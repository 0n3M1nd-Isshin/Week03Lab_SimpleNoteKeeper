<%-- 
    Document   : editnote
    Created on : Oct 1, 2020, 2:31:46 PM
    Author     : 823280
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <form method="post" action="note">
            
            <h2>Edit Note</h2>
            
            <h3>Title: <input type="text" name="title" value="${first}"></h3>
             
            <h3>Contents: </h3>
            <textarea name="content" value="">${second}</textarea>
            <br>
            
            <input type="Submit" value="Save">
        </form>
    </body>
</html>
