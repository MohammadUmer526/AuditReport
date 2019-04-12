<?php
require 'connect.php';

// Get the posted data.
$postdata = file_get_contents("php://input");

if(isset($postdata) && !empty($postdata))
{
  // Extract the data.
  $request = json_decode($postdata);
	

  // Validate.
  if(trim($request->data->name) === '')
  {
    return http_response_code(400);
  }
	
  // Sanitize.
  $name = mysqli_real_escape_string($con, trim($request->data->name));
  
    

  // Store.
  $sql = "INSERT INTO `roles`(`role_id`,`role_name`,`price`) VALUES (null,'{$name}')";

  if(mysqli_query($con,$sql))
  {
    http_response_code(201);
    $role = [
      'name' => $name,
      'id'    => mysqli_insert_id($con)
    ];
    echo json_encode(['data'=>$role]);
  }
  else
  {
    http_response_code(422);
  }
}
