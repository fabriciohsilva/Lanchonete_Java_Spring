<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="template-header.jsp" >
    <jsp:param name="title" value="Xtra Beico - Sobre Nós" />
</jsp:include>
	
	<form id="cadprod" action="<c:url value="/cadprod${ empty produto.idProd ? '' : '/'.concat(produto.idProd) }" />" method="post" enctype="multipart/form-data">
	<fieldset>
		
		<legend>${empty produto.idProd ? 'Novo' : 'Editar'} Produto</legend>
		<c:if test="${not empty produto.idProd}">
	
		  <label>Código do Produto</label><br/>
			<input type="text" name="idProd" value="${produto.idProd}" readonly="readonly"><br/><br/>
		</c:if>
	
		<label>Descrição do Produto</label><br/>
		<input name="desProd" type="text" value="${produto.desProd}" size="30" maxlength="30" required/><br/><br/>
	
		<label>Valor Unitário</label><br/>
		<input name="valUnit" type="number" step="any" value="${produto.valUnit}" size="10" maxlength="20" required/><br/><br/>
						
	
		<c:set var="status" scope="session" value="${produto.statusProd}"/>
		<c:choose>
      		<c:when test="${status == 'S'}">
      			<input name="statusProd" type="checkbox"  checked />Produto Ativo?<br/><br/>
		    </c:when>
			
      		<c:otherwise>
      			<input name="statusProd" type="checkbox"  />Produto Ativo?<br/><br/>
      		</c:otherwise>
		</c:choose>
		
						
						
		<label>Imagem do Produto</label><br/>
		<input name="urlProd" type="file" /><br/><br/>
	
	
		
		<button type="submit">Gravar</button>
		

	</fieldset>
	</form>                    
	
<jsp:include page="template-footer.jsp" />