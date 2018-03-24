<?php include("conecta.php") ?>
<?php include("funcoes-usuario.php") ?>
<?php
  $email = $_POST["email"];
  $senha = $_POST["senha"];
  $usuario = buscaUsuario($conexao, $email, $senha);

if ($usuario == null) {
  header("Location:index.php?login=0");
}
else {
  logaUsuario($email);
  header("Location:index.php?login=1");
}
die();
?>
