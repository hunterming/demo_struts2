<%--
  Created by IntelliJ IDEA.
  User: hunter
  Date: 2018/6/3
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--这里是声明使用的标签是Struts2标签--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--这是增加了一个跳转到添加商品页面的超链接--%>
<a href="${pageContext.servletContext.contextPath}/view/add.jsp">添加</a>
<table border="2px" width="500px">
    <tr>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品数量</td>
        <td>操作</td>
    </tr>
    <%--这里用的是s:iterator标签，其中，value表示的是被迭代的集合,从后台返回的结果集；var表示的是页面用于迭代使用的代替名称，就相当于你给返回的结果集起个别名
    ;statue是迭代元素的索引--%>
    <s:iterator value="%{list_product}" var="p" status="status">
    <%--这里就是对返回的结果集以table的表现方式进行遍历--%>
    <tr>
        <td><s:property value="%{#p.productid}"/> </td>
        <td><s:property value="%{#p.productname}"/></td>
        <td><s:property value="%{#p.productprice}"/></td>
        <td><s:property value="%{#p.productnum}"/></td>
        <td>
            <%--这里对修改和删除设置了超链接，分别跳转到修改页面和delete的Action，并且将productid的值传到下一个界面/Action。--%>
            <a href="${pageContext.servletContext.contextPath}/view/update.jsp?productid=${p.productid}">修改</a>&nbsp;
            <a href="${pageContext.servletContext.contextPath}/delete.action?productid=${p.productid}">删除</a>
        </td>
    </tr>
    </s:iterator>
</table>

</body>
</html>
