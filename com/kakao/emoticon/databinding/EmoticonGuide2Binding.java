package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.GuideView;
import com.kakao.emoticon.ui.widget.EmoticonView;

public final class EmoticonGuide2Binding implements a {
    public final RelativeLayout background;
    public final EmoticonView guideEmoticon;
    public final View line;
    private final GuideView rootView;
    public final TextView start;
    public final TextView text1;
    public final TextView text2;

    private EmoticonGuide2Binding(GuideView guideView0, RelativeLayout relativeLayout0, EmoticonView emoticonView0, View view0, TextView textView0, TextView textView1, TextView textView2) {
        this.rootView = guideView0;
        this.background = relativeLayout0;
        this.guideEmoticon = emoticonView0;
        this.line = view0;
        this.start = textView0;
        this.text1 = textView1;
        this.text2 = textView2;
    }

    public static EmoticonGuide2Binding bind(View view0) {
        int v = id.background;
        View view1 = view0.findViewById(v);
        if(((RelativeLayout)view1) != null) {
            v = id.guide_emoticon;
            View view2 = view0.findViewById(v);
            if(((EmoticonView)view2) != null) {
                v = id.line;
                View view3 = view0.findViewById(v);
                if(view3 != null) {
                    v = id.start;
                    View view4 = view0.findViewById(v);
                    if(((TextView)view4) != null) {
                        v = id.text1;
                        View view5 = view0.findViewById(v);
                        if(((TextView)view5) != null) {
                            v = id.text2;
                            View view6 = view0.findViewById(v);
                            if(((TextView)view6) != null) {
                                return new EmoticonGuide2Binding(((GuideView)view0), ((RelativeLayout)view1), ((EmoticonView)view2), view3, ((TextView)view4), ((TextView)view5), ((TextView)view6));
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

    public GuideView getRoot() {
        return this.rootView;
    }

    public static EmoticonGuide2Binding inflate(LayoutInflater layoutInflater0) {
        return EmoticonGuide2Binding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonGuide2Binding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_guide_2, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonGuide2Binding.bind(view0);
    }
}

