package com.example.demo0719.mysql.dao;

import com.example.demo0719.mysql.entity.MUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MUserInfoDaoTest {
    @Select("SELECT * FROM test.userInfo")
    List<MUserInfo> testUserInfo();
}
