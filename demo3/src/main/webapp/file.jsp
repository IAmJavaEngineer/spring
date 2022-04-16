<%--
  Created by IntelliJ IDEA.
  User: 王景辉
  Date: 2022/3/28
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick21" method="post" enctype="multipart/form-data">
        姓名<input type="text" name="username"><br>
        文件<input type="file" name="multipartFile"><br>
        <input type="submit" value="提交"><br>
    </form>

    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
        姓名<input type="text" name="username"><br>
        文件1<input type="file" name="multipartFile"><br>
        文件2<input type="file" name="multipartFile"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
