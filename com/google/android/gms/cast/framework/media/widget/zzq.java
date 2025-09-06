package com.google.android.gms.cast.framework.media.widget;

import P1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.google.android.gms.cast.internal.Logger;

public final class zzq {
    private static final Logger zza;

    static {
        zzq.zza = new Logger("WidgetUtil");
    }

    public static Bitmap zza(Context context0, Bitmap bitmap0, float f, float f1) {
        Object[] arr_object = {bitmap0, bitmap0.getWidth(), bitmap0.getHeight()};
        zzq.zza.d("Begin blurring bitmap %s, original width = %d, original height = %d.", arr_object);
        int v = Math.round(((float)bitmap0.getWidth()) * 0.25f);
        int v1 = Math.round(((float)bitmap0.getHeight()) * 0.25f);
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap0, v, v1, false);
        Bitmap bitmap2 = Bitmap.createBitmap(v, v1, bitmap1.getConfig());
        RenderScript renderScript0 = RenderScript.create(context0);
        Allocation allocation0 = Allocation.createFromBitmap(renderScript0, bitmap1);
        Allocation allocation1 = Allocation.createTyped(renderScript0, allocation0.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlur0 = ScriptIntrinsicBlur.create(renderScript0, allocation0.getElement());
        scriptIntrinsicBlur0.setInput(allocation0);
        scriptIntrinsicBlur0.setRadius(7.5f);
        scriptIntrinsicBlur0.forEach(allocation1);
        allocation1.copyTo(bitmap2);
        renderScript0.destroy();
        zzq.zza.d("End blurring bitmap %s, original width = %d, original height = %d.", new Object[]{bitmap1, v, v1});
        return bitmap2;
    }

    public static Drawable zzb(Context context0, int v, int v1) {
        return zzq.zzd(context0, v, v1, 0, 0x106000B);
    }

    public static Drawable zzc(Context context0, int v, int v1) {
        return zzq.zzd(context0, v, v1, 0x1010030, 0);
    }

    private static Drawable zzd(Context context0, int v, int v1, int v2, int v3) {
        ColorStateList colorStateList0;
        int v4;
        Drawable drawable0 = context0.getResources().getDrawable(v1).mutate();
        drawable0.setTintMode(PorterDuff.Mode.SRC_IN);
        if(v == 0) {
            if(v2 == 0) {
                v4 = c.getColor(context0, v3);
            }
            else {
                TypedArray typedArray0 = context0.obtainStyledAttributes(new int[]{v2});
                v4 = typedArray0.getColor(0, 0);
                typedArray0.recycle();
            }
            int[] arr_v = {v4, S1.c.k(v4, 0x80)};
            colorStateList0 = new ColorStateList(new int[][]{new int[]{0x101009E}, new int[]{0xFEFEFF62}}, arr_v);
        }
        else {
            colorStateList0 = c.getColorStateList(context0, v);
        }
        drawable0.setTintList(colorStateList0);
        return drawable0;
    }
}

