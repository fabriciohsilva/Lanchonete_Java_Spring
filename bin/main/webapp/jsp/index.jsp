<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="template-header.jsp" >
    <jsp:param name="title" value="Xtra Beico" />
</jsp:include>

			<div class="carousel slide" id="carousel">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-814798">
					</li>
					<li data-slide-to="1" data-target="#carousel-814798">
					</li>
					<li data-slide-to="2" data-target="#carousel-814798" class="active">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img alt="600x200" src="img/hamburger1.jpg" />
						<div class="carousel-caption">
							<h2>
								Do tamanho da sua fome!
							</h2>
							<p>
								Something
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="600x200" src="img/hamburger2.jpg" />
						<div class="carousel-caption">
							<h2>
								Vai resistir?
							</h2>
							<p>
								Something
							</p>
						</div>
					</div>
					<div class="item active">
						<img alt="600x200" src="img/hamburger3.jpg" />
						<div class="carousel-caption">
							<h2>
								Incrivelmente grande!
							</h2>
							<p>
								Something
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-814798" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-814798" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>

    
<jsp:include page="template-footer.jsp" />