package com.example.animalkingdom.ui.animaldetails;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.example.animalkingdom.R;
import com.example.animalkingdom.data.model.Animal;
import com.example.animalkingdom.ui.BaseFragment.BaseFragment;


public class AnimalDialogFragment extends DialogFragment{

    public BaseFragment fatherFragment;



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the MaterialAlertDialogBuilder to create the dialog
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext(), R.style.CustomDialogStyle);

        // Set dialog title
        builder.setTitle("Add New Animal");

        // Set the custom view for the dialog
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.animal_dialog_fragment, null);
        builder.setView(dialogView);

        // Create the dialog
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);

        dialog.setCanceledOnTouchOutside(false);

        // Set positive button with text and click listener
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                EditText editTextAnimalName = dialogView.findViewById(R.id.edit_text_athlete_name);
                EditText editTextAnimalHabitat = dialogView.findViewById(R.id.edit_text_athlete_habitat);
                EditText editTextAnimalDiet = dialogView.findViewById(R.id.edit_text_athlete_diet);

                String animalName = editTextAnimalName.getText().toString();
                String animalHabitat = editTextAnimalHabitat.getText().toString();
                String animalDiet = editTextAnimalDiet.getText().toString();

                if (animalName.isEmpty() || animalHabitat.isEmpty() || animalDiet.isEmpty()
                ) {
                    // Display a Toast message indicating all fields must be filled
                   Toast.makeText(requireContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    Animal animal = new Animal(animalName,animalHabitat,animalDiet);
                    fatherFragment.addItem(animal);

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