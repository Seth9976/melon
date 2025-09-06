package com.iloen.melon.utils.color;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RotateDrawable;
import android.view.View;

public class DrawableColorUtils {
    public static GradientDrawable changeDrawableInnerColor(View view0, int v) {
        Drawable drawable0 = view0.getBackground();
        if(drawable0 == null) {
            return null;
        }
        GradientDrawable gradientDrawable0 = drawable0 instanceof RotateDrawable ? ((GradientDrawable)((RotateDrawable)drawable0).getDrawable()) : ((GradientDrawable)view0.getBackground());
        if(gradientDrawable0 != null) {
            gradientDrawable0.setColor(v);
        }
        return gradientDrawable0;
    }

    public static GradientDrawable changeDrawableStrokeColor(View view0, int v, int v1) {
        GradientDrawable gradientDrawable0 = (GradientDrawable)view0.getBackground();
        if(gradientDrawable0 != null) {
            gradientDrawable0.setStroke(v, v1, 0.0f, 0.0f);
        }
        return gradientDrawable0;
    }

    public static GradientDrawable changeDrawableStrokeColor(View view0, int v, int v1, int v2) {
        GradientDrawable gradientDrawable0 = DrawableColorUtils.changeDrawableStrokeColor(view0, v, v1);
        gradientDrawable0.setAlpha(v2);
        return gradientDrawable0;
    }
}

