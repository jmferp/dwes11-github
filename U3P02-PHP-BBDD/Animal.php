<?php
class Animal{
    private $chip;
    private $nombre;
    private $tipo;
    private $imagen;
    
    /**
     * @return mixed
     */
    public function getChip()
    {
        return $this->chip;
    }

    /**
     * @return mixed
     */
    public function getNombre()
    {
        return $this->nombre;
    }

    /**
     * @return mixed
     */
    public function getTipo()
    {
        return $this->tipo;
    }

    /**
     * @return mixed
     */
    public function getImagen()
    {
        return $this->imagen;
    }

    /**
     * @param mixed $chip
     */
    public function setChip($chip)
    {
        $this->chip = $chip;
    }

    /**
     * @param mixed $nombre
     */
    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    /**
     * @param mixed $tipo
     */
    public function setEspecie($tipo)
    {
        $this->especie = $tipo;
    }

    /**
     * @param mixed $imagen
     */
    public function setImagen($imagen)
    {
        $this->imagen = $imagen;
    }

    public function __toString(){
        return "El chip es ".$this->chip." , el nombre ".$this->nombre." , el tipo".$this->tipo." y la imagen es
                <p><img src='img/".$this->imagen."' width=100 height=100 /></p>"."";
    }
    
    
    
}