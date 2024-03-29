<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="head.jsp" />

</head>

<body>
    <c:import url="navigation.jsp" />
    
     <main class="centered">
            <h1>${product.title}</h1>
            <hr>
            <div class="image">
                <img src="${product.imageurl}" alt="${product.title}">
            </div>
            <h2>${product.price}</h2>
            <p>${product.description}</p>
            
            <form action="${pageContext.request.contextPath}/shop/add-cart" method="post">
					<button class="btn" type="submit">Add to Cart</button>
					<input type="hidden" name="productId" value="${product.id}">
			</form>
      </main>
      
      <c:import url="end.jsp" />