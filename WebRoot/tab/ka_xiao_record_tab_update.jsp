<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>���ű������ϵͳ</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
<link href="js/calendar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/calendar.js" charset="GBK"></script>
<script type="text/javascript" src="js/formChk.js"></script>
<script>
var  highlightcolor='#c1ebff';
//�˴�clickcolorֻ����winϵͳ��ɫ������ܳɹ�,�����#xxxxxx�Ĵ���Ͳ���,��û�����Ϊʲô:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function submit_update() {
		document.forms[0].action = "updateCardSale.do";
		document.forms[0].submit();
	}
function submit_check() {
		var myForm = document.forms[0];
		if(myForm.yearMonth.value=="") {
			alert("�����뿨�������ڣ�");
			myForm.yearMonth.focus();
			return false;
		}
		if(myForm.cityCode.value=="") {
			alert("��ѡ��������ƣ�");
			myForm.cityCode.focus();
			return false;
		}
		if(myForm.productCode.value=="") {
			alert("��ѡ���Ʒ���ƣ�");
			myForm.productCode.focus();
			return false;
		}
		if(myForm.parValue.value=="") {
			alert("�����뵥����ֵ��");
			myForm.parValue.focus();
			return false;
		}
		if(myForm.amount.value=="") {
			alert("�����뿨������");
			myForm.amount.focus();
			return false;
		}
		if(myForm.discountFee.value=="") {
			alert("�������ۿۺ��");
			myForm.discountFee.focus();
			return false;
		}
		if(!isInt(myForm.amount.value)){
	    	alert("������ӦΪ�������֣�");
			myForm.amount.focus();
			return false;
		}
		if(!isInt(myForm.parValue.value)){
	    	alert("������ֵ���ӦΪ���֣�");
			myForm.parValue.focus();
			return false;
		}
		if(!isInt(myForm.discountFee.value)){
	    	alert("�ۿۺ���ӦΪ���֣�");
			myForm.discountFee.focus();
			return false;
		}
		submit_update();
}
function submit_mulitple(){
	var pv = document.getElementById("pv").value;
	var am = document.getElementById("am").value;
	document.getElementById("tf").innerText = pv * am;
	
}
function submit_sub(){
	var tf = document.getElementById("tf").value;
	var df = document.getElementById("df").value;
	document.getElementById("dt").innerText = tf - df;
	
}
</script>

</head>

<body onload="MM_preloadImages('images/bt44.GIF')">

<br/>
<form method="post">
<table width="95%" align="center" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="97%" align="center" class="STYLE3">�������޸�</td>
              </tr>
            </table></td>
           
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()" style="">
          
          <tr>
            <td width="20%"  height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">���������ڣ� 
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp; 
              <input type="text" name="yearMonth" value="${month }" class="calinput" onclick="showcalendar(event, this);" readonly="true"/>(���ڸ�ʽ��YYYY-MM)
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">�������ƣ�
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
             <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="cityCode" style="width:120px">
              		<c:forEach items="${cityList}" var="city">
              			<c:if test="${cityCode==city.cityCode}">
              				<option value="${city.cityCode }" selected="selected">${city.cityName }</option>
              			</c:if>
              				<option value="${city.cityCode }">${city.cityName }</option>
              		</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">��Ʒ���ƣ�
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="productCode" style="width:300px">
              		<c:forEach items="${productList}" var="product">
              			<c:if test="${productCode==product.productCode}">
              				<option value="${product.productCode }" selected="selected">${product.productName }</option>
              			</c:if>
              			<option value="${product.productCode }">${product.productName }</option>
              		</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">������ֵ�� 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<input type="text" name="parValue" value="${pv }" style="width: 150px" id="pv" onchange="submit_mulitple();"/>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">�������� 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<input type="text" name="amount" value="${amount }" style="width: 150px" id="am" onchange="submit_mulitple();"/>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">���ܽ� 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<input type="text" name="totalFee" value="${tf }" style="width: 150px" id="tf" onchange="submit_sub();"/>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">�ۿۺ�� 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<input type="text" name="discountFee" value="${df }" style="width: 150px" id="df" onchange="submit_sub();"/>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">�ۿ۶ 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<input type="text" name="discount" value="${dt }" style="width: 150px" id="dt" onchange="submit_sub();"/>
              	<input type="hidden" name="cardSaleId" value="${cardSaleId }"/>
              </div>
            </div></td>
          </tr>
        </table></td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="1%" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        
        <td width="99%"><table width="100%" border="0" cellpadding="0" cellspacing="0" height="19">
                  <tr>
                  <td align="center"><a onclick="submit_check()" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image5','','images/bt44.GIF',1)"><img src="images/bt4.GIF" name="Image5" width="79" height="23" border="0" id="Image5" /></a></td>
                  </tr>
                </table></td>
                <td width="60"><br/></td>
                
        <td width="1%"  height="35"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
