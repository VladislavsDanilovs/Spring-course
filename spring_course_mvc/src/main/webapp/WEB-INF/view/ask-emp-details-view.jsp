<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>

<h2> I wish you luck in Spring MVC learning!</h2>
<br>
<br>
<form:form action = "showDetails" modelAttribute = "employee">
    Name <form:input path = "name"/>
    <br><br>
    Surname <form:input path = "surname"/>
    <br><br>
    Salary <form:input path = "salary"/>
    <br><br>
    Department <form:select path = "department">
    <!-- using map: -->
    <form:options items="${employee.departments}"/>

    <!-- hardcoded option:
    <form:option value="Information Technology" label = "IT" />
    <form:option value="Human Resources" label = "HR" />
    <form:option value="Sales" label = "Sales" />
    -->
    </form:select>

    <br><br>
    Which car do you want?
    <!-- hardcoded option:
    BMW <form:radiobutton path = "carBrand" value = "BMW M5"/>
    Nissan <form:radiobutton path = "carBrand" value = "Nissan GTR"/>
    Audi <form:radiobutton path = "carBrand" value = "Audi R8"/>
    -->
    <!-- using map: -->
    <form:radiobuttons path ="carBrand" items="${employee.carBrands}"/>
    <br><br>

    Choose language:
        <!-- hardcoded option:
    EN <form:checkbox path="languages" value="English"/>
    DE <form:checkbox path="languages" value="Deutsch"/>
    FR <form:checkbox path="languages" value="French"/>
        -->
    <!-- using map: -->
    <form:checkboxes path="languages" items="${employee.languageList}"/>

       <br><br>
    <input type = "submit" value = "OK" />
    </form:form>
</body>

</html>