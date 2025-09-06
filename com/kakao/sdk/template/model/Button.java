package com.kakao.sdk.template.model;

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
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002\'&B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0017\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0013\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001B\u0010\u0016J\u0010\u0010\u001C\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\u001A\u0010 \u001A\u00020\u001F2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001A\u0004\b#\u0010\u0016R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001A\u0004\b%\u0010\u0018¨\u0006("}, d2 = {"Lcom/kakao/sdk/template/model/Button;", "", "", "title", "Lcom/kakao/sdk/template/model/Link;", "link", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/kakao/sdk/template/model/Link;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/Button;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/kakao/sdk/template/model/Link;", "copy", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;)Lcom/kakao/sdk/template/model/Button;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Lcom/kakao/sdk/template/model/Link;", "getLink", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class Button {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/Button.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/Button;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/Button;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/Button;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer button$$serializer0 = new .serializer();
            .serializer.INSTANCE = button$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.Button", button$$serializer0, 2);
            pluginGeneratedSerialDescriptor0.addElement("title", false);
            pluginGeneratedSerialDescriptor0.addElement("link", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, com.kakao.sdk.template.model.Link..serializer.INSTANCE};
        }

        @NotNull
        public Button deserialize(@NotNull Decoder decoder0) {
            int v;
            Object object0;
            String s;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, null);
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
                            object1 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, object1);
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
            return new Button(v, s, ((Link)object0), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull Button button0) {
            q.g(encoder0, "encoder");
            q.g(button0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            Button.write$Self(button0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((Button)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/Button$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/Button;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Link link;
    @NotNull
    private final String title;

    static {
        Button.Companion = new Companion(null);
    }

    @d
    public Button(int v, String s, Link link0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(3 != (v & 3)) {
            PluginExceptionsKt.throwMissingFieldException(v, 3, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.title = s;
        this.link = link0;
    }

    public Button(@NotNull String s, @NotNull Link link0) {
        q.g(s, "title");
        q.g(link0, "link");
        super();
        this.title = s;
        this.link = link0;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final Link component2() {
        return this.link;
    }

    @NotNull
    public final Button copy(@NotNull String s, @NotNull Link link0) {
        q.g(s, "title");
        q.g(link0, "link");
        return new Button(s, link0);
    }

    public static Button copy$default(Button button0, String s, Link link0, int v, Object object0) {
        if((v & 1) != 0) {
            s = button0.title;
        }
        if((v & 2) != 0) {
            link0 = button0.link;
        }
        return button0.copy(s, link0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Button)) {
            return false;
        }
        return q.b(this.title, ((Button)object0).title) ? q.b(this.link, ((Button)object0).link) : false;
    }

    @NotNull
    public final Link getLink() {
        return this.link;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override
    public int hashCode() {
        return this.link.hashCode() + this.title.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "Button(title=" + this.title + ", link=" + this.link + ")";
    }

    public static final void write$Self(@NotNull Button button0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(button0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, button0.title);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, button0.link);
    }
}

