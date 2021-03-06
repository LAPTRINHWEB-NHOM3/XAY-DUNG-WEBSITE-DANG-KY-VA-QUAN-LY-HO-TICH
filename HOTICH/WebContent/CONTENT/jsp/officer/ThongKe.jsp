<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="home" value="/" scope="request" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HOTICH.NET</title>
    <jsp:include page="./template/css.jsp"></jsp:include>
    <!-- Code css here -->
    <link rel="stylesheet" type="text/css" href="./CONTENT/styles/officer/ThongKe.css">
</head>
<body>

<div class="wrapper">
    <jsp:include page="./template/sidebar.jsp">
    	<jsp:param value="3" name="mode" />
    </jsp:include>
    <div class="main-panel">
        <jsp:include page="./template/navbar.jsp"></jsp:include>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                <!-- code here .... -->
	                <div class="row thongke-control">
		                <select class="form-control thongke-select" id="loai-thongke" onchange="changeSelect()">
		                	<option value= -1>Chọn loại thống kê ....</option>
		                    <option value = 1>Thống kê từng loại giấy tờ theo tháng</option>
		                    <option value = 2>Thống kê từng loại giấy tờ theo năm</option>
		                </select>
		                
		                <button class="btn btn-success thongke-button" onclick="showChart()" id="thongke-submit">Xác nhận</button>
	                </div>
	                <div class="row thongke-condition" id="condition">
	                	
	                </div>
                
	                
	                <div class="row">
	                    <div class="col-md-12">
	                        <div class="card">
	                            <div class="header" style="text-align : center;    padding-top: 0;">
	                                <h4 class="title">
	                                	
	                                </h4>
	                                <p class="category"></p>
	                            </div>
	                            <div class="content">
	                                <div id="chartContainer" style="height: 400px; width: 800px;margin:auto;"></div>
	                            </div>
	                        </div>
	                    </div>
                    </div>
                    <!-- end code here -->
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./template/footer.jsp"></jsp:include>
</body>
	<jsp:include page="./template/js.jsp"></jsp:include>
	<!-- Code js here -->
	<script src="./CONTENT/js/officer/ThongKe.js"></script>
	<script type="text/javascript">
    	$(document).ready(function(){
        	$.notify(
					{
						icon : 'ti-bookmark-alt',
						message : "Chào mừng đến với <b>HOTICH.NET</b> - Hệ thống quản lý hộ tịch."

					}, {
						type : 'info',
						timer : 4000
					});

    	});
	</script>
</html>