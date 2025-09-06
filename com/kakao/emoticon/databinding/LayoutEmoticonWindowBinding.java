package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.widget.EmoticonView;

public final class LayoutEmoticonWindowBinding implements a {
    public final Button btnClose;
    public final Button btnCloseKeyboad;
    public final EmoticonView emoticonKeyboardThumb;
    public final EmoticonView emoticonToastView;
    public final RelativeLayout keyboardMode;
    public final RelativeLayout previewLayout;
    public final RelativeLayout previewMode;
    private final RelativeLayout rootView;

    private LayoutEmoticonWindowBinding(RelativeLayout relativeLayout0, Button button0, Button button1, EmoticonView emoticonView0, EmoticonView emoticonView1, RelativeLayout relativeLayout1, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout0;
        this.btnClose = button0;
        this.btnCloseKeyboad = button1;
        this.emoticonKeyboardThumb = emoticonView0;
        this.emoticonToastView = emoticonView1;
        this.keyboardMode = relativeLayout1;
        this.previewLayout = relativeLayout2;
        this.previewMode = relativeLayout3;
    }

    public static LayoutEmoticonWindowBinding bind(View view0) {
        int v = id.btn_close;
        View view1 = view0.findViewById(v);
        if(((Button)view1) != null) {
            v = id.btn_close_keyboad;
            View view2 = view0.findViewById(v);
            if(((Button)view2) != null) {
                v = id.emoticon_keyboard_thumb;
                View view3 = view0.findViewById(v);
                if(((EmoticonView)view3) != null) {
                    v = id.emoticon_toast_view;
                    View view4 = view0.findViewById(v);
                    if(((EmoticonView)view4) != null) {
                        v = id.keyboard_mode;
                        View view5 = view0.findViewById(v);
                        if(((RelativeLayout)view5) != null) {
                            v = id.preview_layout;
                            View view6 = view0.findViewById(v);
                            if(((RelativeLayout)view6) != null) {
                                v = id.preview_mode;
                                View view7 = view0.findViewById(v);
                                if(((RelativeLayout)view7) != null) {
                                    return new LayoutEmoticonWindowBinding(((RelativeLayout)view0), ((Button)view1), ((Button)view2), ((EmoticonView)view3), ((EmoticonView)view4), ((RelativeLayout)view5), ((RelativeLayout)view6), ((RelativeLayout)view7));
                                }
                            }
                        }
                    }
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

    public static LayoutEmoticonWindowBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutEmoticonWindowBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutEmoticonWindowBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_emoticon_window, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutEmoticonWindowBinding.bind(view0);
    }
}

