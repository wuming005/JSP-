<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <form action="loginServlet">
    <input type="hidden" name="login" value="login"/>
    <%=request.getAttribute("opTip") %>
    <table>
      <tr>
        <th>用户ID</th>
        <td><input type="text" name="roleId"/></td>
      </tr>
      <tr>
        <th>用户名</th>
        <td><input type="text" name="username"/></td>
      </tr>
      <tr>
        <th>密码</th>
        <td><input type="password" name="password"/></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="提交"/>
          <input type="reset" value="重置"/>
        </td>
      </tr>
    </table>
  </form>

  </body>
</html>