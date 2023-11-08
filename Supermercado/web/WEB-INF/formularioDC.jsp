<%-- 
    Document   : formularioDC
    Created on : 5/10/2023, 9:22:26 a. m.
    Author     : camil
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Detalle Compra</title>
    </head>
    <jsp:useBean id="unDC" class="modelo.DetalleC" scope="request" />
    <jsp:useBean id="unaF" class="modelo.FacturaComp" scope="request" />
    <jsp:useBean id="unP" class="modelo.Producto" scope="request" />


    <body class="miP">
        <jsp:include page="jspf/menu.jspf"></jsp:include>
            <div class="miDiv">
                <center class="miC"><h1 class="nt">Formulario Detalle Compra</h1></center> 

                <div class=" mit table-responsive ">
                    <style>
                        .table thead {
                            background-color: yellow;
                        }
                    </style>

                    <table border="1" class="table table-hover table-striped table-bordered ">
                        <thead> 
                            <tr>
                                <th>Cantidad</th>
                                <th>SubTotal</th>
                                <th>Producto</th>
                                <th>Id Factura</th>
                                <th></th>
                            </tr>
                        <thead> 
                        <tbody class="table-group-divider ">

                        <c:forEach items="${unDC.listar(0)}" var="elDC">
                        <tr class="table-light">

                        <form action="ControladorDC" method="post">
                            <td><input type="hidden" name="fIdDC" readonly value="${elDC.idDC}">
                                <input type="number" name="fCantidad" value="${elDC.cantidad}"></td>
                            <td><input type="number" name="fSubTotal" value="${elDC.subTotal}"></td>
                            <td>
                                <select name="fIdProd">

                                    <c:forEach items="${unP.listar(0)}" var="elProd">
                                        <option value="${elProd.idProd}" <c:if test="${elProd.idProd == elDC.idProd}" >
                                                Selected
                                            </c:if>>${elProd.nombre}                                     
                                        </option>
                                    </c:forEach> 
                                </select>
                            </td>

                            <td>
                                <select name="fIdF">

                                    <c:forEach items="${unaF.listar(0)}" var="laF">
                                        <option value="${laF.idF}" <c:if test="${laF.idF == elDC.idF}" >
                                                Selected
                                            </c:if>>${laF.idF}                                     
                                        </option>
                                    </c:forEach> 
                                </select>

                            </td>


                            <td> <button type="submit" name="fAccion" value="Eliminar" style="background: red; color: white"class="btn-sm  btn">
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
                    <form action="ControladorDC" method="post">
                        <td><input type="hidden" readonly name="fIdDC" value="0">
                            <input type="number" name="fCantidad"></td>
                        <td><input type="number" name="fSubTotal"></td>

                        <td>
                            <select name="fIdProd">
                                <option value="">Selecciona Producto</option> <!-- Opción fija -->
                                <c:forEach items="${unP.listar(0)}" var="elP">
                                    <option value="${elP.idProd}" <c:if test="${elP.idProd == elDC.idProd}">selected</c:if>>${elP.nombre}</option>
                                </c:forEach>
                            </select>


                        </td>
                        <td>
                            <select name="fIdF">
                                <option value="">Selecciona Factura</option> <!-- Opción fija -->
                                <c:forEach items="${unaF.listar(0)}" var="laF">
                                    <option value="${laF.idF}" <c:if test="${laF.idF == elDC.idF}">selected</c:if>>${laF.idF}</option>
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
                    </tr>
                  </tbody>
                </table>
               </div>
        </div>
                </body>
                </html>
