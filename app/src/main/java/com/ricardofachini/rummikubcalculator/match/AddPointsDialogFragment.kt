package com.ricardofachini.rummikubcalculator.match

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.ricardofachini.rummikubcalculator.databinding.FragmentAddPointsDialogBinding

class AddPointsDialogFragment: DialogFragment() {
    private lateinit var listener: AddPointsDialogListener
    private lateinit var binding: FragmentAddPointsDialogBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as AddPointsDialogListener
        } catch (error: ClassCastException) {
            throw ClassCastException("Activity must implement ${AddPointsDialogListener::class}")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            binding = FragmentAddPointsDialogBinding.inflate(layoutInflater)

            val data = arguments?.getString("player_name")
            binding.addPointsDialogTitle.text = "Adicionar pontos para " + data

            builder.setView(binding.root)
                .setPositiveButton("Adicionar") { _,_ ->
                    val points = binding.addPointsInput.text.toString()
                    listener.onAddPointsDialogPositiveClick(points.toInt())
                }
                .setNegativeButton("Cancelar") { _,_ ->
                    dialog?.cancel()
                }

            builder.create()
        } ?: throw IllegalStateException("Fragment or activity cannot be null")
    }
}