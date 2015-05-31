package team.pallette.d_line.palletesphero.interfacing;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import orbotix.robot.base.Robot;
import orbotix.view.calibration.Controller;
import team.pallette.d_line.palletesphero.R;

/**
 * Created by D-Line on 5/30/15.
 */
public class SlideStickView extends View implements Controller {

    private final SlideStickNub nub;
    private int nub_radius = 25;

    private final SlideStickBackground background;
    private int background_radius = 75;

    private int overlap = 30;

    public SlideStickView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.nub = new SlideStickNub();
        this.background = new SlideStickBackground();


        if(attrs != null){
            TypedArray a = this.getContext().obtainStyledAttributes(attrs, R.styleable.JoystickView);

            //Get puck size
            this.nub_radius = (int)a.getDimension(R.styleable.JoystickView_puck_radius, 25);

            //Get alpha
            this.setAlpha(a.getFloat(R.styleable.JoystickView_alpha, 255));

            //Get edge overlap
            this.overlap = (int)a.getDimension(R.styleable.JoystickView_edge_overlap, 10);
        }
    }



    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public void setRobot(Robot robot) {

    }

    @Override
    public void interpretMotionEvent(MotionEvent motionEvent) {

    }
}
