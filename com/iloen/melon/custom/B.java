package com.iloen.melon.custom;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.jvm.internal.q;

public final class b extends CustomTarget {
    public final ArtistCardRelayItemView a;

    public b(ArtistCardRelayItemView artistCardRelayItemView0) {
        this.a = artistCardRelayItemView0;
        super();
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.CustomTarget
    public final void onLoadFailed(Drawable drawable0) {
        super.onLoadFailed(drawable0);
        this.a.m.setImageBitmap(null);
        ColorDrawable colorDrawable0 = new ColorDrawable(ColorUtils.getColor(this.a.getContext(), 0x7F060161));  // color:gray601s
        this.a.a.setImageDrawable(colorDrawable0);
        this.a.b.setVisibility(8);
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        q.g(((Bitmap)object0), "bitmap");
        this.a.m.setImageBitmap(((Bitmap)object0));
        GradientDrawable gradientDrawable0 = ArtistCardRelayItemView.a(this.a, ((Bitmap)object0));
        this.a.a.setImageDrawable(gradientDrawable0);
        this.a.b.setVisibility(0);
    }
}

