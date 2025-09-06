package co.ab180.airbridge.internal.d0.g.a;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u000B\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\u000B\u001A\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n¨\u0006\u000E"}, d2 = {"Lco/ab180/airbridge/internal/d0/g/a/d;", "", "", "b", "()Ljava/lang/String;", "", "c", "()J", "a", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "origin", "<init>", "(Landroid/os/Bundle;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d {
    private final Bundle a;

    public d(@NotNull Bundle bundle0) {
        this.a = bundle0;
    }

    public final long a() {
        return this.a.getLong("install_begin_timestamp") / 1000L;
    }

    @Nullable
    public final String b() {
        return this.a.getString("install_referrer");
    }

    public final long c() {
        return this.a.getLong("referrer_click_timestamp") / 1000L;
    }
}

