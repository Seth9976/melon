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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0002:9B3\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00A2\u0006\u0004\b\u000B\u0010\fBW\b\u0017\u0012\u0006\u0010\u000E\u001A\u00020\r\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0001\u0010\u000F\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u000B\u0010\u0012J(\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016H\u00C7\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0018\u0010!\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\"J@\u0010#\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00C6\u0001\u00A2\u0006\u0004\b#\u0010$J\u0010\u0010%\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b%\u0010\u001CJ\u0010\u0010&\u001A\u00020\rH\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\'J\u001A\u0010+\u001A\u00020*2\b\u0010)\u001A\u0004\u0018\u00010(H\u00D6\u0003\u00A2\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010-\u001A\u0004\b.\u0010\u001CR \u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u0010/\u0012\u0004\b1\u00102\u001A\u0004\b0\u0010\u001ER\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u00103\u001A\u0004\b4\u0010 R\u001F\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006\u00A2\u0006\f\n\u0004\b\n\u00105\u001A\u0004\b6\u0010\"R \u0010\u000F\u001A\u00020\u00028\u0006X\u0087D\u00A2\u0006\u0012\n\u0004\b\u000F\u0010-\u0012\u0004\b8\u00102\u001A\u0004\b7\u0010\u001C\u00A8\u0006;"}, d2 = {"Lcom/kakao/sdk/template/model/CalendarTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "", "id", "Lcom/kakao/sdk/template/model/IdType;", "idType", "Lcom/kakao/sdk/template/model/Content;", "content", "", "Lcom/kakao/sdk/template/model/Button;", "buttons", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/IdType;Lcom/kakao/sdk/template/model/Content;Ljava/util/List;)V", "", "seen1", "objectType", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/kakao/sdk/template/model/IdType;Lcom/kakao/sdk/template/model/Content;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/CalendarTemplate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/kakao/sdk/template/model/IdType;", "component3", "()Lcom/kakao/sdk/template/model/Content;", "component4", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/IdType;Lcom/kakao/sdk/template/model/Content;Ljava/util/List;)Lcom/kakao/sdk/template/model/CalendarTemplate;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lcom/kakao/sdk/template/model/IdType;", "getIdType", "getIdType$annotations", "()V", "Lcom/kakao/sdk/template/model/Content;", "getContent", "Ljava/util/List;", "getButtons", "getObjectType", "getObjectType$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class CalendarTemplate implements DefaultTemplate {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/CalendarTemplate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/CalendarTemplate;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/CalendarTemplate;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/CalendarTemplate;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer calendarTemplate$$serializer0 = new .serializer();
            .serializer.INSTANCE = calendarTemplate$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.CalendarTemplate", calendarTemplate$$serializer0, 5);
            pluginGeneratedSerialDescriptor0.addElement("id", false);
            pluginGeneratedSerialDescriptor0.addElement("id_type", false);
            pluginGeneratedSerialDescriptor0.addElement("content", false);
            pluginGeneratedSerialDescriptor0.addElement("buttons", true);
            pluginGeneratedSerialDescriptor0.addElement("object_type", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = IdType.Companion.serializer();
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE));
            return new KSerializer[]{StringSerializer.INSTANCE, kSerializer0, com.kakao.sdk.template.model.Content..serializer.INSTANCE, kSerializer1, StringSerializer.INSTANCE};
        }

        @NotNull
        public CalendarTemplate deserialize(@NotNull Decoder decoder0) {
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
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, IdType.Companion.serializer(), null);
                object1 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Content..serializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), null);
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
                            object3 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, IdType.Companion.serializer(), object3);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object4 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Content..serializer.INSTANCE, object4);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), object5);
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
            return new CalendarTemplate(v, s2, ((IdType)object0), ((Content)object1), ((List)object2), s3, null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull CalendarTemplate calendarTemplate0) {
            q.g(encoder0, "encoder");
            q.g(calendarTemplate0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            CalendarTemplate.write$Self(calendarTemplate0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((CalendarTemplate)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/CalendarTemplate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/CalendarTemplate;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final List buttons;
    @NotNull
    private final Content content;
    @NotNull
    private final String id;
    @NotNull
    private final IdType idType;
    @NotNull
    private final String objectType;

    static {
        CalendarTemplate.Companion = new Companion(null);
    }

    @d
    public CalendarTemplate(int v, String s, @SerialName("id_type") IdType idType0, Content content0, List list0, @SerialName("object_type") String s1, SerializationConstructorMarker serializationConstructorMarker0) {
        if(23 != (v & 23)) {
            PluginExceptionsKt.throwMissingFieldException(v, 23, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.id = s;
        this.idType = idType0;
        this.content = content0;
        this.buttons = (v & 8) == 0 ? null : list0;
        this.objectType = s1;
    }

    public CalendarTemplate(@NotNull String s, @NotNull IdType idType0, @NotNull Content content0) {
        q.g(s, "id");
        q.g(idType0, "idType");
        q.g(content0, "content");
        this(s, idType0, content0, null, 8, null);
    }

    public CalendarTemplate(@NotNull String s, @NotNull IdType idType0, @NotNull Content content0, @Nullable List list0) {
        q.g(s, "id");
        q.g(idType0, "idType");
        q.g(content0, "content");
        super();
        this.id = s;
        this.idType = idType0;
        this.content = content0;
        this.buttons = list0;
        this.objectType = "calendar";
    }

    public CalendarTemplate(String s, IdType idType0, Content content0, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 8) != 0) {
            list0 = null;
        }
        this(s, idType0, content0, list0);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final IdType component2() {
        return this.idType;
    }

    @NotNull
    public final Content component3() {
        return this.content;
    }

    @Nullable
    public final List component4() {
        return this.buttons;
    }

    @NotNull
    public final CalendarTemplate copy(@NotNull String s, @NotNull IdType idType0, @NotNull Content content0, @Nullable List list0) {
        q.g(s, "id");
        q.g(idType0, "idType");
        q.g(content0, "content");
        return new CalendarTemplate(s, idType0, content0, list0);
    }

    public static CalendarTemplate copy$default(CalendarTemplate calendarTemplate0, String s, IdType idType0, Content content0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            s = calendarTemplate0.id;
        }
        if((v & 2) != 0) {
            idType0 = calendarTemplate0.idType;
        }
        if((v & 4) != 0) {
            content0 = calendarTemplate0.content;
        }
        if((v & 8) != 0) {
            list0 = calendarTemplate0.buttons;
        }
        return calendarTemplate0.copy(s, idType0, content0, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CalendarTemplate)) {
            return false;
        }
        if(!q.b(this.id, ((CalendarTemplate)object0).id)) {
            return false;
        }
        if(this.idType != ((CalendarTemplate)object0).idType) {
            return false;
        }
        return q.b(this.content, ((CalendarTemplate)object0).content) ? q.b(this.buttons, ((CalendarTemplate)object0).buttons) : false;
    }

    @Nullable
    public final List getButtons() {
        return this.buttons;
    }

    @NotNull
    public final Content getContent() {
        return this.content;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final IdType getIdType() {
        return this.idType;
    }

    @SerialName("id_type")
    public static void getIdType$annotations() {
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
        int v = this.id.hashCode();
        int v1 = this.idType.hashCode();
        int v2 = this.content.hashCode();
        return this.buttons == null ? (v2 + (v1 + v * 0x1F) * 0x1F) * 0x1F : (v2 + (v1 + v * 0x1F) * 0x1F) * 0x1F + this.buttons.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "CalendarTemplate(id=" + this.id + ", idType=" + this.idType + ", content=" + this.content + ", buttons=" + this.buttons + ")";
    }

    public static final void write$Self(@NotNull CalendarTemplate calendarTemplate0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(calendarTemplate0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, calendarTemplate0.id);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 1, IdType.Companion.serializer(), calendarTemplate0.idType);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Content..serializer.INSTANCE, calendarTemplate0.content);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || calendarTemplate0.buttons != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), calendarTemplate0.buttons);
        }
        compositeEncoder0.encodeStringElement(serialDescriptor0, 4, calendarTemplate0.objectType);
    }
}

