<?php
require_once (PATH_MODELS . 'DAO.php');
require_once (PATH_ENTITIES . 'VIP.php');

class VIPDAO extends DAO
{
	
    public function getbyid($id)
    {
        $res = $this->queryRow('SELECT * FROM VIP WHERE IdVip=?', array($id));
        if ($res === false)
            $pers = null;
        else
            $pers = new VIP($res['IdVip'],$res['Coef_imp'],$res['Type'],$res['IdComp'],$res['Nationalite']);
        return $pers;
    }
	
	
   public function updatepvip($idvip,$prenom,$nom,$coef,$type,$idcomp,$nationalite){
    
    $res = $this->queryBdd('update Personne set Prenom=?,Nom=? where Id_Pers = ? ',array($prenom,$nom,$idvip));
	$res = $this->queryBdd('update VIP set Coef_imp=?,Type=?,IdComp=?,Nationalite=? where IdVip = ? ',array($coef,$type,$idcomp,$nationalite,$idvip));
	
   }	
 
 public function insertvip($lien,$prenom,$nom,$coef,$type,$idcomp,$nationalite){
    
    $res = $this->queryBdd('INSERT INTO Photo(Lien) VALUES("'.$lien.'")',array($lien));
	$res = $this->queryBdd('INSERT INTO Personne(pseudo,mdp,email) VALUES("'.$pseudo.'","'.$mdp.'","'.$email.'")',array($pseudo,$mdp,$email));
	$res = $this->queryBdd('INSERT INTO VIP(pseudo,mdp,email) VALUES("'.$pseudo.'","'.$mdp.'","'.$email.'")',array($pseudo,$mdp,$email));	
  } 
	
}
