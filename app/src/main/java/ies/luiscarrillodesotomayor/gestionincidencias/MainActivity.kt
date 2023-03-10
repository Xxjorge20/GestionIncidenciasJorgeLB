package ies.luiscarrillodesotomayor.gestionincidencias

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat.*
import com.google.firebase.auth.FirebaseAuth
import ies.luiscarrillodesotomayor.gestionincidencias.Logins.LoginActivity
import ies.luiscarrillodesotomayor.gestionincidencias.Menu.*
import ies.luiscarrillodesotomayor.gestionincidencias.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.open_drawer, R.string.close_drawer)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        // cargo el header del menu lateral
        val header = binding.navView.getHeaderView(0)
        val email = header.findViewById<TextView>(R.id.TBCorreoUserName)
        val nombre = header.findViewById<TextView>(R.id.TBUserName)
        email.text = intent.getStringExtra("email")
        nombre.text = intent.getStringExtra("nombre")



        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, CasaFragment()).commit()
                    binding.drawer.closeDrawers()
                }
                R.id.nav_modificarIncidencia -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, ModificarIncidencia()).commit()
                    binding.drawer.closeDrawers()
                }
                R.id.nav_insertarIncidencia -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, InsertarIncidenciaFragment()).commit()
                    binding.drawer.closeDrawers()
                }
                R.id.nav_salir -> {
                    cerrarSesion()
                    // vuelvo a la actividad de login
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    // Cierro la actividad
                    finish()

                }
            }

            binding.drawer.closeDrawer(START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // Funcion para cerrar Sesi??n de firebase
    fun cerrarSesion() {
        // Cierro la sesi??n de firebase
        FirebaseAuth.getInstance().signOut()
        Log.d("CierreSesion", "Sesi??n cerrada")
    }


}