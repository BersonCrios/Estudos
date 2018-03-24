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
    <form method="post" action="tabuada.php">
      Escolha um numero para ver a tabuada:
      <?php
      $numero = 0;
      $count = 1;
      echo "<select name='num'>";
      while ($numero <= 10) {
        echo "<option value='$numero'>$numero</option>";
        $numero++;
      }
      echo "</select>";
        ?>
      <input type="submit" value="Verificar" />
    </form>
  </div>
</body>

</html>
