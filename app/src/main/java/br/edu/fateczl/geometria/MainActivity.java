package br.edu.fateczl.geometria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<sJOÃO VITOR LIMA COSTA>
     */

    Fragment fragment;

    private static final HashMap<Integer, Fragment> MAPA = new HashMap<>(Map.ofEntries(
            Map.entry(R.id.item_ret, new RetanguloFragment()),
            Map.entry(R.id.item_cir, new CirculoFragment())
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            carregaFragment(bundle);
        }
    }

    private void carregaFragment(Bundle bundle) {
        fragment = MAPA.get(bundle.getInt("forma"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        alternar(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private static void alternar(Activity atividade, int itemID){
        Bundle bundle = new Bundle();
        bundle.putInt("forma", itemID);
        Intent i = new Intent(atividade, MainActivity.class);
        i.putExtras(bundle);
        atividade.startActivity(i);
        atividade.finish();
    }

}