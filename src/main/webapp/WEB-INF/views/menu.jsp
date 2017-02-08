<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%--因为多个页面都有以下内容，故把它抽出来，在其它页面中只要include这个jsp就行了，而且修改起来方便，这边一改，其它地方自动就改了 --%>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<!-- struts中的if else标签，当session里没有user时，即没有登录，显示 登录 注册，此处#表示OGNL表达式 -->
				<s:if test="#session.existUser == null">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_loginPage.action">登录</a>|
					</li>
					
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_registerPage.action">注册</a>|
					</li>
				</s:if>
				
				<!-- 用户登录后显示名字，退出及我的订单 -->
				<s:else>
					<!-- 1.通过property标签显示登录用户的名字 -->
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<s:property value="#session.existUser.name" />
					</li>
					
					<!-- 2.显示 我的订单 -->
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="#">我的订单</a>
					</li>
					
					<!-- 3.退出 -->
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath }/user_exit.action">退出</a>|
					</li>
				</s:else>
				
				<li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogout" class="headerLogout">
					<a>[退出]</a>|
				</li>
						<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="./购物车.htm">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${pageContext.request.contextPath }/index.action">首页</a>
						|
					</li>
					<!-- 通过迭代器遍历cList中的所有一级分类 -->
					<s:iterator var="c" value="#session.cList" >
					<li>
						<a href="./蔬菜分类.htm"><s:property value="#c.cname" /></a>
						|
					</li>
					</s:iterator>
					
		</ul>
	</div>