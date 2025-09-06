package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.inputmethodservice.InputMethodService;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0000¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/layout/util/ContextCompatHelper;", "", "()V", "unwrapUiContext", "Landroid/content/Context;", "context", "unwrapUiContext$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ContextCompatHelper {
    @NotNull
    public static final ContextCompatHelper INSTANCE;

    static {
        ContextCompatHelper.INSTANCE = new ContextCompatHelper();
    }

    @NotNull
    public final Context unwrapUiContext$window_release(@NotNull Context context0) {
        q.g(context0, "context");
        Context context1 = context0;
        while(context1 instanceof ContextWrapper) {
            if(context1 instanceof Activity || context1 instanceof InputMethodService || ((ContextWrapper)context1).getBaseContext() == null) {
                return context1;
            }
            context1 = ((ContextWrapper)context1).getBaseContext();
            q.f(context1, "getBaseContext(...)");
        }
        throw new IllegalArgumentException("Context " + context0 + " is not a UiContext");
    }
}

