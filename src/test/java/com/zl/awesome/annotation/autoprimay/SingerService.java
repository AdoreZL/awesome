package com.zl.awesome.annotation.autoprimay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author: netposa
 * @Date: 2021/1/22 11:31
 * @Description:
 */
@Component
@Slf4j
public class SingerService {
    @Autowired()
    @Qualifier("metalSinger")
    private Singer singer;

    public String sing(){
        return singer.sing("song lyrics");
    }
}
