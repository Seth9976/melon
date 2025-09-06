package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB)\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0015\u001A\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R&\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lkotlinx/serialization/internal/ElementMarker;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlin/Function2;", "", "", "readIfAbsent", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lwe/n;)V", "elementsCount", "", "prepareHighMarksArray", "(I)[J", "index", "Lie/H;", "markHigh", "(I)V", "nextUnmarkedHighIndex", "()I", "mark", "nextUnmarkedIndex", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lwe/n;", "", "lowerMarks", "J", "highMarksArray", "[J", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ElementMarker {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/internal/ElementMarker$Companion;", "", "<init>", "()V", "EMPTY_HIGH_MARKS", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    private static final Companion Companion;
    @NotNull
    private static final long[] EMPTY_HIGH_MARKS;
    @NotNull
    private final SerialDescriptor descriptor;
    @NotNull
    private final long[] highMarksArray;
    private long lowerMarks;
    @NotNull
    private final n readIfAbsent;

    static {
        ElementMarker.Companion = new Companion(null);
        ElementMarker.EMPTY_HIGH_MARKS = new long[0];
    }

    public ElementMarker(@NotNull SerialDescriptor serialDescriptor0, @NotNull n n0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(n0, "readIfAbsent");
        super();
        this.descriptor = serialDescriptor0;
        this.readIfAbsent = n0;
        int v = serialDescriptor0.getElementsCount();
        long v1 = 0L;
        if(v <= 0x40) {
            if(v != 0x40) {
                v1 = -1L << v;
            }
            this.lowerMarks = v1;
            this.highMarksArray = ElementMarker.EMPTY_HIGH_MARKS;
            return;
        }
        this.lowerMarks = 0L;
        this.highMarksArray = this.prepareHighMarksArray(v);
    }

    public final void mark(int v) {
        if(v < 0x40) {
            this.lowerMarks |= 1L << v;
            return;
        }
        this.markHigh(v);
    }

    private final void markHigh(int v) {
        int v1 = (v >>> 6) - 1;
        this.highMarksArray[v1] |= 1L << (v & 0x3F);
    }

    private final int nextUnmarkedHighIndex() {
        for(int v = 0; v < this.highMarksArray.length; ++v) {
            int v1 = (v + 1) * 0x40;
            long v2 = this.highMarksArray[v];
            while(v2 != -1L) {
                int v3 = Long.numberOfTrailingZeros(~v2);
                v2 |= 1L << v3;
                int v4 = v3 + v1;
                if(((Boolean)this.readIfAbsent.invoke(this.descriptor, v4)).booleanValue()) {
                    this.highMarksArray[v] = v2;
                    return v4;
                }
                if(false) {
                    break;
                }
            }
            this.highMarksArray[v] = -1L;
        }
        return -1;
    }

    public final int nextUnmarkedIndex() {
        int v = this.descriptor.getElementsCount();
        long v1;
        while((v1 = this.lowerMarks) != -1L) {
            int v2 = Long.numberOfTrailingZeros(~v1);
            this.lowerMarks |= 1L << v2;
            if(((Boolean)this.readIfAbsent.invoke(this.descriptor, v2)).booleanValue()) {
                return v2;
            }
        }
        return v <= 0x40 ? -1 : this.nextUnmarkedHighIndex();
    }

    private final long[] prepareHighMarksArray(int v) {
        int v1 = v - 1 >>> 6;
        long[] arr_v = new long[v1];
        if((v & 0x3F) != 0) {
            arr_v[v1 - 1] = -1L << v;
        }
        return arr_v;
    }
}

