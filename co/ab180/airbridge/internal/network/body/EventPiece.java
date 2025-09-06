package co.ab180.airbridge.internal.network.body;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.h;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(h.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u000B\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\b¢\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\bHÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001C\u0010\r\u001A\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001A\u0004\b\u0017\u0010\nR\u001C\u0010\u000B\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u0018\u001A\u0004\b\u0019\u0010\u0004R\u001C\u0010\f\u001A\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001A\u001A\u0004\b\u001B\u0010\u0007¨\u0006\u001E"}, d2 = {"Lco/ab180/airbridge/internal/network/body/EventPiece;", "", "Lco/ab180/airbridge/internal/network/body/EventPieceHeader;", "component1", "()Lco/ab180/airbridge/internal/network/body/EventPieceHeader;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "header", "body", "eventCategory", "copy", "(Lco/ab180/airbridge/internal/network/body/EventPieceHeader;Ljava/lang/String;I)Lco/ab180/airbridge/internal/network/body/EventPiece;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getEventCategory", "Lco/ab180/airbridge/internal/network/body/EventPieceHeader;", "getHeader", "Ljava/lang/String;", "getBody", "<init>", "(Lco/ab180/airbridge/internal/network/body/EventPieceHeader;Ljava/lang/String;I)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class EventPiece {
    @d("body")
    @NotNull
    private final String body;
    @d("eventCategory")
    private final int eventCategory;
    @d("header")
    @NotNull
    private final EventPieceHeader header;

    public EventPiece(@NotNull EventPieceHeader eventPieceHeader0, @NotNull String s, int v) {
        this.header = eventPieceHeader0;
        this.body = s;
        this.eventCategory = v;
    }

    @NotNull
    public final EventPieceHeader component1() {
        return this.header;
    }

    @NotNull
    public final String component2() {
        return this.body;
    }

    public final int component3() {
        return this.eventCategory;
    }

    @NotNull
    public final EventPiece copy(@NotNull EventPieceHeader eventPieceHeader0, @NotNull String s, int v) {
        return new EventPiece(eventPieceHeader0, s, v);
    }

    public static EventPiece copy$default(EventPiece eventPiece0, EventPieceHeader eventPieceHeader0, String s, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            eventPieceHeader0 = eventPiece0.header;
        }
        if((v1 & 2) != 0) {
            s = eventPiece0.body;
        }
        if((v1 & 4) != 0) {
            v = eventPiece0.eventCategory;
        }
        return eventPiece0.copy(eventPieceHeader0, s, v);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof EventPiece && q.b(this.header, ((EventPiece)object0).header) && q.b(this.body, ((EventPiece)object0).body) && this.eventCategory == ((EventPiece)object0).eventCategory;
    }

    @NotNull
    public final String getBody() {
        return this.body;
    }

    public final int getEventCategory() {
        return this.eventCategory;
    }

    @NotNull
    public final EventPieceHeader getHeader() {
        return this.header;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.header == null ? 0 : this.header.hashCode();
        String s = this.body;
        if(s != null) {
            v = s.hashCode();
        }
        return this.eventCategory + (v1 * 0x1F + v) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EventPiece(header=");
        stringBuilder0.append(this.header);
        stringBuilder0.append(", body=");
        stringBuilder0.append(this.body);
        stringBuilder0.append(", eventCategory=");
        return x.g(this.eventCategory, ")", stringBuilder0);
    }
}

