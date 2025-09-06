package co.ab180.airbridge.internal.network.body;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(x.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001C\u0010\b\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001A\u0004\b\u0015\u0010\u0004R\u001C\u0010\t\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/internal/network/body/ReportPiece;", "", "", "component1", "()Ljava/lang/String;", "Lco/ab180/airbridge/internal/network/body/LogData;", "component2", "()Lco/ab180/airbridge/internal/network/body/LogData;", "logLevel", "data", "copy", "(Ljava/lang/String;Lco/ab180/airbridge/internal/network/body/LogData;)Lco/ab180/airbridge/internal/network/body/ReportPiece;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getLogLevel", "Lco/ab180/airbridge/internal/network/body/LogData;", "getData", "<init>", "(Ljava/lang/String;Lco/ab180/airbridge/internal/network/body/LogData;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class ReportPiece {
    @d("data")
    @NotNull
    private final LogData data;
    @d("logLevel")
    @NotNull
    private final String logLevel;

    public ReportPiece(@NotNull String s, @NotNull LogData logData0) {
        this.logLevel = s;
        this.data = logData0;
    }

    @NotNull
    public final String component1() {
        return this.logLevel;
    }

    @NotNull
    public final LogData component2() {
        return this.data;
    }

    @NotNull
    public final ReportPiece copy(@NotNull String s, @NotNull LogData logData0) {
        return new ReportPiece(s, logData0);
    }

    public static ReportPiece copy$default(ReportPiece reportPiece0, String s, LogData logData0, int v, Object object0) {
        if((v & 1) != 0) {
            s = reportPiece0.logLevel;
        }
        if((v & 2) != 0) {
            logData0 = reportPiece0.data;
        }
        return reportPiece0.copy(s, logData0);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof ReportPiece && q.b(this.logLevel, ((ReportPiece)object0).logLevel) && q.b(this.data, ((ReportPiece)object0).data);
    }

    @NotNull
    public final LogData getData() {
        return this.data;
    }

    @NotNull
    public final String getLogLevel() {
        return this.logLevel;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.logLevel == null ? 0 : this.logLevel.hashCode();
        LogData logData0 = this.data;
        if(logData0 != null) {
            v = logData0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "ReportPiece(logLevel=" + this.logLevel + ", data=" + this.data + ")";
    }
}

