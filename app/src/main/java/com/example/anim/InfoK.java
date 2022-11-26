package com.example.anim;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.util.Base64;

public class InfoK extends AppCompatActivity {

    ImageView imageView;
    EditText Student, Subject, Class;

    MaskK mask;
    Connection connection;
    View v;
    String image = "";


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_k);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        mask = getIntent().getParcelableExtra("Cat");

        imageView = findViewById(R.id.InfoKImage);

        /*Student = findViewById(R.id.addendum_Student);
        Student.setText(mask.getStudent());

        Class = findViewById(R.id.addendum_Class);
        Class.setText(mask.getCclass());

        Subject = findViewById(R.id.addendum_Subject);
        Subject.setText(mask.getSubject());*/



        imageView.setImageBitmap(getImgBitmap(mask.getImage()));
        v = findViewById(com.google.android.material.R.id.ghost_view);
    }

    private Bitmap getImgBitmap(String encodedImg) {
        if(encodedImg!=null&& !encodedImg.equals("null")) {
            byte[] bytes = new byte[0];
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                bytes = Base64.getDecoder().decode(encodedImg);
            }
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        //return BitmapFactory.decodeResource(Details.this.getResources(),
                //R.drawable.zagl);
        return null;
    }

    public void onClickChooseImage(View view)
    {
        getImage();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && data!= null && data.getData()!= null)
        {
            if(resultCode==RESULT_OK)
            {
                Log.d("MyLog","Image URI : "+data.getData());
                imageView.setImageURI(data.getData());
                Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                encodeImage(bitmap);

            }
        }
    }

    private void getImage()
    {
        Intent intentChooser= new Intent();
        intentChooser.setType("image/*");
        intentChooser.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentChooser,1);
    }

    private String encodeImage(Bitmap bitmap) {
        int prevW = 150;
        int prevH = bitmap.getHeight() * prevW / bitmap.getWidth();
        Bitmap b = Bitmap.createScaledBitmap(bitmap, prevW, prevH, false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            image=Base64.getEncoder().encodeToString(bytes);
            return image;
        }
        return "";
    }
}