<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.phoenix.bo.Student" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
    Student stu=(Student)(request.getAttribute("student"));
%>
<form action="updateStudentServlet" method="post" >

    <input type="hidden" name="roleName" value="教师" />
    <input type="hidden" name="id" value="<%=stu.getId()%>" />
    <p>学号：<input type="text" name="studentId" value="<%=stu.getId() %>" /></p>
    <p>姓名：<input type="text" name="studentName" value="<%=stu.getName()%>" /></p>
    <p>
        性别：
        <% if(stu.getSex().equals("男"))
        {%>
        <input type="radio" name="studentSex" value="男" checked="checked" />男
        <input type="radio" name="studentSex" value="女" />女
        <%}
            else
                {%>
        <input type="radio" name="studentSex" value="nan"  />男
        <input type="radio" name="studentSex" value="nv" checked="checked" />女
                <%}%>
<p>生日日期：<input type="text" name="studentBirthday" value="<%=stu.getBirthday() %>"/></p>
 <p>专业：<input type="text" name="studentSpecialty" value="<%=stu.getSpecialty() %>" readonly="readonly"/></p>
    </p>
    <p>
        <input type="submit" name="保存"/>
        <input type="reset" name="重置"/>
    </p>
</form>
</body>
</html>
