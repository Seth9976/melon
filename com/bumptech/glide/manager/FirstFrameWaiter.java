package com.bumptech.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

final class FirstFrameWaiter implements FrameWaiter {
    volatile boolean isFirstFrameSet;
    final Set pendingActivities;

    public FirstFrameWaiter() {
        this.pendingActivities = Collections.newSetFromMap(new WeakHashMap());
    }

    @Override  // com.bumptech.glide.manager.FrameWaiter
    public void registerSelf(Activity activity0) {
        if(this.isFirstFrameSet || !this.pendingActivities.add(activity0)) {
            return;
        }
        View view0 = activity0.getWindow().getDecorView();
        view0.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            @Override  // android.view.ViewTreeObserver$OnDrawListener
            public void onDraw() {
                Util.postOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        HardwareConfigState.getInstance().unblockHardwareBitmaps();
                        FirstFrameWaiter.this.isFirstFrameSet = true;
                        FirstFrameWaiter.removeListener(com.bumptech.glide.manager.FirstFrameWaiter.1.this.val$view, this);
                        FirstFrameWaiter.this.pendingActivities.clear();
                    }
                });
            }
        });
    }

    public static void removeListener(View view0, ViewTreeObserver.OnDrawListener viewTreeObserver$OnDrawListener0) {
        view0.getViewTreeObserver().removeOnDrawListener(viewTreeObserver$OnDrawListener0);
    }
}

