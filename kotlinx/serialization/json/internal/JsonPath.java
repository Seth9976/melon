package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001A\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0003J\r\u0010\u0014\u001A\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u001E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001B\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath;", "", "<init>", "()V", "Lie/H;", "resize", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "sd", "pushDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "updateDescriptorIndex", "(I)V", "key", "updateCurrentMapKey", "(Ljava/lang/Object;)V", "resetCurrentMapKey", "popDescriptor", "", "getPath", "()Ljava/lang/String;", "toString", "", "currentObjectPath", "[Ljava/lang/Object;", "", "indicies", "[I", "currentDepth", "I", "Tombstone", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonPath {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath$Tombstone;", "", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    static final class Tombstone {
        @NotNull
        public static final Tombstone INSTANCE;

        static {
            Tombstone.INSTANCE = new Tombstone();
        }
    }

    private int currentDepth;
    @NotNull
    private Object[] currentObjectPath;
    @NotNull
    private int[] indicies;

    public JsonPath() {
        this.currentObjectPath = new Object[8];
        int[] arr_v = new int[8];
        for(int v = 0; v < 8; ++v) {
            arr_v[v] = -1;
        }
        this.indicies = arr_v;
        this.currentDepth = -1;
    }

    @NotNull
    public final String getPath() [...] // 潜在的解密器

    public final void popDescriptor() {
        int v = this.currentDepth;
        int[] arr_v = this.indicies;
        if(arr_v[v] == -2) {
            arr_v[v] = -1;
            this.currentDepth = v - 1;
        }
        int v1 = this.currentDepth;
        if(v1 != -1) {
            this.currentDepth = v1 - 1;
        }
    }

    public final void pushDescriptor(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "sd");
        int v = this.currentDepth + 1;
        this.currentDepth = v;
        if(v == this.currentObjectPath.length) {
            this.resize();
        }
        this.currentObjectPath[v] = serialDescriptor0;
    }

    public final void resetCurrentMapKey() {
        int v = this.currentDepth;
        if(this.indicies[v] == -2) {
            this.currentObjectPath[v] = Tombstone.INSTANCE;
        }
    }

    private final void resize() {
        int v = this.currentDepth * 2;
        Object[] arr_object = Arrays.copyOf(this.currentObjectPath, v);
        q.f(arr_object, "copyOf(...)");
        this.currentObjectPath = arr_object;
        int[] arr_v = Arrays.copyOf(this.indicies, v);
        q.f(arr_v, "copyOf(...)");
        this.indicies = arr_v;
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "$";
    }

    public final void updateCurrentMapKey(@Nullable Object object0) {
        int v = this.currentDepth;
        if(this.indicies[v] != -2) {
            this.currentDepth = v + 1;
            if(v + 1 == this.currentObjectPath.length) {
                this.resize();
            }
        }
        int v1 = this.currentDepth;
        this.currentObjectPath[v1] = object0;
        this.indicies[v1] = -2;
    }

    public final void updateDescriptorIndex(int v) {
        this.indicies[this.currentDepth] = v;
    }
}

