package br.com.bersoncrios.relativelayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("INFO", "onCreate")

        val cadastrados = arrayOf("João","Maria","José","Bento","Maíra")

        val lista = findViewById(R.id.lista) as ListView

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cadastrados)

        lista.setAdapter(adapter);
    }
}
