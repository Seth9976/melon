package com.kakao.sdk.common.model;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\n\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&%B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B1\b\u0017\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000BJ(\u0010\u0012\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FHÇ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J&\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001A\u001A\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ\u001A\u0010\u001E\u001A\u00020\u001D2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001E\u0010\u001FR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001A\u0004\b!\u0010\u0015R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010 \u0012\u0004\b#\u0010$\u001A\u0004\b\"\u0010\u0015¨\u0006\'"}, d2 = {"Lcom/kakao/sdk/common/model/AuthErrorResponse;", "", "", "error", "errorDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/common/model/AuthErrorResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/kakao/sdk/common/model/AuthErrorResponse;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getError", "getErrorDescription", "getErrorDescription$annotations", "()V", "Companion", "$serializer", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class AuthErrorResponse {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/common/model/AuthErrorResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/common/model/AuthErrorResponse;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/common/model/AuthErrorResponse;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/common/model/AuthErrorResponse;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer authErrorResponse$$serializer0 = new .serializer();
            .serializer.INSTANCE = authErrorResponse$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.common.model.AuthErrorResponse", authErrorResponse$$serializer0, 2);
            pluginGeneratedSerialDescriptor0.addElement("error", false);
            pluginGeneratedSerialDescriptor0.addElement("error_description", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            return new KSerializer[]{StringSerializer.INSTANCE, kSerializer0};
        }

        @NotNull
        public AuthErrorResponse deserialize(@NotNull Decoder decoder0) {
            int v;
            Object object0;
            String s;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, null);
                v = 3;
            }
            else {
                int v1 = 0;
                s = null;
                Object object1 = null;
                boolean z = true;
                while(z) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, object1);
                            v1 |= 2;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                object0 = object1;
                v = v1;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new AuthErrorResponse(v, s, ((String)object0), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull AuthErrorResponse authErrorResponse0) {
            q.g(encoder0, "encoder");
            q.g(authErrorResponse0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            AuthErrorResponse.write$Self(authErrorResponse0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((AuthErrorResponse)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/common/model/AuthErrorResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/common/model/AuthErrorResponse;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String error;
    @Nullable
    private final String errorDescription;

    static {
        AuthErrorResponse.Companion = new Companion(null);
    }

    @d
    public AuthErrorResponse(int v, String s, @SerialName("error_description") String s1, SerializationConstructorMarker serializationConstructorMarker0) {
        if(3 != (v & 3)) {
            PluginExceptionsKt.throwMissingFieldException(v, 3, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.error = s;
        this.errorDescription = s1;
    }

    public AuthErrorResponse(@NotNull String s, @Nullable String s1) {
        q.g(s, "error");
        super();
        this.error = s;
        this.errorDescription = s1;
    }

    @NotNull
    public final String component1() {
        return this.error;
    }

    @Nullable
    public final String component2() {
        return this.errorDescription;
    }

    @NotNull
    public final AuthErrorResponse copy(@NotNull String s, @Nullable String s1) {
        q.g(s, "error");
        return new AuthErrorResponse(s, s1);
    }

    public static AuthErrorResponse copy$default(AuthErrorResponse authErrorResponse0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = authErrorResponse0.error;
        }
        if((v & 2) != 0) {
            s1 = authErrorResponse0.errorDescription;
        }
        return authErrorResponse0.copy(s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AuthErrorResponse)) {
            return false;
        }
        return q.b(this.error, ((AuthErrorResponse)object0).error) ? q.b(this.errorDescription, ((AuthErrorResponse)object0).errorDescription) : false;
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    @Nullable
    public final String getErrorDescription() {
        return this.errorDescription;
    }

    @SerialName("error_description")
    public static void getErrorDescription$annotations() {
    }

    @Override
    public int hashCode() {
        int v = this.error.hashCode();
        return this.errorDescription == null ? v * 0x1F : v * 0x1F + this.errorDescription.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "AuthErrorResponse(error=" + this.error + ", errorDescription=" + this.errorDescription + ")";
    }

    public static final void write$Self(@NotNull AuthErrorResponse authErrorResponse0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(authErrorResponse0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, authErrorResponse0.error);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, authErrorResponse0.errorDescription);
    }
}

