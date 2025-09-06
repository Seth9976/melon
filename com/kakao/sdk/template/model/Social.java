package com.kakao.sdk.template.model;

import ie.d;
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
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000243BE\b\u0007\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\b\u0010\tBW\b\u0017\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u000B\u00A2\u0006\u0004\b\b\u0010\rJ(\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u0011H\u00C7\u0001\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0017J\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u0017JL\u0010\u001C\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001F\u001A\u00020\u001EH\u00D6\u0001\u00A2\u0006\u0004\b\u001F\u0010 J\u0010\u0010!\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b!\u0010\"J\u001A\u0010%\u001A\u00020$2\b\u0010#\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010\'\u0012\u0004\b)\u0010*\u001A\u0004\b(\u0010\u0017R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010\'\u0012\u0004\b,\u0010*\u001A\u0004\b+\u0010\u0017R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u0010\'\u0012\u0004\b.\u0010*\u001A\u0004\b-\u0010\u0017R\"\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u0010\'\u0012\u0004\b0\u0010*\u001A\u0004\b/\u0010\u0017R\"\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u0010\'\u0012\u0004\b2\u0010*\u001A\u0004\b1\u0010\u0017\u00A8\u00065"}, d2 = {"Lcom/kakao/sdk/template/model/Social;", "", "", "likeCount", "commentCount", "sharedCount", "viewCount", "subscriberCount", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/template/model/Social;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/kakao/sdk/template/model/Social;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getLikeCount", "getLikeCount$annotations", "()V", "getCommentCount", "getCommentCount$annotations", "getSharedCount", "getSharedCount$annotations", "getViewCount", "getViewCount$annotations", "getSubscriberCount", "getSubscriberCount$annotations", "Companion", "$serializer", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class Social {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/template/model/Social.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/template/model/Social;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/template/model/Social;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/template/model/Social;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer social$$serializer0 = new .serializer();
            .serializer.INSTANCE = social$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.template.model.Social", social$$serializer0, 5);
            pluginGeneratedSerialDescriptor0.addElement("like_count", true);
            pluginGeneratedSerialDescriptor0.addElement("comment_count", true);
            pluginGeneratedSerialDescriptor0.addElement("shared_count", true);
            pluginGeneratedSerialDescriptor0.addElement("view_count", true);
            pluginGeneratedSerialDescriptor0.addElement("subscriber_count", true);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
        }

        @NotNull
        public Social deserialize(@NotNull Decoder decoder0) {
            int v;
            Object object6;
            Object object5;
            Object object4;
            Object object2;
            Object object1;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, IntSerializer.INSTANCE, null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, IntSerializer.INSTANCE, null);
                Object object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, IntSerializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, IntSerializer.INSTANCE, null);
                object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, IntSerializer.INSTANCE, null);
                object6 = object3;
                v = 0x1F;
            }
            else {
                int v1 = 0;
                Object object7 = null;
                object6 = null;
                Object object8 = null;
                Object object9 = null;
                boolean z = true;
                while(z) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, IntSerializer.INSTANCE, object0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, IntSerializer.INSTANCE, object7);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, IntSerializer.INSTANCE, object6);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, IntSerializer.INSTANCE, object8);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, IntSerializer.INSTANCE, object9);
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
                object2 = object7;
                object4 = object8;
                object5 = object9;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new Social(v, ((Integer)object1), ((Integer)object2), ((Integer)object6), ((Integer)object4), ((Integer)object5), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull Social social0) {
            q.g(encoder0, "encoder");
            q.g(social0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            Social.write$Self(social0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((Social)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/Social$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/Social;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Integer commentCount;
    @Nullable
    private final Integer likeCount;
    @Nullable
    private final Integer sharedCount;
    @Nullable
    private final Integer subscriberCount;
    @Nullable
    private final Integer viewCount;

    static {
        Social.Companion = new Companion(null);
    }

    public Social() {
        this(null, null, null, null, null, 0x1F, null);
    }

    @d
    public Social(int v, @SerialName("like_count") Integer integer0, @SerialName("comment_count") Integer integer1, @SerialName("shared_count") Integer integer2, @SerialName("view_count") Integer integer3, @SerialName("subscriber_count") Integer integer4, SerializationConstructorMarker serializationConstructorMarker0) {
        this.likeCount = (v & 1) == 0 ? null : integer0;
        this.commentCount = (v & 2) == 0 ? null : integer1;
        this.sharedCount = (v & 4) == 0 ? null : integer2;
        this.viewCount = (v & 8) == 0 ? null : integer3;
        if((v & 16) == 0) {
            this.subscriberCount = null;
            return;
        }
        this.subscriberCount = integer4;
    }

    public Social(@Nullable Integer integer0) {
        this(integer0, null, null, null, null, 30, null);
    }

    public Social(@Nullable Integer integer0, @Nullable Integer integer1) {
        this(integer0, integer1, null, null, null, 28, null);
    }

    public Social(@Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2) {
        this(integer0, integer1, integer2, null, null, 24, null);
    }

    public Social(@Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable Integer integer3) {
        this(integer0, integer1, integer2, integer3, null, 16, null);
    }

    public Social(@Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable Integer integer3, @Nullable Integer integer4) {
        this.likeCount = integer0;
        this.commentCount = integer1;
        this.sharedCount = integer2;
        this.viewCount = integer3;
        this.subscriberCount = integer4;
    }

    public Social(Integer integer0, Integer integer1, Integer integer2, Integer integer3, Integer integer4, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            integer0 = null;
        }
        if((v & 2) != 0) {
            integer1 = null;
        }
        if((v & 4) != 0) {
            integer2 = null;
        }
        if((v & 8) != 0) {
            integer3 = null;
        }
        this(integer0, integer1, integer2, integer3, ((v & 16) == 0 ? integer4 : null));
    }

    @Nullable
    public final Integer component1() {
        return this.likeCount;
    }

    @Nullable
    public final Integer component2() {
        return this.commentCount;
    }

    @Nullable
    public final Integer component3() {
        return this.sharedCount;
    }

    @Nullable
    public final Integer component4() {
        return this.viewCount;
    }

    @Nullable
    public final Integer component5() {
        return this.subscriberCount;
    }

    @NotNull
    public final Social copy(@Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2, @Nullable Integer integer3, @Nullable Integer integer4) {
        return new Social(integer0, integer1, integer2, integer3, integer4);
    }

    public static Social copy$default(Social social0, Integer integer0, Integer integer1, Integer integer2, Integer integer3, Integer integer4, int v, Object object0) {
        if((v & 1) != 0) {
            integer0 = social0.likeCount;
        }
        if((v & 2) != 0) {
            integer1 = social0.commentCount;
        }
        if((v & 4) != 0) {
            integer2 = social0.sharedCount;
        }
        if((v & 8) != 0) {
            integer3 = social0.viewCount;
        }
        if((v & 16) != 0) {
            integer4 = social0.subscriberCount;
        }
        return social0.copy(integer0, integer1, integer2, integer3, integer4);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Social)) {
            return false;
        }
        if(!q.b(this.likeCount, ((Social)object0).likeCount)) {
            return false;
        }
        if(!q.b(this.commentCount, ((Social)object0).commentCount)) {
            return false;
        }
        if(!q.b(this.sharedCount, ((Social)object0).sharedCount)) {
            return false;
        }
        return q.b(this.viewCount, ((Social)object0).viewCount) ? q.b(this.subscriberCount, ((Social)object0).subscriberCount) : false;
    }

    @Nullable
    public final Integer getCommentCount() {
        return this.commentCount;
    }

    @SerialName("comment_count")
    public static void getCommentCount$annotations() {
    }

    @Nullable
    public final Integer getLikeCount() {
        return this.likeCount;
    }

    @SerialName("like_count")
    public static void getLikeCount$annotations() {
    }

    @Nullable
    public final Integer getSharedCount() {
        return this.sharedCount;
    }

    @SerialName("shared_count")
    public static void getSharedCount$annotations() {
    }

    @Nullable
    public final Integer getSubscriberCount() {
        return this.subscriberCount;
    }

    @SerialName("subscriber_count")
    public static void getSubscriberCount$annotations() {
    }

    @Nullable
    public final Integer getViewCount() {
        return this.viewCount;
    }

    @SerialName("view_count")
    public static void getViewCount$annotations() {
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.likeCount == null ? 0 : this.likeCount.hashCode();
        int v2 = this.commentCount == null ? 0 : this.commentCount.hashCode();
        int v3 = this.sharedCount == null ? 0 : this.sharedCount.hashCode();
        int v4 = this.viewCount == null ? 0 : this.viewCount.hashCode();
        Integer integer0 = this.subscriberCount;
        if(integer0 != null) {
            v = integer0.hashCode();
        }
        return (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "Social(likeCount=" + this.likeCount + ", commentCount=" + this.commentCount + ", sharedCount=" + this.sharedCount + ", viewCount=" + this.viewCount + ", subscriberCount=" + this.subscriberCount + ")";
    }

    public static final void write$Self(@NotNull Social social0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(social0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 0) || social0.likeCount != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, IntSerializer.INSTANCE, social0.likeCount);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 1) || social0.commentCount != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, IntSerializer.INSTANCE, social0.commentCount);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 2) || social0.sharedCount != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, IntSerializer.INSTANCE, social0.sharedCount);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || social0.viewCount != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, IntSerializer.INSTANCE, social0.viewCount);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || social0.subscriberCount != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, IntSerializer.INSTANCE, social0.subscriberCount);
        }
    }
}

