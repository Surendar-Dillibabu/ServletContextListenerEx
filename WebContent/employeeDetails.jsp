<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
  <head>
    <style>
      .container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
      }
	</style>
    <meta charset="ISO-8859-1">
    <title>Employee details</title>
  </head>
  <body>
    <div class="container"> 
      <c:choose>
        <c:when test="${not empty employeeList}">        
          <b>List of employee details</b>
          <table>
            <thead>
              <tr>
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Salary</th>
                <th>Dept ID</th>
                <th>Joining Date</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="employeeList" items="${employeeList}">
          	    <tr>
          	      <td>${employeeList.employeeId}</td>
          	      <td>${employeeList.employeeName}</td>
          	      <td>${employeeList.salary}</td>
          	      <td>${employeeList.deptId}</td>
          	      <td>${employeeList.joiningDate}</td>
          	    </tr>
        	  </c:forEach>
            </tbody>
          </table>        
        </c:when>
        <c:otherwise>
          <p>Employee details is not present</p>
        </c:otherwise>
      </c:choose>
      <a href="<%=request.getContextPath()%>/home">Back</a>
    </div>
  </body>
</html>