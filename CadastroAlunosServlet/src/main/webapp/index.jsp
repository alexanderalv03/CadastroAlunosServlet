<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Cadastro de Alunos</title>
</head>

<h1>Sistema de Cadastro de Alunos</h1> <br>

<h2>Informe seu usuario e senha</h2>

<form action="LoginServlet" method="post">
<br>
Login:<input type="text" name="usuario" required>
<br><br>
Senha:<input type="password" name="senha" required>
<br><br>
<input type="submit" value="Efetuar Login">
<br><br>

<%=request.getAttribute("mensagem") == null ? "": request.getAttribute("mensagem") %>



</form>

<body>

</body>
</html>