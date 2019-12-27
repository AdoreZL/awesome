package com.zl.awesome.service;

import com.zl.awesome.modal.vo.OptionVo;

import java.util.List;
import java.util.Map;

public interface IOptionService {
    void insertOption(OptionVo optionVo);

    void insertOption(String name, String value);

    List<OptionVo> getOptions();


    /**
     * 保存一组配置
     *
     * @param options
     */
    void saveOptions(Map<String, String> options);

    OptionVo getOptionByName(String name);
}