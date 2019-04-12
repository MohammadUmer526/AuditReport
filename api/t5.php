
			
			
			<?php
/**
 * Returns the list of cars.
 */
 $competency=array();
 require 'connect.php'; 
 $query10="SELECT audit.competency, COUNT(audit.id) as total from audit WHERE status=1 GROUP by competency";
             			 
			 if($check_location=mysqli_query($con,$query10)){
			$s=0;
			while($competencies = mysqli_fetch_assoc($check_location))
            {
            	$competency[]=$competencies['competency'];
				$competency[]=(int)$competencies['total'];
            }
			
				
		}  
else
{
  http_response_code(404);
}


 $st=(array_chunk($competency, 2));
  echo json_encode(['data'=>$st]);
  
?>