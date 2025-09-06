package he;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public final class e extends a {
    public final int a;
    public final int b;
    public final RoundedCornersTransformation.CornerType c;

    public e(int v, RoundedCornersTransformation.CornerType roundedCornersTransformation$CornerType0) {
        this.a = v;
        this.b = v * 2;
        this.c = roundedCornersTransformation$CornerType0;
    }

    @Override  // he.a
    public final Bitmap a(Context context0, BitmapPool bitmapPool0, Bitmap bitmap0) {
        int v = bitmap0.getWidth();
        int v1 = bitmap0.getHeight();
        Bitmap bitmap1 = bitmapPool0.get(v, v1, Bitmap.Config.ARGB_8888);
        bitmap1.setHasAlpha(true);
        bitmap1.setDensity(bitmap0.getDensity());
        Canvas canvas0 = new Canvas(bitmap1);
        Paint paint0 = new Paint();
        paint0.setAntiAlias(true);
        paint0.setShader(new BitmapShader(bitmap0, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        float f = ((float)v) - 0.0f;
        float f1 = ((float)v1) - 0.0f;
        int v2 = this.b;
        int v3 = this.a;
        switch(d.a[this.c.ordinal()]) {
            case 1: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, f, f1), ((float)v3), ((float)v3), paint0);
                return bitmap1;
            }
            case 2: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, ((float)v2), ((float)v2)), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, ((float)v3), ((float)v3), f1), paint0);
                canvas0.drawRect(new RectF(((float)v3), 0.0f, f, f1), paint0);
                return bitmap1;
            }
            case 3: {
                canvas0.drawRoundRect(new RectF(f - ((float)v2), 0.0f, f, ((float)v2)), ((float)v3), ((float)v3), paint0);
                float f2 = f - ((float)v3);
                canvas0.drawRect(new RectF(0.0f, 0.0f, f2, f1), paint0);
                canvas0.drawRect(new RectF(f2, ((float)v3), f, f1), paint0);
                return bitmap1;
            }
            case 4: {
                canvas0.drawRoundRect(new RectF(0.0f, f1 - ((float)v2), ((float)v2), f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, 0.0f, ((float)v2), f1 - ((float)v3)), paint0);
                canvas0.drawRect(new RectF(((float)v3), 0.0f, f, f1), paint0);
                return bitmap1;
            }
            case 5: {
                canvas0.drawRoundRect(new RectF(f - ((float)v2), f1 - ((float)v2), f, f1), ((float)v3), ((float)v3), paint0);
                float f3 = f - ((float)v3);
                canvas0.drawRect(new RectF(0.0f, 0.0f, f3, f1), paint0);
                canvas0.drawRect(new RectF(f3, 0.0f, f, f1 - ((float)v3)), paint0);
                return bitmap1;
            }
            case 6: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, f, ((float)v2)), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, ((float)v3), f, f1), paint0);
                return bitmap1;
            }
            case 7: {
                canvas0.drawRoundRect(new RectF(0.0f, f1 - ((float)v2), f, f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, 0.0f, f, f1 - ((float)v3)), paint0);
                return bitmap1;
            }
            case 8: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, ((float)v2), f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(((float)v3), 0.0f, f, f1), paint0);
                return bitmap1;
            }
            case 9: {
                canvas0.drawRoundRect(new RectF(f - ((float)v2), 0.0f, f, f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, 0.0f, f - ((float)v3), f1), paint0);
                return bitmap1;
            }
            case 10: {
                canvas0.drawRoundRect(new RectF(0.0f, f1 - ((float)v2), f, f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRoundRect(new RectF(f - ((float)v2), 0.0f, f, f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, 0.0f, f - ((float)v3), f1 - ((float)v3)), paint0);
                return bitmap1;
            }
            case 11: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, ((float)v2), f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRoundRect(new RectF(0.0f, f1 - ((float)v2), f, f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(((float)v3), 0.0f, f, f1 - ((float)v3)), paint0);
                return bitmap1;
            }
            case 12: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, f, ((float)v2)), ((float)v3), ((float)v3), paint0);
                canvas0.drawRoundRect(new RectF(f - ((float)v2), 0.0f, f, f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, ((float)v3), f - ((float)v3), f1), paint0);
                return bitmap1;
            }
            case 13: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, f, ((float)v2)), ((float)v3), ((float)v3), paint0);
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, ((float)v2), f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(((float)v3), ((float)v3), f, f1), paint0);
                return bitmap1;
            }
            case 14: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, ((float)v2), ((float)v2)), ((float)v3), ((float)v3), paint0);
                canvas0.drawRoundRect(new RectF(f - ((float)v2), f1 - ((float)v2), f, f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, ((float)v3), f - ((float)v3), f1), paint0);
                canvas0.drawRect(new RectF(((float)v3), 0.0f, f, f1 - ((float)v3)), paint0);
                return bitmap1;
            }
            case 15: {
                canvas0.drawRoundRect(new RectF(f - ((float)v2), 0.0f, f, ((float)v2)), ((float)v3), ((float)v3), paint0);
                canvas0.drawRoundRect(new RectF(0.0f, f1 - ((float)v2), ((float)v2), f1), ((float)v3), ((float)v3), paint0);
                canvas0.drawRect(new RectF(0.0f, 0.0f, f - ((float)v3), f1 - ((float)v3)), paint0);
                canvas0.drawRect(new RectF(((float)v3), ((float)v3), f, f1), paint0);
                return bitmap1;
            }
            default: {
                canvas0.drawRoundRect(new RectF(0.0f, 0.0f, f, f1), ((float)v3), ((float)v3), paint0);
                return bitmap1;
            }
        }
    }

    @Override  // com.bumptech.glide.load.Key
    public final boolean equals(Object object0) {
        return object0 instanceof e && ((e)object0).a == this.a && ((e)object0).b == this.b && ((e)object0).c == this.c;
    }

    @Override  // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.c.ordinal() * 10 + (this.b * 1000 + (this.a * 10000 + 0x195894B4));
    }

    @Override
    public final String toString() {
        return "RoundedTransformation(radius=" + this.a + ", margin=0, diameter=" + this.b + ", cornerType=" + this.c.name() + ")";
    }

    @Override  // com.bumptech.glide.load.Key
    public final void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(("jp.wasabeef.glide.transformations.RoundedCornersTransformation.1" + this.a + this.b + 0 + this.c).getBytes(Key.CHARSET));
    }
}

