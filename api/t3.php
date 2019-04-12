<?php
/**
 * Returns the list of cars.
 */
 $role=array();
 require 'connect.php'; 
 $query10="SELECT roles.role_name, (SUM(check_list.Points_Attained)/sum(check_list.Total_Points))*100 as result from audit INNER JOIN check_list INNER JOIN stages INNER JOIN roles where audit.status=1 && audit.id=check_list.report_id && check_list.stage_id =stages.stage_id && stages.role_id = roles.role_id GROUP By roles.role_name ORDER BY stages.stage_id";
             			 
			 if($check_location=mysqli_query($con,$query10)){
			$s=0;
			while($roles = mysqli_fetch_assoc($check_location))
            {
            	$role[]=$roles['role_name'];
				$role[]=(float)$roles['result'];
            }
			
				
		}  
else
{
  http_response_code(404);
}


 $st=(array_chunk($role, 2));
  echo json_encode(['data'=>$st]);
  
?>