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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0014\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002A@BG\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000B\u00A2\u0006\u0004\b\r\u0010\u000EBc\b\u0017\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0001\u0010\u0011\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012\u00A2\u0006\u0004\b\r\u0010\u0014J(\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0015\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u00C7\u0001\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0012\u0010\u001F\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0012\u0010!\u001A\u0004\u0018\u00010\u0006H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b#\u0010$J\u0012\u0010%\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b%\u0010&JP\u0010\'\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000BH\u00C6\u0001\u00A2\u0006\u0004\b\'\u0010(J\u0010\u0010)\u001A\u00020\u000BH\u00D6\u0001\u00A2\u0006\u0004\b)\u0010&J\u0010\u0010*\u001A\u00020\u000FH\u00D6\u0001\u00A2\u0006\u0004\b*\u0010+J\u001A\u0010/\u001A\u00020.2\b\u0010-\u001A\u0004\u0018\u00010,H\u00D6\u0003\u00A2\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u00101\u001A\u0004\b2\u0010\u001ER\"\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u00103\u0012\u0004\b5\u00106\u001A\u0004\b4\u0010 R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u00107\u001A\u0004\b8\u0010\"R\u001F\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006\u00A2\u0006\f\n\u0004\b\n\u00109\u001A\u0004\b:\u0010$R\"\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\f\u0010;\u0012\u0004\b=\u00106\u001A\u0004\b<\u0010&R \u0010\u0011\u001A\u00020\u000B8\u0006X\u0087D\u00A2\u0006\u0012\n\u0004\b\u0011\u0010;\u0012\u0004\b?\u00106\u001A\u0004\b>\u0010&\u00A8\u0006B"}, d2 = {"Lcom/kakao/sdk/template/model/FeedTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Lcom/kakao/sdk/template/model/Content;", "content", "Lcom/kakao/sdk/template/model/ItemContent;", "itemContent", "Lcom/kakao/sdk/template/model/Social;", "social", "", "Lcom/kakao/sdk/template/model/Button;", "buttons", "", "buttonTitle", "<init>", "(Lcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/ItemContent;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;)V", "", "seen1", "objectType", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/ItemContent;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/FeedTemplate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Lcom/kakao/sdk/template/model/Content;", "component2", "()Lcom/kakao/sdk/template/model/ItemContent;", "component3", "()Lcom/kakao/sdk/template/model/Social;", "component4", "()Ljava/util/List;", "component5", "()Ljava/lang/String;", "copy", "(Lcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/ItemContent;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;)Lcom/kakao/sdk/template/model/FeedTemplate;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/kakao/sdk/template/model/Content;", "getContent", "Lcom/kakao/sdk/template/model/ItemContent;", "getItemContent", "getItemContent$annotations", "()V", "Lcom/kakao/sdk/template/model/Social;", "getSocial", "Ljava/util/List;", "getButtons", "Ljava/lang/String;", "getButtonTitle", "getButtonTitle$annotations", "getObjectType", "getObjectType$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class FeedTemplate implements DefaultTemplate {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/FeedTemplate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/FeedTemplate;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/FeedTemplate;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/FeedTemplate;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer feedTemplate$$serializer0 = new .serializer();
            .serializer.INSTANCE = feedTemplate$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.FeedTemplate", feedTemplate$$serializer0, 6);
            pluginGeneratedSerialDescriptor0.addElement("content", false);
            pluginGeneratedSerialDescriptor0.addElement("item_content", true);
            pluginGeneratedSerialDescriptor0.addElement("social", true);
            pluginGeneratedSerialDescriptor0.addElement("buttons", true);
            pluginGeneratedSerialDescriptor0.addElement("button_title", true);
            pluginGeneratedSerialDescriptor0.addElement("object_type", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(com.kakao.sdk.template.model.ItemContent..serializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(com.kakao.sdk.template.model.Social..serializer.INSTANCE);
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE));
            KSerializer kSerializer3 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            return new KSerializer[]{com.kakao.sdk.template.model.Content..serializer.INSTANCE, kSerializer0, kSerializer1, kSerializer2, kSerializer3, StringSerializer.INSTANCE};
        }

        @NotNull
        public FeedTemplate deserialize(@NotNull Decoder decoder0) {
            String s;
            int v;
            Object object5;
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
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.ItemContent..serializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Social..serializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), null);
                object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, null);
                v = 0x3F;
                s = compositeDecoder0.decodeStringElement(serialDescriptor0, 5);
            }
            else {
                int v1 = 0;
                Object object6 = null;
                Object object7 = null;
                Object object8 = null;
                Object object9 = null;
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
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.ItemContent..serializer.INSTANCE, object6);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Social..serializer.INSTANCE, object7);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), object8);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, object9);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            s1 = compositeDecoder0.decodeStringElement(serialDescriptor0, 5);
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
                object2 = object6;
                object3 = object7;
                object4 = object8;
                object5 = object9;
                s = s1;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new FeedTemplate(v, ((Content)object1), ((ItemContent)object2), ((Social)object3), ((List)object4), ((String)object5), s, null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull FeedTemplate feedTemplate0) {
            q.g(encoder0, "encoder");
            q.g(feedTemplate0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            FeedTemplate.write$Self(feedTemplate0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((FeedTemplate)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/FeedTemplate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/FeedTemplate;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Content content;
    @Nullable
    private final ItemContent itemContent;
    @NotNull
    private final String objectType;
    @Nullable
    private final Social social;

    static {
        FeedTemplate.Companion = new Companion(null);
    }

    @d
    public FeedTemplate(int v, Content content0, @SerialName("item_content") ItemContent itemContent0, Social social0, List list0, @SerialName("button_title") String s, @SerialName("object_type") String s1, SerializationConstructorMarker serializationConstructorMarker0) {
        if(33 != (v & 33)) {
            PluginExceptionsKt.throwMissingFieldException(v, 33, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.content = content0;
        this.itemContent = (v & 2) == 0 ? null : itemContent0;
        this.social = (v & 4) == 0 ? null : social0;
        this.buttons = (v & 8) == 0 ? null : list0;
        this.buttonTitle = (v & 16) == 0 ? null : s;
        this.objectType = s1;
    }

    public FeedTemplate(@NotNull Content content0) {
        q.g(content0, "content");
        this(content0, null, null, null, null, 30, null);
    }

    public FeedTemplate(@NotNull Content content0, @Nullable ItemContent itemContent0) {
        q.g(content0, "content");
        this(content0, itemContent0, null, null, null, 28, null);
    }

    public FeedTemplate(@NotNull Content content0, @Nullable ItemContent itemContent0, @Nullable Social social0) {
        q.g(content0, "content");
        this(content0, itemContent0, social0, null, null, 24, null);
    }

    public FeedTemplate(@NotNull Content content0, @Nullable ItemContent itemContent0, @Nullable Social social0, @Nullable List list0) {
        q.g(content0, "content");
        this(content0, itemContent0, social0, list0, null, 16, null);
    }

    public FeedTemplate(@NotNull Content content0, @Nullable ItemContent itemContent0, @Nullable Social social0, @Nullable List list0, @Nullable String s) {
        q.g(content0, "content");
        super();
        this.content = content0;
        this.itemContent = itemContent0;
        this.social = social0;
        this.buttons = list0;
        this.buttonTitle = s;
        this.objectType = "feed";
    }

    public FeedTemplate(Content content0, ItemContent itemContent0, Social social0, List list0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            itemContent0 = null;
        }
        if((v & 4) != 0) {
            social0 = null;
        }
        if((v & 8) != 0) {
            list0 = null;
        }
        this(content0, itemContent0, social0, list0, ((v & 16) == 0 ? s : null));
    }

    @NotNull
    public final Content component1() {
        return this.content;
    }

    @Nullable
    public final ItemContent component2() {
        return this.itemContent;
    }

    @Nullable
    public final Social component3() {
        return this.social;
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
    public final FeedTemplate copy(@NotNull Content content0, @Nullable ItemContent itemContent0, @Nullable Social social0, @Nullable List list0, @Nullable String s) {
        q.g(content0, "content");
        return new FeedTemplate(content0, itemContent0, social0, list0, s);
    }

    public static FeedTemplate copy$default(FeedTemplate feedTemplate0, Content content0, ItemContent itemContent0, Social social0, List list0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            content0 = feedTemplate0.content;
        }
        if((v & 2) != 0) {
            itemContent0 = feedTemplate0.itemContent;
        }
        if((v & 4) != 0) {
            social0 = feedTemplate0.social;
        }
        if((v & 8) != 0) {
            list0 = feedTemplate0.buttons;
        }
        if((v & 16) != 0) {
            s = feedTemplate0.buttonTitle;
        }
        return feedTemplate0.copy(content0, itemContent0, social0, list0, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof FeedTemplate)) {
            return false;
        }
        if(!q.b(this.content, ((FeedTemplate)object0).content)) {
            return false;
        }
        if(!q.b(this.itemContent, ((FeedTemplate)object0).itemContent)) {
            return false;
        }
        if(!q.b(this.social, ((FeedTemplate)object0).social)) {
            return false;
        }
        return q.b(this.buttons, ((FeedTemplate)object0).buttons) ? q.b(this.buttonTitle, ((FeedTemplate)object0).buttonTitle) : false;
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

    @Nullable
    public final ItemContent getItemContent() {
        return this.itemContent;
    }

    @SerialName("item_content")
    public static void getItemContent$annotations() {
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
        int v = this.content.hashCode();
        int v1 = 0;
        int v2 = this.itemContent == null ? 0 : this.itemContent.hashCode();
        int v3 = this.social == null ? 0 : this.social.hashCode();
        int v4 = this.buttons == null ? 0 : this.buttons.hashCode();
        String s = this.buttonTitle;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("FeedTemplate(content=");
        stringBuilder0.append(this.content);
        stringBuilder0.append(", itemContent=");
        stringBuilder0.append(this.itemContent);
        stringBuilder0.append(", social=");
        stringBuilder0.append(this.social);
        stringBuilder0.append(", buttons=");
        stringBuilder0.append(this.buttons);
        stringBuilder0.append(", buttonTitle=");
        return x.m(stringBuilder0, this.buttonTitle, ")");
    }

    public static final void write$Self(@NotNull FeedTemplate feedTemplate0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(feedTemplate0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 0, com.kakao.sdk.template.model.Content..serializer.INSTANCE, feedTemplate0.content);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 1) || feedTemplate0.itemContent != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, com.kakao.sdk.template.model.ItemContent..serializer.INSTANCE, feedTemplate0.itemContent);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || feedTemplate0.social != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, com.kakao.sdk.template.model.Social..serializer.INSTANCE, feedTemplate0.social);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || feedTemplate0.buttons != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, new ArrayListSerializer(com.kakao.sdk.template.model.Button..serializer.INSTANCE), feedTemplate0.buttons);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || feedTemplate0.buttonTitle != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, feedTemplate0.buttonTitle);
        }
        compositeEncoder0.encodeStringElement(serialDescriptor0, 5, feedTemplate0.objectType);
    }
}

