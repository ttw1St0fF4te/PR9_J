package com.example.myapplication2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

public class FullImageView extends AppCompatActivity {
    ImageView FullImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_image_view);
        FullImage = findViewById(R.id.full_image);
        String imageUriSrc = getIntent().getStringExtra("image");
        Uri imageUri = Uri.parse(imageUriSrc);
        try{
            InputStream imageStream = getContentResolver().openInputStream(imageUri);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            FullImage.setImageBitmap(selectedImage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}