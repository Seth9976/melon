package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.widget.EmoticonView;

public final class LayoutEmoticonPreviewBinding implements a {
    public final ImageButton btnPreviewClose;
    public final EmoticonView emoticonView;
    private final RelativeLayout rootView;

    private LayoutEmoticonPreviewBinding(RelativeLayout relativeLayout0, ImageButton imageButton0, EmoticonView emoticonView0) {
        this.rootView = relativeLayout0;
        this.btnPreviewClose = imageButton0;
        this.emoticonView = emoticonView0;
    }

    public static LayoutEmoticonPreviewBinding bind(View view0) {
        int v = id.btn_preview_close;
        ImageButton imageButton0 = (ImageButton)view0.findViewById(v);
        if(imageButton0 != null) {
            v = id.emoticon_view;
            EmoticonView emoticonView0 = (EmoticonView)view0.findViewById(v);
            if(emoticonView0 != null) {
                return new LayoutEmoticonPreviewBinding(((RelativeLayout)view0), imageButton0, emoticonView0);
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

    public static LayoutEmoticonPreviewBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutEmoticonPreviewBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutEmoticonPreviewBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_emoticon_preview, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutEmoticonPreviewBinding.bind(view0);
    }
}

