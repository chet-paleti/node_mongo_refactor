
    
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
                                <a href="${pageContext.request.contextPath}/shop/product/${tmpproduct.id}" class="btn">Details</a>
                                
                                <form action="${pageContext.request.contextPath}/shop/add-cart" method="post">
								    <button class="btn" type="submit">Add to Cart</button>
								    <input type="hidden" name="productId" value="${tmpproduct.id}">
								</form>
                            
                        </div>
               </article>
	  
	  
	  </c:forEach>
   
    </div>
    
    </main>
    
    <c:import url="end.jsp" />