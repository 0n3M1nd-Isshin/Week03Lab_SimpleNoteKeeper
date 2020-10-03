<%-- 
    Document   : viewnote
    Created on : Oct 1, 2020, 2:31:27 PM
    Author     : 823280
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <form method="post" action="note">
            
            <h2>View Note</h2>
            
            <h3>Title: </h3> <p>${title}</p>
            
            <h3>Contents: </h3> <p>${content}</p>
            <br>
            
            <a href="note?edit">Edit</a>
        </form>
        
    </body>
</html>
