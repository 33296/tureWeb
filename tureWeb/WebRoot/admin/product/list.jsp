<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="style/sheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/addProduct.do";
			}
			
			function queryCategorySecondByCid(cid){
				//window.location.href="${pageContext.request.contextPath}/queryCategorySecondByCid.do?cid="+cid.value
				//alert(cid.value);
		        $.ajax({  
			       	data:{"cid":cid.value},  
			        type:"GET",  
			        dataType: "json",  
			        url:"../${pageContext.request.contextPath}/queryCategorySecondByCid.do",  
			        success:function(csList){
			        	var test;
			        	
			        	for ( var cs in csList) {
			        		var csid = csList[cs].csid;
			        		var csname = csList[cs].csname;
			        		test+="<option value="+csid+" id=option"+csid+">"+csname+"</option>";
						}
						$("#csid").css("display","block");
			        	$("#csid").html(test);
			        },
			        error:function(csList){
			        	alert(csList.csname+"cuo");
			        }
		        });  
			}
			
			function queryProductByCsid(csid){
				alert(csid.value);
				window.location.href="${pageContext.request.contextPath}/queryProductByCsid.do?csid="+csid.value
			}
		</script>
	</HEAD>
	<body>
		<br>
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<select id="cid" onchange="queryCategorySecondByCid(this)" >
								<option>查询全部</option>
								<c:forEach items="${categoryList}" var="c">
									<option value="${c.cid}">${c.cname}</option>
								</c:forEach>
							</select>
							
							<select id="csid" onchange="queryProductByCsid(this)" style="display: none;">
								<option value="${cs.csid}" id="option${cs.csid}"></option>
							<select>
						
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">
								&#28155;&#21152;
							</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										序号
									</td>
									<td align="center" width="17%">
										商品图片
									</td>
									<td align="center" width="17%">
										商品名称
									</td>
									<td align="center" width="17%">
										商品价格
									</td>
									<td align="center" width="17%">
										是否热门
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
									<c:forEach items="${productList}" var="p">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">${p.pid}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<img width="40" height="45" src="${pageContext.request.contextPath }/${p.image}">
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">${p.pname}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">${p.shop_price}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${p.is_hot==1}">
													是
												</c:if>
												<c:if test="${p.is_hot!=1}">
													否
												</c:if>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath }/findAdminProductByPid.do?pid=${p.pid}">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath }/deleteProduct.do?pid=${p.pid}">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
					<tr align="center">
						<td colspan="7">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 
							<s:if test="pageBean.page != 1">
								<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?page=1">首页</a>|
								<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
								<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a href="${pageContext.request.contextPath }/adminProduct_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
						</td>
					</tr>
				</TBODY>
			</table>
	</body>
</HTML>

