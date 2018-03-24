                                                     <?php include("header.php"); ?>
<?php//DESCIRÇÃO DA FUNÇÃO DE CONECTAR ESTA NO ARQUIVO CONECTA PHP JUNTO DA FUNCAO ?>
<?php include("conecta.php"); ?>
<?php include("funcoes-produto.php");?>
<?php include("funcoes-usuario.php");?>

<?php
  verificaUsuario();
?>

    <?php

      //VARIAVEIS QUE RECEBEM VALORES VINDOS DA VIEW
      $nome = $_POST["nome"];
      $preco = $_POST["preco"];
      $descricao = $_POST['descricao'];
      $categoria_id = $_POST['categoria_id'];
      if (array_key_exists('usado', $_POST)) {
        $usado = "true";
      }
      else {
        $usado = "false";
      }
      //TRATAMENTO DE INSERÇÃO
      //SE, CHAMANDO A FUNÇÃO INSEREPRODUTO E PASSANDO OS PARAMETROS DER CERTO RETORNA MENSAGEM DIZENDO QUE DEU CERTO
      if(insereProduto($conexao,$nome,$preco,$descricao,$categoria_id,$usado)){
        echo "<p class='text-success'>Produto $nome, R$ $preco adicionado com sucesso</p>";
      }
      //SENÃO, RETORNA UMA MENSAGEM DIZENDO QUE DEU ERRADO, E A VÁRIAVEL $msg INFORMA O ERRO TECNICO
      else{
        $msg = mysqli_error($conexao);
        echo "<p class='text-danger'>Produto $nome não foi adicionado: $msg</p>";
      }

      //FECHA-SE A CONEXÃO COM O BANCO
      mysqli_close($conexao);

    ?>
<?php include("footer.php"); ?>
