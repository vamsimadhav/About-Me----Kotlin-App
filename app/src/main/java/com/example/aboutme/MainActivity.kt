package com.example.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var myName: MyName = MyName("Vamsi Madhav H")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.button.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {

        binding.apply {
            myName?.nickName = editTextTextPersonName.editableText.toString()
            invalidateAll()
            nickName.visibility = View.VISIBLE
            view.visibility = View.GONE
            editTextTextPersonName.visibility = View.GONE
        }

        // Hide the keyboard
        val im = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        im.hideSoftInputFromWindow(view.windowToken,0)
    }

}