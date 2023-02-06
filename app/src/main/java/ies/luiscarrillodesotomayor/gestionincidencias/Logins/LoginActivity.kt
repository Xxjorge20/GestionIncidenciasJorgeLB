package ies.luiscarrillodesotomayor.gestionincidencias.Logins

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import ies.luiscarrillodesotomayor.gestionincidencias.Datos.Usuario
import ies.luiscarrillodesotomayor.gestionincidencias.MainActivity
import ies.luiscarrillodesotomayor.gestionincidencias.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Evento click del botón Registrar usuario

        binding.BRegistrarse.setOnClickListener(View.OnClickListener {

            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        })

        // Evento click del botón Iniciar sesión
        binding.BLogin.setOnClickListener {

            val email = binding.TBCorreo.text.toString()
            val password = binding.TBPassword.text.toString()

            // Validar que el email y la contraseña no estén vacíos
            if (email.isEmpty() || password.isEmpty()) {
                // Si están vacíos, mostrar mensaje de error
                Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT)
                    .show()
                Log.d("Login", "Por favor, rellene todos los campos")
            }
            else
            {
                val usuario = Usuario(email, password)
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(usuario.email,usuario.password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) return@addOnCompleteListener
                        // Si la autenticación es correcta, mostrar mensaje de bienvenida
                        Log.d("Login", "Inicio de sesion correctamente, bienvenido ${email}")
                        Toast.makeText(
                            this@LoginActivity,
                            "Bienvenido ${email}",
                            Toast.LENGTH_SHORT
                        ).show()

                        var nombre = email.substring(0,email.indexOf("@"))
                        // Abrir la actividad principal
                        intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("email",email)
                        intent.putExtra("nombre",nombre)
                        startActivity(intent)
                    }
                    .addOnFailureListener {
                        // Si la autenticación falla, mostrar mensaje de error
                        Log.d("Login", "Error al iniciar sesión: ${it.message}")
                        Toast.makeText(
                            this@LoginActivity,
                            "Error al iniciar sesión: ${it.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

            }

        }


        // Evento click del botón Recuperar contraseña
        binding.BRecordarContrasena.setOnClickListener(View.OnClickListener {
            intent = Intent(this, RecordarContrasena::class.java)
            startActivity(intent)
        })
    }
}