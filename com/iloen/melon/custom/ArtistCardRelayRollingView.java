package com.iloen.melon.custom;

import Vb.i;
import android.animation.AnimatorSet.Builder;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE.MEMORIALCARDRELAYLIST;
import com.iloen.melon.utils.system.AppUtils;
import d3.g;
import e.k;
import ie.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R6\u0010\u0012\u001A\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\b8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R:\u0010\u001C\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001B\u0010\"\u001A\u00020\u001D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!R\u0014\u0010&\u001A\u00020#8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%¨\u0006\'"}, d2 = {"Lcom/iloen/melon/custom/ArtistCardRelayRollingView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/Function2;", "", "", "Lie/H;", "a", "Lwe/n;", "getOnClickListener", "()Lwe/n;", "setOnClickListener", "(Lwe/n;)V", "onClickListener", "", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST;", "value", "i", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "Landroid/view/animation/Interpolator;", "j", "Lie/j;", "getRollingInterpolator", "()Landroid/view/animation/Interpolator;", "rollingInterpolator", "Landroid/animation/AnimatorSet;", "getRollingAnim", "()Landroid/animation/AnimatorSet;", "rollingAnim", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistCardRelayRollingView extends RelativeLayout {
    public n a;
    public final float b;
    public Job c;
    public AnimatorSet d;
    public final CardView e;
    public int f;
    public final ArrayList g;
    public int h;
    public List i;
    public final r j;
    public static final int k;

    public ArtistCardRelayRollingView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.b = this.getResources().getDimension(0x7F070052);  // dimen:artist_channel_card_relay_height
        ArrayList arrayList0 = new ArrayList(2);
        int v = 0;
        for(int v1 = 0; v1 < 2; ++v1) {
            arrayList0.add(new ArtistCardRelayItemView(context0, null, 6, 0));
        }
        this.g = arrayList0;
        View.inflate(context0, 0x7F0D0212, this);  // layout:detail_item_artist_channel_card_relay_view
        View view0 = this.findViewById(0x7F0A0211);  // id:card_view
        q.f(view0, "findViewById(...)");
        this.e = (CardView)view0;
        for(Object object0: arrayList0) {
            if(v >= 0) {
                CardView cardView0 = this.e;
                RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(-1, -1);
                if(v != 0) {
                    ((ArtistCardRelayItemView)object0).setTranslationY(this.b);
                }
                cardView0.addView(((ArtistCardRelayItemView)object0), relativeLayout$LayoutParams0);
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        this.j = g.Q(new i(17));
    }

    public final void b() {
        this.c();
        if(this.i != null && !this.i.isEmpty()) {
            this.h = 0;
            List list0 = this.i;
            if(list0 != null) {
                for(int v = 0; v < 2; ++v) {
                    ArtistCardRelayItemView artistCardRelayItemView0 = (ArtistCardRelayItemView)this.g.get((this.f + v) % 2);
                    int v1 = v % list0.size();
                    artistCardRelayItemView0.setData(((MEMORIALCARDRELAYLIST)list0.get(v1)));
                    artistCardRelayItemView0.setOnClickListener(new c(this, v, list0, v1));
                    artistCardRelayItemView0.setAccessibilityDelegate(new f(this, list0, artistCardRelayItemView0));
                }
            }
            Job job0 = this.c;
            if(job0 != null) {
                DefaultImpls.cancel$default(job0, null, 1, null);
            }
            if(!AppUtils.isAccessibilityTalkbackOn()) {
                this.c = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.custom.g(this, null), 3, null);
            }
        }
    }

    public final void c() {
        Job job0 = this.c;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        AnimatorSet animatorSet0 = this.d;
        if(animatorSet0 != null) {
            if(animatorSet0.isStarted()) {
                animatorSet0.end();
            }
            animatorSet0.removeAllListeners();
        }
    }

    @Nullable
    public final List getData() {
        return this.i;
    }

    @Nullable
    public final n getOnClickListener() {
        return this.a;
    }

    private final AnimatorSet getRollingAnim() {
        AnimatorSet animatorSet0 = new AnimatorSet();
        ArtistCardRelayItemView artistCardRelayItemView0 = (ArtistCardRelayItemView)this.g.get(this.f);
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(((ArtistCardRelayItemView)this.g.get((this.f + 1) % 2)), "translationY", new float[]{0.0f});
        objectAnimator0.setInterpolator(this.getRollingInterpolator());
        objectAnimator0.setDuration(350L);
        AnimatorSet.Builder animatorSet$Builder0 = animatorSet0.play(objectAnimator0);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(artistCardRelayItemView0, "translationY", new float[]{-this.b});
        objectAnimator1.setInterpolator(this.getRollingInterpolator());
        objectAnimator1.setDuration(350L);
        animatorSet$Builder0.with(objectAnimator1);
        animatorSet0.addListener(new e(this, artistCardRelayItemView0));
        return animatorSet0;
    }

    private final Interpolator getRollingInterpolator() {
        return (Interpolator)this.j.getValue();
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c();
    }

    public final void setData(@Nullable List list0) {
        this.i = list0;
        this.b();
    }

    public final void setOnClickListener(@Nullable n n0) {
        this.a = n0;
    }
}

