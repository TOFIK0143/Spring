<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOC TYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">

		First name: <form:input path="firstName" />

		<br><br>

		Last name: <form:input path="lastName" />

		<br><br>

        Country:
        <form:select path="country">
          <form:options items="${student.countryOptions}"/>

        </form:select>

		<br><br>
		Favorite Language:
		Java<form:radiobutton path="favoriteLanguage" value="java"/>
		PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
		C++<form:radiobutton path="favoriteLanguage" value="C++"/>
		Python<form:radiobutton path="favoriteLanguage" value="Python"/>

		<br><br>

		Select Operation Systems:
		Linux<form:checkbox path="operatingSystem" value="Linux"/>
		Windows<form:checkbox path="operatingSystem" value="Windows"/>
		Mac OS<form:checkbox path="operatingSystem" value="Mac OS"/>

		<br><br>
       <input type="submit" value="Submit" />

	</form:form>


</body>

</html>











