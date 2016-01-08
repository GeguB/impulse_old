<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Being Java Guys | Spring DI Hello World</title>
<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 100px;
 height: 22px;
 text-align: left;
}

.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
</head>
<body>
 <b>Being Java Guys | Registration Form </b> 

  

  <div>
   <form:form method="post" action="/create" modelAttribute="user">
    <table>
     <tr>
      <td>First Name :</td>
      <td><form:input path="username" /></td>
     </tr>
	<tr>
      <td>�</td>
      <td><input type="submit" value="Save" /></td>
     </tr>
     <tr>
      
      <td colspan="2"><a href="getList">Click Here to See User List</a></td>
     </tr>
    </table>
   </form:form>
  </div>
</body>
</html>
