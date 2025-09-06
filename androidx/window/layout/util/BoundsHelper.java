package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/window/layout/util/BoundsHelper;", "", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface BoundsHelper {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001A\u00020\bR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/window/layout/util/BoundsHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getInstance", "Landroidx/window/layout/util/BoundsHelper;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;
        @NotNull
        private static final String TAG;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.TAG = "BoundsHelper";
        }

        @NotNull
        public final BoundsHelper getInstance() {
            int v = Build.VERSION.SDK_INT;
            if(v >= 30) {
                return BoundsHelperApi30Impl.INSTANCE;
            }
            if(v >= 29) {
                return BoundsHelperApi29Impl.INSTANCE;
            }
            return v >= 28 ? BoundsHelperApi28Impl.INSTANCE : BoundsHelperApi24Impl.INSTANCE;
        }

        @NotNull
        public final String getTAG() [...] // 潜在的解密器
    }

    @NotNull
    public static final Companion Companion;

    static {
        BoundsHelper.Companion = Companion.$$INSTANCE;
    }

    @NotNull
    Rect currentWindowBounds(@NotNull Activity arg1);

    @NotNull
    Rect maximumWindowBounds(@NotNull Context arg1);
}

