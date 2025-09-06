package com.kakao.sdk.user.model;

import U4.x;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002<;BC\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001A\u00020\u0007\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b\f\u0010\rB_\b\u0017\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001A\u00020\u0007\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\f\u0010\u0012J(\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016H\u00C7\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001CJ\u0010\u0010\u001E\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010 \u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b \u0010!J\u0012\u0010\"\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b$\u0010!J\u0012\u0010%\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b%\u0010#JZ\u0010&\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001A\u00020\u00072\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0007H\u00C6\u0001\u00A2\u0006\u0004\b&\u0010\'J\u0010\u0010(\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b(\u0010\u001CJ\u0010\u0010)\u001A\u00020\u000EH\u00D6\u0001\u00A2\u0006\u0004\b)\u0010*J\u001A\u0010,\u001A\u00020\u00072\b\u0010+\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010.\u001A\u0004\b/\u0010\u001CR \u0010\u0004\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010.\u0012\u0004\b1\u00102\u001A\u0004\b0\u0010\u001CR\u0017\u0010\u0006\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u00103\u001A\u0004\b4\u0010\u001FR\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u00105\u001A\u0004\b6\u0010!R\u0019\u0010\t\u001A\u0004\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\t\u00107\u001A\u0004\b8\u0010#R\u0017\u0010\n\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\n\u00105\u001A\u0004\b9\u0010!R\u0019\u0010\u000B\u001A\u0004\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\u000B\u00107\u001A\u0004\b:\u0010#\u00A8\u0006="}, d2 = {"Lcom/kakao/sdk/user/model/Scope;", "", "", "id", "displayName", "Lcom/kakao/sdk/user/model/ScopeType;", "type", "", "using", "delegated", "agreed", "revocable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/user/model/ScopeType;ZLjava/lang/Boolean;ZLjava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/user/model/ScopeType;ZLjava/lang/Boolean;ZLjava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/Scope;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lcom/kakao/sdk/user/model/ScopeType;", "component4", "()Z", "component5", "()Ljava/lang/Boolean;", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/user/model/ScopeType;ZLjava/lang/Boolean;ZLjava/lang/Boolean;)Lcom/kakao/sdk/user/model/Scope;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getDisplayName", "getDisplayName$annotations", "()V", "Lcom/kakao/sdk/user/model/ScopeType;", "getType", "Z", "getUsing", "Ljava/lang/Boolean;", "getDelegated", "getAgreed", "getRevocable", "Companion", "$serializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class Scope {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/Scope.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/Scope;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/Scope;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/Scope;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer scope$$serializer0 = new .serializer();
            .serializer.INSTANCE = scope$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.Scope", scope$$serializer0, 7);
            pluginGeneratedSerialDescriptor0.addElement("id", false);
            pluginGeneratedSerialDescriptor0.addElement("display_name", false);
            pluginGeneratedSerialDescriptor0.addElement("type", false);
            pluginGeneratedSerialDescriptor0.addElement("using", false);
            pluginGeneratedSerialDescriptor0.addElement("delegated", false);
            pluginGeneratedSerialDescriptor0.addElement("agreed", false);
            pluginGeneratedSerialDescriptor0.addElement("revocable", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = EnumsKt.createSimpleEnumSerializer("com.kakao.sdk.user.model.ScopeType", ScopeType.values());
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE);
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE);
            return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializer0, BooleanSerializer.INSTANCE, kSerializer1, BooleanSerializer.INSTANCE, kSerializer2};
        }

        @NotNull
        public Scope deserialize(@NotNull Decoder decoder0) {
            String s3;
            int v;
            boolean z3;
            boolean z2;
            String s2;
            Object object2;
            Object object1;
            Object object0;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            if(compositeDecoder0.decodeSequentially()) {
                String s = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                String s1 = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                object0 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, EnumsKt.createSimpleEnumSerializer("com.kakao.sdk.user.model.ScopeType", ScopeType.values()), null);
                boolean z = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 3);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, BooleanSerializer.INSTANCE, null);
                boolean z1 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 5);
                object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, null);
                s2 = s;
                z2 = z1;
                z3 = z;
                v = 0x7F;
                s3 = s1;
            }
            else {
                boolean z4 = false;
                int v1 = 0;
                Object object3 = null;
                String s4 = null;
                String s5 = null;
                Object object4 = null;
                boolean z5 = false;
                Object object5 = null;
                boolean z6 = true;
                while(z6) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            z6 = false;
                            break;
                        }
                        case 0: {
                            v1 |= 1;
                            s4 = compositeDecoder0.decodeStringElement(serialDescriptor0, 0);
                            break;
                        }
                        case 1: {
                            s5 = compositeDecoder0.decodeStringElement(serialDescriptor0, 1);
                            v1 |= 2;
                            break;
                        }
                        case 2: {
                            object4 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, EnumsKt.createSimpleEnumSerializer("com.kakao.sdk.user.model.ScopeType", ScopeType.values()), object4);
                            v1 |= 4;
                            break;
                        }
                        case 3: {
                            z5 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 3);
                            v1 |= 8;
                            break;
                        }
                        case 4: {
                            object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, BooleanSerializer.INSTANCE, object5);
                            v1 |= 16;
                            break;
                        }
                        case 5: {
                            z4 = compositeDecoder0.decodeBooleanElement(serialDescriptor0, 5);
                            v1 |= 0x20;
                            break;
                        }
                        case 6: {
                            object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, object3);
                            v1 |= 0x40;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                }
                z2 = z4;
                object2 = object3;
                object1 = object5;
                z3 = z5;
                v = v1;
                s2 = s4;
                s3 = s5;
                object0 = object4;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new Scope(v, s2, s3, ((ScopeType)object0), z3, ((Boolean)object1), z2, ((Boolean)object2), null);
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

        public void serialize(@NotNull Encoder encoder0, @NotNull Scope scope0) {
            q.g(encoder0, "encoder");
            q.g(scope0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            Scope.write$Self(scope0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((Scope)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/Scope$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/Scope;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final boolean agreed;
    @Nullable
    private final Boolean delegated;
    @NotNull
    private final String displayName;
    @NotNull
    private final String id;
    @Nullable
    private final Boolean revocable;
    @NotNull
    private final ScopeType type;
    private final boolean using;

    static {
        Scope.Companion = new Companion(null);
    }

    @d
    public Scope(int v, String s, @SerialName("display_name") String s1, ScopeType scopeType0, boolean z, Boolean boolean0, boolean z1, Boolean boolean1, SerializationConstructorMarker serializationConstructorMarker0) {
        if(0x7F != (v & 0x7F)) {
            PluginExceptionsKt.throwMissingFieldException(v, 0x7F, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.id = s;
        this.displayName = s1;
        this.type = scopeType0;
        this.using = z;
        this.delegated = boolean0;
        this.agreed = z1;
        this.revocable = boolean1;
    }

    public Scope(@NotNull String s, @NotNull String s1, @NotNull ScopeType scopeType0, boolean z, @Nullable Boolean boolean0, boolean z1, @Nullable Boolean boolean1) {
        q.g(s, "id");
        q.g(s1, "displayName");
        q.g(scopeType0, "type");
        super();
        this.id = s;
        this.displayName = s1;
        this.type = scopeType0;
        this.using = z;
        this.delegated = boolean0;
        this.agreed = z1;
        this.revocable = boolean1;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.displayName;
    }

    @NotNull
    public final ScopeType component3() {
        return this.type;
    }

    public final boolean component4() {
        return this.using;
    }

    @Nullable
    public final Boolean component5() {
        return this.delegated;
    }

    public final boolean component6() {
        return this.agreed;
    }

    @Nullable
    public final Boolean component7() {
        return this.revocable;
    }

    @NotNull
    public final Scope copy(@NotNull String s, @NotNull String s1, @NotNull ScopeType scopeType0, boolean z, @Nullable Boolean boolean0, boolean z1, @Nullable Boolean boolean1) {
        q.g(s, "id");
        q.g(s1, "displayName");
        q.g(scopeType0, "type");
        return new Scope(s, s1, scopeType0, z, boolean0, z1, boolean1);
    }

    public static Scope copy$default(Scope scope0, String s, String s1, ScopeType scopeType0, boolean z, Boolean boolean0, boolean z1, Boolean boolean1, int v, Object object0) {
        if((v & 1) != 0) {
            s = scope0.id;
        }
        if((v & 2) != 0) {
            s1 = scope0.displayName;
        }
        if((v & 4) != 0) {
            scopeType0 = scope0.type;
        }
        if((v & 8) != 0) {
            z = scope0.using;
        }
        if((v & 16) != 0) {
            boolean0 = scope0.delegated;
        }
        if((v & 0x20) != 0) {
            z1 = scope0.agreed;
        }
        if((v & 0x40) != 0) {
            boolean1 = scope0.revocable;
        }
        return scope0.copy(s, s1, scopeType0, z, boolean0, z1, boolean1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Scope)) {
            return false;
        }
        if(!q.b(this.id, ((Scope)object0).id)) {
            return false;
        }
        if(!q.b(this.displayName, ((Scope)object0).displayName)) {
            return false;
        }
        if(this.type != ((Scope)object0).type) {
            return false;
        }
        if(this.using != ((Scope)object0).using) {
            return false;
        }
        if(!q.b(this.delegated, ((Scope)object0).delegated)) {
            return false;
        }
        return this.agreed == ((Scope)object0).agreed ? q.b(this.revocable, ((Scope)object0).revocable) : false;
    }

    public final boolean getAgreed() {
        return this.agreed;
    }

    @Nullable
    public final Boolean getDelegated() {
        return this.delegated;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @SerialName("display_name")
    public static void getDisplayName$annotations() {
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Boolean getRevocable() {
        return this.revocable;
    }

    @NotNull
    public final ScopeType getType() {
        return this.type;
    }

    public final boolean getUsing() {
        return this.using;
    }

    @Override
    public int hashCode() {
        int v = x.b(this.id.hashCode() * 0x1F, 0x1F, this.displayName);
        int v1 = this.type.hashCode();
        int v2 = this.using;
        int v3 = 1;
        if(v2) {
            v2 = 1;
        }
        int v4 = 0;
        int v5 = this.delegated == null ? 0 : this.delegated.hashCode();
        if(!this.agreed) {
            v3 = false;
        }
        Boolean boolean0 = this.revocable;
        if(boolean0 != null) {
            v4 = boolean0.hashCode();
        }
        return ((((v1 + v) * 0x1F + v2) * 0x1F + v5) * 0x1F + v3) * 0x1F + v4;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = A7.d.o("Scope(id=", this.id, ", displayName=", this.displayName, ", type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", using=");
        stringBuilder0.append(this.using);
        stringBuilder0.append(", delegated=");
        stringBuilder0.append(this.delegated);
        stringBuilder0.append(", agreed=");
        stringBuilder0.append(this.agreed);
        stringBuilder0.append(", revocable=");
        stringBuilder0.append(this.revocable);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    public static final void write$Self(@NotNull Scope scope0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(scope0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, scope0.id);
        compositeEncoder0.encodeStringElement(serialDescriptor0, 1, scope0.displayName);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 2, EnumsKt.createSimpleEnumSerializer("com.kakao.sdk.user.model.ScopeType", ScopeType.values()), scope0.type);
        compositeEncoder0.encodeBooleanElement(serialDescriptor0, 3, scope0.using);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, BooleanSerializer.INSTANCE, scope0.delegated);
        compositeEncoder0.encodeBooleanElement(serialDescriptor0, 5, scope0.agreed);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, scope0.revocable);
    }
}

