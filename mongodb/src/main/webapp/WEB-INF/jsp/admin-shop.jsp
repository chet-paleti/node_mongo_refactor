<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="head.jsp" />
   
    <link rel='stylesheet' href="${pageContext.request.contextPath}/css/product.css" type='text/css'>

</head>

<body>
    <c:import url="navigation.jsp" />
    
    <main>
    
    <div class="grid">
    
	  <c:forEach var="tmpproduct" items="${products}">
	  
			<article class="card product-item">
                        <header class="card__header">
                            <h1 class="product__title">${tmpproduct.title}</h1>
                        </header>
                        <div class="card__image">
                            <img src="${tmpproduct.imageurl}"
                                alt="${tmpproduct.title}">
                        </div>
                        <div class="card__content">
                            <h2 class="product__price">$${tmpproduct.price}</h2>
                            <p class="product__description">${tmpproduct.description}</p>
                        </div>
                        <div class="card__actions">
                                    <a href="${pageContext.request.contextPath}/admin/edit-product/${tmpproduct.id}?edit=true" class="btn">Edit</a>
                                    <form action="${pageContext.request.contextPath}/admin/delete-product" method="POST">
                                        <input type="hidden" value="${tmpproduct.id}" name="productId">
                                        <button class="btn" type="submit">Delete</button>
                                    </form>

                                </div>
               </article>
	  
	  
	  </c:forEach>
   
    </div>
    
    </main>
    
    <c:import url="end.jsp" />