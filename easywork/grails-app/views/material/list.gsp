
<%@ page import="cn.easywork.Material" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'material.label', default: 'Material')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'material.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'material.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="price" title="${message(code: 'material.price.label', default: 'Price')}" />
                        
                            <g:sortableColumn property="unit" title="${message(code: 'material.unit.label', default: 'Unit')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${materialInstanceList}" status="i" var="materialInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${materialInstance.id}">${fieldValue(bean: materialInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: materialInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: materialInstance, field: "price")}</td>
                        
                            <td>${fieldValue(bean: materialInstance, field: "unit")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${materialInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
