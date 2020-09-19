<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        .error {
            color: red;
        }
    </style>
     <!-- Required meta tags -->
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
     <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>EmailSender</title>
</head>
<body>
    <div class="container">
        <h1>Send your email!</h1>
        <form:form action="${pageContext.request.contextPath}/process" method="POST" modelAttribute="sender">
            <form:errors path="email" cssClass="error" />
            <input type="text" name="email" placeholder="Your email" class="form-control">
            <br>
            <form:errors path="subject" cssClass="error"/>
            <input type="text" name="subject" placeholder="Subject" class="form-control">
            <br>
            <form:errors path="content" cssClass="error" />
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content"></textarea>
            <br>
            <input type="submit" value="Send" class="btn btn-primary mb-2">
        </form:form>
    </div>
</body>
</html>