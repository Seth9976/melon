package com.kakao.emoticon.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kakao.emoticon.controller.EmoticonSectionViewController.ViewEventListener;

public class EmoticonSectionView extends FrameLayout {
    private ViewEventListener viewEventListener;

    public EmoticonSectionView(Context context0) {
        super(context0);
    }

    public EmoticonSectionView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public EmoticonSectionView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewEventListener emoticonSectionViewController$ViewEventListener0 = this.viewEventListener;
        if(emoticonSectionViewController$ViewEventListener0 != null) {
            emoticonSectionViewController$ViewEventListener0.onRootViewAttached();
        }
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        ViewEventListener emoticonSectionViewController$ViewEventListener0 = this.viewEventListener;
        if(emoticonSectionViewController$ViewEventListener0 != null) {
            emoticonSectionViewController$ViewEventListener0.onRootViewDetached();
        }
        super.onDetachedFromWindow();
    }

    @Override  // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ViewEventListener emoticonSectionViewController$ViewEventListener0 = this.viewEventListener;
        if(emoticonSectionViewController$ViewEventListener0 != null) {
            emoticonSectionViewController$ViewEventListener0.onWindowFocusChanged(z);
        }
    }

    public void setViewEventListener(ViewEventListener emoticonSectionViewController$ViewEventListener0) {
        this.viewEventListener = emoticonSectionViewController$ViewEventListener0;
    }
}

