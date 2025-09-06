package com.kakao.sdk.template.model;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0012\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000298BM\b\u0007\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u000B\u0010\fB]\b\u0017\u0012\u0006\u0010\r\u001A\u00020\b\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\b\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u000B\u0010\u0010J(\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0014H\u00C7\u0001\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u0010\u0010\u001C\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0012\u0010\u001E\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001AJ\u0012\u0010\u001F\u001A\u0004\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0012\u0010!\u001A\u0004\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010 JV\u0010\"\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\bH\u00C6\u0001\u00A2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b$\u0010\u001AJ\u0010\u0010%\u001A\u00020\bH\u00D6\u0001\u00A2\u0006\u0004\b%\u0010&J\u001A\u0010)\u001A\u00020(2\b\u0010\'\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b)\u0010*R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010+\u001A\u0004\b,\u0010\u001AR\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010+\u0012\u0004\b.\u0010/\u001A\u0004\b-\u0010\u001AR\u0017\u0010\u0006\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u00100\u001A\u0004\b1\u0010\u001DR\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010+\u001A\u0004\b2\u0010\u001AR\"\u0010\t\u001A\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\t\u00103\u0012\u0004\b5\u0010/\u001A\u0004\b4\u0010 R\"\u0010\n\u001A\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\n\u00103\u0012\u0004\b7\u0010/\u001A\u0004\b6\u0010 \u00A8\u0006:"}, d2 = {"Lcom/kakao/sdk/template/model/Content;", "", "", "title", "imageUrl", "Lcom/kakao/sdk/template/model/Link;", "link", "description", "", "imageWidth", "imageHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/Content;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lcom/kakao/sdk/template/model/Link;", "component4", "component5", "()Ljava/lang/Integer;", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/kakao/sdk/template/model/Content;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getImageUrl", "getImageUrl$annotations", "()V", "Lcom/kakao/sdk/template/model/Link;", "getLink", "getDescription", "Ljava/lang/Integer;", "getImageWidth", "getImageWidth$annotations", "getImageHeight", "getImageHeight$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class Content {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/Content.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/Content;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/Content;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/Content;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer content$$serializer0 = new .serializer();
            .serializer.INSTANCE = content$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.Content", content$$serializer0, 6);
            pluginGeneratedSerialDescriptor0.addElement("title", true);
            pluginGeneratedSerialDescriptor0.addElement("image_url", true);
            pluginGeneratedSerialDescriptor0.addElement("link", false);
            pluginGeneratedSerialDescriptor0.addElement("description", true);
            pluginGeneratedSerialDescriptor0.addElement("image_width", true);
            pluginGeneratedSerialDescriptor0.addElement("image_height", true);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer3 = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
            KSerializer kSerializer4 = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
            return new KSerializer[]{kSerializer0, kSerializer1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, kSerializer2, kSerializer3, kSerializer4};
        }

        @NotNull
        public Content deserialize(@NotNull Decoder decoder0) {
            int v;
            Object object7;
            Object object6;
            Object object4;
            Object object3;
            Object object2;
            Object object1;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, StringSerializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Link..serializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, null);
                Object object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, IntSerializer.INSTANCE, null);
                object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, IntSerializer.INSTANCE, null);
                object7 = object5;
                v = 0x3F;
            }
            else {
                int v1 = 0;
                Object object8 = null;
                Object object9 = null;
                Object object10 = null;
                object7 = null;
                Object object11 = null;
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
                            object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, object8);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object9 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Link..serializer.INSTANCE, object9);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object10 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, object10);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, IntSerializer.INSTANCE, object7);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            object11 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, IntSerializer.INSTANCE, object11);
                            v1 |= 0x20;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                object1 = object0;
                object2 = object8;
                object3 = object9;
                object4 = object10;
                object6 = object11;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new Content(v, ((String)object1), ((String)object2), ((Link)object3), ((String)object4), ((Integer)object7), ((Integer)object6), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull Content content0) {
            q.g(encoder0, "encoder");
            q.g(content0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            Content.write$Self(content0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((Content)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/Content$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/Content;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String description;
    @Nullable
    private final Integer imageHeight;
    @Nullable
    private final String imageUrl;
    @Nullable
    private final Integer imageWidth;
    @NotNull
    private final Link link;
    @Nullable
    private final String title;

    static {
        Content.Companion = new Companion(null);
    }

    @d
    public Content(int v, String s, @SerialName("image_url") String s1, Link link0, String s2, @SerialName("image_width") Integer integer0, @SerialName("image_height") Integer integer1, SerializationConstructorMarker serializationConstructorMarker0) {
        if(4 != (v & 4)) {
            PluginExceptionsKt.throwMissingFieldException(v, 4, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.title = (v & 1) == 0 ? null : s;
        this.imageUrl = (v & 2) == 0 ? null : s1;
        this.link = link0;
        this.description = (v & 8) == 0 ? null : s2;
        this.imageWidth = (v & 16) == 0 ? null : integer0;
        if((v & 0x20) == 0) {
            this.imageHeight = null;
            return;
        }
        this.imageHeight = integer1;
    }

    public Content(@NotNull Link link0) {
        q.g(link0, "link");
        this(null, null, link0, null, null, null, 59, null);
    }

    public Content(@Nullable String s, @NotNull Link link0) {
        q.g(link0, "link");
        this(s, null, link0, null, null, null, 58, null);
    }

    public Content(@Nullable String s, @Nullable String s1, @NotNull Link link0) {
        q.g(link0, "link");
        this(s, s1, link0, null, null, null, 56, null);
    }

    public Content(@Nullable String s, @Nullable String s1, @NotNull Link link0, @Nullable String s2) {
        q.g(link0, "link");
        this(s, s1, link0, s2, null, null, 0x30, null);
    }

    public Content(@Nullable String s, @Nullable String s1, @NotNull Link link0, @Nullable String s2, @Nullable Integer integer0) {
        q.g(link0, "link");
        this(s, s1, link0, s2, integer0, null, 0x20, null);
    }

    public Content(@Nullable String s, @Nullable String s1, @NotNull Link link0, @Nullable String s2, @Nullable Integer integer0, @Nullable Integer integer1) {
        q.g(link0, "link");
        super();
        this.title = s;
        this.imageUrl = s1;
        this.link = link0;
        this.description = s2;
        this.imageWidth = integer0;
        this.imageHeight = integer1;
    }

    public Content(String s, String s1, Link link0, String s2, Integer integer0, Integer integer1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 8) != 0) {
            s2 = null;
        }
        if((v & 16) != 0) {
            integer0 = null;
        }
        this(s, s1, link0, s2, integer0, ((v & 0x20) == 0 ? integer1 : null));
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.imageUrl;
    }

    @NotNull
    public final Link component3() {
        return this.link;
    }

    @Nullable
    public final String component4() {
        return this.description;
    }

    @Nullable
    public final Integer component5() {
        return this.imageWidth;
    }

    @Nullable
    public final Integer component6() {
        return this.imageHeight;
    }

    @NotNull
    public final Content copy(@Nullable String s, @Nullable String s1, @NotNull Link link0, @Nullable String s2, @Nullable Integer integer0, @Nullable Integer integer1) {
        q.g(link0, "link");
        return new Content(s, s1, link0, s2, integer0, integer1);
    }

    public static Content copy$default(Content content0, String s, String s1, Link link0, String s2, Integer integer0, Integer integer1, int v, Object object0) {
        if((v & 1) != 0) {
            s = content0.title;
        }
        if((v & 2) != 0) {
            s1 = content0.imageUrl;
        }
        if((v & 4) != 0) {
            link0 = content0.link;
        }
        if((v & 8) != 0) {
            s2 = content0.description;
        }
        if((v & 16) != 0) {
            integer0 = content0.imageWidth;
        }
        if((v & 0x20) != 0) {
            integer1 = content0.imageHeight;
        }
        return content0.copy(s, s1, link0, s2, integer0, integer1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Content)) {
            return false;
        }
        if(!q.b(this.title, ((Content)object0).title)) {
            return false;
        }
        if(!q.b(this.imageUrl, ((Content)object0).imageUrl)) {
            return false;
        }
        if(!q.b(this.link, ((Content)object0).link)) {
            return false;
        }
        if(!q.b(this.description, ((Content)object0).description)) {
            return false;
        }
        return q.b(this.imageWidth, ((Content)object0).imageWidth) ? q.b(this.imageHeight, ((Content)object0).imageHeight) : false;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getImageHeight() {
        return this.imageHeight;
    }

    @SerialName("image_height")
    public static void getImageHeight$annotations() {
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @SerialName("image_url")
    public static void getImageUrl$annotations() {
    }

    @Nullable
    public final Integer getImageWidth() {
        return this.imageWidth;
    }

    @SerialName("image_width")
    public static void getImageWidth$annotations() {
    }

    @NotNull
    public final Link getLink() {
        return this.link;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.title == null ? 0 : this.title.hashCode();
        int v2 = this.imageUrl == null ? 0 : this.imageUrl.hashCode();
        int v3 = this.link.hashCode();
        int v4 = this.description == null ? 0 : this.description.hashCode();
        int v5 = this.imageWidth == null ? 0 : this.imageWidth.hashCode();
        Integer integer0 = this.imageHeight;
        if(integer0 != null) {
            v = integer0.hashCode();
        }
        return (((v3 + (v1 * 0x1F + v2) * 0x1F) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = A7.d.o("Content(title=", this.title, ", imageUrl=", this.imageUrl, ", link=");
        stringBuilder0.append(this.link);
        stringBuilder0.append(", description=");
        stringBuilder0.append(this.description);
        stringBuilder0.append(", imageWidth=");
        stringBuilder0.append(this.imageWidth);
        stringBuilder0.append(", imageHeight=");
        stringBuilder0.append(this.imageHeight);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    public static final void write$Self(@NotNull Content content0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(content0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 0) || content0.title != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, StringSerializer.INSTANCE, content0.title);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 1) || content0.imageUrl != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, content0.imageUrl);
        }
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Link..serializer.INSTANCE, content0.link);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || content0.description != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, content0.description);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || content0.imageWidth != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, IntSerializer.INSTANCE, content0.imageWidth);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 5) || content0.imageHeight != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, IntSerializer.INSTANCE, content0.imageHeight);
        }
    }
}

