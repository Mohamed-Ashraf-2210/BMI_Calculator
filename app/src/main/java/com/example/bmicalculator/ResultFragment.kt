package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bmicalculator.databinding.FragmentCalculatorBinding
import com.example.bmicalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private var binding: FragmentResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)

        binding?.apply {
            val heightCM = arguments?.getString("heightCM")
            val weightKG = arguments?.getString("weightKG")
            val gender = arguments?.getString("gender")
            val heightM = heightCM?.toInt()?.div(100)
            val res = (weightKG?.toInt())?.div((heightM?.times(heightM)!!))?.toFloat()

            resNumber.text = res.toString()

            if (gender == "male") {
                forMale.visibility = View.VISIBLE
                forFemale.visibility = View.GONE

                title4.text = when (res!!) {
                    in 0.0..18.5 -> "Underweight BMI"
                    in 18.5.. 24.9 -> "Normal BMI"
                    in 25.0.. 29.9 -> "Overweight BMI"
                    else -> "Obesity"
                }
            } else {
                forMale.visibility = View.GONE
                forFemale.visibility = View.VISIBLE
                title4.text = when (res!!) {
                    in 0.0..19.0 -> "Underweight BMI"
                    in 19.0.. 24.9 -> "Normal BMI"
                    in 25.0.. 29.9 -> "Overweight BMI"
                    else -> "Obesity"
                }
            }
        }

        return binding?.root
    }

}