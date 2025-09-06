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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002A@Bo\b\u0007\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\r\u0010\u000EB}\b\u0017\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u0012\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\r\u0010\u0013J\u0012\u0010\u0014\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u0012\u0010\u0017\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0015J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0015J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0015J\u0018\u0010\u001A\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0012\u0010\u001C\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u0015J\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u0015Jv\u0010\u001E\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010 \u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b \u0010\u0015J\u0010\u0010!\u001A\u00020\u000FH\u00D6\u0001\u00A2\u0006\u0004\b!\u0010\"J\u001A\u0010%\u001A\u00020$2\b\u0010#\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b%\u0010&J(\u0010-\u001A\u00020,2\u0006\u0010\'\u001A\u00020\u00002\u0006\u0010)\u001A\u00020(2\u0006\u0010+\u001A\u00020*H\u00C7\u0001\u00A2\u0006\u0004\b-\u0010.R\"\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010/\u0012\u0004\b1\u00102\u001A\u0004\b0\u0010\u0015R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010/\u0012\u0004\b4\u00102\u001A\u0004\b3\u0010\u0015R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u0010/\u0012\u0004\b6\u00102\u001A\u0004\b5\u0010\u0015R\"\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u0010/\u0012\u0004\b8\u00102\u001A\u0004\b7\u0010\u0015R\"\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u0010/\u0012\u0004\b:\u00102\u001A\u0004\b9\u0010\u0015R\u001F\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010;\u001A\u0004\b<\u0010\u001BR\u0019\u0010\u000B\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010/\u001A\u0004\b=\u0010\u0015R\"\u0010\f\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\f\u0010/\u0012\u0004\b?\u00102\u001A\u0004\b>\u0010\u0015\u00A8\u0006B"}, d2 = {"Lcom/kakao/sdk/template/model/ItemContent;", "", "", "profileText", "profileImageUrl", "titleImageText", "titleImageUrl", "titleImageCategory", "", "Lcom/kakao/sdk/template/model/ItemInfo;", "items", "sum", "sumOp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()Ljava/util/List;", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/kakao/sdk/template/model/ItemContent;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/ItemContent;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/String;", "getProfileText", "getProfileText$annotations", "()V", "getProfileImageUrl", "getProfileImageUrl$annotations", "getTitleImageText", "getTitleImageText$annotations", "getTitleImageUrl", "getTitleImageUrl$annotations", "getTitleImageCategory", "getTitleImageCategory$annotations", "Ljava/util/List;", "getItems", "getSum", "getSumOp", "getSumOp$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class ItemContent {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/ItemContent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/ItemContent;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/ItemContent;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/ItemContent;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer itemContent$$serializer0 = new .serializer();
            .serializer.INSTANCE = itemContent$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.ItemContent", itemContent$$serializer0, 8);
            pluginGeneratedSerialDescriptor0.addElement("profile_text", true);
            pluginGeneratedSerialDescriptor0.addElement("profile_image_url", true);
            pluginGeneratedSerialDescriptor0.addElement("title_image_text", true);
            pluginGeneratedSerialDescriptor0.addElement("title_image_url", true);
            pluginGeneratedSerialDescriptor0.addElement("title_image_category", true);
            pluginGeneratedSerialDescriptor0.addElement("items", true);
            pluginGeneratedSerialDescriptor0.addElement("sum", true);
            pluginGeneratedSerialDescriptor0.addElement("sum_op", true);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(com.kakao.sdk.template.model.ItemInfo..serializer.INSTANCE)), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
        }

        @NotNull
        public ItemContent deserialize(@NotNull Decoder decoder0) {
            int v;
            Object object10;
            Object object9;
            Object object8;
            Object object6;
            Object object5;
            Object object4;
            Object object3;
            Object object1;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, StringSerializer.INSTANCE, null);
                Object object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, null);
                object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, null);
                object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, new ArrayListSerializer(com.kakao.sdk.template.model.ItemInfo..serializer.INSTANCE), null);
                Object object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, null);
                object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, null);
                object9 = object2;
                object10 = object7;
                v = 0xFF;
            }
            else {
                int v1 = 0;
                Object object11 = null;
                object10 = null;
                Object object12 = null;
                object9 = null;
                Object object13 = null;
                Object object14 = null;
                Object object15 = null;
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
                            object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, object9);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object13 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, object13);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object14 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, object14);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object15 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, object15);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            object12 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, new ArrayListSerializer(com.kakao.sdk.template.model.ItemInfo..serializer.INSTANCE), object12);
                            v1 |= 0x20;
                            break;
                        }
                        case 6: {
                            object10 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, object10);
                            v1 |= 0x40;
                            break;
                        }
                        case 7: {
                            object11 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, object11);
                            v1 |= 0x80;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                object8 = object11;
                object6 = object12;
                object1 = object0;
                object3 = object13;
                object4 = object14;
                object5 = object15;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new ItemContent(v, ((String)object1), ((String)object9), ((String)object3), ((String)object4), ((String)object5), ((List)object6), ((String)object10), ((String)object8), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull ItemContent itemContent0) {
            q.g(encoder0, "encoder");
            q.g(itemContent0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            ItemContent.write$Self(itemContent0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((ItemContent)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/ItemContent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/ItemContent;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final List items;
    @Nullable
    private final String profileImageUrl;
    @Nullable
    private final String profileText;
    @Nullable
    private final String sum;
    @Nullable
    private final String sumOp;
    @Nullable
    private final String titleImageCategory;
    @Nullable
    private final String titleImageText;
    @Nullable
    private final String titleImageUrl;

    static {
        ItemContent.Companion = new Companion(null);
    }

    public ItemContent() {
        this(null, null, null, null, null, null, null, null, 0xFF, null);
    }

    @d
    public ItemContent(int v, @SerialName("profile_text") String s, @SerialName("profile_image_url") String s1, @SerialName("title_image_text") String s2, @SerialName("title_image_url") String s3, @SerialName("title_image_category") String s4, List list0, String s5, @SerialName("sum_op") String s6, SerializationConstructorMarker serializationConstructorMarker0) {
        this.profileText = (v & 1) == 0 ? null : s;
        this.profileImageUrl = (v & 2) == 0 ? null : s1;
        this.titleImageText = (v & 4) == 0 ? null : s2;
        this.titleImageUrl = (v & 8) == 0 ? null : s3;
        this.titleImageCategory = (v & 16) == 0 ? null : s4;
        this.items = (v & 0x20) == 0 ? null : list0;
        this.sum = (v & 0x40) == 0 ? null : s5;
        if((v & 0x80) == 0) {
            this.sumOp = null;
            return;
        }
        this.sumOp = s6;
    }

    public ItemContent(@Nullable String s) {
        this(s, null, null, null, null, null, null, null, 0xFE, null);
    }

    public ItemContent(@Nullable String s, @Nullable String s1) {
        this(s, s1, null, null, null, null, null, null, 0xFC, null);
    }

    public ItemContent(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        this(s, s1, s2, null, null, null, null, null, 0xF8, null);
    }

    public ItemContent(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        this(s, s1, s2, s3, null, null, null, null, 0xF0, null);
    }

    public ItemContent(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
        this(s, s1, s2, s3, s4, null, null, null, 0xE0, null);
    }

    public ItemContent(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable List list0) {
        this(s, s1, s2, s3, s4, list0, null, null, 0xC0, null);
    }

    public ItemContent(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable List list0, @Nullable String s5) {
        this(s, s1, s2, s3, s4, list0, s5, null, 0x80, null);
    }

    public ItemContent(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable List list0, @Nullable String s5, @Nullable String s6) {
        this.profileText = s;
        this.profileImageUrl = s1;
        this.titleImageText = s2;
        this.titleImageUrl = s3;
        this.titleImageCategory = s4;
        this.items = list0;
        this.sum = s5;
        this.sumOp = s6;
    }

    public ItemContent(String s, String s1, String s2, String s3, String s4, List list0, String s5, String s6, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            s2 = null;
        }
        if((v & 8) != 0) {
            s3 = null;
        }
        if((v & 16) != 0) {
            s4 = null;
        }
        if((v & 0x20) != 0) {
            list0 = null;
        }
        if((v & 0x40) != 0) {
            s5 = null;
        }
        this(s, s1, s2, s3, s4, list0, s5, ((v & 0x80) == 0 ? s6 : null));
    }

    @Nullable
    public final String component1() {
        return this.profileText;
    }

    @Nullable
    public final String component2() {
        return this.profileImageUrl;
    }

    @Nullable
    public final String component3() {
        return this.titleImageText;
    }

    @Nullable
    public final String component4() {
        return this.titleImageUrl;
    }

    @Nullable
    public final String component5() {
        return this.titleImageCategory;
    }

    @Nullable
    public final List component6() {
        return this.items;
    }

    @Nullable
    public final String component7() {
        return this.sum;
    }

    @Nullable
    public final String component8() {
        return this.sumOp;
    }

    @NotNull
    public final ItemContent copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable List list0, @Nullable String s5, @Nullable String s6) {
        return new ItemContent(s, s1, s2, s3, s4, list0, s5, s6);
    }

    public static ItemContent copy$default(ItemContent itemContent0, String s, String s1, String s2, String s3, String s4, List list0, String s5, String s6, int v, Object object0) {
        if((v & 1) != 0) {
            s = itemContent0.profileText;
        }
        if((v & 2) != 0) {
            s1 = itemContent0.profileImageUrl;
        }
        if((v & 4) != 0) {
            s2 = itemContent0.titleImageText;
        }
        if((v & 8) != 0) {
            s3 = itemContent0.titleImageUrl;
        }
        if((v & 16) != 0) {
            s4 = itemContent0.titleImageCategory;
        }
        if((v & 0x20) != 0) {
            list0 = itemContent0.items;
        }
        if((v & 0x40) != 0) {
            s5 = itemContent0.sum;
        }
        if((v & 0x80) != 0) {
            s6 = itemContent0.sumOp;
        }
        return itemContent0.copy(s, s1, s2, s3, s4, list0, s5, s6);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ItemContent)) {
            return false;
        }
        if(!q.b(this.profileText, ((ItemContent)object0).profileText)) {
            return false;
        }
        if(!q.b(this.profileImageUrl, ((ItemContent)object0).profileImageUrl)) {
            return false;
        }
        if(!q.b(this.titleImageText, ((ItemContent)object0).titleImageText)) {
            return false;
        }
        if(!q.b(this.titleImageUrl, ((ItemContent)object0).titleImageUrl)) {
            return false;
        }
        if(!q.b(this.titleImageCategory, ((ItemContent)object0).titleImageCategory)) {
            return false;
        }
        if(!q.b(this.items, ((ItemContent)object0).items)) {
            return false;
        }
        return q.b(this.sum, ((ItemContent)object0).sum) ? q.b(this.sumOp, ((ItemContent)object0).sumOp) : false;
    }

    @Nullable
    public final List getItems() {
        return this.items;
    }

    @Nullable
    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    @SerialName("profile_image_url")
    public static void getProfileImageUrl$annotations() {
    }

    @Nullable
    public final String getProfileText() {
        return this.profileText;
    }

    @SerialName("profile_text")
    public static void getProfileText$annotations() {
    }

    @Nullable
    public final String getSum() {
        return this.sum;
    }

    @Nullable
    public final String getSumOp() {
        return this.sumOp;
    }

    @SerialName("sum_op")
    public static void getSumOp$annotations() {
    }

    @Nullable
    public final String getTitleImageCategory() {
        return this.titleImageCategory;
    }

    @SerialName("title_image_category")
    public static void getTitleImageCategory$annotations() {
    }

    @Nullable
    public final String getTitleImageText() {
        return this.titleImageText;
    }

    @SerialName("title_image_text")
    public static void getTitleImageText$annotations() {
    }

    @Nullable
    public final String getTitleImageUrl() {
        return this.titleImageUrl;
    }

    @SerialName("title_image_url")
    public static void getTitleImageUrl$annotations() {
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.profileText == null ? 0 : this.profileText.hashCode();
        int v2 = this.profileImageUrl == null ? 0 : this.profileImageUrl.hashCode();
        int v3 = this.titleImageText == null ? 0 : this.titleImageText.hashCode();
        int v4 = this.titleImageUrl == null ? 0 : this.titleImageUrl.hashCode();
        int v5 = this.titleImageCategory == null ? 0 : this.titleImageCategory.hashCode();
        int v6 = this.items == null ? 0 : this.items.hashCode();
        int v7 = this.sum == null ? 0 : this.sum.hashCode();
        String s = this.sumOp;
        if(s != null) {
            v = s.hashCode();
        }
        return ((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = A7.d.o("ItemContent(profileText=", this.profileText, ", profileImageUrl=", this.profileImageUrl, ", titleImageText=");
        A7.d.u(stringBuilder0, this.titleImageText, ", titleImageUrl=", this.titleImageUrl, ", titleImageCategory=");
        stringBuilder0.append(this.titleImageCategory);
        stringBuilder0.append(", items=");
        stringBuilder0.append(this.items);
        stringBuilder0.append(", sum=");
        return A7.d.n(stringBuilder0, this.sum, ", sumOp=", this.sumOp, ")");
    }

    public static final void write$Self(@NotNull ItemContent itemContent0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(itemContent0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 0) || itemContent0.profileText != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, StringSerializer.INSTANCE, itemContent0.profileText);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 1) || itemContent0.profileImageUrl != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, itemContent0.profileImageUrl);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || itemContent0.titleImageText != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, itemContent0.titleImageText);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || itemContent0.titleImageUrl != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, itemContent0.titleImageUrl);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || itemContent0.titleImageCategory != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, StringSerializer.INSTANCE, itemContent0.titleImageCategory);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 5) || itemContent0.items != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, new ArrayListSerializer(com.kakao.sdk.template.model.ItemInfo..serializer.INSTANCE), itemContent0.items);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 6) || itemContent0.sum != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, itemContent0.sum);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 7) || itemContent0.sumOp != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, itemContent0.sumOp);
        }
    }
}

