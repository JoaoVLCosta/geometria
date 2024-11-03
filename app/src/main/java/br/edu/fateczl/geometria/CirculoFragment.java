package br.edu.fateczl.geometria;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.fateczl.geometria.controller.CalculosCirculo;
import br.edu.fateczl.geometria.model.Circulo;

public class CirculoFragment extends Fragment {
    /*
     *@author:<sJOÃO VITOR LIMA COSTA>
     */

    private EditText etRaio;
    private TextView tvResC;

    public CirculoFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circulo, container, false);
        etRaio = view.findViewById(R.id.etRaio);
        tvResC = view.findViewById(R.id.tvResC);

        Button btnAreaC = view.findViewById(R.id.btnAreaC);
        btnAreaC.setOnClickListener(op -> area());

        Button btnPerimetroC = view.findViewById(R.id.btnPerimetroC);
        btnPerimetroC.setOnClickListener(op -> perimetro());

        return view;
    }

    private Circulo objeto(){
        return new Circulo(Float.parseFloat(etRaio.getText().toString()));
    }

    private void perimetro() {
        CalculosCirculo cc = new CalculosCirculo();
        String resposta = getText(R.string.resultado) + " " + cc.perimetro(objeto());
        tvResC.setText(resposta);
        limpar();
    }

    private void area() {
        CalculosCirculo cc = new CalculosCirculo();
        String resposta = getText(R.string.resultado) + " " + cc.area(objeto());
        tvResC.setText(resposta);
        limpar();
    }

    private void limpar(){
        etRaio.setText("");
    }
}