package dg;

import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.internal.TaggedDecoder;
import we.a;

public final class c implements a {
    public final int a;
    public final TaggedDecoder b;
    public final DeserializationStrategy c;
    public final Object d;

    public c(TaggedDecoder taggedDecoder0, DeserializationStrategy deserializationStrategy0, Object object0, int v) {
        this.a = v;
        this.b = taggedDecoder0;
        this.c = deserializationStrategy0;
        this.d = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? TaggedDecoder.b(this.b, this.c, this.d) : TaggedDecoder.a(this.b, this.c, this.d);
    }
}

