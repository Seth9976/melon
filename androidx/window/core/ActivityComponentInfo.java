package androidx.window.core;

import U4.x;
import android.content.ComponentName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0006H\u0016R\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/window/core/ActivityComponentInfo;", "", "componentName", "Landroid/content/ComponentName;", "(Landroid/content/ComponentName;)V", "packageName", "", "className", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getPackageName", "equals", "", "other", "hashCode", "", "toString", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ActivityComponentInfo {
    @NotNull
    private final String className;
    @NotNull
    private final String packageName;

    public ActivityComponentInfo(@NotNull ComponentName componentName0) {
        q.g(componentName0, "componentName");
        String s = componentName0.getPackageName();
        q.f(s, "getPackageName(...)");
        String s1 = componentName0.getClassName();
        q.f(s1, "getClassName(...)");
        this(s, s1);
    }

    public ActivityComponentInfo(@NotNull String s, @NotNull String s1) {
        q.g(s, "packageName");
        q.g(s1, "className");
        super();
        this.packageName = s;
        this.className = s1;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!ActivityComponentInfo.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type androidx.window.core.ActivityComponentInfo");
        return q.b(this.packageName, ((ActivityComponentInfo)object0).packageName) ? q.b(this.className, ((ActivityComponentInfo)object0).className) : false;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @Override
    public int hashCode() {
        return this.className.hashCode() + this.packageName.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ClassInfo { packageName: ");
        stringBuilder0.append(this.packageName);
        stringBuilder0.append(", className: ");
        return x.m(stringBuilder0, this.className, " }");
    }
}

