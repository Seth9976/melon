package com.kakao.sdk.template.model;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumsKt;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
final class IdType.Companion..cachedSerializer.delegate.1 extends r implements a {
    public static final IdType.Companion..cachedSerializer.delegate.1 INSTANCE;

    static {
        IdType.Companion..cachedSerializer.delegate.1.INSTANCE = new IdType.Companion..cachedSerializer.delegate.1();
    }

    public IdType.Companion..cachedSerializer.delegate.1() {
        super(0);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }

    @NotNull
    public final KSerializer invoke() {
        return EnumsKt.createMarkedEnumSerializer("com.kakao.sdk.template.model.IdType", IdType.values(), new String[]{"event", "calendar"}, new Annotation[][]{0, 0});
    }
}

