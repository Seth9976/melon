package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class EmoticonBannerItemBinding implements a {
    public final ImageView emoticonBanner;
    private final RelativeLayout rootView;

    private EmoticonBannerItemBinding(RelativeLayout relativeLayout0, ImageView imageView0) {
        this.rootView = relativeLayout0;
        this.emoticonBanner = imageView0;
    }

    public static EmoticonBannerItemBinding bind(View view0) {
        ImageView imageView0 = (ImageView)view0.findViewById(id.emoticon_banner);
        if(imageView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0415));  // id:emoticon_banner
        }
        return new EmoticonBannerItemBinding(((RelativeLayout)view0), imageView0);
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EmoticonBannerItemBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonBannerItemBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonBannerItemBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_banner_item, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonBannerItemBinding.bind(view0);
    }
}

