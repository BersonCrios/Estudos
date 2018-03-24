<?php
	$k = $_SESSION['classes']; 
	$xi = $_SESSION['porcent'];
	$fi = $_SESSION['frequencia'];
	$i;
	$cores = array('FF0000', '008000', '0000FF', 'FFFF00', 'FFA500', '4B0082','DC143C', '8B4513', '000080', '800080', '808080', 'FFD700', '00FFFF', 'DC143C', '191970', '00FF00', '008B8B');

?>

<html>
  <head>
  </head>
  <body>
	<div id="chart_div">
	<?php
	echo "<img src='http://chart.apis.google.com/chart?cht=p3&chd=t:";
	for($i = 1; $i <= $k; $i++)
	{
		if($i == 1)
		{
			echo $fi[$i];
		}
		else
		{
		echo ",".$fi[$i];
		}
	}
	echo "&chs=800x350&chco0&chco=";
	for($i=0;$i<$k;$i++)
	{
		if($i==0)
		{
			echo $cores[$i];
		}
		else
		{
			echo "|".$cores[$i];
		}
	}
	echo "&chdl=";
	for($i = 1; $i <= $k; $i++)
	{
		if($i==1)
		{
			echo "Classe+".$i;
		}
		else
		{
			echo "|Classe+".$i;
		}
	}
	echo "&chtt=Grafico+de+Classes|da+Sequencia&chl=";
	for($i = 1; $i<=$k;$i++)
	{
		if($i==1)
		{
			echo $xi[$i]."%+(".$fi[$i]."+Elementos)";
		}
		else
		{
			echo "|".$xi[$i]."%+(".$fi[$i]."+Elementos)";
		}
	}
	echo "'  ?/>";
	
	?>
    </div>
  </body>
</html>

</body>
</html>




