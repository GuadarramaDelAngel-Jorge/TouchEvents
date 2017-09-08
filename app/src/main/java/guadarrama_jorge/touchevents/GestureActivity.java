package guadarrama_jorge.touchevents;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GestureActivity extends Activity implements
        GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    private static final String DEBUG_TAG = "Hello";
    private GestureDetectorCompat mDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        changeBackgroundColor(Color.MAGENTA);
        TextView textView = findViewById(R.id.hello_gesture);
        textView.setText(R.string.Down);
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        changeBackgroundColor(Color.CYAN);
        TextView textview = findViewById(R.id.hello_gesture);
        textview.setText(R.string.onFling);
        Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        changeBackgroundColor(Color.BLUE);
        TextView textview = findViewById(R.id.hello_gesture);
        textview.setText(R.string.LongPress);
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        changeBackgroundColor(Color.RED);
        TextView textview = findViewById(R.id.hello_gesture);
        textview.setText(R.string.Scroll);
        Log.d(DEBUG_TAG, "onScroll: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        changeBackgroundColor(Color.WHITE);
        TextView textview = findViewById(R.id.hello_gesture);
        textview.setText(R.string.ShowPress);
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        changeBackgroundColor(Color.GREEN);
        TextView textview = findViewById(R.id.hello_gesture);
        textview.setText(R.string.SingleTapUp);
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        changeBackgroundColor(Color.RED);
        TextView textview = findViewById(R.id.hello_gesture);
        textview.setText(R.string.DoubleTap);
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        changeBackgroundColor(Color.CYAN);
        TextView textview = findViewById(R.id.hello_gesture);
        textview.setText(R.string.DoubleTapEvent);
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        changeBackgroundColor(Color.LTGRAY);
        TextView textview = findViewById(R.id.hello_gesture);
        textview.setText(R.string.SingleTapConfirmed);
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }

    public void changeBackgroundColor(int color){
        View view = findViewById(R.id.main_Gesture);
        Drawable background = view.getBackground();
        int colorFrom = Color.TRANSPARENT;
        if (background instanceof ColorDrawable)
            colorFrom= ((ColorDrawable) background).getColor();

        int colorTo;
        colorTo = color;
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                View view = findViewById(R.id.main_Gesture);
                view.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();

    }}
