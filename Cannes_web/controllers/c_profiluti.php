<?php
/*
 * MODULE DE PHP
 * Controller page 404
 *
 * Copyright 2016, Eric Dufour
 * http://techfacile.fr
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 */
 
session_name('p1606501');
session_start();
 
require_once (PATH_MODELS . 'utilisateurDAO.php');

if(isset($_POST['debloque']))
{
	$id= htmlspecialchars($_POST['debloque']);
	
	$uDAO=new utilisateurDAO(DEBUG);
	
	$uDAO->supprerreur($id);
}


$uDAO=new utilisateurDAO(DEBUG);

$utilisateurs=$uDAO->getAllutilisateur();


require_once(PATH_VIEWS.$page.'.php'); 
