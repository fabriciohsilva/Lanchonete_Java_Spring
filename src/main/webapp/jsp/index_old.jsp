<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home Page</title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/style.css"/>">
	<meta charset="UTF-8">
	
</head>

<body>
	<div id="menu">
		<div id="menu-container">
			<ul>
				<li><a href="<c:url value="/home"/>" title="Cardapio">Home</a></li>
				<li><a href="<c:url value="/cardapio"/>" title="Cardapio">Card�pio</a></li>
				<li>
				
					<form id="login-form" class="navbar-form navbar-right" role="form" method="post" action="<c:url value='/login' />">			
						<div class="form-group">
							<input type="text" name="nickusr" placeholder="Nome de usu�rio" size="10" maxlength="10" class="form-control">
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
				<li><a href="<c:url value="/sobre"/>" title="Sobre N�s">Sobre</a></li>
				<li>
					<c:if test="${not empty usuario.tipUsr}">
						<a href="<c:url value="/cadprod?new"/>" title="Cadastrar Produto">Cadastrar Produto</a>
					</c:if>
				</li>
				
			</ul>
		</div>
	</div>
	
	<div id="header">
		<div id="header-container"></div>
	</div>
	
	<div id="content">
	
		<div id="content-container">
		
			<div class="content-box">
			
				<h1>Lorem Ipsum</h1>
				
				<p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, 
				e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos
				e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, 
				como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. 
				Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum,
				e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.</p>
			</div>
			
			<div class="content-box">
			
				<h1>Lorem Ipsum</h1>
				
				<p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, 
				e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos
				e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, 
				como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. 
				Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum,
				e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.</p>
			</div>
			
			<div class="content-box">
			
				<h1>Lorem Ipsum</h1>
				
				<p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, 
				e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos
				e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, 
				como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. 
				Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum,
				e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.</p>
			</div>
			
			<div class="content-box">
			
				<h1>Lorem Ipsum</h1>
				
				<p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, 
				e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos
				e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, 
				como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. 
				Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum,
				e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.</p>
			</div>
			
		</div>
		
	</div>
	
	<div id="footer">
		<div id="footer-container">
			<p>Dados da Empresa</p>
		</div>
	</div>
	
</body>

</html> 