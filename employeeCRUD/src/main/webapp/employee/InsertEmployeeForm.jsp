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
              let fileReader = new FileReader();
              
              let fileToLoad = filesSelected[0];
      		  console.log("fileToLoad=" + fileToLoad.name );
              fileReader.onload = function(fileLoadedEvent) 
              {
                  picture.value = fileLoadedEvent.target.result;
                  img.src 		= fileLoadedEvent.target.result;
              };
              fileReader.readAsDataURL(fileToLoad);
          }
     }


    </script>
</head>
<body>
    <div class='container'>
    <div class='alert alert-success'><h2 align='center'>新建員工資料</h2></div>
    
    <form method='POST' action="<c:url value='/employee/insertEmployee.do' />">
        <div class='row mb-3'>
            <label class='col-sm-2'>員工編號</label>
            <div class='col-sm-6'>
                <input type='text' class='form-control' name='employeeId' 
                       placeholder="請輸入員工編號" value="${param.employeeId}" >
            </div>
            <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.employeeId}</font>
            </div>
        </div> 
        <div class='row mb-3'>
            <label class='col-sm-2'>姓名</label>
            <div class='col-sm-6'>
                <input type='text' class='form-control' name='name' 
                       placeholder="請輸入姓名"  value="${param.name}" >
            </div>
            <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.name}</font>
            </div>
            
        </div>
        <div class='row mb-3'>
            <label class='col-sm-2'>生日</label>
            <div class='col-sm-6'>
                <input type='text' class='form-control' name='birthday' 
                       placeholder="請輸入生日 (yyyy-mm-dd)"  value="${param.birthday}" >
            </div>
             <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.birthday}</font>
            </div>
        </div>
        <div class='row mb-3'>
            <label class='col-sm-2'>電郵地址</label>
            <div class='col-sm-6'>
                <input type='email' class='form-control' name='email' 
                       placeholder="請輸入電郵地址"  value="${param.email}" >
            </div>
            <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.email}</font>
            </div>
        </div>

        <div class='row mb-3'>
            <label class='col-sm-2'>圖片</label>
            <div class='col-sm-4	'>
                <input type='file' id='inputFileToLoad' class='form-control' 
                       placeholder="請輸入挑選圖片"  name='image' onchange="loadImageFileAsURL();"  >
                <input type='hidden' id='picture' name='picture'  value="${param.picture}">
            </div>
            <div class='col-sm-2'>
                <img id='img' width='60' height='80' src='${param.picture}'>
            </div>    
            <div class='col-sm-4'>
            	<font style="color:#FF0000; font-size:90%;" >${ErrorMsg.picture}</font>
            </div>
        </div>
        <c:if test="${not empty exception}">
	        ${exception}
        </c:if>
        <div class='row mb-3'>
            <div class='offset-sm-3 col-sm-3 d-grid'>
                <button type='submit' class='btn btn-primary'>提交</button>
            </div>
            <div class='col-sm-3 d-grid'>
                <a class='btn btn-outline-primary' href="<c:url value='/index.jsp' />" role='button'>放棄新增</a>
            </div>
        </div>
        </form>
        <hr>
        
    </div>
</body>
</html>
