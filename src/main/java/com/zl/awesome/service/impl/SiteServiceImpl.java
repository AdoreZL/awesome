package com.zl.awesome.service.impl;

import com.github.pagehelper.PageHelper;
import com.zl.awesome.constant.WebConst;
import com.zl.awesome.dao.AttachVoMapper;
import com.zl.awesome.dao.CommentVoMapper;
import com.zl.awesome.dao.ContentVoMapper;
import com.zl.awesome.dao.MetaVoMapper;
import com.zl.awesome.dto.MetaDto;
import com.zl.awesome.dto.Types;
import com.zl.awesome.exception.TipException;
import com.zl.awesome.modal.bo.ArchiveBo;
import com.zl.awesome.modal.bo.BackResponseBo;
import com.zl.awesome.modal.bo.StaticticsBo;
import com.zl.awesome.modal.vo.*;
import com.zl.awesome.service.ISiteService;
import com.zl.awesome.util.DateKit;
import com.zl.awesome.util.MyUtils;
import com.zl.awesome.util.ZipUtils;
import com.zl.awesome.util.backup.Backup;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author tangj
 * @date 2018/1/23 13:18
 */
@Service
public class SiteServiceImpl implements ISiteService {

    @Resource
    private CommentVoMapper commentDao;

    @Resource
    private ContentVoMapper contentDao;

    @Resource
    private AttachVoMapper attachDao;

    @Resource
    private MetaVoMapper metaDao;

    @Override
    public List<CommentVo> recentComments(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        CommentVoExample example = new CommentVoExample();
        example.setOrderByClause("created desc");
        PageHelper.startPage(1, limit);
        List<CommentVo> byPage = commentDao.selectByExampleWithBLOBs(example);
        return byPage;
    }

    @Override
    public List<ContentVo> recentContents(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        ContentVoExample example = new ContentVoExample();
        example.createCriteria().andStatusEqualTo(Types.PUBLISH.getType()).andTypeEqualTo(Types.ARTICLE.getType());
        example.setOrderByClause("created desc");
        PageHelper.startPage(1, limit);
        List<ContentVo> list = contentDao.selectByExample(example);
        return list;
    }

    @Override
    public CommentVo getComment(Integer coid) {
        if (null != coid) {
            return commentDao.selectByPrimaryKey(coid);
        }
        return null;
    }

    @Override
    public BackResponseBo backup(String bk_type, String bk_path, String fmt) throws Exception {
        BackResponseBo backResponseBo = new BackResponseBo();
        if (bk_type.equals("attach")) {
            if (StringUtils.isBlank(bk_path)) {
                throw new TipException("请输入备份文件存储路径");
            }
            if (!(new File(bk_path).isDirectory())) {
                throw new TipException("请输入一个存在的目录");
            }
            String bkAttachDir = MyUtils.getUploadFilePath() + "upload";
            String bkThemesDir = MyUtils.getUploadFilePath() + "templates/themes";
            String fileName = DateKit.dateFormat(new Date(), fmt) + "_" + MyUtils.getRandomNumber(5) + ".zip";

            String attackPath = bk_path + "/" + "attachs_" + fileName;
            String themesPath = bk_path + "/" + "themes_" + fileName;

            ZipUtils.zipFolder(bkAttachDir, attackPath);
            ZipUtils.zipFolder(bkThemesDir, themesPath);

            backResponseBo.setAttachPath(attackPath);
            backResponseBo.setThemePath(themesPath);
        }
        if (bk_type.equals("db")) {
            String bkAttachDir = MyUtils.getUploadFilePath() + "upload/";
            if (!(new File(bkAttachDir)).isDirectory()) {
                File file = new File(bkAttachDir);
                if (!file.exists()) {
                    file.mkdir();
                }
            }
            String sqlFileName = "tale_" + DateKit.dateFormat(new Date(), fmt) + "_" + MyUtils.getRandomNumber(5) + ".sql";
            String zipFile = sqlFileName.replace(".sql", ".zip");

            Backup backup = new Backup(MyUtils.getNewDataSource().getConnection());
            String sqlContent = backup.execute();
            File sqlFile = new File(bkAttachDir + sqlFileName);
            write(sqlContent, sqlFile, Charset.forName("UTF-8"));

            String zip = bkAttachDir + zipFile;
            ZipUtils.zipFile(sqlFile.getPath(), zip);

            Thread.sleep(500);

            if (!sqlFile.exists()) {
                throw new TipException("数据库备份失败");
            }
            sqlFile.delete();
            backResponseBo.setSqlPath(zipFile);

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    new File(zip).delete();
                }
            }, 10 * 1000);
        }
        return backResponseBo;
    }

    @Override
    public StaticticsBo getStatistics() {
        StaticticsBo staticticsBo = new StaticticsBo();

        ContentVoExample contentVoExample = new ContentVoExample();
        contentVoExample.createCriteria().andTypeEqualTo(Types.ARTICLE.getType()).andStatusEqualTo(Types.PUBLISH.getType());

        Long articles = contentDao.countByExample(contentVoExample);
        Long comments = commentDao.countByExample(new CommentVoExample());
        Long attachs = attachDao.countByExample(new AttachVoExample());

        MetaVoExample metaVoExample = new MetaVoExample();
        metaVoExample.createCriteria().andTypeEqualTo(Types.LINK.getType());
        Long links = metaDao.countByExample(metaVoExample);

        staticticsBo.setArticles(articles);
        staticticsBo.setComments(comments);
        staticticsBo.setAttachs(attachs);
        staticticsBo.setLinks(links);
        return staticticsBo;
    }

    @Override
    public List<ArchiveBo> getArchives() {
        List<ArchiveBo> archiveBoList = contentDao.findReturnArchiveBo();
        if (null != archiveBoList) {
            archiveBoList.forEach(archive -> {
                ContentVoExample example = new ContentVoExample();
                ContentVoExample.Criteria criteria = example.createCriteria().andTypeEqualTo(Types.ARTICLE.getType()).andStatusEqualTo(Types.PUBLISH.getType());
                example.setOrderByClause("created desc");
                String date = archive.getDate();
                Date sd = DateKit.dateFormat(date, "yyyy年MM月");
                int start = DateKit.getUnixTimeByDate(sd);
                int end = DateKit.getUnixTimeByDate(DateKit.dateAdd(DateKit.INTERVAL_MONTH, sd, 1)) - 1;
                criteria.andCreatedGreaterThan(start);
                criteria.andCreatedLessThan(end);
                List<ContentVo> contentss = contentDao.selectByExample(example);
                archive.setArticles(contentss);
            });
        }
        return archiveBoList;
    }

    @Override
    public List<MetaDto> metas(String type, String orderBy, int limit) {
        List<MetaDto> retList = null;
        if (StringUtils.isNotBlank(type)) {
            if (StringUtils.isBlank(orderBy)) {
                orderBy = "count desc, a.mid desc";
            }
            if (limit < 1 || limit > WebConst.MAX_POSTS) {
                limit = 10;
            }
            Map<String, Object> paraMap = new HashMap<>();
            paraMap.put("type", type);
            paraMap.put("order", orderBy);
            paraMap.put("limit", limit);
            retList = metaDao.selectFromSql(paraMap);
        }
        return retList;
    }

    private void write(String data, File file, Charset charset) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(data.getBytes(charset));
        } catch (IOException var8) {
            throw new IllegalStateException(var8);
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException var2) {
                    var2.printStackTrace();
                }
            }
        }

    }
}
