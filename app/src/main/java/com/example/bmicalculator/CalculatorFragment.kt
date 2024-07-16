package com.example.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bmicalculator.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {

    private var binding: FragmentCalculatorBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        actionBtn()
        return binding?.root
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    private fun actionBtn() {
        binding?.apply {
            plusAge.setOnClickListener {
                val age = ageNumber.text.toString().toInt()
                if (age < 99)
                    ageNumber.text = (age + 1).toString()
            }

            minusAge.setOnClickListener {
                val age = ageNumber.text.toString().toInt()
                if (age > 1)
                    ageNumber.text = (age - 1).toString()
            }

            plusWeight.setOnClickListener {
                weightNumber.text = (weightNumber.text.toString().toInt() + 1).toString()
            }

            minusWeight.setOnClickListener {
                weightNumber.text = (weightNumber.text.toString().toInt() - 1).toString()
            }

            slider.addOnChangeListener { _, value, _ ->
                heightNumber.text = value.toInt().toString()
            }

            maleCard.setOnClickListener {
                maleSelect.visibility = View.VISIBLE
                femaleSelect.visibility = View.GONE
            }

            femaleCard.setOnClickListener {
                maleSelect.visibility = View.GONE
                femaleSelect.visibility = View.VISIBLE
            }

            calculateBmiBtn.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, ResultFragment())
                    .commit()
            }
        }
    }

}