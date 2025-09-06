package com.kakao.sdk.user.model;

import ie.d;
import java.util.List;
import k8.Y;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0014\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000232B+\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00A2\u0006\u0004\b\t\u0010\nBE\b\u0017\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0010\b\u0001\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\b\t\u0010\u000FJ(\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013H\u00C7\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0018\u0010\u001C\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ:\u0010\u001E\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u00C6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010!\u001A\u00020 H\u00D6\u0001\u00A2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001A\u00020\u000BH\u00D6\u0001\u00A2\u0006\u0004\b#\u0010$J\u001A\u0010&\u001A\u00020\u00042\b\u0010%\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b&\u0010\'R\"\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010(\u0012\u0004\b*\u0010+\u001A\u0004\b)\u0010\u0019R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u0010,\u0012\u0004\b.\u0010+\u001A\u0004\b-\u0010\u001BR(\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\b\u0010/\u0012\u0004\b1\u0010+\u001A\u0004\b0\u0010\u001D\u00A8\u00064"}, d2 = {"Lcom/kakao/sdk/user/model/UserShippingAddresses;", "", "", "userId", "", "needsAgreement", "", "Lcom/kakao/sdk/user/model/ShippingAddress;", "shippingAddresses", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/UserShippingAddresses;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/Long;", "component2", "()Ljava/lang/Boolean;", "component3", "()Ljava/util/List;", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;)Lcom/kakao/sdk/user/model/UserShippingAddresses;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getUserId", "getUserId$annotations", "()V", "Ljava/lang/Boolean;", "getNeedsAgreement", "getNeedsAgreement$annotations", "Ljava/util/List;", "getShippingAddresses", "getShippingAddresses$annotations", "Companion", "$serializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class UserShippingAddresses {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/UserShippingAddresses.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/UserShippingAddresses;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/UserShippingAddresses;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/UserShippingAddresses;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer userShippingAddresses$$serializer0 = new .serializer();
            .serializer.INSTANCE = userShippingAddresses$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.UserShippingAddresses", userShippingAddresses$$serializer0, 3);
            pluginGeneratedSerialDescriptor0.addElement("user_id", false);
            pluginGeneratedSerialDescriptor0.addElement("shipping_addresses_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("shipping_addresses", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(com.kakao.sdk.user.model.ShippingAddress..serializer.INSTANCE))};
        }

        @NotNull
        public UserShippingAddresses deserialize(@NotNull Decoder decoder0) {
            int v;
            Object object3;
            Object object2;
            Object object1;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, BooleanSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.user.model.ShippingAddress..serializer.INSTANCE), null);
                v = 7;
            }
            else {
                int v1 = 0;
                Object object4 = null;
                Object object5 = null;
                boolean z = true;
                while(z) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, object0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, BooleanSerializer.INSTANCE, object4);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.user.model.ShippingAddress..serializer.INSTANCE), object5);
                            v1 |= 4;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                object1 = object0;
                object2 = object4;
                object3 = object5;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new UserShippingAddresses(v, ((Long)object1), ((Boolean)object2), ((List)object3), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull UserShippingAddresses userShippingAddresses0) {
            q.g(encoder0, "encoder");
            q.g(userShippingAddresses0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            UserShippingAddresses.write$Self(userShippingAddresses0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((UserShippingAddresses)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/UserShippingAddresses$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/UserShippingAddresses;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Boolean needsAgreement;
    @Nullable
    private final List shippingAddresses;
    @Nullable
    private final Long userId;

    static {
        UserShippingAddresses.Companion = new Companion(null);
    }

    @d
    public UserShippingAddresses(int v, @SerialName("user_id") Long long0, @SerialName("shipping_addresses_needs_agreement") Boolean boolean0, @SerialName("shipping_addresses") List list0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(7 != (v & 7)) {
            PluginExceptionsKt.throwMissingFieldException(v, 7, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.userId = long0;
        this.needsAgreement = boolean0;
        this.shippingAddresses = list0;
    }

    public UserShippingAddresses(@Nullable Long long0, @Nullable Boolean boolean0, @Nullable List list0) {
        this.userId = long0;
        this.needsAgreement = boolean0;
        this.shippingAddresses = list0;
    }

    @Nullable
    public final Long component1() {
        return this.userId;
    }

    @Nullable
    public final Boolean component2() {
        return this.needsAgreement;
    }

    @Nullable
    public final List component3() {
        return this.shippingAddresses;
    }

    @NotNull
    public final UserShippingAddresses copy(@Nullable Long long0, @Nullable Boolean boolean0, @Nullable List list0) {
        return new UserShippingAddresses(long0, boolean0, list0);
    }

    public static UserShippingAddresses copy$default(UserShippingAddresses userShippingAddresses0, Long long0, Boolean boolean0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            long0 = userShippingAddresses0.userId;
        }
        if((v & 2) != 0) {
            boolean0 = userShippingAddresses0.needsAgreement;
        }
        if((v & 4) != 0) {
            list0 = userShippingAddresses0.shippingAddresses;
        }
        return userShippingAddresses0.copy(long0, boolean0, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof UserShippingAddresses)) {
            return false;
        }
        if(!q.b(this.userId, ((UserShippingAddresses)object0).userId)) {
            return false;
        }
        return q.b(this.needsAgreement, ((UserShippingAddresses)object0).needsAgreement) ? q.b(this.shippingAddresses, ((UserShippingAddresses)object0).shippingAddresses) : false;
    }

    @Nullable
    public final Boolean getNeedsAgreement() {
        return this.needsAgreement;
    }

    @SerialName("shipping_addresses_needs_agreement")
    public static void getNeedsAgreement$annotations() {
    }

    @Nullable
    public final List getShippingAddresses() {
        return this.shippingAddresses;
    }

    @SerialName("shipping_addresses")
    public static void getShippingAddresses$annotations() {
    }

    @Nullable
    public final Long getUserId() {
        return this.userId;
    }

    @SerialName("user_id")
    public static void getUserId$annotations() {
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.userId == null ? 0 : this.userId.hashCode();
        int v2 = this.needsAgreement == null ? 0 : this.needsAgreement.hashCode();
        List list0 = this.shippingAddresses;
        if(list0 != null) {
            v = list0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("UserShippingAddresses(userId=");
        stringBuilder0.append(this.userId);
        stringBuilder0.append(", needsAgreement=");
        stringBuilder0.append(this.needsAgreement);
        stringBuilder0.append(", shippingAddresses=");
        return Y.m(stringBuilder0, this.shippingAddresses, ")");
    }

    public static final void write$Self(@NotNull UserShippingAddresses userShippingAddresses0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(userShippingAddresses0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, userShippingAddresses0.userId);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, BooleanSerializer.INSTANCE, userShippingAddresses0.needsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.user.model.ShippingAddress..serializer.INSTANCE), userShippingAddresses0.shippingAddresses);
    }
}

