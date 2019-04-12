<?php
require 'connect.php';

// Get the posted data.
$postdata = file_get_contents("php://input");

if(isset($postdata) && !empty($postdata))
{
  // Extract the data.
  $request = json_decode($postdata);
	
  // Validate.
  if (trim($request->id)=='') {
    return http_response_code(400);
  }
    
  // Sanitize.
  $id    = mysqli_real_escape_string($con, (int)$request->id);
  $projectName = mysqli_real_escape_string($con, trim($request->projectName));
  $location = mysqli_real_escape_string($con, trim($request->location));
  $projectManager = mysqli_real_escape_string($con, trim($request->projectManager));
  $competency = mysqli_real_escape_string($con, trim($request->competency));
  $qaLead = mysqli_real_escape_string($con, trim($request->qaLead));
  $tracks = mysqli_real_escape_string($con, trim($request->tracks));
  $aduitDate = mysqli_real_escape_string($con, trim($request->aduitDate));
  $remarks = mysqli_real_escape_string($con, trim($request->remarks));
  $Lead = mysqli_real_escape_string($con, trim($request->Lead));
 

  // Update.
  $sql = "UPDATE `audit` SET `location`='$location',`competency` = '$competency',`tracks` = '$tracks',`projectName` = '$projectName',`projectManager` = '$projectManager',`Lead` = '$Lead',`qaLead` = '$qaLead' ,`auditor` = '$auditor' ,`aduitDate` = '$aduitDate' ,`remarks`='$remarks' where id={$id} limit 1";

  if(mysqli_query($con, $sql))
  {
    http_response_code(204);
  }
  else
  {
    return http_response_code(422);
  }  
}
