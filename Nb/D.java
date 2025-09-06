package Nb;

import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.melon.playback.FloatingLyricService;
import kotlin.jvm.internal.q;

public final class d implements View.OnTouchListener {
    public final int a;
    public int b;
    public float c;
    public float d;
    public boolean e;
    public final FloatingLyricService f;

    public d(FloatingLyricService floatingLyricService0) {
        this.f = floatingLyricService0;
        this.a = ViewConfiguration.get(floatingLyricService0).getScaledTouchSlop();
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        q.g(view0, "v");
        q.g(motionEvent0, "event");
        int v = motionEvent0.getAction();
        FloatingLyricService floatingLyricService0 = this.f;
        switch(v) {
            case 0: {
                this.e = false;
                q.d(floatingLyricService0.d);
                WindowManager.LayoutParams windowManager$LayoutParams0 = floatingLyricService0.d;
                q.d(windowManager$LayoutParams0);
                this.b = windowManager$LayoutParams0.y;
                this.c = motionEvent0.getRawX();
                this.d = motionEvent0.getRawY();
                return false;
            }
            case 1: {
                if(!this.e) {
                    Intent intent0 = new Intent("com.iloen.melon.MELON_PLAYER_START");
                    intent0.addCategory("android.intent.category.DEFAULT");
                    intent0.addFlags(0x10000000);
                    intent0.putExtra("activitystartactionname", "player");
                    PendingIntent pendingIntent0 = PendingIntent.getActivity(floatingLyricService0, 0, intent0, 0xC000000);
                    try {
                        pendingIntent0.send();
                    }
                    catch(PendingIntent.CanceledException pendingIntent$CanceledException0) {
                        pendingIntent$CanceledException0.printStackTrace();
                    }
                    view0.performClick();
                    return false;
                }
                MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
                WindowManager.LayoutParams windowManager$LayoutParams1 = floatingLyricService0.d;
                q.d(windowManager$LayoutParams1);
                melonPrefs0.setInt("FloatingLyricY", windowManager$LayoutParams1.y);
                return false;
            }
            case 2: {
                if(!this.e) {
                    double f = Math.abs(motionEvent0.getRawX() - this.c);
                    double f1 = (double)this.a;
                    if(f >= f1 || Math.abs(motionEvent0.getRawY() - this.d) >= f1) {
                        this.e = true;
                    }
                }
                WindowManager.LayoutParams windowManager$LayoutParams2 = floatingLyricService0.d;
                q.d(windowManager$LayoutParams2);
                windowManager$LayoutParams2.y = this.b - ((int)(motionEvent0.getRawY() - this.d));
                try {
                    WindowManager windowManager0 = floatingLyricService0.c;
                    q.d(windowManager0);
                    windowManager0.updateViewLayout(view0, floatingLyricService0.d);
                }
                catch(Exception exception0) {
                    LogU.Companion.e("FloatingLyricService", "onTouch() updateViewLayout error : " + exception0);
                }
                return false;
            }
            default: {
                return false;
            }
        }
    }
}

