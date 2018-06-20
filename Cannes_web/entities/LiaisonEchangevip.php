<?php

class LiaisonEchangevip
{
	
	private $_IdLiaisonVIP;
	
    private $_IdPers;
    
    private $_IdEchange;
	
	private $_IdStaff;
    
    private $_Detail;	
	     
    private $_Denomination;
	
	private $_acronyme;
           

    public function __construct($IdLiaisonVIP,$IdPers, $IdEchange,$IdStaff,$Detail,$Denomination,$acronyme)
    {
		$this->_IdLiaisonVIP = $IdLiaisonVIP;
        $this->_IdPers = $IdPers;
        $this->_IdEchange = $IdEchange;
		$this->_IdStaff = $IdStaff;
        $this->_Detail = $Detail;		
		
        $this->_IdEchange = $IdEchange;
        $this->_Denomination = $Denomination;
		$this->_acronyme = $acronyme;
    }

    public function getidliaisonvip()
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
	
	
    public function getid()
    {
        return $this->_IdEchange;
    }

    /**
     * @return mixed
     */
    public function getdenomination()
    {
        return $this->_Denomination;
    }
	
	public function getacronyme()
    {
        return $this->_acronyme;
    }
   
}