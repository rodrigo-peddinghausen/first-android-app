package br.com.senac.first_activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //O 'R' serve para referenciarmos recursos existentes em arquivos XML
        random = new Random();
        grid = (GridView)findViewById(R.id.gridView1);
        atualizarNumeros();
    }

    private void atualizarNumeros() {
        Integer[] numeros = new Integer[6];
        for (int i = 0; i < 6; i++) {
            numeros[i] = random.nextInt(60) + 1;
            for(int j = 0; j < i; j++) {
                if (numeros[i] == numeros[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(numeros);
        ArrayAdapter<Integer> adaptador = new ArrayAdapter<Integer>(this, R.layout.elemento, R.id.numero, numeros);
        // O ArrayAdapter faz a conexão entre um Array (que pode ser um vetor tradicional ou uma List) e um objeto visual (que pode ser um GridView, ListView ou Spinner)
        grid.setAdapter(adaptador);
    }

    public void onClick(View v) {
        atualizarNumeros();
        Toast.makeText(this, "Boa sorte! :)", Toast.LENGTH_SHORT).show();
    }
}