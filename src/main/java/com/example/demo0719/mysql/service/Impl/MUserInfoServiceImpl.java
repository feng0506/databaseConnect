package com.example.demo0719.mysql.service.Impl;

import com.example.demo0719.mysql.dao.MUserInfoDaoTest;
import com.example.demo0719.mysql.entity.MUserInfo;
import com.example.demo0719.mysql.service.MUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MUserInfoServiceImpl implements MUserInfoService {

    @Autowired
    private MUserInfoDaoTest mUserInfoDaoTest;

    @Override
    public List<MUserInfo> testUserInfo(){
        return mUserInfoDaoTest.testUserInfo();
    }
}
