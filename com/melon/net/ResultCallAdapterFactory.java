package com.melon.net;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tg.U;
import tg.d;
import tg.e;
import tg.f;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\f\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\n\u001A\u00020\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/melon/net/ResultCallAdapterFactory;", "Ltg/e;", "<init>", "()V", "Ljava/lang/reflect/Type;", "returnType", "", "", "annotations", "Ltg/U;", "retrofit", "Ltg/f;", "get", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Ltg/U;)Ltg/f;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ResultCallAdapterFactory extends e {
    public static final int $stable = 8;

    @Override  // tg.e
    @Nullable
    public f get(@NotNull Type type0, @NotNull Annotation[] arr_annotation, @NotNull U u0) {
        q.g(type0, "returnType");
        q.g(arr_annotation, "annotations");
        q.g(u0, "retrofit");
        if(q.b(e.getRawType(type0), d.class)) {
            if(!(type0 instanceof ParameterizedType)) {
                throw new IllegalStateException("Check failed.");
            }
            Type type1 = e.getParameterUpperBound(0, ((ParameterizedType)type0));
            if(q.b(e.getRawType(type1), ApiResult.class)) {
                if(!(type1 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Check failed.");
                }
                Type type2 = e.getParameterUpperBound(0, ((ParameterizedType)type1));
                q.d(type2);
                return new ApiResultCallAdapter(type2);
            }
        }
        return null;
    }
}

