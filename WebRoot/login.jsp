<%@ page contentType="text/html; charset=GBK" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ҵ��Ϣ����ϵͳ_�û���¼</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow:hidden;
	background-image: url(file:///E|/TDDOWNLOAD/china_netcom/WebRoot/images/blue_backgrounds_login.jpg);
}
.STYLE1 {
	color: #000000;
	font-size: 12px;
}
.STYLE2 {
	font-size: xx-large;
	font-weight: bold;
}
-->
</style>
<script>
function submit_check() {
		var myForm = document.forms[0];
		if(myForm.name.value=="") {
			alert("�������û�����");
			myForm.name.focus();
			return false;
		}
		if(myForm.password.value=="") {
			alert("���벻��Ϊ�գ�");
			myForm.password.focus();
			return false;
		}
		submit_login();
}
function submit_login(){
		document.forms[0].action = "login.do";
		document.forms[0].submit();

}

if (window != top) // ���session������ת����½ҳ�沢����iframe��� 
	top.location.href = location.href; 
</script>

</head>

<body>
 <div align="center"><font color="red">${msg }</font></div>
<div align="center" class="STYLE2">
  <p>���ű���ϵͳ</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
<form method="post">
<table width="100%" hesight="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="53"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="206" background="file:///E|/TDDOWNLOAD/china_netcom/WebRoot/images/kong.png"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="39%" height="25"><div align="right"><span class="STYLE1">�û�</span></div></td>
                <td width="21%" height="25">
                <div align="center">
                  <input type="text" name="name" value="" style="width:105px; height:17px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff"/>
                </div>
                </td>
                <td width="40%" height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25"><div align="right"><span class="STYLE1">����</span></div></td>
                <td height="25"><div align="center">
                  <input type="password" name="password" value="" style="width:105px; height:17px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff"/>
                </div></td>
                <td height="25"><div align="left"><a onclick="submit_check()"><img src="images/dl.gif" width="49" height="18" border="0"/></a></div></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
