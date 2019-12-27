package com.zl.awesome.service.impl;

import com.zl.awesome.dao.RelationshipVoMapper;
import com.zl.awesome.modal.vo.RelationshipVoExample;
import com.zl.awesome.modal.vo.RelationshipVoKey;
import com.zl.awesome.service.IRelationshipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangj
 * @date 2018/1/24 21:33
 */
@Service
public class RelationshipServiceImpl implements IRelationshipService {

    @Resource
    private RelationshipVoMapper relationshipVoDao;

    @Override
    public void deleteById(Integer cid, Integer mid) {
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.Criteria criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        relationshipVoDao.deleteByExample(relationshipVoExample);
    }

    @Override
    public Long countById(Integer cid, Integer mid) {
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.Criteria criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        long num = relationshipVoDao.countByExample(relationshipVoExample);
        return num;
    }

    @Override
    public void insertVo(RelationshipVoKey relationshipVoKey) {
        relationshipVoDao.insert(relationshipVoKey);
    }

    @Override
    public List<RelationshipVoKey> getRelationshipById(Integer cid, Integer mid) {
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.Criteria criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        return relationshipVoDao.selectByExample(relationshipVoExample);
    }
}
