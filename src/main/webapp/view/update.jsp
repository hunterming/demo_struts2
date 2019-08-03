<%--
  Created by IntelliJ IDEA.
  User: hunter
  Date: 2018/6/4
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/update.action?productid=${param.productid}">
    <h4>现在开始修改商品编号为：${param.productid}的商品信息</h4>
    <table>
        <tr>
            <td>商品名</td>
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
    <button type="submit">提交修改</button>


</form>
</body>
</html>
