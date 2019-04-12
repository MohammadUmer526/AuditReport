<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
$id=$_GET['id'];
$summaryDetail = [];
$sql = "SELECT * FROM `observations` WHERE `report_id` = $id";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $summaryDetail[$cr]['Observations'] = $row['Observations'];
    $summaryDetail[$cr]['id'] = $row['id'];
	
	
    $cr++;
  }
    
  echo json_encode(['data'=>$summaryDetail]);
}
else
{
  http_response_code(404);
}