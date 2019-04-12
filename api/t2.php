

<?php
/**
 * Returns the list of cars.
 */
 $loc=array();
require 'connect.php'; 
$query9 = "SELECT location, count(location) as loc FROM `audit` where status=1 GROUP by location";
		if($check_location=mysqli_query($con,$query9)){
			$s=0;
			while($locs = mysqli_fetch_assoc($check_location))
            {
            	$loc[]=$locs['location'];
				$loc[]=(int)$locs['loc'];
            }
			
				
		}  
else
{
  http_response_code(404);
}

	
$lc=(array_chunk($loc, 2));
  echo json_encode(['data'=>$lc]);
  
 
		
		
?>