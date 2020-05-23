<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Inscription</title>
    <link type="text/css" rel="stylesheet" href="inc/form.css"/>
    <style>
        <%@ include file="../inc/form.css"%>
        <%@include file="../inc/bootstrap-4.5.0-dist/css/bootstrap.css" %>

    </style>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script>
        <%@ include file="../inc/bootstrap-4.5.0-dist/js/bootstrap.js"%>
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="container align-items-center ">
        <div class="col item_inner logo text-center">

            PandaTech'
        </div>
        <div class="col item_inner">
            <a href="accueil">
                        <span class="menu_icon_wrapper">
                            <i class="menu_icon blank fa"></i>
                        </span>
                <span class="item_text">Home</span>
            </a>
        </div>

        <div class="item_inner col">
            <a href="livre">
                <span class="menu_icon_wrapper">
                    <i class="menu_icon blank fa"></i>
                </span>
                <span class="item_text">Livre d'or</span>
            </a>
        </div>
        <div class="item_inner col">
            <a href="inscription">
                        <span class="menu_icon_wrapper">
                            <i class="menu_icon blank fa"></i>
                        </span>
                <span class="item_text">S'inscrire</span>
            </a>
        </div>
        <div class="item_inner col">
            <a href="message">
                        <span class="menu_icon_wrapper">
                            <i class="menu_icon blank fa"></i>
                        </span>
                <span class="item_text">Laisser un message</span>
            </a>
        </div>


    </div>


</nav>

<div class=" main container ">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-10 col-md-8 col-lg-6">
            <!-- Form -->
            <form class="form-example" action="" method="post" >
                <h1 class="text-center">S'inscrire</h1>
                <p class="description">Vous étes à 2 cliques de nous rejoindre</p>
                <!-- Input fields -->
                <div class="form-group form-inline ">
                    <label for="username" class="col">Email :</label>
                    <input type="text" class="form-control username" id="username" placeholder="Username..." name="username" >

                </div>
                <div class="form-group form-inline">
                    <label for="password" class="col">Mot de passe:</label>
                    <input type="password" class="form-control password" id="password" placeholder="Password..." name="password" >
                </div>
                <div class="form-group form-inline">
                    <label for="password" class="col">Copie mot de passe:</label>
                    <input type="password" class="form-control password" id="password" placeholder="Password..." name="password" >
                </div>
                <div class="form-group form-inline">
                    <label for="nom" class="col">Nom:</label>
                    <input type="text" class="form-control password" id="nom" placeholder="Nom..." name="nom" >
                </div>
                <button type="submit" class="btn btn-primary btn-customized align-items-center col">Login</button>


            </form>
            <!-- Form end -->
        </div>
    </div>


</div>

<footer class="footer align-content-center fixed-bottom">
    <div class="container ">

        <div class="text-muted">Pandatech'© 2020</div>


    </div>
</footer>
</body>
</html>