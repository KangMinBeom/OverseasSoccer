<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>연습용 페이지 입니다.</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<div class="container">
    <header class="d-flex justify-content-center py-3">
      <ul class="nav nav-pills">
        <li class="nav-item"><a href="#" class="nav-link" aria-current="page">프리미어리그</a></li>
        <li class="nav-item"><a href="#" class="nav-link">프리메라리그</a></li>
        <li class="nav-item"><a href="#" class="nav-link">분데스리가</a></li>
        <li class="nav-item"><a href="#" class="nav-link">세리에A</a></li>
        <li class="nav-item"><a href="#" class="nav-link active" aria-current="page">해외파 뉴스</a></li>
      </ul>
    </header>
  </div>
<body>
<table border="1">
                <td><a th:href="${new.title}" width="100"></td>
                <td><a th:href="${new.link}">[[${new.description}]]</a></td>
                <td>[[${new.pubdate}]]</td>
		</table>
</body>
</html>