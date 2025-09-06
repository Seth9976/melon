package com.kakao.sdk.share.model;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002+*BW\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001A\u00020\t\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\f\u001A\u00020\u0006\u00A2\u0006\u0004\b\r\u0010\u000EBi\b\u0017\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001A\u00020\t\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\r\u0010\u0013J(\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0014\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0017H\u00C7\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BR\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010\u001C\u001A\u0004\b\u001F\u0010\u001ER\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010\u001C\u001A\u0004\b \u0010\u001ER\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010!\u001A\u0004\b\"\u0010#R\u0019\u0010\b\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\b\u0010!\u001A\u0004\b$\u0010#R\u0017\u0010\n\u001A\u00020\t8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010%\u001A\u0004\b&\u0010\'R\u0019\u0010\u000B\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010!\u001A\u0004\b(\u0010#R\u0017\u0010\f\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\f\u0010!\u001A\u0004\b)\u0010#\u00A8\u0006,"}, d2 = {"Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment;", "", "", "lv", "av", "ak", "Lkotlinx/serialization/json/JsonObject;", "P", "C", "", "ti", "ta", "extras", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;JLkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;JLkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/String;", "getLv", "()Ljava/lang/String;", "getAv", "getAk", "Lkotlinx/serialization/json/JsonObject;", "getP", "()Lkotlinx/serialization/json/JsonObject;", "getC", "J", "getTi", "()J", "getTa", "getExtras", "Companion", "$serializer", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class KakaoTalkSharingAttachment {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/share/model/KakaoTalkSharingAttachment.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer kakaoTalkSharingAttachment$$serializer0 = new .serializer();
            .serializer.INSTANCE = kakaoTalkSharingAttachment$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.share.model.KakaoTalkSharingAttachment", kakaoTalkSharingAttachment$$serializer0, 8);
            pluginGeneratedSerialDescriptor0.addElement("lv", true);
            pluginGeneratedSerialDescriptor0.addElement("av", true);
            pluginGeneratedSerialDescriptor0.addElement("ak", false);
            pluginGeneratedSerialDescriptor0.addElement("P", true);
            pluginGeneratedSerialDescriptor0.addElement("C", true);
            pluginGeneratedSerialDescriptor0.addElement("ti", false);
            pluginGeneratedSerialDescriptor0.addElement("ta", true);
            pluginGeneratedSerialDescriptor0.addElement("extras", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE);
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE);
            return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializer0, kSerializer1, LongSerializer.INSTANCE, kSerializer2, JsonObjectSerializer.INSTANCE};
        }

        @NotNull
        public KakaoTalkSharingAttachment deserialize(@NotNull Decoder decoder0) {
            long v2;
            String s6;
            String s5;
            int v1;
            String s4;
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
                String s2 = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                String s3 = compositeDecoder0.decodeStringElement(serialDescriptor0, 2);
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, JsonObjectSerializer.INSTANCE, null);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, JsonObjectSerializer.INSTANCE, null);
                long v = compositeDecoder0.decodeLongElement(serialDescriptor0, 5);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, JsonObjectSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 7, JsonObjectSerializer.INSTANCE, null);
                s4 = s1;
                v1 = 0xFF;
                s5 = s3;
                s6 = s2;
                v2 = v;
            }
            else {
                int v3 = 0;
                Object object4 = null;
                Object object5 = null;
                Object object6 = null;
                Object object7 = null;
                long v4 = 0L;
                String s7 = null;
                String s8 = null;
                boolean z = true;
                while(z) {
                    int v5 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v5) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            v3 |= 1;
                            s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                            break;
                        }
                        case 1: {
                            v3 |= 2;
                            s7 = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                            break;
                        }
                        case 2: {
                            s8 = compositeDecoder0.decodeStringElement(serialDescriptor0, 2);
                            v3 |= 4;
                            break;
                        }
                        case 3: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, JsonObjectSerializer.INSTANCE, object6);
                            v3 |= 8;
                            break;
                        }
                        case 4: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, JsonObjectSerializer.INSTANCE, object7);
                            v3 |= 16;
                            break;
                        }
                        case 5: {
                            v4 = compositeDecoder0.decodeLongElement(serialDescriptor0, 5);
                            v3 |= 0x20;
                            break;
                        }
                        case 6: {
                            object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, JsonObjectSerializer.INSTANCE, object5);
                            v3 |= 0x40;
                            break;
                        }
                        case 7: {
                            object4 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 7, JsonObjectSerializer.INSTANCE, object4);
                            v3 |= 0x80;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v5);
                        }
                    }
                }
                v1 = v3;
                object3 = object4;
                object2 = object5;
                s4 = s;
                s6 = s7;
                s5 = s8;
                object0 = object6;
                object1 = object7;
                v2 = v4;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new KakaoTalkSharingAttachment(v1, s4, s6, s5, ((JsonObject)object0), ((JsonObject)object1), v2, ((JsonObject)object2), ((JsonObject)object3), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull KakaoTalkSharingAttachment kakaoTalkSharingAttachment0) {
            q.g(encoder0, "encoder");
            q.g(kakaoTalkSharingAttachment0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            KakaoTalkSharingAttachment.write$Self(kakaoTalkSharingAttachment0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((KakaoTalkSharingAttachment)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment;", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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

    @Nullable
    private final JsonObject C;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final JsonObject P;
    @NotNull
    private final String ak;
    @NotNull
    private final String av;
    @NotNull
    private final JsonObject extras;
    @NotNull
    private final String lv;
    @Nullable
    private final JsonObject ta;
    private final long ti;

    static {
        KakaoTalkSharingAttachment.Companion = new Companion(null);
    }

    @d
    public KakaoTalkSharingAttachment(int v, String s, String s1, String s2, JsonObject jsonObject0, JsonObject jsonObject1, long v1, JsonObject jsonObject2, JsonObject jsonObject3, SerializationConstructorMarker serializationConstructorMarker0) {
        if(0xA4 != (v & 0xA4)) {
            PluginExceptionsKt.throwMissingFieldException(v, 0xA4, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.lv = (v & 1) == 0 ? "4.0" : s;
        this.av = (v & 2) == 0 ? "4.0" : s1;
        this.ak = s2;
        this.P = (v & 8) == 0 ? null : jsonObject0;
        this.C = (v & 16) == 0 ? null : jsonObject1;
        this.ti = v1;
        this.ta = (v & 0x40) == 0 ? null : jsonObject2;
        this.extras = jsonObject3;
    }

    public KakaoTalkSharingAttachment(@NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable JsonObject jsonObject0, @Nullable JsonObject jsonObject1, long v, @Nullable JsonObject jsonObject2, @NotNull JsonObject jsonObject3) {
        q.g(s, "lv");
        q.g(s1, "av");
        q.g(s2, "ak");
        q.g(jsonObject3, "extras");
        super();
        this.lv = s;
        this.av = s1;
        this.ak = s2;
        this.P = jsonObject0;
        this.C = jsonObject1;
        this.ti = v;
        this.ta = jsonObject2;
        this.extras = jsonObject3;
    }

    public KakaoTalkSharingAttachment(String s, String s1, String s2, JsonObject jsonObject0, JsonObject jsonObject1, long v, JsonObject jsonObject2, JsonObject jsonObject3, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            s = "4.0";
        }
        if((v1 & 2) != 0) {
            s1 = "4.0";
        }
        if((v1 & 8) != 0) {
            jsonObject0 = null;
        }
        if((v1 & 16) != 0) {
            jsonObject1 = null;
        }
        this(s, s1, s2, jsonObject0, jsonObject1, v, ((v1 & 0x40) == 0 ? jsonObject2 : null), jsonObject3);
    }

    @NotNull
    public final String getAk() {
        return this.ak;
    }

    @NotNull
    public final String getAv() {
        return this.av;
    }

    @Nullable
    public final JsonObject getC() {
        return this.C;
    }

    @NotNull
    public final JsonObject getExtras() {
        return this.extras;
    }

    @NotNull
    public final String getLv() {
        return this.lv;
    }

    @Nullable
    public final JsonObject getP() {
        return this.P;
    }

    @Nullable
    public final JsonObject getTa() {
        return this.ta;
    }

    public final long getTi() {
        return this.ti;
    }

    public static final void write$Self(@NotNull KakaoTalkSharingAttachment kakaoTalkSharingAttachment0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(kakaoTalkSharingAttachment0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 0) || !q.b(kakaoTalkSharingAttachment0.lv, "4.0")) {
            compositeEncoder0.encodeStringElement(serialDescriptor0, 0, kakaoTalkSharingAttachment0.lv);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 1) || !q.b(kakaoTalkSharingAttachment0.av, "4.0")) {
            compositeEncoder0.encodeStringElement(serialDescriptor0, 1, kakaoTalkSharingAttachment0.av);
        }
        compositeEncoder0.encodeStringElement(serialDescriptor0, 2, kakaoTalkSharingAttachment0.ak);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 3) || kakaoTalkSharingAttachment0.P != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, JsonObjectSerializer.INSTANCE, kakaoTalkSharingAttachment0.P);
        }
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 4) || kakaoTalkSharingAttachment0.C != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, JsonObjectSerializer.INSTANCE, kakaoTalkSharingAttachment0.C);
        }
        compositeEncoder0.encodeLongElement(serialDescriptor0, 5, kakaoTalkSharingAttachment0.ti);
        if(compositeEncoder0.shouldEncodeElementDefault(serialDescriptor0, 6) || kakaoTalkSharingAttachment0.ta != null) {
            compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 6, JsonObjectSerializer.INSTANCE, kakaoTalkSharingAttachment0.ta);
        }
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 7, JsonObjectSerializer.INSTANCE, kakaoTalkSharingAttachment0.extras);
    }
}

