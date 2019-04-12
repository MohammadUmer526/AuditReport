<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
$id=$_GET['id'];
$summary = [];
$sql = "SELECT check_list.checklist_id, check_list.Evidence, check_list.Verified,check_list.Total_Points,check_list.Points_Attained,check_list.Exception_Deviation,check_list.NC, check_list.Observation,check_list.report_id, check_list.question,check_list.project_total from audit INNER JOIN check_list where check_list.report_id = $id && check_list.report_id = audit.id";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $summary[$cr]['question'] = $row['question'];
    $summary[$cr]['Verified'] = $row['Verified'];
	$summary[$cr]['Total_Points'] = $row['Total_Points'];
	$summary[$cr]['Points_Attained'] = $row['Points_Attained'];
	$summary[$cr]['Evidence'] = $row['Evidence'];
	$summary[$cr]['Exception_Deviation'] = $row['Exception_Deviation'];
	$summary[$cr]['Observation'] = $row['Observation'];
	$summary[$cr]['NC'] = $row['NC'];
	$summary[$cr]['project_total'] = $row['project_total'];
	$summary[$cr]['report_id'] = $row['report_id'];
    $cr++;
  }
    
  echo json_encode(['data'=>$summary]);
}
else
{
  http_response_code(404);
}