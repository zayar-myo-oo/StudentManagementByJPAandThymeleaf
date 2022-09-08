<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">

<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link th:href="@{/css/test.css}" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    
        <title>Course Registration</title>
</head>

<body>
    <div id="testheader">
        <div class="container">
            <div class=row>        
                <div class="col-md-5 ">
            <a href="MNU001.jsp"><h3>Student Registration</h3></a>
        </div>  
        <div class="col-md-6">
            User:<span th:text="${session.login.id}"></span><span th:text="${session.login.name}"></span>
            <br>
            Date :<span th:text="${session.date}"></span>
        </div>  
        <div class="col-md-1" >
            <input type="button" class="btn-basic" id="lgnout-button" value="Log Out" onclick="location.href='/Logout'">
        </div>        
    </div>
</div>

</div>
    <!-- <div id="testsidebar">Hello World </div> -->
    <div class="container">
    <div class="sidenav">
        
        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
          <div class="dropdown-container">
          <a href="/courseRegister">Course Registration </a>
          <a href="/registerStudent">Student Registration </a>
          <a href="/showuser">Student Search </a>
        </div>
        <a href="/UserShow">Users Management</a>
      </div>
      
      <div class="main_contents" >
    <div id="sub_content" >
    
    <p style="color: red;">${error}</p>
        

		
		  <form action="#" th:action="@{/UserUpdate}" th:object="${user}" method="post"  >
        <h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Update</h2>
        
        
        <div class="row mb-4">
         <input type="hidden" th:field = *{id}   >
            <div class="col-md-2"></div>
            <label for="email" class="col-md-2 col-form-label">Name</label>
            <div class="col-md-4">
           
           
          
			<input type="text" class="form-control" required="required" th:field = *{name} >
             
              
                
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="email" class="col-md-2 col-form-label">Email</label>
            <div class="col-md-4">
              
                <input type="email" class="form-control" required="required" th:field = *{email}>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="Passowrd" class="col-md-2 col-form-label">Passowrd</label>
            <div class="col-md-4">
           <input type="password" class="form-control" required="required" th:field = *{password} >
               
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="confirmPassword" class="col-md-2 col-form-label">Confirm Passowrd</label>
            <div class="col-md-4">
            <input type="password" class="form-control" required="required" th:field = *{confirm} >  
                
               
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="userRole" class="col-md-2 col-form-label">User Role</label>
            <div class="col-md-4">
           
                <select class="form-select" aria-label="Education" th:field = *{role}>
                <option th:value = "admin">Admin</option>
                <option th:value = "user">User</option>
                </select>

               
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-4"></div>

            <div class="col-md-6">
               

                <button type="button" class="btn btn-success col-md-2 addsubmits" data-bs-toggle="modal" data-bs-target="#exampleModal">Update</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">User Update</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                               
                               <h5 style="color: rgb(127, 209, 131);" id="addusersuccessfuls">Succesfully Updated !</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success col-md-2" data-bs-dismiss="modal">Ok</button>
                               
                            </div>
                        </div>
                    </div>
            </div>
            <button type="button" class="btn btn-secondary col-md-2 " onclick="location.href = 'USR003.jsp';">
                Back
            </button>
    

        </div>
      
        
        </form>
        
        
        </div>
      
        
       
    
</div>
</div>
        <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
        </div>
        <script type="text/javascript" th:src="@{/js/stuReg.js}"></script>
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
              this.classList.toggle("active");
              var dropdownContent = this.nextElementSibling;
              if (dropdownContent.style.display === "block") {
              dropdownContent.style.display = "none";
              } else {
              dropdownContent.style.display = "block";
              }
              });
            }
            </script>
</body>

</html>

    


    
