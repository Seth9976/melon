package k5;

import android.graphics.Typeface;
import android.graphics.drawable.AnimatedImageDrawable;
import android.media.MediaMetadataRetriever.BitmapParams;
import android.text.PrecomputedText;

public abstract class s {
    public static int a(Typeface typeface0) {
        return typeface0.getWeight();
    }

    public static AnimatedImageDrawable c(Object object0) [...] // Inlined contents

    public static MediaMetadataRetriever.BitmapParams d() {
        return new MediaMetadataRetriever.BitmapParams();
    }

    public static boolean k(CharSequence charSequence0) {
        return charSequence0 instanceof PrecomputedText;
    }
}

