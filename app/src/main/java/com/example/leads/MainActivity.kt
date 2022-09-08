package com.example.leads

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bRegistrase : Button = findViewById(R.id.bRegistrarse)

        bRegistrase.setOnClickListener {
            registro()
        }

    }

    private fun registro() {
        val etNombre : EditText = findViewById(R.id.etNombre)
        val etTelefono : EditText = findViewById(R.id.etTelefono)
        val etEmail : EditText = findViewById(R.id.etEmail)

        val sArea : Spinner = findViewById(R.id.sArea)

        val cbAdministracion : CheckBox = findViewById(R.id.cbAdministracion)
        val cbDerecho : CheckBox = findViewById(R.id.cbDerecho)
        val cbMedicina : CheckBox = findViewById(R.id.cbMedicina)
        val cbSistemas : CheckBox = findViewById(R.id.cbSistemas)
        //////////////////////////////////////////////////////////////////////////////

        val nombre : String = etNombre.text.toString()
        val telefono : String = etTelefono.text.toString()
        val email : String = etEmail.text.toString()

        val area : String = sArea.selectedItem.toString().trim()

        var administracion : String = ""
        if(cbAdministracion.isChecked){ administracion = getString(R.string.administracion) }

        var derecho : String = ""
        if(cbDerecho.isChecked){ derecho = getString(R.string.derecho) }

        var medicina : String = ""
        if(cbMedicina.isChecked){ medicina = getString(R.string.medicina) }

        var sistemas : String = ""
        if(cbSistemas.isChecked){ sistemas = getString(R.string.sistemas) }

    //////////////////////////////////////////////////////////////////////////////////////////
    // VALIDACION

        if(nombre.isNotEmpty()){
            if(telefono.isNotEmpty()){
                if(email.isNotEmpty()){
                    if(area.isNotBlank()){
                        if(administracion.isNotEmpty() ||
                            derecho.isNotEmpty() ||
                                medicina.isNotEmpty() ||
                                    sistemas.isNotEmpty()){


                            mensajeConfirmacion("")


                        }else{
                            mensajeError(getString(R.string.error_licenciatura))
                        }
                    }else{
                        mensajeError(getString(R.string.error_area))
                    }
                }else{
                    mensajeError(getString(R.string.error_email))
                }
            }else{
                mensajeError(getString(R.string.error_telefono))
            }
        }else{
            mensajeError(getString(R.string.error_nombre))
        }
    }

    private fun mensajeConfirmacion(s: String) {

    }

    private fun mensajeError(s: String) {
        val alertDialog: AlertDialog? = this?.let {

            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(R.string.ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User clicked OK button
                    })
            }

            builder.setTitle(getString(R.string.datos_faltantes))
            builder.setMessage(s)

            // Create the AlertDialog
            builder.create()
            builder.show()
        }
    }
}