<!DOCTYPE html>
<html lang="en">

<head>
  <?php
    $txt = $_POST["t"];
    $tam = $_POST["tam"];
    $cor = $_POST["cor"];
  ?>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="../css/estilo.css">

  <style>
    span.texto{
      font-size: <?php echo $tam; ?>;
      color: <?php echo $cor; ?>;
    }
  </style>
  
</head>

<body>
  <div>
      <?php
          echo "<span class='texto'>$txt</span>";
      ?>
  </div>
</body>

</html>
