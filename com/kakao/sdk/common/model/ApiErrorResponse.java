package com.kakao.sdk.common.model;

import U4.x;
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
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000254BG\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b\n\u0010\u000BB]\b\u0017\u0012\u0006\u0010\f\u001A\u00020\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\u0010\b\u0001\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\b\n\u0010\u000FJ(\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013H\u00C7\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0012\u0010\u001C\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\u0018\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0018\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u001EJT\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u00C6\u0001\u00A2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00020\u0004H\u00D6\u0001\u00A2\u0006\u0004\b\"\u0010\u001BJ\u0010\u0010#\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b#\u0010\u0019J\u001A\u0010&\u001A\u00020%2\b\u0010$\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b&\u0010\'R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010(\u001A\u0004\b)\u0010\u0019R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010*\u001A\u0004\b+\u0010\u001BR\"\u0010\u0006\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u0010*\u0012\u0004\b-\u0010.\u001A\u0004\b,\u0010\u001BR(\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\b\u0010/\u0012\u0004\b1\u0010.\u001A\u0004\b0\u0010\u001ER(\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\t\u0010/\u0012\u0004\b3\u0010.\u001A\u0004\b2\u0010\u001E\u00A8\u00066"}, d2 = {"Lcom/kakao/sdk/common/model/ApiErrorResponse;", "", "", "code", "", "msg", "apiType", "", "requiredScopes", "allowedScopes", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/common/model/ApiErrorResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/util/List;", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/kakao/sdk/common/model/ApiErrorResponse;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "Ljava/lang/String;", "getMsg", "getApiType", "getApiType$annotations", "()V", "Ljava/util/List;", "getRequiredScopes", "getRequiredScopes$annotations", "getAllowedScopes", "getAllowedScopes$annotations", "Companion", "$serializer", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class ApiErrorResponse {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/common/model/ApiErrorResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/common/model/ApiErrorResponse;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/common/model/ApiErrorResponse;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/common/model/ApiErrorResponse;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer apiErrorResponse$$serializer0 = new .serializer();
            .serializer.INSTANCE = apiErrorResponse$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.common.model.ApiErrorResponse", apiErrorResponse$$serializer0, 5);
            pluginGeneratedSerialDescriptor0.addElement("code", false);
            pluginGeneratedSerialDescriptor0.addElement("msg", false);
            pluginGeneratedSerialDescriptor0.addElement("api_type", true);
            pluginGeneratedSerialDescriptor0.addElement("required_scopes", true);
            pluginGeneratedSerialDescriptor0.addElement("allowed_scopes", true);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE));
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE));
            return new KSerializer[]{IntSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializer0, kSerializer1, kSerializer2};
        }

        @NotNull
        public ApiErrorResponse deserialize(@NotNull Decoder decoder0) {
            int v1;
            String s1;
            Object object2;
            Object object1;
            Object object0;
            int v;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                v = compositeDecoder0.decodeIntElement(serialDescriptor0, 0);
                String s = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, null);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(StringSerializer.INSTANCE), null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, new ArrayListSerializer(StringSerializer.INSTANCE), null);
                s1 = s;
                v1 = 0x1F;
            }
            else {
                v = 0;
                String s2 = null;
                Object object3 = null;
                Object object4 = null;
                Object object5 = null;
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
                            v = compositeDecoder0.decodeIntElement(serialDescriptor0, 0);
                            v2 |= 1;
                            break;
                        }
                        case 1: {
                            s2 = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                            v2 |= 2;
                            break;
                        }
                        case 2: {
                            object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, object3);
                            v2 |= 4;
                            break;
                        }
                        case 3: {
                            object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(StringSerializer.INSTANCE), object4);
                            v2 |= 8;
                            break;
                        }
                        case 4: {
                            object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, new ArrayListSerializer(StringSerializer.INSTANCE), object5);
                            v2 |= 16;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v3);
                        }
                    }
                }
                v1 = v2;
                s1 = s2;
                object0 = object3;
                object1 = object4;
                object2 = object5;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new ApiErrorResponse(v1, v, s1, ((String)object0), ((List)object1), ((List)object2), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull ApiErrorResponse apiErrorResponse0) {
            q.g(encoder0, "encoder");
            q.g(apiErrorResponse0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            ApiErrorResponse.write$Self(apiErrorResponse0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((ApiErrorResponse)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/common/model/ApiErrorResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/common/model/ApiErrorResponse;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final List allowedScopes;
    @Nullable
    private final String apiType;
    private final int code;
    @NotNull
    private final String msg;
    @Nullable
    private final List requiredScopes;

    static {
        ApiErrorResponse.Companion = new Companion(null);
    }

    @d
    public ApiErrorResponse(int v, int v1, String s, @SerialName("api_type") String s1, @SerialName("required_scopes") List list0, @SerialName("allowed_scopes") List list1, SerializationConstructorMarker serializationConstructorMarker0) {
        if(3 != (v & 3)) {
            PluginExceptionsKt.throwMissingFieldException(v, 3, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.code = v1;
        this.msg = s;
        this.apiType = (v & 4) == 0 ? null : s1;
        this.requiredScopes = (v & 8) == 0 ? null : list0;
        if((v & 16) == 0) {
            this.allowedScopes = null;
            return;
        }
        this.allowedScopes = list1;
    }

    public ApiErrorResponse(int v, @NotNull String s, @Nullable String s1, @Nullable List list0, @Nullable List list1) {
        q.g(s, "msg");
        super();
        this.code = v;
        this.msg = s;
        this.apiType = s1;
        this.requiredScopes = list0;
        this.allowedScopes = list1;
    }

    public ApiErrorResponse(int v, String s, String s1, List list0, List list1, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 4) != 0) {
            s1 = null;
        }
        if((v1 & 8) != 0) {
            list0 = null;
        }
        this(v, s, s1, list0, ((v1 & 16) == 0 ? list1 : null));
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.msg;
    }

    @Nullable
    public final String component3() {
        return this.apiType;
    }

    @Nullable
    public final List component4() {
        return this.requiredScopes;
    }

    @Nullable
    public final List component5() {
        return this.allowedScopes;
    }

    @NotNull
    public final ApiErrorResponse copy(int v, @NotNull String s, @Nullable String s1, @Nullable List list0, @Nullable List list1) {
        q.g(s, "msg");
        return new ApiErrorResponse(v, s, s1, list0, list1);
    }

    public static ApiErrorResponse copy$default(ApiErrorResponse apiErrorResponse0, int v, String s, String s1, List list0, List list1, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = apiErrorResponse0.code;
        }
        if((v1 & 2) != 0) {
            s = apiErrorResponse0.msg;
        }
        if((v1 & 4) != 0) {
            s1 = apiErrorResponse0.apiType;
        }
        if((v1 & 8) != 0) {
            list0 = apiErrorResponse0.requiredScopes;
        }
        if((v1 & 16) != 0) {
            list1 = apiErrorResponse0.allowedScopes;
        }
        return apiErrorResponse0.copy(v, s, s1, list0, list1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ApiErrorResponse)) {
            return false;
        }
        if(this.code != ((ApiErrorResponse)object0).code) {
            return false;
        }
        if(!q.b(this.msg, ((ApiErrorResponse)object0).msg)) {
            return false;
        }
        if(!q.b(this.apiType, ((ApiErrorResponse)object0).apiType)) {
            return false;
        }
        return q.b(this.requiredScopes, ((ApiErrorResponse)object0).requiredScopes) ? q.b(this.allowedScopes, ((ApiErrorResponse)object0).allowedScopes) : false;
    }

    @Nullable
    public final List getAllowedScopes() {
        return this.allowedScopes;
    }

    @SerialName("allowed_scopes")
    public static void getAllowedScopes$annotations() {
    }

    @Nullable
    public final String getApiType() {
        return this.apiType;
    }

    @SerialName("api_type")
    public static void getApiType$annotations() {
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final List getRequiredScopes() {
        return this.requiredScopes;
    }

    @SerialName("required_scopes")
    public static void getRequiredScopes$annotations() {
    }

    @Override
    public int hashCode() {
        int v = x.b(this.code * 0x1F, 0x1F, this.msg);
        int v1 = 0;
        int v2 = this.apiType == null ? 0 : this.apiType.hashCode();
        int v3 = this.requiredScopes == null ? 0 : this.requiredScopes.hashCode();
        List list0 = this.allowedScopes;
        if(list0 != null) {
            v1 = list0.hashCode();
        }
        return ((v + v2) * 0x1F + v3) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = x.o(this.code, "ApiErrorResponse(code=", ", msg=", this.msg, ", apiType=");
        stringBuilder0.append(this.apiType);
        stringBuilder0.append(", requiredScopes=");
        stringBuilder0.append(this.requiredScopes);
        stringBuilder0.append(", allowedScopes=");
        return Y.m(stringBuilder0, this.allowedScopes, ")");
    }

    public static final void write$Self(@NotNull ApiErrorResponse apiErrorResponse0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(apiErrorResponse0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeIntElement(serialDescriptor0, 0, apiErrorResponse0.code);
        compositeEncoder0.encodeStringElement(serialDescriptor0, 1, apiErrorResponse0.msg);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || apiErrorResponse0.apiType != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, apiErrorResponse0.apiType);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || apiErrorResponse0.requiredScopes != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(StringSerializer.INSTANCE), apiErrorResponse0.requiredScopes);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || apiErrorResponse0.allowedScopes != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, new ArrayListSerializer(StringSerializer.INSTANCE), apiErrorResponse0.allowedScopes);
        }
    }
}

