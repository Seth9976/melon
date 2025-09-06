package com.kakao.sdk.common.json;

import ie.H;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "Lie/H;", "invoke", "(Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class MapToQuerySerializer.descriptor.1 extends r implements k {
    public static final MapToQuerySerializer.descriptor.1 INSTANCE;

    static {
        MapToQuerySerializer.descriptor.1.INSTANCE = new MapToQuerySerializer.descriptor.1();
    }

    public MapToQuerySerializer.descriptor.1() {
        super(1);
    }

    @Override  // we.k
    public Object invoke(Object object0) {
        this.invoke(((ClassSerialDescriptorBuilder)object0));
        return H.a;
    }

    public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
        classSerialDescriptorBuilder0.element("query", StringSerializer.INSTANCE.getDescriptor(), w.a, false);
    }
}

