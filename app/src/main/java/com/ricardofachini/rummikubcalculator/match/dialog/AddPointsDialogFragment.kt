package com.ricardofachini.rummikubcalculator.match.dialog

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

            val playerOnClickName = arguments?.getString("player_name")
            binding.addPointsDialogTitle.text = "Adicionar pontos para " + playerOnClickName

            builder.setView(binding.root)
                .setPositiveButton("Adicionar") { _,_ ->
                    val points = binding.addPointsInput.text.toString()
                    listener.onAddPointsDialogPositiveClick(points.toInt(), arguments?.getInt("player_id"))
                }
                .setNegativeButton("Cancelar") { _,_ ->
                    dialog?.cancel()
                }

            builder.create()
        } ?: throw IllegalStateException("Fragment or activity cannot be null")
    }
}