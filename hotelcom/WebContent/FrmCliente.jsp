<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de Cliente co jstl</title>
</head>
<body>

	<c:import url="includes/menu.jsp"></c:import>	
	
	<form action="clientecontroller.do" method="post">
	
		<label>ID:</label>
		<input type="text" name="txtid" value="${requestScope.cliente.codcliente }" />
	
		<label>Endereço de e-mail:</label>
		<input type="text" name="txtemail" value="${requestScope.cliente.email }" />
		
		<label>Senha:</label>
		<input type="password" name="txtsenha" value="${requestScope.cliente.senha}" maxlength="16" />
		
		<label>Nome:</label>
		<input type="text" name="txtnome" value="${requestScope.cliente.nome}" />
		
		<label>Sobrenome:</label>
		<input type="text" name="txtsobrenome" value="${requestScope.cliente.sobrenome}" />
		
		<input type="submit" value="Salvar"/>
	
	</form>

</body>
</html>