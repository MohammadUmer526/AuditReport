<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
$id=$_GET['id'];
$summaryDetail = [];
$sql = "SELECT * FROM `summary` WHERE `report_id` = $id";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $summaryDetail[$cr]['NonConformanceSummary'] = $row['NonConformanceSummary'];
    $summaryDetail[$cr]['type'] = $row['type'];
	$summaryDetail[$cr]['phase'] = $row['phase'];
	$summaryDetail[$cr]['owner'] = $row['owner'];
	
	
    $cr++;
  }
    
  echo json_encode(['data'=>$summaryDetail]);
}
else
{
  http_response_code(404);
}