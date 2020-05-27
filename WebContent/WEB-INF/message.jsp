<%--
  Created by IntelliJ IDEA.
  User: benji
  Date: 23/05/2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Message</title>
    <link type="text/css" rel="stylesheet" href="inc/form.css"/>
    <style>
        <%@ include file="../inc/form.css"%>
        <%@include file="../inc/bootstrap-4.5.0-dist/css/bootstrap.css" %>

    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script>
        <%@ include file="../inc/bootstrap-4.5.0-dist/js/bootstrap.js"%>
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

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


    </div>


</nav>

<div class=" main container ">

    <h1>Notre tops 3 commentaires :</h1>
    <div class="row ">
        <c:forEach items="${topcommentaire}" var="i" varStatus = "status">


                <div class="card col">
                    <div class="card-body text-center">

                            <p class="card-text col">${i.key.content}</p>


                        <c:if test="${i.value == true}">
                            <form action="message" method="post">
                                <button

                                        type="submit"
                                        class="btn btn-primary btn-lg"
                                        name="id"
                                        value="${i.key.idCommentaire}"
                                >
                                    <span class="fa fa-thumbs-up fa-lg"></span>
                                </button>
                            </form>
                        </c:if>


                        </div>
                    <p class="card-footer text-muted"> Like : ${i.key.likes} </p>

                </div>

        </c:forEach>


    </div>
    <h1>Nos commentaires :</h1>
    <div class="row ">
    <c:forEach items="${commentaire}" var="i" varStatus = "status">


        <div class="card col">
            <div class="card-body text-center">

                    <p class="card-text col">${i.key.content}</p>

                    <c:if test="${i.value == true}">
                        <form action="message" method="post">
                            <button
                                    
                                    type="submit"
                                    class="btn btn-primary btn-lg"
                                    name="id"
                                    value="${i.key.idCommentaire}"
                            >
                                <span class="fa fa-thumbs-up fa-lg"></span>
                            </button>
                        </form>
                    </c:if>




            </div>
            <p class="card-footer text-muted"> Like : ${i.key.likes} </p>

        </div>

    </c:forEach>


</div>

</div>

<footer class="footer align-content-center fixed-bottom">
    <div class="container ">

        <div class="text-muted">Pandatech'© 2020</div>


    </div>
</footer>
</body>
</html>
