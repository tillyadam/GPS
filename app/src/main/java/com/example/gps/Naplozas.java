package com.example.gps;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Naplozas {
    //CSV: longitude,latitude,dátum
    public static void kiir(double longitude, double latitude) throws IOException {
        Date datum = Calendar.getInstance().getTime();

        //éééé-hh-nn óó:pp:mm
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formazottDatum = dateFormat.format(datum);

        String sor = String.format("%f,%f,%s", longitude, latitude, formazottDatum);

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            File file = new File(Environment.getExternalStorageDirectory(), "gps.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.append(sor);
            bw.append(System.lineSeparator());
            bw.close();
        }
    }
}
