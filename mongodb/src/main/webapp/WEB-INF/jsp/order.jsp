<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="head.jsp" />

<link rel='stylesheet' href="${pageContext.request.contextPath}/css/orders.css" type='text/css'>

</head>

<body>
    <c:import url="navigation.jsp" />
    
      <main>
      
      <c:choose>
  		<c:when test="${empty orders}">
  		
  		<h1>Nothing there!</h1>
  		
    
  		</c:when>
 
  	<c:otherwise>
  	
  		
  			<ul class="orders">
  			
  			<c:forEach var="order" items="${orders}">
  			
  					<li class="orders__item">
                            <h1># ${order.id}</h1>
                            <ul class="orders__products">
                                <c:forEach var="orderitem" items="${order.orderitems}">
                                    <li class="orders__products-item">${orderitem.product.title} (${orderitem.qty})</li>
                                </c:forEach>
                            </ul>
                        </li>
  			
  			
  		 	</c:forEach>
  		 	
  		 	</ul>
             
  
  	</c:otherwise>
	
	</c:choose>
       
           
      </main>
      
      <c:import url="end.jsp" />