<?php 
		//verificando inicialização
		if(empty ($_POST["series"]))
		{
			echo "<b>Insira os valores na calculadora e veja a magica acontecer!</b>";
		}	
		//caso esteja tudo vazio, ele não inicializia o programa.
		else
		{
			$num = $_POST["series"];//pega tudo que tem dentro da area de texto
			$delimitador = $_POST["delimitador"];
						
			//passando seções
			$_SESSION['numeros'] = $num;
			$_SESSION['delimitador'] = $delimitador;
		
			//primeira requisição para verificar se há numeros validos
			require_once 'teste.php';
			$validar = $_SESSION['validar'];
		
			//caso ele nao valide nenhum numero, ele não exibira nada, caso tenha ele passará
			if($validar == NULL)
				echo"<br><b>Insira numeros validos para a calculadora funcionar!</b><br>";
			else
				require_once 'exibir.php';
		}
?>