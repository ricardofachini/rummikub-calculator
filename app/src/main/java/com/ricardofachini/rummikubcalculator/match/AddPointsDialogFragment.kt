package com.ricardofachini.rummikubcalculator.match

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.ricardofachini.rummikubcalculator.R

class AddPointsDialogFragment: DialogFragment() {
    private lateinit var listener: AddPointsDialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            val addPointsView = inflater.inflate(R.layout.fragment_add_points_dialog, null)
            val pointsInput = addPointsView.findViewById<EditText>(R.id.addPointsInput)

            builder.setView(addPointsView)
                .setPositiveButton("Adicionar") { _,_ ->
                    val points = pointsInput.text.toString()
                    listener.onAddPointsDialogPositiveClick(points.toInt())
                }
                .setNegativeButton("Cancelar") { _,_ ->
                    dialog?.cancel()
                }

            builder.create()
        } ?: throw IllegalStateException("Fragment or activity cannot be null")
    }
}