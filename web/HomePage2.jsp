<%-- 
    Document   : HomePage
    Created on : Nov 14, 2021, 9:25:49 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.*" import="java.io.*"%>
<%--<%@ page import="model.Book" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Shopee.vn</title>
        <style>
            <%@include file="/css/homeStyle.css"%>
        </style>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

    </head>

    <body>
        <!-- header -->
        <header>
            <%

                String accountID = null;
                String cartID = null;
                Cookie[] cookies = request.getCookies();

                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("accountID")) {
                            accountID = cookie.getValue();
                        }
                        if (cookie.getName().equals("cartID")) {
                            cartID = cookie.getValue();
                        }
                    }

                }
                Cookie pathCookie = new Cookie("prePath", "Home");
                response.addCookie(pathCookie);

            %>

            <!-- for logo page -->
            <div class="logo">
                <a href="HomePage2.jsp">
                    <h1>
                        <span style="color:white">Shopee</span>

                    </h1>
                </a>
            </div>
            <!-- for search form -->
            <div class="search-container">
                <form action="Search" method="post">
                    <div class="enter-for-search">
                        <input type="text" placeholder=" Tìm kiếm sản phẩm mong muốn.." name="keyword">
                    </div>
                    <div class="button-search">
                        <button type="submit"><i class="fa fa-search"></i><span>Tìm</span></button>
                    </div>
                </form>
            </div>
            <!-- for nav bar -->
            <div class="header-link">
                <div class="book-order">
                    <form class="myform" action="Cart" method="post">
                        <button class="control-btn">
                            <i class="fa fa-shopping-bag fa-lg"></i>
                            <span>Đơn hàng </span>
                        </button>
                    </form>
                    <form class="myform" action="Cart" method="post">
                        <button class="control-btn">
                            <i class="fa fa-shopping-cart fa-lg"></i>
                            <span>Giỏ hàng</span>
                        </button>
                    </form>
                </div>
                <!-- dropdown tai khoan -->
                <div class="dropdown">
                    <a href="#" class="tk">
                        <i class="fa fa-user-circle fa-lg"></i><span>Tài khoản</span>
                    </a>
                    <div class="dropdown-content">
                        <a href=""><i class="fa fa-cog"></i><span>Cài đặt</span></a>
                        <a href=""><i class="fa fa-id-badge"></i><span>Liên hệ</span></a>
                        <a href="HomePage.jsp"><i class="fa fa-power-off"></i><span>Đăng xuất</span></a>
                    </div>
                </div>
                <!-- end  dropdown tai khoan -->
            </div>
            <!-- end for nav bar -->
        </header>
        <!-- end header -->
        <main>
            <div class="nav-left">
                <div class="bar-1">
                    <a href=""><i style="background-color: rgb(6, 104, 104);" class="fa fa-bookmark main-span"></i><span
                            class="main-span-1">Yêu thích</span></a>
                </div>
                <div class="bar-1">
                    <a href=""><i style="background-color: rgb(233, 63, 51);" class="fa fa-bell main-span"></i><span
                            class="main-span-1">Thông báo</span></a>
                </div>
                <div class="bar-1">
                    <a href=""><i style="background-color: rgb(162, 211, 26);" class="fa fa-gift main-span"
                                  aria-hidden="true"></i></i><span class="main-span-1">Quà tặng</span></a>
                </div>
                <div class="bar-1">
                    <a href=""><i style="color: black;" class="fa fa-bars main-span"></i><span class="main-span-1">Danh sách</span></a>
                    <ul class="list">

                        <li>


                            <div class="dropdown">
                                <a href=""><span class="span-1">Sách</span></a>
                                <div class="dropdown-content">
                                    <a href=""><span class="span-2">Thiếu nhi</a>
                                    <a href=""><span class="span-2">Giáo dục</a>
                                    <a href=""><span class="span-2">Khoa học</a>
                                    <a href=""><span class="span-2">Kinh tế</a>
                                </div>
                            </div>
                        </li>
                        <br>

                        <li>
                            <div class="dropdown">
                                <a href=""><span class="span-1">Đồ điện tử</span></a>
                                <div class="dropdown-content">
                                    <a href=""><span class="span-2">Máy sấy tóc</a>
                                    <a href=""><span class="span-2">Điện thoại</a>
                                    <a href=""><span class="span-2">Laptop</a>
                                    <a href=""><span class="span-2">PC</a>
                                </div>
                            </div>
                        </li>
                        <br>

                        <li>
                            <div class="dropdown">
                                <a href=""><span class="span-1">Giày</span></a>
                                <div class="dropdown-content">
                                    <a href=""><span class="span-2">Giày sneaker</a>
                                    <a href=""><span class="span-2">Giày chạy</a>
                                    <a href=""><span class="span-2">Bussiness</a>
                                    <a href=""><span class="span-2">Boot</a>
                                </div>
                            </div>
                        </li>
                        <br>

                        <li>
                            <div class="dropdown">
                                <a href=""><span class="span-1">Quần áo</span></a>
                                <div class="dropdown-content">
                                    <a href=""><span class="span-2">Áo thun</a>
                                    <a href=""><span class="span-2">Áo khoác</a>
                                    <a href=""><span class="span-2">Quần jeans</a>
                                    <a href=""><span class="span-2">Quần shorts</a>
                                </div>
                            </div>
                        </li>


                    </ul>
                </div>

            </div>
            <div class="menu-bar">
                <div class="text-bar">
                    <a href="HomePage.jsp">

                        <span>Trang chủ</span>
                    </a>
                </div>
                <div class="text-bar">
                    <a href="">
                        <span>Sản phẩm mới nhất</span>
                    </a>
                </div>
                <div class="text-bar">
                    <a href="">
                        <span>Sản phẩm bán chạy nhất</span>
                    </a>
                </div>
            </div>
            <div class="display-book">
                <table style="width:100%; border:1px solid">		
                    <tr>
                        <th>Tên sản phẩm</th>
                        <th>Giá </th>
                        <th>Thao tác</th>
                    </tr>
                    <c:forEach items="${listBook}" var="item" varStatus="status">
                        <tr>
                            <td align="center">${item.name}</td>
                            <td align="center">${item.price}</td>
                            <td align="center"><form action="AddToCart" method="post">
                                    <input type="hidden" name="itemID" value="${item.id }"/>
                                    <input type="hidden" name="quantity" value="1" />
                                    <input type="hidden" name="accountID" value="<%=accountID%>" />
                                    <input type="hidden" name="cartID" value="<%=cartID%>" />
                                    <button type="submit" style="color:black; background-color:orange;border:1px solid orange"}>Select</button>
                                </form></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </main>
        <footer>
            <div class="main-content">
                <div class="left box">
                    <h2>
                        Địa chỉ</h2>
                    <div class="content">
                        <div class="place">
                            <span class="fas fa-map-marker-alt"></span>
                            <span class="text">PTIT, Hà Đông-Hà Nội</span>
                        </div>
                        <div class="phone">
                            <span class="fas fa-phone-alt"></span>
                            <span class="text">0123456789</span>
                        </div>
                        <div class="email">
                            <span class="fas fa-envelope"></span>
                            <span class="text">nguyenvana@gmail.com</span>
                        </div>
                    </div>

                </div>
                <div class="center box">
                    <iframe 
                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3725.3024241108965!2d105.78573631532709!3d20.980510994798752!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135accdd8a1ad71%3A0xa2f9b16036648187!2zSOG7jWMgdmnhu4duIEPDtG5nIG5naOG7hyBCxrB1IGNow61uaCB2aeG7hW4gdGjDtG5n!5e0!3m2!1svi!2s!4v1637076035857!5m2!1svi!2s" 
                        width="600" 
                        height="300" 
                        style="border:0;" 
                        allowfullscreen="" 
                        loading="lazy">

                    </iframe>
                </div>
                <div class="right box">
                    <iframe src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FHocvienPTIT&tabs=timeline&width=600&height=300&small_header=true&adapt_container_width=true&hide_cover=false&show_facepile=true&appId" 
                            width="600" 
                            height="300" 
                            style="border:none;overflow:hidden" 
                            scrolling="no" 
                            frameborder="0" 
                            allowfullscreen="true" 
                            allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share">

                    </iframe>
                </div>
            </div>
        </footer>
    </body>
</html>
