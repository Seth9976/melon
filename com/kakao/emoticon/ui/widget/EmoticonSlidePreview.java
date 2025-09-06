package com.kakao.emoticon.ui.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.ui.a;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.util.ScreenUtils;

public class EmoticonSlidePreview {
    private static final int SLIDE_FULL_MARGIN = 0xFFFFFF71;
    private static final int SLIDE_HALF_MARGIN = -80;
    private EmoticonView emoticonAniView;
    private EmoticonPreview emoticonPortView;
    private View emoticonRootPreview;
    private EmoticonView emoticonThumbView;
    private final LayoutInflater inflater;
    private boolean isKeyboardMode;
    private RelativeLayout keyboardModeLayout;
    private final Context mContext;
    private RelativeLayout previewLayout;
    private RelativeLayout previewModeLayout;
    private AnimatorSet slideFullDown;
    private AnimatorSet slideFullUp;
    private AnimatorSet slideHalfDown;
    private AnimatorSet slideHalfToFullDown;
    private AnimatorSet slideHalfUp;
    private final WindowManager.LayoutParams windowLayoutParams;
    private final WindowManager wm;

    public EmoticonSlidePreview(Context context0) {
        this.mContext = context0;
        WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams(-2, -2, 2, 8, -3);
        this.windowLayoutParams = windowManager$LayoutParams0;
        windowManager$LayoutParams0.gravity = 0x30;
        this.wm = (WindowManager)context0.getSystemService("window");
        this.inflater = (LayoutInflater)context0.getSystemService("layout_inflater");
        a a0 = new a(this, 6);
        ValueAnimator valueAnimator0 = ValueAnimator.ofInt(new int[]{ScreenUtils.INSTANCE.dp2px(-143.0f), 0}).setDuration(0L);
        ValueAnimator valueAnimator1 = ValueAnimator.ofInt(new int[]{0, ScreenUtils.INSTANCE.dp2px(-143.0f)}).setDuration(0L);
        ValueAnimator valueAnimator2 = ValueAnimator.ofInt(new int[]{ScreenUtils.INSTANCE.dp2px(-80.0f), ScreenUtils.INSTANCE.dp2px(-143.0f)}).setDuration(0L);
        ValueAnimator valueAnimator3 = ValueAnimator.ofInt(new int[]{0, ScreenUtils.INSTANCE.dp2px(-80.0f)}).setDuration(200L);
        ValueAnimator valueAnimator4 = ValueAnimator.ofInt(new int[]{ScreenUtils.INSTANCE.dp2px(-80.0f), 0}).setDuration(200L);
        valueAnimator0.addUpdateListener(a0);
        valueAnimator1.addUpdateListener(a0);
        valueAnimator2.addUpdateListener(a0);
        valueAnimator3.addUpdateListener(a0);
        valueAnimator4.addUpdateListener(a0);
        AnimatorSet animatorSet0 = new AnimatorSet();
        this.slideFullDown = animatorSet0;
        animatorSet0.play(valueAnimator0);
        this.slideFullDown.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet1 = new AnimatorSet();
        this.slideFullUp = animatorSet1;
        animatorSet1.play(valueAnimator1);
        this.slideFullUp.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.slideHalfUp = animatorSet2;
        animatorSet2.play(valueAnimator2);
        this.slideHalfUp.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.slideHalfDown = animatorSet3;
        animatorSet3.play(valueAnimator3);
        this.slideHalfDown.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.slideHalfToFullDown = animatorSet4;
        animatorSet4.play(valueAnimator4);
        this.slideHalfToFullDown.setInterpolator(new AccelerateDecelerateInterpolator());
        com.kakao.emoticon.ui.widget.EmoticonSlidePreview.1 emoticonSlidePreview$10 = new Animator.AnimatorListener() {
            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationCancel(Animator animator0) {
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationEnd(Animator animator0) {
                if(valueAnimator2 != animator0 && animator0 != valueAnimator1) {
                    return;
                }
                WindowManager windowManager0 = (WindowManager)EmoticonSlidePreview.access$200(EmoticonSlidePreview.this).getSystemService("window");
                if(windowManager0 != null && EmoticonSlidePreview.access$300(EmoticonSlidePreview.this) != null) {
                    windowManager0.removeView(EmoticonSlidePreview.access$300(EmoticonSlidePreview.this));
                }
                EmoticonSlidePreview.access$302(EmoticonSlidePreview.this, null);
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationRepeat(Animator animator0) {
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationStart(Animator animator0) {
                if(valueAnimator3 == animator0) {
                    EmoticonSlidePreview.this.previewModeLayout.setVisibility(8);
                    EmoticonSlidePreview.this.keyboardModeLayout.setVisibility(0);
                }
                if(animator0 == valueAnimator4) {
                    EmoticonSlidePreview.this.keyboardModeLayout.setVisibility(8);
                    EmoticonSlidePreview.this.previewModeLayout.setVisibility(0);
                }
            }
        };
        valueAnimator2.addListener(emoticonSlidePreview$10);
        valueAnimator1.addListener(emoticonSlidePreview$10);
        valueAnimator3.addListener(emoticonSlidePreview$10);
        valueAnimator4.addListener(emoticonSlidePreview$10);
    }

    public static void a(EmoticonSlidePreview emoticonSlidePreview0, ValueAnimator valueAnimator0) {
        emoticonSlidePreview0.lambda$new$0(valueAnimator0);
    }

    public static Context access$200(EmoticonSlidePreview emoticonSlidePreview0) {
        return emoticonSlidePreview0.mContext;
    }

    public static View access$300(EmoticonSlidePreview emoticonSlidePreview0) {
        return emoticonSlidePreview0.emoticonRootPreview;
    }

    public static View access$302(EmoticonSlidePreview emoticonSlidePreview0, View view0) {
        emoticonSlidePreview0.emoticonRootPreview = view0;
        return view0;
    }

    public void hidePreview() {
        if(this.emoticonPortView.getVisibility() == 0) {
            this.emoticonPortView.hidePreview();
        }
        if(this.emoticonRootPreview != null) {
            if(this.isKeyboardMode) {
                this.slideHalfUp.start();
            }
            else {
                this.slideFullUp.start();
            }
            this.isKeyboardMode = false;
        }
    }

    public boolean isShown() {
        ScreenUtils screenUtils0 = ScreenUtils.INSTANCE;
        if(screenUtils0.isPortrait()) {
            EmoticonPreview emoticonPreview0 = this.emoticonPortView;
            if(emoticonPreview0 != null) {
                return emoticonPreview0.isShown();
            }
        }
        if(screenUtils0.isLandscape()) {
            return this.previewLayout == null ? false : this.previewLayout.isShown();
        }
        return false;
    }

    private void lambda$new$0(ValueAnimator valueAnimator0) {
        this.updatePreviewLayout(valueAnimator0);
    }

    private void lambda$showPreview$1(View view0) {
        this.hidePreview();
    }

    private void lambda$showPreview$2(View view0) {
        this.hidePreview();
    }

    public void onConfigurationChanged(EmoticonViewParam emoticonViewParam0) {
        if(ScreenUtils.INSTANCE.isLandscape()) {
            if(this.emoticonPortView.getVisibility() == 0) {
                this.emoticonPortView.hidePreview();
                if(emoticonViewParam0 != null) {
                    this.showPreview(emoticonViewParam0);
                }
            }
        }
        else if(this.emoticonRootPreview != null) {
            this.hidePreview();
            if(emoticonViewParam0 != null) {
                this.emoticonPortView.showPreview(emoticonViewParam0, null);
            }
        }
    }

    public void setPortraitPreview(EmoticonPreview emoticonPreview0) {
        this.emoticonPortView = emoticonPreview0;
    }

    public void showFullPreview() {
        if(this.emoticonRootPreview == null) {
            return;
        }
        if(this.isKeyboardMode) {
            this.slideHalfToFullDown.start();
        }
        this.isKeyboardMode = false;
    }

    public void showKeyboardPreview() {
        if(this.emoticonRootPreview == null) {
            return;
        }
        if(!this.isKeyboardMode) {
            this.slideHalfDown.start();
        }
        this.isKeyboardMode = true;
    }

    public void showPreview(EmoticonViewParam emoticonViewParam0) {
        if(!ScreenUtils.INSTANCE.isLandscape()) {
            this.emoticonPortView.showPreview(emoticonViewParam0, null);
            return;
        }
        if(this.emoticonRootPreview == null) {
            View view0 = this.inflater.inflate(layout.layout_emoticon_window, null);
            this.emoticonRootPreview = view0;
            EmoticonView emoticonView0 = (EmoticonView)view0.findViewById(id.emoticon_toast_view);
            this.emoticonAniView = emoticonView0;
            emoticonView0.enableAutoSoundPlay(true);
            this.emoticonThumbView = (EmoticonView)this.emoticonRootPreview.findViewById(id.emoticon_keyboard_thumb);
            this.previewLayout = (RelativeLayout)this.emoticonRootPreview.findViewById(id.preview_layout);
            this.previewModeLayout = (RelativeLayout)this.emoticonRootPreview.findViewById(id.preview_mode);
            this.keyboardModeLayout = (RelativeLayout)this.emoticonRootPreview.findViewById(id.keyboard_mode);
            this.emoticonRootPreview.findViewById(id.btn_close_keyboad).setOnClickListener(new com.kakao.emoticon.ui.widget.a(this, 0));
            ((Button)this.emoticonRootPreview.findViewById(id.btn_close)).setOnClickListener(new com.kakao.emoticon.ui.widget.a(this, 1));
            this.wm.addView(this.emoticonRootPreview, this.windowLayoutParams);
            this.slideFullDown.start();
            this.isKeyboardMode = false;
        }
        this.emoticonAniView.loadEmoticon(emoticonViewParam0, null);
        this.emoticonThumbView.loadThumbnail(emoticonViewParam0, null);
    }

    private void updatePreviewLayout(ValueAnimator valueAnimator0) {
        ((ViewGroup.MarginLayoutParams)this.previewLayout.getLayoutParams()).topMargin = (int)(((Integer)valueAnimator0.getAnimatedValue()));
        this.previewLayout.requestLayout();
    }
}

