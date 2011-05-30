
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.xylon.ioc.IHello"%><html>
<body>
<h2>Hello World!</h2>
<img src="/img/1.jpg" />
<%
	ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(application);
	
	((IHello)applicationContext.getBean("iHello")).sayHi();

%>
</body>
</html>
