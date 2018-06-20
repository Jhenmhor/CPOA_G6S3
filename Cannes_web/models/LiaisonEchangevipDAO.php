<?php
require_once (PATH_MODELS . 'DAO.php');
require_once (PATH_ENTITIES . 'LiaisonEchangevip.php');

class LiaisonEchangevipDAO extends DAO
{
	
    public function getbyid($id)
    {
        $res = $this->queryAll('SELECT * FROM Liaison_VIP_Echange,Echange where IdPers=? and Liaison_VIP_Echange.IdEchange=Echange.IdEchange',array($id));
        if ($res == false)
            $liaison = array();
        else {
            foreach ($res as $p) {
                $liaison[] = new LiaisonEchangevip($p['IdLiaisonVIP'],$p['IdPers'], $p['IdEchange'],$p['IdStaff'],$p['Detail'],$p['Denomination'],$p['acronyme']);
            }
        }
        return $liaison;
    }
	 
	
}
