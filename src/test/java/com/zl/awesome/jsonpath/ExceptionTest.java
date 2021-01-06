package com.zl.awesome.jsonpath;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.junit.Test;

/**
 * @author: netposa
 * @Date: 2020/12/8 09:42
 * @Description:
 */
public class ExceptionTest {
    @Test
    public void test() {
        String json = "[\n" +
                "   {\n" +
                "      \"name\" : \"john\",\n" +
                "      \"gender\" : \"male\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"name\" : \"ben\"\n" +
                "   }\n" +
                "]";
        Configuration conf = Configuration.defaultConfiguration();

        //Works fine
        String gender0 = JsonPath.using(conf).parse(json).read("$[0]['gender']");
        //PathNotFoundException thrown
//        String gender1 = JsonPath.using(conf).parse(json).read("$[1]['gender']");

        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);

        //Works fine
        String gender2 = JsonPath.using(conf2).parse(json).read("$[0]['gender']");
        //Works fine (null is returned)
        String gender3 = JsonPath.using(conf2).parse(json).read("$[1]['gender']");
    }
}
