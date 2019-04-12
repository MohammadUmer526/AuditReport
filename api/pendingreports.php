<?php

require 'connect.php';
    
$reports = [];
$sql = "SELECT *, check_list.project_total from audit INNER JOIN check_list where audit.status=0 && audit.id = check_list.report_id GROUP by check_list.report_id";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $reports[$cr]['id']    = $row['id'];
    $reports[$cr]['location'] = $row['location'];
	$reports[$cr]['competency'] = $row['competency'];
	$reports[$cr]['Customer'] = $row['Customer'];
	$reports[$cr]['projectName'] = $row['projectName'];
	$reports[$cr]['aduitDate'] = $row['aduitDate'];
	$reports[$cr]['tracks'] = $row['tracks'];
	$reports[$cr]['status'] = $row['status'];
	$reports[$cr]['project_total'] = $row['project_total'];
    $cr++;
  }
    
  echo json_encode(['data'=>$reports]);
}
else
{
  http_response_code(404);
}