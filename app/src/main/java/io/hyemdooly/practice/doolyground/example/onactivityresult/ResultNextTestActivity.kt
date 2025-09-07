package io.hyemdooly.practice.doolyground.example.onactivityresult

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.hyemdooly.practice.doolyground.R
import io.hyemdooly.practice.doolyground.databinding.ActivityResultNextTestBinding
import io.hyemdooly.practice.doolyground.databinding.ActivityResultTestBinding

class ResultNextTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultNextTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultNextTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnNext.setOnClickListener {
            startActivityForResult(Intent(this, ResultNextNextTestActivity::class.java), 123)
        }

        binding.btnFinish.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra("datakey", "HI"))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123) {
            Log.d("test", "== test")
            val data = data?.getStringExtra("datakey")
            binding.textCallback.text = data ?: "not catch"
        }
    }
}
