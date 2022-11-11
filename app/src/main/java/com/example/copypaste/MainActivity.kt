package com.example.copypaste

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.copypaste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgCopyPaste.setOnClickListener {
            val nama : String = binding.textNama.text.toString()
            Log.d("TAG", "onNama: "+nama)
            val cm : ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip : ClipData = ClipData.newPlainText("",nama)
            cm.setPrimaryClip(clip)
            Log.d("TAG", "onText: "+cm);
            Toast.makeText(applicationContext,"Coppied",Toast.LENGTH_SHORT).show()
        }
    }
}