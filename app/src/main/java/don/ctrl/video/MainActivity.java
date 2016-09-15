package don.ctrl.video;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mPlay;
    private VideoView mVideoView;
    private MediaController mMediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();

    }
    private void initUi(){
        mPlay = (Button) findViewById(R.id.btn_play);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        mMediaController = new MediaController(this);
        mPlay.setOnClickListener(this);
    }

    private void setmVideoView(){
        String videoPath = "https://www.youtube.com/watch?v=SrPHLj_q_OQ";
        Uri uri = Uri.parse(videoPath);
        mVideoView.setVideoURI(uri);
        mVideoView.setMediaController(mMediaController);
        mMediaController.setAnchorView(mVideoView);
        mVideoView.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                setmVideoView();
        }
    }
}
