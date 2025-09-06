package he;

import U4.x;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public final class b extends a {
    public final int a;

    public b(int v) {
        this.a = v;
    }

    @Override  // he.a
    public final Bitmap a(Context context0, BitmapPool bitmapPool0, Bitmap bitmap0) {
        Bitmap bitmap1 = bitmapPool0.get(bitmap0.getWidth(), bitmap0.getHeight(), (bitmap0.getConfig() == null ? Bitmap.Config.ARGB_8888 : bitmap0.getConfig()));
        bitmap1.setDensity(bitmap0.getDensity());
        Canvas canvas0 = new Canvas(bitmap1);
        Paint paint0 = new Paint();
        paint0.setAntiAlias(true);
        paint0.setColorFilter(new PorterDuffColorFilter(this.a, PorterDuff.Mode.SRC_ATOP));
        canvas0.drawBitmap(bitmap0, 0.0f, 0.0f, paint0);
        return bitmap1;
    }

    @Override  // com.bumptech.glide.load.Key
    public final boolean equals(Object object0) {
        return object0 instanceof b && ((b)object0).a == this.a;
    }

    @Override  // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.a * 10 + 0x2A0B2610;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ColorFilterTransformation(color=");
        return x.g(this.a, ")", stringBuilder0);
    }

    @Override  // com.bumptech.glide.load.Key
    public final void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(("jp.wasabeef.glide.transformations.ColorFilterTransformation.1" + this.a).getBytes(Key.CHARSET));
    }
}

