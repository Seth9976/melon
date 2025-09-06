package androidx.mediarouter.app;

import De.I;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatSeekBar;

class MediaRouteVolumeSlider extends AppCompatSeekBar {
    public final float b;
    public boolean c;
    public Drawable d;
    public int e;
    public int f;

    public MediaRouteVolumeSlider(Context context0) {
        this(context0, null);
    }

    public MediaRouteVolumeSlider(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040535);  // attr:seekBarStyle
    }

    public MediaRouteVolumeSlider(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.b = I.G(context0);
    }

    public final void a(int v, int v1) {
        if(this.e != v) {
            if(Color.alpha(v) != 0xFF) {
                Log.e("MediaRouteVolumeSlider", "Volume slider progress and thumb color cannot be translucent: #" + Integer.toHexString(v));
            }
            this.e = v;
        }
        if(this.f != v1) {
            if(Color.alpha(v1) != 0xFF) {
                Log.e("MediaRouteVolumeSlider", "Volume slider background color cannot be translucent: #" + Integer.toHexString(v1));
            }
            this.f = v1;
        }
    }

    public final void b(boolean z) {
        if(this.c == z) {
            return;
        }
        this.c = z;
        super.setThumb((z ? null : this.d));
    }

    @Override  // androidx.appcompat.widget.AppCompatSeekBar
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int v = this.isEnabled() ? 0xFF : ((int)(this.b * 255.0f));
        PorterDuff.Mode porterDuff$Mode0 = PorterDuff.Mode.SRC_IN;
        this.d.setColorFilter(this.e, porterDuff$Mode0);
        this.d.setAlpha(v);
        Drawable drawable0 = this.getProgressDrawable();
        if(drawable0 instanceof LayerDrawable) {
            LayerDrawable layerDrawable0 = (LayerDrawable)this.getProgressDrawable();
            Drawable drawable1 = layerDrawable0.findDrawableByLayerId(0x102000D);
            layerDrawable0.findDrawableByLayerId(0x1020000).setColorFilter(this.f, porterDuff$Mode0);
            drawable0 = drawable1;
        }
        drawable0.setColorFilter(this.e, porterDuff$Mode0);
        drawable0.setAlpha(v);
    }

    @Override  // android.widget.AbsSeekBar
    public final void setThumb(Drawable drawable0) {
        this.d = drawable0;
        if(this.c) {
            drawable0 = null;
        }
        super.setThumb(drawable0);
    }
}

