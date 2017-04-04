<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Carrinho</title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/style.css"/>">
	<meta charset="UTF-8">
	
</head>

<body>

	<table border="1">
  	<thead>
    	<tr>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Qtde</th>
			<th>Total</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrinho.itens}" var="item">
			<tr>
				<td>${item.produto.desProd }</td>
				<td>
					<fmt:formatNumber type="currency" value="${item.produto.valUnit }"/>
				</td>
				<td>${item.quantidade }</td>
				<td>
					<fmt:formatNumber type="currency" value="${item.quantidade * item.produto.valUnit }"/>
				</td>
				<td><a href="<c:url value="/carrinho/del/${item.produto.idProd}"/>">Remover</a></td>
			</tr>          
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
		<td colspan="1"></td>
		<th colspan="2">Total:</th>
		<th>
			<fmt:formatNumber type="currency" value="${carrinho.total }"/>
		</th>
    </tr>
	</tfoot>
	</table>
	
	<a href="/cardapio">Voltar</a>
	<a href="/pedido">Finalizar Compra</a>


</body>

</html> 