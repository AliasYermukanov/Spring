<%@ page import="com.spring.dao.Users" %>
<html>
<head>
    <title>Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/scrolling-nav.css" rel="stylesheet">
    <link href="css/sign.css" rel="stylesheet">



</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index">Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
        </div>
    </div>
</nav>
<br><br><br><br><br><br>
<div class="container">
    <form class="form-signin" method="post" action="/auth">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name="login" placeholder="e-mail" required class="form-control" id="inputEmail">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name = "password" required class="form-control" id="inputPassword" placeholder="Password">
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>


    </form>
</div>

</body>
</html>
