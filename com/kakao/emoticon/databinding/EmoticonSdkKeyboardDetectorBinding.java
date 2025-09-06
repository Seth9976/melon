package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.KeyboardDetectorLayout;

public final class EmoticonSdkKeyboardDetectorBinding implements a {
    private final KeyboardDetectorLayout rootView;

    private EmoticonSdkKeyboardDetectorBinding(KeyboardDetectorLayout keyboardDetectorLayout0) {
        this.rootView = keyboardDetectorLayout0;
    }

    public static EmoticonSdkKeyboardDetectorBinding bind(View view0) {
        if(view0 == null) {
            throw new NullPointerException("rootView");
        }
        return new EmoticonSdkKeyboardDetectorBinding(((KeyboardDetectorLayout)view0));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public KeyboardDetectorLayout getRoot() {
        return this.rootView;
    }

    public static EmoticonSdkKeyboardDetectorBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonSdkKeyboardDetectorBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonSdkKeyboardDetectorBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_sdk_keyboard_detector, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonSdkKeyboardDetectorBinding.bind(view0);
    }
}

