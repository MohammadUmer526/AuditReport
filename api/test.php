<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
    $test=[];
$questions = [];
$sql = "select questions.question_id, questions.question, questions.Total_Points, stages.stage_name, roles.role_name 
		from `questions` inner join `stages` inner join `roles` 
		where stages.role_id=roles.role_id && questions.stage_id=stages.stage_id";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_array($result))
  {
	$questions[$cr]['question_id'] = $row['question_id'];
    $questions[$cr]['question']    = $row['question'];
    $questions[$cr]['Total_Points'] = $row['Total_Points'];
	$questions[$cr]['stage_name'] = $row['stage_name'];
	$questions[$cr]['role_name'] = $row['role_name'];
    $cr++;
 
    $test[$row['role_name']][$row['stage_name']]['questions'][$cr]=$row['question'];
	//$test[['role_name']$row['role_name']][$cr]=$row['question'];
  
}

echo json_encode(['Data'=>$test]);

}  
else
{
  http_response_code(404);
}