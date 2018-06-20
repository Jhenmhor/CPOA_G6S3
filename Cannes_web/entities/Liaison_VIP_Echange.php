<?php

class Liaison_VIP_Echange
{
    
	private $_IdLiaisonVIP;
	
    private $_IdPers;
    
    private $_IdEchange;
	
	private $_IdStaff;
    
    private $_Detail;
     
    public function __construct($IdLiaisonVIP,$IdPers, $IdEchange,$IdStaff,$Detail)
    {
		$this->_IdLiaisonVIP = $IdLiaisonVIP;
        $this->_IdPers = $IdPers;
        $this->_IdEchange = $IdEchange;
		$this->_IdStaff = $IdStaff;
        $this->_Detail = $Detail;
    }
    /**
     * @return mixed
     */
	 
    public function getidliaison()
    {
        return $this->_IdLiaisonVIP;
    }	 
	 
	 
    public function getidpers()
    {
        return $this->_IdPers;
    }

    /**
     * @return mixed
     */
    public function getidechange()
    {
        return $this->_IdEchange;
    }

    /**
     * @return mixed
     */
    public function getdetail()
    {
        return $this->_Detail;
    }
	
	public function getidstaff()
    {
        return $this->_IdStaff;
    }
	
    
}