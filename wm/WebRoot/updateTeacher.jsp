<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.phoenix.bo.Teacher" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateTeacher.jsp' starting page</title>
    
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
    Teacher tea=(Teacher)(request.getAttribute("teacher"));
%>
  <form action="updateTeacherServlet" method="post" >

    <input type="hidden" name="id" value="<%=tea.getId()%>" />
    <p>工号：<input type="text" name="teacherId" value="<%=tea.getId() %>" /></p>
    <p>姓名：<input type="text" name="teacherName" value="<%=tea.getName()%>" /></p>
    <p>
        <input type="submit" name="保存"/>
        <input type="reset" name="重置"/>
    </p>
</form>
</body>
</html>

