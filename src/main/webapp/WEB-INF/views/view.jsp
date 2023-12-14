<%--
  Created by IntelliJ IDEA.
  User: gunmi
  Date: 2023-12-06
  Time: 오전 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        body{
            background-color:beige;
        }
    </style>
</head>
<body>

<main class="main">
    <div class="container">
        <br><h1 style="text-align: center;">View</h1><br>
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
                    <th>Playtime</th>
                    <th>Likes</th>
                    <th>RegDate</th>
                    <th>Dibs</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${post.getID()}</td>
                    <td>${post.getName()}</td>
                    <td>${post.getArtist()}</td>
                    <td>${post.getSongAmount()}</td>
                    <td>${post.getLikes()}</td>
                    <td>${post.getRegDate()}</td>
                    <c:choose>
                        <c:when test="${u.getDibs() eq true}">
                            <td>찜</td>
                        </c:when>
                        <c:when test="${u.getDibs() eq false}">
                            <td></td>
                        </c:when>
                    </c:choose>
                </tr>
                </tbody>
            </table>
            <div class="row">
                <div class="col-1 col-s-1">
                    <button class="btn btn-primary d-inline-flex align-items-center" type="button" onclick="history.back()">
                        Back
                    </button>
                </div><br>
            </div>
        </div>
    </div>
</body>
</html>