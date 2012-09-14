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

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<s:url var="loginUrl" action="login" namespace="user" />
	<s:a href="%{loginUrl}">登录</s:a>
	<br />
	<s:form name="register_form" method="post" action="register"
		namespace="/user">
		<s:textfield name="email" label="Login name" />
		<s:password name="password" label="Password" />
		<s:password name="password1" label="Password1" />
		<s:submit value="Register" align="center" />
	</s:form>
</body>
</html>
