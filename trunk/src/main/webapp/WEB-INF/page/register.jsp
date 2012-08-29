<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
  </head>
  
  <body>
  	<s:form action="register" namespace="/member" method="post">
  		用户名:<s:textfield name="user.username"/><br/>
  		密码:<s:textfield name="user.password"/><br/>
  		性别:<s:radio list="#{'MAN':'男','WOMAN':'女'}" listKey="key" listValue="value" name="user.gender"/>
  		<input type="submit" value="保存"/>
  	</s:form>
  </body>
</html>
