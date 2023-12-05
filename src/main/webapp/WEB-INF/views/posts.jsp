<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.example.dao.AlbumDAO, com.example.bean.AlbumVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>free board</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        @media only screen and (min-width: 600px) {
            .col-s-1 {width: 8.33%;}
            .col-s-2 {width: 16.66%;}
            .col-s-3 {width: 25%;}
            .col-s-4 {width: 33.33%;}
            .col-s-5 {width: 41.66%;}
            .col-s-6 {width: 50%;}
            .col-s-7 {width: 58.33%;}
            .col-s-8 {width: 66.66%;}
            .col-s-9 {width: 75%;}
            .col-s-10 {width: 83.33%;}
            .col-s-11 {width: 91.66%;}
            .col-s-12 {width: 100%;}
        }
        @media only screen and (min-width: 768px) {
            .col-1 {width: 8.33%;}
            .col-2 {width: 16.66%;}
            .col-3 {width: 25%;}
            .col-4 {width: 33.33%;}
            .col-5 {width: 41.66%;}
            .col-6 {width: 50%;}
            .col-7 {width: 58.33%;}
            .col-8 {width: 66.66%;}
            .col-9 {width: 75%;}
            .col-10 {width: 83.33%;}
            .col-11 {width: 91.66%;}
            .col-12 {width: 100%;}
        }
        body{
            background-color:beige;
        }
    </style>
    <script>
        function delete_ok(id){
            var a = confirm("정말로 삭제하겠습니까?");
            if(a) location.href='deletepost.jsp?ID=' + id;
        }
    </script>
</head>
<body>
<main class="main">
    <div class="container">
        <br><h1 style="text-align: center;">ALBUM List</h1><br>
    </div>
    <div class="row">
        <div class="col-2 col-s-1"></div>
        <div class="col-8 col-s-10 table-responsive small">
            <table id="list" width="90%" class="table table-striped table-sm">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Artist</th>
                    <th>SongAmount</th>
                    <th>Likes</th>
                    <th>View</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${posts}" var="u">
                    <tr>
                        <td>${u.getID()}</td>
                        <td>${u.getName()}</td>
                        <td>${u.getArtist()}</td>
                        <td>${u.getSongAmount()}</td>
                        <td>${u.getLikes()}</td>
                        <td><a href="view.jsp?ID=${u.getID()}">View</a></td>
                        <td><a href="editform.jsp?ID=${u.getID()}">Edit</a></td>
                        <td><a href="javascript:delete_ok('${u.getID()}')">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%--<br/><a href="addpostform.jsp">Add New Post</a>--%>
    <br/>
    <div class="d-flex gap-2 justify-content-center">
        <button class="btn btn-primary d-inline-flex align-items-center" type="button" onclick="location.href='addpostform.jsp'">
            Add New Post
        </button>
    </div>
</main>
</body>
</html>