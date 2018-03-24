<?php

//pagina dedicada a calculo das medidas de dispersão
	$num = $_SESSION['dados_brutos'];
	$n = $_SESSION['total_num'];
	$maior = $_SESSION['maior'];
	$menor = $_SESSION['menor'];
	$dms = 0;
	$c_dms;
	$desvio_p;
	$variança = 0;
	$c_var;
	$aux;
	
	//calculo amplitude total
	$amplitude_total = $maior - $menor;
	
	//calculo desvio medio simples
	$x =  $_SESSION['media'];
	for($i = 1; $i <= $n; $i++)
	{
		$aux = $num[$i]-$x;
		if($aux < 0)
			$c_dms[$i] = $aux * -1;
		else
			$c_dms[$i] = $aux;
	}
	$dms = array_sum($c_dms)/$n;
	
	//calculo variança e desvio padrão
	for($i = 1;$i <= $n; $i++)
	{
		$aux = $num[$i] - $x;
		$c_var[$i] = pow($aux,2);
	}
	$variança = array_sum($c_var)/$n;
	$desvio_p = sqrt($variança);
	
	//formatando os numeros
	$dms = number_format($dms, 2, '.', '');
	$variança = number_format($variança, 2, '.', '');
	$desvio_p = number_format($desvio_p, 2, '.', '');
		
	//passando os dados para a seção
	$_SESSION['dms'] = $dms;
	$_SESSION['amplitude_total'] = $amplitude_total;
	$_SESSION['variança'] = $variança;
	$_SESSION['desvio_p'] = $desvio_p;
	
?>