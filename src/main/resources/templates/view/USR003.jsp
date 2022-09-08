<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">

<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       	<link th:href="@{/css/test.css}" rel="stylesheet"/>
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
      
      <div class="main_contents">
    <div id="sub_content">
    <p th:text="${param.notfound }" style="color: red;"	></p>
    
    	
        <form action="#" th:action="@{/processingUsearch}" th:object="${user}" method="post" class="row g-3 mt-3 ms-2">
            <div class="col-auto">
                <label for="staticEmail2" class="visually-hidden">User Id</label>
                <input type="text" placeholder="User ID"  th:field = *{id} class="form-control" id="staticEmail2">
                
            
            </div>
            <div class="col-auto">
                <label for="inputPassword2" class="visually-hidden">User Name</label>
                <input type="text" placeholder="User Name"  th:field = *{name} class="form-control" id="inputPassword2" >
               
           
            </div>
    
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Search</button>
            </div>
            
            <div class="col-auto">
                <button type="button" class="btn btn-secondary " onclick="location.href = '/URegister';">
                    Add
                </button>
    
            </div>
            <div class="col-auto">
                <button type="reset" class="btn btn-danger mb-3">Reset</button>
            </div>
        
        
   </form>
        <table class="table table-striped" id="stduentTable">
            <thead>
                <tr>
                    
                    <th scope="col">User ID</th>
                    <th scope="col">User Name</th>
                    <th scope="col">Details</th>
                    
                </tr>
            </thead>
            <tbody>
             
             
             
            
            
                <tr  th:each = "users : ${session.user} ">
    			
                    
                   <td th:text = "${users.id} "></td>
                   <td th:text = "${users.name}"></td>
                    
                <td>
                <a  th:href="@{/updateUser/{id}(id=${users.id})}">
                
                    <button type="button" class="btn btn-success">
                        Update
                    </button>
                    </a>
                </td>
                <td>
                    
                <a th:href="@{/deleteUser/{id}(id=${users.id})}">
                <button type="submit" class="btn btn-secondary mb-3" data-bs-toggle="modal"
                    data-bs-target="#exampleModal">Delete</button>
                   </a> 
                    </td>
    			
                </tr>
		
		

			
            </tbody>
        </table>
    
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Student Deletion</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div th:if="${param.notfoun}">
                            <h5 style="color: red">You can't delete</h5>
                         </div>
                         <!-- ELSE -->
                         <div th:unless="${param.notfoun}">
                            <h5 style="color: rgb(127, 209, 131);">Are you sure want to delete !</h5>
                         </div>                    
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success col-md-2" data-bs-dismiss="modal">Ok</button>
    
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
        <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
        </div>
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

    


    


<body>
    
</body>

