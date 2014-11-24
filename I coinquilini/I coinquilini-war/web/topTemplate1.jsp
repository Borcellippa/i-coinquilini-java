<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.google.gson.Gson"%>
<% Gson gson = new Gson(); %>
<!DOCTYPE html>
<html>
    <head>
        <title><%=titolo %></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">

        <%@include  file="imports.html" %>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <%@include  file="header.html" %>
                <div class="col-md-2">
                    <%@include  file="sidemenu.html" %>
                </div>
                <div class="col-md-10">