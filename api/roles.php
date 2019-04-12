<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
    
$roles = [];
$sql = "SELECT role_id, role_name FROM roles";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $roles[$cr]['id']    = $row['role_id'];
    $roles[$cr]['name'] = $row['role_name'];
    $cr++;
  }
    
  echo json_encode(['data'=>$roles]);
}
else
{
  http_response_code(404);
}