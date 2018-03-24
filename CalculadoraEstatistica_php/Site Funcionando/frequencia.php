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
			$xiac[0] = 0;
		}
		$fi[$p] = 0;
		while($i<=$total_nums)
		{
			if($p<$k)
			{
				if($nums[$i]>=$inter[$p-1] && $nums[$i]<$inter[$p])
					$fi[$p]++;
				$xi[$p] = ($fi[$p]*100)/$total_nums;
			}
			else
			{
				if($nums[$i]>=$inter[$p-1] && $nums[$i]<=$inter[$p])
					$fi[$p]++;
				$xi[$p] = ($fi[$p]*100)/$total_nums;
			}
			$i++;
		}
		$fiac[$p]=$fi[$p]+$fiac[$p-1];
		$xiac[$p]=$xi[$p]+$xiac[$p-1];
		$xi[$p] = number_format($xi[$p], 2, '.', '');
		if($p == $k)
			$xiac[$k] = 100;
		$xiac[$p] = number_format($xiac[$p], 2, '.', '');

	}
		
	//passando os dados para a seção
	$_SESSION['classes'] = $k;
	$_SESSION['intervalos'] = $inter;
	$_SESSION['frequencia'] = $fi;
	$_SESSION['frequeac'] = $fiac;
	$_SESSION['porcent'] = $xi;
	$_SESSION['porcac'] = $xiac;
	
?>