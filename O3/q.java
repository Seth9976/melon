package o3;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.net.ssl.SSLSockets;
import javax.net.ssl.SSLSocket;

public abstract class q {
    public static ColorStateList a(ColorStateListDrawable colorStateListDrawable0) {
        return colorStateListDrawable0.getColorStateList();
    }

    public static ColorStateListDrawable c(Drawable drawable0) [...] // Inlined contents

    public static void g(SSLSocket sSLSocket0) {
        SSLSockets.setUseSessionTickets(sSLSocket0, true);
    }

    public static boolean i(Drawable drawable0) {
        return drawable0 instanceof ColorStateListDrawable;
    }
}

