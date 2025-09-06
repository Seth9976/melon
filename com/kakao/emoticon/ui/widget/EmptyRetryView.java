package com.kakao.emoticon.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.appevents.c;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.kakao.emoticon.R.anim;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.controller.EmoticonSectionViewController.ViewEventListener;

public class EmptyRetryView extends FrameLayout {
    private ImageView loadingImage;
    private View reloadBtn;
    private ViewEventListener viewEventListener;

    public EmptyRetryView(Context context0) {
        super(context0);
    }

    public EmptyRetryView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public static void a(EmptyRetryView emptyRetryView0, View view0) {
        emptyRetryView0.lambda$setReloadButton$1(view0);
    }

    public static void b(EmptyRetryView emptyRetryView0) {
        emptyRetryView0.lambda$setVisibility$0();
    }

    public void inflate() {
        this.removeAllViews();
        View.inflate(this.getContext(), layout.layout_sectionview_empty, this);
    }

    private void lambda$setReloadButton$1(View view0) {
        this.findViewById(id.iv_reload).setBackgroundResource(drawable.loading_smile);
        ImageView imageView0 = (ImageView)this.findViewById(id.loading_image);
        this.loadingImage = imageView0;
        imageView0.setVisibility(0);
        Animation animation0 = AnimationUtils.loadAnimation(this.getContext(), anim.loading_reload_anim);
        this.loadingImage.startAnimation(animation0);
        ViewEventListener emoticonSectionViewController$ViewEventListener0 = this.viewEventListener;
        if(emoticonSectionViewController$ViewEventListener0 != null) {
            emoticonSectionViewController$ViewEventListener0.onReloadClicked();
        }
    }

    private void lambda$setVisibility$0() {
        this.findViewById(id.iv_reload).setBackgroundResource(drawable.btn_reload);
        this.loadingImage.clearAnimation();
        this.loadingImage.setVisibility(8);
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.inflate();
    }

    public void setReloadButton() {
        View view0 = this.findViewById(id.btn_reload);
        this.reloadBtn = view0;
        if(view0 != null) {
            view0.setOnClickListener(new p(this, 11));
        }
    }

    public void setViewEventListener(ViewEventListener emoticonSectionViewController$ViewEventListener0) {
        this.viewEventListener = emoticonSectionViewController$ViewEventListener0;
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        if(v == 0) {
            if(this.loadingImage != null && this.loadingImage.getVisibility() == 0) {
                this.postDelayed(new c(this, 22), 2000L);
                return;
            }
            if(this.reloadBtn != null) {
                this.findViewById(id.iv_reload).setBackgroundResource(drawable.btn_reload);
            }
        }
        else if(v == 8) {
            ImageView imageView0 = this.loadingImage;
            if(imageView0 != null) {
                imageView0.clearAnimation();
                this.loadingImage.setVisibility(8);
            }
        }
        else if(this.reloadBtn != null) {
            this.findViewById(id.iv_reload).setBackgroundResource(drawable.btn_reload);
        }
    }
}

