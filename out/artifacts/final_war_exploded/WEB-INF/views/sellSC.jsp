<%@ page import="com.spring.dao.Users" %>
<%@ page import="com.spring.dao.Items" %>
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
            <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/profile">Profile</a>
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

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">

          <h1 class="my-4">Final Project</h1>
          <div class="list-group">
            <a href="/home" class="list-group-item">Sell</a>
            <a href="/sell" class="list-group-item">Sell by UTC</a>
          </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="http://s46.radikal.ru/i111/1712/00/866dd1b183f6.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="http://s41.radikal.ru/i093/1712/96/9b8ee904c78f.jpg" alt="Second slide" style="weight:150px !important">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="http://s03.radikal.ru/i176/1712/42/76f4f1cb4337.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>


          <%
          if(user.getRoles().getName().equals("CASHIER"))
          {
          %>
          <form action="/sell1" method="post">
            <label for="inputEmail" class="sr-only">Universal product code</label>
            <input type="text" name="utc" placeholder="U_T_C" required class="form-control" id="inputEmail">
            <input type="number" name="number" required style="width: 350px;border-radius: 8px;margin-left:30px;margin-right: 50px">
            <input type="submit" class="btn btn-outline-primary" value="Sell">
          </form>
        <%
          }
          else {
              %>
          <br><br><br><br>
          <%
          }
        %>
        </div>

        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
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
