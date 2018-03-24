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
      //http://localhost/EstudandoPHP1/funcoes_aritmeticas.php?x=5&y=2
      $v1 = $_GET["x"];
      $v2 = $_GET["y"];
      echo "<h3> Valores recebidos $v1 e $v2 </h3>";
      echo "Valor absoluto de $v1 é " . abs($v1) . "<br/>";
      echo "Valor de $v1 <sup>$v2</sup> é " . pow($v1,$v2) . "<br/>";
      echo "A raiz quadrada de $v1 é " . sqrt($v1) . "<br/>";
      echo "O valor arredondado de $v2 é " . round($v2) . "<br/>";  //ceil e floor
      echo "A parte inteira de $v2 é " . intval($v2) . "<br/>";
      echo "O valor de  $v1 em moeda é R$ " . number_format($v1,2) . "<br/>"; 
     ?>
   </div>
</body>
</html>
