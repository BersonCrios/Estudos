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
      $n1 = $_GET["a"];
      $n2 = $_GET["b"];

      $media = ($n1+$n2)/2;
      echo "<h2>Foram recebidos os números $n1 & $n2 </h2><br/>";

      echo "A soma de $n1 + $n2 vale " . ($n1 + $n2)  . "<br/>";
      echo "A divisão de $n1 / $n2 vale " . ($n1 / $n2)  . "<br/>";
      echo "A multiplicação de $n1 * $n2 vale " . ($n1 * $n2)  . "<br/>";
      echo "A subtração de $n1 - $n2 vale " . ($n1 - $n2)  . "<br/>";
      echo "O modulo de  $n1 % $n2 vale " . ($n1 % $n2)  . "<br/>";

      echo "a média de  $n1 e $n2 vale $media"  . "<br/>";

      echo "$n1 + $n2 =" . ($n1+$n2) . "<br/>";
     ?>
   </div>
</body>
</html>
