package co.ab180.airbridge.internal.network.body;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.g;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(g.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0007\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0007\u001A\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001C\u0010\b\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001A\u0004\b\u0015\u0010\u0004R\u001C\u0010\u0007\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001A\u0004\b\u0016\u0010\u0004R\u001C\u0010\t\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001A\u0004\b\u0017\u0010\u0004¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/internal/network/body/EventPieceHeader;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "signature", "timestamp", "secretId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lco/ab180/airbridge/internal/network/body/EventPieceHeader;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTimestamp", "getSignature", "getSecretId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class EventPieceHeader {
    @d("X-Airbridge-Signature-Secret-ID")
    @NotNull
    private final String secretId;
    @d("X-Airbridge-Signature")
    @NotNull
    private final String signature;
    @d("X-Airbridge-Signature-Timestamp")
    @NotNull
    private final String timestamp;

    public EventPieceHeader(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        this.signature = s;
        this.timestamp = s1;
        this.secretId = s2;
    }

    @NotNull
    public final String component1() {
        return this.signature;
    }

    @NotNull
    public final String component2() {
        return this.timestamp;
    }

    @NotNull
    public final String component3() {
        return this.secretId;
    }

    @NotNull
    public final EventPieceHeader copy(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        return new EventPieceHeader(s, s1, s2);
    }

    public static EventPieceHeader copy$default(EventPieceHeader eventPieceHeader0, String s, String s1, String s2, int v, Object object0) {
        if((v & 1) != 0) {
            s = eventPieceHeader0.signature;
        }
        if((v & 2) != 0) {
            s1 = eventPieceHeader0.timestamp;
        }
        if((v & 4) != 0) {
            s2 = eventPieceHeader0.secretId;
        }
        return eventPieceHeader0.copy(s, s1, s2);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof EventPieceHeader && q.b(this.signature, ((EventPieceHeader)object0).signature) && q.b(this.timestamp, ((EventPieceHeader)object0).timestamp) && q.b(this.secretId, ((EventPieceHeader)object0).secretId);
    }

    @NotNull
    public final String getSecretId() {
        return this.secretId;
    }

    @NotNull
    public final String getSignature() {
        return this.signature;
    }

    @NotNull
    public final String getTimestamp() {
        return this.timestamp;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.signature == null ? 0 : this.signature.hashCode();
        int v2 = this.timestamp == null ? 0 : this.timestamp.hashCode();
        String s = this.secretId;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EventPieceHeader(signature=");
        stringBuilder0.append(this.signature);
        stringBuilder0.append(", timestamp=");
        stringBuilder0.append(this.timestamp);
        stringBuilder0.append(", secretId=");
        return x.m(stringBuilder0, this.secretId, ")");
    }
}

