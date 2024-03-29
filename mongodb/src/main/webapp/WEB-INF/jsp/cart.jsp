<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="head.jsp" />

<link rel='stylesheet' href="${pageContext.request.contextPath}/css/cart.css" type='text/css'>

</head>

<body>
    <c:import url="navigation.jsp" />
    
      <main>
      
      <c:choose>
  		<c:when test="${empty cartitems}">
  		
  		<h1>No Products in Cart!</h1>
  		
    
  		</c:when>
 
  	<c:otherwise>
  	
  		
  		
  			<ul class="cart__item-list">
  			
  			<c:forEach var="cartitem" items="${cartitems}">
  			
  					<li class="cart__item">
	                   <h1>${cartitem.product.title}</h1>
	                   <h2>Quantity: ${cartitem.qty}</h2>
	                   <form action="${pageContext.request.contextPath}/shop/cart-delete-item" method="POST">
	                       <input type="hidden" value="${cartitem.product.id}" name="cartitemid">
	                       <button class="btn danger" type="submit">Delete</button>
	                   </form>
                   </li>
  			
  			
  		 	</c:forEach>
  		 	
  		 	</ul>
             <hr>
             
             <div class="centered">
                  <form action="${pageContext.request.contextPath}/shop/create-order" method="POST">
                      <button type="submit" class="btn">Order Now!</button>
                  </form>
              </div>
  
  	</c:otherwise>
	
	</c:choose>
       
           
      </main>
      
      <c:import url="end.jsp" />