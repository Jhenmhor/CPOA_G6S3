<?php

class Photo
{
    
    private $_IdPhoto;
    
    private $_Lien;
    
 

    public function __construct($IdPhoto, $Lien)
    {
        $this->_IdPhoto= $IdPhoto;
        $this->_Lien = $Lien;

    }
    /**
     * @return mixed
     */
    public function getid()
    {
        return $this->_IdPhoto;
    }

    /**
     * @return mixed
     */
    public function getlien()
    {
        return $this->_Lien;
    }

    
}