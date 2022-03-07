package com.reader.service;

import com.reader.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: lijinhao
 * @date: 2022/03/07 16:10
 */

@Service
public class TestService {
    // 用于注入对象
    @Resource
    private TestMapper testMapper;

    @Transactional()
    public void batchImport(){
        for (int i = 0; i < 5; i++) {
            testMapper.insertSample();
        }
    }
}
