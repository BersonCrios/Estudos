<?php include("header.php"); ?>
<?php include("conecta.php");?>
<?php include("funcoes-produto.php");?>

<?php
    if (array_key_exists("removido",$_GET) && $_GET["removido"] == "true") {

        echo "<p class='alert-success'>Produto apagado com sucesso</p>";
    }
?>


<table class="table table-striped table-bordered">
  <?php
    $produtos = listaProdutos($conexao);
    foreach($produtos as $produto) {
  ?>

  <tr>
    <td>
      <?=$produto['nome'] ?>
    </td>
    <td>
      <?= $produto['preco'] ?>
    </td>
    <td>
      <?= substr($produto['descricao'],0,40) ?>
    </td>
    <td>
        <?= $produto['categoria_nome'] ?>
    </td>
    <td>
        <a href="produto-altera-formulario.php?idProduto=<?=$produto['idProduto']?>" class="btn btn-primary">Alterar</a>
    </td>
    <td>
        <!-- FORMULARIO DE REMOÇÃO POR POST, leva para a action REMOVE-PRODUTO -->
        <form action="remove-produto.php" method="post">
            <!-- CRIA-SE UM INPUT DO TIPO HIDDEN(PARA NÇAO MOSTRA O CAMPO ID), COM O NOME QUE VAI PARA A REMOVE-PRODUTO.PHP ATRAVES DO POST, SENDO O VALOR O ID VIDNO DA TABELA -->
            <input type="hidden" name="id" value="<?=$produto['idProduto']?>">
            <!-- BOTÃO QUE VAI EXECUTAR O METODO POST PARA A ACTION REMOVE PRODUTO PHP  -->
            <button class="btn btn-danger">Remover</button>
      </form>
    </td>
  </tr>
  <?php
  }
  ?>
</table>


<?php include("footer.php"); ?>
