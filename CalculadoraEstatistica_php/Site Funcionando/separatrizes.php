<?php
//pagina dedicada as medidas separatrizes 
	$dados = $_SESSION['rol'];
	$total_nums = $_SESSION['total_num'];
	$i;$p;$pos;$mod;$n1;$n2;
	$quartil;$kintil;$decil;//variaveis que irão fazer as medias separatrizes
	
	//fazendo o quartil
	$pos = 25;
	for($i = 1; $i < 4; $i++)
	{
		$p = ($pos * $total_nums)/100;
		if(($p % 2) == 0)
		{
			$quartil[$i] = $dados[$p];
		}
		else
		{
			//se for impar ele calculará a media dos dois numeros das duas posicoes;
			$mod = $p % 2;
			$n1 = $p - $mod;
			$n2 = $p + 1;
			$p = ($n1 + $n2)/2;
			$quartil[$i] = $dados[$p];
		}
		$pos = $pos + 25;
	}
	
	//fazendo o kintil
	$pos = 20;
	for($i = 1; $i < 5; $i++)
	{
		$p = ($pos * $total_nums)/100;
		if(($p % 2) == 0)
		{
			$kintil[$i] = $dados[$p];
		}
		else
		{
			//se for impar ele calculará a media dos dois numeros das duas posicoes;
			$mod = $p % 2;
			$n1 = $p - $mod;
			$n2 = $p + 1;
			$p = ($n1 + $n2)/2;
			$kintil[$i] = $dados[$p];
		}
		$pos = $pos + 20;
	}
	
	//fazendo o kintil
	$pos = 10;
	for($i = 1; $i < 10; $i++)
	{
		$p = ($pos * $total_nums)/100;
		if(($p % 2) == 0)
		{
			$decil[$i] = $dados[$p];
		}
		else
		{
			//se for impar ele calculará a media dos dois numeros das duas posicoes;
			$mod = $p % 2;
			$n1 = $p - $mod;
			$n2 = $p + 1;
			$p = ($n1 + $n2)/2;
			$decil[$i] = $dados[$p];
		}
		$pos = $pos + 10;
	}

	//passando os dados para a seção
	$_SESSION['quartil'] = $quartil;
	$_SESSION['kintil'] = $kintil;
	$_SESSION['decil'] = $decil;
	
?>