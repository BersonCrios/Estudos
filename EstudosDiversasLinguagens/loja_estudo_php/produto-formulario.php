<?php include("header.php"); ?>
<?php include("conecta.php"); ?>
<?php include("funcoes-categoria.php"); ?>
<?php include("funcoes-usuario.php"); ?>

<?php
    verificaUsuario();
    $categorias = listaCategorias($conexao);
?>
      <h1>FORMULARIO DE PRODUTO</h1>
    <form action="adicionaProduto.php" method="post">
      <table class="table">
        <tr>
          <td>Nome:</td>
          <td><input class="form-control" type="text" name="nome"></td>
      </tr>
      <tr>
        <td>Preco:</td>
         <td><input class="form-control"  type="number" name="preco"></td>
      </tr>
      <tr>
        <td>Descrição</td>
        <td><textarea name="descricao" class="form-control"></textarea></td>
      </tr>

      <tr>
        <td>Usado: </td>
        <td><input type="checkbox" name="usado" value="true">Usado</td>
      </tr>

      <tr>
        <td>Categoria</td>
        <td>
              <select name="categoria_id" class="form-control" >
                <?php foreach($categorias as $categoria) { ?>
                    <option value="<?=$categoria['id']?>"><?=$categoria['nome']?></option>
                <?php } ?>
              </select>
        </td>
      </tr>
      <tr>
        <td>
          <button class="btn btn-primary" type="submit">Cadastrar</button>
        </td>
      </tr>
      </table>
    </form>
<?php include("footer.php"); ?>
