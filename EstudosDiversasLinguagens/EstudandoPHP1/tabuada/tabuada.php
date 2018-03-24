<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="_css/estilo.css" />
  <meta charset="UTF-8" />
  <title>Tabuada</title>
  <link rel="stylesheet" href="../css/estilo.css">

</head>

<body>
  <div>
      <?php
        $num = $_POST["num"];
        $cont = 0;
        $result = 0;
        echo "<h1>Tabuada do <span class='foco'>$num</span></h1>";

        do {
          $result = $num * $cont;
          echo "$num x $cont = $result <br/>";
          $cont++;
        } while ($cont < 10);
      ?>
  </div>
</body>

</html>
