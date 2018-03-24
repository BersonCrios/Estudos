<?php
//FUNÇÃO DE INSERIR PRODUTO NO BANCO DE DADOS, RECEB COMO PARAMETRO A CONEXÃO, O NOME DO PRODUTO E PREÇO REBIDO DA VIEW
function insereProduto($conexao,$nome,$preco,$descricao,$categoria_id,$usado){
  //SQL QUE IRA FAZER A INSERÇÃO NO BANCO
  $sql = "insert into produto (nome,preco,descricao,categoria_id,usado) value('{$nome}', {$preco}, '{$descricao}', {$categoria_id},{$usado})";
  //RETORNO DA EXECURSÃO DA QUERY ACIMA, PASSADA COMO PARAMETRO A CONEXÃO E A SQL

  return mysqli_query($conexao, $sql);

}

//FUNÇÃO DE ALTERAR PRODUTO NO BANCO DE DADOS, RECEB COMO PARAMETRO A CONEXÃO,O ID, O NOME DO PRODUTO E PREÇO REBIDO DA VIEW
function alteraProduto($conexao,$id,$nome,$preco,$descricao,$categoria_id,$usado){
  //SQL QUE IRA FAZER A ALTERACAO NO BANCO
  $sql = "update produto set nome = '{$nome}', preco = {$preco}, descricao='{$descricao}', categoria_id={$categoria_id}, usado={$usado} where idProduto = {$id}";
  //RETORNO DA EXECURSÃO DA QUERY ACIMA, PASSADA COMO PARAMETRO A CONEXÃO E A SQL
  return mysqli_query($conexao, $sql);

}

//FUNCAO DE LISTAGEM DE PRODUTOS, RECEBE A CONEXÃO COMO PARAMETRO
function listaProdutos($conexao){
  //CRIA-SE UM ARRAY PARA ARMAZENAR OS PRODUTOS VINDOS DO BANCO
  $produtos = array();
  //QUERY QUE IRAR FAZER AS BUSCAS NO BANCO DE DADOS
  $sql = "select p.* ,c.nome as categoria_nome from produto as p join categoria as c on c.id = p.categoria_id";
  //A VARIÁVEL RESULT RECEBE O COMANDO DE EXECURSÃO DA QUERY, PASSANDO COMO PARAMETRO A CONEXÃO E O SQL ACIMA
  $result = mysqli_query($conexao,$sql);

  //ASSOCIA A BUSCA VINDA DE RESULT, CADA UM DOS PRODUTOS,ENQUANTO TIVER PRODUTO, VAI ARMAZENAR NO ARRAY PRODUTOS
  while ($produto = mysqli_fetch_assoc($result)) {
      array_push($produtos,$produto);
  }
  //RETORNA O ARRAY
  return $produtos;
}


//FUNÇÃO DE REMOVER PRODUTO DO BANCO DE DADOS, RECEBE COMO PARAMETRO A CONEXÃO E UMA VARÁVEL QUE VAI RECEBER O ID DO PRODUTO
function removeProduto($conexao, $id){
    //SQL QUE REMOVE O PRODUTO BASADO NA LINHA idProduto RECEBENDO O ID RECEBIDO DA VIEW
    $sql = "delete from produto where idProduto = {$id}";
    //RETORNA A EXECUSÃO DA QUERY, PASSANDO COMO PARAMETRO A CONEXÃO E O SQL
    return mysqli_query($conexao,$sql);
}

// FUNCÇÃO QUE BUSCA UM RPDOUTO PARA ALTERAR, RECEBE A CONEXÃO E O ID COMO PARAMETRO
function buscaProduto($conexao, $idProduto){
    //SQL QUE ALTERA O PRODUTO DE DETERMIANDO ID
    $sql = "select * from produto where idProduto = {$idProduto}";
    $resultado = mysqli_query($conexao,$sql);
    return mysqli_fetch_assoc($resultado);
}
