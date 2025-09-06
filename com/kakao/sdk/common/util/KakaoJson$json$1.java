package com.kakao.sdk.common.util;

import com.kakao.sdk.common.json.DateSerializer;
import ie.H;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/serialization/json/JsonBuilder;", "Lie/H;", "invoke", "(Lkotlinx/serialization/json/JsonBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class KakaoJson.json.1 extends r implements k {
    public static final KakaoJson.json.1 INSTANCE;

    static {
        KakaoJson.json.1.INSTANCE = new KakaoJson.json.1();
    }

    public KakaoJson.json.1() {
        super(1);
    }

    @Override  // we.k
    public Object invoke(Object object0) {
        this.invoke(((JsonBuilder)object0));
        return H.a;
    }

    public final void invoke(@NotNull JsonBuilder jsonBuilder0) {
        q.g(jsonBuilder0, "$this$Json");
        jsonBuilder0.setIgnoreUnknownKeys(true);
        jsonBuilder0.setLenient(true);
        jsonBuilder0.setCoerceInputValues(true);
        jsonBuilder0.setExplicitNulls(false);
        jsonBuilder0.setAllowStructuredMapKeys(true);
        SerializersModuleBuilder serializersModuleBuilder0 = new SerializersModuleBuilder();
        DateSerializer dateSerializer0 = new DateSerializer();
        serializersModuleBuilder0.contextual(I.a.b(Date.class), dateSerializer0);
        jsonBuilder0.setSerializersModule(serializersModuleBuilder0.build());
    }
}

