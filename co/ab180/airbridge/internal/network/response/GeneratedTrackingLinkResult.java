package co.ab180.airbridge.internal.network.response;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.k;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(k.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0006\u001A\u00020\u00002\b\b\u0002\u0010\u0005\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001A\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0005\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001A\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkResult;", "", "Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;", "component1", "()Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;", "data", "copy", "(Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;)Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;", "getData", "<init>", "(Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class GeneratedTrackingLinkResult {
    @d("data")
    @NotNull
    private final GeneratedTrackingLinkInfo data;

    public GeneratedTrackingLinkResult(@NotNull GeneratedTrackingLinkInfo generatedTrackingLinkInfo0) {
        this.data = generatedTrackingLinkInfo0;
    }

    @NotNull
    public final GeneratedTrackingLinkInfo component1() {
        return this.data;
    }

    @NotNull
    public final GeneratedTrackingLinkResult copy(@NotNull GeneratedTrackingLinkInfo generatedTrackingLinkInfo0) {
        return new GeneratedTrackingLinkResult(generatedTrackingLinkInfo0);
    }

    public static GeneratedTrackingLinkResult copy$default(GeneratedTrackingLinkResult generatedTrackingLinkResult0, GeneratedTrackingLinkInfo generatedTrackingLinkInfo0, int v, Object object0) {
        if((v & 1) != 0) {
            generatedTrackingLinkInfo0 = generatedTrackingLinkResult0.data;
        }
        return generatedTrackingLinkResult0.copy(generatedTrackingLinkInfo0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof GeneratedTrackingLinkResult && q.b(this.data, ((GeneratedTrackingLinkResult)object0).data);
    }

    @NotNull
    public final GeneratedTrackingLinkInfo getData() {
        return this.data;
    }

    @Override
    public int hashCode() {
        return this.data == null ? 0 : this.data.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "GeneratedTrackingLinkResult(data=" + this.data + ")";
    }
}

