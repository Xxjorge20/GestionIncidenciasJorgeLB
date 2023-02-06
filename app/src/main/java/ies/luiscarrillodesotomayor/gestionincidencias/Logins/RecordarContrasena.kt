package ies.luiscarrillodesotomayor.gestionincidencias.Logins

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ies.luiscarrillodesotomayor.gestionincidencias.Datos.Usuario
import ies.luiscarrillodesotomayor.gestionincidencias.databinding.RecordarContrasenaBinding

class RecordarContrasena : AppCompatActivity() {

    private lateinit var binding: RecordarContrasenaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecordarContrasenaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var usuario : Usuario = Usuario(nombre = "", apellidos = "", email = "", password = "")



        // Botón para volver recuperar contraseña y volver a la pantalla de login
        binding.BRecordarContrasena.setOnClickListener(View.OnClickListener {
            var email = binding.TBCorreoRecuperarContrasena.text.toString()

            // Validar que el email y la contraseña no estén vacíos
            if (email.isEmpty())
            {
                // Si están vacíos, mostrar mensaje de error
                Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show()
                Log.d("RecuperarPassword", "Por favor, rellene todos los campos")
            }
            else
            {
                usuario.email = email
                if (!usuario.recordarContraseña(email))
                {
                    //Si el usuario se ha registrado correctamente, mostrar mensaje de éxito
                    Toast.makeText(this, "Se ha enviado un correo para recuperar la contraseña", Toast.LENGTH_SHORT).show()
                    Log.d("RecuperarPassword", "Se ha enviado un correo para recuperar la contraseña")
                    //Volver a la pantalla de login
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                else
                {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    //Si no se ha podido registrar el usuario, mostrar mensaje de error
                    Toast.makeText(this, "No se ha podido enviar el correo para recuperar la contraseña", Toast.LENGTH_SHORT).show()
                    Log.d("RecuperarPassword", "No se ha podido enviar el correo para recuperar la contraseña")
                }

            }
        })
    }
}

