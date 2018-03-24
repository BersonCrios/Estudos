/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//mascara do cpf da pagina de login
$(document).ready(function(){
  $('.cpf').mask('000.000.000-00', {reverse: false});
});
$(document).ready(function(){
  $('.validade').mask('00/00/0000', {reverse: false});
});

$(document).ready(function(){
  $('.preco').mask('00.00', {reverse: true});
});

$(document).ready(function(){
  $('.Cnpj').mask('00.000.000/0000-00', {reverse: false});
});

$('.limpar').click(function(){
  $('#nome').val("");
  $('#cpf').val("");
  $('#rg').val("");
  $('#end').val("");
  $('#senha').val("");
});


