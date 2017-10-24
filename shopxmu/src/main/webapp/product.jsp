
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="shopxmu/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="shopxmu/themes/icon.css">   
<script type="text/javascript" src="shopxmui/jquery-1.8.0.min.js"></script>   
<script type="text/javascript" src="shopxmu/jquery.easyui.min.js"></script>

</head>
<body>

    <table border="1">
      <tr><td>商品ID</td><td>商品名称</td><td>商品描述</td><td>折扣</td><td>原价</td><td>图片</td><td>数量</td><td>所属类别</td></tr>
      <c:forEach items="${list}" var="pro" >
      <tr><td>${pro.proID}</td>
      <td>${pro.proname }</td>
      <td>${pro.description }</td>
      <td>${pro.discount }</td>
      <td>${pro.price }</td>
      <td>${pro.proImg }</td>
      <td>${pro.procount }</td>
      <td>${pro.proname }</td>
      <td>${pro.sortid }</td>
      </c:forEach>
    </table>
</body>
</html>