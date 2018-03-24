<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>SWITCH</title>
  <link rel="stylesheet" href="../css/estilo.css">

</head>
<body>
    <div>
        <?php
          $n = $_POST["num"];
          $o = $_POST["oper"];

          switch ($o) {
            case "Dobro":
              $r = $n*2;
              break;
            case "Cubo":
              $r = $n*$n*$n;
              break;
            case "Raiz":
              $r = sqrt($n);
              break;
            default:
              echo "Valor inválido";
          }

          echo "O resultado da operação de $o solicitada para o numero $n é $r";
        ?>
    </div>
</body>
</html>
