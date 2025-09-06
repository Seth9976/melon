package com.kakao.sdk.user.model;

import ie.d;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.ContextualSerializer;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001B\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0002QPBc\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\b\u0010\f\u001A\u0004\u0018\u00010\n\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F\u00A2\u0006\u0004\b\u0011\u0010\u0012B\u0083\u0001\b\u0017\u0012\u0006\u0010\u0014\u001A\u00020\u0013\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000E\u001A\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u0010\u001A\u0004\u0018\u00010\u000F\u0012\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015\u00A2\u0006\u0004\b\u0011\u0010\u0017J\r\u0010\u0019\u001A\u00020\u0018\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001E\u0010\u001D\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0012\u0010\u001F\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0012\u0010!\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001A\u0004\u0018\u00010\nH\u00C6\u0003\u00A2\u0006\u0004\b#\u0010$J\u0012\u0010%\u001A\u0004\u0018\u00010\nH\u00C6\u0003\u00A2\u0006\u0004\b%\u0010$J\u0012\u0010&\u001A\u0004\u0018\u00010\rH\u00C6\u0003\u00A2\u0006\u0004\b&\u0010\'J\u0012\u0010(\u001A\u0004\u0018\u00010\u000FH\u00C6\u0003\u00A2\u0006\u0004\b(\u0010)J|\u0010*\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u00C6\u0001\u00A2\u0006\u0004\b*\u0010+J\u0010\u0010,\u001A\u00020\u0005H\u00D6\u0001\u00A2\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001A\u00020\u0013H\u00D6\u0001\u00A2\u0006\u0004\b-\u0010.J\u001A\u00100\u001A\u00020\r2\b\u0010/\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b0\u00101J(\u00108\u001A\u0002072\u0006\u00102\u001A\u00020\u00002\u0006\u00104\u001A\u0002032\u0006\u00106\u001A\u000205H\u00C7\u0001\u00A2\u0006\u0004\b8\u00109R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010:\u001A\u0004\b;\u0010\u001CR%\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010<\u001A\u0004\b=\u0010\u001ER\"\u0010\b\u001A\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\b\u0010>\u0012\u0004\b@\u0010A\u001A\u0004\b?\u0010 R\"\u0010\t\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\t\u0010B\u0012\u0004\bD\u0010A\u001A\u0004\bC\u0010\"R\"\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000B\u0010E\u0012\u0004\bG\u0010A\u001A\u0004\bF\u0010$R\"\u0010\f\u001A\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\f\u0010E\u0012\u0004\bI\u0010A\u001A\u0004\bH\u0010$R\"\u0010\u000E\u001A\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000E\u0010J\u0012\u0004\bL\u0010A\u001A\u0004\bK\u0010\'R\"\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0010\u0010M\u0012\u0004\bO\u0010A\u001A\u0004\bN\u0010)\u00A8\u0006R"}, d2 = {"Lcom/kakao/sdk/user/model/UserResponse;", "", "", "id", "", "", "properties", "Lcom/kakao/sdk/user/model/Account;", "kakaoAccount", "groupUserToken", "Ljava/util/Date;", "connectedAt", "synchedAt", "", "hasSignedUp", "Lcom/kakao/sdk/user/model/ForPartner;", "forPartner", "<init>", "(Ljava/lang/Long;Ljava/util/Map;Lcom/kakao/sdk/user/model/Account;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/ForPartner;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Long;Ljava/util/Map;Lcom/kakao/sdk/user/model/Account;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/ForPartner;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "Lcom/kakao/sdk/user/model/User;", "toUser", "()Lcom/kakao/sdk/user/model/User;", "component1", "()Ljava/lang/Long;", "component2", "()Ljava/util/Map;", "component3", "()Lcom/kakao/sdk/user/model/Account;", "component4", "()Ljava/lang/String;", "component5", "()Ljava/util/Date;", "component6", "component7", "()Ljava/lang/Boolean;", "component8", "()Lcom/kakao/sdk/user/model/ForPartner;", "copy", "(Ljava/lang/Long;Ljava/util/Map;Lcom/kakao/sdk/user/model/Account;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/ForPartner;)Lcom/kakao/sdk/user/model/UserResponse;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/UserResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/Long;", "getId", "Ljava/util/Map;", "getProperties", "Lcom/kakao/sdk/user/model/Account;", "getKakaoAccount", "getKakaoAccount$annotations", "()V", "Ljava/lang/String;", "getGroupUserToken", "getGroupUserToken$annotations", "Ljava/util/Date;", "getConnectedAt", "getConnectedAt$annotations", "getSynchedAt", "getSynchedAt$annotations", "Ljava/lang/Boolean;", "getHasSignedUp", "getHasSignedUp$annotations", "Lcom/kakao/sdk/user/model/ForPartner;", "getForPartner", "getForPartner$annotations", "Companion", "$serializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class UserResponse {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/UserResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/UserResponse;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/UserResponse;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/UserResponse;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer userResponse$$serializer0 = new .serializer();
            .serializer.INSTANCE = userResponse$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.UserResponse", userResponse$$serializer0, 8);
            pluginGeneratedSerialDescriptor0.addElement("id", false);
            pluginGeneratedSerialDescriptor0.addElement("properties", false);
            pluginGeneratedSerialDescriptor0.addElement("kakao_account", false);
            pluginGeneratedSerialDescriptor0.addElement("group_user_token", false);
            pluginGeneratedSerialDescriptor0.addElement("connected_at", false);
            pluginGeneratedSerialDescriptor0.addElement("synched_at", false);
            pluginGeneratedSerialDescriptor0.addElement("has_signed_up", false);
            pluginGeneratedSerialDescriptor0.addElement("for_partner", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(com.kakao.sdk.user.model.Account..serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0])), BuiltinSerializersKt.getNullable(new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0])), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(com.kakao.sdk.user.model.ForPartner..serializer.INSTANCE)};
        }

        @NotNull
        public UserResponse deserialize(@NotNull Decoder decoder0) {
            Object object8;
            int v;
            Object object7;
            Object object6;
            Object object5;
            Object object4;
            Object object3;
            Object object2;
            Object object0;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            boolean z = compositeDecoder0.decodeSequentially();
            Class class0 = Date.class;
            if(z) {
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, null);
                Object object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, com.kakao.sdk.user.model.Account..serializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), null);
                object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), null);
                object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, null);
                object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, com.kakao.sdk.user.model.ForPartner..serializer.INSTANCE, null);
                v = 0xFF;
                object8 = object1;
            }
            else {
                int v1 = 0;
                object0 = null;
                object4 = null;
                Object object9 = null;
                Object object10 = null;
                Object object11 = null;
                Object object12 = null;
                Object object13 = null;
                Object object14 = null;
                boolean z1 = true;
                while(z1) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z1 = false;
                            break;
                        }
                        case 0: {
                            object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, object0);
                            v1 |= 1;
                            break;
                        }
                        case 1: {
                            object14 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), object14);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object13 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, com.kakao.sdk.user.model.Account..serializer.INSTANCE, object13);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            object10 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, object10);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), object4);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            object12 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, new ContextualSerializer(I.a.b(class0), null, new KSerializer[0]), object12);
                            v1 |= 0x20;
                            break;
                        }
                        case 6: {
                            object11 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, object11);
                            v1 |= 0x40;
                            break;
                        }
                        case 7: {
                            object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, com.kakao.sdk.user.model.ForPartner..serializer.INSTANCE, object9);
                            v1 |= 0x80;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                v = v1;
                object3 = object10;
                object8 = object14;
                object7 = object9;
                object6 = object11;
                object2 = object13;
                object5 = object12;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new UserResponse(v, ((Long)object0), ((Map)object8), ((Account)object2), ((String)object3), ((Date)object4), ((Date)object5), ((Boolean)object6), ((ForPartner)object7), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull UserResponse userResponse0) {
            q.g(encoder0, "encoder");
            q.g(userResponse0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            UserResponse.write$Self(userResponse0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((UserResponse)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/UserResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/UserResponse;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Date connectedAt;
    @Nullable
    private final ForPartner forPartner;
    @Nullable
    private final String groupUserToken;
    @Nullable
    private final Boolean hasSignedUp;
    @Nullable
    private final Long id;
    @Nullable
    private final Account kakaoAccount;
    @Nullable
    private final Map properties;
    @Nullable
    private final Date synchedAt;

    static {
        UserResponse.Companion = new Companion(null);
    }

    @d
    public UserResponse(int v, Long long0, Map map0, @SerialName("kakao_account") Account account0, @SerialName("group_user_token") String s, @SerialName("connected_at") Date date0, @SerialName("synched_at") Date date1, @SerialName("has_signed_up") Boolean boolean0, @SerialName("for_partner") ForPartner forPartner0, SerializationConstructorMarker serializationConstructorMarker0) {
        if(0xFF != (v & 0xFF)) {
            PluginExceptionsKt.throwMissingFieldException(v, 0xFF, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.id = long0;
        this.properties = map0;
        this.kakaoAccount = account0;
        this.groupUserToken = s;
        this.connectedAt = date0;
        this.synchedAt = date1;
        this.hasSignedUp = boolean0;
        this.forPartner = forPartner0;
    }

    public UserResponse(@Nullable Long long0, @Nullable Map map0, @Nullable Account account0, @Nullable String s, @Nullable Date date0, @Nullable Date date1, @Nullable Boolean boolean0, @Nullable ForPartner forPartner0) {
        this.id = long0;
        this.properties = map0;
        this.kakaoAccount = account0;
        this.groupUserToken = s;
        this.connectedAt = date0;
        this.synchedAt = date1;
        this.hasSignedUp = boolean0;
        this.forPartner = forPartner0;
    }

    @Nullable
    public final Long component1() {
        return this.id;
    }

    @Nullable
    public final Map component2() {
        return this.properties;
    }

    @Nullable
    public final Account component3() {
        return this.kakaoAccount;
    }

    @Nullable
    public final String component4() {
        return this.groupUserToken;
    }

    @Nullable
    public final Date component5() {
        return this.connectedAt;
    }

    @Nullable
    public final Date component6() {
        return this.synchedAt;
    }

    @Nullable
    public final Boolean component7() {
        return this.hasSignedUp;
    }

    @Nullable
    public final ForPartner component8() {
        return this.forPartner;
    }

    @NotNull
    public final UserResponse copy(@Nullable Long long0, @Nullable Map map0, @Nullable Account account0, @Nullable String s, @Nullable Date date0, @Nullable Date date1, @Nullable Boolean boolean0, @Nullable ForPartner forPartner0) {
        return new UserResponse(long0, map0, account0, s, date0, date1, boolean0, forPartner0);
    }

    public static UserResponse copy$default(UserResponse userResponse0, Long long0, Map map0, Account account0, String s, Date date0, Date date1, Boolean boolean0, ForPartner forPartner0, int v, Object object0) {
        if((v & 1) != 0) {
            long0 = userResponse0.id;
        }
        if((v & 2) != 0) {
            map0 = userResponse0.properties;
        }
        if((v & 4) != 0) {
            account0 = userResponse0.kakaoAccount;
        }
        if((v & 8) != 0) {
            s = userResponse0.groupUserToken;
        }
        if((v & 16) != 0) {
            date0 = userResponse0.connectedAt;
        }
        if((v & 0x20) != 0) {
            date1 = userResponse0.synchedAt;
        }
        if((v & 0x40) != 0) {
            boolean0 = userResponse0.hasSignedUp;
        }
        if((v & 0x80) != 0) {
            forPartner0 = userResponse0.forPartner;
        }
        return userResponse0.copy(long0, map0, account0, s, date0, date1, boolean0, forPartner0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof UserResponse)) {
            return false;
        }
        if(!q.b(this.id, ((UserResponse)object0).id)) {
            return false;
        }
        if(!q.b(this.properties, ((UserResponse)object0).properties)) {
            return false;
        }
        if(!q.b(this.kakaoAccount, ((UserResponse)object0).kakaoAccount)) {
            return false;
        }
        if(!q.b(this.groupUserToken, ((UserResponse)object0).groupUserToken)) {
            return false;
        }
        if(!q.b(this.connectedAt, ((UserResponse)object0).connectedAt)) {
            return false;
        }
        if(!q.b(this.synchedAt, ((UserResponse)object0).synchedAt)) {
            return false;
        }
        return q.b(this.hasSignedUp, ((UserResponse)object0).hasSignedUp) ? q.b(this.forPartner, ((UserResponse)object0).forPartner) : false;
    }

    @Nullable
    public final Date getConnectedAt() {
        return this.connectedAt;
    }

    @SerialName("connected_at")
    public static void getConnectedAt$annotations() {
    }

    @Nullable
    public final ForPartner getForPartner() {
        return this.forPartner;
    }

    @SerialName("for_partner")
    public static void getForPartner$annotations() {
    }

    @Nullable
    public final String getGroupUserToken() {
        return this.groupUserToken;
    }

    @SerialName("group_user_token")
    public static void getGroupUserToken$annotations() {
    }

    @Nullable
    public final Boolean getHasSignedUp() {
        return this.hasSignedUp;
    }

    @SerialName("has_signed_up")
    public static void getHasSignedUp$annotations() {
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final Account getKakaoAccount() {
        return this.kakaoAccount;
    }

    @SerialName("kakao_account")
    public static void getKakaoAccount$annotations() {
    }

    @Nullable
    public final Map getProperties() {
        return this.properties;
    }

    @Nullable
    public final Date getSynchedAt() {
        return this.synchedAt;
    }

    @SerialName("synched_at")
    public static void getSynchedAt$annotations() {
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.id == null ? 0 : this.id.hashCode();
        int v2 = this.properties == null ? 0 : this.properties.hashCode();
        int v3 = this.kakaoAccount == null ? 0 : this.kakaoAccount.hashCode();
        int v4 = this.groupUserToken == null ? 0 : this.groupUserToken.hashCode();
        int v5 = this.connectedAt == null ? 0 : this.connectedAt.hashCode();
        int v6 = this.synchedAt == null ? 0 : this.synchedAt.hashCode();
        int v7 = this.hasSignedUp == null ? 0 : this.hasSignedUp.hashCode();
        ForPartner forPartner0 = this.forPartner;
        if(forPartner0 != null) {
            v = forPartner0.hashCode();
        }
        return ((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "UserResponse(id=" + this.id + ", properties=" + this.properties + ", kakaoAccount=" + this.kakaoAccount + ", groupUserToken=" + this.groupUserToken + ", connectedAt=" + this.connectedAt + ", synchedAt=" + this.synchedAt + ", hasSignedUp=" + this.hasSignedUp + ", forPartner=" + this.forPartner + ")";
    }

    @NotNull
    public final User toUser() {
        return this.forPartner == null ? new User(this.id, this.properties, this.kakaoAccount, this.groupUserToken, this.connectedAt, this.synchedAt, this.hasSignedUp, null) : new User(this.id, this.properties, this.kakaoAccount, this.groupUserToken, this.connectedAt, this.synchedAt, this.hasSignedUp, this.forPartner.getUuid());
    }

    public static final void write$Self(@NotNull UserResponse userResponse0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(userResponse0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, LongSerializer.INSTANCE, userResponse0.id);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), userResponse0.properties);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, com.kakao.sdk.user.model.Account..serializer.INSTANCE, userResponse0.kakaoAccount);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, StringSerializer.INSTANCE, userResponse0.groupUserToken);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0]), userResponse0.connectedAt);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, new ContextualSerializer(I.a.b(Date.class), null, new KSerializer[0]), userResponse0.synchedAt);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, userResponse0.hasSignedUp);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 7, com.kakao.sdk.user.model.ForPartner..serializer.INSTANCE, userResponse0.forPartner);
    }
}

