<?php
//pagina dedicada ao calculo da frequencia, intervalo e numero de classes
	$nums = $_SESSION['dados_brutos'];
	$total_nums = $_SESSION['total_num'];
	$maior = $_SESSION['maior'];
	$menor = $_SESSION['menor'];
	$inter;
	$fi;
	$fiac;
	$p;
	$i;
	
	//calculando o numero de classes
	$k = sqrt($total_nums);
	$k = round($k);
	
	//calculando o valor do intervalo
	$h = ($maior-$menor)/$k;
	$h = number_format($h, 2, '.', '');
	
	//jogando dados do intervalo para um vetor
	for($p=1;$p<=$k;$p++)
	{
		if($p == 1)
		{
			$inter[$p-1] = $menor;
			$inter[$p] = $menor + $h;
		}
		else
		if($p < $k)
			$inter[$p] = $inter[$p-1] + $h;
		else
			$inter[$p] = $maior;
	}
	
	//fazendo fi e fiac
	for($p=1;$p<=$k;$p++)
	{
		$i=1;
		if($p==1)
		{
			$fiac[0] = 0;
		}
		$fi[$p] = 0;
		while($i<=$total_nums)
		{
			if($p<$k)
			{
				if($nums[$i]>=$inter[$p-1] && $nums[$i]<$inter[$p])
					$fi[$p]++;
			}
			else
			{
				if($nums[$i]>=$inter[$p-1] && $nums[$i]<=$inter[$p])
					$fi[$p]++;
			}
			$i++;
		}
		$fiac[$p]=$fi[$p]+$fiac[$p-1];
	}
	
	//fazendo xi e xiac
	$xiac[0] = 0;
	$porc = 100;
	for($p=$k;$p>=1;$p--)
	{
		if($p > 1)
		{
			$xi[$p]= ($fi[$p]*100)/$total_nums;
			$xi[$p] = number_format($xi[$p], 2, '.', '');
			if($p == $k)
			{
				$xiac[$k] = $porc;
				$porc = $porc - $xi[$k];
			}
			else
			if($p < $k)
			{
				$xiac[$p] = $porc;
				$porc = $porc - $xi[$p];
			}
		}
		else
		{
			$xi[1] = $porc;
			$xiac[1] = $porc;
		}
	}
		
	//passando os dados para a seção
	$_SESSION['classes'] = $k;
	$_SESSION['intervalos'] = $inter;
	$_SESSION['frequencia'] = $fi;
	$_SESSION['frequeac'] = $fiac;
	$_SESSION['porcent'] = $xi;
	$_SESSION['porcac'] = $xiac;
	
?>