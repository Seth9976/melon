package com.kakao.sdk.user.model;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001C\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B/\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tBI\b\u0017\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001A\u0004\u0018\u00010\f\u00A2\u0006\u0004\b\b\u0010\u000EJ(\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0012H\u00C7\u0001\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0018J\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ@\u0010\u001D\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u00C6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001F\u0010\u0018J\u0010\u0010 \u001A\u00020\nH\u00D6\u0001\u00A2\u0006\u0004\b \u0010!J\u001A\u0010#\u001A\u00020\u00062\b\u0010\"\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b#\u0010$R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010%\u001A\u0004\b&\u0010\u0018R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010%\u0012\u0004\b(\u0010)\u001A\u0004\b\'\u0010\u0018R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u0010%\u0012\u0004\b+\u0010)\u001A\u0004\b*\u0010\u0018R\"\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u0010,\u0012\u0004\b-\u0010)\u001A\u0004\b\u0007\u0010\u001C\u00A8\u00060"}, d2 = {"Lcom/kakao/sdk/user/model/Profile;", "", "", "nickname", "profileImageUrl", "thumbnailImageUrl", "", "isDefaultImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/Profile;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/lang/Boolean;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/kakao/sdk/user/model/Profile;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNickname", "getProfileImageUrl", "getProfileImageUrl$annotations", "()V", "getThumbnailImageUrl", "getThumbnailImageUrl$annotations", "Ljava/lang/Boolean;", "isDefaultImage$annotations", "Companion", "$serializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class Profile {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/Profile.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/Profile;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/Profile;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/Profile;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer profile$$serializer0 = new .serializer();
            .serializer.INSTANCE = profile$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.Profile", profile$$serializer0, 4);
            pluginGeneratedSerialDescriptor0.addElement("nickname", false);
            pluginGeneratedSerialDescriptor0.addElement("profile_image_url", false);
            pluginGeneratedSerialDescriptor0.addElement("thumbnail_image_url", false);
            pluginGeneratedSerialDescriptor0.addElement("is_default_image", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
        }

        @NotNull
        public Profile deserialize(@NotNull Decoder decoder0) {
            int v;
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
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, BooleanSerializer.INSTANCE, null);
                object5 = object2;
                v = 15;
            }
            else {
                int v1 = 0;
                object5 = null;
                Object object6 = null;
                Object object7 = null;
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
                            object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, object5);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, object6);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, BooleanSerializer.INSTANCE, object7);
                            v1 |= 8;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                object1 = object0;
                object3 = object6;
                object4 = object7;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new Profile(v, ((String)object1), ((String)object5), ((String)object3), ((Boolean)object4), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull Profile profile0) {
            q.g(encoder0, "encoder");
            q.g(profile0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            Profile.write$Self(profile0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((Profile)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/Profile$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/Profile;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Boolean isDefaultImage;
    @Nullable
    private final String nickname;
    @Nullable
    private final String profileImageUrl;
    @Nullable
    private final String thumbnailImageUrl;

    static {
        Profile.Companion = new Companion(null);
    }

    @d
    public Profile(int v, String s, @SerialName("profile_image_url") String s1, @SerialName("thumbnail_image_url") String s2, @SerialName("is_default_image") Boolean boolean0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(15 != (v & 15)) {
            PluginExceptionsKt.throwMissingFieldException(v, 15, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.nickname = s;
        this.profileImageUrl = s1;
        this.thumbnailImageUrl = s2;
        this.isDefaultImage = boolean0;
    }

    public Profile(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Boolean boolean0) {
        this.nickname = s;
        this.profileImageUrl = s1;
        this.thumbnailImageUrl = s2;
        this.isDefaultImage = boolean0;
    }

    @Nullable
    public final String component1() {
        return this.nickname;
    }

    @Nullable
    public final String component2() {
        return this.profileImageUrl;
    }

    @Nullable
    public final String component3() {
        return this.thumbnailImageUrl;
    }

    @Nullable
    public final Boolean component4() {
        return this.isDefaultImage;
    }

    @NotNull
    public final Profile copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Boolean boolean0) {
        return new Profile(s, s1, s2, boolean0);
    }

    public static Profile copy$default(Profile profile0, String s, String s1, String s2, Boolean boolean0, int v, Object object0) {
        if((v & 1) != 0) {
            s = profile0.nickname;
        }
        if((v & 2) != 0) {
            s1 = profile0.profileImageUrl;
        }
        if((v & 4) != 0) {
            s2 = profile0.thumbnailImageUrl;
        }
        if((v & 8) != 0) {
            boolean0 = profile0.isDefaultImage;
        }
        return profile0.copy(s, s1, s2, boolean0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Profile)) {
            return false;
        }
        if(!q.b(this.nickname, ((Profile)object0).nickname)) {
            return false;
        }
        if(!q.b(this.profileImageUrl, ((Profile)object0).profileImageUrl)) {
            return false;
        }
        return q.b(this.thumbnailImageUrl, ((Profile)object0).thumbnailImageUrl) ? q.b(this.isDefaultImage, ((Profile)object0).isDefaultImage) : false;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    @SerialName("profile_image_url")
    public static void getProfileImageUrl$annotations() {
    }

    @Nullable
    public final String getThumbnailImageUrl() {
        return this.thumbnailImageUrl;
    }

    @SerialName("thumbnail_image_url")
    public static void getThumbnailImageUrl$annotations() {
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.nickname == null ? 0 : this.nickname.hashCode();
        int v2 = this.profileImageUrl == null ? 0 : this.profileImageUrl.hashCode();
        int v3 = this.thumbnailImageUrl == null ? 0 : this.thumbnailImageUrl.hashCode();
        Boolean boolean0 = this.isDefaultImage;
        if(boolean0 != null) {
            v = boolean0.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Nullable
    public final Boolean isDefaultImage() {
        return this.isDefaultImage;
    }

    @SerialName("is_default_image")
    public static void isDefaultImage$annotations() {
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = A7.d.o("Profile(nickname=", this.nickname, ", profileImageUrl=", this.profileImageUrl, ", thumbnailImageUrl=");
        stringBuilder0.append(this.thumbnailImageUrl);
        stringBuilder0.append(", isDefaultImage=");
        stringBuilder0.append(this.isDefaultImage);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    public static final void write$Self(@NotNull Profile profile0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(profile0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, StringSerializer.INSTANCE, profile0.nickname);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, profile0.profileImageUrl);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, StringSerializer.INSTANCE, profile0.thumbnailImageUrl);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, BooleanSerializer.INSTANCE, profile0.isDefaultImage);
    }
}

