package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import e.k;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\f\u001A\u00020\u000B2\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR$\u0010\u0015\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001D\u001A\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\"\u0010%\u001A\u00020\u001E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/iloen/melon/custom/FadeScaleUpImageSwitcher;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "", "imageUrls", "Lie/H;", "setImageList", "(Ljava/util/List;)V", "Lcom/bumptech/glide/RequestManager;", "c", "Lcom/bumptech/glide/RequestManager;", "getGlideRequestManager", "()Lcom/bumptech/glide/RequestManager;", "setGlideRequestManager", "(Lcom/bumptech/glide/RequestManager;)V", "glideRequestManager", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "getLoopJob", "()Lkotlinx/coroutines/Job;", "setLoopJob", "(Lkotlinx/coroutines/Job;)V", "loopJob", "", "e", "Z", "getNoAnimate", "()Z", "setNoAnimate", "(Z)V", "noAnimate", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FadeScaleUpImageSwitcher extends FrameLayout {
    public int a;
    public final ArrayList b;
    public RequestManager c;
    public Job d;
    public boolean e;
    public final ArrayList f;

    public FadeScaleUpImageSwitcher(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null);
    }

    public FadeScaleUpImageSwitcher(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.b = new ArrayList();
        this.f = new ArrayList();
    }

    public final void a(int v, boolean z) {
        if(this.isAttachedToWindow() && !this.e) {
            ArrayList arrayList0 = this.b;
            if(v >= arrayList0.size()) {
                v = 0;
            }
            this.a = v;
            int v1 = 0;
            for(Object object0: this.f) {
                if(v1 >= 0) {
                    if(this.a == v1) {
                        ((MelonImageView)object0).setVisibility(0);
                        ((MelonImageView)object0).setAnimation(AnimationUtils.loadAnimation(this.getContext(), 0x7F010020));  // anim:fade_in_scale_up_short
                    }
                    else {
                        ((MelonImageView)object0).setVisibility(4);
                    }
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
            if(arrayList0.size() > 1) {
                this.d = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new B(this, z, null), 3, null);
            }
        }
    }

    @Nullable
    public final RequestManager getGlideRequestManager() {
        return this.c;
    }

    @Nullable
    public final Job getLoopJob() {
        return this.d;
    }

    public final boolean getNoAnimate() {
        return this.e;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a(this.a, true);
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job job0 = this.d;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
    }

    public final void setGlideRequestManager(@Nullable RequestManager requestManager0) {
        this.c = requestManager0;
    }

    public final void setImageList(@Nullable List list0) {
        ArrayList arrayList0 = this.b;
        arrayList0.clear();
        if(list0 != null && !list0.isEmpty()) {
            q.d(list0);
            arrayList0.addAll(list0);
            for(Object object0: list0) {
                String s = (String)object0;
                MelonImageView melonImageView0 = new MelonImageView(this.getContext(), null, 6, 0);
                melonImageView0.setScaleType(ImageView.ScaleType.CENTER_CROP);
                melonImageView0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f.add(melonImageView0);
                this.addView(melonImageView0);
                RequestManager requestManager0 = this.c;
                if(requestManager0 != null) {
                    RequestBuilder requestBuilder0 = requestManager0.load(s);
                    if(requestBuilder0 != null) {
                        requestBuilder0.into(melonImageView0);
                    }
                }
            }
            this.a(0, true);
        }
    }

    public final void setLoopJob(@Nullable Job job0) {
        this.d = job0;
    }

    public final void setNoAnimate(boolean z) {
        this.e = z;
    }
}

