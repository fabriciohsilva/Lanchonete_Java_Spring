<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="template-header.jsp" >
    <jsp:param name="title" value="Xtra Beico - Cardápio" />
</jsp:include>
	
	<div class="row">
	
		<c:forEach items="${cardapio}" var="produtos">
			
			<c:if test="${not empty produtos.statusProd}">
			
			<div class="col-md-3">
				<div class="thumbnail">
					<img alt="300x200" src=<c:url value="/imgprod/${produtos.idProd}.jpg" />/>
					<div class="caption">
						<h3>${produtos.desProd }</h3>
						<p><fmt:formatNumber type="currency" value="${produtos.valUnit }"/></p>
						<p>
							<a class="btn" href="<c:url value="/carrinho/add/${produtos.idProd}"/>"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Incluir</a>
						</p>
					</div>
				</div>
			</div>
			
			</c:if>			
        
		</c:forEach>
	
	</div>

	
<!-- <br/>
	<a href="/home">Voltar</a>
	<a href="/Carrinho">Carrinho de Compras</a>  -->	
	
	
<jsp:include page="template-footer.jsp" />