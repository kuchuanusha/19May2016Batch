<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String firstNumber=request.getParameter("firstNumber");
int a=Integer.parseInt(firstNumber);
String secondNumber=request.getParameter("secondNumber");
int b=Integer.parseInt(secondNumber);
String calci=request.getParameter("calci");
if(calci.equals("add")){
	out.println("value:"+(a+b));
}
else if(calci.equals("sub")){
	out.println("value:"+(a-b));
}
else if(calci.equals("mul")){
	out.println("value:"+(a*b));
}
else if(calci.equals("div")){
	out.println("value:"+(a/b));
}
%>

</body>
</html>