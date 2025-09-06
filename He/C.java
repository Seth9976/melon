package he;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public final class c extends a {
    public static final Paint a;

    static {
        Paint paint0 = new Paint();
        c.a = paint0;
        paint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override  // he.a
    public final Bitmap a(Context context0, BitmapPool bitmapPool0, Bitmap bitmap0) {
        int v = bitmap0.getWidth();
        int v1 = bitmap0.getHeight();
        Bitmap bitmap1 = bitmapPool0.get(v, v1, Bitmap.Config.ARGB_8888);
        bitmap1.setHasAlpha(true);
        Drawable drawable0 = context0.getDrawable(0x7F08092E);  // drawable:thumbnail_background_image_arched
        bitmap1.setDensity(bitmap0.getDensity());
        Canvas canvas0 = new Canvas(bitmap1);
        drawable0.setBounds(0, 0, v, v1);
        drawable0.draw(canvas0);
        canvas0.drawBitmap(bitmap0, 0.0f, 0.0f, c.a);
        return bitmap1;
    }

    @Override  // com.bumptech.glide.load.Key
    public final boolean equals(Object object0) {
        if(object0 instanceof c) {
            ((c)object0).getClass();
            return true;
        }
        return false;
    }

    @Override  // com.bumptech.glide.load.Key
    public final int hashCode() {
        return 0x821F18DB;
    }

    @Override
    public final String toString() {
        return "MaskTransformation(maskId=2131233070)";
    }

    @Override  // com.bumptech.glide.load.Key
    public final void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update("jp.wasabeef.glide.transformations.MaskTransformation.12131233070".getBytes(Key.CHARSET));
    }
}

