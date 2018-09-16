package com.example.dc.qrcode;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratorActivity extends AppCompatActivity {

        EditText text;
        Button gen_btn;
        ImageView image_ImageView;
        String text2QR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);


        text = (EditText) findViewById(R.id.text);

        gen_btn = (Button) findViewById(R.id.gen_btn);

        image_ImageView = (ImageView) findViewById(R.id.image_ImageView);

        gen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2QR = text.getText().toString().trim();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(text2QR, BarcodeFormat.QR_CODE, 200, 200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image_ImageView.setImageBitmap(bitmap);


                }
                catch (WriterException e) {

                }
            }
        });
    }
}
