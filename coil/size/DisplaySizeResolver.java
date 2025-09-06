package coil.size;

import android.content.Context;
import android.util.DisplayMetrics;
import i5.k;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import u5.a;
import u5.g;
import u5.h;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcoil/size/DisplaySizeResolver;", "Lu5/h;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class DisplaySizeResolver implements h {
    public final Context a;

    public DisplaySizeResolver(@NotNull Context context0) {
        this.a = context0;
    }

    @Override  // u5.h
    public final Object c(k k0) {
        DisplayMetrics displayMetrics0 = this.a.getResources().getDisplayMetrics();
        a a0 = new a(Math.max(displayMetrics0.widthPixels, displayMetrics0.heightPixels));
        return new g(a0, a0);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof DisplaySizeResolver && q.b(this.a, ((DisplaySizeResolver)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

