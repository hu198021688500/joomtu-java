<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>JSP获取系统信息</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style>
		table tr{width:1000px;}
		table td{font-size:10.5pt;}
		.width100{width:100px;}
		.width300{width:300px;}
		.width600{width:600px;}
		.table-head{background-color:#CCCCCC;}
		.align-left{text-align:left;}
		</style>
	</head>
	<body>
		<table border="0" cellspacing="1" cellpadding="2">
			<tr class="table-head">
				<th class="width100">&nbsp;</th>
				<th class="width300">属性名</th>
				<th class="width600">属性值</th>
			</tr>
			<%
				int iCount = 1;
				Enumeration<Object> enu = System.getProperties().keys();
				while (enu.hasMoreElements()) {
					String sKey = (String) enu.nextElement();
					String sVal = System.getProperty(sKey);
			%>
			<tr>
				<td class="align-left"><%=iCount++%>&nbsp;</td>
				<td><%=sKey%></td>
				<td><%=sVal%></td>
			</tr>
			<% } %>
			<tr>
				<td class="align-left"><%=iCount++%>&nbsp;</td>
				<td>Default Locale</td>
				<td><%=Locale.getDefault()%></td>
			</tr>
			<%
				Runtime runtimeInfo = Runtime.getRuntime();
				long unitMb = 1204 * 1024L;
			%>
			<tr>
				<td class="align-left"><%=iCount++%>&nbsp;</td>
				<td>TotalMemory</td>
				<td><%=runtimeInfo.totalMemory() / unitMb%>(M)</td>
			</tr>
			<tr>
				<td class="align-left"><%=iCount++%>&nbsp;</td>
				<td>FreeMemory</td>
				<td><%=runtimeInfo.freeMemory() / unitMb%>(M)</td>
			</tr>
		</table>
	</body>
</html>
