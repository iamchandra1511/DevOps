<div class="container">
  <header>
   <h1>Spring MVC + JSP + JPA + Spring Boot 2</h1>
  </header>
  <div class="starter-template">
   <h1>Users List</h1>
   <table
    class="table table-striped table-hover table-condensed table-bordered">
    <tr>
     <th>Id</th>
     <th>Name</th>
    </tr>
    <c:forEach var="user" items="${users}">
     <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
     </tr>
    </c:forEach>
   </table>
  </div>

 </div>

 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>