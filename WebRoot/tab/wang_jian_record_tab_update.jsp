<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>电信报表管理系统</title>
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
<script type="text/javascript" src="js/calendar.js" charset="GB2312"></script>
<script type="text/javascript" src="js/formChk.js"></script>
<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
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

function submit_update(){
		var myForm = document.forms[0];
		if(myForm.recordMonth1.value=="") {
			alert("请输入出账月份！");
			return;
		}
		if(myForm.amount.value=="") {
			alert("请输入结算金额！");
			myForm.amount.focus();
			return;
		}
		if(!isInt(myForm.amount.value)){
	    	alert("结算金额应为数字！");
			myForm.amount.focus();
			return;
		}
		document.forms[0].action = "updateInterSettle.do";
		document.forms[0].submit();
}
</script>

</head>

<body onload="MM_preloadImages('images/bt44.GIF')">
<br/>
<form action="" method="post">
<table width="95%" align="center" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="97%" align="center" class="STYLE3">网间结算修改</td>
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
            <td width="20%"  height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">结算月份： 
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="text" name="recordMonth1" value="${month }" class="calinput" onclick="showcalendar(event, this);" readonly="true"/>(日期格式：YYYY-MM-DD)
              </div>
            </div></td>
          </tr>
         <tr>
             <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">结算城市： 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
             <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="cityCode" style="width:120px">
              		<c:forEach items="${cityList}" var="a">
              			<c:if test="${cityCode==a.cityCode}">
              				<option value="${a.cityCode }" selected="selected">${a.cityName }</option>
              			</c:if>
              				<option value="${a.cityCode }">${a.cityName }</option>
              		</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">产品名称：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="productCode" style="width:300px">
              		<c:forEach items="${productList}" var="b">
              			<c:if test="${productCode==b.productCode}">
              				<option value="${b.productCode }" selected="selected">${b.productName }</option>
              			</c:if>
              			<option value="${b.productCode }">${b.productName }</option>
              		</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
           <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">结算运营商： 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="balanceSpCode" style="width:120px">
              		<c:forEach items="${balanceSpList}" var="c">
              		<c:if test="${balanceSpCode==c.balanceSpCode}">
              				<option value="${c.balanceSpCode }" selected="selected">${c.balanceSpName }</option>
              		</c:if>
					<option value="${c.balanceSpCode }">${c.balanceSpName }</option>
					</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">结算类型： 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="balanceTypeCode" style="width:120px">
              		<c:forEach items="${balanceTypeList}" var="d">
              		<c:if test="${balanceTypeCode==d.balanceTypeCode}">
              			<option value="${d.balanceTypeCode }" selected="selected">${d.balanceTypeName }</option>
              		</c:if>
					<option value="${d.balanceTypeCode }">${d.balanceTypeName }</option>
					</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">结算金额： 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<input type="text" name="amount" value="${amount }" style="width: 110px"/>
              	<input type="hidden" name="interSettleId" value="${interSettleId }"/>
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
                  <td align="center"><a onclick="submit_update()" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image5','','images/bt44.GIF',1)"><img src="images/bt4.GIF" name="Image5" width="79" height="23" border="0" id="Image5" /></a></td>
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