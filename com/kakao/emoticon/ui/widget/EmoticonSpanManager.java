package com.kakao.emoticon.ui.widget;

import android.view.View;
import android.widget.TextView;
import com.kakao.emoticon.ui.LongClickLinkMovementMethod;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class EmoticonSpanManager {
    private static EmoticonSpanManager instance;
    private List spanList;

    private EmoticonSpanManager() {
        this.spanList = new ArrayList();
    }

    public void add(EmoticonSpan emoticonSpan0) {
        WeakReference weakReference0 = new WeakReference(emoticonSpan0);
        this.spanList.add(weakReference0);
    }

    public void clearOtherEmoticonSpan(View view0, EmoticonSpan emoticonSpan0) {
        for(Object object0: this.spanList) {
            EmoticonSpan emoticonSpan1 = (EmoticonSpan)((WeakReference)object0).get();
            if(emoticonSpan1 != null && emoticonSpan1 != emoticonSpan0 && emoticonSpan1.getAttachedView() == view0) {
                emoticonSpan1.stopEmoticonSpan();
            }
        }
    }

    public void detachedEmoticonSpan(View view0) {
        for(Object object0: this.spanList) {
            EmoticonSpan emoticonSpan0 = (EmoticonSpan)((WeakReference)object0).get();
            if(emoticonSpan0 != null && emoticonSpan0.getAttachedView() == view0) {
                emoticonSpan0.clearView();
            }
        }
    }

    public static EmoticonSpanManager getInstance() {
        if(EmoticonSpanManager.instance == null) {
            EmoticonSpanManager.instance = new EmoticonSpanManager();
        }
        return EmoticonSpanManager.instance;
    }

    public boolean isEmoticonTouch(TextView textView0) {
        return textView0 == null || textView0.getMovementMethod() == null || !(textView0.getMovementMethod() instanceof LongClickLinkMovementMethod) ? false : ((LongClickLinkMovementMethod)textView0.getMovementMethod()).isEmoticonTouch();
    }
}

