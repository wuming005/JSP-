<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <form action="addStudentServlet">
    <input type="hidden" name="roleName" value="教师"/>
    <p>学号：<input type="text" name="studentId"/></p>
    <p>姓名：<input type="text" name="studentName"/></p>
    <p>
        性别：
        <input type="radio" name="studentSex" value="男" checked="checked"/>男
        <input type="radio" name="studentSex" value="女"/>女
    </p>
    <p>日期：<input type="text" name="studentBirthday"/></p>
     <p>专业：<input type="text" name="studentSpecialty"/></p>
    <p>
        <input type="submit" name="保存"/>
        <input type="reset" name="重置"/>
    </p>
</form>
</body>
</html>

