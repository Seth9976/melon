package com.kakao.sdk.auth.model;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002)(B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B1\b\u0017\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0013\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001B\u0010\u0018J\u0010\u0010\u001C\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\u001A\u0010 \u001A\u00020\u001F2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001A\u0004\b#\u0010\u0016R \u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010$\u0012\u0004\b&\u0010\'\u001A\u0004\b%\u0010\u0018¨\u0006*"}, d2 = {"Lcom/kakao/sdk/auth/model/CertTokenInfo;", "", "Lcom/kakao/sdk/auth/model/OAuthToken;", "token", "", "txId", "<init>", "(Lcom/kakao/sdk/auth/model/OAuthToken;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/kakao/sdk/auth/model/OAuthToken;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/auth/model/CertTokenInfo;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Lcom/kakao/sdk/auth/model/OAuthToken;", "component2", "()Ljava/lang/String;", "copy", "(Lcom/kakao/sdk/auth/model/OAuthToken;Ljava/lang/String;)Lcom/kakao/sdk/auth/model/CertTokenInfo;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/kakao/sdk/auth/model/OAuthToken;", "getToken", "Ljava/lang/String;", "getTxId", "getTxId$annotations", "()V", "Companion", "$serializer", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class CertTokenInfo {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/auth/model/CertTokenInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/auth/model/CertTokenInfo;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/auth/model/CertTokenInfo;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/auth/model/CertTokenInfo;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer certTokenInfo$$serializer0 = new .serializer();
            .serializer.INSTANCE = certTokenInfo$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.auth.model.CertTokenInfo", certTokenInfo$$serializer0, 2);
            pluginGeneratedSerialDescriptor0.addElement("token", false);
            pluginGeneratedSerialDescriptor0.addElement("tx_id", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{com.kakao.sdk.auth.model.OAuthToken..serializer.INSTANCE, StringSerializer.INSTANCE};
        }

        @NotNull
        public CertTokenInfo deserialize(@NotNull Decoder decoder0) {
            int v;
            String s;
            Object object0;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.auth.model.OAuthToken..serializer.INSTANCE, null);
                s = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                v = 3;
            }
            else {
                int v1 = 0;
                object0 = null;
                String s1 = null;
                boolean z = true;
                while(z) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.auth.model.OAuthToken..serializer.INSTANCE, object0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            s1 = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                            v1 |= 2;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                s = s1;
                v = v1;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new CertTokenInfo(v, ((OAuthToken)object0), s, null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull CertTokenInfo certTokenInfo0) {
            q.g(encoder0, "encoder");
            q.g(certTokenInfo0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            CertTokenInfo.write$Self(certTokenInfo0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((CertTokenInfo)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/auth/model/CertTokenInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/auth/model/CertTokenInfo;", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    @NotNull
    private final OAuthToken token;
    @NotNull
    private final String txId;

    static {
        CertTokenInfo.Companion = new Companion(null);
    }

    @d
    public CertTokenInfo(int v, OAuthToken oAuthToken0, @SerialName("tx_id") String s, SerializationConstructorMarker serializationConstructorMarker0) {
        if(3 != (v & 3)) {
            PluginExceptionsKt.throwMissingFieldException(v, 3, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.token = oAuthToken0;
        this.txId = s;
    }

    public CertTokenInfo(@NotNull OAuthToken oAuthToken0, @NotNull String s) {
        q.g(oAuthToken0, "token");
        q.g(s, "txId");
        super();
        this.token = oAuthToken0;
        this.txId = s;
    }

    @NotNull
    public final OAuthToken component1() {
        return this.token;
    }

    @NotNull
    public final String component2() {
        return this.txId;
    }

    @NotNull
    public final CertTokenInfo copy(@NotNull OAuthToken oAuthToken0, @NotNull String s) {
        q.g(oAuthToken0, "token");
        q.g(s, "txId");
        return new CertTokenInfo(oAuthToken0, s);
    }

    public static CertTokenInfo copy$default(CertTokenInfo certTokenInfo0, OAuthToken oAuthToken0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            oAuthToken0 = certTokenInfo0.token;
        }
        if((v & 2) != 0) {
            s = certTokenInfo0.txId;
        }
        return certTokenInfo0.copy(oAuthToken0, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CertTokenInfo)) {
            return false;
        }
        return q.b(this.token, ((CertTokenInfo)object0).token) ? q.b(this.txId, ((CertTokenInfo)object0).txId) : false;
    }

    @NotNull
    public final OAuthToken getToken() {
        return this.token;
    }

    @NotNull
    public final String getTxId() {
        return this.txId;
    }

    @SerialName("tx_id")
    public static void getTxId$annotations() {
    }

    @Override
    public int hashCode() {
        return this.txId.hashCode() + this.token.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "CertTokenInfo(token=" + this.token + ", txId=" + this.txId + ")";
    }

    public static final void write$Self(@NotNull CertTokenInfo certTokenInfo0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(certTokenInfo0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.auth.model.OAuthToken..serializer.INSTANCE, certTokenInfo0.token);
        compositeEncoder0.encodeStringElement(serialDescriptor0, 1, certTokenInfo0.txId);
    }
}

