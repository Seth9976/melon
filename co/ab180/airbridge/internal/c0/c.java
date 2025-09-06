package co.ab180.airbridge.internal.c0;

import co.ab180.airbridge.internal.network.body.LogData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005JG\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u00062\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\nH&¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0010\u001A\u00020\nH&¢\u0006\u0004\b\u0010\u0010\u0015J!\u0010\u0018\u001A\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\u001BH&¢\u0006\u0004\b\u0010\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u000FH&¢\u0006\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lco/ab180/airbridge/internal/c0/c;", "", "", "Lco/ab180/airbridge/internal/c0/a;", "e", "()Ljava/util/List;", "", "uuid", "", "type", "", "createdAt", "bodyJsonString", "secretId", "signature", "Lie/H;", "a", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "eventUUID", "(Ljava/lang/String;)V", "d", "()J", "", "Lco/ab180/airbridge/internal/c0/b;", "c", "()Ljava/util/Map;", "priority", "Lco/ab180/airbridge/internal/network/body/LogData;", "log", "(ILco/ab180/airbridge/internal/network/body/LogData;)V", "b", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface c {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        public static void a(c c0, String s, int v, long v1, String s1, String s2, String s3, int v2, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertEventEntity");
            }
            if((v2 & 16) != 0) {
                s2 = null;
            }
            if((v2 & 0x20) != 0) {
                s3 = null;
            }
            c0.a(s, v, v1, s1, s2, s3);
        }
    }

    long a();

    void a(int arg1, @NotNull LogData arg2);

    void a(@NotNull String arg1);

    void a(@NotNull String arg1, int arg2, long arg3, @NotNull String arg4, @Nullable String arg5, @Nullable String arg6);

    void b();

    @NotNull
    Map c();

    long d();

    @NotNull
    List e();
}

