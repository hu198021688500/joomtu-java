<%@ page language="java" import="java.util.*,java.util.List" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'resultList.jsp' starting page</title>
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
  <s:if test="#request.searchresults.size!=0">
    共搜索到<font color="red"><s:property value="#request.searchresults.size"/></font>记录<br/>
  <s:else>
  no results found.
  </s:else>
  </s:if>
  <s:iterator value="#request.searchresults">
    <s:property value="id"/>,<s:property value="username" escape="false"/> ,<s:property value="password"/>, <s:property value="gender"/><br/>
  </s:iterator>
</body>
</html>
