<?php include("header.php"); ?>
<?php include("funcoes-usuario.php"); ?>

<?php if (isset($_GET["login"])&& $_GET["login"]== true) {?>
  <p class="alert-success">Logado com Sucesso!!!</p>
<?php } ?>
<?php if (isset($_GET["login"])&& $_GET["login"]==false) {?>
  <p class="alert-danger">Usuario ou senha inválida</p>
  <?php } ?>
<?php if (isset($_GET["falhaDeSeguranca"])&& $_GET["falhaDeSeguranca"]==true) {?>
  <p class="alert-danger">Você não tem acesso á essa funcionalidade</p>
<?php } ?>

      <h1>SEJA BEM VINDO</h1>
      <?php if(usuarioEstaLogado()){?>
        <p class="text-success">Você esta logado como <?=usuarioLogado()?></p>
        <?php } ?>

  <?php if(!isset($_COOKIE["usuario_logado"])){?>
      <h2>LOGIN DO SISTEMA</h2>
    <form action="login.php" method="post">
      <table class="table">
        <tr>
          <td>Email: </td>
          <td><input class="form-control" type="email" name="email"></td>
        </tr>
          <td>Email: </td>
          <td><input class="form-control" type="password" name="senha"></td>
        </tr>
        <tr>
          <td><button class="btn btn-primary">Login</button></td>
        </tr>
      </table>
    </form>
        <?php } ?>
<?php include("footer.php"); ?>
                                                                                             
