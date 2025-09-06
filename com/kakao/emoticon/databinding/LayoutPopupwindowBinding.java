package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.kakao.emoticon.R.layout;

public final class LayoutPopupwindowBinding implements a {
    private final LinearLayout rootView;

    private LayoutPopupwindowBinding(LinearLayout linearLayout0) {
        this.rootView = linearLayout0;
    }

    public static LayoutPopupwindowBinding bind(View view0) {
        if(view0 == null) {
            throw new NullPointerException("rootView");
        }
        return new LayoutPopupwindowBinding(((LinearLayout)view0));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPopupwindowBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutPopupwindowBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutPopupwindowBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_popupwindow, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutPopupwindowBinding.bind(view0);
    }
}

