<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Contatos</title>

<link rel="stylesheet" type="text/css" href="view/css/estilo.css" />
<link rel="stylesheet" type="text/css"
	href="view/bootstrap/css/bootstrap.min.css" />

<script type="text/javascript" src="view/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

</head>

<body id="corpoPadrao">

			<form action="incluirContato" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="inputNome">Nome</label> <input type="text"
						id="inputNome" class="form-control" name="nome"
						style="width: 500px;" placeholder="Nome" minlength="3"
						maxlength="50" required="required" />
				</div>
				<div class="form-group">
					<label for="inputTelefone">Teledone</label> <input type="text" id="inputPreco"
						class="form-control" name="telefone" style="width: 500px;"
						placeholder="Telefone" maxlength="9" required="required" />
				</div>
				<div class="form-group">
					<label for="inputEndereco">endereço</label> <input type="text"
						id="inputEndereco" class="form-control" name="endereco"
						style="width: 500px;" required="required" maxlength="255" />
				</div>
				<div class="form-group">
					<label for="inputEmail">email</label> <input type="text"
						id="inputEmail" class="form-control" name="email"
						style="width: 500px;" required="required" maxlength="255" />
				</div>
					<button type="submit" value="salvar" class="btn btn-primary">&nbsp;
						Cadastrar &nbsp;</button>

			</form>

</body>
</html>
