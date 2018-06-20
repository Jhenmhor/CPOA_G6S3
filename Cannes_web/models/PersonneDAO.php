<?php
require_once (PATH_MODELS . 'DAO.php');
require_once (PATH_ENTITIES . 'Personne.php');

class PersonneDAO extends DAO
{

    public function recherchepersonne($Recherche)
    {
		//$Recherche = explode(" ", $Recherche);
		// $Prenom=$Recherche
		
        $res = $this->queryRow('SELECT * FROM Personne WHERE Prenom=? and Nom=?', array($Prenom,$Nom));
        if ($res === false)
            $Staff = null;
        else
            foreach ($res as $p) {
                $personnes[] = new Personne($p['Id_Pers'], $p['Prenom'],$p['Nom'],$p['Id_Photo']);
            }
        return $personnes;
    }
	
    public function getbyidstaff($IdStaff)
    {
        $res = $this->queryRow('SELECT * FROM Personne WHERE Id_Pers=?', array($IdStaff));
        if ($res === false)
            $pers = null;
        else
            $pers = new Personne($res['Id_Pers'],$res['Prenom'],$res['Nom'],$res['Id_Photo']);
        return $pers;
    }

    public function getallpersonnevip()
    {
        $res = $this->queryAll('SELECT Id_Pers,Prenom,Nom,Id_Photo FROM Personne,VIP WHERE Personne.Id_Pers=VIP.IdVip');
        if ($res == false)
            $personnevip = array();
        else{
            foreach($res as $p){
                $personnevip[] = new Personne($p['Id_Pers'],$p['Prenom'],$p['Nom'],$p['Id_Photo']);
            }
		}
        return $personnevip;
    }

}
