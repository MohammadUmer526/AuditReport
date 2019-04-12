
			
			
			<?php
/**
 * Returns the list of cars.
 */
 $track=array();
 require 'connect.php'; 
 $query10="SELECT tracks, COUNT(id) as total from audit where status=1 GROUP by tracks";
             			 
			 if($check_location=mysqli_query($con,$query10)){
			$s=0;
			while($tracks = mysqli_fetch_assoc($check_location))
            {
            	$track[]=$tracks['tracks'];
				$track[]=(int)$tracks['total'];
            }
			
				
		}  
else
{
  http_response_code(404);
}


 $st=(array_chunk($track, 2));
  echo json_encode(['data'=>$st]);
  
?>