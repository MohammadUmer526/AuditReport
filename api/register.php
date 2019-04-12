<?php
  header('Access-Control-Allow-Origin: *');
		header("Access-Control-Allow-Methods: GET, POST, PUT, PATCH, POST, DELETE, OPTIONS");
		header('Access-Control-Max-Age: 86400');
		header("Access-Control-Expose-Headers: Content-Length, X-JSON");
		header("Access-Control-Allow-Headers: *");

if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $fname = $_POST['fname'];
    $lname = $_POST['lname'];
    $email = $_POST['email'];
	$password = $_POST['password'];
	$ran=rand(10,1000);
  $username=$fname.$lname.$ran;
    
            
   
        


    require_once 'data.php';
    
   

    
    
    $sql = "INSERT INTO `tbl_login`(username,fname,lname,email,password) VALUES('$username','$fname','$lname','$email','$password')";
    
    if ( mysqli_query($conn, $sql) && !empty($password) && !empty($email)) {
    
   
           
                            
        $result["success"] = "1";
        $result["message"] = "Registration successful";

        echo json_encode($result);
        mysqli_close($conn);

    } else {

        $result["success"] = "0";
        $result["message"] = "error in registration";

        echo json_encode($result);
        mysqli_close($conn);
    }
   
}

?>