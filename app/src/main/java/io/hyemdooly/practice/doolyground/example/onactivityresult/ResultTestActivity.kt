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
import io.hyemdooly.practice.doolyground.databinding.ActivityResultTestBinding

class ResultTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultTestBinding

//    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == RESULT_OK) {
//            val data = result.data?.getStringExtra("datakey")
//            binding.textCallback.text = data ?: "not catch"
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "test")
        enableEdgeToEdge()
        binding = ActivityResultTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnNext.setOnClickListener {
//            launcher.launch(Intent(this, ResultNextTestActivity::class.java))
            startActivityForResult(Intent(this, ResultNextTestActivity::class.java), 123123)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val data = data?.getStringExtra("datakey")
            binding.textCallback.text = data ?: "not catch"
        }
    }
}
