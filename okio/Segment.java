package okio;

import java.util.Arrays;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\t¢\u0006\u0004\b\u0002\u0010\fJ\r\u0010\r\u001A\u00020\u0000¢\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\u0000¢\u0006\u0004\b\u000F\u0010\u000EJ\u000F\u0010\u0010\u001A\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0010\u0010\u000EJ\u0015\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001A\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0003J\u001D\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u0006¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001CR\u0016\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\u001DR\u0016\u0010\b\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\b\u0010\u001DR\u0016\u0010\n\u001A\u00020\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\n\u0010\u001ER\u0016\u0010\u000B\u001A\u00020\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u000B\u0010\u001ER\u0018\u0010\u001F\u001A\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0018\u0010!\u001A\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b!\u0010 ¨\u0006#"}, d2 = {"Lokio/Segment;", "", "<init>", "()V", "", "data", "", "pos", "limit", "", "shared", "owner", "([BIIZZ)V", "sharedCopy", "()Lokio/Segment;", "unsharedCopy", "pop", "segment", "push", "(Lokio/Segment;)Lokio/Segment;", "byteCount", "split", "(I)Lokio/Segment;", "Lie/H;", "compact", "sink", "writeTo", "(Lokio/Segment;I)V", "[B", "I", "Z", "next", "Lokio/Segment;", "prev", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Segment {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lokio/Segment$Companion;", "", "<init>", "()V", "SIZE", "", "SHARE_MINIMUM", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int SHARE_MINIMUM = 0x400;
    public static final int SIZE = 0x2000;
    @NotNull
    public final byte[] data;
    public int limit;
    @Nullable
    public Segment next;
    public boolean owner;
    public int pos;
    @Nullable
    public Segment prev;
    public boolean shared;

    static {
        Segment.Companion = new Companion(null);
    }

    public Segment() {
        this.data = new byte[0x2000];
        this.owner = true;
        this.shared = false;
    }

    public Segment(@NotNull byte[] arr_b, int v, int v1, boolean z, boolean z1) {
        q.g(arr_b, "data");
        super();
        this.data = arr_b;
        this.pos = v;
        this.limit = v1;
        this.shared = z;
        this.owner = z1;
    }

    public final void compact() {
        int v2;
        Segment segment0 = this.prev;
        if(segment0 == this) {
            throw new IllegalStateException("cannot compact");
        }
        q.d(segment0);
        if(segment0.owner) {
            int v = this.limit - this.pos;
            Segment segment1 = this.prev;
            q.d(segment1);
            int v1 = 0x2000 - segment1.limit;
            Segment segment2 = this.prev;
            q.d(segment2);
            if(segment2.shared) {
                v2 = 0;
            }
            else {
                Segment segment3 = this.prev;
                q.d(segment3);
                v2 = segment3.pos;
            }
            if(v <= v1 + v2) {
                Segment segment4 = this.prev;
                q.d(segment4);
                this.writeTo(segment4, v);
                this.pop();
                SegmentPool.recycle(this);
            }
        }
    }

    @Nullable
    public final Segment pop() {
        Segment segment0 = this.next == this ? null : this.next;
        Segment segment1 = this.prev;
        q.d(segment1);
        segment1.next = this.next;
        Segment segment2 = this.next;
        q.d(segment2);
        segment2.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment0;
    }

    @NotNull
    public final Segment push(@NotNull Segment segment0) {
        q.g(segment0, "segment");
        segment0.prev = this;
        segment0.next = this.next;
        Segment segment1 = this.next;
        q.d(segment1);
        segment1.prev = segment0;
        this.next = segment0;
        return segment0;
    }

    @NotNull
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    @NotNull
    public final Segment split(int v) {
        Segment segment0;
        if(v <= 0 || v > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if(v >= 0x400) {
            segment0 = this.sharedCopy();
        }
        else {
            segment0 = SegmentPool.take();
            n.T(this.data, 0, this.pos, segment0.data, this.pos + v);
        }
        segment0.limit = segment0.pos + v;
        this.pos += v;
        Segment segment1 = this.prev;
        q.d(segment1);
        segment1.push(segment0);
        return segment0;
    }

    @NotNull
    public final Segment unsharedCopy() {
        byte[] arr_b = Arrays.copyOf(this.data, this.data.length);
        q.f(arr_b, "copyOf(...)");
        return new Segment(arr_b, this.pos, this.limit, false, true);
    }

    public final void writeTo(@NotNull Segment segment0, int v) {
        q.g(segment0, "sink");
        if(!segment0.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int v1 = segment0.limit;
        int v2 = v1 + v;
        if(v2 > 0x2000) {
            if(segment0.shared) {
                throw new IllegalArgumentException();
            }
            int v3 = segment0.pos;
            if(v2 - v3 > 0x2000) {
                throw new IllegalArgumentException();
            }
            n.T(segment0.data, 0, v3, segment0.data, v1);
            segment0.limit -= segment0.pos;
            segment0.pos = 0;
        }
        n.T(this.data, segment0.limit, this.pos, segment0.data, this.pos + v);
        segment0.limit += v;
        this.pos += v;
    }
}

