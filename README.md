# reader

## MyBatis-Plus
(简称 MP）是一个**MyBatis**的增强工具
自动实现Mapper CRUD操作，极致提高数据库开发效率
MP在MyBatis的基础上只做增强不做改变


## MyBatis-Plus使用步骤

MP整合三部曲：
1. pom.xml引入入mybatis-plus依赖
   ```xml
        <!-- MyBatis-Plus依赖 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus</artifactId>
            <version>3.5.1</version>
        </dependency>
    ```
2. Spring XML更改配置SqlSessionFactory实现类
   ```xml
        <!-- 3. SqlSessionFactoryBean用于根据配置信息创建SqlSessionFactory,不再需要我们自己编码创建 -->
        <!-- 原生Mybaits与Spring整合 -->
        <!--    <bean id="sessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">-->
        <bean id="sessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
            <property name="dataSource" ref="dataSource"/>
            <property name="mapperLocations" value="classpath:mappers/*.xml"/>
            <!-- 5.MyBatis配置文件地址 -->
            <property name="configLocation" value="classpath:mybatis-config.xml"/>
        </bean>
    ```
3. mybatis-config.xml增加MP分页插件
    ```xml
        <!-- 配置MyBatis-Plus分页插件 -->
        <plugins>
            <plugin interceptor="com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor"></plugin>
        </plugins>
    ```

## MP使用三部曲
1. 创建实体类，@TableName/@TableId/@TableField实现映射  
   1. @TableName - 本类与表名映射  
   2. @TableId - 说明对应属性是表的主键  
   3. @TableField - 设置属性与列名的对应关系  
      ![](https://gitee.com/leekinghou/image/raw/master/img/20220308230214.png)
2. 创建Mapper接口继承BaseMapper，创建Mapper XML  
3. 开发时注入Mapper对象，通过内置API实现CRUD操作 

## 项目功能
1. 显示图书类别
2. 实现图书分页查询
3. 实现图书列表分页查询
4. 实现图书多条件动态查询
5. 图书详情页-读取图书信息
6. 图书详情页-显示评论列表
7. Kaptcha验证码的配置与使用、比对
8. 实现会员注册、登录功能
     
会员交互功能：
9. 获取、更新会员阅读状态
10. 实现写短评功能
11. 实现会员点赞功能
12. Spring-Task定时任务(Spring 3.0+、周期性后台自动执行任务、利用Cron表达式实现灵活的定时处理)
    ![](https://gitee.com/leekinghou/image/raw/master/img/20220523165125.png)
13. 


