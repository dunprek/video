package don.ctrl.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mPlay;
    private VideoView mVideoView;
    private MediaController mMediaController;
    private boolean mCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheck = false;
        initUi();

    }
    private void initUi(){
        mPlay = (LinearLayout) findViewById(R.id.btn_play);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        mMediaController = new MediaController(this);
        mPlay.setOnClickListener(this);
    }

    private void setmVideoView(){
        String videoPath = "https://r4---sn-4pgnuhxqp5-jb3d.googlevideo.com/videoplayback?ipbits=0&initcwndbps=802500&pcm2cms=yes&mime=video%2Fmp4&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2cms%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cupn%2Cexpire&id=o-AGgEK_6snyjOFKcFG_csmiAZKdbECeUOh9kkUV3B_Wm_&mn=sn-4pgnuhxqp5-jb3d&mm=31&pl=22&ip=202.62.17.69&ms=au&ei=YOXaV6z7A4r7oAO6ha2oDA&mv=m&mt=1473962756&ratebypass=yes&sver=3&expire=1473984960&upn=UF4cgFkK66s&itag=22&signature=B2DA6B349748A35944D4BE2ED909F5CD82DD12D5.2AC3030B4A242082F20421F2B445FB4B66F56D73&key=yt6&requiressl=yes&lmt=1472027745388392&dur=15.092&source=youtube";
//        String videoPath = "https://www.youtube.com/watch?v=5CQzC6uG6mo";
        Uri uri = Uri.parse(videoPath);
        mVideoView.setVideoURI(uri);
        mVideoView.setMediaController(mMediaController);
  /*      mMediaController.setAnchorView(mVideoView);
        mMediaController.requestFocus();*/
        mVideoView.start();
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mCheck = true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:

                setmVideoView();
                if (mCheck==false){
                    mPlay.setVisibility(View.VISIBLE);

                }else{
                    mPlay.setVisibility(View.GONE);
                }


        }
    }






}
