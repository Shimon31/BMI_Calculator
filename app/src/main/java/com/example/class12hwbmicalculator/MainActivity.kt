package com.example.class12hwbmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.class12hwbmicalculator.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val df = DecimalFormat("#.##")

        binding.bmiBTN.setOnClickListener(){
           val weight = binding.bmiWeight.text.toString().toDouble()
            val height = binding.bmiHeight.text.toString().toDouble()/100

            val bmi = weight/(height*height)
            val bmiFormat = df.format(bmi)

            binding.bmiTV.text = when(bmi){
                in 1.00..18.49->{
                    "Bmi is : $bmiFormat \n It's Underweight \n Food: Meat,Egg,Milk"
                }
                in 18.50..24.99->{
                    "Bmi is : $bmiFormat \n It's Healthy Weight \nFood: Meat,Egg,Milk,Vegetable"
                }
                in 25.00 ..29.00->{
                    "Bmi is : $bmiFormat \n It's Overweight \n Food: Vegetable,Egg,Papaya,Soup\n Exercise: Regularly"
                }
                else->{
                    "Bmi is : $bmiFormat \n It's Obese\n Food: vegetable,soup,Avoid Junk Food\n Exercise: Mandatory"
                }
            }



        }



    }
}