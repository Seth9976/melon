package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build.VERSION;
import android.os.LocaleList;
import com.airbnb.lottie.utils.MiscUtils;

public class LPaint extends Paint {
    public LPaint() {
    }

    public LPaint(int v) {
        super(v);
    }

    public LPaint(int v, PorterDuff.Mode porterDuff$Mode0) {
        super(v);
        this.setXfermode(new PorterDuffXfermode(porterDuff$Mode0));
    }

    public LPaint(PorterDuff.Mode porterDuff$Mode0) {
        this.setXfermode(new PorterDuffXfermode(porterDuff$Mode0));
    }

    @Override  // android.graphics.Paint
    public void setAlpha(int v) {
        if(Build.VERSION.SDK_INT < 30) {
            this.setColor(MiscUtils.clamp(v, 0, 0xFF) << 24 | this.getColor() & 0xFFFFFF);
            return;
        }
        super.setAlpha(MiscUtils.clamp(v, 0, 0xFF));
    }

    @Override  // android.graphics.Paint
    public void setTextLocales(LocaleList localeList0) {
    }
}

