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
<script type="text/javascript" src="js/calendar.js" charset="GB2312"></script>
<script type="text/javascript" src="js/formChk.js"></script>
<script language="javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/jquery-1.4.min.js"></script>
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


function submit_search(){
		document.forms[0].action = "queryCheckInterSettle.do";
		document.forms[0].submit();
}


function firstPage(){
		document.forms[0].action = "queryCheckInterSettle.do?currentPage=1";
		document.forms[0].submit();
}
function previousPage(){
		document.forms[0].action = "queryCheckInterSettle.do?currentPage="+document.getElementById('previousPage').value;
		document.forms[0].submit();
}
function nextPage(){
		document.forms[0].action = "queryCheckInterSettle.do?currentPage="+document.getElementById('nextPage').value;
		document.forms[0].submit();
}
function lastPage(){
		document.forms[0].action = "queryCheckInterSettle.do?currentPage="+document.getElementById('lastPage').value;
		document.forms[0].submit();
}
function jumpPage(){
		var id = document.getElementById('jump').value;
		if(id=="") {
			alert("��������ת���ڼ�ҳ��");
			document.getElementById('jump').focus();
			return;
		}
		if(!isInt(id)){
	    	alert("ֻ��Ϊ���֣�");
			document.getElementById('jump').focus();
			return;
		}
		document.forms[0].action = "queryCheckInterSettle.do?currentPage="+document.getElementById('jump').value;
		document.forms[0].submit();
}

function selectAll()
{
  //��ǰ�ĵ��Ͽؼ�check������
  if(document.getElementById("checkAll").checked){
  	var count = self.document.all.item("chk");
  	for(i=0;i<count.length;i++){
    	self.document.all.item("chk",i).checked =true;
 	}
  }else{
  	var count = self.document.all.item("chk");
  	for(i=0;i<count.length;i++){
    	self.document.all.item("chk",i).checked =false;
 	}
  }
}



//��������״̬AJAX
//��һ������
var XMLHttpReq=false;
//����һ��XMLHttpRequest����
function createXMLHttpRequest(){
if(window.XMLHttpRequest){ //Mozilla 
    XMLHttpReq=new XMLHttpRequest();
    }
    else if(window.ActiveXObject){
   try{
   XMLHttpReq=new ActiveXObject("Msxml2.XMLHTTP");
   }catch(e){
       try{
      XMLHttpReq=new ActiveXObject("Microsoft.XMLHTTP");
      }catch(e){}
      }
       }
}
//����������
function send(url){
createXMLHttpRequest();
XMLHttpReq.open("get",url,true);
XMLHttpReq.onreadystatechange=proce; //ָ����Ӧ�ĺ���
XMLHttpReq.send(null);   //��������
}
function proce(){
if(XMLHttpReq.readyState==4){ //����״̬
if(XMLHttpReq.status==200){//��Ϣ�ѳɹ����أ���ʼ������Ϣ 
            <!--���Զ�ȡxml��ʼ-->
var root=XMLHttpReq.responseXML;
var res=root.getElementsByTagName("content1")[0].firstChild.data;
var outAccountId=root.getElementsByTagName("content2")[0].firstChild.data;
var msg="#"+outAccountId;
$(msg).html(res);//ʹ��jQuery�޸Ļ���״̬,��js�ļ�������js��ͻ������javascript����
//document.body.getElementsByTagName("span")[14].firstChild.data=res;//javascript����
//window.alert(res); 
    <!--���Զ�ȡxml����--> 
//var xmlReturn = XMLHttpReq.responseText;
//window.alert(xmlReturn);
}else{
    window.alert("�������ҳ�����쳣");
    }
  }
}
//������������״̬
function checkSuccess(id){
   send('updateAuditStatusInterSettle.do?status=1&interSettleId='+id);      
}

function checkFail(id){
   send('updateAuditStatusInterSettle.do?status=0&interSettleId='+id);          
}

//�����������״̬
function checkAllSuccess(){
	if (checkNull(document.forms[1])) {
		var url="updateAuditStatusInterSettle.do?status=1";
		var count = self.document.all.item("chk");
		for(i=0;i<count.length;i++){
	    	if(self.document.all.item("chk",i).checked){
	    		url=url+"&interSettleIds="+self.document.all.item("chk",i).value;
	    		//alert(self.document.all.item("check",i).value)
	    	}
 		}
  		 send(url);  
	} else {
		alert("������Ŀ����Ϊ�գ���ѡ��Ҫ��������Ŀ��");
	}
}

function checkAllFail(){
	if (checkNull(document.forms[1])) {
		var url="updateAuditStatusInterSettle.do?status=0";
		var count = self.document.all.item("chk");
		for(i=0;i<count.length;i++){
	    	if(self.document.all.item("chk",i).checked){
	    		url=url+"&interSettleIds="+self.document.all.item("chk",i).value;
	    		//alert(self.document.all.item("check",i).value)
	    	}
 		}
  		 send(url);  
	} else {
		alert("������Ŀ����Ϊ�գ���ѡ��Ҫ��������Ŀ��");
	}
}
</script>

</head>

<body onload="MM_preloadImages('images/bt11.GIF','images/bt22.GIF','images/bt33.GIF')">
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
                <td width="3%"><div align="center"><img src="images/tb.gif" width="16" height="16" /></div></td>
                <td width="97%" class="STYLE1"><span class="STYLE3">�㵱ǰ��λ��</span>���տ����--><font color="red">��������������</font></td>
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
            <td width="100%" height="22" colspan="2" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3">��������ѯѡ��</span></div></td>
          </tr>
          <tr>
           <td width="20%"  height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">�����·ݣ�
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;
            	�� <input type="text"  name="recordMonth1" value="${recordMonth1 }" class="calinput" onclick="showcalendar(event, this);"  readonly="true"/>��
            	<input type="text"  name="recordMonth2" value="${recordMonth2 }" class="calinput" onclick="showcalendar(event, this);"  readonly="true"/>(���ڸ�ʽ��YYYY-MM-DD����ʼ������С�ڽ�������) 
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">������У� 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
             <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="cityCode" style="width:120px">
              		<option value="">ȫ��</option>
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
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">��Ʒ���ƣ�
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="productCode" style="width:300px">
              		<option value="">ȫ��</option>
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
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">������Ӫ�̣� 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="balanceSpCode" style="width:120px">
              		<option value="">ȫ��</option>
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
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">�������ͣ� 
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="balanceTypeCode" style="width:120px">
              		<option value="">ȫ��</option>
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
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">����״̬��  
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="checkCode" style="width:80px">
              		<option value="">ȫ��</option>
              		<c:if test="${checkCode==2}">
              			<option value="2" selected="selected">δ����</option>
              		</c:if>
              		<c:if test="${checkCode!=2}">
              			<option value="2">δ����</option>
              		</c:if>
              		<c:if test="${checkCode==1}">
              			<option value="1" selected="selected">���˳ɹ�</option>
              		</c:if>
              		<c:if test="${checkCode!=1}">
              			<option value="1">���˳ɹ�</option>
              		</c:if>
              		<c:if test="${checkCode==0}">
              			<option value="0" selected="selected">����ʧ��</option>
              		</c:if>
              		<c:if test="${checkCode!=0}">
              			<option value="0">����ʧ��</option>
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
                  <td align="center"><a onclick="submit_search()" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image15','','images/bt11.GIF',1)"><img src="images/bt1.GIF" name="Image15" width="79" height="23" border="0" id="Image15" /></a></td>
                  </tr>
                </table></td>
        <td width="60"><table width="55" border="0" cellpadding="0" cellspacing="0" height="34">
                  <tr>
                  <td align="center"><a onclick="checkAllSuccess()" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image16','','images/bt22.GIF',1)"><img src="images/bt2.GIF" name="Image16" width="79" height="23" border="0" id="Image16" /></a></td>
                  </tr>
                </table></td>
        <td width="60"><table width="55" border="0" cellpadding="0" cellspacing="0" height="34">
                  <tr>
                  <td align="center"><a onclick="checkAllFail()" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image17','','images/bt33.GIF',1)"><img src="images/bt3.GIF" name="Image17" width="79" height="23" border="0" id="Image17" /></a></td>
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


<table width="95%" align="center" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="center"><span class="STYLE3">��ѯ���</span></td>
              </tr>
            </table></td>
            
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td>
         <form action="" method="post">
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="6%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">�����·�</span></div></td>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">�������</span></div></td>
            <td width="20%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">��Ʒ����</span></div></td>
            <td width="25%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">������Ӫ��</span></div></td>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">��������</span></div></td>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">������</span></div></td>
            <td width="5%" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">¼����Ա</span></div></td>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">����״̬</span></div></td>
            <td width="10%" height="22" background="images/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">��������״̬</div></td>
             <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">ȫѡ<input name="select" id="checkAll" type="checkbox" onclick="selectAll()"/></span></div></td>

          </tr>
          <c:if test="${isEmpty==null}">
          	<span class="STYLE1">û�����������ļ�¼��</span>
          </c:if>
          
          <c:forEach items="${interSettleList}" var="interSettle">
	          <tr>
	            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
	              <div align="center">${interSettle.yearMonth }</div>
	            </div></td>
	            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
	              <div align="center">${interSettle.cityName }</div>
	            </div></td>
	            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
	              <div align="center">${interSettle.productName }</div>
	            </div></td>
	            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${interSettle.balanceSpName }</span></div></td>
	            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${interSettle.balanceTypeName }</span></div></td>
	            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${interSettle.amount }</span></div></td>
	            <td bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${interSettle.recordOperator }</span></div></td>
	            <td height="20" bgcolor="#FFFFFF"><div align="center">
	            <span class="STYLE1" id="${interSettle.interSettleId }">
	            ${interSettle.checkStatus }
	            </span></div></td>
	            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4"><img src="images/right.gif" width="16" height="16" />
	            	<a onclick="checkSuccess(${interSettle.interSettleId })"><font color="#006600">�ɹ�</font></a>&nbsp; &nbsp;<img src="images/wrong.gif" width="16" height="16" />
	            	<a onclick="checkFail(${interSettle.interSettleId })"><font color="#990000">ʧ��</font></a></span></div></td>
            	<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><input type="checkbox" name="chk" value="${interSettle.interSettleId }"/></span></div></td>
	          </tr>
          </c:forEach>
          
        </table>
        
         </form>
         
        </td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
           <td class="STYLE4">&nbsp;&nbsp;���� ${page.totalSize } ����¼����ǰ�� ${page.currentPage }/${page.totalPage } ҳ
            </td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <c:if test="${totalRows!=0 }">
	                  <td width="40">
		                  <c:if test="${page.hasFirst}">
		                  <input type="button" value="��ҳ" onclick="firstPage()" />
		            	  </c:if>
	            	  </td>
	                  <td width="45">
		                  <c:if test="${page.hasPrevious}"> 
		                  <input type="hidden" id="previousPage" value="${page.currentPage-1 }"/>
		                  <input type="button" value="��һҳ" onclick="previousPage()" />
		                  </c:if>
	                  </td>
	                  <td width="45">
		                  <c:if test="${page.hasNext}">
		                  <input type="hidden" id="nextPage" value="${page.currentPage+1 }"/>
		                  <input type="button" value="��һҳ" onclick="nextPage()" />
		            	  </c:if>
	                  </td>
	                  <td width="40">
		                  <c:if test="${page.hasLast }">
		                  <input type="hidden" id="lastPage" value="${page.totalPage }"/>
		                  <input type="button" value="βҳ" onclick="lastPage()" />
		            	  </c:if>
	                  </td>
	                  <td width="100"><div align="center"><span class="STYLE1">ת����
	                    <input id="jump" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
	                    ҳ </span></div>
	                  </td>
	                  <td width="40">
	                  	<a onclick="jumpPage()"><img src="images/go.gif" width="37" height="15" /></a>
	                  </td>
                  </c:if>
                  <td width="1"></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>