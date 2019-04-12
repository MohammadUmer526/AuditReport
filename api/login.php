<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $username = $_POST['username'];   
    $password = $_POST['password'];

    require_once 'data.php';

    $sql = "SELECT * FROM tbl_login WHERE username='$username'";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['login'] = array();
    if ( mysqli_num_rows($response) == 1 ) {
        
        $row = mysqli_fetch_assoc($response);

        if ( $password === $row['password']) {
            
			 $index['email'] = $row['email'];
            $index['id'] = $row['id'];
            $index['name'] = $row['username'];
			$index['designation'] = $row['designation'];

            array_push($result['login'], $index);
            
            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);

        } else {

            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);

            mysqli_close($conn);

        }

    }

}

?>