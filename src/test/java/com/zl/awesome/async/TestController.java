package com.zl.awesome.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/4/9 13:54
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/async")
    public Map<Object, Object> test() throws InterruptedException {
        System.out.println("接收到请求。。。");
        task();
        Map<Object, Object> map = new HashMap<>();
        System.out.println("请求结束。。。");
        map.put("msg", "操作成功");
        map.put("code", "0");
        return map;
    }

    @Async
    void task() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("线程任务执行结束。。。");
    }
}
