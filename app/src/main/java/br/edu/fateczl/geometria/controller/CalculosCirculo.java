package br.edu.fateczl.geometria.controller;

import br.edu.fateczl.geometria.model.Circulo;

public class CalculosCirculo implements IGeometriaController<Circulo>{
    /*
     *@author:<sJOÃO VITOR LIMA COSTA>
     */

    @Override
    public float area(Circulo circulo) {
        return (float) ( Math.PI * Math.pow( circulo.getRaio(), 2 ) );
    }

    @Override
    public float perimetro(Circulo circulo) {
        return (float) ( Math.PI * circulo.getRaio() * 2 );
    }
}
