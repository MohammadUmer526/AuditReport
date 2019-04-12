<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
    
$reports = [];
$sql = "select * from `audit` where status=1";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $reports[$cr]['location']    = $row['location'];
    $reports[$cr]['competency'] = $row['competency'];
	$reports[$cr]['Customer'] = $row['Customer'];
	$reports[$cr]['projectName'] = $row['projectName'];
	$reports[$cr]['aduitDate'] = $row['aduitDate'];
	$reports[$cr]['tracks'] = $row['tracks'];
	$reports[$cr]['id'] = $row['id'];
	$reports[$cr]['status'] = (int)$row['status'];
    $cr++;
  }
    
  echo json_encode(['data'=>$reports]);
}
else
{
  http_response_code(404);
}