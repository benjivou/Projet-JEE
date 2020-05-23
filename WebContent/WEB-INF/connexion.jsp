<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Connexion</title>
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
<div class=" main container ">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-10 col-md-8 col-lg-6">
            <!-- Form -->
            <form class="form-example" action="" method="post" >
                <h1 class="text-center">Connexion</h1>
                <p class="description">Merci pour votre retour sur votre expérience </p>
                <!-- Input fields -->
                <div class="form-group form-inline ">
                    <label for="email" class="col">Email :</label>
                    <input type="text" class="form-control username" id="email" placeholder="email..." name="email" >

                </div>
                <div class="form-group form-inline">
                    <label for="mot de passe" class="col">Mot de passe:</label>
                    <input type="mot_de_passe" class="form-control mot de passe" id="mot_de_passe" placeholder="mot de passe..." name="mot de passe" >
                </div>

                <div class="container text-center ">

                <button type="submit" class=" btn btn-primary btn-radius btn-customized col-lg-4">Connexion</button>

                </div>

            </form>
            <!-- Form end -->
        </div>
    </div>


</div>

</body>
</html>