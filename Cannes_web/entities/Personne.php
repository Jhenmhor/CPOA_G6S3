<?php

class Personne
{
    
    private $_Id_Pers;
    
    private $_Prenom;
    
    private $_Nom;
    
    private $_Id_Photo;
	
      
    public function __construct($Id_Pers, $Prenom,$Nom, $Id_Photo)
    {
        $this->_Id_Pers = $Id_Pers;
        $this->_Prenom = $Prenom;
        $this->_Nom = $Nom;
        $this->_Id_Photo = $Id_Photo;
    }
    /**
     * @return mixed
     */
    public function getid()
    {
        return $this->_Id_Pers;
    }

    /**
     * @return mixed
     */
    public function getprenom()
    {
        return $this->_Prenom;
    }

    /**
     * @return mixed
     */
    public function getnom()
    {
        return $this->_Nom;
    }
	
    public function getidphoto()
    {
        return $this->_Id_Photo;
    }
  
}