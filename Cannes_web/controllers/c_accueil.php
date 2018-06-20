<?php
session_name('p1606501');
session_start();

require_once (PATH_MODELS . 'EchangeDAO.php');
require_once (PATH_MODELS . 'Liaison_VIP_EchangeDAO.php');
require_once (PATH_MODELS . 'PersonneDAO.php');
require_once (PATH_MODELS . 'PhotoDAO.php');
require_once (PATH_MODELS . 'StaffDAO.php');
require_once (PATH_MODELS . 'VIPDAO.php');

require_once (PATH_MODELS . 'LiaisonEchangevipDAO.php');

//deconnexion du staff

if(isset($_GET['deconnexion'])||isset($_POST['suppr']))
{
	if(ini_get("session.use_cookies")) {
	$params = session_get_cookie_params();
	setcookie(session_name(), '', -1,
		$params["path"], $params["domain"],
		$params["secure"], $params["httponly"]
	);
	
	$_SESSION = array();
	session_destroy();	
	}
}

// connexion du staff

if(isset($_POST['mdp']))
{
	$identifiant=htmlspecialchars($_POST['identifiant']);
	$mdp=htmlspecialchars  ($_POST['mdp']);
	
	$uDAO=new StaffDAO(DEBUG);
			
	if($uDAO->connexionstaff($identifiant,$mdp)!=null)
	{
		$_SESSION['logged']=$identifiant;
		
		$pDAO=new PersonneDAO(DEBUG);
		$persstaff=$pDAO->getbyidstaff($_SESSION['logged']);
		
		$_SESSION['nom']=$persstaff->getnom();
		$_SESSION['prenom']=$persstaff->getprenom();
		
		$phoDAO=new PhotoDAO(DEBUG);
		$photostaff=$phoDAO->getbyidstaff($_SESSION['logged']);
					
		$_SESSION['photo']=$photostaff->getlien();
		
	}
	else
	{
		$alerteconnexion ="Identifiant et/ou Mot de passe invalide";
	}
	
}

// récupération de tous les VIP

if(isset($_GET['supprvip']))
{
	$supprvip=htmlspecialchars($_GET['supprvip']);
	$supprvipDAO=new Liaison_VIP_EchangeDAO(DEBUG);
	
	$supprvipDAO->supprvip($supprvip);
}


if(isset($_SESSION['logged']))
{
	$pvipDAO=new PersonneDAO(DEBUG);
	$personnevip=$pvipDAO->getallpersonnevip();
	
	
}

/*
if(isset($_POST['search']))
{
	$search=htmlspecialchars($_POST['search']);
}
*/

if(isset($_POST['prenom'])&isset($_POST['nom']))
{
	$idvip=htmlspecialchars($_GET['idvip']);
	$prenom=htmlspecialchars($_POST['prenom']);
	$nom=htmlspecialchars($_POST['nom']);
	$coefimport=htmlspecialchars($_POST['coefimport']);
	$type=htmlspecialchars($_POST['type']);
	$idcomp=htmlspecialchars($_POST['idcomp']);
	$nation=htmlspecialchars($_POST['nation']);
	
	echo $prenom;
	
	$updatevipDAO=new VIPDAO(DEBUG);
	$updatevipDAO->updatepvip($idvip,$prenom,$nom,$coefimport,$type,$idcomp,$nation);
	
	
}


if(isset($_GET['supprdemande']))
{
	$supprdemande=htmlspecialchars($_GET['supprdemande']);
	
	$ndDAO=new Liaison_VIP_EchangeDAO(DEBUG);
	$ndDAO->suppdemande($supprdemande);
	
	
}


if(isset($_POST['denomination'])&isset($_POST['acronyme']))
{
	$denomination=htmlspecialchars($_POST['denomination']);
	$acronyme=htmlspecialchars($_POST['acronyme']);
	
	$echinsDAO=new EchangeDAO(DEBUG);
	$echinsDAO->insertcat($denomination,$acronyme);
	

}

if(isset($_POST['nbnd'])&isset($_POST['detaildemande']))
{
	$nbnd=htmlspecialchars($_POST['nbnd']);
	$detaildemande=htmlspecialchars($_POST['detaildemande']);
	$idvip=htmlspecialchars($_GET['idvip']);
			
	$ndDAO=new Liaison_VIP_EchangeDAO(DEBUG);
	$ndDAO->insertdemande($idvip,$nbnd,$_SESSION['logged'],$detaildemande);
	
	
	$iddem = $ndDAO->getmaxid();
	
	$demDAO=new Liaison_VIP_EchangeDAO(DEBUG);
	$dem=$demDAO->getbyiddem($iddem);
	
	$idstaffdem=$dem->getidstaff();
	
	$persdemDAO=new PersonneDAO(DEBUG);
	$persdem=$persdemDAO->getbyidstaff($idstaffdem);
	
	$phodemDAO=new PhotoDAO(DEBUG);
	$photostaffdem=$phodemDAO->getbyidstaff($idstaffdem);

	
}




if(isset($_GET['idvip']))
{
	$idvip=htmlspecialchars($_GET['idvip']);
	
	$persvipDAO=new PersonneDAO(DEBUG);
	$persvip=$persvipDAO->getbyidstaff($idvip);
	
	$phovipDAO=new PhotoDAO(DEBUG);
	$photovip=$phovipDAO->getbyidstaff($idvip);
	
	$liaiechDAO=new LiaisonEchangevipDAO(DEBUG);
	$liaiech=$liaiechDAO->getbyid($idvip);
	
	$echDAO=new EchangeDAO(DEBUG);
	$ech=$echDAO->getall();
	
	$infovipDAO=new VIPDAO(DEBUG);
	$infovip=$infovipDAO->getbyid($idvip);
	
	

}

if(isset($_GET['iddem']))
{
	$iddem=htmlspecialchars($_GET['iddem']);
	
	$demDAO=new Liaison_VIP_EchangeDAO(DEBUG);
	$dem=$demDAO->getbyiddem($iddem);
	
	$idstaffdem=$dem->getidstaff();
	
	$persdemDAO=new PersonneDAO(DEBUG);
	$persdem=$persdemDAO->getbyidstaff($idstaffdem);
	
	$phodemDAO=new PhotoDAO(DEBUG);
	$photostaffdem=$phodemDAO->getbyidstaff($idstaffdem);
	
	
	
}


if(isset($_POST['prenom'])&isset($_POST['nom'])&isset($_POST['coefimport'])&isset($_POST['type'])&isset($_POST['idcomp'])&isset($_POST['nation'])&isset($_FILES['imgvip']['name']))
{
	echo "fdsqfd";
}





// appel de la vue
require_once (PATH_VIEWS . $page . '.php');
        