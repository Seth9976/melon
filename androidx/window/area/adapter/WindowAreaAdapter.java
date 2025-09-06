package androidx.window.area.adapter;

import androidx.window.area.WindowAreaCapability.Status;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.core.ExtensionsUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u0006H\u0000¢\u0006\u0002\b\n¨\u0006\u000B"}, d2 = {"Landroidx/window/area/adapter/WindowAreaAdapter;", "", "()V", "translate", "Landroidx/window/area/WindowAreaCapability$Status;", "status", "", "sessionActive", "", "vendorApiLevel", "translate$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowAreaAdapter {
    @NotNull
    public static final WindowAreaAdapter INSTANCE;

    static {
        WindowAreaAdapter.INSTANCE = new WindowAreaAdapter();
    }

    @NotNull
    public final Status translate$window_release(int v, boolean z, int v1) {
        return v1 > 3 ? WindowAreaAdapterApi4.INSTANCE.translate(v) : WindowAreaAdapterApi3.INSTANCE.translate(v, z);
    }

    public static Status translate$window_release$default(WindowAreaAdapter windowAreaAdapter0, int v, boolean z, int v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            z = false;
        }
        if((v2 & 4) != 0) {
            v1 = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
        }
        return windowAreaAdapter0.translate$window_release(v, z, v1);
    }
}

