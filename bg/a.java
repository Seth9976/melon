package bg;

import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import we.k;

public final class a implements k {
    public final int a;
    public final SealedClassSerializer b;

    public a(SealedClassSerializer sealedClassSerializer0, int v) {
        this.a = v;
        this.b = sealedClassSerializer0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? SealedClassSerializer.a(this.b, ((ClassSerialDescriptorBuilder)object0)) : SealedClassSerializer.b(this.b, ((ClassSerialDescriptorBuilder)object0));
    }
}

