package com.kakao.sdk.auth.model;

import Tf.o;
import U4.x;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import ie.d;
import java.util.Date;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0014\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002<;BE\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u00A2\u0006\u0004\b\u000B\u0010\fBg\b\u0017\u0012\u0006\u0010\u000E\u001A\u00020\r\u0012\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F\u00A2\u0006\u0004\b\u000B\u0010\u0011J(\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0015H\u00C7\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001BJ\u0010\u0010\u001F\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u001DJ\u0012\u0010 \u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u001BJ\u0018\u0010!\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\"JV\u0010#\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u00C6\u0001\u00A2\u0006\u0004\b#\u0010$J\u0010\u0010%\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b%\u0010\u001BJ\u0010\u0010&\u001A\u00020\rH\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\'J\u001A\u0010*\u001A\u00020)2\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b*\u0010+R \u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010,\u0012\u0004\b.\u0010/\u001A\u0004\b-\u0010\u001BR \u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u00100\u0012\u0004\b2\u0010/\u001A\u0004\b1\u0010\u001DR \u0010\u0006\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u0010,\u0012\u0004\b4\u0010/\u001A\u0004\b3\u0010\u001BR \u0010\u0007\u001A\u00020\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u00100\u0012\u0004\b6\u0010/\u001A\u0004\b5\u0010\u001DR\"\u0010\b\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\b\u0010,\u0012\u0004\b8\u0010/\u001A\u0004\b7\u0010\u001BR\u001F\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b\n\u00109\u001A\u0004\b:\u0010\"\u00A8\u0006="}, d2 = {"Lcom/kakao/sdk/auth/model/OAuthToken;", "", "", "accessToken", "Ljava/util/Date;", "accessTokenExpiresAt", "refreshToken", "refreshTokenExpiresAt", "idToken", "", "scopes", "<init>", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/auth/model/OAuthToken;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/Date;", "component3", "component4", "component5", "component6", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/List;)Lcom/kakao/sdk/auth/model/OAuthToken;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAccessToken", "getAccessToken$annotations", "()V", "Ljava/util/Date;", "getAccessTokenExpiresAt", "getAccessTokenExpiresAt$annotations", "getRefreshToken", "getRefreshToken$annotations", "getRefreshTokenExpiresAt", "getRefreshTokenExpiresAt$annotations", "getIdToken", "getIdToken$annotations", "Ljava/util/List;", "getScopes", "Companion", "$serializer", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class OAuthToken {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/auth/model/OAuthToken.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/auth/model/OAuthToken;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/auth/model/OAuthToken;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/auth/model/OAuthToken;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer oAuthToken$$serializer0 = new .serializer();
            .serializer.INSTANCE = oAuthToken$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.auth.model.OAuthToken", oAuthToken$$serializer0, 6);
            pluginGeneratedSerialDescriptor0.addElement("access_token", false);
            pluginGeneratedSerialDescriptor0.addElement("access_token_expires_at", false);
            pluginGeneratedSerialDescriptor0.addElement("refresh_token", false);
            pluginGeneratedSerialDescriptor0.addElement("refresh_token_expires_at", false);
            pluginGeneratedSerialDescriptor0.addElement("id_token", true);
            pluginGeneratedSerialDescriptor0.addElement("scopes", true);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            ContextualSerializer contextualSerializer0 = new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0]);
            ContextualSerializer contextualSerializer1 = new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0]);
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE));
            return new KSerializer[]{StringSerializer.INSTANCE, contextualSerializer0, StringSerializer.INSTANCE, contextualSerializer1, kSerializer0, kSerializer1};
        }

        @NotNull
        public OAuthToken deserialize(@NotNull Decoder decoder0) {
            int v;
            String s2;
            Object object3;
            Object object2;
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
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), null);
                String s1 = compositeDecoder0.decodeStringElement(serialDescriptor0, 2);
                object1 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 3, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, new ArrayListSerializer(StringSerializer.INSTANCE), null);
                s2 = s1;
                v = 0x3F;
            }
            else {
                int v1 = 0;
                s = null;
                Object object4 = null;
                Object object5 = null;
                Object object6 = null;
                String s3 = null;
                Object object7 = null;
                boolean z1 = true;
                while(z1) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z1 = false;
                            break;
                        }
                        case 0: {
                            s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            object7 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), object7);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            s3 = compositeDecoder0.decodeStringElement(serialDescriptor0, 2);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object5 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 3, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), object5);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, object6);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, new ArrayListSerializer(StringSerializer.INSTANCE), object4);
                            v1 |= 0x20;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                object0 = object7;
                object3 = object4;
                object1 = object5;
                object2 = object6;
                s2 = s3;
                v = v1;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new OAuthToken(v, s, ((Date)object0), s2, ((Date)object1), ((String)object2), ((List)object3), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull OAuthToken oAuthToken0) {
            q.g(encoder0, "encoder");
            q.g(oAuthToken0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            OAuthToken.write$Self(oAuthToken0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((OAuthToken)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0004J\u000F\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\tHÆ\u0001¨\u0006\n"}, d2 = {"Lcom/kakao/sdk/auth/model/OAuthToken$Companion;", "", "()V", "fromResponse", "Lcom/kakao/sdk/auth/model/OAuthToken;", "response", "Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "oldToken", "serializer", "Lkotlinx/serialization/KSerializer;", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final OAuthToken fromResponse(@NotNull AccessTokenResponse accessTokenResponse0, @Nullable OAuthToken oAuthToken0) {
            Date date1;
            q.g(accessTokenResponse0, "response");
            String s = accessTokenResponse0.getAccessToken();
            Date date0 = new Date(accessTokenResponse0.getAccessTokenExpiresIn() * 1000L + new Date().getTime());
            String s1 = accessTokenResponse0.getRefreshToken();
            if(s1 == null) {
                s1 = oAuthToken0 == null ? null : oAuthToken0.getRefreshToken();
                if(s1 == null) {
                    throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found in the response.");
                }
            }
            if(accessTokenResponse0.getRefreshToken() == null) {
                date1 = oAuthToken0 == null ? null : oAuthToken0.getRefreshTokenExpiresAt();
                q.d(date1);
            }
            else {
                Long long0 = accessTokenResponse0.getRefreshTokenExpiresIn();
                date1 = long0 == null ? new Date() : new Date(long0.longValue() * 1000L + new Date().getTime());
            }
            String s2 = accessTokenResponse0.getScope();
            if(s2 != null) {
                return new OAuthToken(s, date0, s1, date1, accessTokenResponse0.getIdToken(), o.R0(s2, new String[]{" "}, 0, 6));
            }
            return oAuthToken0 == null ? new OAuthToken(s, date0, s1, date1, accessTokenResponse0.getIdToken(), null) : new OAuthToken(s, date0, s1, date1, accessTokenResponse0.getIdToken(), oAuthToken0.getScopes());
        }

        public static OAuthToken fromResponse$default(Companion oAuthToken$Companion0, AccessTokenResponse accessTokenResponse0, OAuthToken oAuthToken0, int v, Object object0) {
            if((v & 2) != 0) {
                oAuthToken0 = null;
            }
            return oAuthToken$Companion0.fromResponse(accessTokenResponse0, oAuthToken0);
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
    @NotNull
    private final Date accessTokenExpiresAt;
    @Nullable
    private final String idToken;
    @NotNull
    private final String refreshToken;
    @NotNull
    private final Date refreshTokenExpiresAt;
    @Nullable
    private final List scopes;

    static {
        OAuthToken.Companion = new Companion(null);
    }

    @d
    public OAuthToken(int v, @SerialName("access_token") String s, @SerialName("access_token_expires_at") Date date0, @SerialName("refresh_token") String s1, @SerialName("refresh_token_expires_at") Date date1, @SerialName("id_token") String s2, List list0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(15 != (v & 15)) {
            PluginExceptionsKt.throwMissingFieldException(v, 15, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.accessToken = s;
        this.accessTokenExpiresAt = date0;
        this.refreshToken = s1;
        this.refreshTokenExpiresAt = date1;
        this.idToken = (v & 16) == 0 ? null : s2;
        if((v & 0x20) == 0) {
            this.scopes = null;
            return;
        }
        this.scopes = list0;
    }

    public OAuthToken(@NotNull String s, @NotNull Date date0, @NotNull String s1, @NotNull Date date1, @Nullable String s2, @Nullable List list0) {
        q.g(s, "accessToken");
        q.g(date0, "accessTokenExpiresAt");
        q.g(s1, "refreshToken");
        q.g(date1, "refreshTokenExpiresAt");
        super();
        this.accessToken = s;
        this.accessTokenExpiresAt = date0;
        this.refreshToken = s1;
        this.refreshTokenExpiresAt = date1;
        this.idToken = s2;
        this.scopes = list0;
    }

    public OAuthToken(String s, Date date0, String s1, Date date1, String s2, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 16) != 0) {
            s2 = null;
        }
        this(s, date0, s1, date1, s2, ((v & 0x20) == 0 ? list0 : null));
    }

    @NotNull
    public final String component1() {
        return this.accessToken;
    }

    @NotNull
    public final Date component2() {
        return this.accessTokenExpiresAt;
    }

    @NotNull
    public final String component3() {
        return this.refreshToken;
    }

    @NotNull
    public final Date component4() {
        return this.refreshTokenExpiresAt;
    }

    @Nullable
    public final String component5() {
        return this.idToken;
    }

    @Nullable
    public final List component6() {
        return this.scopes;
    }

    @NotNull
    public final OAuthToken copy(@NotNull String s, @NotNull Date date0, @NotNull String s1, @NotNull Date date1, @Nullable String s2, @Nullable List list0) {
        q.g(s, "accessToken");
        q.g(date0, "accessTokenExpiresAt");
        q.g(s1, "refreshToken");
        q.g(date1, "refreshTokenExpiresAt");
        return new OAuthToken(s, date0, s1, date1, s2, list0);
    }

    public static OAuthToken copy$default(OAuthToken oAuthToken0, String s, Date date0, String s1, Date date1, String s2, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            s = oAuthToken0.accessToken;
        }
        if((v & 2) != 0) {
            date0 = oAuthToken0.accessTokenExpiresAt;
        }
        if((v & 4) != 0) {
            s1 = oAuthToken0.refreshToken;
        }
        if((v & 8) != 0) {
            date1 = oAuthToken0.refreshTokenExpiresAt;
        }
        if((v & 16) != 0) {
            s2 = oAuthToken0.idToken;
        }
        if((v & 0x20) != 0) {
            list0 = oAuthToken0.scopes;
        }
        return oAuthToken0.copy(s, date0, s1, date1, s2, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof OAuthToken)) {
            return false;
        }
        if(!q.b(this.accessToken, ((OAuthToken)object0).accessToken)) {
            return false;
        }
        if(!q.b(this.accessTokenExpiresAt, ((OAuthToken)object0).accessTokenExpiresAt)) {
            return false;
        }
        if(!q.b(this.refreshToken, ((OAuthToken)object0).refreshToken)) {
            return false;
        }
        if(!q.b(this.refreshTokenExpiresAt, ((OAuthToken)object0).refreshTokenExpiresAt)) {
            return false;
        }
        return q.b(this.idToken, ((OAuthToken)object0).idToken) ? q.b(this.scopes, ((OAuthToken)object0).scopes) : false;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @SerialName("access_token")
    public static void getAccessToken$annotations() {
    }

    @NotNull
    public final Date getAccessTokenExpiresAt() {
        return this.accessTokenExpiresAt;
    }

    @SerialName("access_token_expires_at")
    public static void getAccessTokenExpiresAt$annotations() {
    }

    @Nullable
    public final String getIdToken() {
        return this.idToken;
    }

    @SerialName("id_token")
    public static void getIdToken$annotations() {
    }

    @NotNull
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @SerialName("refresh_token")
    public static void getRefreshToken$annotations() {
    }

    @NotNull
    public final Date getRefreshTokenExpiresAt() {
        return this.refreshTokenExpiresAt;
    }

    @SerialName("refresh_token_expires_at")
    public static void getRefreshTokenExpiresAt$annotations() {
    }

    @Nullable
    public final List getScopes() {
        return this.scopes;
    }

    @Override
    public int hashCode() {
        int v = x.b((this.accessTokenExpiresAt.hashCode() + this.accessToken.hashCode() * 0x1F) * 0x1F, 0x1F, this.refreshToken);
        int v1 = this.refreshTokenExpiresAt.hashCode();
        int v2 = 0;
        int v3 = this.idToken == null ? 0 : this.idToken.hashCode();
        List list0 = this.scopes;
        if(list0 != null) {
            v2 = list0.hashCode();
        }
        return ((v1 + v) * 0x1F + v3) * 0x1F + v2;
    }

    @Override
    @NotNull
    public String toString() {
        return "OAuthToken(accessToken=" + this.accessToken + ", accessTokenExpiresAt=" + this.accessTokenExpiresAt + ", refreshToken=" + this.refreshToken + ", refreshTokenExpiresAt=" + this.refreshTokenExpiresAt + ", idToken=" + this.idToken + ", scopes=" + this.scopes + ")";
    }

    public static final void write$Self(@NotNull OAuthToken oAuthToken0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(oAuthToken0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, oAuthToken0.accessToken);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 1, new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0]), oAuthToken0.accessTokenExpiresAt);
        compositeEncoder0.encodeStringElement(serialDescriptor0, 2, oAuthToken0.refreshToken);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 3, new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0]), oAuthToken0.refreshTokenExpiresAt);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || oAuthToken0.idToken != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, oAuthToken0.idToken);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 5) || oAuthToken0.scopes != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, new ArrayListSerializer(StringSerializer.INSTANCE), oAuthToken0.scopes);
        }
    }
}

