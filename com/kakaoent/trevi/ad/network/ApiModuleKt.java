package com.kakaoent.trevi.ad.network;

import com.kakaoent.trevi.ad.TreviAd;
import com.kakaoent.trevi.ad.constants.TreviAdUrl;
import com.kakaoent.trevi.ad.constants.TreviAdUrlType;
import com.kakaoent.trevi.ad.exception.TreviAdException;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import tg.T;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A/\u0010\u0005\u001A\n \u0004*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001A#\u0010\b\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Ltg/T;", "Ljava/lang/Class;", "clazz", "kotlin.jvm.PlatformType", "create", "(Ltg/T;Ljava/lang/Class;)Ljava/lang/Object;", "", "getUrl", "(Ljava/lang/Class;)Ljava/lang/String;", "trevi-ad-android-sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public abstract class ApiModuleKt {
    public static final Object access$create(T t0, Class class0) {
        return ApiModuleKt.create(t0, class0);
    }

    private static final Object create(T t0, Class class0) {
        synchronized(ApiModuleKt.class) {
            t0.a(ApiModuleKt.getUrl(class0));
            return t0.b().b(class0);
        }
    }

    private static final String getUrl(Class class0) {
        Object object0;
        Annotation annotation0;
        Annotation[] arr_annotation = class0.getAnnotations();
        q.f(arr_annotation, "getAnnotations(...)");
        for(int v = 0; true; ++v) {
            annotation0 = null;
            object0 = null;
            if(v >= arr_annotation.length) {
                break;
            }
            Annotation annotation1 = arr_annotation[v];
            if(annotation1 instanceof TreviAdUrl) {
                annotation0 = annotation1;
                break;
            }
        }
        if(annotation0 != null) {
            object0 = TreviAdUrl.class.cast(annotation0);
        }
        if(((TreviAdUrl)object0) != null) {
            TreviAdUrlType treviAdUrlType0 = ((TreviAdUrl)object0).type();
            if(treviAdUrlType0 != null) {
                return treviAdUrlType0.getUrl(TreviAd.INSTANCE.getServerConfig$trevi_ad_android_sdk_release());
            }
        }
        throw new TreviAdException("RetrofitApi must use TreviAdUrl annotation");
    }
}

