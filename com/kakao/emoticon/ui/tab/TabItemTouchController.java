package com.kakao.emoticon.ui.tab;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.kakao.emoticon.R.color;
import com.kakao.emoticon.R.dimen;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.util.ActionTracker;

public class TabItemTouchController implements TabItemTouchListener {
    private View contentDimView;
    private final Context context;
    private AnimatorSet expandTrashAniSet;
    private boolean isExpanded;
    private boolean isShowMenu;
    private boolean isShowTrashAniEnd;
    private AnimatorSet reduceTrashAniSet;
    private final ViewGroup rootView;
    private AnimatorSet showTrashAniSet;
    private View tabTrashView;
    private View trashBtn;

    public TabItemTouchController(Context context0, ViewGroup viewGroup0) {
        this.context = context0;
        this.rootView = viewGroup0;
    }

    private void lambda$onItemSelected$0(ValueAnimator valueAnimator0) {
        Integer integer0 = (Integer)valueAnimator0.getAnimatedValue();
        this.trashBtn.getLayoutParams().width = (int)integer0;
        this.trashBtn.getLayoutParams().height = (int)integer0;
        this.trashBtn.requestLayout();
    }

    private void lambda$onTrashHover$1(ValueAnimator valueAnimator0) {
        GradientDrawable gradientDrawable0 = new GradientDrawable();
        gradientDrawable0.setCornerRadius(((float)this.context.getResources().getDimensionPixelSize(dimen.emoticon_tab_trash_corner)));
        gradientDrawable0.setColor(((int)(((Integer)valueAnimator0.getAnimatedValue()))));
        this.trashBtn.setBackground(gradientDrawable0);
    }

    private void lambda$onTrashHover$2(ValueAnimator valueAnimator0) {
        GradientDrawable gradientDrawable0 = new GradientDrawable();
        gradientDrawable0.setCornerRadius(((float)this.context.getResources().getDimensionPixelSize(dimen.emoticon_tab_trash_corner)));
        gradientDrawable0.setColor(((int)(((Integer)valueAnimator0.getAnimatedValue()))));
        this.trashBtn.setBackground(gradientDrawable0);
    }

    @Override  // com.kakao.emoticon.ui.tab.TabItemTouchListener
    public void onItemClear() {
        this.isShowMenu = false;
        View view0 = this.contentDimView;
        if(view0 != null) {
            view0.setVisibility(8);
        }
        if(this.tabTrashView != null && this.tabTrashView.getParent() != null) {
            ((ViewGroup)this.tabTrashView.getParent()).removeView(this.tabTrashView);
        }
        this.tabTrashView = null;
    }

    @Override  // com.kakao.emoticon.ui.tab.TabItemTouchListener
    public boolean onItemSelected() {
        this.isShowMenu = true;
        this.isExpanded = false;
        if(this.tabTrashView == null) {
            View view0 = LayoutInflater.from(this.context).inflate(layout.layout_tab_menu, null);
            this.tabTrashView = view0;
            this.trashBtn = view0.findViewById(id.rl_emoticon_tab_trash);
            ValueAnimator valueAnimator0 = ValueAnimator.ofInt(new int[]{((int)this.context.getResources().getDimension(dimen.emoticon_tab_trash_start)), ((int)this.context.getResources().getDimension(dimen.emoticon_tab_trash_default))}).setDuration(200L);
            valueAnimator0.addUpdateListener(new c(this, 2));
            AnimatorSet animatorSet0 = new AnimatorSet();
            this.showTrashAniSet = animatorSet0;
            animatorSet0.playTogether(new Animator[]{valueAnimator0});
            this.showTrashAniSet.setInterpolator(new OvershootInterpolator());
            this.showTrashAniSet.addListener(new Animator.AnimatorListener() {
                @Override  // android.animation.Animator$AnimatorListener
                public void onAnimationCancel(Animator animator0) {
                    TabItemTouchController.this.isShowTrashAniEnd = false;
                }

                @Override  // android.animation.Animator$AnimatorListener
                public void onAnimationEnd(Animator animator0) {
                    TabItemTouchController.this.isShowTrashAniEnd = true;
                }

                @Override  // android.animation.Animator$AnimatorListener
                public void onAnimationRepeat(Animator animator0) {
                }

                @Override  // android.animation.Animator$AnimatorListener
                public void onAnimationStart(Animator animator0) {
                    TabItemTouchController.this.isShowTrashAniEnd = false;
                }
            });
        }
        AnimatorSet animatorSet1 = this.showTrashAniSet;
        if(animatorSet1 != null) {
            animatorSet1.cancel();
        }
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(((int)this.context.getResources().getDimension(dimen.emoticon_tab_trash_area)), ((int)this.context.getResources().getDimension(dimen.emoticon_tab_trash_area)));
        frameLayout$LayoutParams0.topMargin = (this.rootView.getHeight() - this.context.getResources().getDimensionPixelSize(dimen.emoticon_tab_trash_default)) / 2;
        frameLayout$LayoutParams0.gravity = 1;
        try {
            if(this.tabTrashView.getParent() != null) {
                ((ViewGroup)this.tabTrashView.getParent()).removeView(this.tabTrashView);
            }
            this.rootView.addView(this.tabTrashView, 3, frameLayout$LayoutParams0);
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return false;
        }
        this.showTrashAniSet.start();
        View view1 = this.rootView.findViewById(id.v_content_dim);
        this.contentDimView = view1;
        view1.setVisibility(0);
        ActionTracker.pushLog("A001", "12", null);
        return true;
    }

    @Override  // com.kakao.emoticon.ui.tab.TabItemTouchListener
    public void onTrashHover(boolean z) {
        if(this.isShowMenu && this.isShowTrashAniEnd) {
            if(z && !this.isExpanded) {
                this.isExpanded = true;
                AnimatorSet animatorSet0 = this.expandTrashAniSet;
                if(animatorSet0 == null) {
                    int v = P1.c.getColor(this.context, color.emoticon_tab_trash_n);
                    int v1 = P1.c.getColor(this.context, color.emoticon_tab_trash_p);
                    ValueAnimator valueAnimator0 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{v, v1});
                    valueAnimator0.setDuration(100L);
                    valueAnimator0.addUpdateListener(new c(this, 0));
                    AnimatorSet animatorSet1 = new AnimatorSet();
                    this.expandTrashAniSet = animatorSet1;
                    animatorSet1.playTogether(new Animator[]{valueAnimator0});
                    this.expandTrashAniSet.setInterpolator(new LinearInterpolator());
                }
                else {
                    animatorSet0.cancel();
                }
                this.expandTrashAniSet.start();
                return;
            }
            if(!z && this.isExpanded) {
                this.isExpanded = false;
                AnimatorSet animatorSet2 = this.reduceTrashAniSet;
                if(animatorSet2 == null) {
                    int v2 = P1.c.getColor(this.context, color.emoticon_tab_trash_p);
                    int v3 = P1.c.getColor(this.context, color.emoticon_tab_trash_n);
                    ValueAnimator valueAnimator1 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{v2, v3});
                    valueAnimator1.setDuration(100L);
                    valueAnimator1.addUpdateListener(new c(this, 1));
                    AnimatorSet animatorSet3 = new AnimatorSet();
                    this.reduceTrashAniSet = animatorSet3;
                    animatorSet3.playTogether(new Animator[]{valueAnimator1});
                    this.reduceTrashAniSet.setInterpolator(new LinearInterpolator());
                }
                else {
                    animatorSet2.cancel();
                }
                this.reduceTrashAniSet.start();
            }
        }
    }
}

