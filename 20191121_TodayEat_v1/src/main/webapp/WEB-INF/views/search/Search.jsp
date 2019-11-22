<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 BOOK</title>
	<link href="${pageContext.request.contextPath}/resources/css/searchBOOK.css" rel="stylesheet">
</head>

<!-- 한글과 띄어쓰기만 입력 가능 ------------------------------------------------------------------->

	<script
		src="https://code.jquery.com/jquery-1.11.0.js"
	  	integrity="sha256-zgND4db0iXaO7v4CLBIYHGoIIudWI5hRMQrPB20j0Qw="
	  	crossorigin="anonymous"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	 	$("input:text[name=query]").on("keyup", function() {
		    $(this).val($(this).val().replace( /[^가-힣\s]/g,""));
		});
	});
	</script>
	
<!-- 한글과 띄어쓰기만 입력 가능 ------------------------------------------------------------------->
<!-- 국가 checkboxChecked -------------------------------------------------------------------->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-migrate-3.1.0.min.js"></script>
	
	<script type="text/javascript">
		 <c:forEach items="${list_country}" var="country">
			 if("${country}"=="한식"){
					$(document).ready(function() {
						$("input:checkbox[id=H]").prop("checked",true);
					});
			 	}
			 if("${country}"=="중식"){
					$(document).ready(function() {
						$("input:checkbox[id=C]").prop("checked",true);
					});
				}
			 if("${country}"=="일식"){
					$(document).ready(function() {
						$("input:checkbox[id=J]").prop("checked",true);
					});
				}
			 if("${country}"=="양식"){
					$(document).ready(function() {
						$("input:checkbox[id=A]").prop("checked",true);
					});
				}
		</c:forEach> 
		/*이벤트처리*/
		$(document).ready(function(){
			//1
		    $(".check1").change(function(){
		        if($(".check1").is(":checked")){
			    		$( window ).one("scroll",function() {
			    			
			    			var a = document.research;
		    				a.submit();
			    				
			    		});
		        }else{
		        	$( window ).one("scroll",function() {
		    			
		    			var a = document.research;
	    				a.submit();
		    				
		    		});
		        }
		    });
		    //2
		    $(".check2").change(function(){
		        if($(".check2").is(":checked")){
			    		$( window ).one("scroll",function() {
			    			
			    			var a = document.research;
		    				a.submit();
			    				
			    		});
		        }else{
		        	$( window ).one("scroll",function() {
		    			
		    			var a = document.research;
	    				a.submit();
		    				
		    		});
		        }
		    });
		    //3
		    $(".check3").change(function(){
		        if($(".check3").is(":checked")){
			    		$( window ).one("scroll",function() {
			    			
			    			var a = document.research;
		    				a.submit();
		    				
			    		});
		        }else{
		        	$( window ).one("scroll",function() {
		    			
		    			var a = document.research;
	    				a.submit();
		    				
		    		});
		        }
		    });
		    //4
		    $(".check4").change(function(){
		        if($(".check4").is(":checked")){
			    		$( window ).one("scroll",function() {
			    			
			    			var a = document.research;
		    				a.submit();
			    				
			    		});
		        }else{
		        	$( window ).one("scroll",function() {
		    			
		    			var a = document.research;
	    				a.submit();
		    				
		    		});
		        }
		    });
		});
	</script>

<body>

<div class="page">
<div class="contents_wrap">

<!-- 검색창 -------------------------------------------------------------------------------------->
	<form action="test.do">
		<div class="div1" align="center">
			<br><br><br>
			<input class="search1" type="text" name="query" placeholder="토마토 감자" align="center">
			<input class="img1" type="image" src="${pageContext.request.contextPath}/resources/img/icon/Search_main.svg" alt="검색이모티콘"> 
		</div>
	</form>
<!-- 검색창 --------------------------------------------------------------------------------------->
<!-- Filter 이미지 -------------------------------------------------------------------------------->
	<div class="div11">
		<c:if test="${recipe_book !=1 }">
			<div class="div8" align="center">
				<img class="img2" src="${pageContext.request.contextPath}/resources/img/icon/Filter.svg" alt="필터이미지">
			</div>
		</c:if>
<!-- Filter 이미지 --------------------------------------------------------------------------------->
<!-- 국가 체크 박스 ----------------------------------------------------------------------------------->
		<form action="test.do" method="post" name="research">	
			<div class="div3" align="center">
				<table>
					<tr> 
						<th><input class="button1" type="button" value="한식" ></th>
						<th><input class="button1" type="button" value="중식" ></th>
						<th><input class="button1" type="button" value="일식" ></th>
						<th><input class="button1" type="button" value="양식" ></th>
					</tr>
					<tr>
						<td align="center"><label class="switch1 input1">
							<input type="checkbox" name="country" value="한식" class="check1" id="H"><span class="slider round"></span></label></td>
		
						<td align="center"><label class="switch1 input1">
							<input type="checkbox" name="country" value="중식" class="check2" id="C"><span class="slider round"></span></label></td>
						
						<td align="center"><label class="switch1 input1">
							<input type="checkbox" name="country" value="일식" class="check3" id="J"><span class="slider round"></span></label></td>
						
						<td align="center"><label class="switch1 input1">
							<input type="checkbox" name="country" value="양식" class="check4" id="A"><span class="slider round"></span></label></td>
					</tr>
				</table>
			</div>
<!-- 국가 체크 박스 ------------------------------------------------------------------------------------>
<!-- 식재료 추가 검색 ----------------------------------------------------------------------------------->
			<div class="div4" align="center">
				<input class="search2" type="text" placeholder="식재료 추가" name="query">
				<input class="img3" type="image" src="${pageContext.request.contextPath}/resources/img/icon/Search_sub.svg" alt="검색이모티콘">
			</div>
<!-- 식재료 추가 검색 ----------------------------------------------------------------------------------->
<!-- 검색어 체크 박스 ----------------------------------------------------------------------------------->
			<div class="div5 checks etrans " align="center">
				<c:forEach items="${list_searchVO}" var="vo" > 
					<c:if test="${vo.query!=''}">
						<input type="checkbox" name="query" value="${vo.query}" id="ex_chk'${vo.i }'" checked="checked" > <label for="ex_chk'${vo.i }'" class="aa" >${vo.query}</label>
  					</c:if>
   				</c:forEach>
   			</div>
<!-- 검색어 체크 박스 ----------------------------------------------------------------------------------->
<!-- 검색 버튼 ---------------------------------------------------------------------------------------->
		   	<div class="div6" align = "center">   
		      	<input type="submit" class="btn1" value="검색" >
		   	</div>
		</form>
	</div>
<!-- 검색 버튼 ---------------------------------------------------------------------------------------->
<!-- Recipe 로고 ------------------------------------------------------------------------------------->
	<c:if test="${!empty list_recipeVO}">
		<div class="div9" align="center" id="recipe_img">
			<img  src="${pageContext.request.contextPath}/resources/img/icon/Recipe.svg" alt="필터이미지" class="img2">
		</div>
<!-- Recipe 로고 --------------------------------------------------------------------------------------->
<!-- 하단 ReciepView ----------------------------------------------------------------------------------->
		<script type="text/javascript">
			function a(){ alert("로그인후 상세 레시피 볼수 있습니다.");}
		</script>

		<c:forEach items="${list_recipeVO}" var="recipe" >
			<input type="hidden" name="recipe_no" value="${recipe.recipe_no}">
   			<div class = "div7">
		<!----------------------------------------------------------------------------회원가능---------->
	   			<c:if test="${empty login_id }">
	      			<input class="img2" id="float1" type="image" src="/img/${recipe.complete_img}" alt="필터이미지" onclick="a()">
				</c:if>
				<c:if test="${not empty login_id }">
	   				<a href = "searchOneRecipe.do?recipe_no=${recipe.recipe_no}">
	      				<input class="img2" id="float1" type="image" src="/img/${recipe.complete_img}" alt="필터이미지">
					</a>
				</c:if>
      			<div>
	      			<table class = "table01">
		      			<tr>
			      			<td colspan="${fn:length(list_recipeMaterialVO) }">
			      				<c:if test="${empty login_id }">
			      					<label onclick="a()">[ ${recipe.recipe_title} ]</label>
			      				</c:if>
			      				<c:if test="${not empty login_id }">
			      					<a href = "searchOneRecipe.do?recipe_no=${recipe.recipe_no}">[ ${recipe.recipe_title} ]</a>  
			      				</c:if>
			      			</td>
			  			</tr>
			  			<tr>
			      			<td colspan="4"> &nbsp </td><!-- 사용재료 -->
			  			</tr>
			  			<tr>
			  				<c:forEach items="${list_recipeMaterialVO}" var="material" >
			  					<c:if test="${recipe.recipe_no==material.recipe_no }">
									<c:set var="n" value="1"/>
									<c:forEach items="${list_searchVO}" var="search">
										<c:if test="${n=='1' }">
											<c:set var="a" value="${material.material_food}"/>
											<c:set var="b" value="${search.query }"/>
						  					<c:if test="${fn:contains(a,b)}">				  			
							  					<td id="fontstyle0 " ><label class="highlight">${a }</label></td>
						  						<c:set var="n" value="0"/>
						  					</c:if>
				  						</c:if>
			  						</c:forEach>
					  				<c:if test="${!fn:contains(a,b)}">
					  					<td id="fontstyle1" >${material.material_food}</td>
									</c:if>
			    				</c:if>
			  				</c:forEach>
			  			</tr>
			  			<tr>
			  				<td colspan="${fn:length(list_recipeMaterialVO)}">&nbsp</td>
			  			</tr>
			  			<tr align="center">
			  				<td colspan="${fn:length(list_recipeMaterialVO)}" id="fontstyle1"> &nbsp&nbsp추천 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp비추천</td>
			  			</tr>
			  			<tr align="center">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			      			<td colspan="${fn:length(list_recipeMaterialVO)}">&nbsp<input type="image" class="good-btn" src="${pageContext.request.contextPath}/resources/img/icon/good_icon_black.svg">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			      			<input type="image" class="bad-btn" src="${pageContext.request.contextPath}/resources/img/icon/bad_icon_black.svg"></td>
		      			</tr>
		      			<tr align="center">
			  				<td colspan="${fn:length(list_recipeMaterialVO)}" id="fontstyle1">&nbsp${recipe.recipe_good }&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${recipe.recipe_bad }</td>
			  			</tr>
	      			</table>
      			</div>
   			</div>
		</c:forEach>
	</c:if>
				<c:if test="${no_recipe == 0 }">
					<label align="center" class="label2">COMING SOON</label><br><br><br><br><br><br><br>
				</c:if>
<!-- 하단 ReciepView ----------------------------------------------------------------------------------->
		<jsp:include page="../main/footer.jsp" /> <!-- 푸터부분 삽입 --> 
	</div>
</div>
<jsp:include page="../main/header.jsp" />  <!-- 헤더부분 삽입 -->
</body>
</html>