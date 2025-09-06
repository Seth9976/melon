package com.kakaoent.leonplayer.databinding;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kakaoent.leonplayer.R.id;
import com.kakaoent.leonplayer.R.layout;

public final class LayoutLeonPlayerBinding implements a {
    public final ImageView imagePoster;
    public final FrameLayout layoutPlayer;
    private final FrameLayout rootView;
    public final SurfaceView surfaceView;

    private LayoutLeonPlayerBinding(FrameLayout frameLayout0, ImageView imageView0, FrameLayout frameLayout1, SurfaceView surfaceView0) {
        this.rootView = frameLayout0;
        this.imagePoster = imageView0;
        this.layoutPlayer = frameLayout1;
        this.surfaceView = surfaceView0;
    }

    public static LayoutLeonPlayerBinding bind(View view0) {
        int v = id.image_poster;
        ImageView imageView0 = (ImageView)I.C(view0, v);
        if(imageView0 != null) {
            SurfaceView surfaceView0 = (SurfaceView)I.C(view0, id.surfaceView);
            if(surfaceView0 != null) {
                return new LayoutLeonPlayerBinding(((FrameLayout)view0), imageView0, ((FrameLayout)view0), surfaceView0);
            }
            v = 0x7F0A0B08;  // id:surfaceView
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutLeonPlayerBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutLeonPlayerBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutLeonPlayerBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_leon_player, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutLeonPlayerBinding.bind(view0);
    }
}

