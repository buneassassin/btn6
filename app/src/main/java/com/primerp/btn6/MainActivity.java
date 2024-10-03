package com.primerp.btn6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button btnExplicit1, btnExplicit2, btnExplicit3;
    Button btnImplicit1, btnImplicit2, btnImplicit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botones de Intent Explícito
        btnExplicit1 = findViewById(R.id.btnExplicit1);
        btnExplicit2 = findViewById(R.id.btnExplicit2);
        btnExplicit3 = findViewById(R.id.btnExplicit3);

        // Botones de Intent Implícito
        btnImplicit1 = findViewById(R.id.btnImplicit1);
        btnImplicit2 = findViewById(R.id.btnImplicit2);
        btnImplicit3 = findViewById(R.id.btnImplicit3);

        // Intent Explícito 1: Navegar a otra actividad
        btnExplicit1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Intent Explícito 2: Enviar datos a otra actividad
        btnExplicit2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("message", "Hola desde la MainActivity");
            startActivity(intent);
        });

        // Intent Explícito 3: Navegar y obtener resultado
        btnExplicit3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, 1);
        });

        // Intent Implícito 1: Abrir navegador web
        btnImplicit1.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        // Intent Implícito 2: Abrir la cámara
        btnImplicit2.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        // Intent Implícito 3: Hacer una llamada
        btnImplicit3.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+123456789"));
            startActivity(intent);
        });
    }
}