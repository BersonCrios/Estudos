<?php
//pagina dedicada as medidas de assimetria e medidas de curtose 
	$x = $_SESSION['media'];
	$s = $_SESSION['desvio_p'];
	$mo = $_SESSION['moda'];
	$q = $_SESSION['quartil'] ;
	$d = $_SESSION['decil'] ;
	$i;
	$As;
	$Ku;
	
	//fazendo a assimetria
	if($s == 0)
		$As = 0;
	else
		$As = ($x - $mo)/$s;
	
	//fazendo a curtose
	$i = 2*($d[9]-$d[1]);
	if($i == 0)
		$Ku = 0;
	else
		$Ku = ($q[3]-$q[1])/$i;
	
	//arredondando os numeros
	$As = number_format($As, 2, '.', '');
	$Ku = number_format($Ku, 2, '.', '');
	
	
	//passando os dados para a seção
	$_SESSION['As'] = $As;
	$_SESSION['Ku'] = $Ku;

	
?>