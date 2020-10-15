package br.com.bersoncrios.notas.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.bersoncrios.notas.ui.NotasAdapter
import br.com.bersoncrios.notas.R
import br.com.bersoncrios.notas.data.Nota
import br.com.bersoncrios.notas.viewmodels.NotasViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialogo_ui.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.EnumSet.of

class MainActivity : AppCompatActivity(){

    private val notasViewModel: NotasViewModel by viewModel()

    val notasAdapter: NotasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        recycler_view.adapter = notasAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)


        //INICIALIZAR VIEW MODEL
       //notasViewModel = ViewModelProvider(this).get(NotasViewModel::class.java)

        notasViewModel.getNotas().observe(this, Observer {notas ->
            notas?.let {
                if (it.isEmpty()){
                        Toast.makeText(this, "Lista Vazia!", Toast.LENGTH_LONG).show()
                }
                else {
                    notasAdapter.add(it)
                }
            }
        })

//        notasViewModel.carregarNotas()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item!!.itemId == R.id.action_adicionar){
            dialigoAddNota()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialigoAddNota() {
        val layout = LayoutInflater.from(this).inflate(R.layout.dialogo_ui, null, false)

        val inputNota = layout.input_nota

        val dialog = AlertDialog.Builder(this)
        dialog.setView(layout)
        dialog.setNegativeButton("Cancelar", null)
        dialog.setPositiveButton("Salvar") {d, i ->
            var nota = Nota(id = 0, text = inputNota.text.toString())
            notasViewModel.salvar(nota)
        }
        dialog.create().show()
    }
}