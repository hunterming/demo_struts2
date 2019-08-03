<%--
  Created by IntelliJ IDEA.
  User: hunter
  Date: 2018/6/3
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--跳转到add的Action中，并将productname，productprice，productnum获取的值传入--%>
<form method="post" action="${pageContext.servletContext.contextPath}/add.action">
    <table>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="productname"></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="productprice"></td>
        </tr>
        <tr>
            <td>商品数量</td>
            <td><input type="text" name="productnum"></td>
        </tr>
    </table>
    <button type="submit">提交</button>
</form>

</body>
</html>
