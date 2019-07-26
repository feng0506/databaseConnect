package com.example.demo0719.controller;

import com.example.demo0719.mysql.entity.MUserInfo;
import com.example.demo0719.mysql.service.MUserInfoService;
import com.example.demo0719.sqlite.dao.SqliteDao;
import com.example.demo0719.sqlite.entity.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping()
public class MysqlTest {
    @Autowired
    private MUserInfoService mUserInfoService;

    @Autowired
    private SqliteDao sdao;
//    @ResponseBody
//    @RequestMapping("/getMuserInfo")
//    public List<MUserInfo> getMuserInfo(){
//        return MUserInfoService.getMuserInfo();
//    }

    @ResponseBody
    @RequestMapping("/getMuserInfoTest")
    public List<MUserInfo> getMuserInfoTest(){
        return mUserInfoService.testUserInfo();
    }

    @ResponseBody
    @RequestMapping("/sqlite")
    public List<test> sqlite(){
        return sdao.sgetInfo();
    }


}
