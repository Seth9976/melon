package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;

public class TintContextWrapper extends ContextWrapper {
    public static final Object a;

    static {
    }

    public static void a(Context context0) {
        if(!(context0 instanceof TintContextWrapper) && !(context0.getResources() instanceof b1)) {
            context0.getResources();
        }
    }

    @Override  // android.content.ContextWrapper
    public final AssetManager getAssets() {
        throw null;
    }

    @Override  // android.content.ContextWrapper
    public final Resources getResources() {
        return null;
    }
}

