<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
 $test=[];  
 $aud=[];
 $loc=[];
$sql = "SELECT * FROM audit";

if($result = mysqli_query($con,$sql))
{$check_rowcount=mysqli_num_rows($result); 
 $sql1="SELECT * FROM tbl_login where status=1";
	if($result1 = mysqli_query($con,$sql1))
	{$check_rowcount1=mysqli_num_rows($result1); 
     $query1="SELECT * FROM audit where status=1";
		if($result2=mysqli_query($con,$query1)){
		 $check_rowcount2=mysqli_num_rows($result2);
		 
		$query2="SELECT customer,projectName,location,competency,tracks FROM `audit` where status = 1 ORDER by id DESC limit 5";		 
		if($result3=mysqli_query($con,$query2)){
		 $sr=0;
             while($row2 = mysqli_fetch_array($result3))
            {
             $aud[$sr]['customer'] = $row2['customer'];
			 $aud[$sr]['projectName'] = $row2['projectName'];
			 $aud[$sr]['location'] = $row2['location'];
			 $aud[$sr]['competency'] = $row2['competency'];
			 $aud[$sr]['tracks'] = $row2['tracks'];
			 
            	$sr++;
			}
			
			
		}
		}
}
   
}  
else
{
  http_response_code(404);
}

$test=array('audits'=>$check_rowcount,'auditors'=>$check_rowcount1,'approved'=>$check_rowcount2,'auds'=>$aud);

  echo json_encode(['data'=>[$test]]);
  
  

