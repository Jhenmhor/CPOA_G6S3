<?php
require_once (PATH_MODELS . 'DAO.php');
require_once (PATH_ENTITIES . 'Echange.php');

class EchangeDAO extends DAO
{
	
    public function getAll()
    {
        $res = $this->queryAll('SELECT * FROM Echange');
        if ($res == false)
            $Echange = array();
        else {
            foreach ($res as $p) {
                $Echange[] = new Echange($p['IdEchange'], $p['Denomination'],$p['acronyme']);
            }
        }
        return $Echange;
    }
	
   public function insertcat($denomination,$acronyme){
    
    $res = $this->queryBdd('INSERT INTO Echange (Denomination,acronyme) VALUES("'.$denomination.'","'.$acronyme.'")',array($denomination,$acronyme));	
  }
		
	
}
