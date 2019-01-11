<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.spring.dao.Users" %>
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


    <section id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 mx-auto">
            <form class="form-signin" action="/registration" method="post" >
                <center><h2 class="form-signin-heading">Register</h2></center>

                    <label for="inputEmail" class="sr-only">Login</label>
                    <input type="text" name="login" placeholder="Login" required class="form-control" id="inputEmail">
                    <label for="inputEmail" class="sr-only">Password</label>
                    <input type="text" name="password" placeholder="password" required class="form-control" id="inputEmail">
                    <br>
                    <center>
                    <select name="role">
                        <option value = "36">Admin</option>
                        <option value = "37">Cashier</option>
                    </select>
                    </center>
                    <br>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Registration</button>
            	
            	</form>

          </div>    
        </div>
      </div>
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
    