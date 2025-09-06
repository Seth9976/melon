package co.ab180.airbridge.internal.d0.f.a;

import android.os.Bundle;
import ie.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@d
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u000E¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u0007J\u000F\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\n¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u0010\u001A\u00020\u000E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000F¨\u0006\u0013"}, d2 = {"Lco/ab180/airbridge/internal/d0/f/a/d;", "", "", "f", "()Ljava/lang/Integer;", "", "a", "()Ljava/lang/String;", "d", "c", "", "e", "()J", "b", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "origin", "<init>", "(Landroid/os/Bundle;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class co.ab180.airbridge.internal.d0.f.a.d {
    private final Bundle a;

    public co.ab180.airbridge.internal.d0.f.a.d(@NotNull Bundle bundle0) {
        this.a = bundle0;
    }

    @Nullable
    public final String a() {
        return this.a.getString("description");
    }

    public final long b() {
        return this.a.getLong("install_begin_timestamp_seconds");
    }

    @Nullable
    public final String c() {
        return this.a.getString("install_referrer");
    }

    @Nullable
    public final String d() {
        return this.a.getString("onestore_pid");
    }

    public final long e() {
        return this.a.getLong("referrer_click_timestamp_seconds");
    }

    @Nullable
    public final Integer f() {
        return this.a.getInt("result_code");
    }
}

