<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
    
$employees = [];
$sql = "SELECT * FROM employees";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $employees[$cr]['emp_name']    = $row['emp_name'];
    $cr++;
  }
    
  echo json_encode(['data'=>$employees]);
}
else
{
  http_response_code(404);
}