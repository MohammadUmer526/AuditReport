<?php
require 'connect.php';

// Get the posted data.
$postdata = file_get_contents("php://input");

if(isset($postdata) && !empty($postdata))
{
  // Extract the data.
  $request = json_decode($postdata);
                

  // Validate.

                
  // Sanitize.
  $username = mysqli_real_escape_string($con, trim($request->username));
  $password = mysqli_real_escape_string($con, trim($request->password));
  

  // Store.
   $sql = "SELECT * FROM tbl_login WHERE username='$username'";

    $response = mysqli_query($con, $sql);

    $login = array();
    $login['login'] = array();
    
    if ( mysqli_num_rows($response) == 1 ) {
                                                
        
        $row = mysqli_fetch_assoc($response);
                                                                
        if ( $password === $row['password'] ) {
            http_response_code(201);
           $login = [      
                                                                'username' => $username      
                                                ];
                                                                echo json_encode(['data'=>$login]);

            mysqli_close($con);

        } else {
                                                http_response_code(422);
            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);

            mysqli_close($con);

        }

    }
}
