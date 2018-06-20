<?php
session_name('p1606501');
session_start();

require_once (PATH_MODELS . 'utilisateurDAO.php');

$uDAO= new utilisateurDAO(DEBUG);
$utilisateur=$uDAO->getbyid($_SESSION['logged']);

$pu = $utilisateur->getpseudo();
$mdpu = $utilisateur->getmdp();
$emailu = $utilisateur->getemail();

if(isset($_POST['nom']))
{
	$nom=htmlspecialchars($_POST['nom']);
	
	if(($nom!=$pu)&&($uDAO->getbypseudo($nom)==null)&&(strlen($nom)>=1))
	{
		$uDAO->updatepseudo($_SESSION['logged'],$nom);
		$pu=$nom;
	}

	
	$mdp=htmlspecialchars($_POST['mdp']);
	if(($mdp!=$mdpu)&&(strlen($mdp)>=1))
	{
		$uDAO->updatemdp($_SESSION['logged'],$mdp);
		$mdpu=$mdp;
	}	
	
	$email=htmlspecialchars($_POST['email']);
	if(($email!=$emailu)&&(strlen($nom)>=1))
	{
		$uDAO->updatemail($_SESSION['logged'],$email);
		$emailu=$email;
	}
	
	$page="profil";
		
}


require_once (PATH_VIEWS . $page . '.php');
        