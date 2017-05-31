<%@page import="br.com.hotel.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr bgcolor="#CCCCCC">
			<th>ID</th> <th>Nome</th> <th> Sobrenome</th> <th>E-mail</th> <th>Senha</th>
			<th>Celular</th> <th>Tel. Fixo</th> <th>Acao</th>
		</tr>	

<%//Scriptlet
	
	List<Cliente> listaC = (List<Cliente>)request.getAttribute("listaCliente");
	
	for(Cliente c: listaC){
%>
		<tr>
			<td><%=c.getCodcliente() %></td>
			<td><%=c.getNome() %></td>
			<td><%=c.getSobrenome() %></td>
			<td><%=c.getEmail() %></td>
			<td><%=c.getSenha() %></td>
			<td><%=c.getTelefonecelular() %></td>
			<td><%=c.getTelefoneresid() %></td>
			
			<td>
			<a href="clientecontroller.do?action=del&id=<%=c.getCodcliente()%>">Excluir</a>
			|
			<a href="clientecontroller.do?action=update&id=<%=c.getCodcliente()%>">Alterar</a>
			</td>
		</tr>

<%
	} 
%>

</table>

</body>
</html>