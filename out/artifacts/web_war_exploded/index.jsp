<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ABC Delivery</title>
  </head>
  <body>
    <h1>ABC Delivery API System</h1>
    <br>
    <p><span style="font-size: 25px; font-weight: bold;">/user</span> -> Post a new user (POST API): All USER attributes is param </p>
    <p><span style="font-size: 25px; font-weight: bold;">/user</span> -> Get all users (GET API)</p>
    <br>
    <p><span style="font-size: 25px; font-weight: bold;">/order</span> -> Post an order for a user (POST API): All Order attributes and user id are params</p>
    <p><span style="font-size: 25px; font-weight: bold;">/order</span> -> Get all orders for a user (GET API): User id is param</p>
    <p><span style="font-size: 25px; font-weight: bold;">/order</span> -> Update a particular order for a user (PUT API): User id and order id are params</p>
    <p><span style="font-size: 25px; font-weight: bold;">/order</span> -> Delete a particular order for a user (DELETE API): User id and order id are params</p>
  </body>
</html>