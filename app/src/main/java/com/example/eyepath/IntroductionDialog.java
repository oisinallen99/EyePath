package com.example.eyepath;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class IntroductionDialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Information")
        .setMessage("For best results hold device at face level a moderate distance away from your face. Start calibration and maintain the position of the device throughout use. Should calibration feel off recalibrate. If eye tracking stops working at any stage refresh the page using the menu in the top right corner.")
        .setPositiveButton("Okay!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })  ;
        return builder.create();
    }
}
