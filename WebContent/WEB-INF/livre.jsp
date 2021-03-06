<%@ page import="com.exemple.servlets.abstrct.AuthentificationAbstract" %>
<%@ page import="com.exemple.bdd.entity.UtilisateurEntity" %><%--
        Created by IntelliJ IDEA.
        User: benji
        Date: 23/05/2020
        Time: 12:23
        To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Livre d'or</title>
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
            <a href="connexion">
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

    <div class="form-group align-items-center text-center">
        <form class="form-example"
              action="livre"
              method="post" >

            <label for="content" class="requis ">
                <h1 for="content ">Laisser votre message sur notre livre d'or ${utilisateur.nom} !</h1></label>
                <textarea type="text"
                       class="form-control  password"
                       id="content"
                       placeholder="Votre souvenir ..."
                       name="content"
                ></textarea>


            <button type="submit" value="avis" class="btn btn-primary btn-block btn-radius">

                Je laisse mon message
            </button>

        </form>
    </div>


</div>

<footer class="footer align-content-center fixed-bottom">
    <div class="container ">

        <div class="text-muted">Pandatech'© 2020</div>


    </div>
</footer>
</body>
</html>
