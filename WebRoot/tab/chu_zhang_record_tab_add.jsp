<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


function submit_search(){
		document.forms[0].action = "queryOutAccount.do";
		document.forms[0].submit();
}
function submit_add(){
		document.forms[0].action = "getOutAccount.do";
		document.forms[0].submit();
}

function submit_check(){
		var myForm = document.forms[1];
		if(myForm.recordMonth1.value=="") {
			alert("请输入出账月份！");
			return;
		}
		if(myForm.cityCode.value=="") {
			alert("请选择出账城市！");
			return;
		}
		if(myForm.productCode.value=="") {
			alert("请选择产品名称！");
			return;
		}
		if(myForm.accountTypeCode.value=="") {
			alert("请输入出账收入类型！");
			return;
		}
		
		if(myForm.fee.value=="") {
			alert("请输入出账金额！");
			myForm.fee.focus();
			return;
		}
		if(!isInt(myForm.fee.value)){
	    	alert("出账金额应为数字！");
			myForm.fee.focus();
			return;
		}
		document.forms[1].action = "addOutAccount.do";
		document.forms[1].submit();
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
                <td width="3%"><div align="center"><img src="images/tb.gif" width="16" height="16" /></div></td>
                <td width="97%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：手工录入--&gt;<font color="red">出账收入录入</font></td>
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
            <td width="100%" height="22" colspan="2" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3">出账查询选择</span></div></td>
          </tr>
          <tr>
            <td width="20%"  height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">出账月份：
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;
            	从 <input type="text"  name="recordMonth1" value="${recordMonth1 }" class="calinput" onclick="showcalendar(event, this);"  readonly="true"/>到
            	<input type="text"  name="recordMonth2" value="${recordMonth2 }" class="calinput" onclick="showcalendar(event, this);"  readonly="true"/>(日期格式：YYYY-MM-DD，起始日期须小于结束日期) 
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">出账城市：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
             <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="cityCode" style="width:120px">
              		<option value="">全部</option>
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
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">产品名称：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="productCode" style="width:300px">
              		<option value="">全部</option>
              		<c:forEach items="${productList}" var="product">
              			<c:if test="${productCode==product.productTypeCode}">
              				<option value="${product.productTypeCode }" selected="selected">${product.productName }</option>
              			</c:if>
              			<option value="${product.productTypeCode }">${product.productName }</option>
              		</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">出账收入类型：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="accountTypeCode" style="width:500px">
              		<option value="">全部</option>
              		<c:forEach items="${typeList}" var="type">
              			<c:if test="${accountTypeCode==type.outAccountTypeCode}">
              				<option value="${type.outAccountTypeCode }" selected="selected">${type.outAccountTypeName }</option>
              			</c:if>
              			<option value="${type.outAccountTypeCode }">${type.outAccountTypeName }</option>
              		</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">稽查状态：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="checkCode" style="width:80px">
              		<option value="">全部</option>
              		<c:if test="${checkCode==2}">
              			<option value="2" selected="selected">未稽核</option>
              		</c:if>
              		<c:if test="${checkCode!=2}">
              			<option value="2">未稽核</option>
              		</c:if>
              		<c:if test="${checkCode==1}">
              			<option value="1" selected="selected">稽核成功</option>
              		</c:if>
              		<c:if test="${checkCode!=1}">
              			<option value="1">稽核成功</option>
              		</c:if>
              		<c:if test="${checkCode==0}">
              			<option value="0" selected="selected">稽核失败</option>
              		</c:if>
              		<c:if test="${checkCode!=0}">
              			<option value="0">稽核失败</option>
              		</c:if>
              	</select>
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
        <td width="100%" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table></td>
        <td width="60"><table width="55" border="0" cellpadding="0" cellspacing="0" height="34">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><input type="button" value="新增" class="STYLE3" onclick="submit_add()"/></div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="55" border="0" cellpadding="0" cellspacing="0" height="34">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/33.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><input type="button" value="查询" class="STYLE3" onclick="submit_search()"/><br/></td>
                  </tr>
                </table></td>
                <td width="60"><table width="55" border="0" cellpadding="0" cellspacing="0" height="34">
                  <tr>
                    <td class="STYLE1"><div align="center"></div></td>
                    <td class="STYLE1"><br/></td>
                  </tr>
                </table></td>
        <td width="1%"  height="35"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>

<br/><br/>

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
                <td width="97%" align="center" class="STYLE3">出账收入录入</td>
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
            <td width="20%"  height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">出账月份：
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="recordMonth1" value="${recordMonth1 }" class="calinput" onclick="showcalendar(event, this);" readonly="true" />(日期格式：YYYY-MM-DD)
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">地市名称：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
             <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="cityCode" style="width:120px">
              		<option value="">全部</option>
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
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">产品名称：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="productCode" style="width:300px">
              		<option value="">全部</option>
              		<c:forEach items="${productList}" var="product">
              			<c:if test="${productCode==product.productTypeCode}">
              				<option value="${product.productTypeCode }" selected="selected">${product.productName }</option>
              			</c:if>
              			<option value="${product.productTypeCode }">${product.productName }</option>
              		</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">出账收入类型：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="accountTypeCode" style="width:500px">
              		<option value="">全部</option>
              		<c:forEach items="${typeList}" var="type">
              			<c:if test="${accountTypeCode==type.outAccountTypeCode}">
              				<option value="${type.outAccountTypeCode }" selected="selected">${type.outAccountTypeName }</option>
              			</c:if>
              			<option value="${type.outAccountTypeCode }">${type.outAccountTypeName }</option>
              		</c:forEach>
              	</select>
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">出账金额：
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<input type="text" name="fee" style="width: 110px"/>
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
                  <td align="center"><a onclick="submit_check()" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image12','','images/bt44.GIF',1)"><img src="images/bt4.GIF" name="Image12" width="79" height="23" border="0" id="Image12" /></a></td>
                  </tr>
                </table></td>
                <td width="60"><br></td>
                
        <td width="1%"  height="35"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
