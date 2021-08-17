package zvhir.dev.robotface.demoapp;

import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;


public class Face extends AppCompatActivity {

    ImageView control;
    Button connect;
    ImageView gif;

    private CommunicateViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setup our activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);

        hideStatusBar();

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        gif = findViewById(R.id.gif);
        control = findViewById(R.id.control);
        connect = findViewById(R.id.connect);

        // Enable the back button in the action bar if possible
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Setup our ViewModel
        viewModel = ViewModelProviders.of(this).get(CommunicateViewModel.class);

        // This method return false if there is an error, so if it does, we should close.
        if (!viewModel.setupViewModel(getIntent().getStringExtra("device_name"), getIntent().getStringExtra("device_mac"))) {
            finish();
            return;
        }

        Glide.with(this).asGif().load(R.drawable.blink).into(gif);
        // Start observing the data sent to us by the ViewModel
        viewModel.getConnectionStatus().observe(this, this::onConnectionStatus);
        viewModel.getDeviceName().observe(this, name -> setTitle(getString(R.string.device_name_format, name)));
        viewModel.getMessages().observe(this, message -> {
            if (TextUtils.isEmpty(message)) {
                message = getString(R.string.no_messages);
            }
            Log.i("Data received: ", message);
            if (message.equals("angry")){
                Glide.with(this).asGif().load(R.drawable.angry).into(gif);
                Log.i("Play reaction: ", message);
            }
            if (message.equals("blink")){
                Glide.with(this).asGif().load(R.drawable.blink).into(gif);
                Log.i("Play reaction: ", message);
            }
            if (message.equals("curious")){
                Glide.with(this).asGif().load(R.drawable.curious).into(gif);
                Log.i("Play reaction: ", message);
            }
            if (message.equals("grateful")){
                Glide.with(this).asGif().load(R.drawable.grateful).into(gif);
                Log.i("Play reaction: ", message);
            }
            if (message.equals("laugh")){
                Glide.with(this).asGif().load(R.drawable.laugh).into(gif);
                Log.i("Play reaction: ", message);
            }
            if (message.equals("oneeye")){
                Glide.with(this).asGif().load(R.drawable.oneeye).into(gif);
                Log.i("Play reaction: ", message);
            }
            if (message.equals("sad")){
                Glide.with(this).asGif().load(R.drawable.sad).into(gif);
                Log.i("Play reaction: ", message);
            }
            if (message.equals("shock")){
                Glide.with(this).asGif().load(R.drawable.shock).into(gif);
                Log.i("Play reaction: ", message);
            }
            if (message.equals("understand")){
                Glide.with(this).asGif().load(R.drawable.understand).into(gif);
                Log.i("Play reaction: ", message);
            }
        });
        viewModel.getMessage().observe(this, message -> {
            // Only update the message if the ViewModel is trying to reset it
            if (TextUtils.isEmpty(message)) {
                Log.i("Data received: ", message);
            }
        });

    }

    public void hideStatusBar() {
        View view = getWindow().getDecorView();
        int uiOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
        view.setSystemUiVisibility(uiOption);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    // Called when the ViewModel updates us of our connectivity status
    private void onConnectionStatus(CommunicateViewModel.ConnectionStatus connectionStatus) {
        control = findViewById(R.id.control);
        switch (connectionStatus) {
            case CONNECTED:
                connect.setEnabled(true);
                connect.setText(R.string.disconnect);
                connect.setOnClickListener(v -> viewModel.disconnect());
                control.setBackgroundResource(R.drawable.dot_connected);
                break;
            case CONNECTING:
                connect.setEnabled(false);
                connect.setText(R.string.connect);
                control.setBackgroundResource(R.drawable.dot_connecting);
                break;
            case DISCONNECTED:
                connect.setEnabled(true);
                connect.setText(R.string.connect);
                connect.setOnClickListener(v -> viewModel.connect());
                control.setBackgroundResource(R.drawable.dot_disconnected);
                break;
        }
    }

    // Called when a button in the action bar is pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                // If the back button was pressed, handle it the normal way
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Called when the user presses the back button
    @Override
    public void onBackPressed() {
        // Close the activity
        finish();
    }
}
