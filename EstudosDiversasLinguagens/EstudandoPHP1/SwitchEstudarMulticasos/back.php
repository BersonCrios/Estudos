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
        $d = $_POST["ds"];
        switch ($d) {
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
            echo "Levanta e vai estudar";
            break;

          case 7:
          case 8:
            echo "Descance!";
            break;

        default:
          echo "DIA INVÁLIDO";
            break;
        }
      ?>

      <a href="form.html">Voltar!</a>
    </div>
</body>
</html>
