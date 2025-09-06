package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.KeyboardDetectorLayout;

public final class KakaoEmoticonEmptyBinding implements a {
    public final FrameLayout contentsLayout;
    public final FrameLayout emoticonLayout;
    public final KeyboardDetectorLayout keyboardDetectorLayout;
    private final RelativeLayout rootView;

    private KakaoEmoticonEmptyBinding(RelativeLayout relativeLayout0, FrameLayout frameLayout0, FrameLayout frameLayout1, KeyboardDetectorLayout keyboardDetectorLayout0) {
        this.rootView = relativeLayout0;
        this.contentsLayout = frameLayout0;
        this.emoticonLayout = frameLayout1;
        this.keyboardDetectorLayout = keyboardDetectorLayout0;
    }

    public static KakaoEmoticonEmptyBinding bind(View view0) {
        int v = id.contents_layout;
        FrameLayout frameLayout0 = (FrameLayout)view0.findViewById(v);
        if(frameLayout0 != null) {
            v = id.emoticon_layout;
            FrameLayout frameLayout1 = (FrameLayout)view0.findViewById(v);
            if(frameLayout1 != null) {
                v = id.keyboard_detector_layout;
                KeyboardDetectorLayout keyboardDetectorLayout0 = (KeyboardDetectorLayout)view0.findViewById(v);
                if(keyboardDetectorLayout0 != null) {
                    return new KakaoEmoticonEmptyBinding(((RelativeLayout)view0), frameLayout0, frameLayout1, keyboardDetectorLayout0);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static KakaoEmoticonEmptyBinding inflate(LayoutInflater layoutInflater0) {
        return KakaoEmoticonEmptyBinding.inflate(layoutInflater0, null, false);
    }

    public static KakaoEmoticonEmptyBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.kakao_emoticon_empty, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return KakaoEmoticonEmptyBinding.bind(view0);
    }
}

