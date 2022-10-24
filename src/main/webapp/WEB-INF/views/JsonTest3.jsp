<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contexPath" value="${pageContext.request.contextPath }"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	//화면뜨자마자 과일, 야채, 생성, 유제품이 나오도록(첫번째 selectBox)
	$("#pro_fam").change(function(){
		var fid = $(this).val();
		$.ajax({
			type:"GET",
			url:"${contexPath}/productList/"+fid,
			success:function(data, textStatus) {
				$('#product').empty();
				data.forEach(function(product){
					var option = $('<option value="'+product.id+'">'+product.name+'</option>');
					$("#product").append(option);
				})
				/*람다로 변경
				data.forEach(product=>{
					var option = $('<option value="'+product.id+'">'+product.name+'</option>');
					$("#product").append(option);
				}) */
			},
			error:function(data,textStatus) {
				alert("에러가 발생했습니다.")			
			},
			complete:function(data, textStatus) {
				  
			}
		})
	})
	
	//화면뜨자마자 과일이 선택되어있으니깐 두번째 selectBox에 빈값을 보여주지말고 과일에 대한 selectList값을 보여주자!(두번째 selectBox)
	var ifid = $("#pro_fam").val();	//화면 처음 뜨자마자 과일이 선택되어있으니 ifid값은 1이 지정되어있다.
	console.log(ifid);
	$.ajax({
		type:"GET",
		url:"${contexPath}/productList/"+ifid,
		success:function(data, textStatus) {
			$('#product').empty();
			data.forEach(function(product){
				var option = $('<option value="'+product.id+'">'+product.name+'</option>');
				$("#product").append(option);
			})
		},
		error:function(data,textStatus) {
			alert("에러가 발생했습니다.")			
		},
		complete:function(data, textStatus) {}
	})
	
	
})



</script>
</head>
<body>
<select id="pro_fam">
	<c:forEach var="pf" items="${productFamily}">
		<option value="${pf.id}" >${pf.name}</option>
	</c:forEach>
</select>

<select id="product">
	
</select>


</body>
</html>