<!DOCTYPE html>
<html 
      xmlns:th="http://thymeleaf.org">
<head>
<link th:href="@{/css/test.css}" rel="stylesheet" />
<title> Student Registration LGN001 </title>
</head>
<body class="login-page-body"> 
  
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
            <p th:text="${param.error}" style="color: red;"	></p>
          </div>
        </div>
       <form action="#" th:action="@{/Login}" th:object="${user}" method="post">
      
       	<input type="text" placeholder="User ID" required="required" th:field = *{id} >
       
         <input type="password" placeholder="password" required="required" th:field = *{password} >
         
          <input type="submit" value="login">
          <p class="message">Not registered? <a href="#">Create an account</a></p>
        
        </form>
      </div>
    </div>
</body>

</html>