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

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0014\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002A@BO\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\r\u0010\u000EBm\b\u0017\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0011\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012\u00A2\u0006\u0004\b\r\u0010\u0014J(\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0015\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u00C7\u0001\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0012\u0010!\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u001EJ\u0012\u0010\"\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b$\u0010%J\u0012\u0010&\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b&\u0010\u001EJZ\u0010\'\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\'\u0010(J\u0010\u0010)\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b)\u0010\u001EJ\u0010\u0010*\u001A\u00020\u000FH\u00D6\u0001\u00A2\u0006\u0004\b*\u0010+J\u001A\u0010/\u001A\u00020.2\b\u0010-\u001A\u0004\u0018\u00010,H\u00D6\u0003\u00A2\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u00101\u001A\u0004\b2\u0010\u001ER\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u00103\u001A\u0004\b4\u0010 R\"\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u00101\u0012\u0004\b6\u00107\u001A\u0004\b5\u0010\u001ER\u0019\u0010\b\u001A\u0004\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u00108\u001A\u0004\b9\u0010#R\u001F\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010:\u001A\u0004\b;\u0010%R\"\u0010\f\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\f\u00101\u0012\u0004\b=\u00107\u001A\u0004\b<\u0010\u001ER \u0010\u0011\u001A\u00020\u00028\u0006X\u0087D\u00A2\u0006\u0012\n\u0004\b\u0011\u00101\u0012\u0004\b?\u00107\u001A\u0004\b>\u0010\u001E\u00A8\u0006B"}, d2 = {"Lcom/kakao/sdk/template/model/LocationTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "", "address", "Lcom/kakao/sdk/template/model/Content;", "content", "addressTitle", "Lcom/kakao/sdk/template/model/Social;", "social", "", "Lcom/kakao/sdk/template/model/Button;", "buttons", "buttonTitle", "<init>", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Content;Ljava/lang/String;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;)V", "", "seen1", "objectType", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/kakao/sdk/template/model/Content;Ljava/lang/String;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/LocationTemplate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/kakao/sdk/template/model/Content;", "component3", "component4", "()Lcom/kakao/sdk/template/model/Social;", "component5", "()Ljava/util/List;", "component6", "copy", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Content;Ljava/lang/String;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;)Lcom/kakao/sdk/template/model/LocationTemplate;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAddress", "Lcom/kakao/sdk/template/model/Content;", "getContent", "getAddressTitle", "getAddressTitle$annotations", "()V", "Lcom/kakao/sdk/template/model/Social;", "getSocial", "Ljava/util/List;", "getButtons", "getButtonTitle", "getButtonTitle$annotations", "getObjectType", "getObjectType$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class LocationTemplate implements DefaultTemplate {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/LocationTemplate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/LocationTemplate;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/LocationTemplate;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/LocationTemplate;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer locationTemplate$$serializer0 = new .serializer();
            .serializer.INSTANCE = locationTemplate$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.LocationTemplate", locationTemplate$$serializer0, 7);
            pluginGeneratedSerialDescriptor0.addElement("address", false);
            pluginGeneratedSerialDescriptor0.addElement("content", false);
            pluginGeneratedSerialDescriptor0.addElement("address_title", true);
            pluginGeneratedSerialDescriptor0.addElement("social", true);
            pluginGeneratedSerialDescriptor0.addElement("buttons", true);
            pluginGeneratedSerialDescriptor0.addElement("button_title", true);
            pluginGeneratedSerialDescriptor0.addElement("object_type", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(com.kakao.sdk.template.model.Social..serializer.INSTANCE);
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE));
            KSerializer kSerializer3 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            return new KSerializer[]{StringSerializer.INSTANCE, com.kakao.sdk.template.model.Content..serializer.INSTANCE, kSerializer0, kSerializer1, kSerializer2, kSerializer3, StringSerializer.INSTANCE};
        }

        @NotNull
        public LocationTemplate deserialize(@NotNull Decoder decoder0) {
            int v;
            String s3;
            String s2;
            Object object4;
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
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Content..serializer.INSTANCE, null);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, com.kakao.sdk.template.model.Social..serializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, null);
                s2 = s1;
                s3 = compositeDecoder0.decodeStringElement(serialDescriptor0, 6);
                v = 0x7F;
            }
            else {
                int v1 = 0;
                Object object5 = null;
                Object object6 = null;
                Object object7 = null;
                Object object8 = null;
                Object object9 = null;
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
                            object5 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Content..serializer.INSTANCE, object5);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, object6);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, com.kakao.sdk.template.model.Social..serializer.INSTANCE, object7);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), object8);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, object9);
                            v1 |= 0x20;
                            break;
                        }
                        case 6: {
                            s4 = compositeDecoder0.decodeStringElement(serialDescriptor0, 6);
                            v1 |= 0x40;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                s2 = s;
                object0 = object5;
                object1 = object6;
                object2 = object7;
                object3 = object8;
                object4 = object9;
                s3 = s4;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new LocationTemplate(v, s2, ((Content)object0), ((String)object1), ((Social)object2), ((List)object3), ((String)object4), s3, null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull LocationTemplate locationTemplate0) {
            q.g(encoder0, "encoder");
            q.g(locationTemplate0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            LocationTemplate.write$Self(locationTemplate0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((LocationTemplate)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/LocationTemplate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/LocationTemplate;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String address;
    @Nullable
    private final String addressTitle;
    @Nullable
    private final String buttonTitle;
    @Nullable
    private final List buttons;
    @NotNull
    private final Content content;
    @NotNull
    private final String objectType;
    @Nullable
    private final Social social;

    static {
        LocationTemplate.Companion = new Companion(null);
    }

    @d
    public LocationTemplate(int v, String s, Content content0, @SerialName("address_title") String s1, Social social0, List list0, @SerialName("button_title") String s2, @SerialName("object_type") String s3, SerializationConstructorMarker serializationConstructorMarker0) {
        if(67 != (v & 67)) {
            PluginExceptionsKt.throwMissingFieldException(v, 67, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.address = s;
        this.content = content0;
        this.addressTitle = (v & 4) == 0 ? null : s1;
        this.social = (v & 8) == 0 ? null : social0;
        this.buttons = (v & 16) == 0 ? null : list0;
        this.buttonTitle = (v & 0x20) == 0 ? null : s2;
        this.objectType = s3;
    }

    public LocationTemplate(@NotNull String s, @NotNull Content content0) {
        q.g(s, "address");
        q.g(content0, "content");
        this(s, content0, null, null, null, null, 60, null);
    }

    public LocationTemplate(@NotNull String s, @NotNull Content content0, @Nullable String s1) {
        q.g(s, "address");
        q.g(content0, "content");
        this(s, content0, s1, null, null, null, 56, null);
    }

    public LocationTemplate(@NotNull String s, @NotNull Content content0, @Nullable String s1, @Nullable Social social0) {
        q.g(s, "address");
        q.g(content0, "content");
        this(s, content0, s1, social0, null, null, 0x30, null);
    }

    public LocationTemplate(@NotNull String s, @NotNull Content content0, @Nullable String s1, @Nullable Social social0, @Nullable List list0) {
        q.g(s, "address");
        q.g(content0, "content");
        this(s, content0, s1, social0, list0, null, 0x20, null);
    }

    public LocationTemplate(@NotNull String s, @NotNull Content content0, @Nullable String s1, @Nullable Social social0, @Nullable List list0, @Nullable String s2) {
        q.g(s, "address");
        q.g(content0, "content");
        super();
        this.address = s;
        this.content = content0;
        this.addressTitle = s1;
        this.social = social0;
        this.buttons = list0;
        this.buttonTitle = s2;
        this.objectType = "location";
    }

    public LocationTemplate(String s, Content content0, String s1, Social social0, List list0, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            s1 = null;
        }
        if((v & 8) != 0) {
            social0 = null;
        }
        if((v & 16) != 0) {
            list0 = null;
        }
        this(s, content0, s1, social0, list0, ((v & 0x20) == 0 ? s2 : null));
    }

    @NotNull
    public final String component1() {
        return this.address;
    }

    @NotNull
    public final Content component2() {
        return this.content;
    }

    @Nullable
    public final String component3() {
        return this.addressTitle;
    }

    @Nullable
    public final Social component4() {
        return this.social;
    }

    @Nullable
    public final List component5() {
        return this.buttons;
    }

    @Nullable
    public final String component6() {
        return this.buttonTitle;
    }

    @NotNull
    public final LocationTemplate copy(@NotNull String s, @NotNull Content content0, @Nullable String s1, @Nullable Social social0, @Nullable List list0, @Nullable String s2) {
        q.g(s, "address");
        q.g(content0, "content");
        return new LocationTemplate(s, content0, s1, social0, list0, s2);
    }

    public static LocationTemplate copy$default(LocationTemplate locationTemplate0, String s, Content content0, String s1, Social social0, List list0, String s2, int v, Object object0) {
        if((v & 1) != 0) {
            s = locationTemplate0.address;
        }
        if((v & 2) != 0) {
            content0 = locationTemplate0.content;
        }
        if((v & 4) != 0) {
            s1 = locationTemplate0.addressTitle;
        }
        if((v & 8) != 0) {
            social0 = locationTemplate0.social;
        }
        if((v & 16) != 0) {
            list0 = locationTemplate0.buttons;
        }
        if((v & 0x20) != 0) {
            s2 = locationTemplate0.buttonTitle;
        }
        return locationTemplate0.copy(s, content0, s1, social0, list0, s2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LocationTemplate)) {
            return false;
        }
        if(!q.b(this.address, ((LocationTemplate)object0).address)) {
            return false;
        }
        if(!q.b(this.content, ((LocationTemplate)object0).content)) {
            return false;
        }
        if(!q.b(this.addressTitle, ((LocationTemplate)object0).addressTitle)) {
            return false;
        }
        if(!q.b(this.social, ((LocationTemplate)object0).social)) {
            return false;
        }
        return q.b(this.buttons, ((LocationTemplate)object0).buttons) ? q.b(this.buttonTitle, ((LocationTemplate)object0).buttonTitle) : false;
    }

    @NotNull
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getAddressTitle() {
        return this.addressTitle;
    }

    @SerialName("address_title")
    public static void getAddressTitle$annotations() {
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

    @Nullable
    public final Social getSocial() {
        return this.social;
    }

    @Override
    public int hashCode() {
        int v = this.address.hashCode();
        int v1 = this.content.hashCode();
        int v2 = 0;
        int v3 = this.addressTitle == null ? 0 : this.addressTitle.hashCode();
        int v4 = this.social == null ? 0 : this.social.hashCode();
        int v5 = this.buttons == null ? 0 : this.buttons.hashCode();
        String s = this.buttonTitle;
        if(s != null) {
            v2 = s.hashCode();
        }
        return ((((v1 + v * 0x1F) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v2;
    }

    @Override
    @NotNull
    public String toString() {
        return "LocationTemplate(address=" + this.address + ", content=" + this.content + ", addressTitle=" + this.addressTitle + ", social=" + this.social + ", buttons=" + this.buttons + ", buttonTitle=" + this.buttonTitle + ")";
    }

    public static final void write$Self(@NotNull LocationTemplate locationTemplate0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(locationTemplate0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, locationTemplate0.address);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.Content..serializer.INSTANCE, locationTemplate0.content);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || locationTemplate0.addressTitle != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, locationTemplate0.addressTitle);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || locationTemplate0.social != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, com.kakao.sdk.template.model.Social..serializer.INSTANCE, locationTemplate0.social);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || locationTemplate0.buttons != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), locationTemplate0.buttons);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 5) || locationTemplate0.buttonTitle != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, locationTemplate0.buttonTitle);
        }
        compositeEncoder0.encodeStringElement(serialDescriptor0, 6, locationTemplate0.objectType);
    }
}

