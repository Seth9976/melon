package androidx.window.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u000F\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001A\u00020\u0003H\u0016J\b\u0010\t\u001A\u00020\nH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/window/layout/SupportedPosture;", "", "rawValue", "", "(I)V", "equals", "", "other", "hashCode", "toString", "", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SupportedPosture {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/window/layout/SupportedPosture$Companion;", "", "()V", "TABLETOP", "Landroidx/window/layout/SupportedPosture;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final SupportedPosture TABLETOP;
    private final int rawValue;

    static {
        SupportedPosture.Companion = new Companion(null);
        SupportedPosture.TABLETOP = new SupportedPosture(0);
    }

    public SupportedPosture(int v) {
        this.rawValue = v;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        return object0.getClass() == SupportedPosture.class ? this.rawValue == ((SupportedPosture)object0).rawValue : false;
    }

    @Override
    public int hashCode() {
        return this.rawValue;
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return this.equals(SupportedPosture.TABLETOP) ? "TABLETOP" : "UNKNOWN";
    }
}

