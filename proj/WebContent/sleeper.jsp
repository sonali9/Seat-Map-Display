<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ include file="header.html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<%
		String cls = request.getParameter("class1");
		String t = request.getParameter("trainNo");
		String date = request.getParameter("startdate");
		int tno = Integer.parseInt(t);

		PreparedStatement ps;

		String s1 = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/PRSDB", "root",
				"12345678");
		Connection co = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/PRSDB", "root",
				"12345678");

		Statement stmt = (Statement) con.createStatement();
		ps = co.prepareStatement("UPDATE userinfo SET Berth_Availability='no' where Coach_id=? AND Berth_id=?");
		ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo WHERE Train_no= '" + tno + "'");
	%>

	<div class="container" style="margin-top: 50px; margin-bottom: 75px">
		<div class="page header">
			<h1>${param.class1}</h1>
		</div>
		<%
			String cid = "none";

			int k = 0;
			while (rs.next()) {

				if (rs.getString(3).equals("SL")) {
					if (!rs.getString(4).equals(cid))
						k++;
		%>

		<div class="row">
			<div class="col-md-4 one">
				<button class="sl s<%=k%>">
					<%=rs.getString(4)%>
					<%
						cid = rs.getString(4);
					%>
				</button>
			</div>
			<div class="row main<%=k%>">
				<div class="col-md-8" style="width: 50%; margin: 10px -50px">
					<%
						int a = 0;
						for (int j = 0; j < 3; j++) {
					%>
					
					<div class="col-md-4">
						<div class="row bg-warning">
							<%
								for (int i = 0; i < 3; i++) {
							%>
							<div class="col-md-4 coach1 <%=cid%>">
								<div class="btn-group-vertical left" role="group"
									aria-label="...">
									<%
										a = rs.getInt(5);
									%>

									<button class="btn btn-success" onclick="<%ps.setString(1, cid);
										ps.setInt(2, a);
										ps.addBatch();%>"><%=a%></button>

									<%
										rs.next();
										a = rs.getInt(5);
									%>
									<button class="btn btn-primary" onclick="<%ps.setString(1, cid);
										ps.setInt(2, a);
										ps.addBatch();%>"><%=a%></button>

									<%
										rs.next();
										a = rs.getInt(5);
									%>
									<button class="btn btn-danger" onclick="<%ps.setString(1, cid);
										ps.setInt(2, a);
										ps.addBatch();%>"><%=a%></button>
								</div>

								<div class="btn-group-vertical right" role="group" aria-label="...">
								<%
										rs.next();
										a = rs.getInt(5);
								%>
								<button class="btn btn-success" onclick="<%ps.setString(1, cid);
										ps.setInt(2, a);
										ps.addBatch();%>"><%=a%></button>

								<%
										rs.next();
										a = rs.getInt(5);
								%>
								<button class="btn btn-primary" onclick="<%ps.setString(1, cid);
										ps.setInt(2, a);
										ps.addBatch();%>"><%=a%></button>

								<%
										rs.next();
										a = rs.getInt(5);
								%>
								<button class="btn btn-danger" onclick="<%ps.setString(1, cid);
										ps.setInt(2, a);
										ps.addBatch();%>"><%=a%></button>
								</div>
								
								<%
										rs.next();
										a = rs.getInt(5);
								%>
								<button class="btn btn-info bottom-right" onclick="<%ps.setString(1, cid);
										ps.setInt(2, a);
										ps.addBatch();%>"><%=a%></button>

								<%
										rs.next();
										a = rs.getInt(5);
								%>
								<button class="btn btn-warning bottom-left" onclick="<%ps.setString(1, cid);
										ps.setInt(2, a);
										ps.addBatch();%>"><%=a%></button>
							</div>
							<%
							if(rs.getString(5).equals("72")){
								break;
							}
								rs.next();			
								}
							%>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<%
					ps.executeBatch();
				}
			}
		%>
	</div>
<%@ include file="footer.html" %>
</body>
</html>