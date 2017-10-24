<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table width="100%">
	<tr>
		<td>图片</td>
		<td>商品</td>
		<td>数量</td>
		<td>价格</td>
	</tr>
	<c:forEach items="${orderItemList}" var="orderItem">
	<tr>
		<td><img width="40" height="45" src="${pageContext.request.contextPath }/${orderItem.product.image}"></td>
		<td>${orderItem.product.pname}</td>
		<td>${orderItem.count}</td>
		<td>${orderItem.subtotal}</td>
	</tr>
	</c:forEach>
</table>