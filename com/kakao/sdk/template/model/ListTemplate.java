package com.kakao.sdk.template.model;

import U4.x;
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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0013\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002=<BE\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\f\u0010\rBk\b\u0017\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0010\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\f\u0010\u0013J(\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0014\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0017H\u00C7\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0016\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00C6\u0003\u00A2\u0006\u0004\b \u0010!J\u0018\u0010\"\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010!J\u0012\u0010#\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b#\u0010\u001DJR\u0010$\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\u001DJ\u0010\u0010\'\u001A\u00020\u000EH\u00D6\u0001\u00A2\u0006\u0004\b\'\u0010(J\u001A\u0010,\u001A\u00020+2\b\u0010*\u001A\u0004\u0018\u00010)H\u00D6\u0003\u00A2\u0006\u0004\b,\u0010-R \u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010.\u0012\u0004\b0\u00101\u001A\u0004\b/\u0010\u001DR \u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u00102\u0012\u0004\b4\u00101\u001A\u0004\b3\u0010\u001FR\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00A2\u0006\f\n\u0004\b\b\u00105\u001A\u0004\b6\u0010!R\u001F\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\n\u00105\u001A\u0004\b7\u0010!R\"\u0010\u000B\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000B\u0010.\u0012\u0004\b9\u00101\u001A\u0004\b8\u0010\u001DR \u0010\u0010\u001A\u00020\u00028\u0006X\u0087D\u00A2\u0006\u0012\n\u0004\b\u0010\u0010.\u0012\u0004\b;\u00101\u001A\u0004\b:\u0010\u001D\u00A8\u0006>"}, d2 = {"Lcom/kakao/sdk/template/model/ListTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "", "headerTitle", "Lcom/kakao/sdk/template/model/Link;", "headerLink", "", "Lcom/kakao/sdk/template/model/Content;", "contents", "Lcom/kakao/sdk/template/model/Button;", "buttons", "buttonTitle", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "", "seen1", "objectType", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/ListTemplate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/kakao/sdk/template/model/Link;", "component3", "()Ljava/util/List;", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/kakao/sdk/template/model/ListTemplate;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getHeaderTitle", "getHeaderTitle$annotations", "()V", "Lcom/kakao/sdk/template/model/Link;", "getHeaderLink", "getHeaderLink$annotations", "Ljava/util/List;", "getContents", "getButtons", "getButtonTitle", "getButtonTitle$annotations", "getObjectType", "getObjectType$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class ListTemplate implements DefaultTemplate {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/ListTemplate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/ListTemplate;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/ListTemplate;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/ListTemplate;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer listTemplate$$serializer0 = new .serializer();
            .serializer.INSTANCE = listTemplate$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.ListTemplate", listTemplate$$serializer0, 6);
            pluginGeneratedSerialDescriptor0.addElement("header_title", false);
            pluginGeneratedSerialDescriptor0.addElement("header_link", false);
            pluginGeneratedSerialDescriptor0.addElement("contents", false);
            pluginGeneratedSerialDescriptor0.addElement("buttons", true);
            pluginGeneratedSerialDescriptor0.addElement("button_title", true);
            pluginGeneratedSerialDescriptor0.addElement("object_type", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            ArrayListSerializer arrayListSerializer0 = new ArrayListSerializer(com.kakao.sdk.template.model.Content..serializer.INSTANCE);
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE));
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            return new KSerializer[]{StringSerializer.INSTANCE, com.kakao.sdk.template.model.Link..serializer.INSTANCE, arrayListSerializer0, kSerializer0, kSerializer1, StringSerializer.INSTANCE};
        }

        @NotNull
        public ListTemplate deserialize(@NotNull Decoder decoder0) {
            int v;
            String s3;
            String s2;
            Object object3;
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
                object1 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Content..serializer.INSTANCE), null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, null);
                s2 = s1;
                s3 = compositeDecoder0.decodeStringElement(serialDescriptor0, 5);
                v = 0x3F;
            }
            else {
                int v1 = 0;
                Object object4 = null;
                Object object5 = null;
                Object object6 = null;
                Object object7 = null;
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
                            object4 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, object4);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object5 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Content..serializer.INSTANCE), object5);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), object6);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, object7);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            s4 = compositeDecoder0.decodeStringElement(serialDescriptor0, 5);
                            v1 |= 0x20;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                s2 = s;
                object0 = object4;
                object1 = object5;
                object2 = object6;
                object3 = object7;
                s3 = s4;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new ListTemplate(v, s2, ((Link)object0), ((List)object1), ((List)object2), ((String)object3), s3, null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull ListTemplate listTemplate0) {
            q.g(encoder0, "encoder");
            q.g(listTemplate0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            ListTemplate.write$Self(listTemplate0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((ListTemplate)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/ListTemplate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/ListTemplate;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final List contents;
    @NotNull
    private final Link headerLink;
    @NotNull
    private final String headerTitle;
    @NotNull
    private final String objectType;

    static {
        ListTemplate.Companion = new Companion(null);
    }

    @d
    public ListTemplate(int v, @SerialName("header_title") String s, @SerialName("header_link") Link link0, List list0, List list1, @SerialName("button_title") String s1, @SerialName("object_type") String s2, SerializationConstructorMarker serializationConstructorMarker0) {
        if(39 != (v & 39)) {
            PluginExceptionsKt.throwMissingFieldException(v, 39, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.headerTitle = s;
        this.headerLink = link0;
        this.contents = list0;
        this.buttons = (v & 8) == 0 ? null : list1;
        this.buttonTitle = (v & 16) == 0 ? null : s1;
        this.objectType = s2;
    }

    public ListTemplate(@NotNull String s, @NotNull Link link0, @NotNull List list0) {
        q.g(s, "headerTitle");
        q.g(link0, "headerLink");
        q.g(list0, "contents");
        this(s, link0, list0, null, null, 24, null);
    }

    public ListTemplate(@NotNull String s, @NotNull Link link0, @NotNull List list0, @Nullable List list1) {
        q.g(s, "headerTitle");
        q.g(link0, "headerLink");
        q.g(list0, "contents");
        this(s, link0, list0, list1, null, 16, null);
    }

    public ListTemplate(@NotNull String s, @NotNull Link link0, @NotNull List list0, @Nullable List list1, @Nullable String s1) {
        q.g(s, "headerTitle");
        q.g(link0, "headerLink");
        q.g(list0, "contents");
        super();
        this.headerTitle = s;
        this.headerLink = link0;
        this.contents = list0;
        this.buttons = list1;
        this.buttonTitle = s1;
        this.objectType = "list";
    }

    public ListTemplate(String s, Link link0, List list0, List list1, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 8) != 0) {
            list1 = null;
        }
        this(s, link0, list0, list1, ((v & 16) == 0 ? s1 : null));
    }

    @NotNull
    public final String component1() {
        return this.headerTitle;
    }

    @NotNull
    public final Link component2() {
        return this.headerLink;
    }

    @NotNull
    public final List component3() {
        return this.contents;
    }

    @Nullable
    public final List component4() {
        return this.buttons;
    }

    @Nullable
    public final String component5() {
        return this.buttonTitle;
    }

    @NotNull
    public final ListTemplate copy(@NotNull String s, @NotNull Link link0, @NotNull List list0, @Nullable List list1, @Nullable String s1) {
        q.g(s, "headerTitle");
        q.g(link0, "headerLink");
        q.g(list0, "contents");
        return new ListTemplate(s, link0, list0, list1, s1);
    }

    public static ListTemplate copy$default(ListTemplate listTemplate0, String s, Link link0, List list0, List list1, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = listTemplate0.headerTitle;
        }
        if((v & 2) != 0) {
            link0 = listTemplate0.headerLink;
        }
        if((v & 4) != 0) {
            list0 = listTemplate0.contents;
        }
        if((v & 8) != 0) {
            list1 = listTemplate0.buttons;
        }
        if((v & 16) != 0) {
            s1 = listTemplate0.buttonTitle;
        }
        return listTemplate0.copy(s, link0, list0, list1, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ListTemplate)) {
            return false;
        }
        if(!q.b(this.headerTitle, ((ListTemplate)object0).headerTitle)) {
            return false;
        }
        if(!q.b(this.headerLink, ((ListTemplate)object0).headerLink)) {
            return false;
        }
        if(!q.b(this.contents, ((ListTemplate)object0).contents)) {
            return false;
        }
        return q.b(this.buttons, ((ListTemplate)object0).buttons) ? q.b(this.buttonTitle, ((ListTemplate)object0).buttonTitle) : false;
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
    public final List getContents() {
        return this.contents;
    }

    @NotNull
    public final Link getHeaderLink() {
        return this.headerLink;
    }

    @SerialName("header_link")
    public static void getHeaderLink$annotations() {
    }

    @NotNull
    public final String getHeaderTitle() {
        return this.headerTitle;
    }

    @SerialName("header_title")
    public static void getHeaderTitle$annotations() {
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
        int v = A7.d.d((this.headerLink.hashCode() + this.headerTitle.hashCode() * 0x1F) * 0x1F, 0x1F, this.contents);
        int v1 = 0;
        int v2 = this.buttons == null ? 0 : this.buttons.hashCode();
        String s = this.buttonTitle;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ListTemplate(headerTitle=");
        stringBuilder0.append(this.headerTitle);
        stringBuilder0.append(", headerLink=");
        stringBuilder0.append(this.headerLink);
        stringBuilder0.append(", contents=");
        stringBuilder0.append(this.contents);
        stringBuilder0.append(", buttons=");
        stringBuilder0.append(this.buttons);
        stringBuilder0.append(", buttonTitle=");
        return x.m(stringBuilder0, this.buttonTitle, ")");
    }

    public static final void write$Self(@NotNull ListTemplate listTemplate0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(listTemplate0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, listTemplate0.headerTitle);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Link..serializer.INSTANCE, listTemplate0.headerLink);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 2, new ArrayListSerializer(com.kakao.sdk.template.model.Content..serializer.INSTANCE), listTemplate0.contents);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || listTemplate0.buttons != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), listTemplate0.buttons);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || listTemplate0.buttonTitle != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, listTemplate0.buttonTitle);
        }
        compositeEncoder0.encodeStringElement(serialDescriptor0, 5, listTemplate0.objectType);
    }
}

