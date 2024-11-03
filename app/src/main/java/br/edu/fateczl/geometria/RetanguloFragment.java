package br.edu.fateczl.geometria;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.fateczl.geometria.controller.CalculosRetangulo;
import br.edu.fateczl.geometria.model.Retangulo;

public class RetanguloFragment extends Fragment {
    /*
     *@author:<sJOÃO VITOR LIMA COSTA>
     */

    private EditText etAltura;
    private EditText etBase;
    private TextView tvResR;

    public RetanguloFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retangulo, container, false);
        etAltura = view.findViewById(R.id.etAltura);
        etBase = view.findViewById(R.id.etBase);
        tvResR = view.findViewById(R.id.tvResR);

        Button btnAreaR = view.findViewById(R.id.btnAreaR);
        btnAreaR.setOnClickListener(op -> area());

        Button btnPerimetroR = view.findViewById(R.id.btnPerimetroR);
        btnPerimetroR.setOnClickListener(op -> perimetro());

        return view;
    }

    private Retangulo objeto(){
        return new Retangulo(
                Float.parseFloat(etBase.getText().toString()),
                Float.parseFloat(etAltura.getText().toString()));
    }

    private void perimetro() {
        CalculosRetangulo rc = new CalculosRetangulo();
        String resposta = getText(R.string.resultado) + " " + rc.perimetro(objeto());
        tvResR.setText(resposta);
        limpar();
    }

    private void area() {
        CalculosRetangulo rc = new CalculosRetangulo();
        String resposta = getText(R.string.resultado) + " " + rc.area(objeto());
        tvResR.setText(resposta);
        limpar();
    }

    private void limpar(){
        etAltura.setText("");
        etBase.setText("");
    }
}