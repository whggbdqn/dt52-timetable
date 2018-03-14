/**
 * Project Name:antherProject
 * File Name:ExportControllerTest.java
 * Package Name:cn.bdqn.controller
 * Date:2018年3月1日下午5:08:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
//import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Description:   <br/>
 * Date:     2018年3月1日 下午5:08:48 <br/>
 * @author   junwen.bao
 * @version
 * @see
 */
public class ExportControllerTest extends BaseMvcTest{
    
    @Test
    public void testExport() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/export.do");
        //builder.param("", "");
        //builder.accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(builder)
        //响应状态比较
        .andExpect(status().isOk())
        .andDo(print())
        //json格式结果取指定属性值作比较
        //.andExpect(MockMvcResultMatchers.jsonPath("$.status").value(true))
        //.andExpect(content().string(equalTo("hello world!"))) 
        ;
    }
}

