<?php
	$k = $_SESSION['classes']; 
	$xi = $_SESSION['porcent'];
	$fi = $_SESSION['frequencia'];

?>

<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart()
	  {
		var i = 1;
		var total = <?echo $k;?>;
		var arr = <?php echo json_encode($fi); ?>;
		var data = new google.visualization.DataTable();
        data.addColumn('string', 'Task');
        data.addColumn('number', 'Hours per Day');
		do
		{
			data.addRow(['Classe '+i, arr[i]]);
			i++;
		}
		while(i <= total);

        var options = 
		{
          width: 800, height: 450,
          title: 'Elementos Divididos por Classes ',
		  is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
	<? echo $fi; ?>
    <div id="chart_div"></div>
  </body>
</html>

</body>
</html>




