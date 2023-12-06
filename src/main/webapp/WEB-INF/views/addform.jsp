<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Insert title here</title>
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
</head>
<body>
<main class="main">
    <div class="container">
        <br><h1 style="text-align: center;">Add New Post</h1><br>
    </div>
    <div class="row">
        <div class="col-2 col-s-1"></div>
        <div class="col-8 col-s-10 table-responsive small">
            <form name="add" action="addok" method="post" onsubmit="return validateForm()">
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-12 col-md-offset-3">
                        <input type="text" class="form-control" name="Name">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Artist</label>
                    <div class="col-sm-12 col-md-offset-3">
                        <input type="text" class="form-control" name="Artist">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">SongAmount</label>
                    <div class="col-sm-12 col-md-offset-3">
                        <input type="text" class="form-control" name="SongAmount">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Likes</label>
                    <div class="col-sm-12 col-md-offset-3">
                        <input type="text" class="form-control" name="Likes">
                    </div>
                </div>
                <div class="row">
                    <div class="col-3 col-s-9">
                        <button class="btn btn-primary d-inline-flex align-items-center" type="button" onclick="location.href='posts'">
                            View All Records
                        </button>
                    </div>
                    <div class="col-2 col-s-1">
                        <button class="btn btn-primary d-inline-flex align-items-center" type="submit" >
                           Add Post
                        </button>
                    </div><br>
                </div>
            </form>
            <script>
                function validateForm() {
                    var Name = document.add.Name;
                    if (Name.value == '') {
                        alert("이름을 입력하세요");
                        Name.focus();
                        return false;
                    }

                    var Artist = document.add.Artist;
                    if (Artist.value == '') {
                        alert("작곡가를 입력하세요");
                        Artist.focus();
                        return false;
                    }

                    var SongAmount = document.add.SongAmount;
                    if (SongAmount.value == '') {
                        alert("재생시간을 입력하세요");
                        SongAmount.focus();
                        return false;
                    }

                    var Likes = document.add.Likes;
                    if (Likes.value == '') {
                        alert("좋아요 수를 입력하세요");
                        Likes.focus();
                        return false;
                    }
                }
            </script>
        </div>
    </div>
</main>

</body>
</html>