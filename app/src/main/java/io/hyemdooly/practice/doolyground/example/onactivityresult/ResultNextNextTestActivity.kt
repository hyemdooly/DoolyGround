package io.hyemdooly.practice.doolyground.example.onactivityresult

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.hyemdooly.practice.doolyground.R
import io.hyemdooly.practice.doolyground.databinding.ActivityResultNextNextTestBinding
import io.hyemdooly.practice.doolyground.databinding.ActivityResultNextTestBinding

class ResultNextNextTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultNextNextTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultNextNextTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnFinish.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra("datakey", "HIHI"))
            finish()
        }
    }
}
