<?php
	session_start();
	//pagina para exibir o grafico
	require_once 'phplot-6.1.0/phplot.php';
	
	$p = $_SESSION['classes']; 
	$q = $_SESSION['frequencia'];
	$i;
	$c = 1;
	$data=array();
	for($i=0;$i<$p;$i++)
	{
		$data[$i] = array('Classe '.$c, $q[$c]);
		$c++;
	}

	$plot = new PHPlot(800,600);
	$plot->SetImageBorderType('plain');
	$plot->SetPlotType('pie');
	$plot->SetDataType('text-data-single');
	$plot->SetDataValues($data);
	# Set enough different colors;	
	$plot->SetDataColors(array('red', 'green', 'yellow', 'navy', 'blue', 'cyan',
                        'magenta', 'brown', 'lavender', 'pink', 'gray', 'orange', 
						'gold', 'plum', 'orchid', '#D2691E', '#FF7F50', '#4B0082'
						));

	# Main plot title:
	$plot->SetTitle("Mostrando por Classes");

	# Build a legend from our data array.
	# Each call to SetLegend makes one line as "label: value".
	foreach ($data as $row)
		$plot->SetLegend(implode(': ', $row));
	# Place the legend in the upper left corner:
	$plot->SetLegendPixels(5, 5);

	$plot->DrawGraph();
?>
