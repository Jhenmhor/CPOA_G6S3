<?php
require_once (PATH_MODELS . 'DAO.php');
require_once (PATH_ENTITIES . 'Photo.php');

class PhotoDAO extends DAO
{	
   public function getbyidstaff($idstaff)
    {
        $res = $this->queryRow('SELECT * FROM Photo WHERE IdPhoto=?', array($idstaff));
        if ($res === false)
            $photo = null;
        else
            $photo = new Photo($res['IdPhoto'], $res['Lien']);
        return $photo;
    } 	
	
}
