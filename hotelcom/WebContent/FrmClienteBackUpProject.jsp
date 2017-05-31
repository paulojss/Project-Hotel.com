<%@page import="br.com.hotel.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Cliente c = (Cliente) request.getAttribute("cliente");
	%>

	<form action="clientecontroller.do" method="post">
	
		<label>ID:</label>
		<input type="text" name="txtid" value="<%=c.getCodcliente()%>" />
	
		<label>Endereço de e-mail:</label>
		<input type="text" name="txtemail" value="<%=c.getEmail() %>" />
		
		<label>Senha:</label>
		<input type="password" name="txtsenha" value="<%=c.getSenha() %>" maxlength="16" />
		
		<label>Nome:</label>
		<input type="text" name="txtnome" value="<%=c.getNome() %>" />
		
		<label>Sobrenome:</label>
		<input type="text" name="txtsobrenome" value="<%=c.getSobrenome()%>" />
		
		<input type="submit" value="Salvar"/>
	
	</form>

</body>
</html>