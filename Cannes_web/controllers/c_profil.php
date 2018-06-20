<?php
session_name('p1606501');
session_start();

require_once (PATH_MODELS . 'utilisateurDAO.php');



$uDAO= new utilisateurDAO(DEBUG);
$utilisateur=$uDAO->getbyid($_SESSION['logged']);

$pu = $utilisateur->getpseudo();
$mdpu = $utilisateur->getmdp();
$emailu = $utilisateur->getemail();


require_once (PATH_VIEWS . $page . '.php');
        