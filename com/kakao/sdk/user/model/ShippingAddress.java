package com.kakao.sdk.user.model;

import com.kakao.sdk.common.json.LongDateSerializer;
import ie.d;
import java.util.Date;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001F\b\u0087\b\u0018\u0000 U2\u00020\u0001:\u0002VUB{\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0013\u0010\u0014B\u00A1\u0001\b\u0017\u0012\u0006\u0010\u0016\u001A\u00020\u0015\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0001\u0010\u0007\u001A\u00020\u0006\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\b\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\r\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u000E\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u000F\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0010\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0011\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0012\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017\u00A2\u0006\u0004\b\u0013\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0012\u0010\u001C\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0012\u0010 \u001A\u0004\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b \u0010!J\u0012\u0010\"\u001A\u0004\u0018\u00010\nH\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b$\u0010\u001DJ\u0012\u0010%\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b%\u0010\u001DJ\u0012\u0010&\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b&\u0010\u001DJ\u0012\u0010\'\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\'\u0010\u001DJ\u0012\u0010(\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b(\u0010\u001DJ\u0012\u0010)\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b)\u0010\u001DJ\u0012\u0010*\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b*\u0010\u001DJ\u009C\u0001\u0010+\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0004H\u00C6\u0001\u00A2\u0006\u0004\b+\u0010,J\u0010\u0010-\u001A\u00020\u0004H\u00D6\u0001\u00A2\u0006\u0004\b-\u0010\u001DJ\u0010\u0010.\u001A\u00020\u0015H\u00D6\u0001\u00A2\u0006\u0004\b.\u0010/J\u001A\u00101\u001A\u00020\u00062\b\u00100\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b1\u00102J(\u00109\u001A\u0002082\u0006\u00103\u001A\u00020\u00002\u0006\u00105\u001A\u0002042\u0006\u00107\u001A\u000206H\u00C7\u0001\u00A2\u0006\u0004\b9\u0010:R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010;\u001A\u0004\b<\u0010\u001BR\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010=\u001A\u0004\b>\u0010\u001DR \u0010\u0007\u001A\u00020\u00068\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u0010?\u0012\u0004\b@\u0010A\u001A\u0004\b\u0007\u0010\u001FR\"\u0010\t\u001A\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\t\u0010B\u0012\u0004\bD\u0010A\u001A\u0004\bC\u0010!R\u0019\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010E\u001A\u0004\bF\u0010#R\"\u0010\f\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\f\u0010=\u0012\u0004\bH\u0010A\u001A\u0004\bG\u0010\u001DR\"\u0010\r\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\r\u0010=\u0012\u0004\bJ\u0010A\u001A\u0004\bI\u0010\u001DR\"\u0010\u000E\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000E\u0010=\u0012\u0004\bL\u0010A\u001A\u0004\bK\u0010\u001DR\"\u0010\u000F\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000F\u0010=\u0012\u0004\bN\u0010A\u001A\u0004\bM\u0010\u001DR\"\u0010\u0010\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0010\u0010=\u0012\u0004\bP\u0010A\u001A\u0004\bO\u0010\u001DR\"\u0010\u0011\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0011\u0010=\u0012\u0004\bR\u0010A\u001A\u0004\bQ\u0010\u001DR\"\u0010\u0012\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0012\u0010=\u0012\u0004\bT\u0010A\u001A\u0004\bS\u0010\u001D\u00A8\u0006W"}, d2 = {"Lcom/kakao/sdk/user/model/ShippingAddress;", "", "", "id", "", "name", "", "isDefault", "Ljava/util/Date;", "updatedAt", "Lcom/kakao/sdk/user/model/ShippingAddressType;", "type", "baseAddress", "detailAddress", "receiverName", "receiverPhoneNumber1", "receiverPhoneNumber2", "zoneNumber", "zipCode", "<init>", "(JLjava/lang/String;ZLjava/util/Date;Lcom/kakao/sdk/user/model/ShippingAddressType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLjava/lang/String;ZLjava/util/Date;Lcom/kakao/sdk/user/model/ShippingAddressType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "()Z", "component4", "()Ljava/util/Date;", "component5", "()Lcom/kakao/sdk/user/model/ShippingAddressType;", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(JLjava/lang/String;ZLjava/util/Date;Lcom/kakao/sdk/user/model/ShippingAddressType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/kakao/sdk/user/model/ShippingAddress;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/ShippingAddress;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "J", "getId", "Ljava/lang/String;", "getName", "Z", "isDefault$annotations", "()V", "Ljava/util/Date;", "getUpdatedAt", "getUpdatedAt$annotations", "Lcom/kakao/sdk/user/model/ShippingAddressType;", "getType", "getBaseAddress", "getBaseAddress$annotations", "getDetailAddress", "getDetailAddress$annotations", "getReceiverName", "getReceiverName$annotations", "getReceiverPhoneNumber1", "getReceiverPhoneNumber1$annotations", "getReceiverPhoneNumber2", "getReceiverPhoneNumber2$annotations", "getZoneNumber", "getZoneNumber$annotations", "getZipCode", "getZipCode$annotations", "Companion", "$serializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class ShippingAddress {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/ShippingAddress.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/ShippingAddress;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/ShippingAddress;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/ShippingAddress;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer shippingAddress$$serializer0 = new .serializer();
            .serializer.INSTANCE = shippingAddress$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.ShippingAddress", shippingAddress$$serializer0, 12);
            pluginGeneratedSerialDescriptor0.addElement("id", false);
            pluginGeneratedSerialDescriptor0.addElement("name", false);
            pluginGeneratedSerialDescriptor0.addElement("is_default", false);
            pluginGeneratedSerialDescriptor0.addElement("updated_at", false);
            pluginGeneratedSerialDescriptor0.addElement("type", false);
            pluginGeneratedSerialDescriptor0.addElement("base_address", false);
            pluginGeneratedSerialDescriptor0.addElement("detail_address", false);
            pluginGeneratedSerialDescriptor0.addElement("receiver_name", false);
            pluginGeneratedSerialDescriptor0.addElement("receiver_phone_number1", false);
            pluginGeneratedSerialDescriptor0.addElement("receiver_phone_number2", false);
            pluginGeneratedSerialDescriptor0.addElement("zone_number", false);
            pluginGeneratedSerialDescriptor0.addElement("zip_code", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(new LongDateSerializer());
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(ShippingAddressTypeSerializer.INSTANCE);
            KSerializer kSerializer3 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer4 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer5 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer6 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer7 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer8 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer kSerializer9 = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            return new KSerializer[]{LongSerializer.INSTANCE, kSerializer0, BooleanSerializer.INSTANCE, kSerializer1, kSerializer2, kSerializer3, kSerializer4, kSerializer5, kSerializer6, kSerializer7, kSerializer8, kSerializer9};
        }

        @NotNull
        public ShippingAddress deserialize(@NotNull Decoder decoder0) {
            Object object11;
            Object object10;
            int v1;
            Object object9;
            Object object7;
            Object object5;
            Object object4;
            Object object3;
            Object object2;
            Object object1;
            boolean z;
            Object object0;
            long v;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                v = compositeDecoder0.decodeLongElement(serialDescriptor0, 0);
                object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, null);
                z = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 2);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new LongDateSerializer(), null);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, ShippingAddressTypeSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, null);
                object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, null);
                Object object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 8, StringSerializer.INSTANCE, null);
                object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 9, StringSerializer.INSTANCE, null);
                Object object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 10, StringSerializer.INSTANCE, null);
                object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 11, StringSerializer.INSTANCE, null);
                v1 = 0xFFF;
                object10 = object6;
                object11 = object8;
            }
            else {
                int v2 = 0;
                Object object12 = null;
                Object object13 = null;
                Object object14 = null;
                Object object15 = null;
                Object object16 = null;
                object11 = null;
                Object object17 = null;
                Object object18 = null;
                Object object19 = null;
                long v3 = 0L;
                boolean z1 = false;
                Object object20 = null;
                boolean z2 = true;
                while(z2) {
                    int v4 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v4) {
                        case -1: {
                            z2 = false;
                            break;
                        }
                        case 0: {
                            v3 = compositeDecoder0.decodeLongElement(serialDescriptor0, 0);
                            v2 |= 1;
                            break;
                        }
                        case 1: {
                            object20 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, object20);
                            v2 |= 2;
                            break;
                        }
                        case 2: {
                            z1 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 2);
                            v2 |= 4;
                            break;
                        }
                        case 3: {
                            object19 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, new LongDateSerializer(), object19);
                            v2 |= 8;
                            break;
                        }
                        case 4: {
                            object18 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, ShippingAddressTypeSerializer.INSTANCE, object18);
                            v2 |= 16;
                            break;
                        }
                        case 5: {
                            object16 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, object16);
                            v2 |= 0x20;
                            break;
                        }
                        case 6: {
                            object17 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, object17);
                            v2 |= 0x40;
                            break;
                        }
                        case 7: {
                            object15 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, object15);
                            v2 |= 0x80;
                            break;
                        }
                        case 8: {
                            object14 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 8, StringSerializer.INSTANCE, object14);
                            v2 |= 0x100;
                            break;
                        }
                        case 9: {
                            object13 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 9, StringSerializer.INSTANCE, object13);
                            v2 |= 0x200;
                            break;
                        }
                        case 10: {
                            object11 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 10, StringSerializer.INSTANCE, object11);
                            v2 |= 0x400;
                            break;
                        }
                        case 11: {
                            object12 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 11, StringSerializer.INSTANCE, object12);
                            v2 |= 0x800;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v4);
                        }
                    }
                }
                v1 = v2;
                object9 = object12;
                object7 = object13;
                object10 = object14;
                object5 = object15;
                object3 = object16;
                object4 = object17;
                object2 = object18;
                object1 = object19;
                object0 = object20;
                z = z1;
                v = v3;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new ShippingAddress(v1, v, ((String)object0), z, ((Date)object1), ((ShippingAddressType)object2), ((String)object3), ((String)object4), ((String)object5), ((String)object10), ((String)object7), ((String)object11), ((String)object9), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull ShippingAddress shippingAddress0) {
            q.g(encoder0, "encoder");
            q.g(shippingAddress0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            ShippingAddress.write$Self(shippingAddress0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((ShippingAddress)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/ShippingAddress$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/ShippingAddress;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String baseAddress;
    @Nullable
    private final String detailAddress;
    private final long id;
    private final boolean isDefault;
    @Nullable
    private final String name;
    @Nullable
    private final String receiverName;
    @Nullable
    private final String receiverPhoneNumber1;
    @Nullable
    private final String receiverPhoneNumber2;
    @Nullable
    private final ShippingAddressType type;
    @Nullable
    private final Date updatedAt;
    @Nullable
    private final String zipCode;
    @Nullable
    private final String zoneNumber;

    static {
        ShippingAddress.Companion = new Companion(null);
    }

    @d
    public ShippingAddress(int v, long v1, String s, @SerialName("is_default") boolean z, @SerialName("updated_at") @Serializable(with = LongDateSerializer.class) Date date0, ShippingAddressType shippingAddressType0, @SerialName("base_address") String s1, @SerialName("detail_address") String s2, @SerialName("receiver_name") String s3, @SerialName("receiver_phone_number1") String s4, @SerialName("receiver_phone_number2") String s5, @SerialName("zone_number") String s6, @SerialName("zip_code") String s7, SerializationConstructorMarker serializationConstructorMarker0) {
        if(0xFFF != (v & 0xFFF)) {
            PluginExceptionsKt.throwMissingFieldException(v, 0xFFF, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.id = v1;
        this.name = s;
        this.isDefault = z;
        this.updatedAt = date0;
        this.type = shippingAddressType0;
        this.baseAddress = s1;
        this.detailAddress = s2;
        this.receiverName = s3;
        this.receiverPhoneNumber1 = s4;
        this.receiverPhoneNumber2 = s5;
        this.zoneNumber = s6;
        this.zipCode = s7;
    }

    public ShippingAddress(long v, @Nullable String s, boolean z, @Nullable Date date0, @Nullable ShippingAddressType shippingAddressType0, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7) {
        this.id = v;
        this.name = s;
        this.isDefault = z;
        this.updatedAt = date0;
        this.type = shippingAddressType0;
        this.baseAddress = s1;
        this.detailAddress = s2;
        this.receiverName = s3;
        this.receiverPhoneNumber1 = s4;
        this.receiverPhoneNumber2 = s5;
        this.zoneNumber = s6;
        this.zipCode = s7;
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final String component10() {
        return this.receiverPhoneNumber2;
    }

    @Nullable
    public final String component11() {
        return this.zoneNumber;
    }

    @Nullable
    public final String component12() {
        return this.zipCode;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isDefault;
    }

    @Nullable
    public final Date component4() {
        return this.updatedAt;
    }

    @Nullable
    public final ShippingAddressType component5() {
        return this.type;
    }

    @Nullable
    public final String component6() {
        return this.baseAddress;
    }

    @Nullable
    public final String component7() {
        return this.detailAddress;
    }

    @Nullable
    public final String component8() {
        return this.receiverName;
    }

    @Nullable
    public final String component9() {
        return this.receiverPhoneNumber1;
    }

    @NotNull
    public final ShippingAddress copy(long v, @Nullable String s, boolean z, @Nullable Date date0, @Nullable ShippingAddressType shippingAddressType0, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7) {
        return new ShippingAddress(v, s, z, date0, shippingAddressType0, s1, s2, s3, s4, s5, s6, s7);
    }

    public static ShippingAddress copy$default(ShippingAddress shippingAddress0, long v, String s, boolean z, Date date0, ShippingAddressType shippingAddressType0, String s1, String s2, String s3, String s4, String s5, String s6, String s7, int v1, Object object0) {
        long v2 = (v1 & 1) == 0 ? v : shippingAddress0.id;
        String s8 = (v1 & 2) == 0 ? s : shippingAddress0.name;
        boolean z1 = (v1 & 4) == 0 ? z : shippingAddress0.isDefault;
        Date date1 = (v1 & 8) == 0 ? date0 : shippingAddress0.updatedAt;
        ShippingAddressType shippingAddressType1 = (v1 & 16) == 0 ? shippingAddressType0 : shippingAddress0.type;
        String s9 = (v1 & 0x20) == 0 ? s1 : shippingAddress0.baseAddress;
        String s10 = (v1 & 0x40) == 0 ? s2 : shippingAddress0.detailAddress;
        String s11 = (v1 & 0x80) == 0 ? s3 : shippingAddress0.receiverName;
        String s12 = (v1 & 0x100) == 0 ? s4 : shippingAddress0.receiverPhoneNumber1;
        String s13 = (v1 & 0x200) == 0 ? s5 : shippingAddress0.receiverPhoneNumber2;
        String s14 = (v1 & 0x400) == 0 ? s6 : shippingAddress0.zoneNumber;
        return (v1 & 0x800) == 0 ? shippingAddress0.copy(v2, s8, z1, date1, shippingAddressType1, s9, s10, s11, s12, s13, s14, s7) : shippingAddress0.copy(v2, s8, z1, date1, shippingAddressType1, s9, s10, s11, s12, s13, s14, shippingAddress0.zipCode);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ShippingAddress)) {
            return false;
        }
        if(this.id != ((ShippingAddress)object0).id) {
            return false;
        }
        if(!q.b(this.name, ((ShippingAddress)object0).name)) {
            return false;
        }
        if(this.isDefault != ((ShippingAddress)object0).isDefault) {
            return false;
        }
        if(!q.b(this.updatedAt, ((ShippingAddress)object0).updatedAt)) {
            return false;
        }
        if(this.type != ((ShippingAddress)object0).type) {
            return false;
        }
        if(!q.b(this.baseAddress, ((ShippingAddress)object0).baseAddress)) {
            return false;
        }
        if(!q.b(this.detailAddress, ((ShippingAddress)object0).detailAddress)) {
            return false;
        }
        if(!q.b(this.receiverName, ((ShippingAddress)object0).receiverName)) {
            return false;
        }
        if(!q.b(this.receiverPhoneNumber1, ((ShippingAddress)object0).receiverPhoneNumber1)) {
            return false;
        }
        if(!q.b(this.receiverPhoneNumber2, ((ShippingAddress)object0).receiverPhoneNumber2)) {
            return false;
        }
        return q.b(this.zoneNumber, ((ShippingAddress)object0).zoneNumber) ? q.b(this.zipCode, ((ShippingAddress)object0).zipCode) : false;
    }

    @Nullable
    public final String getBaseAddress() {
        return this.baseAddress;
    }

    @SerialName("base_address")
    public static void getBaseAddress$annotations() {
    }

    @Nullable
    public final String getDetailAddress() {
        return this.detailAddress;
    }

    @SerialName("detail_address")
    public static void getDetailAddress$annotations() {
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getReceiverName() {
        return this.receiverName;
    }

    @SerialName("receiver_name")
    public static void getReceiverName$annotations() {
    }

    @Nullable
    public final String getReceiverPhoneNumber1() {
        return this.receiverPhoneNumber1;
    }

    @SerialName("receiver_phone_number1")
    public static void getReceiverPhoneNumber1$annotations() {
    }

    @Nullable
    public final String getReceiverPhoneNumber2() {
        return this.receiverPhoneNumber2;
    }

    @SerialName("receiver_phone_number2")
    public static void getReceiverPhoneNumber2$annotations() {
    }

    @Nullable
    public final ShippingAddressType getType() {
        return this.type;
    }

    @Nullable
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    @SerialName("updated_at")
    @Serializable(with = LongDateSerializer.class)
    public static void getUpdatedAt$annotations() {
    }

    @Nullable
    public final String getZipCode() {
        return this.zipCode;
    }

    @SerialName("zip_code")
    public static void getZipCode$annotations() {
    }

    @Nullable
    public final String getZoneNumber() {
        return this.zoneNumber;
    }

    @SerialName("zone_number")
    public static void getZoneNumber$annotations() {
    }

    @Override
    public int hashCode() {
        int v = Long.hashCode(this.id);
        int v1 = 0;
        int v2 = this.name == null ? 0 : this.name.hashCode();
        int v3 = this.isDefault;
        if(v3) {
            v3 = 1;
        }
        int v4 = this.updatedAt == null ? 0 : this.updatedAt.hashCode();
        int v5 = this.type == null ? 0 : this.type.hashCode();
        int v6 = this.baseAddress == null ? 0 : this.baseAddress.hashCode();
        int v7 = this.detailAddress == null ? 0 : this.detailAddress.hashCode();
        int v8 = this.receiverName == null ? 0 : this.receiverName.hashCode();
        int v9 = this.receiverPhoneNumber1 == null ? 0 : this.receiverPhoneNumber1.hashCode();
        int v10 = this.receiverPhoneNumber2 == null ? 0 : this.receiverPhoneNumber2.hashCode();
        int v11 = this.zoneNumber == null ? 0 : this.zoneNumber.hashCode();
        String s = this.zipCode;
        if(s != null) {
            v1 = s.hashCode();
        }
        return ((((((((((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v1;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    @SerialName("is_default")
    public static void isDefault$annotations() {
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ShippingAddress(id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", name=");
        stringBuilder0.append(this.name);
        stringBuilder0.append(", isDefault=");
        stringBuilder0.append(this.isDefault);
        stringBuilder0.append(", updatedAt=");
        stringBuilder0.append(this.updatedAt);
        stringBuilder0.append(", type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", baseAddress=");
        stringBuilder0.append(this.baseAddress);
        A7.d.u(stringBuilder0, ", detailAddress=", this.detailAddress, ", receiverName=", this.receiverName);
        A7.d.u(stringBuilder0, ", receiverPhoneNumber1=", this.receiverPhoneNumber1, ", receiverPhoneNumber2=", this.receiverPhoneNumber2);
        A7.d.u(stringBuilder0, ", zoneNumber=", this.zoneNumber, ", zipCode=", this.zipCode);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    public static final void write$Self(@NotNull ShippingAddress shippingAddress0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(shippingAddress0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeLongElement(serialDescriptor0, 0, shippingAddress0.id);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, StringSerializer.INSTANCE, shippingAddress0.name);
        compositeEncoder0.encodeBooleanElement(serialDescriptor0, 2, shippingAddress0.isDefault);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, new LongDateSerializer(), shippingAddress0.updatedAt);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, ShippingAddressTypeSerializer.INSTANCE, shippingAddress0.type);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, shippingAddress0.baseAddress);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 6, StringSerializer.INSTANCE, shippingAddress0.detailAddress);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 7, StringSerializer.INSTANCE, shippingAddress0.receiverName);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 8, StringSerializer.INSTANCE, shippingAddress0.receiverPhoneNumber1);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 9, StringSerializer.INSTANCE, shippingAddress0.receiverPhoneNumber2);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 10, StringSerializer.INSTANCE, shippingAddress0.zoneNumber);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 11, StringSerializer.INSTANCE, shippingAddress0.zipCode);
    }
}

