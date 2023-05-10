<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<style>
.wrap {
   width: 490px;
   padding: 40px 20px 20px 20px;
   background-color: #f5f6f7;
   position: absolute;
   top: 50%;
   left: 50%;
   transform: translate(-50%,-50%);
   border-radius: 30px;
   box-sizing: border-box;
}

.title {
   margin: 0 auto;
    width: 240px;
    height: 44px;
    text-align: center;
    font-size: 25px;
    background-repeat: no-repeat;
    background-position: 0 0;
    background-size: 240px auto;
    margin-bottom: 20px;
}
.kakao{
   margin-top: 15px;
   height: 60px;
   border: solid 1px #FEE500;
   background: #FEE500;
   color: #3c1d1e;
   font-size: 18px;
   box-sizing: border-box;
   border-radius: 5px;
   cursor: pointer;
   width: 450px;
   display: flex;
}
.kakao_i{
   background: url(resources/icons/kakao.png) no-repeat;
   width: 40px;
   height: 100%;
   background-size: 90%;
   background-position: 50%;
   margin: 0 20px;
}
.kakao_txt{
   width: 100%;
   display: flex;
   justify-content: center;
   align-items: center;
   font-size: 16px;
   padding-right: 60px;
}

a {
   text-decoration: none;
}

</style>
<body>
<div class="wrap">
   <div class="title">로그인</div>
     <a href="https://kauth.kakao.com/oauth/authorize?client_id=2fcce12357e1fae7091bdec3ef9261b7&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code"><img src="/image/kakao_login_medium_narrow.png"/></a>
   	</a>
</div>
</body>
</html>