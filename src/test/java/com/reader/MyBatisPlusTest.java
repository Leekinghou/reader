package com.reader;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.reader.Entity.Test;
import com.reader.mapper.TestMapper;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lijinhao
 * @date: 2022/03/07 21:06
 */
//初始化IoC容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MyBatisPlusTest {
    @Resource
    private TestMapper testMapper;

    @org.junit.Test
    public void testInsert(){
        Test test = new Test();
        test.setId(1);
        test.setContent("MyBatis Plus测试");
        testMapper.insert(test);
    }

    @org.junit.Test
    public void testUpdate(){
        Test test = testMapper.selectById(21);
        test.setContent("MyBatis Plus测试1");
        testMapper.updateById(test);

    }

    @org.junit.Test
    public void testDelete(){
        Test test = testMapper.selectById(21);
        testMapper.deleteById(21);
        System.out.println("delete success");
    }

    @org.junit.Test
    public void testSelect(){
        QueryWrapper<Test> queryWrapper = new QueryWrapper<Test>();
//        queryWrapper.eq("id", 22);
        queryWrapper.gt("id", 20);
        List<Test> tests = testMapper.selectList(queryWrapper);
        System.out.println(tests.get(0));
//        for(Test t:tests){
//            System.out.println(t);
//        }
    }
}
