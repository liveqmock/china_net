<%@ page contentType="text/html; charset=GBK" language="java"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE2 {font-size: 9px}
.STYLE3 {
	color: #033d61;
	font-size: 12px;
}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="70" background="images/main_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="24" background="images/main_03.gif">&nbsp;</td>
            <td width="505" background="images/main_04.gif">&nbsp;</td>
            <td>&nbsp;</td>
            <td width="21"><img src="images/main_07.gif" width="21" height="24"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="38"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="38" background="images/main_09.gif">&nbsp;</td>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="77%" height="25" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                </table></td>
                <td width="220" valign="bottom"  nowrap="nowrap"><div align="right"><span class="STYLE1"><span class="STYLE2">■</span>今天是: <script language="javascript">
						var week; 
						if(new Date().getDay()==0)          week="星期日"
						if(new Date().getDay()==1)          week="星期一"
						if(new Date().getDay()==2)          week="星期二" 
						if(new Date().getDay()==3)          week="星期三"
						if(new Date().getDay()==4)          week="星期四"
						if(new Date().getDay()==5)          week="星期五"
						if(new Date().getDay()==6)          week="星期六"
						document.write(new Date().getFullYear()+"年"+(new Date().getMonth()+1)+"月"+new Date().getDate()+"日 "+week);
					</script></span></div></td>
              </tr>
            </table></td>
            <td width="21"><img src="images/main_11.gif" width="21" height="38"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="8" style=" line-height:8px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" background="images/main_29.gif" style=" line-height:8px;">&nbsp;</td>
            <td width="505" background="images/main_30.gif" style=" line-height:8px;">&nbsp;</td>
            <td style=" line-height:8px;">&nbsp;</td>
            <td width="21" style=" line-height:8px;"><img src="images/main_31.gif" width="21" height="8"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" background="images/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="177" height="28" background="images/main_32.gif"><table width="177" border="0" cellspacing="0" cellpadding="0" height="24">
          <tr>
            <td width="20%"  height="22">&nbsp;</td>
            <td width="59%" valign="bottom"><div align="center" class="STYLE1">当前用户：${user.name }</div></td>
            <td width="21%">&nbsp;</td>
          </tr>
        </table></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="65" height="28"></td>
            <td width="63"><br></td>
            <td width="3"><br></td>
            <td width="63"><br></td>
            <td width="3"><br></td>
            <td width="63"><br></td>
            <td width="3"><br></td>
            <td width="63"><br></td>
            <td width="3"><br></td>
            <td width="63"><br></td>
            <td width="3"><br></td>
            <td width="63"><br></td>
            <td width="3"><br></td>
            <td width="30"><br></td>
            <td width="25" class="STYLE3"><a href="logout.do" target="_top">退出</a><br></td><!-- target="_top"整个框架页面刷新返回登录界面 -->
          </tr>
        </table></td>
        <td width="21"><img src="images/main_37.gif" width="21" height="28"></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
