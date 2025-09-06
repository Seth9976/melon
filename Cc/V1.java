package Cc;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.b0;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.iloen.melon.utils.MelonSettingInfo;
import kotlin.jvm.internal.q;
import we.a;
import we.k;

public final class v1 implements RequestListener {
    public final k a;
    public final Context b;
    public final int c;
    public final b0 d;
    public final b0 e;
    public final a f;

    public v1(k k0, Context context0, int v, b0 b00, b0 b01, a a0) {
        this.a = k0;
        this.b = context0;
        this.c = v;
        this.d = b00;
        this.e = b01;
        this.f = a0;
    }

    @Override  // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException glideException0, Object object0, Target target0, boolean z) {
        q.g(target0, "target");
        a a0 = this.f;
        if(a0 != null) {
            a0.invoke();
        }
        return true;
    }

    @Override  // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Object object0, Object object1, Target target0, DataSource dataSource0, boolean z) {
        Drawable drawable0 = (Drawable)object0;
        q.g(drawable0, "resource");
        q.g(object1, "model");
        q.g(dataSource0, "dataSource");
        if(DataSource.MEMORY_CACHE == dataSource0 || DataSource.RESOURCE_DISK_CACHE == dataSource0) {
            this.d.setValue(Boolean.FALSE);
        }
        k k0 = this.a;
        if(k0 != null) {
            k0.invoke(drawable0);
        }
        boolean z1 = MelonSettingInfo.isLowMemoryMode();
        b0 b00 = this.e;
        if(z1) {
            if(drawable0 instanceof WebpDrawable) {
                drawable0 = new BitmapDrawable(this.b.getResources(), ((WebpDrawable)drawable0).getFirstFrame());
            }
            b00.setValue(drawable0);
            return true;
        }
        if(drawable0 instanceof WebpDrawable) {
            ((WebpDrawable)drawable0).setLoopCount(this.c);
            ((WebpDrawable)drawable0).start();
        }
        b00.setValue(drawable0);
        return true;
    }
}

