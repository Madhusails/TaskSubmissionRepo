<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>List of Employees</h1>
    <hr>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>DESIGNATION</th>
                <th>DATE OF BIRTH</th>
                <th>SALARY</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employeeList}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.designation}</td>
                    <td>${emp.dateOfBirth}</td>
                    <td>${emp.salary}</td>
                    <td><a href="delete-employee?id=${emp.id}" class="btn btn-danger">DELETE</a></td>
                    <td><a href="update-employee?id=${emp.id}" class="btn btn-warning">UPDATE</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-employee" class="btn btn-success">Add Employee</a>
    </div>
<%@ include file="common/footer.jspf" %>