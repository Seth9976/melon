package androidx.window.layout;

import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2 = {"Landroidx/window/layout/WindowLayoutInfo;", "", "displayFeatures", "", "Landroidx/window/layout/DisplayFeature;", "(Ljava/util/List;)V", "getDisplayFeatures", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowLayoutInfo {
    @NotNull
    private final List displayFeatures;

    public WindowLayoutInfo(@NotNull List list0) {
        q.g(list0, "displayFeatures");
        super();
        this.displayFeatures = list0;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return WindowLayoutInfo.class.equals(class0) ? q.b(this.displayFeatures, ((WindowLayoutInfo)object0).displayFeatures) : false;
        }
        return false;
    }

    @NotNull
    public final List getDisplayFeatures() {
        return this.displayFeatures;
    }

    @Override
    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return p.q0(this.displayFeatures, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}

