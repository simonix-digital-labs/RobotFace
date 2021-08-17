package zvhir.dev.robotface.demoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;


public class Test extends AppCompatActivity {

    //create class reference
    VideoView videoView;
    TextView txtEmotion;
    ImageView control;

    @SuppressWarnings("DEPRECATION")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        txtEmotion = (TextView) findViewById(R.id.emotionTxt);
        videoView = (VideoView)findViewById(R.id.videoView);
        control = (ImageView) findViewById(R.id.control);


        videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.angry);
        videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("emotion");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String emotion = dataSnapshot.getValue().toString();
//                if(emotion.equals("angry-horizontal")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.angry_horizontal);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("angry-vertical")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.angry_vertical);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("sad-slow")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.sad_slow);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("sad-fast")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.sad_fast);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("laugh-fast")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.laugh_fast);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("laugh-slow")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.laugh_slow);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("blink-normal")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.blinking_normal);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("blink-weird")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.blinking_weird);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("smile")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.smile);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//                if(emotion.equals("shock")){
//                    videoView.setVideoPath("android.resource://zvhir.dev.robotface/"+R.raw.shock);
//                    videoView.start();
//                    txtEmotion.setText("Emotion: " + emotion);
//                    Log.i("Robot face reaction", emotion);
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
//                //do nothing
//            }
//
//        });




    }

}