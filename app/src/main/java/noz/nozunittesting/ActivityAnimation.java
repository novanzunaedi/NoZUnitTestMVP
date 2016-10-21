package noz.nozunittesting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import noz.nozunittesting.main.MainActivity;
import top.wefor.circularanim.CircularAnim;

/**
 * Created by CLient-Pc on 22/10/2016.
 */

public class ActivityAnimation {

    private Context c;
    private View v;

    public ActivityAnimation(Context context, View v) {
        this.c = context;
        this.v = v;
    }

    public void startMainActivity() {
        CircularAnim.fullActivity((Activity) c, v)
                .colorOrImageRes(R.color.colorPrimaryDark)
                .go(new CircularAnim.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd() {
                        c.startActivity(new Intent(c, MainActivity.class));
                    }
                });
    }
}

