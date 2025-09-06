package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import xe.a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\"$\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00000\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0002\u0010\u0003\"$\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001A\u0004\b\b\u0010\u0003¨\u0006\u000B"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "getElementDescriptors", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/Iterable;", "getElementDescriptors$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "elementDescriptors", "", "getElementNames", "getElementNames$annotations", "elementNames", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class SerialDescriptorKt {
    @NotNull
    public static final Iterable getElementDescriptors(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "<this>");
        return new Object() {
            @Override
            public Iterator iterator() {
                return new kotlinx.serialization.descriptors.SerialDescriptorKt.elementDescriptors.1.1(serialDescriptor0);
            }
        };

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001A\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001A\u00020\u0002H\u0096\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementDescriptors$1$1", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsLeft", "", "hasNext", "", "next", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
        public final class kotlinx.serialization.descriptors.SerialDescriptorKt.elementDescriptors.1.1 implements Iterator, a {
            private int elementsLeft;

            public kotlinx.serialization.descriptors.SerialDescriptorKt.elementDescriptors.1.1(SerialDescriptor serialDescriptor0) {
                this.elementsLeft = serialDescriptor0.getElementsCount();
            }

            @Override
            public boolean hasNext() {
                return this.elementsLeft > 0;
            }

            @Override
            public Object next() {
                return this.next();
            }

            public SerialDescriptor next() {
                int v = this.$this_elementDescriptors.getElementsCount();
                int v1 = this.elementsLeft;
                this.elementsLeft = v1 - 1;
                return this.$this_elementDescriptors.getElementDescriptor(v - v1);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

    }

    @NotNull
    public static final Iterable getElementNames(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "<this>");
        return new Object() {
            @Override
            public Iterator iterator() {
                return new kotlinx.serialization.descriptors.SerialDescriptorKt.elementNames.1.1(serialDescriptor0);
            }
        };

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001A\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001A\u00020\u0002H\u0096\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementNames$1$1", "", "", "elementsLeft", "", "hasNext", "", "next", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
        public final class kotlinx.serialization.descriptors.SerialDescriptorKt.elementNames.1.1 implements Iterator, a {
            private int elementsLeft;

            public kotlinx.serialization.descriptors.SerialDescriptorKt.elementNames.1.1(SerialDescriptor serialDescriptor0) {
                this.elementsLeft = serialDescriptor0.getElementsCount();
            }

            @Override
            public boolean hasNext() {
                return this.elementsLeft > 0;
            }

            @Override
            public Object next() {
                return this.next();
            }

            public String next() {
                int v = this.$this_elementNames.getElementsCount();
                int v1 = this.elementsLeft;
                this.elementsLeft = v1 - 1;
                return this.$this_elementNames.getElementName(v - v1);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

    }
}

