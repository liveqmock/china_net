<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

function submit_delete() {
    	if (window.confirm("ɾ���������ָܻ���ȷʵҪɾ����")) { 
    		return true;
    	}else{
    		return false;
    	}
}
function firstPage(){
		document.forms[0].action = "queryCardSale.do?currentPage=1";
		document.forms[0].submit();
}
function previousPage(){
		document.forms[0].action = "queryCardSale.do?currentPage="+document.getElementById('previousPage').value;
		document.forms[0].submit();
}
function nextPage(){
		document.forms[0].action = "queryCardSale.do?currentPage="+document.getElementById('nextPage').value;
		document.forms[0].submit();
}
function lastPage(){
		document.forms[0].action = "queryCardSale.do?currentPage="+document.getElementById('lastPage').value;
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
		document.forms[0].action = "queryCardSale.do?currentPage="+document.getElementById('jump').value;
		document.forms[0].submit();
}
function submit_add() {
		document.forms[0].action = "getCardSale1.do";
		document.forms[0].submit();
}
function submit_search(){
		document.forms[0].action = "queryCardSale.do";
		document.forms[0].submit();
}
</script>

</head>

<body>
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
                <td width="97%" class="STYLE1"><span class="STYLE3">�㵱ǰ��λ��</span>���ֹ�¼��--&gt;<font color="red">����������¼��</font></td>
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
            <td width="100%" height="22" colspan="2" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3">�����۲�ѯѡ��</span></div></td>
          </tr>
          <tr>
            <td width="20%"  height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">�������ڣ�
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="left">&nbsp;
            	�� <input type="text"  name="recordMonth1" value="${recordMonth1 }" class="calinput" onclick="showcalendar(event, this);"  readonly="true"/>��
            	<input type="text"  name="recordMonth2" value="${recordMonth2 }" class="calinput" onclick="showcalendar(event, this);"  readonly="true"/>(���ڸ�ʽ��YYYY-MM-DD����ʼ������С�ڽ�������) 
              </div>
            </div></td>
          </tr>
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">���۳��У�
              <br/>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
             <div align="left">&nbsp;&nbsp;&nbsp;&nbsp;
              	<select name="cityCode" style="width:120px">
              		<option value="">ȫ��</option>
              		<c:forEach items="${city}" var="c">
              		<c:if test="${cityCode==c.cityCode}">
              		<option value="${c.cityCode}" selected="selected">${c.cityName }</option>
              		</c:if>
              		<option value="${c.cityCode}">${c.cityName }</option>
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
              		<c:forEach items="${product}" var="p">
              		<c:if test="${productCode==p.productCode }">
              		<option value="${p.productCode }" selected="selected">${p.productName }</option>
              		</c:if>
              		<option value="${p.productCode }">${p.productName }</option>
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
                    <td class="STYLE1"><div align="center"><img src="images/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><input type="button" value="����" class="STYLE3" onclick="submit_add()"/></div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="55" border="0" cellpadding="0" cellspacing="0" height="34">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/33.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><input type="button" value="��ѯ" class="STYLE3" onclick="submit_search()"/><br/></td>
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
                <td align="center"><span class="STYLE3">���м�¼</span></td>
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
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="6%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">��������</span></div></td>
            <td width="10%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">����</span></div></td>
            <td width="20%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">��Ʒ����</span></div></td>
            <td width="8%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">��������ֵ</span></div></td>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">������</span></div></td>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">���ܽ��</span></div></td>
            <td width="6%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">�ۿۺ���</span></div></td>
            <td width="6%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">�ۿ۶��</span></div></td>
            <td width="6%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">¼����Ա</span></div></td>
            <td width="5%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">����״̬</span></div></td>
            <td width="10%" height="22" background="images/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">��������</div></td>
          </tr>
          <c:if test="${isEmpty==null}">
          	<span class="STYLE1">û�����������ļ�¼��</span>
          </c:if>
          <c:forEach items="${cardSaleList}" var="cardSale">
          <tr>
            <td height="25" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">${cardSale.yearMonth }</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">${cardSale.cityName }</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">${cardSale.productName }</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${cardSale.parValue }</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${cardSale.amount }</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${cardSale.totalFee }</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${cardSale.discountFee }</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${cardSale.discount } </span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${cardSale.recordOperator }</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${cardSale.selectAuditStatus }</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4">
            <img src="images/edt.gif" width="16" height="16" /><a href="getCardSaleMsg.do?cardSaleId=${cardSale.cardSaleId }">�޸�</a>&nbsp; &nbsp;
            <img src="images/del.gif" width="16" height="16" /><a onclick="return submit_delete()" href="deleteCardSale.do?cardSaleId=${cardSale.cardSaleId }" >ɾ��</a></span></div></td>
          </tr>
          </c:forEach>
        </table></td>
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
</table>
</body>
</html>
