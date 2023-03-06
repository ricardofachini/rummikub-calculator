package com.ricardofachini.rummikubcalculator.match

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AddPointsDialogFragment: DialogFragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            val addPoints = inflater.inflate() //colocar o layout do fragment aqui

            builder.setView(addPoints)

            builder.create()
        } ?: throw IllegalStateException("Fragment or activity cannot be null")
    }
}