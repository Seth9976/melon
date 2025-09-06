package android.support.v4.graphics.drawable;

import P4.b;
import androidx.core.graphics.drawable.IconCompat;

public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
    @Override  // androidx.core.graphics.drawable.IconCompatParcelizer
    public static IconCompat read(b b0) {
        return androidx.core.graphics.drawable.IconCompatParcelizer.read(b0);
    }

    @Override  // androidx.core.graphics.drawable.IconCompatParcelizer
    public static void write(IconCompat iconCompat0, b b0) {
        androidx.core.graphics.drawable.IconCompatParcelizer.write(iconCompat0, b0);
    }
}

