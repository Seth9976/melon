package com.kakao.sdk.share.model;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0017\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ(\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EHÇ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001A\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001A\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ\u001A\u0010\u001E\u001A\u00020\u001D2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001E\u0010\u001FR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001A\u0004\b!\u0010\u0014¨\u0006$"}, d2 = {"Lcom/kakao/sdk/share/model/ImageUploadResult;", "", "Lcom/kakao/sdk/share/model/ImageInfos;", "infos", "<init>", "(Lcom/kakao/sdk/share/model/ImageInfos;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/kakao/sdk/share/model/ImageInfos;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/share/model/ImageUploadResult;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Lcom/kakao/sdk/share/model/ImageInfos;", "copy", "(Lcom/kakao/sdk/share/model/ImageInfos;)Lcom/kakao/sdk/share/model/ImageUploadResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/kakao/sdk/share/model/ImageInfos;", "getInfos", "Companion", "$serializer", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class ImageUploadResult {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/share/model/ImageUploadResult.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/share/model/ImageUploadResult;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/share/model/ImageUploadResult;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/share/model/ImageUploadResult;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer imageUploadResult$$serializer0 = new .serializer();
            .serializer.INSTANCE = imageUploadResult$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.share.model.ImageUploadResult", imageUploadResult$$serializer0, 1);
            pluginGeneratedSerialDescriptor0.addElement("infos", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{com.kakao.sdk.share.model.ImageInfos..serializer.INSTANCE};
        }

        @NotNull
        public ImageUploadResult deserialize(@NotNull Decoder decoder0) {
            Object object0;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            int v = 1;
            if(compositeDecoder0.decodeSequentially()) {
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.share.model.ImageInfos..serializer.INSTANCE, null);
            }
            else {
                int v1 = 0;
                object0 = null;
                boolean z = true;
                while(z) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.share.model.ImageInfos..serializer.INSTANCE, object0);
                            v1 = 1;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new ImageUploadResult(v, ((ImageInfos)object0), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull ImageUploadResult imageUploadResult0) {
            q.g(encoder0, "encoder");
            q.g(imageUploadResult0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            ImageUploadResult.write$Self(imageUploadResult0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((ImageUploadResult)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/share/model/ImageUploadResult$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/share/model/ImageUploadResult;", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final ImageInfos infos;

    static {
        ImageUploadResult.Companion = new Companion(null);
    }

    @d
    public ImageUploadResult(int v, ImageInfos imageInfos0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(1 != (v & 1)) {
            PluginExceptionsKt.throwMissingFieldException(v, 1, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.infos = imageInfos0;
    }

    public ImageUploadResult(@NotNull ImageInfos imageInfos0) {
        q.g(imageInfos0, "infos");
        super();
        this.infos = imageInfos0;
    }

    @NotNull
    public final ImageInfos component1() {
        return this.infos;
    }

    @NotNull
    public final ImageUploadResult copy(@NotNull ImageInfos imageInfos0) {
        q.g(imageInfos0, "infos");
        return new ImageUploadResult(imageInfos0);
    }

    public static ImageUploadResult copy$default(ImageUploadResult imageUploadResult0, ImageInfos imageInfos0, int v, Object object0) {
        if((v & 1) != 0) {
            imageInfos0 = imageUploadResult0.infos;
        }
        return imageUploadResult0.copy(imageInfos0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ImageUploadResult ? q.b(this.infos, ((ImageUploadResult)object0).infos) : false;
    }

    @NotNull
    public final ImageInfos getInfos() {
        return this.infos;
    }

    @Override
    public int hashCode() {
        return this.infos.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "ImageUploadResult(infos=" + this.infos + ")";
    }

    public static final void write$Self(@NotNull ImageUploadResult imageUploadResult0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(imageUploadResult0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.share.model.ImageInfos..serializer.INSTANCE, imageUploadResult0.infos);
    }
}

