
			
			
			<?php

 $stag=array();
 require 'connect.php'; 
 $query10="SELECT stages.stage_name, ROUND(((SUM(check_list.Points_Attained)/sum(check_list.Total_Points))*100)/11,2) as total from audit INNER JOIN check_list INNER JOIN stages where audit.status=1 && audit.id=check_list.report_id && check_list.stage_id =stages.stage_id GROUP By stages.stage_name ORDER BY stages.stage_id";
            $cr=0; 			 
			 if($check_location=mysqli_query($con,$query10)){
			$s=0;
			while($row = mysqli_fetch_assoc($check_location))
  {
    $stag[$cr]['y']    = (int)$row['total'];
    $stag[$cr]['name'] = $row['stage_name'];
	
    $cr++;
	
	
  //  $stag[] = $row['stage_name'];
//	$stag[]    = (int)$row['total'];
  }
  //$st=(array_chunk($stag, 2));
  echo json_encode(['data'=>$stag]);
}
else
{
  http_response_code(404);
}

?>

  