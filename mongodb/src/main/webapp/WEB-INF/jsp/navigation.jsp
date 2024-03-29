<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%        
   		String path = request.getContextPath() ;
       
 	%>
<div class="backdrop"></div>
<header class="main-header">
    <button id="side-menu-toggle">Menu</button>
    <nav class="main-header__nav">
        <ul class="main-header__item-list">
            <li class="main-header__item">
                <a class="<%= (path.equals("/") ? "active" : "") %>" href="${pageContext.request.contextPath}/shop/home">Shop</a>
            </li>
            <li class="main-header__item">
                <a class="<%= (path.equals("/products") ? "active" : "") %>" href="${pageContext.request.contextPath}/shop/home">Products</a>
            </li>
            <li class="main-header__item">
                <a class="<%= (path.equals("/cart") ? "active" : "") %>" href="${pageContext.request.contextPath}/shop/cart">Cart</a>
            </li>
            <li class="main-header__item">
                <a class="<%= (path.equals("/orders") ? "active" : "") %>" href="${pageContext.request.contextPath}/shop/orders">Orders</a>
            </li>
            <li class="main-header__item">
                <a class="<%= (path.equals("/admin/add-product") ? "active" : "") %>" href="${pageContext.request.contextPath}/admin/add-product">Add Product
                </a>
            </li>
            <li class="main-header__item">
                <a class="<%= (path.equals("/admin/products") ? "active" : "") %>" href="${pageContext.request.contextPath}/admin/products">Admin Products
                </a>
            </li>
        </ul>
    </nav>
</header>

<nav class="mobile-nav">
        <ul class="mobile-nav__item-list">
                <li class="mobile-nav__item">
                     <a class="<%= (path.equals("/") ? "active" : "") %>" href="/">Shop</a>
                </li>
                <li class="mobile-nav__item">
                   <a class="<%= (path.equals("/products") ? "active" : "") %>" href="/products">Products</a>
                </li>
                <li class="mobile-nav__item">
                    <a class="<%= (path.equals("/cart") ? "active" : "") %>" href="/cart">Cart</a>
                </li>
                <li class="mobile-nav__item">
                    <a class="<%= (path.equals("/orders") ? "active" : "") %>" href="/orders">Orders</a>
                </li>
                <li class="mobile-nav__item">
                    <a class="<%= (path.equals("/admin/add-product") ? "active" : "") %>" href="/admin/add-product">Add Product
                    </a>
                </li>
                <li class="mobile-nav__item">
                   <a class="<%= (path.equals("/admin/products") ? "active" : "") %>" href="/admin/products">Admin Products
                    </a>
                </li>
            </ul>
</nav>