package com.kakao.emoticon.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kakao.emoticon.util.ScreenUtils;

public class KeyboardDetectorLayout extends FrameLayout {
    static class KeyboardDetectorHandler extends Handler {
        OnKeyboardDetectListener detectListener;

        public KeyboardDetectorHandler(OnKeyboardDetectListener keyboardDetectorLayout$OnKeyboardDetectListener0) {
            this.detectListener = keyboardDetectorLayout$OnKeyboardDetectListener0;
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            boolean z = true;
            switch(message0.what) {
                case 2: {
                    if(message0.arg1 != 1) {
                        z = false;
                    }
                    OnKeyboardDetectListener keyboardDetectorLayout$OnKeyboardDetectListener0 = this.detectListener;
                    if(keyboardDetectorLayout$OnKeyboardDetectListener0 != null) {
                        if(z) {
                            keyboardDetectorLayout$OnKeyboardDetectListener0.onKeyboardShown();
                            return;
                        }
                        keyboardDetectorLayout$OnKeyboardDetectListener0.onKeyboardHidden();
                        return;
                    }
                    break;
                }
                case 3: {
                    OnKeyboardDetectListener keyboardDetectorLayout$OnKeyboardDetectListener1 = this.detectListener;
                    if(keyboardDetectorLayout$OnKeyboardDetectListener1 != null) {
                        keyboardDetectorLayout$OnKeyboardDetectListener1.onKeyboardHeightChanged(message0.arg1, message0.arg2);
                        return;
                    }
                    break;
                }
                case 4: {
                    this.detectListener.clear();
                    return;
                }
                default: {
                    super.handleMessage(message0);
                }
            }
        }
    }

    public interface OnKeyboardDetectListener {
        void clear();

        void onKeyboardHeightChanged(int arg1, int arg2);

        void onKeyboardHidden();

        void onKeyboardShown();
    }

    private static final int CLEAR = 4;
    private static final int MSG_DELAY_TIME = 300;
    private static final int MSG_HEIGHT_CHANGED = 3;
    private static final int MSG_LONG_DELAY_TIME = 500;
    private static final int MSG_VISIBILITY_CHANGED = 2;
    private int cachedStatusBarHeight;
    private boolean isChangedOrient;
    private boolean isKeyboardOn;
    private Handler keyboardDetectorHandler;

    public KeyboardDetectorLayout(Context context0) {
        this(context0, null, 0);
    }

    public KeyboardDetectorLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public KeyboardDetectorLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public Activity getActivity(Context context0) {
        while(context0 instanceof ContextWrapper) {
            if(context0 instanceof Activity) {
                return (Activity)context0;
            }
            context0 = ((ContextWrapper)context0).getBaseContext();
        }
        return null;
    }

    public boolean isKeyboardOn() {
        return this.isKeyboardOn;
    }

    private void keyboardDetect() {
        int v = this.measureKeyboardHeight();
        int v1 = 2;
        if(v > 100) {
            if(!this.isKeyboardOn) {
                this.isKeyboardOn = true;
                this.isChangedOrient = false;
                this.keyboardDetectorHandler.removeMessages(2);
                this.keyboardDetectorHandler.sendMessageDelayed(Message.obtain(this.keyboardDetectorHandler, 2, ((int)this.isKeyboardOn), 0), 300L);
            }
            this.keyboardDetectorHandler.removeMessages(3);
            Context context0 = this.getContext();
            int v2 = ScreenUtils.INSTANCE.getHeight(context0);
            Context context1 = this.getContext();
            if(v2 >= ScreenUtils.INSTANCE.getWidth(context1)) {
                v1 = 1;
            }
            this.keyboardDetectorHandler.sendMessageDelayed(Message.obtain(this.keyboardDetectorHandler, 3, v, v1), 300L);
            return;
        }
        if(this.isKeyboardOn) {
            this.isKeyboardOn = false;
            this.keyboardDetectorHandler.removeMessages(2);
            if(this.isChangedOrient) {
                this.isChangedOrient = false;
                this.keyboardDetectorHandler.sendMessageDelayed(Message.obtain(this.keyboardDetectorHandler, 2, ((int)this.isKeyboardOn), 0), 500L);
                return;
            }
            int v3 = Build.VERSION.SDK_INT < 29 ? 300 : 0;
            this.keyboardDetectorHandler.sendMessageDelayed(Message.obtain(this.keyboardDetectorHandler, 2, ((int)this.isKeyboardOn), 0), ((long)v3));
        }
    }

    private int measureKeyboardHeight() {
        int v = Build.VERSION.SDK_INT;
        int v1 = this.getRootWindowInsets().getSystemWindowInsetBottom() - this.getRootWindowInsets().getStableInsetBottom();
        if(v >= 29 && this.getRootWindowInsets().getStableInsetBottom() - this.getRootWindowInsets().getMandatorySystemGestureInsets().bottom != 0) {
            v1 -= this.getRootWindowInsets().getMandatorySystemGestureInsets().bottom;
        }
        return v1 <= 0 ? 0 : v1;
    }

    @Override  // android.view.View
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.isChangedOrient = true;
    }

    @Override  // android.widget.FrameLayout
    public void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        this.keyboardDetect();
    }

    public void setKeyboardStateChangedListener(OnKeyboardDetectListener keyboardDetectorLayout$OnKeyboardDetectListener0) {
        if(this.keyboardDetectorHandler == null) {
            this.keyboardDetectorHandler = new KeyboardDetectorHandler(keyboardDetectorLayout$OnKeyboardDetectListener0);
        }
    }
}

