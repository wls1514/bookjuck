<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp"%>
<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/custmng.css">
<style type="text/css">
</style>
</head>

<body>

	<div class="container">

		<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
		<%@include file="/WEB-INF/views/admin/inc/header.jsp"%>


		<section class="contentsection">
			<h3>고객 관리</h3>

			<!-- 검색 테이블  시작-->
			<table class="table table-bordered" id="tbl1">
				<tr>
					<th width="150">검색어</th>
					<td>

						<select id="selbox1" name="selbox1">
							<option value="">선택</option>
							<option value="1">하나</option>
							<option value="2">둘</option>
							<option value="3">셋</option>
							<option value="direct">직접입력</option>
						</select>
						<input type="text" name="selboxDirect">
					</td>
					<th width="150">개인정보 유효기간</th>
					<td>
						<label>전체<input  type="radio" name="term" checked></label>
						<label>1년<input  type="radio" name="term" ></label>
						<label>2년<input  type="radio" name="term" ></label>
						<label>5년<input  type="radio" name="term" ></label>
						<label>10년<input type="radio" name="term" ></label>
					</td>
				</tr>
				<tr>
					<th>회원구분</th>
					<td>
						<label>전체<input  type="radio" name="socail" checked></label>
						<label>일반<input  type="radio" name="socail" ></label>
						<label>구글<input  type="radio" name="socail" ></label>
						<label>네이버<input type="radio" name="socail" ></label>
						<label>카카오<input  type="radio" name="socail" ></label>
					</td>
					<th>큐레이션 구독 여부</th>
					<td>
						<label>전체<input  type="radio" name="curation" checked></label>
						<label>구독<input  type="radio" name="curation" ></label>
						<label>비구독<input  type="radio" name="curation" ></label>
					</td>
				</tr>
				<tr>
					<th>회원가입 기간</th>
					<td>
						<input type="date" class="form-control">
						<span>~</span>
						<input type="date" class="form-control">
					</td>
					<th>최근 접속일</th>
					<td>
						<input type="date" class="form-control">
						<span>~</span>
						<input type="date" class="form-control">
					</td>
				</tr>
			</table>
			<!-- 검색 테이블  종료-->
			
			<input type="button" class="btn-general" id="listbtn" value="검  색">
			
			
			<hr>
			<select id="selbox2" name="selbox2">
							<option value="10">10</option>
							<option value="25">25</option>
							<option value="50">50</option>
			</select>
			
			<!-- 리스트 테이블 시작 -->
			<table class="talbe table-bordered tbl-md" id="tbl2">
			<tr>
				<th>
					<input  type="checkbox" id="allCheck" name="chk">
				</th>
				<th>
					번호
				</th>
				<th>
					이름
				</th>
				<th>
					아이디
				</th>
				<th>
					연락처
				</th>
				<th>
					가입일
				</th>
				<th>
					회원구분
				</th>
				<th>
					큐레이션
				</th>
				<th>
					최근 접속일
				</th>
				<th width="150">
					
				</th>
			</tr>
			<tr>
				<td><input  type="checkbox"id="Check1" name="chk"></td>
				<td>1</td>
				<td>홍길동</td>
				<td>TEST001</td>
				<td>010-5125-0577</td>
				<td>2021-01-01</td>
				<td>일반</td>
				<td>O</td>
				<td>2021-02-21</td>
				<td>
					<input type="button" value="조회" id="#custSearch" href="#custSearch" data-toggle="modal">
					<input type="button" value="탈퇴" id="#custWithdrawal" href="#custWithdrawal" data-toggle="modal">
					<input type="button" value="휴면" id="#custdormancy" href="#custdormancy" data-toggle="modal">
				</td>
			</tr>
			<tr>
				<td><input  type="checkbox"id="Check2" name="chk"></td>
				<td>2</td>
				<td>마석동</td>
				<td>TEST002</td>
				<td>010-7723-0341</td>
				<td>2021-01-10</td>
				<td>카카오</td>
				<td>X</td>
				<td>2021-02-02</td>
				<td>
					<input type="button" value="조회" id="#custSearch" href="#custSearch" data-toggle="modal">
					<input type="button" value="탈퇴">
					<input type="button" value="휴면">
				</td>
			</tr>
			</table>

			<div>
					<ul class="pagination">
						<li>
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<li>
							<a href="#">1</a>
						</li>
						<li>
							<a href="#">2</a>
						</li>
						<li>
							<a href="#">3</a>
						</li>
						<li>
							<a href="#">4</a>
						</li>
						<li>
							<a href="#">5</a>
						</li>
						<li>
							<a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
			</div>			
			
			

		</section>
	</div>
	<!-- container 종료 -->

		<!-- 플로팅 메뉴 -->
		<%@include file="/WEB-INF/views/common/bookjuckee.jsp"%>
		<%@include file="/WEB-INF/views/common/top.jsp"%>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<!-- ########## 하단 끝 -->



		<!--########### 회원 정보 조회 모달 시작  -->
			<div class="modal fade" id="custSearch" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<!-- 모달 해더 시작 -->
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3>회원정보 조회</h3>
						</div>
						<!-- 모달 해더 끝 -->
						
						<!-- 모달 보디 시작 -->
						<div class="modal-body">

				<h5>아이디 정보</h5>
				
				<table class="createId table" id="idtbl">


					<tr>
						<th width="205">아이디:</th>
						<td colspan="1" width="240">
							TEST001
						</td>
						<td></td>
					</tr>
					<tr>
						<th >비밀번호:</th>
						<td>
							********
						</td>
						<td>
							<a>[비밀번호 보기]</a>
						</td>
					</tr>
					
				<!-- 	<tr>
						<td rowspan="3">비밀번호 안전 등급 표기 위치</td>
						<td></td>
						<td></td>
					</tr> -->
				</table>

				<h5>기본 정보</h5>
				<table class="createId table" id="test001">
			<tr>
				<th>이름:</th>
				<td>홍길동</td>
			</tr>
			<tr>
				<th>성별:</th>
				<td>남자</td>
			</tr>
			<tr>
				<th>주민번호:</th>
				<td>
					940123-1122345
				</td>
			</tr>
			<tr>
				<th>주소:</th>
				<td>서울특별시 강남구 역삼동 테헤란로 132</td>
			</tr>
			<tr>
				<th>E-Mail:</th>
				<td>TEST001@gmail.com</td>
			</tr>
			<tr>
				<th>연락처:</th>
				<td>010<span>-</span>1111<span>-</span>1111</td>
			</tr>
			<tr>
				<th>큐레이션레터 서비스:</th>
				<td> 구독</label></td>
			</tr>
			<tr>
				<th>개인정보 유효 기간</th>
				<td> 1년</td>
			</tr>		
		</table>
				
						</div>
						<!-- 모달 보디 끝 -->
					</div>
				</div>
			</div>
		<!--########### 회원 정보 조회 모달 끝 -->



		<!--########### 회원 탈퇴 모달 시작  -->
			<div class="modal fade" id="custWithdrawal" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<!-- 모달 해더 시작 -->
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3>회원 탈퇴</h3>
						</div>
						<!-- 모달 해더 끝 -->
							
						<!-- 모달 보디 시작 -->
						<div class="modal-body">
							<p>회원 번호: 1</p>
							<p>'홍길동'님의 계정을 <b>삭제하시겠습니까?</b></p>
							<input type="button" id="withdrawalbtn" class="mdalbtn" value="확인">
						</div>
						<!-- 모달 보디 끝 -->
					</div>
				</div>
			</div>
		<!--########### 회원 정보 조회 모달 끝 -->
		
		<!--########### 회원 휴면 전환 모달 시작  -->
			<div class="modal fade" id="custdormancy" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<!-- 모달 해더 시작 -->
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3>휴면 계정 전환</h3>
						</div>
						<!-- 모달 해더 끝 -->
							
						<!-- 모달 보디 시작 -->
						<div class="modal-body">
							<p>회원 번호: 1</p>
							<p>'홍길동'님의 계정을 <b>휴면계정으로 전환하시겠습니까?</b></p>
							<input type="button" id="withdrawalbtn" class="mdalbtn" value="확인">
						</div>
						<!-- 모달 보디 끝 -->
					</div>
				</div>
			</div>
		<!--########### 회원 휴면 전환 모달 끝 -->
	
	
	
	
	
	
	
	
	
	<script>
	$(document).ready(function() {
		//최상단 체크박스 클릭
		$("#allCheck").click(function() {
			//클릭되었으면
			if ($("#allCheck").prop("checked")) {
				//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
				$("input[name=chk]").prop("checked", true);

				//클릭이 안되있으면
			} else {
				//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
				$("input[name=chk]").prop("checked", false);
			}
		})
	})
	

	/* $(function(){
	$("#selbox").change(function() {
			if($("#selbox").val() == "direct") {
				$("#selboxDirect").show();
			}  else {
				$("#selboxDirect").hide();
			}
		}) 
	}); */
	</script>
</body>
</html>