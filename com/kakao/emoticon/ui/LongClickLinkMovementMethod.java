package com.kakao.emoticon.ui;

import D5.a;
import android.os.Handler;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.kakao.emoticon.ui.widget.EmoticonSpan;

public class LongClickLinkMovementMethod extends ArrowKeyMovementMethod {
    private static int LONG_CLICK_TIME = 500;
    private boolean isEmoticonTouch;
    private boolean isLongPressed;
    private Handler longClickHandler;
    private static LongClickLinkMovementMethod sInstance;

    private LongClickLinkMovementMethod() {
        this.isLongPressed = false;
    }

    @Override  // android.text.method.ArrowKeyMovementMethod
    public static MovementMethod getInstance() {
        if(LongClickLinkMovementMethod.sInstance == null) {
            LongClickLinkMovementMethod longClickLinkMovementMethod0 = new LongClickLinkMovementMethod();
            LongClickLinkMovementMethod.sInstance = longClickLinkMovementMethod0;
            longClickLinkMovementMethod0.longClickHandler = new Handler();
        }
        return LongClickLinkMovementMethod.sInstance;
    }

    public boolean isEmoticonTouch() {
        return this.isEmoticonTouch;
    }

    private void lambda$onTouchEvent$0(EmoticonSpan[] arr_emoticonSpan, TextView textView0, MotionEvent motionEvent0) {
        arr_emoticonSpan[0].onLongClick(textView0, ((int)motionEvent0.getX()), ((int)motionEvent0.getY()));
        this.isLongPressed = true;
    }

    @Override  // android.text.method.ArrowKeyMovementMethod
    public boolean onTouchEvent(TextView textView0, Spannable spannable0, MotionEvent motionEvent0) {
        try {
            int v = motionEvent0.getAction();
            if(v == 3) {
                Handler handler0 = this.longClickHandler;
                if(handler0 != null) {
                    handler0.removeCallbacksAndMessages(null);
                }
            }
            if(v == 0 || v == 1) {
                int v1 = (int)motionEvent0.getX();
                int v2 = (int)motionEvent0.getY();
                int v3 = textView0.getTotalPaddingLeft();
                int v4 = textView0.getTotalPaddingTop();
                int v5 = v1 - v3 + textView0.getScrollX();
                int v6 = v2 - v4 + textView0.getScrollY();
                Layout layout0 = textView0.getLayout();
                int v7 = layout0.getOffsetForHorizontal(layout0.getLineForVertical(v6), ((float)v5));
                EmoticonSpan[] arr_emoticonSpan = (EmoticonSpan[])spannable0.getSpans(v7, v7, EmoticonSpan.class);
                if(arr_emoticonSpan.length != 0 && arr_emoticonSpan[0].contains(v5, v6)) {
                    this.isEmoticonTouch = true;
                    if(v == 1) {
                        Handler handler1 = this.longClickHandler;
                        if(handler1 != null) {
                            handler1.removeCallbacksAndMessages(null);
                        }
                        if(!this.isLongPressed) {
                            arr_emoticonSpan[0].onClick(textView0);
                        }
                        this.isLongPressed = false;
                        return true;
                    }
                    this.longClickHandler.postDelayed(new a(this, arr_emoticonSpan, textView0, motionEvent0, 21), ((long)LongClickLinkMovementMethod.LONG_CLICK_TIME));
                    return true;
                }
                this.isEmoticonTouch = false;
            }
            return super.onTouchEvent(textView0, spannable0, motionEvent0);
        }
        catch(Exception unused_ex) {
            return false;
        }
    }
}

