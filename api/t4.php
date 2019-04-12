<?php
/**
 * Returns the list of cars.
 */
 $stage=array();
 require 'connect.php'; 
 $query10="SELECT stages.stage_name, ROUND(((SUM(check_list.Points_Attained)/sum(check_list.Total_Points))*100),2) as total from audit INNER JOIN check_list INNER JOIN stages where audit.status=1 && audit.id=check_list.report_id && check_list.stage_id =stages.stage_id GROUP By stages.stage_name ORDER BY stages.stage_id";
             			 
			 if($check_location=mysqli_query($con,$query10)){
			$s=0;
			while($stages = mysqli_fetch_assoc($check_location))
            {
            	$stage[]=$stages['stage_name'];
				$stage[]=(float)$stages['total'];
            }
			
				
		}  
else
{
  http_response_code(404);
}


 $st=(array_chunk($stage, 2));
  echo json_encode(['data'=>$st]);
  
?>