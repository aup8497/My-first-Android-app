package com.example.akshayuprabhu.myfirstapp1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by akshayuprabhu on 10/10/16.
 */

public class Splash extends Activity{

    MediaPlayer song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        song=MediaPlayer.create(Splash.this,R.raw.bravesong);//the song name must
        // be-> all smallCase letters
        song.start();


        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(7000);//puts the thread to sleep for 7000 milliseconds
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent openMainActivity = new Intent("com.example.akshayuprabhu.MENU");
                    //this is the action name of the MainActivity under the androidManifest.XML
                    //here Intent is a type of dataType(not exactly!!)
                    startActivity(openMainActivity);//this starts the activity(different layout)
                    // with the given intent name
                }
            }
        };
        timer.start();
    }
//when the mainActivity is Started(second line of finally statement),Splash activity calls onPause
// method(for detailed information of this see life cycle of an activity)
    @Override
    protected void onPause() {
        super.onPause();

        finish();
        song.release();

       // finish();//this method destroys the 'activity' which calls the onPause method

        //ourSong is not recognised here ,it is recognised only in oncreate method
        //hence we create a global variale i.e define it outside the oncreate method

    }
}
