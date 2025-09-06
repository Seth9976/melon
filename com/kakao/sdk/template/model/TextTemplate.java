package com.kakao.sdk.template.model;

import ie.d;
import java.util.List;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000276B7\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\n\u0010\u000BBW\b\u0017\u0012\u0006\u0010\r\u001A\u00020\f\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000E\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F\u00A2\u0006\u0004\b\n\u0010\u0011J(\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0015H\u00C7\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0018\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0012\u0010 \u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u001BJB\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b#\u0010\u001BJ\u0010\u0010$\u001A\u00020\fH\u00D6\u0001\u00A2\u0006\u0004\b$\u0010%J\u001A\u0010)\u001A\u00020(2\b\u0010\'\u001A\u0004\u0018\u00010&H\u00D6\u0003\u00A2\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010+\u001A\u0004\b,\u0010\u001BR\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010-\u001A\u0004\b.\u0010\u001DR\u001F\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\b\u0010/\u001A\u0004\b0\u0010\u001FR\"\u0010\t\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\t\u0010+\u0012\u0004\b2\u00103\u001A\u0004\b1\u0010\u001BR \u0010\u000E\u001A\u00020\u00028\u0006X\u0087D\u00A2\u0006\u0012\n\u0004\b\u000E\u0010+\u0012\u0004\b5\u00103\u001A\u0004\b4\u0010\u001B\u00A8\u00068"}, d2 = {"Lcom/kakao/sdk/template/model/TextTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "", "text", "Lcom/kakao/sdk/template/model/Link;", "link", "", "Lcom/kakao/sdk/template/model/Button;", "buttons", "buttonTitle", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/lang/String;)V", "", "seen1", "objectType", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/TextTemplate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/kakao/sdk/template/model/Link;", "component3", "()Ljava/util/List;", "component4", "copy", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/lang/String;)Lcom/kakao/sdk/template/model/TextTemplate;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Lcom/kakao/sdk/template/model/Link;", "getLink", "Ljava/util/List;", "getButtons", "getButtonTitle", "getButtonTitle$annotations", "()V", "getObjectType", "getObjectType$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class TextTemplate implements DefaultTemplate {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/TextTemplate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/TextTemplate;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/TextTemplate;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/TextTemplate;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer textTemplate$$serializer0 = new .serializer();
            .serializer.INSTANCE = textTemplate$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.TextTemplate", textTemplate$$serializer0, 5);
            pluginGeneratedSerialDescriptor0.addElement("text", false);
            pluginGeneratedSerialDescriptor0.addElement("link", false);
            pluginGeneratedSerialDescriptor0.addElement("buttons", true);
            pluginGeneratedSerialDescriptor0.addElement("button_title", true);
            pluginGeneratedSerialDescriptor0.addElement("object_type", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE));
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            return new KSerializer[]{StringSerializer.INSTANCE, com.kakao.sdk.template.model.Link..serializer.INSTANCE, kSerializer0, kSerializer1, StringSerializer.INSTANCE};
        }

        @NotNull
        public TextTemplate deserialize(@NotNull Decoder decoder0) {
            int v;
            String s3;
            String s2;
            Object object2;
            Object object1;
            Object object0;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            String s = null;
            if(compositeDecoder0.decodeSequentially()) {
                String s1 = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, null);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, null);
                s2 = s1;
                s3 = compositeDecoder0.decodeStringElement(serialDescriptor0, 4);
                v = 0x1F;
            }
            else {
                int v1 = 0;
                Object object3 = null;
                Object object4 = null;
                Object object5 = null;
                String s4 = null;
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
                            object3 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, object3);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), object4);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, object5);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            s4 = compositeDecoder0.decodeStringElement(serialDescriptor0, 4);
                            v1 |= 16;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                s2 = s;
                object0 = object3;
                object1 = object4;
                object2 = object5;
                s3 = s4;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new TextTemplate(v, s2, ((Link)object0), ((List)object1), ((String)object2), s3, null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull TextTemplate textTemplate0) {
            q.g(encoder0, "encoder");
            q.g(textTemplate0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            TextTemplate.write$Self(textTemplate0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((TextTemplate)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/TextTemplate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/TextTemplate;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String buttonTitle;
    @Nullable
    private final List buttons;
    @NotNull
    private final Link link;
    @NotNull
    private final String objectType;
    @NotNull
    private final String text;

    static {
        TextTemplate.Companion = new Companion(null);
    }

    @d
    public TextTemplate(int v, String s, Link link0, List list0, @SerialName("button_title") String s1, @SerialName("object_type") String s2, SerializationConstructorMarker serializationConstructorMarker0) {
        if(19 != (v & 19)) {
            PluginExceptionsKt.throwMissingFieldException(v, 19, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.text = s;
        this.link = link0;
        this.buttons = (v & 4) == 0 ? null : list0;
        this.buttonTitle = (v & 8) == 0 ? null : s1;
        this.objectType = s2;
    }

    public TextTemplate(@NotNull String s, @NotNull Link link0) {
        q.g(s, "text");
        q.g(link0, "link");
        this(s, link0, null, null, 12, null);
    }

    public TextTemplate(@NotNull String s, @NotNull Link link0, @Nullable List list0) {
        q.g(s, "text");
        q.g(link0, "link");
        this(s, link0, list0, null, 8, null);
    }

    public TextTemplate(@NotNull String s, @NotNull Link link0, @Nullable List list0, @Nullable String s1) {
        q.g(s, "text");
        q.g(link0, "link");
        super();
        this.text = s;
        this.link = link0;
        this.buttons = list0;
        this.buttonTitle = s1;
        this.objectType = "text";
    }

    public TextTemplate(String s, Link link0, List list0, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            list0 = null;
        }
        if((v & 8) != 0) {
            s1 = null;
        }
        this(s, link0, list0, s1);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final Link component2() {
        return this.link;
    }

    @Nullable
    public final List component3() {
        return this.buttons;
    }

    @Nullable
    public final String component4() {
        return this.buttonTitle;
    }

    @NotNull
    public final TextTemplate copy(@NotNull String s, @NotNull Link link0, @Nullable List list0, @Nullable String s1) {
        q.g(s, "text");
        q.g(link0, "link");
        return new TextTemplate(s, link0, list0, s1);
    }

    public static TextTemplate copy$default(TextTemplate textTemplate0, String s, Link link0, List list0, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = textTemplate0.text;
        }
        if((v & 2) != 0) {
            link0 = textTemplate0.link;
        }
        if((v & 4) != 0) {
            list0 = textTemplate0.buttons;
        }
        if((v & 8) != 0) {
            s1 = textTemplate0.buttonTitle;
        }
        return textTemplate0.copy(s, link0, list0, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TextTemplate)) {
            return false;
        }
        if(!q.b(this.text, ((TextTemplate)object0).text)) {
            return false;
        }
        if(!q.b(this.link, ((TextTemplate)object0).link)) {
            return false;
        }
        return q.b(this.buttons, ((TextTemplate)object0).buttons) ? q.b(this.buttonTitle, ((TextTemplate)object0).buttonTitle) : false;
    }

    @Nullable
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @SerialName("button_title")
    public static void getButtonTitle$annotations() {
    }

    @Nullable
    public final List getButtons() {
        return this.buttons;
    }

    @NotNull
    public final Link getLink() {
        return this.link;
    }

    @NotNull
    public final String getObjectType() {
        return this.objectType;
    }

    @SerialName("object_type")
    public static void getObjectType$annotations() {
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override
    public int hashCode() {
        int v = this.text.hashCode();
        int v1 = this.link.hashCode();
        int v2 = 0;
        int v3 = this.buttons == null ? 0 : this.buttons.hashCode();
        String s = this.buttonTitle;
        if(s != null) {
            v2 = s.hashCode();
        }
        return ((v1 + v * 0x1F) * 0x1F + v3) * 0x1F + v2;
    }

    @Override
    @NotNull
    public String toString() {
        return "TextTemplate(text=" + this.text + ", link=" + this.link + ", buttons=" + this.buttons + ", buttonTitle=" + this.buttonTitle + ")";
    }

    public static final void write$Self(@NotNull TextTemplate textTemplate0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(textTemplate0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, textTemplate0.text);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, textTemplate0.link);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || textTemplate0.buttons != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), textTemplate0.buttons);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || textTemplate0.buttonTitle != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, textTemplate0.buttonTitle);
        }
        compositeEncoder0.encodeStringElement(serialDescriptor0, 4, textTemplate0.objectType);
    }
}

