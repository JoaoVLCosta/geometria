package br.edu.fateczl.geometria.controller;

import br.edu.fateczl.geometria.model.Retangulo;

public class CalculosRetangulo implements IGeometriaController<Retangulo>{
    /*
     *@author:<sJOÃO VITOR LIMA COSTA>
     */

    @Override
    public float area(Retangulo retangulo) {
        return retangulo.getBase() * retangulo.getAltura();
    }

    @Override
    public float perimetro(Retangulo retangulo) {
        return (retangulo.getBase() + retangulo.getAltura()) * 2;
    }
}
