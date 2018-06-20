<?php
require_once (PATH_MODELS . 'DAO.php');
require_once (PATH_ENTITIES . 'Liaison_VIP_Echange.php');

class Liaison_VIP_EchangeDAO extends DAO
{

  public function supprvip($id){
    
    $res = $this->queryBdd('DELETE FROM  VIP where IdVip=? ',array($id));	
  }
	
//   Liaison_VIP_Echange,Personne,Photo    Liaison_VIP_Echange.IdPers=VIP.IdVIP and VIP.IdVIP=Personne.Id_Pers and Personne.Id_Pers=Photo.IdPhoto and Photo.IdPhoto
    public function getbyid($id)
    {
        $res = $this->queryAll('SELECT * FROM Liaison_VIP_Echange where IdPers=?',array($id));
        if ($res == false)
            $liaison = array();
        else {
            foreach ($res as $p) {
                $liaison[] = new Liaison_VIP_Echange($p['IdLiaisonVIP'],$p['IdPers'], $p['IdEchange'],$p['IdStaff'],$p['Detail']);
            }
        }
        return $liaison;
    }
	
	    public function getbyiddem($id)
    {
        $p = $this->queryRow('SELECT * FROM Liaison_VIP_Echange where IdLiaisonVIP=?',array($id));
        if ($p == false)
            $liaison = null;
        else {
             
             $liaison = new Liaison_VIP_Echange($p['IdLiaisonVIP'],$p['IdPers'], $p['IdEchange'],$p['IdStaff'],$p['Detail']);
            
        }
        return $liaison;
    }
	
   public function insertdemande($IdPers,$IdEchange,$IdStaff,$Detail){
    
    $res = $this->queryBdd('INSERT INTO Liaison_VIP_Echange (IdPers,IdEchange,IdStaff,Detail) VALUES("'.$IdPers.'","'.$IdEchange.'","'.$IdStaff.'","'.$Detail.'")',array($IdPers,$IdEchange,$IdStaff,$Detail));	
  }	
 
 
 
	    public function getmaxid()
    {
        $p = $this->queryRow('SELECT max(IdLiaisonVIP) FROM Liaison_VIP_Echange');
		$p= (int) $p[0];		
        $nddem=$p;
		
		return $p;
		
    } 
	
	
    public function suppdemande($id){
    
    $res = $this->queryBdd('DELETE FROM Liaison_VIP_Echange where IdLiaisonVIP = ?',array($id));	
  } 
   
}
