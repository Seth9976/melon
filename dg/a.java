package dg;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.PairSerializer;
import we.k;

public final class a implements k {
    public final int a;
    public final KSerializer b;
    public final KSerializer c;

    public a(KSerializer kSerializer0, KSerializer kSerializer1, int v) {
        this.a = v;
        this.b = kSerializer0;
        this.c = kSerializer1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? MapEntrySerializer.a(this.b, this.c, ((ClassSerialDescriptorBuilder)object0)) : PairSerializer.a(this.b, this.c, ((ClassSerialDescriptorBuilder)object0));
    }
}

