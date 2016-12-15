<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>客户列表页面</h1>
<form action="${ pageContext.request.contextPath }/customerServlet" method="post">
<TABLE border="1" width="1000">
  <TR>
	<TD>
		名称:<input type="text" name="name"/><input type="submit" value="查询">
	</TD>
  </TR>
  </TABLE>
</form>
  <TABLE border="1" width="1000">
  <TR>
	<TD>名称</TD>
	<TD>性别</TD>
	<TD>生日</TD>
	<TD>邮箱</TD>
	<TD>电话</TD>
	<TD>爱好</TD>
	<TD>类型</TD>
	<TD>描述</TD>
	<TD>操作</TD>
  </TR>
  <c:forEach items="${ pageBean.list }" var="c">
  <TR>
	<TD>${ c.name }</TD>
	<TD>${ c.gender }</TD>
	<TD>${ c.birthday }</TD>
	<TD>${ c.email }</TD>
	<TD>${ c.cellphone }</TD>
	<TD>${ c.preference }</TD>
	<TD>${ c.type }</TD>
	<TD>${ c.description }</TD>
	<TD><a href="#">修改</a></TD>
  </TR>
  </c:forEach>
  </TABLE>
  <TABLE border="1" width="1000">
  <TR>
	<TD>
		第${ pageBean.currPage }/${pageBean.totalPage }页 &nbsp; &nbsp;
		<a href="${ pageContext.request.contextPath }/customerServlet?currPage=1&name=${param.name}">首页</a> |
		<a href="${ pageContext.request.contextPath }/customerServlet?currPage=${ pageBean.currPage -1}&name=${param.name}">上一页</a> |
		<a href="${ pageContext.request.contextPath }/customerServlet?currPage=${ pageBean.currPage +1}&name=${param.name}">下一页</a> |
		<a href="${ pageContext.request.contextPath }/customerServlet?currPage=${ pageBean.totalPage}&name=${param.name}">尾页</a> 
	</TD>
  </TR>
  </TABLE>
</body>
</html>