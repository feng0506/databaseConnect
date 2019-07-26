package com.example.demo0719.sqlite.dao;

import com.example.demo0719.sqlite.entity.test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface SqliteDao {
    @Select("SELECT * FROM test")
    List<test> sgetInfo();
}
