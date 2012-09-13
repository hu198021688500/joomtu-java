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

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	-->

</head>

<body>
	This is my JSP page.
	<br>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<br />
	<br />
	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage/>
		</div>
	</s:if>
	<br />
	<br />
	<s:actionerror />
	<s:fielderror />
	<br />
	<br />
	<s:form name="login_form" method="post" action="login" namespace="/user" >
		<s:textfield name="email" label="Login name" />
		<s:password name="password" label="Password" />
		<s:submit value="Login" align="center" />
	</s:form>
</body>
</html>