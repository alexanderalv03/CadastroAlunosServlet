<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de alunos</title>
</head>
<body>

<%String usuario = (String) session.getAttribute("usuario"); %>

<%if (usuario==null){
	response.sendRedirect("index.jsp");
	
 %>

<% }else{

	out.print("Bem vindo, " + usuario + "<br");%>
	
<% }%>

<span>Clique <a href="cadastrarAlunos.jsp"> aqui </a> para cadastrar um aluno</span>

<%List<Aluno> listaAlunos = (List<Aluno>) request.getAttribute("listaAlunos"); %>

<%if (listaAlunos == null) {%>
	<h3>Nenhum Aluno Cadastrado</h3>
<%}else{ %>
	<h2>Alunos Cadastrados</h2>
	<table border="1">
		<tr>
		<th>Detalhar</th>
		<th>Matrícula</th>
		<th>Nome</th>
		<th>Idade</th>
		<th>Sexo</th>
		<th>Semestre</th>
		<th>Excluir</th>
		
		</tr>
	<%for (Aluno aluno : listaAlunos){ %>
	<tr>
	<td> <a href="DetalharServlet?id=<%=aluno.getId()%>">Detalhar </a></td>
	<td><%=aluno.getMatricula() %></td>
	<td><%=aluno.getNome()%></td>
	<td><%=aluno.getIdade()%></td>
	<td> <%=aluno.getGenero()%></td>
	<td> <%=aluno.getSemestre()%></td>
		<td> <a href="ExcluirServlet?id=<%=aluno.getId()%>">Excluir </a></td>
	
	
	</tr>
	<%} %>
	</table>
<% } %>
<br>
<a href="LogoutServlet"> Sair </a>

</body>
</html>