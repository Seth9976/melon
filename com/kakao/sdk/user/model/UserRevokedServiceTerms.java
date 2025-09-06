package com.kakao.sdk.user.model;

import ie.d;
import java.util.List;
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
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,+B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB5\b\u0017\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0010\b\u0001\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u0007\u0010\rJ(\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u0011HÇ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J,\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001D\u001A\u00020\u001CHÖ\u0001¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u001F\u0010 J\u001A\u0010#\u001A\u00020\"2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001A\u0004\b&\u0010\u0017R(\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\'\u0012\u0004\b)\u0010*\u001A\u0004\b(\u0010\u0019¨\u0006-"}, d2 = {"Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "", "", "id", "", "Lcom/kakao/sdk/user/model/RevokedServiceTerms;", "revokedServiceTerms", "<init>", "(JLjava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()J", "component2", "()Ljava/util/List;", "copy", "(JLjava/util/List;)Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "Ljava/util/List;", "getRevokedServiceTerms", "getRevokedServiceTerms$annotations", "()V", "Companion", "$serializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class UserRevokedServiceTerms {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/UserRevokedServiceTerms.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer userRevokedServiceTerms$$serializer0 = new .serializer();
            .serializer.INSTANCE = userRevokedServiceTerms$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.UserRevokedServiceTerms", userRevokedServiceTerms$$serializer0, 2);
            pluginGeneratedSerialDescriptor0.addElement("id", false);
            pluginGeneratedSerialDescriptor0.addElement("revoked_service_terms", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(com.kakao.sdk.user.model.RevokedServiceTerms..serializer.INSTANCE));
            return new KSerializer[]{LongSerializer.INSTANCE, kSerializer0};
        }

        @NotNull
        public UserRevokedServiceTerms deserialize(@NotNull Decoder decoder0) {
            int v1;
            Object object1;
            long v;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                v = compositeDecoder0.decodeLongElement(serialDescriptor0, 0);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, new ArrayListSerializer(com.kakao.sdk.user.model.RevokedServiceTerms..serializer.INSTANCE), null);
                v1 = 3;
            }
            else {
                v = 0L;
                int v2 = 0;
                boolean z = true;
                while(z) {
                    int v3 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v3) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            v = compositeDecoder0.decodeLongElement(serialDescriptor0, 0);
                            v2 |= 1;
                            break;
                        }
                        case 1: {
                            object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, new ArrayListSerializer(com.kakao.sdk.user.model.RevokedServiceTerms..serializer.INSTANCE), object0);
                            v2 |= 2;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v3);
                        }
                    }
                }
                v1 = v2;
                object1 = object0;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new UserRevokedServiceTerms(v1, v, ((List)object1), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull UserRevokedServiceTerms userRevokedServiceTerms0) {
            q.g(encoder0, "encoder");
            q.g(userRevokedServiceTerms0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            UserRevokedServiceTerms.write$Self(userRevokedServiceTerms0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((UserRevokedServiceTerms)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/UserRevokedServiceTerms$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final long id;
    @Nullable
    private final List revokedServiceTerms;

    static {
        UserRevokedServiceTerms.Companion = new Companion(null);
    }

    @d
    public UserRevokedServiceTerms(int v, long v1, @SerialName("revoked_service_terms") List list0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(3 != (v & 3)) {
            PluginExceptionsKt.throwMissingFieldException(v, 3, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.id = v1;
        this.revokedServiceTerms = list0;
    }

    public UserRevokedServiceTerms(long v, @Nullable List list0) {
        this.id = v;
        this.revokedServiceTerms = list0;
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final List component2() {
        return this.revokedServiceTerms;
    }

    @NotNull
    public final UserRevokedServiceTerms copy(long v, @Nullable List list0) {
        return new UserRevokedServiceTerms(v, list0);
    }

    public static UserRevokedServiceTerms copy$default(UserRevokedServiceTerms userRevokedServiceTerms0, long v, List list0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = userRevokedServiceTerms0.id;
        }
        if((v1 & 2) != 0) {
            list0 = userRevokedServiceTerms0.revokedServiceTerms;
        }
        return userRevokedServiceTerms0.copy(v, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof UserRevokedServiceTerms)) {
            return false;
        }
        return this.id == ((UserRevokedServiceTerms)object0).id ? q.b(this.revokedServiceTerms, ((UserRevokedServiceTerms)object0).revokedServiceTerms) : false;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final List getRevokedServiceTerms() {
        return this.revokedServiceTerms;
    }

    @SerialName("revoked_service_terms")
    public static void getRevokedServiceTerms$annotations() {
    }

    @Override
    public int hashCode() {
        int v = Long.hashCode(this.id);
        return this.revokedServiceTerms == null ? v * 0x1F : v * 0x1F + this.revokedServiceTerms.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "UserRevokedServiceTerms(id=" + this.id + ", revokedServiceTerms=" + this.revokedServiceTerms + ")";
    }

    public static final void write$Self(@NotNull UserRevokedServiceTerms userRevokedServiceTerms0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(userRevokedServiceTerms0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeLongElement(serialDescriptor0, 0, userRevokedServiceTerms0.id);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, new ArrayListSerializer(com.kakao.sdk.user.model.RevokedServiceTerms..serializer.INSTANCE), userRevokedServiceTerms0.revokedServiceTerms);
    }
}

