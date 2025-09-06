package com.kakao.sdk.common.model;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000210B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tBC\b\u0017\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u000B\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000FJ(\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001C\u0010\u001DJ.\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010 \u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0019J\u001A\u0010&\u001A\u00020%2\b\u0010$\u001A\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010\'R \u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010(\u0012\u0004\b*\u0010+\u001A\u0004\b)\u0010\u0019R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001A\u0004\b-\u0010\u001BR\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001A\u0004\b/\u0010\u001D¨\u00062"}, d2 = {"Lcom/kakao/sdk/common/model/AuthError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "", "statusCode", "Lcom/kakao/sdk/common/model/AuthErrorCause;", "reason", "Lcom/kakao/sdk/common/model/AuthErrorResponse;", "response", "<init>", "(ILcom/kakao/sdk/common/model/AuthErrorCause;Lcom/kakao/sdk/common/model/AuthErrorResponse;)V", "seen1", "", "msg", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;ILcom/kakao/sdk/common/model/AuthErrorCause;Lcom/kakao/sdk/common/model/AuthErrorResponse;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/common/model/AuthError;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()I", "component2", "()Lcom/kakao/sdk/common/model/AuthErrorCause;", "component3", "()Lcom/kakao/sdk/common/model/AuthErrorResponse;", "copy", "(ILcom/kakao/sdk/common/model/AuthErrorCause;Lcom/kakao/sdk/common/model/AuthErrorResponse;)Lcom/kakao/sdk/common/model/AuthError;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStatusCode", "getStatusCode$annotations", "()V", "Lcom/kakao/sdk/common/model/AuthErrorCause;", "getReason", "Lcom/kakao/sdk/common/model/AuthErrorResponse;", "getResponse", "Companion", "$serializer", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class AuthError extends KakaoSdkError {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/common/model/AuthError.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/common/model/AuthError;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/common/model/AuthError;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/common/model/AuthError;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer authError$$serializer0 = new .serializer();
            .serializer.INSTANCE = authError$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.common.model.AuthError", authError$$serializer0, 4);
            pluginGeneratedSerialDescriptor0.addElement("msg", false);
            pluginGeneratedSerialDescriptor0.addElement("status_code", false);
            pluginGeneratedSerialDescriptor0.addElement("reason", false);
            pluginGeneratedSerialDescriptor0.addElement("response", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE, AuthErrorCauseSerializer.INSTANCE, com.kakao.sdk.common.model.AuthErrorResponse..serializer.INSTANCE};
        }

        @NotNull
        public AuthError deserialize(@NotNull Decoder decoder0) {
            int v2;
            int v1;
            String s1;
            Object object1;
            Object object0;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                String s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                int v = compositeDecoder0.decodeIntElement(serialDescriptor0, 1);
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, AuthErrorCauseSerializer.INSTANCE, null);
                object1 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 3, com.kakao.sdk.common.model.AuthErrorResponse..serializer.INSTANCE, null);
                s1 = s;
                v1 = v;
                v2 = 15;
            }
            else {
                int v3 = 0;
                String s2 = null;
                Object object2 = null;
                Object object3 = null;
                int v4 = 0;
                boolean z = true;
                while(z) {
                    int v5 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v5) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            s2 = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                            v4 |= 1;
                            break;
                        }
                        case 1: {
                            v3 = compositeDecoder0.decodeIntElement(serialDescriptor0, 1);
                            v4 |= 2;
                            break;
                        }
                        case 2: {
                            object2 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, AuthErrorCauseSerializer.INSTANCE, object2);
                            v4 |= 4;
                            break;
                        }
                        case 3: {
                            object3 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 3, com.kakao.sdk.common.model.AuthErrorResponse..serializer.INSTANCE, object3);
                            v4 |= 8;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v5);
                        }
                    }
                }
                v1 = v3;
                v2 = v4;
                s1 = s2;
                object0 = object2;
                object1 = object3;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new AuthError(v2, s1, v1, ((AuthErrorCause)object0), ((AuthErrorResponse)object1), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull AuthError authError0) {
            q.g(encoder0, "encoder");
            q.g(authError0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            AuthError.write$Self(authError0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((AuthError)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/common/model/AuthError$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/common/model/AuthError;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final AuthErrorCause reason;
    @NotNull
    private final AuthErrorResponse response;
    private final int statusCode;

    static {
        AuthError.Companion = new Companion(null);
    }

    public AuthError(int v, @NotNull AuthErrorCause authErrorCause0, @NotNull AuthErrorResponse authErrorResponse0) {
        q.g(authErrorCause0, "reason");
        q.g(authErrorResponse0, "response");
        String s = authErrorResponse0.getErrorDescription();
        if(s == null) {
            s = authErrorResponse0.getError();
        }
        super(s, null);
        this.statusCode = v;
        this.reason = authErrorCause0;
        this.response = authErrorResponse0;
    }

    @d
    public AuthError(int v, String s, @SerialName("status_code") int v1, AuthErrorCause authErrorCause0, AuthErrorResponse authErrorResponse0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(15 != (v & 15)) {
            PluginExceptionsKt.throwMissingFieldException(v, 15, .serializer.INSTANCE.getDescriptor());
        }
        super(v, s, serializationConstructorMarker0);
        this.statusCode = v1;
        this.reason = authErrorCause0;
        this.response = authErrorResponse0;
    }

    public final int component1() {
        return this.statusCode;
    }

    @NotNull
    public final AuthErrorCause component2() {
        return this.reason;
    }

    @NotNull
    public final AuthErrorResponse component3() {
        return this.response;
    }

    @NotNull
    public final AuthError copy(int v, @NotNull AuthErrorCause authErrorCause0, @NotNull AuthErrorResponse authErrorResponse0) {
        q.g(authErrorCause0, "reason");
        q.g(authErrorResponse0, "response");
        return new AuthError(v, authErrorCause0, authErrorResponse0);
    }

    public static AuthError copy$default(AuthError authError0, int v, AuthErrorCause authErrorCause0, AuthErrorResponse authErrorResponse0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = authError0.statusCode;
        }
        if((v1 & 2) != 0) {
            authErrorCause0 = authError0.reason;
        }
        if((v1 & 4) != 0) {
            authErrorResponse0 = authError0.response;
        }
        return authError0.copy(v, authErrorCause0, authErrorResponse0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AuthError)) {
            return false;
        }
        if(this.statusCode != ((AuthError)object0).statusCode) {
            return false;
        }
        return this.reason == ((AuthError)object0).reason ? q.b(this.response, ((AuthError)object0).response) : false;
    }

    @NotNull
    public final AuthErrorCause getReason() {
        return this.reason;
    }

    @NotNull
    public final AuthErrorResponse getResponse() {
        return this.response;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    @SerialName("status_code")
    public static void getStatusCode$annotations() {
    }

    @Override
    public int hashCode() {
        return this.response.hashCode() + (this.reason.hashCode() + this.statusCode * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "AuthError(statusCode=" + this.statusCode + ", reason=" + this.reason + ", response=" + this.response + ")";
    }

    public static final void write$Self(@NotNull AuthError authError0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(authError0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        KakaoSdkError.write$Self(authError0, compositeEncoder0, serialDescriptor0);
        compositeEncoder0.encodeIntElement(serialDescriptor0, 1, authError0.statusCode);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 2, AuthErrorCauseSerializer.INSTANCE, authError0.reason);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 3, com.kakao.sdk.common.model.AuthErrorResponse..serializer.INSTANCE, authError0.response);
    }
}

