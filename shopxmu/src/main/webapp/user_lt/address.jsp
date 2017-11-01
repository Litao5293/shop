<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>地址管理</title>

		<link href="../user_lt/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="../user_lt/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="../user_lt/css/personal.css" rel="stylesheet" type="text/css">
		<link href="../user_lt/css/addstyle.css" rel="stylesheet" type="text/css">
		<script src="../user_lt/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="../user_lt/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="../user_lt/js/jsAddress.js"></script>
		<script type="text/javascript">
		
		function add(){//添加
			console.log(111);
			var name=$("#user-name").val();
			var tel=$("#user-phone").val();
			var address1=$("#cmbProvince").val();
			var address2=$("#cmbCity").val();
			var address3=$("#cmbArea").val();
			var address4=$("#user-intro").val();
			var address=address1+'省'+address2+address3+'  !详细地址：'+address4;
			$.post('/shopxmu/urerlt/pladd.sw',{name:name,tel:tel,address:address} ,function(data){
				if(data){
					//window.location.href=window.location.href; 
					//window.location.reload; 这个也可以刷新本页面
					window.location.reload();
					quxiao();
				}} 
			)
		}
		
		
		function quxiao(){//取消
			$("#user-name").val("");
			$("#user-phone").val("");
			//$("#cmbProvince").val("");
			//$("#cmbCity").val("");
			//$("#cmbArea").val("");
			$("#user-intro").val("");
		}
		</script>
	</head>

	<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<span>欢迎您，${username }!</span>
								</div>
							</div>
						</ul>
						<ul class="message-r">
							<div class="topMessage home">
								<div class="menu-hd"><a href="/shopxmu/index.html" target="_top" class="h">商城首页</a></div>
							</div>
							<div class="topMessage my-shangcheng">
								<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
							</div>
							<div class="topMessage mini-cart">
								<div class="menu-hd"><a id="mc-menu-hd" href="/shopxmu/cart.html" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
							</div>
							<div class="topMessage favorite">
								<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
						</ul>
						</div>

						<!--悬浮搜索框-->

						<div class="nav white">
							<div class="logoBig">
								<li><img src="../user_lt/images/logobig.png" /></li>
							</div>

							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form>
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>

		 <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>
			</div>
		<b class="line"></b>

		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-address">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">地址管理</strong> / <small>设置&nbsp;</small></div>
						</div>
						<hr/>
						<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails" id="dizhi">

							<c:forEach var ="post" items="${place }">
							<li class="user-addresslist ${post.pot eq 'Y' ? 'defaultAddr' :'' }" value="${post.pid }">
								<span class="new-option-r"><i class="am-icon-check-circle"></i>默认地址</span>
								
								<p class="new-tit new-p-re">
							            <span class="new-txt">${post.name}</span>
										<span class="new-txt-rd2">${post.tel}</span>
								</p>
								<div class="new-mu_l2a new-p-re">
								<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">${post.address}</span>
								</div>
								<div class="new-addr-btn">
									<a href="#"><i class="am-icon-edit"></i></a>
									<span class="new-addr-bar"></span>
								<input type="hidden" value="${post.pid }" class="pid" />
									<a href="/shopxmu/urerlt/deletep.sw?pid=${post.pid }" class="deleteAddress")">删除</a> 
								</div>
								
							</li>
							</c:forEach>
						</ul>
						<div class="clear"></div>
						<a class="new-abtn-type" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加新地址</a>
						<!--例子-->
						<div class="am-modal am-modal-no-btn" id="doc-modal-1">

							<div class="add-dress">

								<!--标题 -->
								<div class="am-cf am-padding">
									<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small></div>
								</div>
								<hr/>

								<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
									<form class="am-form am-form-horizontal">

										<div class="am-form-group">
											<label for="user-name" class="am-form-label">收货人</label>
											<div class="am-form-content">
												<input type="text" id="user-name" >
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-phone" class="am-form-label">手机号码</label>
											<div class="am-form-content">
												<input id="user-phone" type="email">
											</div>
										</div>
										<div class="am-form-group">
											<label for="user-address" class="am-form-label">所在地</label>
											<div class="am-form-content address">
												<!-- <select data-am-selected id="cmbProvince">
													
												</select>
												<select data-am-selected id="cmbCity">
													
												</select>
												<select data-am-selected id="cmbArea">
													
												</select> -->
												<select id="cmbProvince"></select>
												<select id="cmbCity"></select>
												<select id="cmbArea"></select>
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-intro" class="am-form-label">详细地址</label>
											<div class="am-form-content">
												<textarea class="" rows="3" id="user-intro" ></textarea>
												<small>100字以内写出你的详细地址...</small>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-u-sm-9 am-u-sm-push-3">
												<a class="am-btn am-btn-danger" onclick="add()">保存</a>
												<a href="javascript: void(0)" onclick="quxiao()" class="am-close am-btn am-btn-danger" data-am-modal-close >取消</a>
											</div>
										</div>
									</form>
								</div>

							</div>

						</div>

					</div>

					<script type="text/javascript">
					
					
						$(document).ready(function() {						
							$(".new-option-r").click(function() {//默认地址点击时
								$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
								//var a=$(this).parent().attr("value");这样也可以得到值
								var pid =$(this).parent().val();
								potupdate(pid);
							});
							
							var $ww = $(window).width();
							if($ww>640) {
								$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
							}
						})
						function potupdate(pid){//修改默认地址
							console.log('WW2',pid);
							$.getJSON('/shopxmu/urerlt/potupdate.sw',{pid:pid},function(data){
								if(data){
									window.location.reload();
								}
							})
						}
						
					</script>

					<div class="clear"></div>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<!-- <p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
						</p> -->
					</div>
				</div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person">
						<a href="../user_lt/23.jsp">个人中心</a>
					</li>
					<li class="person">
						
						<ul>
							<li> <a href="/shopxmu/urerlt/tolist.sw">个人信息</a></li>
							<li> <a href="../user_lt/safety.jsp">安全设置</a></li>
							<li> <a href="/shopxmu/urerlt/plist.sw">收货地址</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的交易</a>
						<ul>
							<li><a href="../user_lt/order.html">订单管理</a></li>
							<li> <a href="../user_lt/change.html">退款售后</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的资产</a>
						<ul>
							<li> <a href="../user_lt/coupon.html">优惠券 </a></li>
							<li> <a href="../user_lt/bonus.html">红包</a></li>
							<li> <a href="../user_lt/bill.html">账单明细</a></li>
						</ul>
					</li>

					<li class="person">
						<a href="#">我的小窝</a>
						<ul>
							<li> <a href="../user_lt/collection.html">收藏</a></li>
							<li> <a href="../user_lt/foot.html">足迹</a></li>
							<li> <a href="../user_lt/comment.html">评价</a></li>
							<li> <a href="../user_lt/news.html">消息</a></li>
						</ul>
					</li>

				</ul>

			</aside>
		</div>
		<script type="text/javascript">
			addressInit('cmbProvince', 'cmbCity', 'cmbArea', '四川', '成都市', '锦江区');
			
		</script>
	</body>

</html>