<%--
  Created by IntelliJ IDEA.
  User: benji
  Date: 05/05/2020
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="inc/form.css" />
</head>
<body>

<title> Boucle de 1 à 10 </title>


    <c:forEach var = "table" items="${table.toArray()}"  >
        <li><c:out value="${table}"/></li>


    </c:forEach>

        </body>
</html>
