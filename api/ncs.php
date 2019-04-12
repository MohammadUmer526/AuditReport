<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
$id=$_GET['id'];
$reportDetails = [];
$sql = "SELECT stages.stage_name, SUM(IF(summary.phase IS NULL, 0, 1)) AS total FROM stages 
		LEFT JOIN summary ON stages.stage_name = summary.phase && summary.report_id = $id GROUP by 1 ORDER by stages.stage_name";

if($result = mysqli_query($con,$sql))
{
  $cr = 0;
  while($row = mysqli_fetch_assoc($result))
  {
   $reportDetails[$cr]['Total']=(int)$row['total'];
   $cr++;
  }
  
  echo json_encode([$reportDetails]);
 
}
else
{
  http_response_code(404);
}