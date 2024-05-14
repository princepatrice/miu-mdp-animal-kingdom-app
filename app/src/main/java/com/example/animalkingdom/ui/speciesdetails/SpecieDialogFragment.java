package com.example.animalkingdom.ui.speciesdetails;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.animalkingdom.data.model.Specie;
import com.example.animalkingdom.ui.BaseFragment.BaseFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.example.animalkingdom.R;


public class SpecieDialogFragment extends DialogFragment {

    public BaseFragment fatherFragment;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the MaterialAlertDialogBuilder to create the dialog
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext(), R.style.CustomDialogStyle);

        // Set dialog title
        builder.setTitle("Add New Specie");

        // Set the custom view for the dialog
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.specie_dialog_fragment, null);
        builder.setView(dialogView);

        // Create the dialog
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);

        dialog.setCanceledOnTouchOutside(false);

        // Set positive button with text and click listener
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                EditText editTextSpecieName = dialogView.findViewById(R.id.edit_text_specie_name);
                EditText editTextSpecieDescription= dialogView.findViewById(R.id.edit_text_specie_description);

                String specieName = editTextSpecieName.getText().toString();
                String specieDescription= editTextSpecieDescription.getText().toString();

                if (specieName.isEmpty() || specieDescription.isEmpty()
                ) {
                    // Display a Toast message indicating all fields must be filled

                    Toast.makeText(requireContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    Specie specie = new Specie(specieName,specieDescription);
                    fatherFragment.addItem(specie);
                    dialog.dismiss(); // Dismiss the dialog
                }
            }
        });

        // Set negative button with text and click listener
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Handle negative button click
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        return dialog;
    }

    // This function is called when you want to return data
}