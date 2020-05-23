<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Accueil</title>
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


    </div>


</nav>

<main role="main" class="container">
    <h1 class="text-center ">Panda Tech'</h1>
    <p class="lead mt-3">Bienvenue sur notre site web, nous sommes une association locale de passionné d'informatique,
        électronique, domotique,... et pleins de mots qui finissent en -ique, qui adoront partager nos
        connaissances.
        <br>
        L'industrie de l'électronique est un industrie extrêmement polluant, qui consomme énormémement d'énergie et
        de ressource,
        et sans connaissances des utilisateurs il est difficile d'éviter le gaspillages de ressources lors de
        l'utilisation des produits issus de cet industrie.
        <br>
        C'est pour éviter ce gaspillage que nous avons monter cette association, le but est d'aider à réparer et
        d'informer les utilisateurs sur les moyens de faire des économies et de conseillers les achats.
        Le tout dans un environnement conviviale, au sein de nos nombreux événements.
        <br>
        Nous avons à se jour organiser de nombreux événement pour réparer vos vieux téléphones,
        des ateliers de sensibilisations.
        <br>
        Le club Pandatech n'attends plus que vous...</p>

</main>


<footer class="footer align-content-center fixed-bottom ">
    <div class="container ">

        <div class="text-muted">Pandatech'© 2020</div>


    </div>
</footer>

</body>
</html>