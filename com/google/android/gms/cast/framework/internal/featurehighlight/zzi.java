package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.cast.framework.R.dimen;

final class zzi {
    private final Rect zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final zzh zzf;

    public zzi(zzh zzh0) {
        this.zza = new Rect();
        this.zzf = zzh0;
        Resources resources0 = zzh0.getResources();
        this.zzb = resources0.getDimensionPixelSize(dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zzc = resources0.getDimensionPixelOffset(dimen.cast_libraries_material_featurehighlight_inner_margin);
        this.zzd = resources0.getDimensionPixelSize(dimen.cast_libraries_material_featurehighlight_text_max_width);
        this.zze = resources0.getDimensionPixelSize(dimen.cast_libraries_material_featurehighlight_text_horizontal_offset);
    }

    public final void zza(Rect rect0, Rect rect1) {
        zzh zzh0 = this.zzf;
        View view0 = zzh0.zzb();
        if(rect0.isEmpty() || rect1.isEmpty()) {
            view0.layout(0, 0, 0, 0);
        }
        else {
            int v = rect0.centerY();
            int v1 = rect0.centerX();
            int v2 = rect1.centerY();
            int v3 = rect0.height();
            int v4 = Math.max(this.zzb + this.zzb, v3);
            int v5 = this.zzc;
            if(v < v2) {
                int v6 = v5 + (v + v4 / 2);
                int v7 = rect1.bottom - v6;
                this.zzc(view0, rect1.width(), v7);
                int v8 = this.zzb(view0, rect1.left, rect1.right, view0.getMeasuredWidth(), v1);
                view0.layout(v8, v6, view0.getMeasuredWidth() + v8, view0.getMeasuredHeight() + v6);
            }
            else {
                int v9 = v - v4 / 2 - v5;
                int v10 = v9 - rect1.top;
                this.zzc(view0, rect1.width(), v10);
                int v11 = this.zzb(view0, rect1.left, rect1.right, view0.getMeasuredWidth(), v1);
                view0.layout(v11, v9 - view0.getMeasuredHeight(), view0.getMeasuredWidth() + v11, v9);
            }
        }
        int v12 = view0.getLeft();
        int v13 = view0.getTop();
        int v14 = view0.getRight();
        int v15 = view0.getBottom();
        this.zza.set(v12, v13, v14, v15);
        zzh0.zzf().zzf(rect0, this.zza);
        zzh0.zzd().zzb(rect0);
    }

    private final int zzb(View view0, int v, int v1, int v2, int v3) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v4 = v3 - v2 / 2;
        int v5 = v3 - v > v1 - v3 ? v4 - this.zze : v4 + this.zze;
        int v6 = viewGroup$MarginLayoutParams0.leftMargin;
        if(v5 - v6 < v) {
            return v + v6;
        }
        return v5 + v2 + viewGroup$MarginLayoutParams0.rightMargin <= v1 ? v5 : v1 - v2 - viewGroup$MarginLayoutParams0.rightMargin;
    }

    private final void zzc(View view0, int v, int v1) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        view0.measure(View.MeasureSpec.makeMeasureSpec(Math.min(v - viewGroup$MarginLayoutParams0.leftMargin - viewGroup$MarginLayoutParams0.rightMargin, this.zzd), 0x40000000), View.MeasureSpec.makeMeasureSpec(v1, 0x80000000));
    }
}

