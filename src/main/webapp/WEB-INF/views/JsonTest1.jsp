<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<script type="text/javascript">
$(function(){
	$("#checkJson").click(function(){
		//json처럼 생겼지만 객체임
		var member = {id:"park",name:"박지성",password:"1234",email:"park@kosta.com"};
		$.ajax({
			type:"post",
			url:"${contextPath}/test/info",
			contentType:"application/json",
			data:JSON.stringify(member),	//JSON.stringify를 사용해서 객체를 json형태로 변환한다.
			success:function(data, textStatus){
				alert(data);
			},
			error:function(data, textStatus){
				
			},
			complete:function(data, textStatus){ }
		});
	});
});

</script>
</head>
<body>
	<input type="button" id="checkJson" value="회원정보 보내기"/>
	<div id="output"></div>
</body>
</html>