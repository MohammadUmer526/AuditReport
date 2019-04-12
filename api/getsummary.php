<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
$id=$_GET['id'];
$summary = [];
$sql = "select stages.stage_name,sum(check_list.Total_Points), SUM(check_list.Points_Attained) 
		from audit INNER JOIN check_list INNER JOIN stages 
		where audit.id=check_list.report_id && audit.id=$id && check_list.stage_id = stages.stage_id 
		GROUP By stages.stage_name ORDER BY stages.stage_id";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $summary[$cr]['stage_name'] = $row['stage_name'];
    $summary[$cr]['SumTotal_Points'] = $row['sum(check_list.Total_Points)'];
	$summary[$cr]['SumAttain_Points'] = $row['SUM(check_list.Points_Attained)'];
	
    $cr++;
  }
    
  echo json_encode(['data'=>$summary]);
}
else
{
  http_response_code(404);
}