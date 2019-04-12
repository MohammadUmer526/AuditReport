<?php
/**
 * Returns the list of cars.
 */
require 'connect.php';
$id=$_GET['id'];

   $query="select COUNT(*) as total from summary where report_id = $id";
          $tnc=mysqli_query($con, $query);
          $ncrow=mysqli_fetch_assoc($tnc);
          $totalnc=$ncrow['total'];
  
  echo json_encode(['data'=>[$totalnc]]);
 
