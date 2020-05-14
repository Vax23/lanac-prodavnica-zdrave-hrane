<?php
 if (isset($_GET['kid'])) {
 $outcome=rand(0,100);
 if($outcome>50)
	echo "Odobri kupovinu";
 else
	echo "Odbij kupovinu";
 }else{
	echo "Kupovina id is not set";	
 }
?>