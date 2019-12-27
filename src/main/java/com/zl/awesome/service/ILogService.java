package com.zl.awesome.service;

import com.zl.awesome.modal.vo.LogVo;

import java.util.List;

/**
 * @author tangj
 * @date 2018/1/21 20:50
 */
public interface ILogService {
    /**
     * 保存操作日志
     *
     * @param logVo
     */
    void insertLog(LogVo logVo);

    /**
     *  保存
     * @param action
     * @param data
     * @param ip
     * @param authorId
     */
    void insertLog(String action, String data, String ip, Integer authorId);

    /**
     * 获取日志分页
     * @param page 当前页
     * @param limit 每页条数
     * @return 日志
     */
    List<LogVo> getLogs(int page, int limit);
}
