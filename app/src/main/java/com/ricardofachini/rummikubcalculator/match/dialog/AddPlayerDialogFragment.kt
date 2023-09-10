package com.ricardofachini.rummikubcalculator.match.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.ricardofachini.rummikubcalculator.databinding.FragmentAddPlayerDialogBinding

class AddPlayerDialogFragment: DialogFragment() {
    private lateinit var binding: FragmentAddPlayerDialogBinding
    private lateinit var listener: AddPlayerDialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as AddPlayerDialogListener
        } catch (error: ClassCastException) {
            throw ClassCastException("Activity must implement ${AddPlayerDialogListener::class}")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            binding = FragmentAddPlayerDialogBinding.inflate(layoutInflater)

            builder.setView(binding.root)
                .setPositiveButton("Adicionar") { _, _ ->
                    val name = binding.addPlayerInput.text
                    listener.addPlayerNameToCurrentMatch(name.toString())
                }
                .setNegativeButton("Cancelar") {_,_ ->
                    dialog?.cancel()
                }

            builder.create()
        } ?: throw IllegalStateException("okasodkaskodk")
    }
}