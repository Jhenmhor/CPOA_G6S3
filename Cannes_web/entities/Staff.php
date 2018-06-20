<?php

class Staff 
{
    
    private $_IdStaff;
    
    private $_MotDePasse;
    
    public function __construct($IdStaff, $MotDePasse)
    {
        $this->_IdStaff = $IdStaff;
        $this->_MotDePasse = $MotDePasse;

    }
    /**
     * @return mixed
     */
    public function getid()
    {
        return $this->_IdStaff;
    }

    /**
     * @return mixed
     */
    public function getmdp()
    {
        return $this->_MotDePasse;
    }

    
}