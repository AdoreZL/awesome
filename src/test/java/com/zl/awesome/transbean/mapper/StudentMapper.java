//package com.zl.awesome.transbean.mapper;
//
//import com.zl.awesome.transbean.StudentDO;
//import com.zl.awesome.transbean.StudentDTO;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
///**
// * @author: netposa
// * @Date: 2021/1/24 17:14
// * @Description:
// */
//@Mapper
//public interface StudentMapper {
//    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
//    @Mapping(source = "no", target = "number")
//    @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd")
//    StudentDO dtoToDo(StudentDTO studentDTO);
//}
