<?php
function buscaUsuario($conexao, $email, $senha){
  $senha_cripto = md5($senha);
  $sql = "select * from usuario where email = '{$email}' && senha='{$senha_cripto}'";
  $result = mysqli_query($conexao, $sql);
  $usuario = mysqli_fetch_assoc($result);
  return $usuario;
}


// logica usuario
function usuarioEstaLogado(){
    return isset($_COOKIE["usuario_logado"]);
}

function verificaUsuario(){
  if (!usuarioEstaLogado()) {
    header("Location: index.php?falhaDeSeguranca=true");
    die();
  }
}

function usuarioLogado(){
  return $_COOKIE["usuario_logado"];
}

function logaUsuario($email){
  setcookie("usuario_logado", $usuario["email"], time()+60);
}
