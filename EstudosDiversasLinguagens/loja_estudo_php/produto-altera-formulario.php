<?php include("header.php"); ?>
<?php include("conecta.php"); ?>
<?php include("funcoes-categoria.php"); ?>
<?php include("funcoes-produto.php"); ?>
<?php
    $idProduto = $_GET["idProduto"];
    $produto = buscaProduto($conexao, $idProduto);
    $categorias = listaCategorias($conexao);
    $usado = $produto['usado']? "checked='checked'":"";
?>
      <h1>ALTERANDO PRODUTO</h1>
    <form action="altera-produto.php" method="post">
      <input type="hidden" name="id" value="<?=$produto['idProduto']?>">
      <table class="table">
        <tr>
          <td>Nome:</td>
          <td><input class="form-control" type="text" name="nome" value="<?=$produto['nome']?>"></td>
      </tr>
      <tr>
        <td>Preco:</td>
         <td><input class="form-control"  type="number" name="preco" value="<?=$produto['preco']?>"></td>
      </tr>
      <tr>
        <td>Descrição</td>
        <td><textarea name="descricao" class="form-control"><?=$produto['descricao']?></textarea></td>
      </tr>

      <tr>
        <td>Usado: </td>
        <td><input type="checkbox" name="usado" <?=$usado?> value="true" >Usado</td>
      </tr>

      <tr>
        <td>Categoria</td>
        <td>
              <select name="categoria_id" class="form-control" >
                <?php foreach($categorias as $categoria) {
                  $essaEhACategoria = $produto['categoria_id'] == $categoria['id'];
                 $selecao = $essaEhACategoria ? "selected='selected'":"";
                ?>
                    <option value="<?=$categoria['id']?>" <?=$selecao?>><?=$categoria['nome']?></option>
                <?php } ?>
              </select>
        </td>
      </tr>
      <tr>
        <td>
          <button class="btn btn-primary" type="submit">Alterar</button>
        </td>
      </tr>
      </table>
    </form>
<?php include("footer.php"); ?>
