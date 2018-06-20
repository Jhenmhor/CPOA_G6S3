<?php

class Echange
{
    
    private $_IdEchange;
    
    private $_Denomination;
	
	private $_acronyme;
           

    public function __construct($IdEchange,$Denomination,$acronyme)
    {
        $this->_IdEchange = $IdEchange;
        $this->_Denomination = $Denomination;
		$this->_acronyme = $acronyme;
    }
    /**
     * @return mixed
     */
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