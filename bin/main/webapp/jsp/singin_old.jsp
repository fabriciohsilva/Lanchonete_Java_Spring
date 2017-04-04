<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Cadastro de Produto</title>
	
</head>

<body>

				<h1></h1>

				<form id="singin" action="<c:url value="/singin${ empty usuario.idUsr ? '' : '/'.concat(usuario.idUsr) }" />" method="post">
					<fieldset>
		    			
		    			<legend>${empty usuario.nickUsr ? 'Novo' : 'Editar'} Usuario</legend>
		    			
		    			<!--<c:if test="${not empty usuario.nickUsr}">-->
		    					    		
		    				<label>Nick Name</label><br/>
		      				<input type="text" name="nickUsr" value="${usuario.nickUsr}" readonly="readonly"><br/><br/>
		      				
					    <!--</c:if>-->
					    
					    <label>Nick Name</label><br/>
		      			<input type="text" name="nickUsr" value="${usuario.nickUsr}" ><br/><br/>
		      			
		      			<label>Senha</label><br/>
    					<input name="senha" type="password" size="20" maxlength="20" required/><br/><br/>
                   	
	    				<label>Nome Completo</label><br/>
    					<input name="nome" type="text" size="30" maxlength="70" required/><br/><br/>
                    
	                    <label>CPF/CNPJ </label><br/>
    					<input name="cpfCnpj" type="text" size="14" maxlength="14" required/><br/><br/>
                           				
    					<!-- <input name="tipUsr" type="checkbox"/>Usuário Administrador: <br/><br/>--> 
                        				
	    				<label>CEP</label><br/>
    					<input name="cepUsr" type="text" size="10" maxlength="10" required/><br/><br/>
    				
	    				<label>Endereço</label><br/>
    					<input name="endUsr" type="text" size="70" maxlength="70" required/><br/><br/>
    					
	    				<label>Número</label><br/>
    					<input name="numEndUsr" type="text" size="8" maxlength="8" required/><br/><br/>    					

	    				<label>E-mail</label><br/>
    					<input name="emailUsr" type="text" size="70" maxlength="70" required/><br/><br/>

	    				<label>Telefone</label><br/>
    					<input name="telUsr" type="text" size="15" maxlength="15" required/><br/><br/>

    					    					
    					<button type="submit">Gravar</button>
    					
    			
    				</fieldset>
				</form>                    

</body>

</html> 