<%--
  Created by IntelliJ IDEA.
  User: kelvi
  Date: 14/4/2024
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title><s:message code="editorial.editar"/></title>
    <jsp:include page="/WEB-INF/views/cabecera.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<div class="container">
    <div class="row">
        <h3><s:message code="editorial.editar"/></h3>
    </div>
    <div class="row">
        <div class=" col-md-7">
            <f:form action="${action}" method="POST"
                    modelAttribute="editorial">
                <f:errors path="*" element="div" cssClass="alert alert-danger" />
                <div class="well well-sm"><strong><span class="glyphicon
glyphicon-asterisk"></span><s:message code="requeridos"/></strong></div>
                <div class="form-group">
                    <label for="codigoEditorial"><s:message code="editorial.codigo"/></label>
                    <div class="input-group">
                        <f:input path="codigoEditorial" cssClass="form-control"
                                 readonly="true"/>
                        <span class="input-group-addon"><span class="glyphicon
glyphicon-asterisk"></span></span>
                    </div>
                    <f:errors path="codigoEditorial" cssClass="alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="nombreEditorial"><s:message code="editorial.nombre"/></label>
                    <div class="input-group">
                        <f:input path="nombreEditorial" cssClass="formcontrol"/>
                        <span class="input-group-addon"><span class="glyphicon
glyphicon-asterisk"></span></span>
                    </div>
                    <f:errors path="nombreEditorial" cssClass="alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="contacto"><s:message code="editorial.contacto"/></label>
                    <div class="input-group">
                        <f:input path="contacto" cssClass="form-control"/>
                        <span class="input-group-addon"><span class="glyphicon
glyphicon-asterisk"></span></span>
                    </div>
                    <f:errors path="contacto" cssClass="alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="telefono"><s:message code="editorial.telefono"/></label>
                    <div class="input-group">
                        <f:input path="telefono" cssClass="form-control"/>
                        <span class="input-group-addon"><span class="glyphicon
glyphicon-asterisk"></span></span>
                    </div>
                    <f:errors path="telefono" cssClass="alert-danger"/>
                </div>
                <f:button class="btn btn-info"><s:message code="guardar"/></f:button>
                <a class="btn btn-danger" href="<s:url
value="/editoriales/list"/>"><s:message code="cancelar"/></a>
            </f:form>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/pie.jsp"/>
</body>
</html>
