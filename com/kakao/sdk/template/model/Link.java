package com.kakao.sdk.template.model;

import com.kakao.sdk.common.json.MapToQuerySerializer;
import ie.d;
import java.util.Map;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000221BQ\b\u0007\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u00A2\u0006\u0004\b\b\u0010\tBc\b\u0017\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\u0016\b\u0001\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\u0010\r\u001A\u0004\u0018\u00010\f\u00A2\u0006\u0004\b\b\u0010\u000EJ(\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0012H\u00C7\u0001\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u001E\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001E\u0010\u001C\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001BJX\u0010\u001D\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0016\b\u0002\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u00C6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001F\u0010\u0018J\u0010\u0010 \u001A\u00020\nH\u00D6\u0001\u00A2\u0006\u0004\b \u0010!J\u001A\u0010$\u001A\u00020#2\b\u0010\"\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010&\u0012\u0004\b(\u0010)\u001A\u0004\b\'\u0010\u0018R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010&\u0012\u0004\b+\u0010)\u001A\u0004\b*\u0010\u0018R.\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u0010,\u0012\u0004\b.\u0010)\u001A\u0004\b-\u0010\u001BR.\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u0010,\u0012\u0004\b0\u0010)\u001A\u0004\b/\u0010\u001B\u00A8\u00063"}, d2 = {"Lcom/kakao/sdk/template/model/Link;", "", "", "webUrl", "mobileWebUrl", "", "androidExecutionParams", "iosExecutionParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/Link;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lcom/kakao/sdk/template/model/Link;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getWebUrl", "getWebUrl$annotations", "()V", "getMobileWebUrl", "getMobileWebUrl$annotations", "Ljava/util/Map;", "getAndroidExecutionParams", "getAndroidExecutionParams$annotations", "getIosExecutionParams", "getIosExecutionParams$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class Link {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/Link.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/Link;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/Link;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/Link;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer link$$serializer0 = new .serializer();
            .serializer.INSTANCE = link$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.Link", link$$serializer0, 4);
            pluginGeneratedSerialDescriptor0.addElement("web_url", true);
            pluginGeneratedSerialDescriptor0.addElement("mobile_web_url", true);
            pluginGeneratedSerialDescriptor0.addElement("android_execution_params", true);
            pluginGeneratedSerialDescriptor0.addElement("ios_execution_params", true);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(MapToQuerySerializer.INSTANCE), BuiltinSerializersKt.getNullable(MapToQuerySerializer.INSTANCE)};
        }

        @NotNull
        public Link deserialize(@NotNull Decoder decoder0) {
            int v;
            Object object4;
            Object object3;
            Object object2;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                Object object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, StringSerializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, MapToQuerySerializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, MapToQuerySerializer.INSTANCE, null);
                object0 = object1;
                v = 15;
            }
            else {
                int v1 = 0;
                Object object5 = null;
                Object object6 = null;
                Object object7 = null;
                boolean z = true;
                while(z) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, StringSerializer.INSTANCE, object0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, object5);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, MapToQuerySerializer.INSTANCE, object6);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, MapToQuerySerializer.INSTANCE, object7);
                            v1 |= 8;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                object2 = object5;
                object3 = object6;
                object4 = object7;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new Link(v, ((String)object0), ((String)object2), ((Map)object3), ((Map)object4), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull Link link0) {
            q.g(encoder0, "encoder");
            q.g(link0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            Link.write$Self(link0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((Link)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/Link$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/Link;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Map androidExecutionParams;
    @Nullable
    private final Map iosExecutionParams;
    @Nullable
    private final String mobileWebUrl;
    @Nullable
    private final String webUrl;

    static {
        Link.Companion = new Companion(null);
    }

    public Link() {
        this(null, null, null, null, 15, null);
    }

    @d
    public Link(int v, @SerialName("web_url") String s, @SerialName("mobile_web_url") String s1, @SerialName("android_execution_params") @Serializable(with = MapToQuerySerializer.class) Map map0, @SerialName("ios_execution_params") @Serializable(with = MapToQuerySerializer.class) Map map1, SerializationConstructorMarker serializationConstructorMarker0) {
        this.webUrl = (v & 1) == 0 ? null : s;
        this.mobileWebUrl = (v & 2) == 0 ? null : s1;
        this.androidExecutionParams = (v & 4) == 0 ? null : map0;
        if((v & 8) == 0) {
            this.iosExecutionParams = null;
            return;
        }
        this.iosExecutionParams = map1;
    }

    public Link(@Nullable String s) {
        this(s, null, null, null, 14, null);
    }

    public Link(@Nullable String s, @Nullable String s1) {
        this(s, s1, null, null, 12, null);
    }

    public Link(@Nullable String s, @Nullable String s1, @Nullable Map map0) {
        this(s, s1, map0, null, 8, null);
    }

    public Link(@Nullable String s, @Nullable String s1, @Nullable Map map0, @Nullable Map map1) {
        this.webUrl = s;
        this.mobileWebUrl = s1;
        this.androidExecutionParams = map0;
        this.iosExecutionParams = map1;
    }

    public Link(String s, String s1, Map map0, Map map1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            map0 = null;
        }
        if((v & 8) != 0) {
            map1 = null;
        }
        this(s, s1, map0, map1);
    }

    @Nullable
    public final String component1() {
        return this.webUrl;
    }

    @Nullable
    public final String component2() {
        return this.mobileWebUrl;
    }

    @Nullable
    public final Map component3() {
        return this.androidExecutionParams;
    }

    @Nullable
    public final Map component4() {
        return this.iosExecutionParams;
    }

    @NotNull
    public final Link copy(@Nullable String s, @Nullable String s1, @Nullable Map map0, @Nullable Map map1) {
        return new Link(s, s1, map0, map1);
    }

    public static Link copy$default(Link link0, String s, String s1, Map map0, Map map1, int v, Object object0) {
        if((v & 1) != 0) {
            s = link0.webUrl;
        }
        if((v & 2) != 0) {
            s1 = link0.mobileWebUrl;
        }
        if((v & 4) != 0) {
            map0 = link0.androidExecutionParams;
        }
        if((v & 8) != 0) {
            map1 = link0.iosExecutionParams;
        }
        return link0.copy(s, s1, map0, map1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Link)) {
            return false;
        }
        if(!q.b(this.webUrl, ((Link)object0).webUrl)) {
            return false;
        }
        if(!q.b(this.mobileWebUrl, ((Link)object0).mobileWebUrl)) {
            return false;
        }
        return q.b(this.androidExecutionParams, ((Link)object0).androidExecutionParams) ? q.b(this.iosExecutionParams, ((Link)object0).iosExecutionParams) : false;
    }

    @Nullable
    public final Map getAndroidExecutionParams() {
        return this.androidExecutionParams;
    }

    @SerialName("android_execution_params")
    @Serializable(with = MapToQuerySerializer.class)
    public static void getAndroidExecutionParams$annotations() {
    }

    @Nullable
    public final Map getIosExecutionParams() {
        return this.iosExecutionParams;
    }

    @SerialName("ios_execution_params")
    @Serializable(with = MapToQuerySerializer.class)
    public static void getIosExecutionParams$annotations() {
    }

    @Nullable
    public final String getMobileWebUrl() {
        return this.mobileWebUrl;
    }

    @SerialName("mobile_web_url")
    public static void getMobileWebUrl$annotations() {
    }

    @Nullable
    public final String getWebUrl() {
        return this.webUrl;
    }

    @SerialName("web_url")
    public static void getWebUrl$annotations() {
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.webUrl == null ? 0 : this.webUrl.hashCode();
        int v2 = this.mobileWebUrl == null ? 0 : this.mobileWebUrl.hashCode();
        int v3 = this.androidExecutionParams == null ? 0 : this.androidExecutionParams.hashCode();
        Map map0 = this.iosExecutionParams;
        if(map0 != null) {
            v = map0.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = A7.d.o("Link(webUrl=", this.webUrl, ", mobileWebUrl=", this.mobileWebUrl, ", androidExecutionParams=");
        stringBuilder0.append(this.androidExecutionParams);
        stringBuilder0.append(", iosExecutionParams=");
        stringBuilder0.append(this.iosExecutionParams);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    public static final void write$Self(@NotNull Link link0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(link0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 0) || link0.webUrl != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, StringSerializer.INSTANCE, link0.webUrl);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 1) || link0.mobileWebUrl != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, link0.mobileWebUrl);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || link0.androidExecutionParams != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, MapToQuerySerializer.INSTANCE, link0.androidExecutionParams);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || link0.iosExecutionParams != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, MapToQuerySerializer.INSTANCE, link0.iosExecutionParams);
        }
    }
}

