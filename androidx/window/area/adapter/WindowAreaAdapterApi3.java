package androidx.window.area.adapter;

import androidx.window.area.WindowAreaCapability.Status;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b¨\u0006\t"}, d2 = {"Landroidx/window/area/adapter/WindowAreaAdapterApi3;", "", "()V", "translate", "Landroidx/window/area/WindowAreaCapability$Status;", "status", "", "sessionActive", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowAreaAdapterApi3 {
    @NotNull
    public static final WindowAreaAdapterApi3 INSTANCE;

    static {
        WindowAreaAdapterApi3.INSTANCE = new WindowAreaAdapterApi3();
    }

    @NotNull
    public final Status translate(int v, boolean z) {
        switch(v) {
            case 0: {
                return Status.WINDOW_AREA_STATUS_UNSUPPORTED;
            }
            case 1: {
                return z ? Status.WINDOW_AREA_STATUS_ACTIVE : Status.WINDOW_AREA_STATUS_UNAVAILABLE;
            }
            case 2: {
                return Status.WINDOW_AREA_STATUS_AVAILABLE;
            }
            case 3: {
                return Status.WINDOW_AREA_STATUS_ACTIVE;
            }
            default: {
                return Status.WINDOW_AREA_STATUS_UNSUPPORTED;
            }
        }
    }
}

