<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
	var total = 0.0;
	function choo(pid){
		t = document.getElementById("total"+pid);
		c = document.getElementById("choose"+pid);
		if(c.checked == true){
			total += parseFloat(t.value);
			
		}else{	
			total -= parseFloat(t.value);
		}
		document.getElementById("effectivePoint").innerHTML=total;
		document.getElementById("effectivePrice").innerHTML="￥"+total+"元";
	}
	
	function submit(){
	
		var choose = document.getElementsByName("choose");
		
		var chooses = "";
		
		for(var i=0; i<choose.length; i++){
			if(choose[i].checked==true){
				chooses+=choose[i].value+";";
			}
		}
		
		window.location.href="${pageContext.request.contextPath}/saveOrder.do?chooses="+chooses+"&total="+total;
	}
	
	function allcheck(){
		var allCheck = document.getElementById("allCheck").checked;
		var chooses = document.getElementsByName("choose");
		var totals = document.getElementsByName("total");
		if(allCheck){
			for(var i=0; i<choose.length; i++){
				chooses[i].checked=true;
			}
			for(var j=0; j<totals.length; j++){
				total += parseFloat(totals[j].value);
				
			}
		}else{
			for(var i=0; i<choose.length; i++){
				chooses[i].checked=false;
			}
			for(var j=0; j<totals.length; j++){
			total -= parseFloat(totals[j].value);
				
			}
		}
	
		document.getElementById("effectivePoint").innerHTML=total;
		document.getElementById("effectivePrice").innerHTML="￥"+total+"元";
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>购物车</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	</div>
	
	<%@ include file="menu.jsp" %>
	
</div>	

	<div class="container cart">
		<c:if test="${!empty cartList}">
		
		<div class="span24">
			<div class="step step1">
				购物车信息
			</div>
				<table>
					<tbody>
					<tr>
						
						<th>
							<input type="checkbox" id="allCheck" onclick="allcheck()"/>
							全选
						</th>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
						<c:forEach items="${cartList }" var="cart">	
						<tr>
							<td>
								<input type="checkbox" id="choose${cart.pid}" name="choose" value="${cart.pid}" onclick="choo('${cart.pid}')"/>
							</td>
							<td width="60">
								<img src="${pageContext.request.contextPath}/${cart.product.image }" />
							</td>
							<td>
								<a target="_blank">${cart.product.pname}</a>
							</td>
							<td>
								￥${cart.product.shop_price}
							</td>
							<td class="quantity" width="60">
								${cart.count}
							</td>
							<td width="140">
								<input type="hidden" class="subtotal" name="total" id="total${cart.pid}" value="${cart.product.shop_price*cart.count}"/>￥${cart.product.shop_price*cart.count }
								<%-- <span class="subtotal" id="total">￥${cart.product.shop_price*cart.count }</span> --%>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/removeCart.do?pid=${cart.pid}&uid=${cart.uid}" class="delete">删除</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
							<em>
								<!-- 登录后确认是否享有优惠 -->
							</em>
					赠送积分: <em id="effectivePoint"></em>
					
					商品金额: <strong id="effectivePrice">￥0元</strong>
				</div>
				<div class="bottom">
					<a href="${ pageContext.request.contextPath}/clearCart.do" id="clear" class="clear">清空购物车</a>
					 <a href="#" id="submit" class="submit" onclick="submit()">生成订单</a> 
					<!-- <a>
						<input type="submit" id="submit" class="submit" value="提交订单"/>
					</a> -->
				</div>
				
		</div>
	
		</c:if>
		<c:if test="${empty cartList}">
			<div class="span24">
				<div class="step step1">
					<span><h2>亲!您还没有购物!请先去购物!</h2></span>
				</div>
			</div>
		</c:if>
	</div>
	
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势"/>
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>