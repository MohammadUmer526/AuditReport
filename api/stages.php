<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
    
$stages = [];
$sql = "select stages.stage_id, stages.stage_name, roles.role_name, stages.stages_code 
		from `stages` inner join `roles` 
		where stages.role_id=roles.role_id";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
    $stages[$cr]['stage_id']    = $row['stage_id'];
    $stages[$cr]['stage_name'] = $row['stage_name'];
	$stages[$cr]['role_name'] = $row['role_name'];	
	$stages[$cr]['stages_code'] = $row['stages_code'];
    $cr++;
  }
    
  echo json_encode(['data'=>$stages]);
}
else
{
  http_response_code(404);
}