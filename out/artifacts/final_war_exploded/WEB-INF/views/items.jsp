<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.spring.dao.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="com.spring.dao.Items" %>
<%Users user = (Users)request.getSession().getAttribute("userData");%>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/scrolling-nav.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index">Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
              <ul class="navbar-nav ml-auto">
                  <li class="nav-item ">
                      <a class="nav-link" href="/home">Home

                      </a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="/profile">Profile
                          </a>

                  </li>
                  <%
                      if(user.getRoles().getName().equals("ADMIN")){

                  %>
                  <li class="nav-item">
                      <a class="nav-link" href="/reg">Registration</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="/addItem">Add Item</a>
                  </li>
                  <%
                      }
                  %>
                  <li class="nav-item">
                      <a class="nav-link" href="/logout">Log out</a>
                  </li>
              </ul>
          </div>
      </div>
    </nav>


    <section id="allUsers" class="bg-light">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <h1>ALL Items</h1><br>
                </div>
            </div>

            <div class="row">
                    <%

            List<Items> itemsList = (List<Items>)request.getAttribute("itemsList");
            int i = 1;
            if(null != itemsList){
            	for(Items u: itemsList){
                if(u.getId()!=user.getId()){
            %>
                <div class="col-8 mx-auto ">
                    <div class="card" style="width: 40rem;">
                        <div class="card-body justify-content-between">
                            <h4 class="card-title"><% out.print(u.getName()); %></h4>
                            <h6 class="card-subtitle mb-2 text-muted">
                                <span>Universal Product Code is <%out.print(u.getUpc());%></span>
                                <small>amounts of <%out.print(u.getAmounts());%></small>
                            </h6>

                            <p class="card-text">Price is <%out.print(u.getPrice());%> $</p>

                            <a href="/editI?id=<%=u.getId()%>" class="card-link">Edit Item</a>
                            <a href="/delI?id=<%=u.getId()%>" class="card-link">Delete Item</a>

                        </div>
                    </div>
                    <br>

                </div>
                    <%
                    }
        i++;
         		}
           	}
        %>

    </section>

   

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>



  </body>

</html>
    