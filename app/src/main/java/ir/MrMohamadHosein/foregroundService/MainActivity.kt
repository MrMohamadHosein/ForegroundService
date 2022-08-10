package ir.MrMohamadHosein.foregroundService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startMyService()

    }


    private fun startMyService() {
        val intent = Intent(this , LogcatService::class.java)
        startService(intent)
    }

}