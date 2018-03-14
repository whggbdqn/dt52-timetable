/**
 * Project Name:antherProject
 * File Name:ExportControllerTest.java
 * Package Name:cn.bdqn.controller
 * Date:2018年3月1日下午5:08:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.controller;

import org.junit.Before;    
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Description: <br/>
 * Date: 2018年3月1日 下午5:08:48 <br/>
 * 
 * @author junwen.bao
 * @version
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext-*.xml", "classpath:springmvc-servlet.xml" })
@WebAppConfiguration
public abstract class BaseMvcTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc = null;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

}
