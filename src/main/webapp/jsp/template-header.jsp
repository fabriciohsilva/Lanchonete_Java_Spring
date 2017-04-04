<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt">
<head>
  <meta charset="utf-8">
  <title>Xtra Beico - A lanchonete da galera</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<link rel="shortcut icon" href="<c:url value="/img/icon.ico"/>">
  
	
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">					
					<div class="collapse navbar-collapse" id="nav">
						<ul class="nav navbar-nav">
							<li class="active">		
								<li><a href="<c:url value="/home"/>"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a></li>								
								<li><a href="<c:url value="/cardapio"/>"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Cardápio</a></li>
								<li><a href="<c:url value="/carrinho"/>"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Pedido</a></li>									
								<li><a href="<c:url value="/sobre"/>"><span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span> Sobre Nós</a></li>
												
								<li>
									<form id="login-form" class="navbar-form navbar-right" role="form" method="post" action="<c:url value='/login' />">			
										<div class="form-group">
											<input type="text" name="nickusr" placeholder="Nome de usuário" size="10" maxlength="10" class="form-control">
											<input type="password" name="senha" placeholder="Password" size="10" maxlength="10" class="form-control">
											<button type="submit" class="btn btn-success">Entrar <span class="glyphicon glyphicon-log-in"></span></button>
										</div>					
									</form>								
								</li>			
								
								<li>
									<c:if test="${empty usuario.nickUsr}">
										<a href="<c:url value="/singin?new"/>" title="Realizar cadastro">Cadastrar-se</a>
									</c:if>
					
									<c:if test="${not empty usuario.nickUsr}">
										<a href="<c:url value="/singin/${usuario.idUsr}"/>" title="Realizar cadastro">Atualizar Cadastro</a>
									</c:if>
								</li>
								
						</ul>					
					</div>					
				</nav>
			</div>
		</div>