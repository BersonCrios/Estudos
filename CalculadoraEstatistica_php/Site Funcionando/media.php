<?php

//pagina dedicada a calculo da media, moda e mediana
	$dados_brutos = $_SESSION['dados_brutos'];
	$total_num = $_SESSION['total_num'];
	
	//calculo da media
	$media = array_sum($dados_brutos)/$total_num;
	$media = number_format($media, 2, '.', '');//alterando o formato
	
	//calculo da mediana
	if(($total_num % 2) == 0)//caso seja par, sao duas medianas
	{
		$mediana1 = ($total_num/2);
		$mediana2 = ($total_num/2)+1;
	}
	else//caso seja impar, apenas uma
	{
		$mediana1 = ($total_num+1)/2;
		$mediana2 = NULL;
	}
	
	//calculo da moda
	$moda_total = 0;
	$p = array_count_values($dados_brutos);
	foreach($p as $key => &$value)
	{
		if($value > $moda_total)
		{
			$moda = $key;
			$moda_total = $value;
		}
	}
		
	//passando os dados para a seção
	$_SESSION['media'] = $media;
	$_SESSION['mediana1'] = $mediana1;
	$_SESSION['mediana2'] = $mediana2;
	$_SESSION['moda'] = $moda;
	
?>