<?php

class VIP
{
    
    private $_IdVip;
    
    private $_Coef_imp;
    
    private $_Type;
    
    private $_IdComp;
	
	private $_Nationalite;
       

    public function __construct($IdVip,$Coef_imp, $Type, $IdComp,$Nationalite)
    {
        $this->_IdVip = $IdVip;
        $this->_Coef_imp = $Coef_imp;
        $this->_Type = $Type;
        $this->_IdComp = $IdComp;
		$this->_Nationalite = $Nationalite;
    }
    /**
     * @return mixed
     */
    public function getid()
    {
        return $this->_IdVip;
    }

    /**
     * @return mixed
     */
    public function getcoef()
    {
        return $this->_Coef_imp;
    }

    /**
     * @return mixed
     */
    public function gettype()
    {
        return $this->_Type;
    }
	
    public function getidcomp()
    {
        return $this->_IdComp;
    }

	    public function getnationalite()
    {
        return $this->_Nationalite;
    }
    
}