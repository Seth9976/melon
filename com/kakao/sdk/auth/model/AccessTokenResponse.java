package com.kakao.sdk.auth.model;

import U4.x;
import ie.d;
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
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001A\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002GFBg\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\r\u0010\u000EB\u0083\u0001\b\u0017\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u0012\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0005\u0012\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\r\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u0015J\u0010\u0010\u001C\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u0015J\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u0015J\u0012\u0010\u001E\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u0015J\u0012\u0010\u001F\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u0015Jv\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001A\u00020\u00022\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\"\u0010\u0015J\u0010\u0010#\u001A\u00020\u000FH\u00D6\u0001\u00A2\u0006\u0004\b#\u0010$J\u001A\u0010\'\u001A\u00020&2\b\u0010%\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\'\u0010(J(\u0010/\u001A\u00020.2\u0006\u0010)\u001A\u00020\u00002\u0006\u0010+\u001A\u00020*2\u0006\u0010-\u001A\u00020,H\u00C7\u0001\u00A2\u0006\u0004\b/\u00100R \u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u00101\u0012\u0004\b3\u00104\u001A\u0004\b2\u0010\u0015R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u00101\u0012\u0004\b6\u00104\u001A\u0004\b5\u0010\u0015R \u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u00107\u0012\u0004\b9\u00104\u001A\u0004\b8\u0010\u0018R\"\u0010\u0007\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u0010:\u0012\u0004\b<\u00104\u001A\u0004\b;\u0010\u001AR\"\u0010\b\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\b\u00101\u0012\u0004\b>\u00104\u001A\u0004\b=\u0010\u0015R \u0010\t\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\t\u00101\u0012\u0004\b@\u00104\u001A\u0004\b?\u0010\u0015R\u0019\u0010\n\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\n\u00101\u001A\u0004\bA\u0010\u0015R\"\u0010\u000B\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000B\u00101\u0012\u0004\bC\u00104\u001A\u0004\bB\u0010\u0015R\"\u0010\f\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\f\u00101\u0012\u0004\bE\u00104\u001A\u0004\bD\u0010\u0015\u00A8\u0006H"}, d2 = {"Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "", "", "accessToken", "refreshToken", "", "accessTokenExpiresIn", "refreshTokenExpiresIn", "idToken", "tokenType", "scope", "scopes", "txId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()J", "component4", "()Ljava/lang/Long;", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/auth/model/AccessTokenResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/String;", "getAccessToken", "getAccessToken$annotations", "()V", "getRefreshToken", "getRefreshToken$annotations", "J", "getAccessTokenExpiresIn", "getAccessTokenExpiresIn$annotations", "Ljava/lang/Long;", "getRefreshTokenExpiresIn", "getRefreshTokenExpiresIn$annotations", "getIdToken", "getIdToken$annotations", "getTokenType", "getTokenType$annotations", "getScope", "getScopes", "getScopes$annotations", "getTxId", "getTxId$annotations", "Companion", "$serializer", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class AccessTokenResponse {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/auth/model/AccessTokenResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/auth/model/AccessTokenResponse;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer accessTokenResponse$$serializer0 = new .serializer();
            .serializer.INSTANCE = accessTokenResponse$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.auth.model.AccessTokenResponse", accessTokenResponse$$serializer0, 9);
            pluginGeneratedSerialDescriptor0.addElement("access_token", false);
            pluginGeneratedSerialDescriptor0.addElement("refresh_token", true);
            pluginGeneratedSerialDescriptor0.addElement("expires_in", false);
            pluginGeneratedSerialDescriptor0.addElement("refresh_token_expires_in", true);
            pluginGeneratedSerialDescriptor0.addElement("id_token", true);
            pluginGeneratedSerialDescriptor0.addElement("token_type", false);
            pluginGeneratedSerialDescriptor0.addElement("scope", true);
            pluginGeneratedSerialDescriptor0.addElement("scopes", true);
            pluginGeneratedSerialDescriptor0.addElement("tx_id", true);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE);
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer3 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer4 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer5 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            return new KSerializer[]{StringSerializer.INSTANCE, kSerializer0, LongSerializer.INSTANCE, kSerializer1, kSerializer2, StringSerializer.INSTANCE, kSerializer3, kSerializer4, kSerializer5};
        }

        @NotNull
        public AccessTokenResponse deserialize(@NotNull Decoder decoder0) {
            long v2;
            int v1;
            String s4;
            String s3;
            Object object5;
            Object object4;
            Object object3;
            Object object2;
            Object object1;
            Object object0;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            String s = null;
            if(compositeDecoder0.decodeSequentially()) {
                String s1 = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, null);
                long v = compositeDecoder0.decodeLongElement(serialDescriptor0, 2);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, LongSerializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, null);
                String s2 = compositeDecoder0.decodeStringElement(serialDescriptor0, 5);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, null);
                object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 8, StringSerializer.INSTANCE, null);
                s3 = s1;
                s4 = s2;
                v1 = 0x1FF;
                v2 = v;
            }
            else {
                int v3 = 0;
                Object object6 = null;
                Object object7 = null;
                Object object8 = null;
                Object object9 = null;
                String s5 = null;
                long v4 = 0L;
                Object object10 = null;
                Object object11 = null;
                boolean z = true;
                while(z) {
                    int v5 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v5) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                            v3 |= 1;
                            break;
                        }
                        case 1: {
                            object10 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, object10);
                            v3 |= 2;
                            break;
                        }
                        case 2: {
                            v4 = compositeDecoder0.decodeLongElement(serialDescriptor0, 2);
                            v3 |= 4;
                            break;
                        }
                        case 3: {
                            object11 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, LongSerializer.INSTANCE, object11);
                            v3 |= 8;
                            break;
                        }
                        case 4: {
                            object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, object9);
                            v3 |= 16;
                            break;
                        }
                        case 5: {
                            s5 = compositeDecoder0.decodeStringElement(serialDescriptor0, 5);
                            v3 |= 0x20;
                            break;
                        }
                        case 6: {
                            object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, object8);
                            v3 |= 0x40;
                            break;
                        }
                        case 7: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, object7);
                            v3 |= 0x80;
                            break;
                        }
                        case 8: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 8, StringSerializer.INSTANCE, object6);
                            v3 |= 0x100;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v5);
                        }
                    }
                }
                v1 = v3;
                object5 = object6;
                object4 = object7;
                object3 = object8;
                s3 = s;
                object0 = object10;
                object1 = object11;
                object2 = object9;
                s4 = s5;
                v2 = v4;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new AccessTokenResponse(v1, s3, ((String)object0), v2, ((Long)object1), ((String)object2), s4, ((String)object3), ((String)object4), ((String)object5), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull AccessTokenResponse accessTokenResponse0) {
            q.g(encoder0, "encoder");
            q.g(accessTokenResponse0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            AccessTokenResponse.write$Self(accessTokenResponse0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((AccessTokenResponse)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/auth/model/AccessTokenResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String accessToken;
    private final long accessTokenExpiresIn;
    @Nullable
    private final String idToken;
    @Nullable
    private final String refreshToken;
    @Nullable
    private final Long refreshTokenExpiresIn;
    @Nullable
    private final String scope;
    @Nullable
    private final String scopes;
    @NotNull
    private final String tokenType;
    @Nullable
    private final String txId;

    static {
        AccessTokenResponse.Companion = new Companion(null);
    }

    @d
    public AccessTokenResponse(int v, @SerialName("access_token") String s, @SerialName("refresh_token") String s1, @SerialName("expires_in") long v1, @SerialName("refresh_token_expires_in") Long long0, @SerialName("id_token") String s2, @SerialName("token_type") String s3, String s4, @d String s5, @SerialName("tx_id") String s6, SerializationConstructorMarker serializationConstructorMarker0) {
        if(37 != (v & 37)) {
            PluginExceptionsKt.throwMissingFieldException(v, 37, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.accessToken = s;
        this.refreshToken = (v & 2) == 0 ? null : s1;
        this.accessTokenExpiresIn = v1;
        this.refreshTokenExpiresIn = (v & 8) == 0 ? null : long0;
        this.idToken = (v & 16) == 0 ? null : s2;
        this.tokenType = s3;
        this.scope = (v & 0x40) == 0 ? null : s4;
        this.scopes = (v & 0x80) == 0 ? null : s5;
        if((v & 0x100) == 0) {
            this.txId = null;
            return;
        }
        this.txId = s6;
    }

    public AccessTokenResponse(@NotNull String s, @Nullable String s1, long v, @Nullable Long long0, @Nullable String s2, @NotNull String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6) {
        q.g(s, "accessToken");
        q.g(s3, "tokenType");
        super();
        this.accessToken = s;
        this.refreshToken = s1;
        this.accessTokenExpiresIn = v;
        this.refreshTokenExpiresIn = long0;
        this.idToken = s2;
        this.tokenType = s3;
        this.scope = s4;
        this.scopes = s5;
        this.txId = s6;
    }

    public AccessTokenResponse(String s, String s1, long v, Long long0, String s2, String s3, String s4, String s5, String s6, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            s1 = null;
        }
        if((v1 & 8) != 0) {
            long0 = null;
        }
        if((v1 & 16) != 0) {
            s2 = null;
        }
        if((v1 & 0x40) != 0) {
            s4 = null;
        }
        if((v1 & 0x80) != 0) {
            s5 = null;
        }
        this(s, s1, v, long0, s2, s3, s4, s5, ((v1 & 0x100) == 0 ? s6 : null));
    }

    @NotNull
    public final String component1() {
        return this.accessToken;
    }

    @Nullable
    public final String component2() {
        return this.refreshToken;
    }

    public final long component3() {
        return this.accessTokenExpiresIn;
    }

    @Nullable
    public final Long component4() {
        return this.refreshTokenExpiresIn;
    }

    @Nullable
    public final String component5() {
        return this.idToken;
    }

    @NotNull
    public final String component6() {
        return this.tokenType;
    }

    @Nullable
    public final String component7() {
        return this.scope;
    }

    @Nullable
    public final String component8() {
        return this.scopes;
    }

    @Nullable
    public final String component9() {
        return this.txId;
    }

    @NotNull
    public final AccessTokenResponse copy(@NotNull String s, @Nullable String s1, long v, @Nullable Long long0, @Nullable String s2, @NotNull String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6) {
        q.g(s, "accessToken");
        q.g(s3, "tokenType");
        return new AccessTokenResponse(s, s1, v, long0, s2, s3, s4, s5, s6);
    }

    public static AccessTokenResponse copy$default(AccessTokenResponse accessTokenResponse0, String s, String s1, long v, Long long0, String s2, String s3, String s4, String s5, String s6, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = accessTokenResponse0.accessToken;
        }
        if((v1 & 2) != 0) {
            s1 = accessTokenResponse0.refreshToken;
        }
        if((v1 & 4) != 0) {
            v = accessTokenResponse0.accessTokenExpiresIn;
        }
        if((v1 & 8) != 0) {
            long0 = accessTokenResponse0.refreshTokenExpiresIn;
        }
        if((v1 & 16) != 0) {
            s2 = accessTokenResponse0.idToken;
        }
        if((v1 & 0x20) != 0) {
            s3 = accessTokenResponse0.tokenType;
        }
        if((v1 & 0x40) != 0) {
            s4 = accessTokenResponse0.scope;
        }
        if((v1 & 0x80) != 0) {
            s5 = accessTokenResponse0.scopes;
        }
        if((v1 & 0x100) != 0) {
            s6 = accessTokenResponse0.txId;
        }
        return accessTokenResponse0.copy(s, s1, v, long0, s2, s3, s4, s5, s6);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AccessTokenResponse)) {
            return false;
        }
        if(!q.b(this.accessToken, ((AccessTokenResponse)object0).accessToken)) {
            return false;
        }
        if(!q.b(this.refreshToken, ((AccessTokenResponse)object0).refreshToken)) {
            return false;
        }
        if(this.accessTokenExpiresIn != ((AccessTokenResponse)object0).accessTokenExpiresIn) {
            return false;
        }
        if(!q.b(this.refreshTokenExpiresIn, ((AccessTokenResponse)object0).refreshTokenExpiresIn)) {
            return false;
        }
        if(!q.b(this.idToken, ((AccessTokenResponse)object0).idToken)) {
            return false;
        }
        if(!q.b(this.tokenType, ((AccessTokenResponse)object0).tokenType)) {
            return false;
        }
        if(!q.b(this.scope, ((AccessTokenResponse)object0).scope)) {
            return false;
        }
        return q.b(this.scopes, ((AccessTokenResponse)object0).scopes) ? q.b(this.txId, ((AccessTokenResponse)object0).txId) : false;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @SerialName("access_token")
    public static void getAccessToken$annotations() {
    }

    public final long getAccessTokenExpiresIn() {
        return this.accessTokenExpiresIn;
    }

    @SerialName("expires_in")
    public static void getAccessTokenExpiresIn$annotations() {
    }

    @Nullable
    public final String getIdToken() {
        return this.idToken;
    }

    @SerialName("id_token")
    public static void getIdToken$annotations() {
    }

    @Nullable
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @SerialName("refresh_token")
    public static void getRefreshToken$annotations() {
    }

    @Nullable
    public final Long getRefreshTokenExpiresIn() {
        return this.refreshTokenExpiresIn;
    }

    @SerialName("refresh_token_expires_in")
    public static void getRefreshTokenExpiresIn$annotations() {
    }

    @Nullable
    public final String getScope() {
        return this.scope;
    }

    @Nullable
    public final String getScopes() {
        return this.scopes;
    }

    @d
    public static void getScopes$annotations() {
    }

    @NotNull
    public final String getTokenType() {
        return this.tokenType;
    }

    @SerialName("token_type")
    public static void getTokenType$annotations() {
    }

    @Nullable
    public final String getTxId() {
        return this.txId;
    }

    @SerialName("tx_id")
    public static void getTxId$annotations() {
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = x.b(((A7.d.c((this.accessToken.hashCode() * 0x1F + (this.refreshToken == null ? 0 : this.refreshToken.hashCode())) * 0x1F, 0x1F, this.accessTokenExpiresIn) + (this.refreshTokenExpiresIn == null ? 0 : this.refreshTokenExpiresIn.hashCode())) * 0x1F + (this.idToken == null ? 0 : this.idToken.hashCode())) * 0x1F, 0x1F, this.tokenType);
        int v2 = this.scope == null ? 0 : this.scope.hashCode();
        int v3 = this.scopes == null ? 0 : this.scopes.hashCode();
        String s = this.txId;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = A7.d.o("AccessTokenResponse(accessToken=", this.accessToken, ", refreshToken=", this.refreshToken, ", accessTokenExpiresIn=");
        stringBuilder0.append(this.accessTokenExpiresIn);
        stringBuilder0.append(", refreshTokenExpiresIn=");
        stringBuilder0.append(this.refreshTokenExpiresIn);
        A7.d.u(stringBuilder0, ", idToken=", this.idToken, ", tokenType=", this.tokenType);
        A7.d.u(stringBuilder0, ", scope=", this.scope, ", scopes=", this.scopes);
        return Y.l(stringBuilder0, ", txId=", this.txId, ")");
    }

    public static final void write$Self(@NotNull AccessTokenResponse accessTokenResponse0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(accessTokenResponse0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, accessTokenResponse0.accessToken);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 1) || accessTokenResponse0.refreshToken != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, accessTokenResponse0.refreshToken);
        }
        compositeEncoder0.encodeLongElement(serialDescriptor0, 2, accessTokenResponse0.accessTokenExpiresIn);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || accessTokenResponse0.refreshTokenExpiresIn != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, LongSerializer.INSTANCE, accessTokenResponse0.refreshTokenExpiresIn);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || accessTokenResponse0.idToken != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, accessTokenResponse0.idToken);
        }
        compositeEncoder0.encodeStringElement(serialDescriptor0, 5, accessTokenResponse0.tokenType);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 6) || accessTokenResponse0.scope != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, accessTokenResponse0.scope);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 7) || accessTokenResponse0.scopes != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, accessTokenResponse0.scopes);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 8) || accessTokenResponse0.txId != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 8, StringSerializer.INSTANCE, accessTokenResponse0.txId);
        }
    }
}

