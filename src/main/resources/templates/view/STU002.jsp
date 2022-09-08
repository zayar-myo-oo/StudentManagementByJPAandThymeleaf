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
            <a href="MNU001.html"><h3>Student Registration</h3></a>
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
    
  
      
      <form action="#" th:action="@{/StudentUpdate}" th:object="${stud}" method="post" >
        
			
            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Details</h2>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="studentID" class="col-md-2 col-form-label">Student ID</label>
                <div class="col-md-4">
                
             <input type="text" class="form-control"  th:field = *{id}  id="studentID" readonly="readonly">
             
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="stuName" class="col-md-2 col-form-label">Name</label>
                <div class="col-md-4">

                <input type="text" class="form-control"  th:field = *{name}  id="stuName" required="required">    
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="stuDOB" class="col-md-2 col-form-label">DOB</label>
                <div class="col-md-4">
                
                <input type="date"   th:field = *{dob}  id="stuDOB" class="form-control" required="required">
                
             
                </div>
            </div>
            <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Gender</legend>
                <div class="col-md-4">
                    <div class="form-check-inline">
                      <input type="radio"  th:attr="name='gender'" th:value="male"  checked class="form-check-input" id="stuGender">
                    
                        <label class="form-check-label" for="stuGender">
                            Male
                        </label>
                    </div>
                    <div class="form-check-inline">
                       <input type="radio"  th:attr="name='gender'" th:value="female"   class="form-check-input" id="stuGender">
                    <label class="form-check-label" for="stuGender">
                            Female
                        </label>
                    </div>
    
                </div>
            </fieldset>
    
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="stuPhone" class="col-md-2 col-form-label">Phone</label>
                <div class="col-md-4">
               <input type="text"   th:field = *{phone} class="form-control"  id="stuPhone" required="required">
               </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="stuEdu" class="col-md-2 col-form-label">Education</label>
                <div class="col-md-4">
                   <select class="form-select" id="stuEdu" aria-label="Education" th:field = *{education} required="required">
                <option th:value = "BachelorofInformationTechnology">Bachelor of Information Technology</option>
                <option th:value = "DiplomainIT">Diploma in IT</option>
<option th:value = "BachelorofComputerScience">Bachelor of Computer Science</option>
                </select>
                
</div>
            </div>
            <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Attend</legend>

                <div class="col-md-4">

                <div class="form-check-inline col-md-3" th:each = "c : ${session.course}" >
                
                <input type="checkbox"  th:field = "*{attend}"  th:value="${c.cid+'-'+c.name}"  class="form-check-input" id="stuCourse"> 

                    <label class="form-check-label" for="stuCourse" th:text = "${c.name}">

                        </label>

                        
                    </div>

                </div>
    
    
    
    
            </fieldset>
            
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Photo</label>
                <div class="col-md-4">
                    <input type="file" class="form-control" id="name">
                </div>
            </div>
    
            <div class="row mb-4">
                <div class="col-md-4"></div>
    
                <div class="col-md-4">
                    <a >
                        <button type="submit" class="btn btn-secondary">
                          
                            <span>Update</span>
                        </button>
                    </a>
    
                    <!-- Button trigger modal -->
                    <a th:href="@{/StudentDelete/{id}(id=*{id})}">
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                       
                       <span>Delete</span> 
                    </button>
    				</a>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Student Deletion</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Are you sure you want to delete?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Ok</button>
                                    <button type="button" class="btn btn-danger">Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
    
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

