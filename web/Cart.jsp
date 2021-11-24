<%-- 
    Document   : Cart
    Created on : Nov 14, 2021, 9:23:26 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Giỏ hàng</title>
        <link rel="stylesheet" href="homeStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <style>
            <%@include file="/css/cart.css"%>
        </style>
        <style>
            <%@include file="/css/homeStyle.css"%>
        </style>
    </head>

    <body>
        <header>
            <%
                String accountID = null;
                String cartID = null;
                String customerID = null;
                Cookie[] cookies = request.getCookies();

                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("accountID")) {
                            accountID = cookie.getValue();
                        }
                        if (cookie.getName().equals("cartID")) {
                            cartID = cookie.getValue();
                        }
                        if (cookie.getName().equals("customerID")) {
                            customerID = cookie.getValue();
                        }
                    }
                }

                Cookie pathCookie = new Cookie("prePath", "Cart");
                response.addCookie(pathCookie);

            %>
            <!-- for logo page -->
            <div class="logo">
                <a href="<%=request.getContextPath()%>/Home">
                    <h1>
                        <span style="color:white">BTL-N5</span>

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
                    <form class="myform" action="CartServlet" method="post">
                        <button class="control-btn">
                            <i class="fa fa-shopping-cart fa-lg"></i>
                            <span>Giỏ hàng</span>
                        </button>
                    </form>
                </div>
                <!-- dropdown tai khoan -->
                <div class="dropdown">
                    <a href="LoginPage.jsp" class="tk">
                        <i class="fa fa-user-circle fa-lg"></i><span>Đăng ký/Đăng nhập</span>
                    </a>
                </div>
                <!-- end  dropdown tai khoan -->
            </div>
            <!-- end for nav bar -->
        </header>
        <!-- end header -->
        <main>
            <div class="nav-left">
                <div class="bar-1">
                    <a href="#"><i style="background-color: rgb(6, 104, 104);" class="fa fa-bookmark main-span"></i><span
                            class="main-span-1">Yêu thích</span></a>
                </div>
                <div class="bar-1">
                    <a href="#"><i style="background-color: rgb(233, 63, 51);" class="fa fa-bell main-span"></i><span
                            class="main-span-1">Thông báo</span></a>
                </div>
                <div class="bar-1">
                    <a href="#"><i style="background-color: rgb(162, 211, 26);" class="fa fa-gift main-span"
                                   aria-hidden="true"></i></i><span class="main-span-1">Quà tặng</span></a>
                </div>
                <div class="bar-1">
                    <a href="#"><i style="color: black;" class="fa fa-bars main-span"></i><span class="main-span-1">Danh sách</span></a>
                    <ul class="list">

                        <li>


                            <div class="dropdown">
                                <a href="<%=request.getContextPath()%>/BookPage"><span class="span-1">Sách</span></a>
                                <div class="dropdown-content">
                                    <a href="#"><span class="span-2">Văn học</a>
                                    <a href="#"><span class="span-2">Giáo dục</a>
                                    <a href="#"><span class="span-2">Khoa học - Công nghệ</a>
                                    <a href="#"><span class="span-2">Kinh tế</a>
                                </div>
                            </div>
                        </li>
                        <br>

                        <li>
                            <div class="dropdown">
                                <a href="#"><span class="span-1">Đồ điện tử</span></a>
                                <div class="dropdown-content">
                                    <a href="#"><span class="span-2">Máy sấy tóc</a>
                                    <a href="#"><span class="span-2">Điện thoại</a>
                                    <a href="#"><span class="span-2">Laptop</a>
                                    <a href="#"><span class="span-2">PC</a>
                                </div>
                            </div>
                        </li>
                        <br>

                        <li>
                            <div class="dropdown">
                                <a href="#"><span class="span-1">Giày</span></a>
                                <div class="dropdown-content">
                                    <a href="#"><span class="span-2">Giày sneaker</a>
                                    <a href="#"><span class="span-2">Giày chạy</a>
                                    <a href="#"><span class="span-2">Bussiness</a>
                                    <a href="#"><span class="span-2">Boot</a>
                                </div>
                            </div>
                        </li>
                        <br>

                        <li>
                            <div class="dropdown">
                                <a href="#"><span class="span-1">Quần áo</span></a>
                                <div class="dropdown-content">
                                    <a href="#"><span class="span-2">Áo thun</a>
                                    <a href="#"><span class="span-2">Áo khoác</a>
                                    <a href="#"><span class="span-2">Quần jeans</a>
                                    <a href="#"><span class="span-2">Quần shorts</a>
                                </div>
                            </div>
                        </li>


                    </ul>
                </div>

            </div>
            <div class="menu-bar">
                <div class="text-bar">
                    <a href="<%=request.getContextPath()%>/Home">

                        <span>Trang chủ</span>
                    </a>
                </div>
                <div class="text-bar">
                    <a href="#">
                        <span>Sản phẩm mới nhất</span>
                    </a>
                </div>
                <div class="text-bar">
                    <a href="#">
                        <span>Sản phẩm bán chạy nhất</span>
                    </a>
                </div>
            </div>
            <div id="display-cart">
                <div id="display-cart-1"><span><b>Giỏ hàng</b></span></div>
            </div>
            <div class="display-book">
                <table style="width:100%; border:1px solid">
                    <tr>
                        <th>Tên sản phẩm</th>
                        <th>Giá tiền</th>
                        <th>Số lượng</th>
                        <th>Thao tác</th>
                    </tr>
                    <c:forEach var="itemBook" items="${listItemBooks}">
                        <tr>
                            <td><c:out value="${itemBook.book.title}" /></td>
                            <td><c:out value="${itemBook.price}" /></td>
                            <td><c:out value="1" /></td>
                            <td><span class="click-del"> <button onclick="click_del_product()">Xóa</button></span></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>


            <div class="order-div">
                <div class="order">
                    <span style="padding-right: 100px;">Tổng tiền</span>
                    <span style="color: #fe3834;">
                        <c:out value="${totalPrice}" />
                    </span>
                </div>
                <div class="click-order">
                    <button id="open-form" onclick="document.getElementById('enter-inf-order').style.display = 'block';">Tiến
                        hành đặt hàng</button>
                </div>
            </div>
        </main>
        <%--
                <div id="enter-inf-order">
                    <div class="head-content">
                        <span>Thông tin đặt hàng</span>
                    </div>
                    <div class="turn-off">
                        <button onclick=" document.getElementById('enter-inf-order').style.display = 'none';">X</button>
                    </div>
                    <div class="enter-inf">
                        <div class="inf">
                            <form id="form-main" action="CreateOrder" method="post">
                                <div class="form-control">
                                    <div class="label">Tên người nhận</div>
                                    <div class="display">
                                        <input type="text" name="full-name">
                                    </div>
                                </div>
                                <div class="click-for-buy">
                                    <div>Tạm tính: <%out.println(request.getAttribute("totalAmount"));%>đ</div>
                                    <br>
                                    <div>Phí giao hàng: <span id="feeShip"></span>đ</div>
                                    <br>
                                    <input type="hidden" name="totalAmount" value="<%=request.getAttribute("totalAmount")%>">
                                    <div>Tổng giá: <span name = "totalPrice" id="totalPrice"><%out.println(request.getAttribute("totalAmount"));%>
                                        </span>
                                    </div>
                                    <br>
                                    <div class="form-control">
                                        <div class="display click-add">
                                            <button type="submit" style="float: left;">Đặt hàng</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-control">
                                    <div class="label">Số điện thoại</div>
                                    <div class="display">
                                        <input type="text" name="phone">
                                    </div>
                                </div>
                                <div class="form-control">
                                    <div class="label">Địa chỉ nhận</div>
                                    <div class="display">
                                        <input type="text" name="address"  value="<%=request.getAttribute("address")%>">
                                    </div>
                                </div>
                                <div class="form-control form-checkbox">
                                    <div class="label">Hình thức vận chuyển</div>
                                    <div class="display1">
                                        <input type="radio" name="type" onclick="document.getElementById('feeShip').innerHTML = '20000';
                                                document.getElementById('totalPrice').innerHTML = eval('<%=request.getAttribute("totalAmount")%>+20000');" value="1">
                                        <label for="">Giao hàng nhanh</label>
                                        <br>
                                        <input type="radio" name="type" onclick="document.getElementById('feeShip').innerHTML = '10000';
                                                document.getElementById('totalPrice').innerHTML = eval('<%=request.getAttribute("totalAmount")%>+10000');" value="2">
                                        <label for="">Giao trong ngày</label>
                                        <br>
                                        <input type="radio" name="type" onclick="document.getElementById('feeShip').innerHTML = '5000';
                                                document.getElementById('totalPrice').innerHTML = eval('<%=request.getAttribute("totalAmount")%>+5000');" value="1">
                                        <label for="">Giao tiêu chuẩn</label>
                                    </div>
                                </div>
                            </form>
                        </div>    		
                    </div>
                </div>
        --%>
        <%-- 
                <script>
                    function click_del_product() {
                        document.getElementById("book-1").style.display = "none";
                    }
                    function setShipFee(name) {
                        debugger;
                        if (name == "1") {
                            document.getElementById("feeShip").text = "20000";
                            document.getElementById("totalPrice").innerHTML = eval("20000");
                        } else if (name == "2") {
                            document.getElementById("feeShip").text = "10000";
                            document.getElementById("totalPrice").innerHTML = eval("10000");
                        } else {
                            document.getElementById("feeShip").text = "5000";
                            document.getElementById("totalPrice").innerHTML = eval("5000");
                        }
                    }
                    function display - form() {
                        document.getElementById("enter-inf-order").style.display = "block";
                    }
                </script>
        --%> 
    </body>

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
                    width="500" 
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
</html>
