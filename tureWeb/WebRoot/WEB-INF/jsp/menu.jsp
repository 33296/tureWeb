<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<c:if test="${u == null}">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/loginPage.do">登录</a>|</li>
				
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/registPage.do">注册</a>|
				</li>
			</c:if>
			<c:if test="${u != null}">
			
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="#">${u.name}</a>
				|</li>
				
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/findOrderItemByUid.do?uid=${u.uid}&curPage=1">我的订单</a>
				|</li>
				
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a href="${pageContext.request.contextPath }/exit.do">退出</a>|
				</li>
			</c:if>
		
			<li><a href="#">会员中心</a> |</li>
			<li><a href="#">购物指南</a> |</li>
			<li><a href="#">关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${pageContext.request.contextPath }/myCart.do?uid=${u.uid}">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${pageContext.request.contextPath }/index.do">首页</a> |</li>
		<c:forEach items="${cList}" var="c">
			<li><a href="${pageContext.request.contextPath }/findProductByCid.do?cid=${c.cid }&curPage=1">${c.cname}</a> |</li>
		</c:forEach>

	</ul>
</div>