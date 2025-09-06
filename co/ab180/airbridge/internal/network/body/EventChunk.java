package co.ab180.airbridge.internal.network.body;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.e;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(e.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001A\u00020\u00002\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001A\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/network/body/EventChunk;", "", "", "Lco/ab180/airbridge/internal/network/body/EventPiece;", "component1", "()Ljava/util/List;", "events", "copy", "(Ljava/util/List;)Lco/ab180/airbridge/internal/network/body/EventChunk;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getEvents", "<init>", "(Ljava/util/List;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class EventChunk {
    @d("events")
    @NotNull
    private final List events;

    public EventChunk(@NotNull List list0) {
        this.events = list0;
    }

    @NotNull
    public final List component1() {
        return this.events;
    }

    @NotNull
    public final EventChunk copy(@NotNull List list0) {
        return new EventChunk(list0);
    }

    public static EventChunk copy$default(EventChunk eventChunk0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = eventChunk0.events;
        }
        return eventChunk0.copy(list0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof EventChunk && q.b(this.events, ((EventChunk)object0).events);
    }

    @NotNull
    public final List getEvents() {
        return this.events;
    }

    @Override
    public int hashCode() {
        return this.events == null ? 0 : this.events.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return Y.m(new StringBuilder("EventChunk(events="), this.events, ")");
    }
}

