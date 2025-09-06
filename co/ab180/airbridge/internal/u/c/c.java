package co.ab180.airbridge.internal.u.c;

import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\'\u0010\b\u001A\u00020\u00072\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\'\u0010\n\u001A\u00020\u00072\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u001F\u0010\n\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\u0003H&¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\n\u001A\u00020\rH&¢\u0006\u0004\b\n\u0010\u0011¨\u0006\u0012"}, d2 = {"Lco/ab180/airbridge/internal/u/c/c;", "", "Lco/ab180/airbridge/common/OnSuccess;", "", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "", "c", "(Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "b", "key", "value", "Lie/H;", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "(Ljava/lang/String;)V", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface c {
    void a(@NotNull String arg1);

    void b();

    void b(@NotNull String arg1, @NotNull String arg2);

    boolean b(@NotNull OnSuccess arg1, @Nullable OnFailure arg2);

    boolean c(@NotNull OnSuccess arg1, @Nullable OnFailure arg2);
}

