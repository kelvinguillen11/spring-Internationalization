<%--
  Created by IntelliJ IDEA.
  User: kelvi
  Date: 7/5/2024
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title><s:message code="libro.nuevo"/></title>
  <jsp:include page="/WEB-INF/views/cabecera.jsp"/>
  <link
          href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.c
ss" rel="stylesheet" />
  <script
          src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"
  ></script>
</head>
<body>
<div class="container">
  <div class="row">
    <h3><s:message code="libro.nuevo"/></h3>
  </div>
  <div class="row">
    <div class=" col-md-7">
      <f:form action="create" method="POST"  modelAttribute="libro">
        <f:errors path="*" element="div" cssClass="alert alert-danger" />
        <div class="well well-sm"><strong><span class="glyphicon
glyphicon-asterisk"></span><s:message code="requeridos"/></strong></div>
        <div class="form-group">
          <label for="codigoLibro"><s:message code="libro.codigo"/></label>
          <div class="input-group">
            <f:input path="codigoLibro" cssClass="form-control"/>
            <span class="input-group-addon"><span
                    class="glyphicon glyphicon-asterisk"></span></span>
          </div>
          <f:errors path="codigoLibro" cssClass="aler alert-danger"/>
        </div>
        <div class="form-group">
          <label for="nombreLibro"><s:message code="libro.nombre"/></label>
          <div class="input-group">
            <f:input path="nombreLibro" cssClass="form-control"/>
            <span class="input-group-addon"><span
                    class="glyphicon glyphicon-asterisk"></span></span>
          </div>
          <f:errors path="nombreLibro" cssClass="aler alert-danger"/>
        </div>
        <div class="form-group">
          <label for="existencias"><s:message code="libro.existencias"/></label>
          <div class="input-group">
            <f:input path="existencias" cssClass="form-control"/>
            <span class="input-group-addon"><span
                    class="glyphicon glyphicon-asterisk"></span></span>
          </div>
          <f:errors path="existencias" cssClass="aler alert-danger"/>
        </div>
        <div class="form-group">
          <label for="precio"><s:message code="libro.precio"/></label>
          <div class="input-group">
            <f:input path="precio" cssClass="form-control"/>
            <span class="input-group-addon"><span
                    class="glyphicon glyphicon-asterisk"></span></span>
          </div>
          <f:errors path="precio" cssClass="aler alert-danger"/>
        </div>
        <div class="form-group">
          <label for="autoresByCodigoAutor.codigoAutor"><s:message code="libro.Autor"/></label>
          <div class="input-group">
            <f:select path="autoresByCodigoAutor.codigoAutor"
                      cssClass="form-control">
              <f:options items="${listaAutores}"
                         itemLabel="nombreAutor"
                         itemValue="codigoAutor"/>
            </f:select>
            <span class="input-group-addon"><span
                    class="glyphicon glyphicon-asterisk"></span></span>
          </div>
          <f:errors path="autoresByCodigoAutor.codigoAutor" cssClass="aler alert-danger"/>
        </div>
        <div class="form-group">
          <label
                  for="editorialesByCodigoEditorial.codigoEditorial"><s:message code="libro.editorial"/></label>
          <div class="input-group">
            <f:select
                    path="editorialesByCodigoEditorial.codigoEditorial" cssClass="form-control">
              <f:options items="${listaEditoriales}"
                         itemLabel="nombreEditorial"
                         itemValue="codigoEditorial"/>
            </f:select>
            <span class="input-group-addon"><span
                    class="glyphicon glyphicon-asterisk"></span></span>
          </div>
          <f:errors path="editorialesByCodigoEditorial.codigoEditorial" cssClass="aler alert-danger"/>
        </div>
        <div class="form-group">
          <label for="generosByIdGenero.idGenero"><s:message code="libro.genero"/></label>
          <div class="input-group">
            <f:select path="generosByIdGenero.idGenero"
                      cssClass="form-control">
              <f:options items="${listaGeneros}"
                         itemLabel="nombreGenero"
                         itemValue="idGenero"/>
            </f:select>
            <span class="input-group-addon"><span
                    class="glyphicon glyphicon-asterisk"></span></span>
          </div>
          <f:errors path="generosByIdGenero.idGenero" cssClass="aler alert-danger"/>
        </div>
        <div class="form-group">
          <label for="descripcion"><s:message code="libro.descripcion"/></label>
          <div class="input-group">
            <f:textarea path="descripcion"
                      cssClass="form-control" rows="4" cols="50" />
            <span class="input-group-addon"><span
                    class="glyphicon glyphicon-asterisk"></span></span>
          </div>
          <f:errors path="descripcion" cssClass="aler alert-danger"/>
        </div>
        <f:button class="btn btn-info"><s:message code="guardar"/></f:button>
        <a class="btn btn-danger" href="<s:url
value="/libros/list"/>"><s:message code="cancelar"/></a>
      </f:form>
    </div>
  </div>
</div>
<script>
  $('#autor').select2();
</script>
<jsp:include page="/WEB-INF/views/pie.jsp"/>
</body>
</html>
