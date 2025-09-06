package co.ab180.airbridge.internal.e0;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0005\u001A\u00020\u0007H\u0000¢\u0006\u0004\b\u0005\u0010\b¨\u0006\u000B"}, d2 = {"Lco/ab180/airbridge/internal/e0/h;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)Z", "", "()Ljava/lang/String;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class h {
    @NotNull
    public static final h a;

    static {
        h.a = new h();
    }

    @NotNull
    public final String a() [...] // Inlined contents

    public final boolean a(@NotNull Context context0) {
        return context0.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
    }
}

