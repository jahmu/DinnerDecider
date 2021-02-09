package com.example.dinnerdecider

import android.content.SharedPreferences
import com.example.dinnerdecider.R



import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dinnerdecider.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var data : SharedPreferences
    lateinit var editData: SharedPreferences.Editor
    var choice: Int =0
    lateinit var food: String
    var newchoice:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        data = applicationContext.getSharedPreferences("choice", MODE_PRIVATE)
        editData = data.edit()

        binding.button.setOnClickListener {
            choice = Random.nextInt(0, 7)
            when (choice) {
                0 -> {
                    food = "Githeri"
                    binding.backgroud.setBackgroundColor(Color.BLUE)
                    binding.backgroud.setBackgroundResource(R.drawable.githeri)
                }
                1 -> {
                    food = "Rice"
                    //binding.backgroud.setBackgroundColor(Color.GREEN)
                    binding.backgroud.setBackgroundResource(R.drawable.rice)
                }
                2 -> {
                    food = "Ugali"
                    //binding.backgroud.setBackgroundColor(Color.WHITE)
                    binding.backgroud.setBackgroundResource(R.drawable.ugali)
                }
                3 -> {
                    food = "Matoke"
                    //binding.backgroud.setBackgroundColor(Color.BLACK)
                    binding.backgroud.setBackgroundResource(R.drawable.matoke)

                }
                4 ->{
                    food = "Chapati"
                    //binding.backgroud.setBackgroundColor(Color.GRAY)
                    binding.backgroud.setBackgroundResource(R.drawable.chapati)
                }
                5 -> {
                    food = "Pilau"
                    //binding.backgroud.setBackgroundColor(Color.DKGRAY)
                    binding.backgroud.setBackgroundResource(R.drawable.pilau)

                }
                6 -> {
                    food = "biriani"
                    //binding.backgroud.setBackgroundColor(Color.CYAN)
                    binding.backgroud.setBackgroundResource(R.drawable.biriani)
                }
                else -> food = "We could not decide"

            }
            binding.textView.text = food
        }

    }
    override fun onStop() {
        super.onStop()
        saveData()
    }



    override fun onStart() {
        super.onStart()
        retrieve()
    }

    fun saveData(){
        editData.putInt("currentchoice",choice)
        editData.commit()
    }

    fun retrieve(){
        newchoice = data.getInt("currentchoice", 0)
        when (newchoice) {
            0 -> {
                food = "Githeri"
                binding.backgroud.setBackgroundColor(Color.BLUE)
                binding.backgroud.setBackgroundResource(R.drawable.githeri)
            }
            1 -> {
                food = "Rice"
                //binding.backgroud.setBackgroundColor(Color.GREEN)
                binding.backgroud.setBackgroundResource(R.drawable.rice)
            }
            2 -> {
                food = "Ugali"
                //binding.backgroud.setBackgroundColor(Color.WHITE)
                binding.backgroud.setBackgroundResource(R.drawable.ugali)
            }
            3 -> {
                food = "Matoke"
                //binding.backgroud.setBackgroundColor(Color.BLACK)
                binding.backgroud.setBackgroundResource(R.drawable.matoke)

            }
            4 ->{
                food = "Chapati"
                //binding.backgroud.setBackgroundColor(Color.GRAY)
                binding.backgroud.setBackgroundResource(R.drawable.chapati)
            }
            5 -> {
                food = "Pilau"
                //binding.backgroud.setBackgroundColor(Color.DKGRAY)
                binding.backgroud.setBackgroundResource(R.drawable.pilau)

            }
            6 -> {
                food = "biriani"
                //binding.backgroud.setBackgroundColor(Color.CYAN)
                binding.backgroud.setBackgroundResource(R.drawable.biriani)
            }
            else -> food = "We could not decide"

        }
        binding.textView.text = food
    }
}