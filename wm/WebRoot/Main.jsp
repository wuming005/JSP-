<%@ page import="java.util.List" %>
<%@ page import="com.phoenix.bo.Student" %>
<%@ page import="com.phoenix.bo.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if(request.getAttribute("tip")!=null){
    %>
<div style="color: red;"><%=request.getAttribute("tip")%></div>
<%
}
%>

<p>你的名字:<%=session.getAttribute("username") %>&nbsp;&nbsp;&nbsp;&nbsp;
    你的身份:<%=session.getAttribute("roleName") %></p>

<a href="updatePersonal.jsp" > 修改本人信息</a>
<%
    if(session.getAttribute("roleName").equals("老师"))
    {
%>
<a href="addStudent.jsp" >添加学生</a>
<%
    List list =(List)request.getAttribute("list");
%>
<table border="1" cellspacing="0">
    <caption>学生信息表</caption>
    <tr>
        <th>学号</th><th>姓名</th><th>性别</th><th>生日日期</th><th>专业</th><th>操作</th>
    <%
        for(int i=0;i<list.size();i++){
            Student stu = (Student) list.get(i);
    %>
    <tr>
        <td><%=stu.getId() %></td>
        <td><%=stu.getName() %></td>
        <td><%=stu.getSex() %></td>
        <td><%=stu.getBirthday() %></td>
        <td><%=stu.getSpecialty() %></td>
    <td>
        <a href="updateStudentServlet?studentId=<%=stu.getId()%>" >修改</a>
        <a href="deleteStudentServlet?studentId=<%=stu.getId()%>" >删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

<form action="queryStudentServlet">
    输入查询条件：
    <input type="text" name="value" value=""><br>
    选择查询方式
    <select name="col">
        <option value=""> 请选择 </option>
        <option value="studentId"> 学号 </option>
        <option value="name"> 姓名 </option>
        <option value="sex"> 性别 </option>
        <option value="birthday">日期 </option>
        <option value="specialty"> 专业 </option>
    </select><br>
    <input type="submit" name="submit" value="查询">
    <input type="Reset" name="reset" value="取消">
</form>
<% } %>


<% if(session.getAttribute("roleName").equals("管理"))
{
%>
    <a href="addTeacher.jsp" >添加老师</a>
<%
    List list =(List)request.getAttribute("list");
%>
<table border="1" cellspacing="0">
    <caption>教师信息表</caption>
    <tr>
        <th>工号</th><th>姓名</th><th>操作</th>
            <%
        for(int i=0;i<list.size();i++){
            Teacher teacher = (Teacher) list.get(i);
    %>
    <tr>
        <td><%=teacher.getId() %></td>
        <td><%=teacher.getName() %></td>
        <td>
            <a href="updateTeacherServlet?teacherId=<%=teacher.getId()%>" >修改</a>
            <a href="deleteTeacherServlet?teacherId=<%=teacher.getId()%>" >删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

<form action="queryTeacherServlet">
    输入查询条件：
    <input type="text" name="value" value=""><br>
    选择查询方式
    <select name="col">
        <option value=""> 请选择 </option>
        <option value="teacherId"> 工号 </option>
        <option value="name"> 姓名 </option>
    </select><br>
    <input type="submit" name="submit" value="查询">
    <input type="Reset" name="reset" value="取消">
</form>
<% } %>
</body>
</html>
