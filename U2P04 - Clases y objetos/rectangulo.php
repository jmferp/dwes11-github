<?php
class Figura{
    private $titulo;
    private $color;
    
    public function __construct($titulo,$color){
        $this->titulo=$titulo;
        $this->color=$color;
    }
    /**
     * @return mixed
     */
    public function getTitulo()
    {
        return $this->titulo;
    }

    /**
     * @return mixed
     */
    public function getColor()
    {
        return $this->color;
    }

    /**
     * @param mixed $titulo
     */
    public function setTitulo($titulo)
    {
        $this->titulo = $titulo;
    }

    /**
     * @param mixed $color
     */
    public function setColor($color)
    {
        $this->color = $color;
    }

    
    
}


class Rectangulo extends Figura{
    public $base;
    public $altura;
    
    public function __construct($base,$altura){
       $this->base=$base;
       $this->altura=$altura;
    }
    /**
     * @return mixed
     */
    public function getBase(){
        return $this->base;
    }

    /**
     * @return mixed
     */
    public function getAltura(){
        return $this->altura;
    }

    /**
     * @param mixed $base
     */
    public function setBase($base){
        $this->base = $base;
    }

    /**
     * @param mixed $altura
     */
    public function setAltura($altura){
        $this->altura = $altura;
    }

    
    public function calcularArea(){
        return $this->base*$this->altura;
    }
    
    public function calcularPerimetro(){
        return ($this->base*2)+($this->altura*2);
    }
    
    public function __toString(){
        return "La base es ".$this->base." , la altura ".$this->altura." , el area es ".$this->calcularArea()." y el perimetro es
                ".$this->calcularPerimetro().".";
    }
    
    public function __destruct(){
        print "Destruyendo rectangulo";
    }
    
    
    
    
}