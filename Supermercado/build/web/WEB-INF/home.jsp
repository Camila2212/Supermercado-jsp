<%-- 
    Document   : home
    Created on : 8/11/2023, 8:11:36 a. m.
    Author     : camil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="public/dist/css/bootstrap.css"/>
        <script src="public/dist/js/bootstrap.js"></script>
    </head>
    <body>
          <jsp:include page="jspf/menu.jspf"></jsp:include>
         <div id="carrousel">
          <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner imgc">
              <div class="carousel-item active" data-bs-interval="10000">
                  <img src="public/img/Captura de pantalla 2023-03-21 073922.png" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                  <img src="public/img/Captura de pantalla 2023-03-21 074046.png" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item " data-bs-interval="10000">
                  <img src="public/img/Captura de pantalla 2023-03-21 074110.png" class="d-block w-100" alt="...">
              </div>

            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval"
              data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval"
              data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
    </body>
</html>
