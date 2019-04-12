<?php
require 'connect.php';

// Get the posted data.
$postdata = file_get_contents("php://input");

if(isset($postdata) && !empty($postdata))
{
  // Extract the data.
  $request = json_decode($postdata);
	
  // Validate.
  if (trim($request->stage_name)===''|| ($request->role_name)==='') {
    return http_response_code(400);
  }
    
  // Sanitize.
  $id    = mysqli_real_escape_string($con, (int)$request->stage_id);
  $role    = mysqli_real_escape_string($con, (int)$request->role_name);
  $name = mysqli_real_escape_string($con, trim($request->stage_name));
 

  // Update.
  $sql = "UPDATE `stages` SET `stage_name`='$name' WHERE `stage_id` = '{$id}' LIMIT 1";

  if(mysqli_query($con, $sql))
  {
    http_response_code(204);
  }
  else
  {
    return http_response_code(422);
  }  
}
