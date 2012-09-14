<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<s:url var="registerUrl" action="register" namespace="user" />
	<s:a href="%{registerUrl}">注册</s:a>
	<br />
	<s:form name="login_form" method="post" action="login"
		namespace="/user" validate="true">
		<s:textfield name="email" label="Login name" />
		<s:password name="password" label="Password" />
		<s:hidden name="returnUrl" value="%{#session.return_url}"></s:hidden>
		<s:submit value="Login" align="center" />
		<s:url var="findPassUrl" action="getpass" namespace="user" />
		<s:a href="%{findPassUrl}">找回密码</s:a>
	</s:form>
</body>
</html>