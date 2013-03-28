<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html>
	<head>
		<title>Product List</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="style2.css">
		<meta name="viewport" content="initial-scale=1.0" />
		<script src="js/jquery-1.8.2.min.js"></script>
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

					<th class="clear"/>

					<div class="logo">
						<a href="#"><img src="images/logo.png" alt=""></a>
					</div>

					<!-- <span class="log">Log in or Register</span> -->

					<div class="navwrap">



						<ul class="nav">
							<li class="home"><a href="#"><img src="images/home.png" alt=""></a></li>
							<li><a href="#">Lindt</a></li>
							<li><a href="#">Sprangli</a></li>
							<li><a href="#">Alba</a></li>
							<li><a href="#">Camille</a></li>
							<li><a href="#">Contact</a></li>
						</ul>
						
	
					</div>
					<div class="shadow"></div>



					
					<div class="modules">
						<div class="cat txteffect">
							<h2>Categories</h2>
						</div>
						<div class="lscat">
							<ul>
								<li><a href="#">Lindt & Sprangli</a></li>
								<li><a href="#">Sprangli AG</a></li>
								<li><a href="#">Alba ipsum</a></li>
								<li><a href="#">Camille Bloch SA</a></li>
							</ul>
						</div>
						
						<br>
						
						<div class="cat txteffect">
							<h2>Range</h2>
						</div>
						<div class="lscat">
							<form name="form1" method="post" action="">
					          <p>
					            <input id="slider" type="range" min="50" max="750" step="25" value="750" onchange="printValue('slider','rangeValue')" />
						        <input id="rangeValue" type="text" size="2"/>
					          </p>
					        </form>
				        </div>
				        
				        <br>
				        
				        <div class="cat">
							<h2 class=" txteffect">Wishlist</h2>
							<div id="favorites" class="lscat">
								<ul id="faves">
								
								</ul>
								<p class="dragmsg">Drag Favorites Here</p>
								<br/>
			        		</div>
			        		
						</div>
						<br><br><br><br><br>
						<div id="favorites" class="widget">
        <h2>Adversiting</h2>
        <p>dolores conspturar to invidos quraius</p>
        <ul id="faves"></ul>
      </div>
						
						
					</div>

					<div class="rprod">

						<span class="navlink">Home :: Sprangli :: Product1</span><br>
						<img src="images/span.png">
						<h2>Product1</h2>
						<img src="images/span.png">
						
						
						<c:forEach var="name"  items="${requestScope['ProductList']}" >	
							<div class="prodinfo" draggable="true">
								<img width="100" height="100" src="images/${name.image}" alt="">
								<br>
								<p class="details">
									${name.designation}
									<br/><br/>
									$<span class="price">${name.prix}</span>
									<br/><br/><br/>
									<span class="btn">Add to cart</span>
								</p>
								
							</div>
							<br class="clear" />
						</c:forEach>
						
						<div id="pagination">
						
							<%--For displaying Previous link except for the 1st page --%>
						    <c:if test="${currentPage != 1}">
						        <a href="ProductList?page=${currentPage - 1}" class="previous">Previous</a>
						    </c:if>
	 						
	 						<div id="numpage">
								    <%--For displaying Page numbers.
								    The when condition does not display a link for the current page--%>
						            <c:forEach begin="1" end="${noOfPages}" var="i">
						                <c:choose>
						                    <c:when test="${currentPage eq i}">
						                        <span>${i}</span>
						                    </c:when>
						                    <c:otherwise>
						                        <a href="ProductList?page=${i}" class="number">${i}</a>
						                    </c:otherwise>
						                </c:choose>
						            </c:forEach>
						    </div>
						 
						    <%--For displaying Next link --%>
						    <c:if test="${currentPage lt noOfPages}">
						        <a href="ProductList?page=${currentPage + 1}" class="next">Next</a>
						    </c:if>
						
						</div>

					</div>

					<br class="clear"/><br>

					

					
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
						<p>Copyright Â© 2013 BoldStore. Powered by Chikola</p>
					</div>
				</div>
			</div>

		</div>
		
		<script type="text/javascript" src="js/jquery.ndd.js"></script>
		<script type="text/javascript" src="js/dragdrop.js"></script>
		
		<script>
        function printValue(sliderID, textbox) {
            var x = document.getElementById(textbox);
            var y = document.getElementById(sliderID);
            x.value = y.value;
        }

        window.onload = function() { printValue('slider', 'rangeValue'); }
		</script>
		
		
		<c:forEach var="name"  items="${requestScope['ProductList']}" >
			
			<script>
			var idprod= ${name.id};
			var prix= ${name.prix};
			// Set price data for paintings
			$('.prodinfo').data({ id:idprod, price:prix });
	
			// Link range to paintings
			$(document).ready(function () {
				var theValue;
	
				$("#slider").change(function() {
					theValue = $("#rangeValue").val();
					filterItems(theValue) ;
				});
			});
	
			function filterItems(priceCriteria)
			{
				$.each($('.prodinfo'), function(i, item) {
					$item = $(item); 
					itemData = $item.data();
					if(itemData.price <= priceCriteria) 
					{
						$item.animate({opacity: 1});
						itemData.matching = true;
					}
					else
					{
						$item.animate({opacity: 0.5});
						itemData.matching = false;
					}
				});
			}
	
			</script>
		
		</c:forEach>
	</body>
</html>