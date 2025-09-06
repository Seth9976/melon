package com.kakao.sdk.common.json;

import ie.H;
import java.io.IOException;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0016\u0018\u0000*\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00028\u00002\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R \u0010\u0014\u001A\u00020\u00138\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u0016\u0010\u0017R\u001A\u0010\u001D\u001A\u0004\u0018\u00010\u001A*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/kakao/sdk/common/json/GenericEnumSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "Ljava/lang/Class;", "enumClass", "<init>", "(Ljava/lang/Class;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "Ljava/lang/Class;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "", "getSerialName", "(Ljava/lang/Enum;)Ljava/lang/String;", "serialName", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class GenericEnumSerializer implements KSerializer {
    @NotNull
    private final SerialDescriptor descriptor;
    @NotNull
    private final Class enumClass;

    public GenericEnumSerializer(@NotNull Class class0) {
        q.g(class0, "enumClass");
        super();
        this.enumClass = class0;
        com.kakao.sdk.common.json.GenericEnumSerializer.descriptor.1 genericEnumSerializer$descriptor$10 = new k() {
            {
                GenericEnumSerializer.this = genericEnumSerializer0;
                super(1);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((ClassSerialDescriptorBuilder)object0));
                return H.a;
            }

            public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
                q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
                Object[] arr_object = GenericEnumSerializer.access$getEnumClass$p(GenericEnumSerializer.this).getEnumConstants();
                q.d(arr_object);
                for(int v = 0; v < ((Enum[])arr_object).length; ++v) {
                    classSerialDescriptorBuilder0.element(((Enum[])arr_object)[v].name(), StringSerializer.INSTANCE.getDescriptor(), w.a, false);
                }
            }
        };
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor(class0.getSimpleName(), ENUM.INSTANCE, new SerialDescriptor[0], genericEnumSerializer$descriptor$10);
    }

    public static final Class access$getEnumClass$p(GenericEnumSerializer genericEnumSerializer0) {
        return genericEnumSerializer0.enumClass;
    }

    @NotNull
    public Enum deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        String s = decoder0.decodeString();
        Enum[] arr_enum = (Enum[])this.enumClass.getEnumConstants();
        Enum enum0 = null;
        if(arr_enum != null) {
            int v = 0;
            while(v < arr_enum.length) {
                Enum enum1 = arr_enum[v];
                if(!q.b(enum1.name(), s) && !q.b(this.getSerialName(enum1), s)) {
                    if(((UnknownValue)this.enumClass.getField(enum1.name()).getAnnotation(UnknownValue.class)) != null) {
                        enum0 = enum1;
                    }
                    ++v;
                    continue;
                }
                return enum1;
            }
        }
        if(enum0 == null) {
            throw new IOException("No matching enum field");
        }
        return enum0;
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public static void getDescriptor$annotations() {
    }

    private final String getSerialName(Enum enum0) {
        SerialName serialName0 = (SerialName)enum0.getClass().getField(enum0.name()).getAnnotation(SerialName.class);
        return serialName0 == null ? null : serialName0.value();
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull Enum enum0) {
        q.g(encoder0, "encoder");
        q.g(enum0, "value");
        String s = this.getSerialName(enum0);
        if(s == null) {
            s = enum0.name();
        }
        encoder0.encodeString(s);
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((Enum)object0));
    }
}

