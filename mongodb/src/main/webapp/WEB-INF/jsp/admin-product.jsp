<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<c:import url="head.jsp" />

<link rel='stylesheet' href="${pageContext.request.contextPath}/css/product.css" type='text/css'>

<link rel='stylesheet' href="${pageContext.request.contextPath}/css/forms.css" type='text/css'>

</head>

<% String editing = (String) request.getParameter("edit"); 

%>

<body>
    <c:import url="navigation.jsp" />
    
      <main>
        <form:form class="product-form" action="${pageContext.request.contextPath}/admin/product" modelAttribute="product" method="POST">
            <div class="form-control">
                <label for="title">Title</label>
                <form:input type="text" path="title"/>
            </div>
            <div class="form-control">
                <label for="imageurl">Image URL</label>
                 <form:input type="text" path="imageurl"/>
            </div>
            <div class="form-control">
                <label for="price">Price</label>
                <form:input type="number" step="0.01" path="price"/>
            </div>
            <div class="form-control">
                <label for="description">Description</label>
                  <form:textarea rows="5" path="description"/>
            </div>
           
           <form:hidden path="id"/>
           
           
            <button class="btn" type="submit"><% if (editing == null) { %>Add Product<% } else { %>Edit Product<% } %></button>
            
        </form:form>
    </main>
      
      <c:import url="end.jsp" />