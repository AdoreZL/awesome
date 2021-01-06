package com.zl.awesome.serialization;

import java.io.IOException;

/**
 * @author: netposa
 * @Date: 2020/12/6 16:54
 * @Description:
 */
public interface ISerializer {
     <T> byte[] serialize(T obj) throws IOException;

     <T> T deserialize(byte[] data,Class<T> clazz);
}
