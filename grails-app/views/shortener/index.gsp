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
    <script>


        %{--function generateShortenURL(){--}%
            %{--var urlLarge = $('#largeUrl').val()--}%

                    %{--${remoteFunction(--}%
                            %{--controller: 'shortener',--}%
                            %{--action: 'shortenUrl',--}%
                            %{--update: 'shortenResult',--}%
                            %{--params: '\'largeUrl=\' + urlLarge'--}%
                    %{--)};--}%
        %{--}--}%

        function generateShortenURL(){
            var urlLarge = $('#largeUrl').val()
            <g:remoteFunction controller="shortener" action="" update="shortenResult" params="'largeUrl='+urlLarge"/>
        }



    </script>
</head>

<body>


    <div  style="text-align: center">
        %{--<g:form class="form-inline">--}%
            %{--<div class="form-group">--}%
                %{--<label>${message(code:"mainPage.form.label")}:  </label>--}%
                %{--<input type="url" class="form-control" id="largeUrl" name="largeUrl" placeholder="${message(code:"mainPage.form.urlField.placeHolder")}">--}%
            %{--</div>--}%
            %{--<button type="submit" class="btn btn-primary" onclick="generateShortenURL()">${message(code:"mainPage.form.button")}</button>--}%
            %{--<button type="submit" class="btn btn-primary" onclick="generateShortenURL()">${message(code:"mainPage.form.button")}</button>--}%
            %{--<button type="submit" class="btn btn-primary">${message(code:"mainPage.form.button")}</button>--}%


        %{--</g:form>--}%

        <g:formRemote class="form-inline" name="formShortenUrl" url="[controller:'shortener',action:'shortenUrl']" update="shortenResult">
            <div class="form-group">
                <label>${message(code:"mainPage.form.label")}:  </label>
                %{--<input type="url" class="form-control" id="largeUrl" name="largeUrl" placeholder="${message(code:"mainPage.form.urlField.placeHolder")}">--}%
                %{--<g:textField name="largeUrl" datatype="url" class="form-control" placeholder="${message(code:"mainPage.form.urlField.placeHolder")}"/>--}%
                <g:field type="url" name="largeUrl" class="form-control" placeholder="${message(code:"mainPage.form.urlField.placeHolder")}"/>
                <g:submitButton name="${message(code:"mainPage.form.button")}"/>
            </div>


            <div style="margin-top: 15%" id="shortenResult"/>
        </g:formRemote>

    </div>






</body>
</html>