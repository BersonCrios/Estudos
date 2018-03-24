<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="_css/estilo.css" />
  <meta charset="UTF-8" />
  <title>Criar caixas de texto randon</title>
  <link rel="stylesheet" href="../css/estilo.css">

</head>

<body>
  <div>
    <form action="back.php" method="post">
      <?php

        $cont = 1;
        while ($cont <= 5) {
          echo "Valor $cont: <input type='number' name='v$cont' max='100' min='0'><br/>";
          $cont+=1;
        }
      ?>
      <input type="submit" value="Enviar" class="botao">
    </form>
  </div>
</body>

</html>
