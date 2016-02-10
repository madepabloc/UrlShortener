<%--
  Created by IntelliJ IDEA.
  User: migdepcas
  Date: 8/02/16
  Time: 20:54
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta name="layout" content="main">

</head>

<body>


    <div  style="text-align: center">

        <g:formRemote class="form-inline" name="formShortenUrl" url="[controller:'shortener',action:'shortenUrl']" update="shortenResult">
            <div class="form-group">
                <label>${message(code:"mainPage.form.label")}:  </label>
                <g:field type="url" name="largeUrl" class="form-control" placeholder="${message(code:"mainPage.form.urlField.placeHolder")}"/>
                <g:submitButton  class="btn btn-primary" name="${message(code:"mainPage.form.button")}"/>
            </div>


            <div style="margin-top: 15%" id="shortenResult"/>
        </g:formRemote>

    </div>






</body>
</html>