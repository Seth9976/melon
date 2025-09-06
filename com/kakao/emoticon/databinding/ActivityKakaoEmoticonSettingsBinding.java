package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class ActivityKakaoEmoticonSettingsBinding implements a {
    public final ViewPager container;
    public final View menuLine;
    public final RadioButton radioDownload;
    public final RadioButton radioEdit;
    public final RadioGroup radioMenu;
    private final RelativeLayout rootView;
    public final LayoutCustomBarBinding topBar;

    private ActivityKakaoEmoticonSettingsBinding(RelativeLayout relativeLayout0, ViewPager viewPager0, View view0, RadioButton radioButton0, RadioButton radioButton1, RadioGroup radioGroup0, LayoutCustomBarBinding layoutCustomBarBinding0) {
        this.rootView = relativeLayout0;
        this.container = viewPager0;
        this.menuLine = view0;
        this.radioDownload = radioButton0;
        this.radioEdit = radioButton1;
        this.radioMenu = radioGroup0;
        this.topBar = layoutCustomBarBinding0;
    }

    public static ActivityKakaoEmoticonSettingsBinding bind(View view0) {
        int v = id.container;
        View view1 = view0.findViewById(v);
        if(((ViewPager)view1) != null) {
            v = id.menu_line;
            View view2 = view0.findViewById(v);
            if(view2 != null) {
                v = id.radio_download;
                View view3 = view0.findViewById(v);
                if(((RadioButton)view3) != null) {
                    v = id.radio_edit;
                    View view4 = view0.findViewById(v);
                    if(((RadioButton)view4) != null) {
                        v = id.radio_menu;
                        View view5 = view0.findViewById(v);
                        if(((RadioGroup)view5) != null) {
                            v = id.top_bar;
                            View view6 = view0.findViewById(v);
                            if(view6 != null) {
                                return new ActivityKakaoEmoticonSettingsBinding(((RelativeLayout)view0), ((ViewPager)view1), view2, ((RadioButton)view3), ((RadioButton)view4), ((RadioGroup)view5), LayoutCustomBarBinding.bind(view6));
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

    public static ActivityKakaoEmoticonSettingsBinding inflate(LayoutInflater layoutInflater0) {
        return ActivityKakaoEmoticonSettingsBinding.inflate(layoutInflater0, null, false);
    }

    public static ActivityKakaoEmoticonSettingsBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.activity_kakao_emoticon_settings, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return ActivityKakaoEmoticonSettingsBinding.bind(view0);
    }
}

