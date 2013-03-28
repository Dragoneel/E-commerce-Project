<%@page import="java.util.List"%>
<%@page import="bean.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.utilisateur" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="style.css">
	</head>
	<body> 
		<div id="container">
			<div class="bar">
				<div class="wrap">

					<div class="left">
						<span class="currency txteffect">Currency : </span>
						<a class="money" href="#">CAD</a>
						<a class="money" href="#">EUR</a>

						<span class="currency txteffect lg">Language : </span>
						<a class="money" href="#">EN</a>
						<a class="money" href="#">FR</a>
					</div>

					<div class="right">
						<div class="cart">
							<a href="#" class="txteffect"></a>Your cart is empty</span>
						</div>
					</div>

					<th class="clear"></th>

					<div class="logo">
						<a href="#"><img src="images/logo.png" alt=""></a>
					</div>

					

					<div class="navwrap">

						<ul class="nav">
							<li class="home"><a href="#"><img src="images/home.png" alt=""></a></li>
							<li><a href="#">Clothes</a></li>
							<li><a href="#">Boths</a></li>
							<li><a href="#">Vestes</a></li>
							<li><a href="#">Misc</a></li>
							<li><a href="#">Contact</a></li>
							<span class="log">
							<li>Log in or Register</li>
							</span>
						</ul>
	
					</div>
					<div class="shadow"></div>

					<div class="slider">
						<img src="images/slide.png" alt="">
					</div>

					<div class="banner">
						<img src="images/ban1.png" class="" alt="">
						<img src="images/ban2.png" class="middle" alt="">
						<img src="images/ban3.png" class="last" alt="">
					</div>

					<th class="clear"></th>

					<div class="title">
						<h1>Featured Products</h1>
					</div>
					
					<div> 
						

					
					</div>
					<br/>
		
					<div class="article">

						 <c:forEach var="name"  items="${requestScope['lsprod']}" >
							<div class="prod">
							
								<img width="206" height="215" src="images/${name.image}" alt="">
								<p class="info">
									${name.designation}
								</p>
								<p class="price">
								$${name.prix}
								</p>
								<p class="btn">Add to cart	//	Details</p>
								
							
							</div>
						 </c:forEach>
						
					</div>

					
				</div>
			</div>
			<br class="clear">

			<div class="bigfooter">
				<div class="footer">
					<div class="fowrap">
						<div class="about">
							<h1>About</h1>
							<p>Vestibulum pharetra ipsum nec nisi tristique tristique. In commodo tempus faucibus. Nulla ac tellus enim, quis cursus sapien. Morbi cursus velit elit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras venenatis nibh nec tellus molestie vitae rhoncus purus dignissim.</p>
						</div>
						<div class="infos">
							<h1>Informations</h1>
							<ul class="links">
								<li><a href="#">---  Shipping & Returns</a></li>
								<li><a href="#">---  Phasellus volutpat </a></li>
								<li><a href="#">---  Praesent vestibulum justo</a></li>
								<li><a href="#">---  Integer condimentum tellus</a></li>
								<li><a href="#">---  Sed consequat </a></li>
							</ul>
						</div>
						<div class="infos infos2">
							<h1>My Account</h1>
							<ul class="links">
								<li><a href="#">---  Terms & Conditions</a></li>
								<li><a href="#">---  Phasellus volutpat </a></li>
								<li><a href="#">---  Praesent vestibulum justo</a></li>
								<li><a href="#">---  Integer condimentum tellus</a></li>
								<li><a href="#">---  Sed consequat</a></li>
								<li><a href="#">---  Personal informations</a></li>
								<li><a href="#">---  Manufacturers</a></li>
							</ul>
						</div>
						<div class="contact">
							<h1>Contact</h1>
							<p class="tel"> +001 234 567</p>
							<p class="mail"> email@example.com</p>
							<p class="location"> Address: Street 1234, NY, USA, Building n3</p>
						</div>
					</div>
				</div>
				<div class="fofooter">
					<div class="fowrap">
						<p>Copyright © 2013 BoldStore. Powered by Chikola</p>
					</div>
				</div>
			</div>

		</div>
	</body>
</html>