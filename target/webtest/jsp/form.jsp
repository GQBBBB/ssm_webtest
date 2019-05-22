<%--
  Created by IntelliJ IDEA.
  User: guanqb
  Date: 2019-05-11
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <%--link进css需要在springmvc.xml中开启<mvc:default-servlet-handler/>--%>
    <link rel="stylesheet" href="${ctx}/static/css/div.css">
    <title>Title</title>
</head>
<body>
<div>${ctx}</div>
Get
<form action="${ctx}/web/get" method="get">
    <input type="text" name="in">
    <button type="submit">提交</button>
</form>
Post
<form action="${ctx}/web/post" method="post">
    <input type="text" name="in">
    <button type="submit">提交</button>
</form>
Delete
<form action="${ctx}/web/delete" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="text" name="in">
    <button type="submit">提交</button>
</form>

Put
<form action="${ctx}/web/put" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="text" name="age">
    <input type="text" name="name">
    <button type="submit">提交</button>
</form>

Put1
<form action="${ctx}/web/put1" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="text" name="age">
    <input type="text" name="name">
    <button type="submit">提交</button>
</form>

Post1
<form action="${ctx}/web/post1" method="post">
    <input type="text" name="id">
    <input type="text" name="name">
    <%--相同friends 自动填充至Student类的String[] friends;--%>
    <input type="text" name="friends">
    <input type="text" name="friends">
    <button type="submit">提交</button>
</form>

testModelAttribute1
<form action="${ctx}/web/testModelAttribute1" method="post">
    <input type="text" name="id">
    <input type="text" name="name">
    <%--相同friends 自动填充至Student类的String[] friends;--%>
    <input type="text" name="friends">
    <input type="text" name="friends">
    <button type="submit">提交</button>
</form>

date
<form action="${ctx}/web/date" method="post">
    <input type="date" name="date">
    <button type="submit">提交</button>
</form>

dateByPOJO
<form action="${ctx}/web/dateByPOJO" method="post">
    <input type="date" name="date">
    <button type="submit">提交</button>
</form>

file upload
<form action="${ctx}/file/upload" method="post" enctype="multipart/form-data">
    <%--上传多个文件有多个该项,name相同--%>
    <input type="file" name="file">
    <button type="submit">提交</button>
</form>
</body>
</html>
