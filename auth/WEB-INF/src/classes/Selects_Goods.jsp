<%@ page import="java.sql.*, classes.DBAccess"
    contentType="text/html; charset=euc-jp" %>
<%
// ����: �ǡ����١����˥�����������
 
// DBAccess �Υ��󥹥��󥹤���������
DBAccess db = new DBAccess();
 
// �ǡ����١����ؤΥ�������
db.open();
 
// ���С������
ResultSet rs = db.getResultSet("select * from member");
 
// ���С�����ɽ���ѤΥơ��֥�
String tableHTML = "<table border=1>";
tableHTML += "<tr bgcolor=\"000080\"><td><font color=\"white\">���С�ID</font></td>"
    + "<td><font color=\"white\">̾��</font></td>"
    + "<td><font color=\"white\">����</font></td>";
 
// �������줿�Ʒ�̤��Ф��Ƥν���
while(rs.next()) {
 
    int id = rs.getInt("member_id"); // ���С�ID�����
    String name = rs.getString("name"); // ���С�̾�����
    String kana = rs.getString("kana"); // ���С�̾(����)�����
 
    // ʸ�������ɤ� EUC_JP ����Unicode ���Ѵ�
    name = new String(name.getBytes("8859_1"), "EUC_JP");
    kana = new String(kana.getBytes("8859_1"), "EUC_JP");
 
    // �ơ��֥���HTML�����
    tableHTML += "<tr><td align=\"right\">" + id + "</td>"
              + "<td>" + name + "</td><td>" + kana + "</td></tr>";
}
 
tableHTML += "</table>";
 
// �ǡ����١����ؤΥ��ͥ��������Ĥ���
db.close();
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><title>�ǡ����١����ؤΥ�������</title></head>
<body>
<p>-- �ǡ����١����ؤΥ������� --</p>
<p>
<b>���С��ΰ���</b><br>
<%= tableHTML %>
</p>
</body>
</html>