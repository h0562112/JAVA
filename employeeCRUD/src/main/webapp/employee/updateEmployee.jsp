<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新建員工資料</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
       let inputFileToLoad = null;
       let picture = null;
       let img = null;
       window.addEventListener('load', function(){
	        inputFileToLoad = document.getElementById("inputFileToLoad");
	        picture = document.getElementById("picture");
	        img = document.getElementById("img");
	        inputFileToLoad.addEventListener('change', loadImageFileAsURL);
       }
       );
       function loadImageFileAsURL(){
          let filesSelected = document.getElementById("inputFileToLoad").files;
          if (filesSelected.length > 0)
          {
              let fileToLoad = filesSelected[0];
	      	
              let fileReader = new FileReader();
      
              fileReader.onload = function(fileLoadedEvent) 
              {
              	fileDataURL = fileLoadedEvent.target.result;
                  picture.value = fileLoadedEvent.target.result;
                  img.src = fileLoadedEvent.target.result;
              };
              fileReader.readAsDataURL(fileToLoad);
          }
     }
    </script>
</head>
<c:choose>
    <c:when test="${empty emp.id}">
        <c:set var="id"  					value = "${param.id}" />
        <c:set var="employeeId"  			value = "${param.employeeId}" />
        <c:set var="name"  					value = "${param.name}" />
        <c:set var="birthday"  				value = "${param.birthday}" />
        <c:set var="email"  				value = "${param.email}" />
        <c:set var="picture"  				value = "${param.picture}" />
    </c:when>
    
    <c:otherwise>
    <c:set var="id"  					value = "${emp.id}" />
        <c:set var="employeeId"  			value = "${emp.employeeId}" />
        <c:set var="previous_employeeId"  	value = "${emp.employeeId}" />
        <c:set var="name"  					value = "${emp.name}" />
        <c:set var="birthday"  				value = "${emp.birthday}" />
        <c:set var="email"  				value = "${emp.email}" />
        <c:set var="picture"  				value = "${emp.dataUri}" />
    </c:otherwise>

</c:choose>
<body>
    <div class='container my-5'>
    <div class='alert alert-success'><h2 align='center'>修改員工資料</h2></div>
    
     <form method='POST' action="<c:url value='/employee/updateEmployee.do' />">
        <div class='row mb-3'>
            <label class='col-sm-2'>員工編號</label>
            <div class='col-sm-6'>
                <input type='text' class='form-control' name='employeeId' value="${employeeId}" >
                <input type='hidden' name='previous_employeeId' value="${employeeId}" >
                <input type='hidden' name='id' value="${id}" >
            </div>
            <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.employeeId}</font>
            </div>
        </div>
        <div class='row mb-3'>
            <label class='col-sm-2'>姓名</label>
            <div class='col-sm-6'>
                <input type='text' class='form-control' name='name' value="${name}" >
            </div>
            <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.name}</font>
            </div>
        </div>
         <div class='row mb-3'>
            <label class='col-sm-2'>生日</label>
            <div class='col-sm-6'>
                <input type='text' class='form-control' name='birthday' 
                       placeholder="請輸入生日 (yyyy-mm-dd)"  value="${birthday}" >
            </div>
             <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.birthday}</font>
            </div>
        </div>
        <div class='row mb-3'>
            <label class='col-sm-2'>電郵地址</label>
            <div class='col-sm-6'>
                <input type='text' class='form-control' name='email' value="${email}" >
            </div>
            <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.email}</font>
            </div>
        </div>
        
        <div class='row mb-3'>
            <label class='col-sm-2'>圖片</label>
            <div class='col-sm-4'>
                <input type='file' id='inputFileToLoad' class='form-control' name='image' onchange="loadImageFileAsURL();"  >
                <input type='hidden' id='picture' name='picture' value="${picture}" >
                
            </div>
            <div class='col-sm-2'>
                <img id='img' width='60' height='80' src='${picture}'>
            </div>  
            <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.picture}</font>
            </div>  
        </div>
        <div class='row mb-3'>
            <div class='offset-sm-3 col-sm-3 d-grid'>
                <button type='submit' class='btn btn-primary'>提交</button>
            </div>
            <div class='col-sm-3 d-grid'>  
                <a class='btn btn-outline-primary' href="<c:url value='/employee/queryEmployee.do' />" role='button'>放棄更新	</a>
            </div>
        </div>
        </form>  
    </div>
</body>
</html>