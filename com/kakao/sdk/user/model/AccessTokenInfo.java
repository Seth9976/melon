package com.kakao.sdk.user.model;

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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000232B+\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\b\u0010\tBE\b\u0017\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0005\u0012\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u000B\u00A2\u0006\u0004\b\b\u0010\rJ(\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u0011H\u00C7\u0001\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0012\u0010\u001C\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u0017J<\u0010\u001D\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FH\u00D6\u0001\u00A2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00020\u0005H\u00D6\u0001\u00A2\u0006\u0004\b\"\u0010\u001BJ\u001A\u0010%\u001A\u00020$2\b\u0010#\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010\'\u001A\u0004\b(\u0010\u0017R \u0010\u0004\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010)\u0012\u0004\b+\u0010,\u001A\u0004\b*\u0010\u0019R \u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u0010-\u0012\u0004\b/\u0010,\u001A\u0004\b.\u0010\u001BR\"\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u0010\'\u0012\u0004\b1\u0010,\u001A\u0004\b0\u0010\u0017\u00A8\u00064"}, d2 = {"Lcom/kakao/sdk/user/model/AccessTokenInfo;", "", "", "id", "expiresIn", "", "appId", "expiresInMillis", "<init>", "(Ljava/lang/Long;JILjava/lang/Long;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Long;JILjava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/AccessTokenInfo;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/Long;", "component2", "()J", "component3", "()I", "component4", "copy", "(Ljava/lang/Long;JILjava/lang/Long;)Lcom/kakao/sdk/user/model/AccessTokenInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getId", "J", "getExpiresIn", "getExpiresIn$annotations", "()V", "I", "getAppId", "getAppId$annotations", "getExpiresInMillis", "getExpiresInMillis$annotations", "Companion", "$serializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class AccessTokenInfo {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/AccessTokenInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/AccessTokenInfo;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/AccessTokenInfo;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/AccessTokenInfo;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer accessTokenInfo$$serializer0 = new .serializer();
            .serializer.INSTANCE = accessTokenInfo$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.AccessTokenInfo", accessTokenInfo$$serializer0, 4);
            pluginGeneratedSerialDescriptor0.addElement("id", false);
            pluginGeneratedSerialDescriptor0.addElement("expires_in", false);
            pluginGeneratedSerialDescriptor0.addElement("app_id", false);
            pluginGeneratedSerialDescriptor0.addElement("expiresInMillis", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE);
            return new KSerializer[]{kSerializer0, LongSerializer.INSTANCE, IntSerializer.INSTANCE, kSerializer1};
        }

        @NotNull
        public AccessTokenInfo deserialize(@NotNull Decoder decoder0) {
            int v4;
            int v3;
            long v2;
            Object object1;
            Object object0;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, null);
                long v = compositeDecoder0.decodeLongElement(serialDescriptor0, 1);
                int v1 = compositeDecoder0.decodeIntElement(serialDescriptor0, 2);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, LongSerializer.INSTANCE, null);
                v2 = v;
                v3 = v1;
                v4 = 15;
            }
            else {
                int v5 = 0;
                v2 = 0L;
                Object object2 = null;
                Object object3 = null;
                int v6 = 0;
                boolean z = true;
                while(z) {
                    int v7 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v7) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, object2);
                            v5 |= 1;
                            break;
                        }
                        case 1: {
                            v2 = compositeDecoder0.decodeLongElement(serialDescriptor0, 1);
                            v5 |= 2;
                            break;
                        }
                        case 2: {
                            v6 = compositeDecoder0.decodeIntElement(serialDescriptor0, 2);
                            v5 |= 4;
                            break;
                        }
                        case 3: {
                            object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, LongSerializer.INSTANCE, object3);
                            v5 |= 8;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v7);
                        }
                    }
                }
                v4 = v5;
                object0 = object2;
                object1 = object3;
                v3 = v6;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new AccessTokenInfo(v4, ((Long)object0), v2, v3, ((Long)object1), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull AccessTokenInfo accessTokenInfo0) {
            q.g(encoder0, "encoder");
            q.g(accessTokenInfo0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            AccessTokenInfo.write$Self(accessTokenInfo0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((AccessTokenInfo)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/AccessTokenInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/AccessTokenInfo;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final int appId;
    private final long expiresIn;
    @Nullable
    private final Long expiresInMillis;
    @Nullable
    private final Long id;

    static {
        AccessTokenInfo.Companion = new Companion(null);
    }

    @d
    public AccessTokenInfo(int v, Long long0, @SerialName("expires_in") long v1, @SerialName("app_id") int v2, @d @SerialName("expiresInMillis") Long long1, SerializationConstructorMarker serializationConstructorMarker0) {
        if(15 != (v & 15)) {
            PluginExceptionsKt.throwMissingFieldException(v, 15, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.id = long0;
        this.expiresIn = v1;
        this.appId = v2;
        this.expiresInMillis = long1;
    }

    public AccessTokenInfo(@Nullable Long long0, long v, int v1, @Nullable Long long1) {
        this.id = long0;
        this.expiresIn = v;
        this.appId = v1;
        this.expiresInMillis = long1;
    }

    @Nullable
    public final Long component1() {
        return this.id;
    }

    public final long component2() {
        return this.expiresIn;
    }

    public final int component3() {
        return this.appId;
    }

    @Nullable
    public final Long component4() {
        return this.expiresInMillis;
    }

    @NotNull
    public final AccessTokenInfo copy(@Nullable Long long0, long v, int v1, @Nullable Long long1) {
        return new AccessTokenInfo(long0, v, v1, long1);
    }

    public static AccessTokenInfo copy$default(AccessTokenInfo accessTokenInfo0, Long long0, long v, int v1, Long long1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            long0 = accessTokenInfo0.id;
        }
        if((v2 & 2) != 0) {
            v = accessTokenInfo0.expiresIn;
        }
        if((v2 & 4) != 0) {
            v1 = accessTokenInfo0.appId;
        }
        if((v2 & 8) != 0) {
            long1 = accessTokenInfo0.expiresInMillis;
        }
        return accessTokenInfo0.copy(long0, v, v1, long1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AccessTokenInfo)) {
            return false;
        }
        if(!q.b(this.id, ((AccessTokenInfo)object0).id)) {
            return false;
        }
        if(this.expiresIn != ((AccessTokenInfo)object0).expiresIn) {
            return false;
        }
        return this.appId == ((AccessTokenInfo)object0).appId ? q.b(this.expiresInMillis, ((AccessTokenInfo)object0).expiresInMillis) : false;
    }

    public final int getAppId() {
        return this.appId;
    }

    @SerialName("app_id")
    public static void getAppId$annotations() {
    }

    public final long getExpiresIn() {
        return this.expiresIn;
    }

    @SerialName("expires_in")
    public static void getExpiresIn$annotations() {
    }

    @Nullable
    public final Long getExpiresInMillis() {
        return this.expiresInMillis;
    }

    @d
    @SerialName("expiresInMillis")
    public static void getExpiresInMillis$annotations() {
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = A7.d.b(this.appId, A7.d.c((this.id == null ? 0 : this.id.hashCode()) * 0x1F, 0x1F, this.expiresIn), 0x1F);
        Long long0 = this.expiresInMillis;
        if(long0 != null) {
            v = long0.hashCode();
        }
        return v1 + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "AccessTokenInfo(id=" + this.id + ", expiresIn=" + this.expiresIn + ", appId=" + this.appId + ", expiresInMillis=" + this.expiresInMillis + ")";
    }

    public static final void write$Self(@NotNull AccessTokenInfo accessTokenInfo0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(accessTokenInfo0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, accessTokenInfo0.id);
        compositeEncoder0.encodeLongElement(serialDescriptor0, 1, accessTokenInfo0.expiresIn);
        compositeEncoder0.encodeIntElement(serialDescriptor0, 2, accessTokenInfo0.appId);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, LongSerializer.INSTANCE, accessTokenInfo0.expiresInMillis);
    }
}

