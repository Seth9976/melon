package com.iloen.melon.player.video.cheer;

import H0.e;
import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import androidx.fragment.app.I;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.OutlineTextView;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001A\u00020\u000B¢\u0006\u0004\b\u0012\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/player/video/cheer/CheerAnimationManager;", "", "Lcom/airbnb/lottie/LottieAnimationView;", "heartAnimView", "explodeAnimView", "Lcom/iloen/melon/custom/OutlineTextView;", "cntTvAnimView", "Landroidx/fragment/app/I;", "fragment", "<init>", "(Lcom/airbnb/lottie/LottieAnimationView;Lcom/airbnb/lottie/LottieAnimationView;Lcom/iloen/melon/custom/OutlineTextView;Landroidx/fragment/app/I;)V", "Lie/H;", "startHeartAnim", "()V", "Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;", "cheerAnimCnt", "startCountAnim", "(Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;)V", "clear", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CheerAnimationManager {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/cheer/CheerAnimationManager$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final LottieAnimationView a;
    public final LottieAnimationView b;
    public final OutlineTextView c;
    public final I d;
    public final AnimatorSet e;

    static {
        CheerAnimationManager.Companion = new Companion(null);
        CheerAnimationManager.$stable = 8;
    }

    public CheerAnimationManager(@NotNull LottieAnimationView lottieAnimationView0, @NotNull LottieAnimationView lottieAnimationView1, @NotNull OutlineTextView outlineTextView0, @NotNull I i0) {
        q.g(lottieAnimationView0, "heartAnimView");
        q.g(lottieAnimationView1, "explodeAnimView");
        q.g(outlineTextView0, "cntTvAnimView");
        q.g(i0, "fragment");
        super();
        this.a = lottieAnimationView0;
        this.b = lottieAnimationView1;
        this.c = outlineTextView0;
        this.d = i0;
        LogU logU0 = new LogU("CheerAnimationManager");
        com.iloen.melon.player.video.cheer.CheerAnimationManager.explodeAnimListener.1 cheerAnimationManager$explodeAnimListener$10 = new Animator.AnimatorListener() {
            public final CheerAnimationManager a;

            {
                this.a = cheerAnimationManager0;
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationCancel(Animator animator0) {
                q.g(animator0, "animation");
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationEnd(Animator animator0) {
                q.g(animator0, "animation");
                CheerAnimationManager cheerAnimationManager0 = this.a;
                if(!e.N(CheerAnimationManager.access$getFragment$p(cheerAnimationManager0))) {
                    return;
                }
                CheerAnimationManager.access$getExplodeAnimView$p(cheerAnimationManager0).setVisibility(8);
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationRepeat(Animator animator0) {
                q.g(animator0, "animation");
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationStart(Animator animator0) {
                q.g(animator0, "animation");
            }
        };
        com.iloen.melon.player.video.cheer.CheerAnimationManager.cntAnimListener.1 cheerAnimationManager$cntAnimListener$10 = new Animator.AnimatorListener() {
            public final CheerAnimationManager a;

            {
                this.a = cheerAnimationManager0;
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationCancel(Animator animator0) {
                q.g(animator0, "animator");
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationEnd(Animator animator0) {
                q.g(animator0, "animator");
                CheerAnimationManager cheerAnimationManager0 = this.a;
                if(!e.N(CheerAnimationManager.access$getFragment$p(cheerAnimationManager0))) {
                    return;
                }
                CheerAnimationManager.access$getCntTvAnimView$p(cheerAnimationManager0).setText("");
                CheerAnimationManager.access$getCntTvAnimView$p(cheerAnimationManager0).setVisibility(8);
                CheerAnimationManager.access$getExplodeAnimView$p(cheerAnimationManager0).playAnimation();
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationRepeat(Animator animator0) {
                q.g(animator0, "animator");
            }

            @Override  // android.animation.Animator$AnimatorListener
            public void onAnimationStart(Animator animator0) {
                q.g(animator0, "animator");
            }
        };
        AnimatorSet animatorSet0 = new AnimatorSet();
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(outlineTextView0, "translationY", new float[]{((float)ViewUtilsKt.dpToPx(-11.0f))});
        objectAnimator0.setDuration(300L);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(outlineTextView0, "scaleX", new float[]{0.0f, 1.0f});
        objectAnimator1.setDuration(300L);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(outlineTextView0, "scaleY", new float[]{0.0f, 1.0f});
        objectAnimator2.setDuration(300L);
        animatorSet0.playTogether(new Animator[]{objectAnimator0, objectAnimator1, objectAnimator2});
        AnimatorSet animatorSet1 = new AnimatorSet();
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(outlineTextView0, "scaleX", new float[]{1.0f, 1.3f});
        objectAnimator3.setDuration(300L);
        objectAnimator3.setRepeatMode(2);
        objectAnimator3.setRepeatCount(5);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(outlineTextView0, "scaleY", new float[]{1.0f, 1.3f});
        objectAnimator4.setDuration(300L);
        objectAnimator4.setRepeatMode(2);
        objectAnimator4.setRepeatCount(5);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{objectAnimator3, objectAnimator4});
        animatorSet1.addListener(cheerAnimationManager$cntAnimListener$10);
        animatorSet1.play(animatorSet2).after(animatorSet0);
        this.e = animatorSet1;
        LogU.debug$default(logU0, "init()", null, false, 6, null);
        lottieAnimationView1.setCropToPadding(false);
        lottieAnimationView1.addAnimatorListener(cheerAnimationManager$explodeAnimListener$10);
    }

    public static final OutlineTextView access$getCntTvAnimView$p(CheerAnimationManager cheerAnimationManager0) {
        return cheerAnimationManager0.c;
    }

    public static final LottieAnimationView access$getExplodeAnimView$p(CheerAnimationManager cheerAnimationManager0) {
        return cheerAnimationManager0.b;
    }

    public static final I access$getFragment$p(CheerAnimationManager cheerAnimationManager0) {
        return cheerAnimationManager0.d;
    }

    public final void clear() {
        this.e.removeAllListeners();
        this.b.removeAllAnimatorListeners();
        this.e.cancel();
        this.b.cancelAnimation();
        this.a.cancelAnimation();
    }

    public final void startCountAnim(@NotNull CheerAnimationCnt cheerAnimationCnt0) {
        q.g(cheerAnimationCnt0, "cheerAnimCnt");
        this.c.setText((cheerAnimationCnt0.getUnit() == CheerUnit.OVER ? cheerAnimationCnt0.getUnit().getUnit() : va.e.h(cheerAnimationCnt0.getNum(), cheerAnimationCnt0.getUnit().getUnit())));
        this.e.start();
    }

    public final void startHeartAnim() {
        this.a.playAnimation();
    }
}

