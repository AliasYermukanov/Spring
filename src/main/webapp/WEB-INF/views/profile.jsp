<%@ page import="com.spring.dao.Users" %>
<%@ page import="com.spring.dao.History" %>
<%@ page import="java.util.List" %>
<%Users user = (Users)request.getSession().getAttribute("userData");%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop </title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-homepage.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
              <ul class="navbar-nav ml-auto">
                  <li class="nav-item ">
                      <a class="nav-link" href="/home">Home

                      </a>
                  </li>
                  <li class="nav-item active">
                      <a class="nav-link" href="/profile">Profile
                          <span class="sr-only">(current)</span></a>

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
    
      <br><br><br>
     <div class="container1">    
                <div class="jumbotron">
                  <div class="row">
                      <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                          <img src="https://www.svgimages.com/svg-image/s5/man-passportsize-silhouette-icon-256x256.png" alt="stack photo" class="img">
                      </div>
                      <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
                          <div class="container" style="border-bottom:1px solid black">
                            <h2><%out.print(user.getLogin());%></h2>
                          </div>
                            <hr>
                              <%
                                  if(user!=null){
                              %>
                          <ul class="container details">

                            <li><p><span class="glyphicon glyphicon-earphone one" style="width:50px;"></span>Login:<%out.print(user.getLogin());%></p></li>
                            <li><p><span class="glyphicon glyphicon-envelope one" style="width:50px;"></span>Position:<%out.print(user.getRoles().getName());%></p></li>
                              <li><p><span class="glyphicon glyphicon-new-window one" style="width:50px;"></span><a href="/updateProfile">Change Profile</a></p></li>

                              <%
                                  if(user.getRoles().getName().equals("ADMIN")){

                              %>
                              <li><p><span class="glyphicon glyphicon-new-window one" style="width:50px;"></span><a href="/users">List all Users</a></p></li>
                              <li><p><span class="glyphicon glyphicon-new-window one" style="width:50px;"></span><a href="/items">List all Items</a></p></li>

                              <%
                                  }
                                  else{
                                      %><li><p><span class="glyphicon glyphicon-new-window one" style="width:50px;"></span>History:</p></li><%
                                      List<History> histories = (List<History>)request.getAttribute("histories");
                                      if(null != histories) {
                                          for (History h : histories) {
                                              if(h.getUsers().getId().equals(user.getId())){
                              %>

                              <li><p><span class="glyphicon glyphicon-new-window one" style="width:50px;"></span>Sell <%out.print(h.getAmount());%> of <%out.print(h.getItems().getName());%> for total of <%out.print(h.getAmount()*h.getItems().getPrice());%> $, in <%out.print(h.getTimestamp());%></p></li>
                              <%
                                      }}}
                                  }
                              %>
                          </ul>
                          <%
                              }
                          %>
                      </div>
                  </div>
                </div>

        <style>
          .details li {
      list-style: none;
    }
    li {
        margin-bottom:10px;
        
    }
         </style>
        <br><br><br><br>
    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="jquery/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

  </body>

</html>
