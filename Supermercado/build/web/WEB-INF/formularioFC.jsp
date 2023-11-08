<%-- 
    Document   : formularioFC
    Created on : 4/10/2023, 4:39:41 p. m.
    Author     : camil

--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="public/app.css"/>
        <link rel="stylesheet" href="public/dist/css/bootstrap.css"/>

        <title>Formulario Factura Compra</title>



    </head>
    <jsp:useBean id="unaFC" class="modelo.FacturaComp" scope="request" />
    <jsp:useBean id="unAdmin" class="modelo.Administrador" scope="request" />
    <jsp:useBean id="unProv" class="modelo.Proveedor" scope="request" />


    <body class="miP">

        <jsp:include page="jspf/menu.jspf"></jsp:include>
            <div class="miDiv">

                <center class="miC"><h1 class="nt">Formulario Factura Compra</h1></center> 
                <div class=" mit table-responsive ">
                    <style>
                        .table thead {
                            background-color: yellow;
                        }
                    </style>

                    <table border="1" class="table table-hover table-striped table-bordered ">
                        <thead>
                            <tr class="miTr">
                                <th>Descuento</th>
                                <th>Descripcion</th>
                                <th>Fecha</th>
                                <th>Total</th>
                                <th>Administrador</th>
                                <th>Proveedor</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider ">
                        <c:forEach items="${unaFC.listar(0)}" var="laFC">
                            <tr class="table-light">
                        <form action="ControladorFC" method="post">
                            <td><input type="hidden" name="fIdF" value="${laFC.idF}">
                                <input type="number" name="fDtoF" value="${laFC.dtoF}"></td>
                            <td><input type="text" name="fDescripcion" value="${laFC.descripcion}"></td>
                            <td><input type="date" name="fFechaF" value="${laFC.fechaF}"></td>
                            <td><input type="number" name="fTotalF" value="${laFC.totalF}"></td>
                            <td>
                                <select name="fIdAdmin">

                                    <c:forEach items="${unAdmin.listar(0)}" var="elAdmin">
                                        <option value="${elAdmin.idAdmin}" <c:if test="${elAdmin.idAdmin == laFC.idAdmin}" >
                                                Selected
                                            </c:if>>${elAdmin.nombre}                                    
                                        </option>
                                    </c:forEach> 
                                </select>
                            </td>
                            <td>
                                <select name="fIdProv">

                                    <c:forEach items="${unProv.listar(0)}" var="elProv">
                                        <option value="${elProv.idProv}" <c:if test="${elProv.idProv == laFC.idProv}" >
                                                Selected
                                            </c:if>>${elProv.nombre}                                     
                                        </option>
                                    </c:forEach> 
                                </select>
                            </td>


                            <td> 
                                <button type="submit" name="fAccion" value="Eliminar" style="background: red; color: white"class="btn-sm  btn">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
                                    <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
                                    </svg>
                                </button>


                                <button type="submit" name="fAccion" value="Modificar" class="btn btn-sm btn-primary">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                    </svg>
                                </button>
                            </td>

                        </form>
                        </tr>
                    </c:forEach> 

                    <tr>
                    <form action="ControladorFC" method="post">
                        <td><input type="hidden" name="fIdF" value="0">
                            <input type="number" name="fDtoF"></td>
                        <td><input type="text" name="fDescripcion"></td>
                        <td><input type="date" name="fFechaF"></td>
                        <td><input type="number" name="fTotalF"></td>
                        <td>
                            <select name="fIdAdmin">
                                <option value="">Selecciona Administrador</option> <!-- Opción fija -->
                                <c:forEach items="${unAdmin.listar(0)}" var="elAdmin">
                                    <option value="${elAdmin.idAdmin}" <c:if test="${elAdmin.idAdmin == laFC.idAdmin}">selected</c:if>>${elAdmin.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>

                        <td>
                            <select name="fIdProv">
                                <option value="">Selecciona Proveedor</option> <!-- Opción fija -->
                                <c:forEach items="${unProv.listar(0)}" var="elProv">
                                    <option value="${elProv.idProv}" <c:if test="${elProv.idProv == laFC.idProv}">selected</c:if>>${elProv.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><button type="submit" name="fAccion" value="Insertar" class="btn btn-sm btn-primary">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                                </svg></button>
                            <button type="reset" name="fAccion" value="Limpiar" style=" color: white "class="  btn btn-secondary btn-sm">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-backspace-fill" viewBox="0 0 16 16">
                                <path d="M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z"/>
                                </svg></button></td>
                    </form>
                    </tr></tbody>


                </table>
            </div>
        </div>
    </body>
</html>

