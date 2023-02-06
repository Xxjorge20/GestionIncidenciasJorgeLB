package ies.luiscarrillodesotomayor.gestionincidencias.Logins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import ies.luiscarrillodesotomayor.gestionincidencias.Datos.Usuario
import ies.luiscarrillodesotomayor.gestionincidencias.MainActivity
import ies.luiscarrillodesotomayor.gestionincidencias.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    // Declaración de variables
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var usuario: Usuario


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Evento click del botón
        binding.BRegistrarUsuario.setOnClickListener(View.OnClickListener {
            var nombreUsuario = binding.TBRegistroNombre.text.toString()
            var apellidosUsuario = binding.TBRegistroApellidos.text.toString()
            var emailUsuario = binding.TBRegistroCorreo.text.toString()
            var passwordUsuario = binding.TBRegistroContrasena.text.toString()

            // validar que los campos no estén vacíos
            if (nombreUsuario.isEmpty() || apellidosUsuario.isEmpty() || emailUsuario.isEmpty() || passwordUsuario.isEmpty()) {
                Toast.makeText(this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show()
            }
            else
            {
                usuario = Usuario(nombre = nombreUsuario, apellidos = apellidosUsuario, email = emailUsuario, password = passwordUsuario)

                // validar que la contraseña sea segura
                if (usuario.contraseñaSegura(usuario) && usuario.validarEmail())
                {
                    if (usuario.existeUsuario())
                    {
                        Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show()
                        binding.TBRegistroCorreo.setText("")
                        binding.TBRegistroContrasena.setText("")
                    }
                    else
                    {
                       // Registrar usuario
                        if (usuario.registrarUsuario(usuario))
                        {
                            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                            Intent(this, MainActivity::class.java).also {
                                startActivity(it)
                            }
                            finish()
                            Log.d("Registro", "Usuario registrado correctamente")
                        }
                        else
                        {
                            Intent(this, LoginActivity::class.java).also {
                                startActivity(it)
                            }
                            finish()
                            Log.d("Registro", "Error al registrar el usuario")
                        }
                    }
                }
                else
                {
                    Toast.makeText(this, "La contraseña no es lo suficientemente segura", Toast.LENGTH_SHORT).show()
                    binding.TBRegistroContrasena.setText("")
                    binding.TBRegistroContrasena.requestFocus()
                }

            }

        })
    }
}