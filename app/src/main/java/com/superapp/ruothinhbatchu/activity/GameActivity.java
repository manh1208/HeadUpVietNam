package com.superapp.ruothinhbatchu.activity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.analytics.HitBuilders;
//import com.google.android.gms.analytics.Tracker;
import com.revmob.RevMob;
import com.revmob.RevMobAdsListener;
import com.revmob.ads.banner.RevMobBanner;
import com.revmob.ads.interstitial.RevMobFullscreen;
import com.superapp.ruothinhbatchu.R;
import com.superapp.ruothinhbatchu.dialog.ResultDialog;
import com.superapp.ruothinhbatchu.model.Result;
import com.superapp.ruothinhbatchu.utils.DataUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.CBLocation;

/**
 * Created by ManhNV on 2/22/2016.
 */
public class GameActivity extends Activity implements SensorEventListener,ResultDialog.ButtonClickHandle {
    protected static final String     TAG     = GameActivity.class.getSimpleName();
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private boolean start = false;
    private boolean done = false;
    private boolean next = false;
    private TextView mText;
    private ImageView mImageGame;
    private int mScore = 0;
    private boolean isCountdown = false;
    private Animation translateIn;
    private List<Integer> mList;
    private int mCurrent;
    private final int timer = 6000;
    private SeekBar bar;
    protected PowerManager.WakeLock mWakeLock;
    private HashMap<Integer, Result> listResult;
    private Context mContext;
    private HashMap<Integer, String> listItem;
    ResultDialog dialog;
    CountDownTimer countDownGame;
    MediaPlayer mp;
    private RevMob revmob;
    private RevMobBanner banner;
    private RevMobFullscreen fullscreen;
    private boolean fullscreenIsLoaded;
//    private Tracker mTracker;
//    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        Chartboost.startWithAppId(this, "56d8630cf789821203cdc036", "3cf4ad96da07137e375b1c576f5b9d7986fb356c");
        Chartboost.onCreate(this);
        Chartboost.cacheInterstitial(CBLocation.LOCATION_GAME_SCREEN);
//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        startRevMobSession();
        requestNewInterstitial();
        init();
        reset();
        createList();
    }

    private void init() {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        mText = (TextView) findViewById(R.id.text_game);
        mImageGame = (ImageView) findViewById(R.id.imageGame);
        translateIn = AnimationUtils.loadAnimation(this, R.anim.translate_left_side);
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        this.mWakeLock.acquire();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        bar = (SeekBar) findViewById(R.id.pbTimer);
        bar.setEnabled(false);
        listResult = new HashMap<Integer, Result>();
        mContext = this;
        headUp();
//        AnalyticsApplication application = (AnalyticsApplication) getApplication();
//        mTracker = application.getDefaultTracker();
//        Log.i(TAG, "Setting screen name: Game");
//        mTracker.setScreenName("Image~Game");
//        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    private void createList() {
        HashMap<Integer, HashMap<Integer, String>> hashMap = DataUtils.getINSTANCE().getAllImage();
        int id = getIntent().getIntExtra("id", R.drawable.animal);
        listItem = hashMap.get(id);
        mList = new ArrayList<>(listItem.keySet());
        Collections.shuffle(mList);
    }
    private boolean timeToEnd = false;
    //Start Countdown game
    private void startTime() {
        timeToEnd=false;
         countDownGame = new CountDownTimer(timer * 10, 10) {

            @Override
            public void onTick(long millisUntilFinished) {
                bar.setProgress((int) (millisUntilFinished / 10));
                if (millisUntilFinished/10<900 && !timeToEnd){
                    timeToEnd=true;
                    mp = MediaPlayer.create(mContext, R.raw.countdown);
                    mp.start();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"Onfinish");
                start = false;
                done =true;
                mp = MediaPlayer.create(getApplicationContext(), R.raw.timeout);
                mp.start();
                dialog = new ResultDialog(mContext, mScore, listResult);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

            }
        };
        countDownGame.start();
    }

    private void reset() {
        mScore = 0;
        listResult.clear();
        mCurrent=0;
    }

    private void headUp(){
        bar.setVisibility(View.INVISIBLE);
        mImageGame.setBackgroundResource(R.drawable.headup);
        int times = DataUtils.getINSTANCE().getTimes();
        Log.i(TAG,"Times="+times);
        if (times ==3){
            Log.d(TAG,"Show Ads");
            DataUtils.getINSTANCE().setTimes(0);
//            if (Chartboost.hasInterstitial(CBLocation.LOCATION_GAME_SCREEN)) {
//                Chartboost.showInterstitial(CBLocation.LOCATION_GAME_SCREEN);
//            }
//            else {
//                Chartboost.cacheInterstitial(CBLocation.LOCATION_GAME_SCREEN);
//            }
//            Chartboost.showInterstitial(CBLocation.LOCATION_GAME_SCREEN);
            showFullscreen();
//            mInterstitialAd.show();
//            if (mInterstitialAd.isLoaded()) {
//                mInterstitialAd.show();
//                mInterstitialAd.setAdListener(new AdListener() {
//                    @Override
//                    public void onAdClosed() {
//                        super.onAdClosed();
//
//                    }
//
//                    @Override
//                    public void onAdLoaded() {
//                        super.onAdLoaded();
//                        mInterstitialAd.show();
//                    }
//                });
//            } else {
//                requestNewInterstitial();
//                //  Toast.makeText(MainActivity.this, "Đang load quảng cáo. Vui lòng đợi!", Toast.LENGTH_SHORT).show();
//            }

        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            //
            if (z < -8 && z > -10 && x>-6&&x<6 && y > -5 && y < 5 && start && !done && !isCountdown) {
                if (!next) {
                    mImageGame.setBackgroundResource(R.drawable.right);
                    //Đặt vào list kết quả
                    String s = listItem.get(mList.get(mCurrent));
                    listResult.put(mList.get(mCurrent), new Result(s, true));
                    mCurrent++;
                    mScore++;
                    next = true;
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beep);
                    mp.start();
                }
            }
            if (z > -5 && z < 5 && x > 5 && x < 10 && y > -5 && y < 5) {
                if (!start && !done) {
                    start = true;
                    isCountdown=true;
                    final int[] count = {3};
                    CountDownTimer countDownTimer = new CountDownTimer(3500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                            Log.d("Đếm: ", millisUntilFinished + "; Đếm: "+count[0]);
                            switch (count[0]) {
                                case 3:
                                     mp = MediaPlayer.create(getApplicationContext(), R.raw.beep);
                                    mp.start();
                                    count[0]--;
                                    mImageGame.setBackgroundResource(R.drawable.three);
                                    break;
                                case 2:
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beep);
                                    mp.start();
                                    mImageGame.setBackgroundResource(R.drawable.two);
                                    count[0]--;
                                    break;
                                case 1:
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beep);
                                    mp.start();
                                    mImageGame.setBackgroundResource(R.drawable.one);
                                    count[0]--;
                                    break;
                            }
                        }
                        @Override
                        public void onFinish() {
                            reset();
                            isCountdown = false;
                            bar.setVisibility(View.VISIBLE);
                            startTime();
                            mImageGame.setBackgroundResource(mList.get(mCurrent));
                            next = false;
                            Log.d(TAG,"Times="+DataUtils.getINSTANCE().getTimes());
                            DataUtils.getINSTANCE().setTimes(DataUtils.getINSTANCE().getTimes()+1);
//                            mTracker.send(new HitBuilders.EventBuilder()
//                                    .setCategory("Action")
//                                    .setAction("Start Game")
//                                    .build());
                        }
                    };
                    countDownTimer.start();
                }

                if (start && next && !done &&!isCountdown ) {
                    if(mCurrent<mList.size()){
                    mImageGame.setBackgroundResource(mList.get(mCurrent));
                    next = false;

                    }else{
                        countDownGame.onFinish();
                        countDownGame.cancel();
                    }
                }
            }

            if (z > 8 && z < 10 && x>-6&&x<6 && y > -5 && y < 5&& start && !done & mCurrent < mList.size() &&!isCountdown ) {

                if (!next) {
                    String s = listItem.get(mList.get(mCurrent));
                    listResult.put(mList.get(mCurrent), new Result(s, false));
                    mImageGame.setBackgroundResource(R.drawable.skip);
                    next = true;
                    mCurrent++;
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beep);
                    mp.start();
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensorEvent, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        this.mWakeLock.release();
        if (countDownGame!=null) {
            countDownGame.cancel();
        }
        super.onDestroy();
        Chartboost.onDestroy(this);
        Log.d("Hủy","Rồi");
    }

    @Override
    public void playAgain() {
        done=false;
        mp = MediaPlayer.create(mContext, R.raw.click);
        mp.start();
        dialog.cancel();
        headUp();
        Collections.shuffle(mList);
//        mTracker.send(new HitBuilders.EventBuilder()
//                .setCategory("Action")
//                .setAction("Play Again")
//                .build());

    }

    @Override
    public void onBackPressed() {
        if (Chartboost.onBackPressed())
            return;
        else
            super.onBackPressed();
        if (countDownGame!=null) {
            countDownGame.cancel();
        }
        Log.d("Hủy", "Chưa");
        start=false;
        done=true;
        if (mp!=null){
            mp.stop();
        }
        mp = MediaPlayer.create(mContext, R.raw.click);
        mp.start();
//        mTracker.send(new HitBuilders.EventBuilder()
//                .setCategory("Action")
//                .setAction("Back")
//                .build());
    }

    @Override
    public void cancel() {
        onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Chartboost.onStart(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Chartboost.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Chartboost.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Chartboost.onStop(this);
    }
    private void requestNewInterstitial() {
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//
//        mInterstitialAd.loadAd(adRequest);

    }

    public void startRevMobSession() {
        //RevMob's Start Session method:
        revmob = RevMob.startWithListener(this, new RevMobAdsListener() {
            @Override
            public void onRevMobSessionStarted() {
                loadFullscreen();
                Log.i("RevMob","Session Started");
            }
            @Override
            public void onRevMobSessionNotStarted(String message) {
                //If the session Fails to start, no ads can be displayed.
                Log.i("RevMob","Session Failed to Start");
            }
        }, "584fc3dfff6b2b3c1cfea8ec");
        if (revmob!=null){
            loadFullscreen();
        }

        Log.i("Revmob","ahihi");
    }

    public void loadFullscreen() {
        //load it with RevMob listeners to control the events fired
        fullscreen = revmob.createFullscreen(this,  new RevMobAdsListener() {
            @Override
            public void onRevMobAdReceived() {
                Log.i("RevMob", "Fullscreen loaded.");
                fullscreenIsLoaded = true;
//                showFullscreen();
            }
            @Override
            public void onRevMobAdNotReceived(String message) {
                Log.i("RevMob", "Fullscreen not received.");
            }
            @Override
            public void onRevMobAdDismissed() {
                Log.i("RevMob", "Fullscreen dismissed.");
            }
            @Override
            public void onRevMobAdClicked() {
                Log.i("RevMob", "Fullscreen clicked.");
            }
            @Override
            public void onRevMobAdDisplayed() {
                Log.i("RevMob", "Fullscreen displayed.");
            }
        });
    }
    public void showFullscreen() {
        if(fullscreenIsLoaded) {
            fullscreen.show(); // call it wherever you want to show the fullscreen ad
//            DataUtils.getINSTANCE().setUnlock(mImageResource);
            fullscreenIsLoaded = false;
            loadFullscreen();
        } else {
//            loadFullscreen();
            Log.i("RevMob", "Ad not loaded yet.");
        }
    }

}
