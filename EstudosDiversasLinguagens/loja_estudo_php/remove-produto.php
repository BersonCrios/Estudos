<?php include("header.php"); ?>
<?php include("conecta.php"); ?>
<?php include("funcoes-produto.php"); ?>

<?php
    $idProduto = $_POST['id'];
    removeProduto($conexao, $idProduto);

    //Faz o redirecionamento de volta para a pagina de listagem
    header("Location: produtoLista.php?removido=true");
    die();
?>
