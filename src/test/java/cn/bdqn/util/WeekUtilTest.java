/**
 * Project Name:antherProject
 * File Name:WeekUtilTest.java
 * Package Name:cn.bdqn.util
 * Date:2018年3月2日下午7:51:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.util;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Description: <br/>
 * Date: 2018年3月2日 下午7:51:44 <br/>
 * 
 * @author junwen.bao
 * @version
 * @see
 */
public class WeekUtilTest {

    @Test
    public void testGetAllDateOfWeek() {
        Calendar cal = Calendar.getInstance();
        // 2018/03/02
        cal.set(2018, 3 - 1, 2);

        Date[] result = WeekUtil.getAllDateOfWeek(cal.getTime());
        Assert.assertEquals(7, result.length);

        cal.setTime(result[0]);
        Assert.assertEquals(26, cal.get(Calendar.DAY_OF_MONTH));
        cal.setTime(result[6]);
        Assert.assertEquals(4, cal.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testAddDate() {
        Calendar cal = Calendar.getInstance();
        // 2018/03/02
        cal.set(2018, 3 - 1, 2);

        Date newDate = WeekUtil.addDate(cal.getTime(), 1);

        cal.setTime(newDate);
        Assert.assertEquals(3, cal.get(Calendar.DAY_OF_MONTH));
    }

}
