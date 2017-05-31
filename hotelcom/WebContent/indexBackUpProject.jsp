<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel.com</title>
<link rel="stylesheet" href="WEB-INF/lib/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<script src="WEB-INF/lib/jquery/js/jquery.min.js"></script>
	<script src="WEB-INF/lib/bootstrap/js/bootstrap.min.js"></script>

	<c:import url="includes/menu.jsp"></c:import>
	
	Seja Bem-Vindo ${sessionScape.clienteLogado.nome }

</body>
</html>