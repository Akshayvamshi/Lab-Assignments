package com.example.nagar.camerademo;

/**
 * Created by nagar on 10/7/2016.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.nagar.camerademo.MainActivity.browse_flag;
import static com.example.nagar.camerademo.MainActivity.cam_flag;


public class PhotoActivity extends ActionBarActivity {
    int TAKE_PHOTO_CODE = 0;

    public static Bitmap photo;

    ImageView userImage;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActionBar().setTitle("Capture image");
        setContentView(R.layout.activity_photo);
        Button capture = (Button) findViewById(R.id.btn_take_photo);
        userImage = (ImageView) findViewById(R.id.view_photo);
        //take photo Button click eventlistener. Initializes the camera.
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });
    }
    //If the photo is captured then set the image view to the photo captured.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");

            userImage.setImageBitmap(photo);
            cam_flag = true;//setting up cam flag to know the cam pic is active.
            browse_flag = false;//setting up bowser to false.
            Log.d("CameraDemo", "Pic saved");
        }
    }

    public void redirectToHome(View v) {
        Intent redirect = new Intent(PhotoActivity.this, MainActivity.class);
        startActivity(redirect);
    }

    public void onClickOfPhotoBrowse(View v) { // to call
        //This code redirects to the browse photo activity.
        Intent redirect = new Intent(PhotoActivity.this, BrowseActivity.class);
        startActivity(redirect);
    }

    public void onClickOfMapButton(View v) {
        //This code redirects from main page to the maps page.
        Intent redirect = new Intent(PhotoActivity.this, MapsActivity.class);
        startActivity(redirect);
    }
}
