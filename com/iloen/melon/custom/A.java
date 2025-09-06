package com.iloen.melon.custom;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;

public final class a extends CustomTarget {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    private final void a(Drawable drawable0) {
    }

    private final void b(Drawable drawable0) {
    }

    private final void c(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.CustomTarget
    public final void onLoadFailed(Drawable drawable0) {
        switch(this.a) {
            case 0: {
                super.onLoadFailed(drawable0);
                ((ArtistCardRelayItemView)this.b).l.setImageBitmap(null);
                ColorDrawable colorDrawable0 = new ColorDrawable(ColorUtils.getColor(((ArtistCardRelayItemView)this.b).getContext(), 0x7F060161));  // color:gray601s
                ((ArtistCardRelayItemView)this.b).a.setImageDrawable(colorDrawable0);
                ((ArtistCardRelayItemView)this.b).b.setVisibility(8);
                return;
            }
            case 1: {
                super.onLoadFailed(drawable0);
                ColorDrawable colorDrawable1 = new ColorDrawable(ColorUtils.getColor(((ArtistCardRelayItemView)this.b).getContext(), 0x7F060161));  // color:gray601s
                ((ArtistCardRelayItemView)this.b).a.setImageDrawable(colorDrawable1);
                return;
            }
            default: {
                CancellableContinuationImpl cancellableContinuationImpl0 = (CancellableContinuationImpl)this.b;
                if(cancellableContinuationImpl0.isActive()) {
                    if(drawable0 == null) {
                        drawable0 = new ColorDrawable(0);
                    }
                    cancellableContinuationImpl0.resumeWith(drawable0);
                }
            }
        }
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        switch(this.a) {
            case 0: {
                q.g(((Bitmap)object0), "bitmap");
                ((ArtistCardRelayItemView)this.b).l.setImageBitmap(((Bitmap)object0));
                GradientDrawable gradientDrawable0 = ArtistCardRelayItemView.a(((ArtistCardRelayItemView)this.b), ((Bitmap)object0));
                ((ArtistCardRelayItemView)this.b).a.setImageDrawable(gradientDrawable0);
                ((ArtistCardRelayItemView)this.b).b.setVisibility(0);
                return;
            }
            case 1: {
                q.g(((Drawable)object0), "drawable");
                ((ArtistCardRelayItemView)this.b).a.setImageDrawable(((Drawable)object0));
                return;
            }
            default: {
                q.g(((Drawable)object0), "resource");
                CancellableContinuationImpl cancellableContinuationImpl0 = (CancellableContinuationImpl)this.b;
                if(cancellableContinuationImpl0.isActive()) {
                    cancellableContinuationImpl0.resumeWith(((Drawable)object0));
                }
            }
        }
    }
}

