<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
    
$auditors = [];
$sql = "SELECT * from tbl_login where status=0";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $auditors[$cr]['id']    = $row['id'];
    $auditors[$cr]['username'] = $row['username'];
	$auditors[$cr]['fname'] = $row['fname'];
	$auditors[$cr]['lname'] = $row['lname'];
	$auditors[$cr]['email'] = $row['email'];
	$auditors[$cr]['designation'] = $row['designation'];
    $cr++;
  }
    
  echo json_encode(['data'=>$auditors]);
}
else
{
  http_response_code(404);
}