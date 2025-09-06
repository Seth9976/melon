package com.kakao.emoticon.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.db.model.EmoticonResource;
import com.kakao.emoticon.net.response.ItemSubType;
import com.kakao.emoticon.ui.widget.EmoticonView;
import com.kakao.emoticon.util.ScreenUtils;

public class GuideView extends FrameLayout {
    static class AnimatorListenerImpl implements Animator.AnimatorListener {
        private AnimatorListenerImpl() {
        }

        public AnimatorListenerImpl(com.kakao.emoticon.ui.GuideView.1 guideView$10) {
        }

        @Override  // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator0) {
        }

        @Override  // android.animation.Animator$AnimatorListener
        public void onAnimationEnd(Animator animator0) {
        }

        @Override  // android.animation.Animator$AnimatorListener
        public void onAnimationRepeat(Animator animator0) {
        }

        @Override  // android.animation.Animator$AnimatorListener
        public void onAnimationStart(Animator animator0) {
        }
    }

    private boolean isProtrait;

    public GuideView(Context context0) {
        this(context0, null);
    }

    public GuideView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public GuideView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public void hideWithAnimation(boolean z) {
        if(!z) {
            this.setVisibility(8);
            return;
        }
        View view0 = this.findViewById(id.background);
        float[] arr_f = {0.0f, ((float)ScreenUtils.INSTANCE.dp2px(300.0f))};
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(view0, View.TRANSLATION_Y, arr_f).setDuration(200L);
        objectAnimator0.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator0.addListener(new AnimatorListenerImpl() {
            {
                GuideView.this = guideView0;
                super(null);
            }

            @Override  // com.kakao.emoticon.ui.GuideView$AnimatorListenerImpl
            public void onAnimationEnd(Animator animator0) {
                GuideView.this.setVisibility(8);
            }
        });
        objectAnimator0.start();
    }

    private void loadEmoticon() {
        EmoticonView emoticonView0 = (EmoticonView)this.findViewById(id.guide_emoticon);
        emoticonView0.setStartAnimationWhenImageLoaded(true);
        emoticonView0.loadEmoticon(EmoticonResource.convertToEmoticonParam(new EmoticonResource("4402790", 6), 1, ItemSubType.ANIMATED_STICKER), null);
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.isInEditMode()) {
            return;
        }
        this.loadEmoticon();
        if(ScreenUtils.INSTANCE.isLandscape()) {
            this.isProtrait = false;
            return;
        }
        this.isProtrait = true;
        this.showWithAnimation();
    }

    public boolean shouldRecreate() {
        return ScreenUtils.INSTANCE.isLandscape() == this.isProtrait;
    }

    private void showWithAnimation() {
        View view0 = this.findViewById(id.text1);
        View view1 = this.findViewById(id.text2);
        View view2 = this.findViewById(id.guide_emoticon);
        View view3 = this.findViewById(id.line);
        View view4 = this.findViewById(id.start);
        view2.setVisibility(4);
        view3.setAlpha(0.0f);
        view4.setAlpha(0.0f);
        float f = (float)ScreenUtils.INSTANCE.dp2px(50.0f);
        float f1 = (float)ScreenUtils.INSTANCE.dp2px(100.0f);
        Property property0 = View.TRANSLATION_X;
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(view0, property0, new float[]{f, 0.0f}).setDuration(600L);
        objectAnimator0.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view1, property0, new float[]{-f, 0.0f}).setDuration(700L);
        objectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        Property property1 = View.ALPHA;
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view0, property1, new float[]{0.0f, 1.0f}).setDuration(600L);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(view1, property1, new float[]{0.0f, 1.0f}).setDuration(700L);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{f1, 0.0f}).setDuration(400L);
        objectAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(view3, property1, new float[]{0.0f, 1.0f}).setDuration(600L);
        objectAnimator5.setStartDelay(300L);
        ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(view4, property1, new float[]{0.0f, 1.0f}).setDuration(600L);
        objectAnimator6.setStartDelay(300L);
        AnimatorSet animatorSet0 = new AnimatorSet();
        animatorSet0.play(objectAnimator5).with(objectAnimator6).after(objectAnimator4);
        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.play(objectAnimator1).with(objectAnimator0).with(objectAnimator2).with(objectAnimator3);
        animatorSet1.start();
        animatorSet1.addListener(new AnimatorListenerImpl(view2, animatorSet0) {
            final View val$emoticonView;
            final AnimatorSet val$latterAnimatorSet;

            {
                GuideView.this = guideView0;
                this.val$emoticonView = view0;
                this.val$latterAnimatorSet = animatorSet0;
                super(null);
            }

            @Override  // com.kakao.emoticon.ui.GuideView$AnimatorListenerImpl
            public void onAnimationEnd(Animator animator0) {
                this.val$emoticonView.setVisibility(0);
                this.val$latterAnimatorSet.start();
            }
        });
    }
}

