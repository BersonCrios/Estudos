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

      $n1 = 3;
      $n2 = 2;
      $media =  ($n1+$n2)/2;
      $soma = $n1+$n2;

      echo "A soma de $n1 + $n2 = $soma <br/>";
      echo "A soma de $n1 + $n2 vale " . ($n1 + $n2)  . "<br/>";
      echo "A divisão de $n1 / $n2 vale " . ($n1 / $n2)  . "<br/>";
      echo "A multiplicação de $n1 * $n2 vale " . ($n1 * $n2)  . "<br/>";
      echo "A subtração de $n1 - $n2 vale " . ($n1 - $n2)  . "<br/>";
      echo "O modulo de  $n1 % $n2 vale " . ($n1 % $n2)  . "<br/>";
      echo "a média de  $n1 e $n2 vale $media"  . "<br/>";
     ?>
   </div>
</body>
</html>
