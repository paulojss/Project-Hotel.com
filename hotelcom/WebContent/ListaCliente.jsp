<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listando com jstl</title>

<script type="text/javascript">
	
	function confirmaExclusao(id) {
		
		if(window.confirm("Deseja realmente excluir?")){
			
			location.href="clientecontroller.do?action=del&id="+id; 
		}
	}
</script>
</head>

<body>

	<c:import url="includes/menu.jsp"></c:import>

	<table border="1">
		<tr bgcolor="#CCCCCC">
			<th>ID</th> <th>Nome</th> <th> Sobrenome</th> <th>E-mail</th> <th>Senha</th>
			<th>Celular</th> <th>Tel. Fixo</th> <th>Acao</th>
		</tr>	


<c:forEach items="${requestScope.listaCliente}" var="cl">
		<tr>
			<td>${cl.codcliente }</td>
			<td>${cl.nome }</td>
			<td>${cl.sobrenome }</td>
			<td>${cl.email }</td>
			<td>${cl.senha }</td>
			<td>${cl.telefonecelular }</td>
			<td>${cl.telefoneresid }</td>
			
			<td>
			<a href="javascript:confirmaExclusao(${cl.codcliente })">Excluir</a>
			|
			<a href="clientecontroller.do?action=update&id=${cl.codcliente }">Alterar</a>
			</td>
		</tr>

</c:forEach>

</table>

</body>
</html>