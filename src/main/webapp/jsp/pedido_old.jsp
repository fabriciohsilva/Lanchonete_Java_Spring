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
			<th>Pedido Nº</th>
			<th>Cliente</th>
			<th>Endereço</th>
			<th>CEP</th>
			<th>Telefone</th>
			<th>Valor Total</th>			
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${carrinho.idCar }</td>
			<td>${carrinho.cliente.nome }</td>
			<td>${carrinho.cliente.endUsr } ", "${carrinho.cliente.numEndUsr }</td>
			<td>${carrinho.cliente.cepUsr }</td>
			<td>${carrinho.cliente.telUsr }</td>
			<td>
				<fmt:formatNumber type="currency" value="${carrinho.total }"/>
			</td>		
	</tbody>
	</table>
	
	<br/>
	
	<table border="1">
	<thead>
    	<tr>
			<th>Produto</th>
			<th>Quantidade</th>
			<th>Valor Unitário</th>
			<th>Valor Item</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrinho.itens}" var="item">
			<tr>
				<td>${item.produto.desProd }</td>
				<td>${item.quantidade }</td>
				<td>
					<fmt:formatNumber type="currency" value="${item.produto.valUnit }"/>
				</td>
				<td>
					<fmt:formatNumber type="currency" value="${item.quantidade * item.produto.valUnit }"/>
				</td>
			</tr>          
		</c:forEach>
	</tbody>
	</table>

</body>

</html> 