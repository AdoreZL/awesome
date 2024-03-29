package com.zl.awesome;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.zl.awesome.annotation.autoprimay.SingerService;
import com.zl.awesome.annotation.resouce.X;
import com.zl.awesome.copy.Student;
import com.zl.awesome.copy.Subject;
import com.zl.awesome.modal.vo.UserTest;
import com.zl.awesome.optional.Dog;
import com.zl.awesome.optional.Zoo;
import com.zl.awesome.transbean.Course;
import com.zl.awesome.transbean.StudentDO;
import com.zl.awesome.transbean.StudentDTO;
import com.zl.awesome.util.NameUtil;
import com.zl.awesome.util.UpLoadFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@EnableAutoConfiguration
public class AwesomeApplicationTests {
    @Autowired
    private SingerService singerService;
    @Autowired
     JdbcTemplate jdbcTemplate;

    List<UserTest> list;

    private static final int USER_COUNT = 1000000; // 数量过大可能导致内存溢出，多运行几次

    @Test
    public void testInsert() {
        long start = System.currentTimeMillis();
        list = new ArrayList<>();
        for (int i=1; i< USER_COUNT+1; i++){
            UserTest user = new UserTest();
            user.setId(i);
            user.setName(NameUtil.getRandomName(i));
            user.setGender(((int)(10 * Math.random())) % 2  );
            String phone = getTel();
            user.setPhone(phone);
            list.add(user);
        }

        save(list);
        long end = System.currentTimeMillis();
        System.out.println("批量插入"+USER_COUNT+"条用户数据完毕，总耗时：" + (end - start) + " 毫秒");

    }

    /**
     * 必须要在数据库连接url加上 &rewriteBatchedStatements=true 来开启批处理，否则还是一条一条写入的
     * 检查IP地址
     * @param list
     */
    public void save(List<UserTest> list) {
        final List<UserTest> tempList = list;
        String sql = "insert into user_innodb(id, name, gender, phone) "
                + "values(?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(java.sql.PreparedStatement ps, int i) throws SQLException {
                Integer id = tempList.get(i).getId();
                String name =  tempList.get(i).getName();
                Integer gender = tempList.get(i).getGender();
                String phone = tempList.get(i).getPhone();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, gender);
                ps.setString(4, phone);
            }

            public int getBatchSize() {
                return tempList.size();
            }
        });

    }

    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    private static String[] telFirst="181,185,136,137,138,179,150,151,152,157,158,159,130,131,132,155,156,199,153,189,166".split(",");
    private static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }

    @Autowired
    private X x;
    /**
     * 使用JSONPrase 解析JSON字符串或者Object对象
     * <p>
     * read(String json, String path)//直接使用json字符串匹配
     * <p>
     * eval(Object rootObject, String path) //直接使用 对象匹配
     * <p>
     * <p>
     * {"store":{"bicycle":{"color":"red","price":19.95},"book":[{"author":"Nigel Rees","price":8.95,"category":"reference","title":"Sayings of the Century"},{"author":"Evelyn Waugh","price":12.99,"isbn":"0-553-21311-3","category":"fiction","title":"Sword of Honour"}]}}
     */
    @Test
    public void test5() {
        String jsonStr = "{\n" +
                "    \"store\": {\n" +
                "        \"bicycle\": {\n" +
                "            \"color\": \"red\",\n" +
                "            \"price\": 19.95\n" +
                "        },\n" +
                "        \"book\": [\n" +
                "            {\n" +
                "                \"author\": \"刘慈欣\",\n" +
                "                \"price\": 8.95,\n" +
                "                \"category\": \"科幻\",\n" +
                "                \"title\": \"三体\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"author\": \"itguang\",\n" +
                "                \"price\": 12.99,\n" +
                "                \"c    ategory\": \"编程语言\",\n" +
                "                \"title\": \"go语言实战\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        log.info(jsonObject.toString());
        //得到所有的书
        List<Book> books = (List<Book>) JSONPath.eval(jsonObject, "$.store.book");
        log.info("books={}", books);
        //得到所有的书名
        List<String> titles = (List<String>) JSONPath.eval(jsonObject, "$.store.book.title");
        log.info("titles={}", titles);
        //第一本书title
        String title = (String) JSONPath.read(jsonStr, "$.store.book[0].title");
        log.info("title={}", title);
        //price大于10元的book
        List<Book> list = (List<Book>) JSONPath.read(jsonStr, "$.store.book[price > 10]");
        log.info("price大于10元的book={}",list);
        //price大于10元的title
        List<String> list2 =(List<String>) JSONPath.read(jsonStr, "$.store.book[price > 10].title");
        log.info("price大于10元的title={}",list2);
        //category(类别)为科幻的book
        List<Book> list3 = (List<Book>) JSONPath.read(jsonStr,"$.store.book[category = '科幻']");
        log.info("category(类别)为科幻的book={}",list3);
        //bicycle的所有属性值
        Collection<String> values = (Collection<String>) JSONPath.eval(jsonObject, "$.store.bicycle.*");
        log.info("bicycle的所有属性值={}",values);
        //bicycle的color和price属性值
        List<String> read =(List<String>) JSONPath.read(jsonStr, "$.store.bicycle['color','price']");
        log.info("bicycle的color和price属性值={}",read);
    }

    @Test
    public void test6() {
        System.out.println(singerService.sing());
    }

    @Test
    public void test7() {
        System.out.println(x.getY().getI());
    }




//*************************************************************对象转化开始*****************************************************************
    @Test
    public void test8(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName("磊磊");
        studentDTO.setAge(18);
        studentDTO.setNo("6666");

        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("math");
        subjects.add("english");
        studentDTO.setSubjects(subjects);
        studentDTO.setCourse(new Course("CS-1"));
        studentDTO.setCreateDate("2020-08-08");


        StudentDO studentDO = new StudentDO();
        //Spring的beanUtils(字段名不一致，属性无法复制,,,类型不一致，属性无法复制。但是注意，如果类型为基本类型以及基本类型的包装类，这种可以转化,,,嵌套对象字段，将会与源对象使用同一对象，即使用浅拷贝)
//        BeanUtils.copyProperties(studentDTO,studentDO);

        //Cglib BeanCopier()
//        BeanCopier beanCopier = BeanCopier.create(StudentDTO.class, StudentDO.class, false);
//        beanCopier.copy(studentDTO, studentDO, null);

        //MapStruct 部分类型不一致，可以自动转换，比如
        //基本类型与包装类型
        //基本类型的包装类型与 String
        //深拷贝
//        studentDO= StudentMapper.INSTANCE.dtoToDo(studentDTO);
        System.out.println(studentDO.toString());
    }


    @Test
    public void shallowCopy() {
        Subject subject = new Subject("yuwen");
        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("Lynn");
        studentA.setAge(20);
        Student studentB = (Student) studentA.clone();
        studentB.setName("Lily");
        studentB.setAge(18);
        Subject subjectB = studentB.getSubject();
        subjectB.setName("lishi");
        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());
    }

    //*************************************************************optional开始***************************************************************
    public void testOptional(){
        Zoo zoo = new Zoo();
        Dog dog = zoo.getDog();
        if(dog != null){
            int age = dog.getAge();
            System.out.println(age);
        }
        Optional.of(zoo).map(Zoo::getDog).map(Dog::getAge).ifPresent(System.out::println);
    }

//    @Test
//    public void upload(){
//        UpLoadFileUtil.UploadFileByHttpClient()
//    }
}


