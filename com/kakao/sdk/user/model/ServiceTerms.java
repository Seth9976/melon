package com.kakao.sdk.user.model;

import U4.x;
import com.kakao.sdk.common.json.GenericEnumSerializer;
import com.kakao.sdk.common.json.UnknownValue;
import i.n.i.b.a.s.e.M3;
import ie.C;
import ie.d;
import ie.j;
import ie.k;
import ie.r;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.ContextualSerializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0004;:<=B;\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b\f\u0010\rBU\b\u0017\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\f\u0010\u0012J(\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016H\u00C7\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u001EJ\u0010\u0010 \u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u001EJ\u0012\u0010!\u001A\u0004\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001A\u0004\u0018\u00010\nH\u00C6\u0003\u00A2\u0006\u0004\b#\u0010$JP\u0010%\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00042\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\nH\u00C6\u0001\u00A2\u0006\u0004\b%\u0010&J\u0010\u0010\'\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\'\u0010\u001CJ\u0010\u0010(\u001A\u00020\u000EH\u00D6\u0001\u00A2\u0006\u0004\b(\u0010)J\u001A\u0010+\u001A\u00020\u00042\b\u0010*\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010-\u001A\u0004\b.\u0010\u001CR\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010/\u001A\u0004\b0\u0010\u001ER\u0017\u0010\u0006\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010/\u001A\u0004\b1\u0010\u001ER\u0017\u0010\u0007\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010/\u001A\u0004\b2\u0010\u001ER\"\u0010\t\u001A\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\t\u00103\u0012\u0004\b5\u00106\u001A\u0004\b4\u0010\"R\"\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000B\u00107\u0012\u0004\b9\u00106\u001A\u0004\b8\u0010$\u00A8\u0006>"}, d2 = {"Lcom/kakao/sdk/user/model/ServiceTerms;", "", "", "tag", "", "required", "agreed", "revocable", "Ljava/util/Date;", "agreedAt", "Lcom/kakao/sdk/user/model/ServiceTerms$Referer;", "referer", "<init>", "(Ljava/lang/String;ZZZLjava/util/Date;Lcom/kakao/sdk/user/model/ServiceTerms$Referer;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;ZZZLjava/util/Date;Lcom/kakao/sdk/user/model/ServiceTerms$Referer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/ServiceTerms;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "()Z", "component3", "component4", "component5", "()Ljava/util/Date;", "component6", "()Lcom/kakao/sdk/user/model/ServiceTerms$Referer;", "copy", "(Ljava/lang/String;ZZZLjava/util/Date;Lcom/kakao/sdk/user/model/ServiceTerms$Referer;)Lcom/kakao/sdk/user/model/ServiceTerms;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTag", "Z", "getRequired", "getAgreed", "getRevocable", "Ljava/util/Date;", "getAgreedAt", "getAgreedAt$annotations", "()V", "Lcom/kakao/sdk/user/model/ServiceTerms$Referer;", "getReferer", "getReferer$annotations", "Companion", "$serializer", "Referer", "RefererSerializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class ServiceTerms {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/ServiceTerms.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/ServiceTerms;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/ServiceTerms;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/ServiceTerms;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer serviceTerms$$serializer0 = new .serializer();
            .serializer.INSTANCE = serviceTerms$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.ServiceTerms", serviceTerms$$serializer0, 6);
            pluginGeneratedSerialDescriptor0.addElement("tag", false);
            pluginGeneratedSerialDescriptor0.addElement("required", false);
            pluginGeneratedSerialDescriptor0.addElement("agreed", false);
            pluginGeneratedSerialDescriptor0.addElement("revocable", false);
            pluginGeneratedSerialDescriptor0.addElement("agreed_at", false);
            pluginGeneratedSerialDescriptor0.addElement("agreed_by", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0]));
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(RefererSerializer.INSTANCE);
            return new KSerializer[]{StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, kSerializer0, kSerializer1};
        }

        @NotNull
        public ServiceTerms deserialize(@NotNull Decoder decoder0) {
            boolean z6;
            boolean z5;
            int v;
            boolean z4;
            Object object1;
            Object object0;
            String s;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            boolean z = compositeDecoder0.decodeSequentially();
            Class class0 = Date.class;
            if(z) {
                s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                boolean z1 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 1);
                boolean z2 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 2);
                boolean z3 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 3);
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), null);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, RefererSerializer.INSTANCE, null);
                z4 = z3;
                v = 0x3F;
                z5 = z2;
                z6 = z1;
            }
            else {
                boolean z7 = false;
                int v1 = 0;
                boolean z8 = false;
                boolean z9 = false;
                s = null;
                Object object2 = null;
                Object object3 = null;
                boolean z10 = true;
                while(z10) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z10 = false;
                            break;
                        }
                        case 0: {
                            s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            z9 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 1);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            z8 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 2);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            z7 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 3);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), object3);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, RefererSerializer.INSTANCE, object2);
                            v1 |= 0x20;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                object1 = object2;
                object0 = object3;
                z4 = z7;
                v = v1;
                z5 = z8;
                z6 = z9;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new ServiceTerms(v, s, z6, z5, z4, ((Date)object0), ((Referer)object1), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull ServiceTerms serviceTerms0) {
            q.g(encoder0, "encoder");
            q.g(serviceTerms0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            ServiceTerms.write$Self(serviceTerms0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((ServiceTerms)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/ServiceTerms$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/ServiceTerms;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/kakao/sdk/user/model/ServiceTerms$Referer;", "", "(Ljava/lang/String;I)V", "KAUTH", "KAPI", "UNKNOWN", "Companion", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    @Serializable(with = RefererSerializer.class)
    public static enum Referer {
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/ServiceTerms$Referer$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/ServiceTerms$Referer;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.kakao.sdk.user.model.ServiceTerms.Referer.Companion {
            private com.kakao.sdk.user.model.ServiceTerms.Referer.Companion() {
            }

            public com.kakao.sdk.user.model.ServiceTerms.Referer.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            private final j get$cachedSerializer$delegate() {
                return Referer.$cachedSerializer$delegate;
            }

            @NotNull
            public final KSerializer serializer() {
                return (KSerializer)this.get$cachedSerializer$delegate().getValue();
            }
        }

        KAUTH,
        KAPI,
        @UnknownValue
        UNKNOWN;

        @NotNull
        private static final j $cachedSerializer$delegate;
        @NotNull
        public static final com.kakao.sdk.user.model.ServiceTerms.Referer.Companion Companion;

        private static final Referer[] $values() [...] // Inlined contents

        static {
            j j0;
            Referer.Companion = new com.kakao.sdk.user.model.ServiceTerms.Referer.Companion(null);
            a a0 = ServiceTerms.Referer.Companion..cachedSerializer.delegate.1.INSTANCE;
            C c0 = C.a;
            if(a0 == null) {
                NullPointerException nullPointerException0 = new NullPointerException(q.i("initializer"));
                q.l(nullPointerException0, q.class.getName());
                throw nullPointerException0;
            }
            switch(k.b.ordinal()) {
                case 0: {
                    j0 = new r(a0);
                    break;
                }
                case 1: {
                    j j1 = new ie.q();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j1.a = a0;
                    j1.b = c0;
                    j0 = j1;
                    break;
                }
                case 2: {
                    j j2 = new ie.I();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j2.a = a0;
                    j2.b = c0;
                    j0 = j2;
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            Referer.$cachedSerializer$delegate = j0;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/kakao/sdk/user/model/ServiceTerms$RefererSerializer;", "Lcom/kakao/sdk/common/json/GenericEnumSerializer;", "Lcom/kakao/sdk/user/model/ServiceTerms$Referer;", "()V", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class RefererSerializer extends GenericEnumSerializer {
        @NotNull
        public static final RefererSerializer INSTANCE;

        static {
            RefererSerializer.INSTANCE = new RefererSerializer();
        }

        private RefererSerializer() {
            super(Referer.class);
        }
    }

    @NotNull
    public static final Companion Companion;
    private final boolean agreed;
    @Nullable
    private final Date agreedAt;
    @Nullable
    private final Referer referer;
    private final boolean required;
    private final boolean revocable;
    @NotNull
    private final String tag;

    static {
        ServiceTerms.Companion = new Companion(null);
    }

    @d
    public ServiceTerms(int v, String s, boolean z, boolean z1, boolean z2, @SerialName("agreed_at") Date date0, @SerialName("agreed_by") Referer serviceTerms$Referer0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(0x3F != (v & 0x3F)) {
            PluginExceptionsKt.throwMissingFieldException(v, 0x3F, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.tag = s;
        this.required = z;
        this.agreed = z1;
        this.revocable = z2;
        this.agreedAt = date0;
        this.referer = serviceTerms$Referer0;
    }

    public ServiceTerms(@NotNull String s, boolean z, boolean z1, boolean z2, @Nullable Date date0, @Nullable Referer serviceTerms$Referer0) {
        q.g(s, "tag");
        super();
        this.tag = s;
        this.required = z;
        this.agreed = z1;
        this.revocable = z2;
        this.agreedAt = date0;
        this.referer = serviceTerms$Referer0;
    }

    @NotNull
    public final String component1() {
        return this.tag;
    }

    public final boolean component2() {
        return this.required;
    }

    public final boolean component3() {
        return this.agreed;
    }

    public final boolean component4() {
        return this.revocable;
    }

    @Nullable
    public final Date component5() {
        return this.agreedAt;
    }

    @Nullable
    public final Referer component6() {
        return this.referer;
    }

    @NotNull
    public final ServiceTerms copy(@NotNull String s, boolean z, boolean z1, boolean z2, @Nullable Date date0, @Nullable Referer serviceTerms$Referer0) {
        q.g(s, "tag");
        return new ServiceTerms(s, z, z1, z2, date0, serviceTerms$Referer0);
    }

    public static ServiceTerms copy$default(ServiceTerms serviceTerms0, String s, boolean z, boolean z1, boolean z2, Date date0, Referer serviceTerms$Referer0, int v, Object object0) {
        if((v & 1) != 0) {
            s = serviceTerms0.tag;
        }
        if((v & 2) != 0) {
            z = serviceTerms0.required;
        }
        if((v & 4) != 0) {
            z1 = serviceTerms0.agreed;
        }
        if((v & 8) != 0) {
            z2 = serviceTerms0.revocable;
        }
        if((v & 16) != 0) {
            date0 = serviceTerms0.agreedAt;
        }
        if((v & 0x20) != 0) {
            serviceTerms$Referer0 = serviceTerms0.referer;
        }
        return serviceTerms0.copy(s, z, z1, z2, date0, serviceTerms$Referer0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ServiceTerms)) {
            return false;
        }
        if(!q.b(this.tag, ((ServiceTerms)object0).tag)) {
            return false;
        }
        if(this.required != ((ServiceTerms)object0).required) {
            return false;
        }
        if(this.agreed != ((ServiceTerms)object0).agreed) {
            return false;
        }
        if(this.revocable != ((ServiceTerms)object0).revocable) {
            return false;
        }
        return q.b(this.agreedAt, ((ServiceTerms)object0).agreedAt) ? this.referer == ((ServiceTerms)object0).referer : false;
    }

    public final boolean getAgreed() {
        return this.agreed;
    }

    @Nullable
    public final Date getAgreedAt() {
        return this.agreedAt;
    }

    @SerialName("agreed_at")
    public static void getAgreedAt$annotations() {
    }

    @Nullable
    public final Referer getReferer() {
        return this.referer;
    }

    @SerialName("agreed_by")
    public static void getReferer$annotations() {
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final boolean getRevocable() {
        return this.revocable;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @Override
    public int hashCode() {
        int v = this.tag.hashCode();
        int v1 = this.required;
        int v2 = 1;
        if(v1) {
            v1 = 1;
        }
        int v3 = this.agreed;
        if(v3) {
            v3 = 1;
        }
        if(!this.revocable) {
            v2 = false;
        }
        int v4 = 0;
        int v5 = this.agreedAt == null ? 0 : this.agreedAt.hashCode();
        Referer serviceTerms$Referer0 = this.referer;
        if(serviceTerms$Referer0 != null) {
            v4 = serviceTerms$Referer0.hashCode();
        }
        return ((((v * 0x1F + v1) * 0x1F + v3) * 0x1F + v2) * 0x1F + v5) * 0x1F + v4;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ServiceTerms(tag=");
        stringBuilder0.append(this.tag);
        stringBuilder0.append(", required=");
        stringBuilder0.append(this.required);
        stringBuilder0.append(", agreed=");
        x.y(stringBuilder0, this.agreed, ", revocable=", this.revocable, ", agreedAt=");
        stringBuilder0.append(this.agreedAt);
        stringBuilder0.append(", referer=");
        stringBuilder0.append(this.referer);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    public static final void write$Self(@NotNull ServiceTerms serviceTerms0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(serviceTerms0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, serviceTerms0.tag);
        compositeEncoder0.encodeBooleanElement(serialDescriptor0, 1, serviceTerms0.required);
        compositeEncoder0.encodeBooleanElement(serialDescriptor0, 2, serviceTerms0.agreed);
        compositeEncoder0.encodeBooleanElement(serialDescriptor0, 3, serviceTerms0.revocable);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0]), serviceTerms0.agreedAt);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, RefererSerializer.INSTANCE, serviceTerms0.referer);
    }
}

