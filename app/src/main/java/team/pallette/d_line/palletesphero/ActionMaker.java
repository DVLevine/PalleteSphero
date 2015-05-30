package team.pallette.d_line.palletesphero;

import android.os.Handler;

import orbotix.sphero.Sphero;

/**
 * Created by D-Line on 5/30/15.
 */
public class ActionMaker {

    private Sphero mSphero;


    public ActionMaker(Sphero theSphero){
        mSphero = theSphero;
    }

    public void blink(final boolean lit){

        if(mSphero != null){

            //If not lit, send command to show blue light, or else, send command to show no light
            if(lit){
                mSphero.setColor(0, 0, 0);                               // 1
            }else{
                mSphero.setColor(0, 0, 255);                             // 2
            }

            //Send delayed message on a handler to run blink again
            final Handler handler = new Handler();                       // 3
            handler.postDelayed(new Runnable() {
                public void run() {
                    blink(!lit);
                }
            }, 1000);
        }
    }

    public void drive() {
        if(mSphero != null) {
            // Send a roll command to Sphero so it goes forward at full speed.
            mSphero.drive(0.0f, 1.0f);                                           // 1

            // Send a delayed message on a handler
            final Handler handler = new Handler();                               // 2
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    // Send a stop to Sphero
                    mSphero.stop();                                               // 3
                }
            }, 2000);

        }
    }



}
