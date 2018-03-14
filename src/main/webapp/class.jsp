<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<!--班级表-->
 <table class="providerTable" cellpadding="0" cellspacing="0" border=1>
    <tr class="firstTr">
      <th width="80px">班级名称</th>
      <th width="100px">班级学科</th>
      <th width="100px">班级老师</th>
      <th width="100px">班级教员</th>
      <th width="100px">班级人数</th>
    </tr>
      <c:forEach items="${allClass}" var="cla" >
    <tr>
      <td>${cla.className }</td>
      <td>${cla.major }</td>
      <td>${cla.teacherId }</td>
      <td>${cla.instructorId }</td>
      <td>${cla.stuNum}</td>
    </tr>
    </c:forEach>
  </table>
  <!--一周课表-->
  <table class="providerTable" cellpadding="0" cellspacing="0" border=1>
    <tr class="firstTr">
   	  <th width="3%">星期</th>
      <th width="10%">一机房</th>
      <th width="10%">二机房</th>
      <th width="10%">三机房</th>
      <th width="10%">四机房</th>
      <th width="10%">五机房</th>
      <th width="10%">六机房</th>
      <th width="10%">七机房</th>
      <th width="10%">八机房</th>
    </tr>
	<br /><hr />
      <c:forEach items="${resultclass }" var="cla2" varStatus="status">
      	<c:if test="${status.count eq 1||(status.count-1)% 8 eq 0}">
    <tr>
    	<td>
    	<c:if test="${status.count eq 1}">周一</c:if> 
    	<c:if test="${status.count eq 9}">周二</c:if> 
    	<c:if test="${status.count eq 17}">周三</c:if> 
    	<c:if test="${status.count eq 25}">周四</c:if> 
    	<c:if test="${status.count eq 33}">周五</c:if> 
    	<c:if test="${status.count eq 41}">周六</c:if> 
    	<c:if test="${status.count eq 49}">周日</c:if> 
    	<%-- ${status.count} --%> </td>
    	</c:if>
      	<td>
      	<c:if test="${cla2==null}">空闲</c:if>
      	${cla2.className }<%-- ${cla2.major } --%>
      	${cla2.teacherId }${cla2.instructorId }
      	</td>
    	<c:if test="${status.count% 8 eq 0||status.count eq 8}">
    </tr>
   		 </c:if>
    </c:forEach>
  </table> 
<!--一周课表2-->
<%--   <table class="providerTable" cellpadding="0" cellspacing="0" border=1>
    <tr class="firstTr">
   	  <th width="3%">星期</th>
      <th width="10%">一机房</th>
      <th width="10%">二机房</th>
      <th width="10%">三机房</th>
      <th width="10%">四机房</th>
      <th width="10%">五机房</th>
      <th width="10%">六机房</th>
      <th width="10%">七机房</th>
      <th width="10%">八机房</th>
    </tr>
	<br /><hr />
      <c:forEach items="${resultclass2 }" var="cla3" varStatus="status2">
      	<c:if test="${status2.count eq 1||(status2.count-1)% 8 eq 0}">
    <tr>
    	<td>
    	<c:if test="${status2.count eq 1}">周一</c:if> 
    	<c:if test="${status2.count eq 9}">周二</c:if> 
    	<c:if test="${status2.count eq 17}">周三</c:if> 
    	<c:if test="${status2.count eq 25}">周四</c:if> 
    	<c:if test="${status2.count eq 33}">周五</c:if> 
    	<c:if test="${status2.count eq 41}">周六</c:if> 
    	<c:if test="${status2.count eq 49}">周日</c:if> 
    	${status.count} </td>
    	</c:if>
      	<td>
      	<c:if test="${cla3==null}">空闲</c:if>
      	${cla3.className }${cla2.major }
      	${cla3.classTeacher }${cla3.instructor }${cla3.time}
      	</td>
    	<c:if test="${status2.count% 8 eq 0||status2.count eq 8}">
    </tr>
   		 </c:if>
    </c:forEach>
  </table>  --%>



<%--   <table class="providerTable" cellpadding="0" cellspacing="0">
    <tr class="firstTr">
      <th width="20%">班级名称</th>
      <th width="20%">班级人数</th>
      <th width="20%">班级老师</th>
      <th width="10%">班级大小</th>
      <th width="20%">操作</th>
    </tr>
      <c:forEach items="${allClass }" var="cla">
    <tr>
      <td>${cla.className }</td>
      <td>${cla.major }</td>
      <td>${cla.classTeacher }</td>
      <td>${cla.instructor }</td>
      <td>操作</td>
    </tr>
    </c:forEach>
  </table> --%>
</body>
</html>