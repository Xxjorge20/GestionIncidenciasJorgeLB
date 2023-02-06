package ies.luiscarrillodesotomayor.gestionincidencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import ies.luiscarrillodesotomayor.gestionincidencias.Logins.LoginActivity

class SplashActivity : AppCompatActivity() {

    val SPLASH_TIME_OUT:Long = 1500 // 2 sec



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread(Runnable {
            Thread.sleep(SPLASH_TIME_OUT)
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }).start()

    }


}