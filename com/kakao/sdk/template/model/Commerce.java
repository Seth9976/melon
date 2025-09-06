package com.kakao.sdk.template.model;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002>=BY\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u000B\u0010\fBm\b\u0017\u0012\u0006\u0010\r\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u000B\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0014J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0014J\u0012\u0010\u0017\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0014Jb\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0007H\u00D6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u0018J\u0010\u0010\u001E\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u0012J\u001A\u0010!\u001A\u00020 2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b!\u0010\"J(\u0010)\u001A\u00020(2\u0006\u0010#\u001A\u00020\u00002\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&H\u00C7\u0001\u00A2\u0006\u0004\b)\u0010*R \u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010+\u0012\u0004\b-\u0010.\u001A\u0004\b,\u0010\u0012R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010/\u0012\u0004\b1\u0010.\u001A\u0004\b0\u0010\u0014R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u0010/\u0012\u0004\b3\u0010.\u001A\u0004\b2\u0010\u0014R\"\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u0010/\u0012\u0004\b5\u0010.\u001A\u0004\b4\u0010\u0014R\"\u0010\b\u001A\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\b\u00106\u0012\u0004\b8\u0010.\u001A\u0004\b7\u0010\u0018R\"\u0010\t\u001A\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\t\u00106\u0012\u0004\b:\u0010.\u001A\u0004\b9\u0010\u0018R\"\u0010\n\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\n\u0010/\u0012\u0004\b<\u0010.\u001A\u0004\b;\u0010\u0014\u00A8\u0006?"}, d2 = {"Lcom/kakao/sdk/template/model/Commerce;", "", "", "regularPrice", "discountPrice", "fixedDiscountPrice", "discountRate", "", "productName", "currencyUnit", "currencyUnitPosition", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()I", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "()Ljava/lang/String;", "component6", "component7", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/kakao/sdk/template/model/Commerce;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/Commerce;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "I", "getRegularPrice", "getRegularPrice$annotations", "()V", "Ljava/lang/Integer;", "getDiscountPrice", "getDiscountPrice$annotations", "getFixedDiscountPrice", "getFixedDiscountPrice$annotations", "getDiscountRate", "getDiscountRate$annotations", "Ljava/lang/String;", "getProductName", "getProductName$annotations", "getCurrencyUnit", "getCurrencyUnit$annotations", "getCurrencyUnitPosition", "getCurrencyUnitPosition$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class Commerce {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/Commerce.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/Commerce;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/Commerce;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/Commerce;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer commerce$$serializer0 = new .serializer();
            .serializer.INSTANCE = commerce$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.Commerce", commerce$$serializer0, 7);
            pluginGeneratedSerialDescriptor0.addElement("regular_price", false);
            pluginGeneratedSerialDescriptor0.addElement("discount_price", true);
            pluginGeneratedSerialDescriptor0.addElement("fixed_discount_price", true);
            pluginGeneratedSerialDescriptor0.addElement("discount_rate", true);
            pluginGeneratedSerialDescriptor0.addElement("product_name", true);
            pluginGeneratedSerialDescriptor0.addElement("currency_unit", true);
            pluginGeneratedSerialDescriptor0.addElement("currency_unit_position", true);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
            KSerializer kSerializer3 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer4 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer5 = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
            return new KSerializer[]{IntSerializer.INSTANCE, kSerializer0, kSerializer1, kSerializer2, kSerializer3, kSerializer4, kSerializer5};
        }

        @NotNull
        public Commerce deserialize(@NotNull Decoder decoder0) {
            int v1;
            Object object5;
            Object object4;
            Object object3;
            Object object2;
            Object object1;
            Object object0;
            int v;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                v = compositeDecoder0.decodeIntElement(serialDescriptor0, 0);
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, IntSerializer.INSTANCE, null);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, IntSerializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, IntSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, null);
                object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, IntSerializer.INSTANCE, null);
                v1 = 0x7F;
            }
            else {
                v = 0;
                Object object6 = null;
                Object object7 = null;
                Object object8 = null;
                Object object9 = null;
                Object object10 = null;
                int v2 = 0;
                Object object11 = null;
                boolean z = true;
                while(z) {
                    int v3 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v3) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            v = compositeDecoder0.decodeIntElement(serialDescriptor0, 0);
                            v2 |= 1;
                            break;
                        }
                        case 1: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, IntSerializer.INSTANCE, object6);
                            v2 |= 2;
                            break;
                        }
                        case 2: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, IntSerializer.INSTANCE, object7);
                            v2 |= 4;
                            break;
                        }
                        case 3: {
                            object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, IntSerializer.INSTANCE, object8);
                            v2 |= 8;
                            break;
                        }
                        case 4: {
                            object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, object9);
                            v2 |= 16;
                            break;
                        }
                        case 5: {
                            object10 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, object10);
                            v2 |= 0x20;
                            break;
                        }
                        case 6: {
                            object11 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, IntSerializer.INSTANCE, object11);
                            v2 |= 0x40;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v3);
                        }
                    }
                }
                object5 = object11;
                v1 = v2;
                object0 = object6;
                object1 = object7;
                object2 = object8;
                object3 = object9;
                object4 = object10;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new Commerce(v1, v, ((Integer)object0), ((Integer)object1), ((Integer)object2), ((String)object3), ((String)object4), ((Integer)object5), null);
        }

        @Override  // kotlinx.serialization.DeserializationStrategy
        public Object deserialize(Decoder decoder0) {
            return this.deserialize(decoder0);
        }

        @Override  // kotlinx.serialization.KSerializer
        @NotNull
        public SerialDescriptor getDescriptor() {
            return .serializer.descriptor;
        }

        public void serialize(@NotNull Encoder encoder0, @NotNull Commerce commerce0) {
            q.g(encoder0, "encoder");
            q.g(commerce0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            Commerce.write$Self(commerce0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((Commerce)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/Commerce$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/Commerce;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final KSerializer serializer() {
            return .serializer.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private final String currencyUnit;
    @Nullable
    private final Integer currencyUnitPosition;
    @Nullable
    private final Integer discountPrice;
    @Nullable
    private final Integer discountRate;
    @Nullable
    private final Integer fixedDiscountPrice;
    @Nullable
    private final String productName;
    private final int regularPrice;

    static {
        Commerce.Companion = new Companion(null);
    }

    public Commerce(int v) {
        this(v, null, null, null, null, null, null, 0x7E, null);
    }

    @d
    public Commerce(int v, @SerialName("regular_price") int v1, @SerialName("discount_price") Integer integer0, @SerialName("fixed_discount_price") Integer integer1, @SerialName("discount_rate") Integer integer2, @SerialName("product_name") String s, @SerialName("currency_unit") String s1, @SerialName("currency_unit_position") Integer integer3, SerializationConstructorMarker serializationConstructorMarker0) {
        if(1 != (v & 1)) {
            PluginExceptionsKt.throwMissingFieldException(v, 1, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.regularPrice = v1;
        this.discountPrice = (v & 2) == 0 ? null : integer0;
        this.fixedDiscountPrice = (v & 4) == 0 ? null : integer1;
        this.discountRate = (v & 8) == 0 ? null : integer2;
        this.productName = (v & 16) == 0 ? null : s;
        this.currencyUnit = (v & 0x20) == 0 ? null : s1;
        if((v & 0x40) == 0) {
            this.currencyUnitPosition = null;
            return;
        }
        this.currencyUnitPosition = integer3;
    }

    public Commerce(int v, @Nullable Integer integer0) {
        this(v, integer0, null, null, null, null, null, 0x7C, null);
    }

    public Commerce(int v, @Nullable Integer integer0, @Nullable Integer integer1) {
        this(v, integer0, integer1, null, null, null, null, 120, null);
    }

    public Commerce(int v, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2) {
        this(v, integer0, integer1, integer2, null, null, null, 0x70, null);
    }

    public Commerce(int v, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable String s) {
        this(v, integer0, integer1, integer2, s, null, null, 0x60, null);
    }

    public Commerce(int v, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable String s, @Nullable String s1) {
        this(v, integer0, integer1, integer2, s, s1, null, 0x40, null);
    }

    public Commerce(int v, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable String s, @Nullable String s1, @Nullable Integer integer3) {
        this.regularPrice = v;
        this.discountPrice = integer0;
        this.fixedDiscountPrice = integer1;
        this.discountRate = integer2;
        this.productName = s;
        this.currencyUnit = s1;
        this.currencyUnitPosition = integer3;
    }

    public Commerce(int v, Integer integer0, Integer integer1, Integer integer2, String s, String s1, Integer integer3, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            integer0 = null;
        }
        if((v1 & 4) != 0) {
            integer1 = null;
        }
        if((v1 & 8) != 0) {
            integer2 = null;
        }
        if((v1 & 16) != 0) {
            s = null;
        }
        if((v1 & 0x20) != 0) {
            s1 = null;
        }
        this(v, integer0, integer1, integer2, s, s1, ((v1 & 0x40) == 0 ? integer3 : null));
    }

    public final int component1() {
        return this.regularPrice;
    }

    @Nullable
    public final Integer component2() {
        return this.discountPrice;
    }

    @Nullable
    public final Integer component3() {
        return this.fixedDiscountPrice;
    }

    @Nullable
    public final Integer component4() {
        return this.discountRate;
    }

    @Nullable
    public final String component5() {
        return this.productName;
    }

    @Nullable
    public final String component6() {
        return this.currencyUnit;
    }

    @Nullable
    public final Integer component7() {
        return this.currencyUnitPosition;
    }

    @NotNull
    public final Commerce copy(int v, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable String s, @Nullable String s1, @Nullable Integer integer3) {
        return new Commerce(v, integer0, integer1, integer2, s, s1, integer3);
    }

    public static Commerce copy$default(Commerce commerce0, int v, Integer integer0, Integer integer1, Integer integer2, String s, String s1, Integer integer3, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = commerce0.regularPrice;
        }
        if((v1 & 2) != 0) {
            integer0 = commerce0.discountPrice;
        }
        if((v1 & 4) != 0) {
            integer1 = commerce0.fixedDiscountPrice;
        }
        if((v1 & 8) != 0) {
            integer2 = commerce0.discountRate;
        }
        if((v1 & 16) != 0) {
            s = commerce0.productName;
        }
        if((v1 & 0x20) != 0) {
            s1 = commerce0.currencyUnit;
        }
        if((v1 & 0x40) != 0) {
            integer3 = commerce0.currencyUnitPosition;
        }
        return commerce0.copy(v, integer0, integer1, integer2, s, s1, integer3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Commerce)) {
            return false;
        }
        if(this.regularPrice != ((Commerce)object0).regularPrice) {
            return false;
        }
        if(!q.b(this.discountPrice, ((Commerce)object0).discountPrice)) {
            return false;
        }
        if(!q.b(this.fixedDiscountPrice, ((Commerce)object0).fixedDiscountPrice)) {
            return false;
        }
        if(!q.b(this.discountRate, ((Commerce)object0).discountRate)) {
            return false;
        }
        if(!q.b(this.productName, ((Commerce)object0).productName)) {
            return false;
        }
        return q.b(this.currencyUnit, ((Commerce)object0).currencyUnit) ? q.b(this.currencyUnitPosition, ((Commerce)object0).currencyUnitPosition) : false;
    }

    @Nullable
    public final String getCurrencyUnit() {
        return this.currencyUnit;
    }

    @SerialName("currency_unit")
    public static void getCurrencyUnit$annotations() {
    }

    @Nullable
    public final Integer getCurrencyUnitPosition() {
        return this.currencyUnitPosition;
    }

    @SerialName("currency_unit_position")
    public static void getCurrencyUnitPosition$annotations() {
    }

    @Nullable
    public final Integer getDiscountPrice() {
        return this.discountPrice;
    }

    @SerialName("discount_price")
    public static void getDiscountPrice$annotations() {
    }

    @Nullable
    public final Integer getDiscountRate() {
        return this.discountRate;
    }

    @SerialName("discount_rate")
    public static void getDiscountRate$annotations() {
    }

    @Nullable
    public final Integer getFixedDiscountPrice() {
        return this.fixedDiscountPrice;
    }

    @SerialName("fixed_discount_price")
    public static void getFixedDiscountPrice$annotations() {
    }

    @Nullable
    public final String getProductName() {
        return this.productName;
    }

    @SerialName("product_name")
    public static void getProductName$annotations() {
    }

    public final int getRegularPrice() {
        return this.regularPrice;
    }

    @SerialName("regular_price")
    public static void getRegularPrice$annotations() {
    }

    @Override
    public int hashCode() {
        int v = this.regularPrice;
        int v1 = 0;
        int v2 = this.discountPrice == null ? 0 : this.discountPrice.hashCode();
        int v3 = this.fixedDiscountPrice == null ? 0 : this.fixedDiscountPrice.hashCode();
        int v4 = this.discountRate == null ? 0 : this.discountRate.hashCode();
        int v5 = this.productName == null ? 0 : this.productName.hashCode();
        int v6 = this.currencyUnit == null ? 0 : this.currencyUnit.hashCode();
        Integer integer0 = this.currencyUnitPosition;
        if(integer0 != null) {
            v1 = integer0.hashCode();
        }
        return (((((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Commerce(regularPrice=");
        stringBuilder0.append(this.regularPrice);
        stringBuilder0.append(", discountPrice=");
        stringBuilder0.append(this.discountPrice);
        stringBuilder0.append(", fixedDiscountPrice=");
        stringBuilder0.append(this.fixedDiscountPrice);
        stringBuilder0.append(", discountRate=");
        stringBuilder0.append(this.discountRate);
        stringBuilder0.append(", productName=");
        A7.d.u(stringBuilder0, this.productName, ", currencyUnit=", this.currencyUnit, ", currencyUnitPosition=");
        stringBuilder0.append(this.currencyUnitPosition);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    public static final void write$Self(@NotNull Commerce commerce0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(commerce0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeIntElement(serialDescriptor0, 0, commerce0.regularPrice);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 1) || commerce0.discountPrice != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, IntSerializer.INSTANCE, commerce0.discountPrice);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || commerce0.fixedDiscountPrice != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, IntSerializer.INSTANCE, commerce0.fixedDiscountPrice);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || commerce0.discountRate != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, IntSerializer.INSTANCE, commerce0.discountRate);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || commerce0.productName != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, commerce0.productName);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 5) || commerce0.currencyUnit != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, commerce0.currencyUnit);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 6) || commerce0.currencyUnitPosition != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 6, IntSerializer.INSTANCE, commerce0.currencyUnitPosition);
        }
    }
}

