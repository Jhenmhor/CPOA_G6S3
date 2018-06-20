<?php
require_once (PATH_MODELS . 'DAO.php');
require_once (PATH_ENTITIES . 'Staff.php');

class StaffDAO extends DAO
{
	
    public function connexionstaff($IdStaff,$MotDePasse)
    {
        $res = $this->queryRow('SELECT * FROM Staff WHERE IdStaff=? and MotDePasse=?', array($IdStaff,$MotDePasse));
        if ($res === false)
            $Staff = null;
        else
            $Staff = new Staff($res['IdStaff'], $res['MotDePasse']);
        return $Staff;
    }
	
}
