<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
<script type="text/javascript" src="/js/function.js"></script>
</head>

<body>
	<form action = "/deviceList" method="post">
		 단말 <br>
        <input type="checkbox" name="checkedValue" value="Galaxy Note20 5G"/>갤럭시 노트20 5G
        <input type="checkbox" name="checkedValue" value="Galaxy S10"/>갤럭시 S10
        <input type="checkbox" name="checkedValue" value="Galaxy Z Flip3 5G"/>갤럭시 Z Flip3 5G
        <input type="checkbox" name="checkedValue" value="Galaxy S21 Ultra"/>갤럭시 S21 울트라
     
        <br><br>테스트 앱 <br>
         <input type="checkbox" name="checkedApplication" value="gigagenie"/>기가지니
         <input type="checkbox" name="checkedApplication" value="ktshow"/>마이케이티
           <input type="checkbox" name="checkedApplication" value="olleh.android"/>KT멤버십
             <input type="checkbox" name="checkedApplication" value="onenavi"/>원내비
               <input type="checkbox" name="checkedApplication" value="ollehtvguide"/>올레 tv play
                 <input type="checkbox" name="checkedApplication" value="gigageniehome"/>기가지니 홈 IoT
         <br> <br>부서명 :
           <input type="text" name="depName"/>
            <br> <br>이름 :
         <input type="text" name="name"/> <br> <br>
         <table>
        <tr>
            <th>예약시간</th>
            <td>
                <select name="year" id="year">
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                </select>년
                <select name="month" id="month">
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>월
                <select name="day">
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
                </select>일
                 <select name="hour" id="hour">
              		<option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                </select>시
            </td>
        </tr>
    </table>
        <br>
        <button type="submit">즉시실행</button> 
       <button type="submit">확인</button> 
    </form>
</body>
</html>