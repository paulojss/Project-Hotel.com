<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hotel.com</title>
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css">

</head>
<body>
	
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>

		<header>

			<div class="container">
				
				<div class="row">
					
				</div>

			</div>

		</header>

	
	<c:import url="includes/menu.jsp"></c:import>
	
	Seja Bem-Vindo ${sessionScape.clienteLogado.nome }

</body>
</html>