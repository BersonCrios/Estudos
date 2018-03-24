<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Verifica Média</title>
  <link rel="stylesheet" href="../css/estilo.css">

</head>
<body>
    <div>
        <?php
          $nome = $_POST["nome"];
          $n1 =  $_POST["n1"];
          $n2 = $_POST["n2"];

          $media = ($n1+$n2)/2;

          if ($media >= 0 && $media <= 4) {
            echo "O Aluno $nome ficou com nota $n1 na A1 e $n2 na A2 ficando assim com a média $media,
            sendo assim o Aluno esta REPROVADO";
          }
          elseif ($media >= 4.1 && $media <= 6.75) {
            echo "O Aluno $nome ficou com nota $n1 na A1 e $n2 na A2 ficando assim com a média $media,
            sendo assim o Aluno esta de RECUPERAÇÃO";
          }
          else {
            echo "O Aluno $nome ficou com nota $n1 na A1 e $n2 na A2 ficando assim com a média $media,
            sendo assim o Aluno esta APROVADO";
          }
        ?>
    </div>
</body>
</html>
