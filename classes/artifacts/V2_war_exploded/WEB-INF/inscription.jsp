<%@ page import="com.exemple.bdd.entity.UtilisateurEntity" %>
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

<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">

    <div class="container align-content-center ">
        <div class="col item_inner logo">

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
                <span class="item_text">Messages</span>
            </a>
        </div>

        <%
            UtilisateurEntity user = (UtilisateurEntity) session.getAttribute(AuthentificationAbstract.ATT_SESSION_USER);
            if (user == null){
                out.print("<div class=\"item_inner col\">\n" +
                        "            <a href=\"connexion\">\n" +
                        "                        <span class=\"menu_icon_wrapper\">\n" +
                        "                            <i class=\"menu_icon blank fa\"></i>\n" +
                        "                        </span>\n" +
                        "                <span class=\"item_text\">Connexion</span>\n" +
                        "            </a>\n" +
                        "        </div>");
            }
            else{
                out.print("<div class=\"item_inner col\">\n" +
                        "            <a href=\"deconnexion\">\n" +
                        "                        <span class=\"menu_icon_wrapper\">\n" +
                        "                            <i class=\"menu_icon blank fa\"></i>\n" +
                        "                        </span>\n" +
                        "                <span class=\"item_text\">Deconnexion</span>\n" +
                        "            </a>\n" +
                        "        </div>");
            }
        %>
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
                    <label for="email" class="col">Email :</label>
                    <input type="text" class="form-control username" id="email" placeholder="email..." name="email" >
                    <span class="erreur col">${form.erreurs['email']}</span>
                </div>
                <div class="form-group form-inline">
                    <label for="motdepasse" class="col">Mot de passe:</label>
                    <input type="password" class="form-control mot de passe" id="motdepasse" placeholder="mot de passe..." name="motdepasse" >
                    <span class="erreur col">${form.erreurs['motdepasse']}</span>
                </div>
                <div class="form-group form-inline">
                    <label for="confirmation" class="col">Copie mot de passe:</label>
                    <input type="password" class="form-control " id="confirmation" placeholder="mot de passe..." name="confirmation" >
                    <span class="erreur col">${form.erreurs['confirmation']}</span>
                </div>
                <div class="form-group form-inline">
                    <label for="nom" class="col">Nom:</label>
                    <input type="text" class="form-control " id="nom" placeholder="Nom..." name="nom" >
                    <span class="erreur col">${form.erreurs['nom']}</span>
                </div>
                <div class="form-group form-inline">
                    <label for="prenom" class="col">Prenom:</label>
                    <input type="text" class="form-control " id="prenom" placeholder="Prenom..." name="prenom" >
                    <span class="erreur col">${form.erreurs['prenom']}</span>
                </div>
                <div class="container text-center">
                    <button type="submit" class=" btn btn-primary btn-radius btn-customized col-lg-4">Je valide</button>
                </div>
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