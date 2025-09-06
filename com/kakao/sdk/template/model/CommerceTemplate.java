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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0002:9B7\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\u000B\u0010\fBW\b\u0017\u0012\u0006\u0010\u000E\u001A\u00020\r\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000F\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u000B\u0010\u0012J(\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016H\u00C7\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0018\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0012\u0010!\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\"JB\u0010#\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\tH\u00C6\u0001\u00A2\u0006\u0004\b#\u0010$J\u0010\u0010%\u001A\u00020\tH\u00D6\u0001\u00A2\u0006\u0004\b%\u0010\"J\u0010\u0010&\u001A\u00020\rH\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\'J\u001A\u0010+\u001A\u00020*2\b\u0010)\u001A\u0004\u0018\u00010(H\u00D6\u0003\u00A2\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010-\u001A\u0004\b.\u0010\u001CR\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010/\u001A\u0004\b0\u0010\u001ER\u001F\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\b\u00101\u001A\u0004\b2\u0010 R\"\u0010\n\u001A\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\n\u00103\u0012\u0004\b5\u00106\u001A\u0004\b4\u0010\"R \u0010\u000F\u001A\u00020\t8\u0006X\u0087D\u00A2\u0006\u0012\n\u0004\b\u000F\u00103\u0012\u0004\b8\u00106\u001A\u0004\b7\u0010\"\u00A8\u0006;"}, d2 = {"Lcom/kakao/sdk/template/model/CommerceTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Lcom/kakao/sdk/template/model/Content;", "content", "Lcom/kakao/sdk/template/model/Commerce;", "commerce", "", "Lcom/kakao/sdk/template/model/Button;", "buttons", "", "buttonTitle", "<init>", "(Lcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/Commerce;Ljava/util/List;Ljava/lang/String;)V", "", "seen1", "objectType", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/Commerce;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/CommerceTemplate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Lcom/kakao/sdk/template/model/Content;", "component2", "()Lcom/kakao/sdk/template/model/Commerce;", "component3", "()Ljava/util/List;", "component4", "()Ljava/lang/String;", "copy", "(Lcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/Commerce;Ljava/util/List;Ljava/lang/String;)Lcom/kakao/sdk/template/model/CommerceTemplate;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/kakao/sdk/template/model/Content;", "getContent", "Lcom/kakao/sdk/template/model/Commerce;", "getCommerce", "Ljava/util/List;", "getButtons", "Ljava/lang/String;", "getButtonTitle", "getButtonTitle$annotations", "()V", "getObjectType", "getObjectType$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class CommerceTemplate implements DefaultTemplate {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/CommerceTemplate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/CommerceTemplate;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/CommerceTemplate;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/CommerceTemplate;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer commerceTemplate$$serializer0 = new .serializer();
            .serializer.INSTANCE = commerceTemplate$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.CommerceTemplate", commerceTemplate$$serializer0, 5);
            pluginGeneratedSerialDescriptor0.addElement("content", false);
            pluginGeneratedSerialDescriptor0.addElement("commerce", false);
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
            return new KSerializer[]{com.kakao.sdk.template.model.Content..serializer.INSTANCE, com.kakao.sdk.template.model.Commerce..serializer.INSTANCE, kSerializer0, kSerializer1, StringSerializer.INSTANCE};
        }

        @NotNull
        public CommerceTemplate deserialize(@NotNull Decoder decoder0) {
            String s;
            int v;
            Object object4;
            Object object3;
            Object object2;
            Object object1;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                object1 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.template.model.Content..serializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Commerce..serializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, null);
                v = 0x1F;
                s = compositeDecoder0.decodeStringElement(serialDescriptor0, 4);
            }
            else {
                int v1 = 0;
                Object object5 = null;
                Object object6 = null;
                Object object7 = null;
                String s1 = null;
                boolean z = true;
                while(z) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.template.model.Content..serializer.INSTANCE, object0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            object5 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Commerce..serializer.INSTANCE, object5);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), object6);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, object7);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            s1 = compositeDecoder0.decodeStringElement(serialDescriptor0, 4);
                            v1 |= 16;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                object1 = object0;
                object2 = object5;
                object3 = object6;
                object4 = object7;
                s = s1;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new CommerceTemplate(v, ((Content)object1), ((Commerce)object2), ((List)object3), ((String)object4), s, null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull CommerceTemplate commerceTemplate0) {
            q.g(encoder0, "encoder");
            q.g(commerceTemplate0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            CommerceTemplate.write$Self(commerceTemplate0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((CommerceTemplate)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/CommerceTemplate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/CommerceTemplate;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Commerce commerce;
    @NotNull
    private final Content content;
    @NotNull
    private final String objectType;

    static {
        CommerceTemplate.Companion = new Companion(null);
    }

    @d
    public CommerceTemplate(int v, Content content0, Commerce commerce0, List list0, @SerialName("button_title") String s, @SerialName("object_type") String s1, SerializationConstructorMarker serializationConstructorMarker0) {
        if(19 != (v & 19)) {
            PluginExceptionsKt.throwMissingFieldException(v, 19, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.content = content0;
        this.commerce = commerce0;
        this.buttons = (v & 4) == 0 ? null : list0;
        this.buttonTitle = (v & 8) == 0 ? null : s;
        this.objectType = s1;
    }

    public CommerceTemplate(@NotNull Content content0, @NotNull Commerce commerce0) {
        q.g(content0, "content");
        q.g(commerce0, "commerce");
        this(content0, commerce0, null, null, 12, null);
    }

    public CommerceTemplate(@NotNull Content content0, @NotNull Commerce commerce0, @Nullable List list0) {
        q.g(content0, "content");
        q.g(commerce0, "commerce");
        this(content0, commerce0, list0, null, 8, null);
    }

    public CommerceTemplate(@NotNull Content content0, @NotNull Commerce commerce0, @Nullable List list0, @Nullable String s) {
        q.g(content0, "content");
        q.g(commerce0, "commerce");
        super();
        this.content = content0;
        this.commerce = commerce0;
        this.buttons = list0;
        this.buttonTitle = s;
        this.objectType = "commerce";
    }

    public CommerceTemplate(Content content0, Commerce commerce0, List list0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            list0 = null;
        }
        if((v & 8) != 0) {
            s = null;
        }
        this(content0, commerce0, list0, s);
    }

    @NotNull
    public final Content component1() {
        return this.content;
    }

    @NotNull
    public final Commerce component2() {
        return this.commerce;
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
    public final CommerceTemplate copy(@NotNull Content content0, @NotNull Commerce commerce0, @Nullable List list0, @Nullable String s) {
        q.g(content0, "content");
        q.g(commerce0, "commerce");
        return new CommerceTemplate(content0, commerce0, list0, s);
    }

    public static CommerceTemplate copy$default(CommerceTemplate commerceTemplate0, Content content0, Commerce commerce0, List list0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            content0 = commerceTemplate0.content;
        }
        if((v & 2) != 0) {
            commerce0 = commerceTemplate0.commerce;
        }
        if((v & 4) != 0) {
            list0 = commerceTemplate0.buttons;
        }
        if((v & 8) != 0) {
            s = commerceTemplate0.buttonTitle;
        }
        return commerceTemplate0.copy(content0, commerce0, list0, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CommerceTemplate)) {
            return false;
        }
        if(!q.b(this.content, ((CommerceTemplate)object0).content)) {
            return false;
        }
        if(!q.b(this.commerce, ((CommerceTemplate)object0).commerce)) {
            return false;
        }
        return q.b(this.buttons, ((CommerceTemplate)object0).buttons) ? q.b(this.buttonTitle, ((CommerceTemplate)object0).buttonTitle) : false;
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
    public final Commerce getCommerce() {
        return this.commerce;
    }

    @NotNull
    public final Content getContent() {
        return this.content;
    }

    @NotNull
    public final String getObjectType() {
        return this.objectType;
    }

    @SerialName("object_type")
    public static void getObjectType$annotations() {
    }

    @Override
    public int hashCode() {
        int v = this.content.hashCode();
        int v1 = this.commerce.hashCode();
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
        return "CommerceTemplate(content=" + this.content + ", commerce=" + this.commerce + ", buttons=" + this.buttons + ", buttonTitle=" + this.buttonTitle + ")";
    }

    public static final void write$Self(@NotNull CommerceTemplate commerceTemplate0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(commerceTemplate0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.template.model.Content..serializer.INSTANCE, commerceTemplate0.content);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Commerce..serializer.INSTANCE, commerceTemplate0.commerce);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || commerceTemplate0.buttons != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), commerceTemplate0.buttons);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || commerceTemplate0.buttonTitle != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, commerceTemplate0.buttonTitle);
        }
        compositeEncoder0.encodeStringElement(serialDescriptor0, 4, commerceTemplate0.objectType);
    }
}

