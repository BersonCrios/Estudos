<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Embracando no PHP</title>
  <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
  <div class="">

    <?php
        $a = 3;
        $b = "3";
        $c = 3;
        $d = 2;
        $e = 4;
        //operadores relacionais
        $rigual = ($a == $b) ? "Sim<br/>" : "Não<br/>";
        $ridentico = ($a === $b) ? "Sim<br/>" : "Não<br/>";
        $rdiferente = ($a != $d) ? "Sim <br/>" : "Não<br/>";
        $rmaior = ($a > $d) ? "Sim <br/>" : "Não <br/>";
        $rmenor = ($a < $d) ? "Sim<br/>" : "Não<br/>";
        $rmenorigual = ($a <= $c) ? "Sim<br/>" : "Não<br/>";
        $rmaiorigual = ($a >= $e) ? "Sim<br/>" : "Não<br/>";
        //operadores logicos
        $and = ($d > 1 && $d < 5) ? "Sim <br/>": "Não<br/>";
        $or = ($e > 1 || $e < 2) ? "Sim <br/>": "Não<br/>";

        //$variavel = expressao ? verdade : falso


        echo "$a e $b são iguais? A rsposta é: $rigual";
        echo "$a e $b são identicos? A rsposta é: $ridentico";
        echo "$a e $d são diferentes? A rsposta é: $rdiferente";
        echo "$a é maior que $d ? A rsposta é: $rmaior";
        echo "$a é menor que $d? A rsposta é: $rmenor";
        echo "$a é menor ou igual a $c? A rsposta é: $rmenorigual";
        echo "$a é maior ou igual a $e? A rsposta é: $rmaiorigual";
        echo "<br/>";
        echo "$d está entre 1 e 5? A rsposta é: $and";
        echo "$e é maior que 1 ou menor que 2? A rsposta é: $or";
        echo "$e é maior que 1 ou menor que 2? A rsposta é: $not";

     ?>
   </div>
</body>
</html>
