<?php
require 'connect.php';

// Get the posted data.
$postdata = file_get_contents("php://input");

if(isset($postdata) && !empty($postdata))
{
  // Extract the data.
  $request = json_decode($postdata);
	
  // Validate.
  if (trim($request->data->question)===''|| ($request->data->Total_Points)==='') {
    return http_response_code(400);
  }
    
  // Sanitize.
  $id    = mysqli_real_escape_string($con, (int)$request->data->question_id);
  $question    = mysqli_real_escape_string($con, $request->data->question);
  $points = mysqli_real_escape_string($con, trim($request->data->Total_Points));
 

  // Update.
  $sql = "UPDATE `questions` SET `question`='{$question}', `Total_Points`={$points} WHERE `question_id` = '{$id}' LIMIT 1";

  if(mysqli_query($con, $sql))
  {
    http_response_code(204);
  }
  else
  {
    return http_response_code(422);
  }  
}
