<?php 
session_name('p1606501');
session_start();

require_once (PATH_MODELS . 'utilisateurDAO.php');

if((isset($_POST['nom']))&&(isset($_POST['mdp'])))
{
	$nom=htmlspecialchars ($_POST['nom']);
	$mdp=htmlspecialchars  ($_POST['mdp']);
	
	$uDAO=new utilisateurDAO(DEBUG);
	
	if(($nom==ADMINISTRATEUR_ID)&&(sha1($mdp)==ADMINISTRATEUR_MDP))
	{
		$_SESSION['logged']=1;
		
	}
	else
	{
	
	if($uDAO->getbypseudo($nom)!=null)
	{
		$uti=$uDAO->getbypseudo($nom);
		if($uti->geterreur()==3)
		{
			$alert=choixAlert('bloque');
		}
		else
		{
			$connexionutilisateur=$uDAO->connexionutilisateur($nom,$mdp);
			if(($connexionutilisateur!=null))
			{

				$_SESSION['logged']=$connexionutilisateur->getid();
				echo $_SESSION['logged'];
			}
			else
			{
		
				if($uDAO->getbypseudo($nom)!=null)
				{
					$alert=choixAlert('motdepasse_invalide');
					$uDAO->updateerreur($uti->getid());
				}
				else
				{
					$alert=choixAlert('identifiant_invalide');
				}
			}
		
		}
	}
	else
	{
		$alert=choixAlert('identifiant_invalide');
	}
	}
		
	
}



if(isset($_SESSION['logged']))
{
	$alert=choixAlert('connexion_valide');
}

require_once(PATH_VIEWS.$page.'.php'); 

