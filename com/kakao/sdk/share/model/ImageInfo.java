package com.kakao.sdk.share.model;

import U4.x;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u000E\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u00020/B/\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u00A2\u0006\u0004\b\t\u0010\nBI\b\u0017\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\b\u0010\r\u001A\u0004\u0018\u00010\f\u00A2\u0006\u0004\b\t\u0010\u000EJ(\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0012H\u00C7\u0001\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001A\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\u0010\u0010\u001D\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001BJB\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u0005H\u00C6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010 \u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b \u0010\u0018J\u0010\u0010!\u001A\u00020\u0005H\u00D6\u0001\u00A2\u0006\u0004\b!\u0010\u001BJ\u001A\u0010$\u001A\u00020#2\b\u0010\"\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010&\u001A\u0004\b\'\u0010\u0018R \u0010\u0004\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010&\u0012\u0004\b)\u0010*\u001A\u0004\b(\u0010\u0018R\u0017\u0010\u0006\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010+\u001A\u0004\b,\u0010\u001BR\u0017\u0010\u0007\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010+\u001A\u0004\b-\u0010\u001BR\u0017\u0010\b\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\b\u0010+\u001A\u0004\b.\u0010\u001B\u00A8\u00061"}, d2 = {"Lcom/kakao/sdk/share/model/ImageInfo;", "", "", "url", "contentType", "", "length", "width", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;III)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;IIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/share/model/ImageInfo;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()I", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;III)Lcom/kakao/sdk/share/model/ImageInfo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "getContentType", "getContentType$annotations", "()V", "I", "getLength", "getWidth", "getHeight", "Companion", "$serializer", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class ImageInfo {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/share/model/ImageInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/share/model/ImageInfo;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/share/model/ImageInfo;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/share/model/ImageInfo;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer imageInfo$$serializer0 = new .serializer();
            .serializer.INSTANCE = imageInfo$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.share.model.ImageInfo", imageInfo$$serializer0, 5);
            pluginGeneratedSerialDescriptor0.addElement("url", false);
            pluginGeneratedSerialDescriptor0.addElement("content_type", false);
            pluginGeneratedSerialDescriptor0.addElement("length", false);
            pluginGeneratedSerialDescriptor0.addElement("width", false);
            pluginGeneratedSerialDescriptor0.addElement("height", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE};
        }

        @NotNull
        public ImageInfo deserialize(@NotNull Decoder decoder0) {
            int v4;
            String s2;
            int v3;
            int v2;
            int v1;
            String s;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                String s1 = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                int v = compositeDecoder0.decodeIntElement(serialDescriptor0, 2);
                v1 = compositeDecoder0.decodeIntElement(serialDescriptor0, 3);
                v2 = compositeDecoder0.decodeIntElement(serialDescriptor0, 4);
                v3 = v;
                s2 = s1;
                v4 = 0x1F;
            }
            else {
                s = null;
                String s3 = null;
                int v5 = 0;
                int v6 = 0;
                int v7 = 0;
                int v8 = 0;
                boolean z = true;
                while(z) {
                    int v9 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v9) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                            v8 |= 1;
                            break;
                        }
                        case 1: {
                            s3 = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                            v8 |= 2;
                            break;
                        }
                        case 2: {
                            v7 = compositeDecoder0.decodeIntElement(serialDescriptor0, 2);
                            v8 |= 4;
                            break;
                        }
                        case 3: {
                            v5 = compositeDecoder0.decodeIntElement(serialDescriptor0, 3);
                            v8 |= 8;
                            break;
                        }
                        case 4: {
                            v6 = compositeDecoder0.decodeIntElement(serialDescriptor0, 4);
                            v8 |= 16;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v9);
                        }
                    }
                }
                v1 = v5;
                v2 = v6;
                v3 = v7;
                s2 = s3;
                v4 = v8;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new ImageInfo(v4, s, s2, v3, v1, v2, null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull ImageInfo imageInfo0) {
            q.g(encoder0, "encoder");
            q.g(imageInfo0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            ImageInfo.write$Self(imageInfo0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((ImageInfo)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/share/model/ImageInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/share/model/ImageInfo;", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String contentType;
    private final int height;
    private final int length;
    @NotNull
    private final String url;
    private final int width;

    static {
        ImageInfo.Companion = new Companion(null);
    }

    @d
    public ImageInfo(int v, String s, @SerialName("content_type") String s1, int v1, int v2, int v3, SerializationConstructorMarker serializationConstructorMarker0) {
        if(0x1F != (v & 0x1F)) {
            PluginExceptionsKt.throwMissingFieldException(v, 0x1F, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.url = s;
        this.contentType = s1;
        this.length = v1;
        this.width = v2;
        this.height = v3;
    }

    public ImageInfo(@NotNull String s, @NotNull String s1, int v, int v1, int v2) {
        q.g(s, "url");
        q.g(s1, "contentType");
        super();
        this.url = s;
        this.contentType = s1;
        this.length = v;
        this.width = v1;
        this.height = v2;
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final String component2() {
        return this.contentType;
    }

    public final int component3() {
        return this.length;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    @NotNull
    public final ImageInfo copy(@NotNull String s, @NotNull String s1, int v, int v1, int v2) {
        q.g(s, "url");
        q.g(s1, "contentType");
        return new ImageInfo(s, s1, v, v1, v2);
    }

    public static ImageInfo copy$default(ImageInfo imageInfo0, String s, String s1, int v, int v1, int v2, int v3, Object object0) {
        if((v3 & 1) != 0) {
            s = imageInfo0.url;
        }
        if((v3 & 2) != 0) {
            s1 = imageInfo0.contentType;
        }
        if((v3 & 4) != 0) {
            v = imageInfo0.length;
        }
        if((v3 & 8) != 0) {
            v1 = imageInfo0.width;
        }
        if((v3 & 16) != 0) {
            v2 = imageInfo0.height;
        }
        return imageInfo0.copy(s, s1, v, v1, v2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ImageInfo)) {
            return false;
        }
        if(!q.b(this.url, ((ImageInfo)object0).url)) {
            return false;
        }
        if(!q.b(this.contentType, ((ImageInfo)object0).contentType)) {
            return false;
        }
        if(this.length != ((ImageInfo)object0).length) {
            return false;
        }
        return this.width == ((ImageInfo)object0).width ? this.height == ((ImageInfo)object0).height : false;
    }

    @NotNull
    public final String getContentType() {
        return this.contentType;
    }

    @SerialName("content_type")
    public static void getContentType$annotations() {
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLength() {
        return this.length;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override
    public int hashCode() {
        return this.height + A7.d.b(this.width, A7.d.b(this.length, x.b(this.url.hashCode() * 0x1F, 0x1F, this.contentType), 0x1F), 0x1F);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = A7.d.o("ImageInfo(url=", this.url, ", contentType=", this.contentType, ", length=");
        x.x(stringBuilder0, this.length, ", width=", this.width, ", height=");
        return x.g(this.height, ")", stringBuilder0);
    }

    public static final void write$Self(@NotNull ImageInfo imageInfo0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(imageInfo0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, imageInfo0.url);
        compositeEncoder0.encodeStringElement(serialDescriptor0, 1, imageInfo0.contentType);
        compositeEncoder0.encodeIntElement(serialDescriptor0, 2, imageInfo0.length);
        compositeEncoder0.encodeIntElement(serialDescriptor0, 3, imageInfo0.width);
        compositeEncoder0.encodeIntElement(serialDescriptor0, 4, imageInfo0.height);
    }
}

