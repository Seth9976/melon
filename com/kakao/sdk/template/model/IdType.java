package com.kakao.sdk.template.model;

import i.n.i.b.a.s.e.M3;
import ie.C;
import ie.I;
import ie.j;
import ie.k;
import ie.r;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/kakao/sdk/template/model/IdType;", "", "(Ljava/lang/String;I)V", "value", "", "getValue", "()Ljava/lang/String;", "EVENT", "CALENDAR", "Companion", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public enum IdType {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/IdType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/IdType;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final j get$cachedSerializer$delegate() {
            return IdType.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer serializer() {
            return (KSerializer)this.get$cachedSerializer$delegate().getValue();
        }
    }

    @SerialName("event")
    EVENT,
    @SerialName("calendar")
    CALENDAR;

    @NotNull
    private static final j $cachedSerializer$delegate;
    @NotNull
    public static final Companion Companion;

    private static final IdType[] $values() [...] // Inlined contents

    static {
        j j0;
        IdType.Companion = new Companion(null);
        a a0 = IdType.Companion..cachedSerializer.delegate.1.INSTANCE;
        C c0 = C.a;
        if(a0 == null) {
            NullPointerException nullPointerException0 = new NullPointerException(q.i("initializer"));
            q.l(nullPointerException0, q.class.getName());
            throw nullPointerException0;
        }
        switch(k.b.ordinal()) {
            case 0: {
                j0 = new r(a0);
                break;
            }
            case 1: {
                j j1 = new ie.q();  // 初始化器: Ljava/lang/Object;-><init>()V
                j1.a = a0;
                j1.b = c0;
                j0 = j1;
                break;
            }
            case 2: {
                j j2 = new I();  // 初始化器: Ljava/lang/Object;-><init>()V
                j2.a = a0;
                j2.b = c0;
                j0 = j2;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        IdType.$cachedSerializer$delegate = j0;
    }

    @NotNull
    public final String getValue() {
        Annotation annotation0 = IdType.class.getField(this.name()).getAnnotation(SerialName.class);
        q.d(annotation0);
        return ((SerialName)annotation0).value();
    }
}

