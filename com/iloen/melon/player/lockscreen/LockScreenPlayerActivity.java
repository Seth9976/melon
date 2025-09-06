package com.iloen.melon.player.lockscreen;

import Rc.D;
import Rc.P;
import Rc.t0;
import Rc.x;
import Xb.j;
import android.app.Activity;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.o;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import com.iloen.melon.eventbus.EventActivityState.EventActivityResumed;
import com.iloen.melon.eventbus.EventActivityState;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.FloatingLyricHelper;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import pd.d;
import r8.b;

public class LockScreenPlayerActivity extends Hilt_LockScreenPlayerActivity implements d, b {
    private static final String TAG = "LockScreenPlayerActivity";
    private static final float UNLOCK_CLICK_PASS_FILTER = 0.01f;
    private static final int UNLOCK_DRAG_START_DELAY = 30;
    private static final float UNLOCK_DRAG_START_OPACITY = 0.05f;
    private static final int UNLOCK_DRAG_VELOCITY_UNIT = 200;
    private static final float UNLOCK_ENABLE_OPACITY = 0.35f;
    private long beginTime;
    private int deviceHeight;
    private int deviceWidth;
    private boolean dragStart;
    IntentFilter filter;
    private View fragmentContainer;
    private static boolean mIsForeground;
    private float opacity;
    private float originX;
    private float originY;
    private x playerFragment;
    private VelocityTracker velocityTracker;

    public LockScreenPlayerActivity() {
        this.dragStart = false;
        this.filter = new IntentFilter();
    }

    @Override  // pd.b
    public boolean dismissDialogOnStop() {
        return false;
    }

    @Override  // android.app.Activity
    public boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        boolean z = this.isPopupShowing();
        switch(motionEvent0.getAction()) {
            case 0: {
                this.beginTime = System.currentTimeMillis();
                this.originX = motionEvent0.getX();
                this.originY = motionEvent0.getY();
                return super.dispatchTouchEvent(motionEvent0);
            }
            case 2: {
                if(System.currentTimeMillis() - this.beginTime > 30L) {
                    float f5 = motionEvent0.getX() - this.originX;
                    float f6 = motionEvent0.getY() - this.originY;
                    this.opacity = z ? Math.abs(f5 / ((float)this.deviceWidth)) : ((float)(Math.sqrt(Math.pow(f6, 2.0) + Math.pow(f5, 2.0)) / ((double)Math.min(this.deviceWidth, this.deviceHeight))));
                    if(this.dragStart) {
                        if(this.velocityTracker == null) {
                            this.velocityTracker = VelocityTracker.obtain();
                        }
                        this.velocityTracker.addMovement(motionEvent0);
                        this.fragmentContainer.setAlpha(1.0f - this.opacity * 2.857143f);
                        return true;
                    }
                    if((!z || Math.abs(f5) > Math.abs(f6) * 2.0f) && this.opacity > 0.05f) {
                        this.originX = motionEvent0.getX();
                        this.originY = motionEvent0.getY();
                        this.dragStart = true;
                        return super.dispatchTouchEvent(motionEvent0);
                    }
                }
                return super.dispatchTouchEvent(motionEvent0);
            }
            case 1: 
            case 3: {
                if(this.dragStart) {
                    float f = motionEvent0.getX() - this.originX;
                    float f1 = z ? Math.abs(f / ((float)this.deviceWidth)) : ((float)(Math.sqrt(Math.pow(motionEvent0.getY() - this.originY, 2.0) + Math.pow(f, 2.0)) / ((double)Math.min(this.deviceWidth, this.deviceHeight))));
                    this.opacity = f1;
                    if(f1 > 0.01f) {
                        motionEvent0.setAction(3);
                    }
                }
                VelocityTracker velocityTracker0 = this.velocityTracker;
                if(velocityTracker0 != null) {
                    velocityTracker0.computeCurrentVelocity(200);
                    float f2 = this.velocityTracker.getXVelocity();
                    float f3 = this.velocityTracker.getYVelocity();
                    this.velocityTracker.recycle();
                    this.velocityTracker = null;
                    double f4 = Math.sqrt(Math.pow(this.deviceHeight, 2.0) + Math.pow(this.deviceWidth, 2.0));
                    if(((double)(this.isPopupShowing() ? Math.abs(f2) : Math.abs(f2) + Math.abs(f3))) > f4 * 0.35) {
                        this.finish();
                        return super.dispatchTouchEvent(motionEvent0);
                    }
                }
                if(this.dragStart && this.opacity > 0.35f) {
                    this.finish();
                    return super.dispatchTouchEvent(motionEvent0);
                }
                this.dragStart = false;
                this.fragmentContainer.setAlpha(1.0f);
                return super.dispatchTouchEvent(motionEvent0);
            }
            default: {
                return super.dispatchTouchEvent(motionEvent0);
            }
        }
    }

    @Override  // android.app.Activity
    public void finish() {
        super.finish();
        this.overridePendingTransition(0x7F010034, 0x7F010035);  // anim:lockscreen_fade_in
    }

    @Override  // pd.d
    public Activity getActivity() {
        return this;
    }

    public static boolean isForeground() {
        return LockScreenPlayerActivity.mIsForeground;
    }

    @Override  // r8.b
    public boolean isLockScreen() {
        return true;
    }

    private boolean isPopupShowing() {
        return this.playerFragment != null && !(((t0)this.playerFragment.getViewModel()).i instanceof D);
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        Point point0 = ScreenUtils.getRealScreenSize(this);
        this.deviceWidth = point0.x;
        this.deviceHeight = point0.y;
    }

    @Override  // com.iloen.melon.player.lockscreen.Hilt_LockScreenPlayerActivity
    public void onCreate(Bundle bundle0) {
        LogU.d("LockScreenPlayerActivity", "onCreate()");
        super.onCreate(bundle0);
        FloatingLyricHelper.requestStopFloatingLyric();
        this.requestWindowFeature(1);
        this.overridePendingTransition(0, 0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.addFlags(0x80000);
            com.google.firebase.b.A(window0);
            ScreenUtils.setAppearanceLightStatusBars(window0, false);
            ScreenUtils.setAppearanceLightNavigationBars(window0, false);
        }
        this.setContentView(0x7F0D001D);  // layout:activity_lockscreen_popup_fragment
        this.fragmentContainer = this.findViewById(0x7F0A04DB);  // id:fragment
        this.playerFragment = new x();
        l0 l00 = this.getSupportFragmentManager();
        a a0 = o.f(l00, l00);
        a0.e(0x7F0A04DB, this.playerFragment, null, 1);  // id:fragment
        a0.k();
        EventBusHelper.register(this);
        Point point0 = ScreenUtils.getRealScreenSize(this);
        this.deviceWidth = point0.x;
        this.deviceHeight = point0.y;
        this.filter.addAction("android.intent.action.SCREEN_ON");
    }

    @Override  // com.iloen.melon.player.lockscreen.Hilt_LockScreenPlayerActivity
    public void onDestroy() {
        LogU.d("LockScreenPlayerActivity", "onDestroy()");
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.clearFlags(0x80000);
        }
        EventBusHelper.unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(EventActivityState eventActivityState0) {
        if(eventActivityState0 instanceof EventActivityResumed && !this.equals(eventActivityState0.mActivity)) {
            this.finish();
        }
    }

    @Override  // android.app.Activity
    public boolean onKeyUp(int v, KeyEvent keyEvent0) {
        if(v == 4) {
            if(this.playerFragment != null && !(((t0)this.playerFragment.getViewModel()).i instanceof D)) {
                this.playerFragment.sendUserEvent(P.a);
            }
            return true;
        }
        return super.onKeyUp(v, keyEvent0);
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onPause() {
        LogU.d("LockScreenPlayerActivity", "onPause()");
        LockScreenPlayerActivity.mIsForeground = false;
        super.onPause();
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.clearFlags(0x400000);
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onResume() {
        LogU.d("LockScreenPlayerActivity", "onResume()");
        super.onResume();
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.addFlags(0x400000);
        }
        LockScreenPlayerActivity.mIsForeground = true;
    }

    @Override  // r8.b
    public boolean shouldIgnoreForeground() {
        return true;
    }

    @Override  // pd.b
    public boolean shouldSkipEvent(j j0) {
        return false;
    }
}

