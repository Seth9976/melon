package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.iloen.melon.utils.color.DrawableColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class CoverView extends RelativeLayout implements W {
    public final float a;
    public final float b;
    public final float c;
    public final boolean d;
    public boolean e;
    public final boolean f;
    public RelativeLayout g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public View m;
    public ImageView n;

    public CoverView(Context context0) {
        super(context0);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = true;
        this.e = false;
        this.f = false;
        this.a();
    }

    public CoverView(Context context0, float f) {
        super(context0);
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = true;
        this.e = false;
        this.f = false;
        this.a = f;
        this.a();
    }

    public CoverView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = true;
        this.e = false;
        this.f = false;
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.i, 0, 0);
        this.a = typedArray0.getFloat(5, 0.0f);
        this.b = typedArray0.getFloat(4, 0.0f);
        this.c = typedArray0.getFloat(1, 0.0f);
        this.d = typedArray0.getBoolean(3, true);
        this.e = typedArray0.getBoolean(0, false);
        this.f = typedArray0.getBoolean(2, false);
        typedArray0.recycle();
        this.a();
    }

    public final void a() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D01DA, this);  // layout:cover_view
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0182);  // id:btn_play
        this.k = imageView0;
        ViewUtils.showWhen(imageView0, this.d);
        if(this.d) {
            int v = ScreenUtils.dipToPixel(this.getContext(), this.c);
            RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
            relativeLayout$LayoutParams0.setMargins(0, v, v, 0);
            this.k.setLayoutParams(relativeLayout$LayoutParams0);
        }
        ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A064F);  // id:iv_melon_logo
        this.l = imageView1;
        float f = this.a;
        if(f <= 58.0f) {
            this.e = false;
            ViewUtils.showWhen(imageView1, false);
        }
        else if(Float.compare(f, 110.0f) <= 0) {
            ViewUtils.showWhen(imageView1, true);
            int v1 = ScreenUtils.dipToPixel(this.getContext(), 3.0f);
            RelativeLayout.LayoutParams relativeLayout$LayoutParams1 = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
            relativeLayout$LayoutParams1.setMargins(v1, v1, 0, 0);
            this.l.setLayoutParams(relativeLayout$LayoutParams1);
        }
        else {
            ViewUtils.showWhen(imageView1, true);
        }
        RelativeLayout relativeLayout0 = (RelativeLayout)view0.findViewById(0x7F0A0713);  // id:layout_cover_container
        this.g = relativeLayout0;
        RelativeLayout.LayoutParams relativeLayout$LayoutParams2 = (RelativeLayout.LayoutParams)relativeLayout0.getLayoutParams();
        int v2 = ScreenUtils.dipToPixel(this.getContext(), this.a);
        int v3 = this.b == 0.0f ? v2 : ScreenUtils.dipToPixel(this.getContext(), this.b);
        relativeLayout$LayoutParams2.width = v2;
        relativeLayout$LayoutParams2.height = v3;
        ImageView imageView2 = (ImageView)view0.findViewById(0x7F0A0606);  // id:iv_bottom_shadow
        this.h = imageView2;
        RelativeLayout.LayoutParams relativeLayout$LayoutParams3 = (RelativeLayout.LayoutParams)imageView2.getLayoutParams();
        relativeLayout$LayoutParams3.width = v2;
        relativeLayout$LayoutParams3.height = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
        this.i = (ImageView)view0.findViewById(0x7F0A05EF);  // id:iv_animation
        this.j = (ImageView)view0.findViewById(0x7F0A0618);  // id:iv_cover_thumb
        View view1 = view0.findViewById(0x7F0A0619);  // id:iv_cover_thumb_stroke
        this.m = view1;
        ViewUtils.showWhen(view1, this.f);
        this.n = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
    }

    public final void b(boolean z) {
        if(this.e) {
            ViewUtils.showWhen(this.l, z);
        }
    }

    public final void c() {
        ViewUtils.showWhen(this.k, false);
    }

    public ImageView getAnimationView() {
        return this.i;
    }

    public View getPlayButtonView() {
        return this.k;
    }

    public float getStandardSize() {
        return this.a;
    }

    public ImageView getThumbnailView() {
        return this.j;
    }

    public void setImageBitmap(Bitmap bitmap0) {
        this.j.setImageBitmap(bitmap0);
    }

    public void setMelonLogoEnabled(boolean z) {
        this.e = z;
        ViewUtils.showWhen(this.l, false);
    }

    public void setOutlineColor(int v) {
        int v1 = ScreenUtils.dipToPixel(this.getContext(), 0.5f);
        DrawableColorUtils.changeDrawableStrokeColor(this.m, v1, v);
    }

    public void setShadowColor(int v) {
        ViewUtils.showWhen(this.h, true);
        this.h.setColorFilter(v, PorterDuff.Mode.SRC_IN);
    }

    public void setShowDefaultThumbnail(boolean z) {
        this.n.setVisibility((z ? 0 : 8));
    }
}

