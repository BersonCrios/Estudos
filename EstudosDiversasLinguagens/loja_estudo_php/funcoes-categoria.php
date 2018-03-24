<?php

//FUNCAO DE LISTAGEM DE PRODUTOS, RECEBE A CONEXÃO COMO PARAMETRO
function listaCategorias($conexao){
  //CRIA-SE UM ARRAY PARA ARMAZENAR OS PRODUTOS VINDOS DO BANCO
  $categorias = array();
  //QUERY QUE IRAR FAZER AS BUSCAS NO BANCO DE DADOS
  $sql = "select * from categoria";
  //A VARIÁVEL RESULT RECEBE O COMANDO DE EXECURSÃO DA QUERY, PASSANDO COMO PARAMETRO A CONEXÃO E O SQL ACIMA
  $result = mysqli_query($conexao,$sql);

  //ASSOCIA A BUSCA VINDA DE RESULT, CADA UM DOS PRODUTOS,ENQUANTO TIVER PRODUTO, VAI ARMAZENAR NO ARRAY PRODUTOS
  while ($categoria = mysqli_fetch_assoc($result)) {
      array_push($categorias,$categoria);
  }
  //RETORNA O ARRAY
  return $categorias;
}


?>
