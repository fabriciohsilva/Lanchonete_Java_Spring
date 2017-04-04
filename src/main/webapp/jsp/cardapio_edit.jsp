<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="template-header.jsp" >
    <jsp:param name="title" value="Xtra Beico - listagem de produtos" />
</jsp:include>
	
	<table border="1">
  	<thead>
    	<tr>
			<th>Descrição</th>
			<th>Preço</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cardapio}" var="produtos">
			<tr>
				<td>${produtos.desProd }</td>
				<td><fmt:formatNumber type="currency" value="${produtos.valUnit }"/></td>
				<td><img src=<c:url value="/imgprod/${produtos.idProd}.jpg" /> height="60" width="50"></td>
				<td><a href="<c:url value="/cadprod/${produtos.idProd}"/>">Editar</a></td>
				<td><a href="<c:url value="/cadprod/remover/${produtos.idProd}"/>">Remover</a></td>
			</tr>          
		</c:forEach>
	</tbody>
	<tfoot>
	</tfoot>
	</table>
	<br/>
	<a href="/home">Voltar</a>
	<a href="/Carrinho">Carrinho de Compras</a>
	
	
<jsp:include page="template-footer.jsp" />