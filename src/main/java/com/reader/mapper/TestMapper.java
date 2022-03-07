package com.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.reader.Entity.Test;

/**
 * @author: lijinhao
 * @date: 2022/03/07 16:02
 */

public interface TestMapper extends BaseMapper<Test> {
    void insertSample();
}
