package P1;

import android.content.Context;
import android.graphics.Insets;
import android.graphics.drawable.Icon;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter2;
import android.net.Uri;
import android.os.ext.SdkExtensions;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;

public abstract class b {
    public static Context a(Context context0, String s) {
        return context0.createAttributionContext(s);
    }

    public static Icon b(Uri uri0) {
        return Icon.createWithAdaptiveBitmapContentUri(uri0);
    }

    public static String c(Context context0) {
        return context0.getAttributionTag();
    }

    public static Display d(Context context0) {
        try {
            return context0.getDisplay();
        }
        catch(UnsupportedOperationException unused_ex) {
            Log.w("ContextCompat", "The context:" + context0 + " is not associated with any display. Return a fallback display instead.");
            return ((DisplayManager)context0.getSystemService(DisplayManager.class)).getDisplay(0);
        }
    }

    public static void e(int v) {
        SdkExtensions.getExtensionVersion(v);
    }

    public static MediaRouter2 f(Context context0) {
        return MediaRouter2.getInstance(context0);
    }

    public static CharSequence g(AccessibilityNodeInfo accessibilityNodeInfo0) {
        return accessibilityNodeInfo0.getStateDescription();
    }

    public static Insets h(DisplayCutout displayCutout0) {
        return displayCutout0.getWaterfallInsets();
    }

    public static void i(Window window0, boolean z) {
        View view0 = window0.getDecorView();
        int v = view0.getSystemUiVisibility();
        view0.setSystemUiVisibility((z ? v & 0xFFFFFEFF : v | 0x100));
        window0.setDecorFitsSystemWindows(z);
    }

    public static void j(Window window0, boolean z) {
        window0.setDecorFitsSystemWindows(z);
    }

    public static void k(View view0) {
        view0.setImportantForContentCapture(1);
    }

    public static void l(EditorInfo editorInfo0, CharSequence charSequence0) {
        editorInfo0.setInitialSurroundingSubText(charSequence0, 0);
    }

    public static void m(AccessibilityNodeInfo accessibilityNodeInfo0, CharSequence charSequence0) {
        accessibilityNodeInfo0.setStateDescription(charSequence0);
    }
}

