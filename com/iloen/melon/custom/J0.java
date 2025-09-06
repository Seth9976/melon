package com.iloen.melon.custom;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.jvm.internal.q;
import m4.e;
import m4.g;

public final class j0 extends CustomTarget {
    public final MelonChartAwardView a;
    public final View b;
    public final ImageView c;

    public j0(MelonChartAwardView melonChartAwardView0, View view0, ImageView imageView0) {
        this.a = melonChartAwardView0;
        this.b = view0;
        this.c = imageView0;
        super();
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        q.g(((Bitmap)object0), "bitmap");
        e e0 = new e(((Bitmap)object0));
        e0.a = 24;
        g g0 = e0.a().e;
        if(g0 != null) {
            GradientDrawable gradientDrawable0 = new GradientDrawable();
            gradientDrawable0.setColors(new int[]{ColorUtils.getColor(this.a.getContext(), 0x7F06048A), g0.d});  // color:transparent
            gradientDrawable0.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            View view0 = this.b;
            if(view0 != null) {
                view0.setBackground(gradientDrawable0);
            }
        }
        ImageView imageView0 = this.c;
        if(imageView0 != null) {
            imageView0.setImageBitmap(((Bitmap)object0));
        }
    }
}

