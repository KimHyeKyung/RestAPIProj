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
<script>
$(function() {
	var article = {id:"114", writer:"박지성", title:"안녕하세요", content:"상품 소개 글입니다."}
	$("#checkJson1").click(function() {
		$.ajax({
			type:"POST",
			url:"${contexPath}/boards",
			contentType:"application/json",
			data:JSON.stringify(article),
			success:function(data, textStatus) {
				alert(data)
			},
			error:function(data,textStatus) {
				alert("에러가 발생했습니다.")			
			},
			complete:function(data, textStatus) {
				
			}
		})
	})
	
	$("#checkJson2").click(function() {
		$.ajax({
			type:"GET",
			url:"${contexPath}/boards/114",
			contentType:"application/json",
			success:function(data, textStatus) {
				var out='<table border="1"><tr><td>'+data.id+'</td><td>'+data.writer+'</td><td>'+data.title+'</td><td>'+data.content+'</td></tr></table>';
				$('#output').html(out);
			},
			error:function(data,textStatus) {
				alert("에러가 발생했습니다.")			
			},
			complete:function(data, textStatus) {
				
			}
		})
	})	

	$("#checkJson3").click(function() {
		var id=$('#id1').val();
		var title=$('#title1').val();
		var content=$('#content1').val();
		var article = {id:id, writer:"", title:title, content:content}
		$.ajax({
			type:"PUT",
			url:"${contexPath}/boards/"+id,
			data: article, 
			success:function(data, textStatus) {
				alert(data);
			},
			error:function(data,textStatus) {
				alert("에러가 발생했습니다.")			
			},
			complete:function(data, textStatus) {
				
			}
		})
	})	
	
	//제목수정
	$("#checkJson4").click(function() {
		var id=$('#id2').val();
		var title=$('#title2').val();
		$.ajax({
			type:"PUT",
			url:"${contexPath}/boards/title/"+id,
			data: {title:title},	//객체인데 값이1개일때는 @RequestParam으로 받을 수 있다.
			success:function(data, textStatus) {
				alert(data);
			},
			error:function(data,textStatus) {
				alert("에러가 발생했습니다.")			
			},
			complete:function(data, textStatus) {
				
			}
		})
	})
	
	//내용수정
	$("#checkJson5").click(function() {
		var id=$('#id3').val();
		var content=$('#content3').val();
		$.ajax({
			type:"PUT",
			url:"${contexPath}/boards/content/"+id,
			data: {content:content},	//객체인데 값이1개일때는 @RequestParam으로 받을 수 있다.
			success:function(data, textStatus) {
				alert(data);
			},
			error:function(data,textStatus) {
				alert("에러가 발생했습니다.")			
			},
			complete:function(data, textStatus) {
				
			}
		})
	})	
	
	
})
</script>
</head>
<body>
	<input type="button" id="checkJson1" value="새글쓰기"/><br/><br/>
	<input type="button" id="checkJson2" value="글조회"/>
	<div id="output"></div><br/>
	
	<input type="button" id="checkJson3" value="글수정"/><br/>
	<label>번호: </label><input type="text" id="id1"><br/>
	<label>제목: </label><input type="text" id="title1"><br/>
	<label>내용: </label><input type="text" id="content1"><br/><br/>
	
	<input type="button" id="checkJson4" value="제목수정"/><br/>
	<label>번호: </label><input type="text" id="id2"><br/>
	<label>제목: </label><input type="text" id="title2"><br/><br/>
	<input type="button" id="checkJson5" value="내용수정"/><br/>
	<label>번호: </label><input type="text" id="id3"><br/>
	<label>내용: </label><input type="text" id="content3"><br/>
</body>
</html>