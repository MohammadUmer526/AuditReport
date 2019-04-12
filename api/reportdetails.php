<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
$id=$_GET['id'];
$reportDetails = [];
$sql = "select * from `audit` where id=$id";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
     $reportDetails[$cr]['location']    = $row['location'];
    $reportDetails[$cr]['competency'] = $row['competency'];
	$reportDetails[$cr]['Customer'] = $row['Customer'];
	$reportDetails[$cr]['projectName'] = $row['projectName'];
	$reportDetails[$cr]['aduitDate'] = $row['aduitDate'];
	$reportDetails[$cr]['id'] = $row['id'];
	$reportDetails[$cr]['tracks'] = $row['tracks'];
	$reportDetails[$cr]['projectManager'] = $row['projectManager'];
	$reportDetails[$cr]['Lead'] = $row['Lead'];
	$reportDetails[$cr]['qaLead'] = $row['qaLead'];
	$reportDetails[$cr]['auditor'] = $row['auditor'];
	$reportDetails[$cr]['status'] = $row['status'];
	$reportDetails[$cr]['remarks'] = $row['remarks'];
    $cr++;
  }
  
  echo json_encode(['data'=>$reportDetails]);
 
}
else
{
  http_response_code(404);
}