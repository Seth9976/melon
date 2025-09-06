package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments.Builder;
import com.facebook.share.model.CameraEffectArguments;
import ie.m;
import java.util.HashMap;
import java.util.Iterator;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000EB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0007J\u0014\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\tH\u0007R2\u0010\u0003\u001A&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/facebook/share/internal/CameraEffectJSONUtility;", "", "()V", "SETTERS", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "Lkotlin/collections/HashMap;", "convertToCameraEffectArguments", "Lcom/facebook/share/model/CameraEffectArguments;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "arguments", "Setter", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CameraEffectJSONUtility {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bb\u0018\u00002\u00020\u0001J)\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "builder", "", "key", "value", "Lie/H;", "setOnArgumentsBuilder", "(Lcom/facebook/share/model/CameraEffectArguments$Builder;Ljava/lang/String;Ljava/lang/Object;)V", "Lorg/json/JSONObject;", "json", "setOnJSON", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    interface Setter {
        void setOnArgumentsBuilder(@NotNull Builder arg1, @NotNull String arg2, @Nullable Object arg3);

        void setOnJSON(@NotNull JSONObject arg1, @NotNull String arg2, @Nullable Object arg3);
    }

    @NotNull
    public static final CameraEffectJSONUtility INSTANCE;
    @NotNull
    private static final HashMap SETTERS;

    static {
        CameraEffectJSONUtility.INSTANCE = new CameraEffectJSONUtility();
        CameraEffectJSONUtility.SETTERS.1 cameraEffectJSONUtility$SETTERS$10 = new CameraEffectJSONUtility.SETTERS.1();
        m m0 = new m(String.class, cameraEffectJSONUtility$SETTERS$10);
        CameraEffectJSONUtility.SETTERS.2 cameraEffectJSONUtility$SETTERS$20 = new CameraEffectJSONUtility.SETTERS.2();
        m m1 = new m(String[].class, cameraEffectJSONUtility$SETTERS$20);
        CameraEffectJSONUtility.SETTERS.3 cameraEffectJSONUtility$SETTERS$30 = new CameraEffectJSONUtility.SETTERS.3();
        CameraEffectJSONUtility.SETTERS = C.R(new m[]{m0, m1, new m(JSONArray.class, cameraEffectJSONUtility$SETTERS$30)});
    }

    @Nullable
    public static final CameraEffectArguments convertToCameraEffectArguments(@Nullable JSONObject jSONObject0) {
        if(jSONObject0 == null) {
            return null;
        }
        Builder cameraEffectArguments$Builder0 = new Builder();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s = (String)object0;
            Object object1 = jSONObject0.get(s);
            if(object1 != JSONObject.NULL) {
                Class class0 = object1.getClass();
                Setter cameraEffectJSONUtility$Setter0 = (Setter)CameraEffectJSONUtility.SETTERS.get(class0);
                if(cameraEffectJSONUtility$Setter0 == null) {
                    throw new IllegalArgumentException("Unsupported type: " + object1.getClass());
                }
                q.f(s, "key");
                cameraEffectJSONUtility$Setter0.setOnArgumentsBuilder(cameraEffectArguments$Builder0, s, object1);
            }
        }
        return cameraEffectArguments$Builder0.build();
    }

    @Nullable
    public static final JSONObject convertToJSON(@Nullable CameraEffectArguments cameraEffectArguments0) {
        if(cameraEffectArguments0 == null) {
            return null;
        }
        JSONObject jSONObject0 = new JSONObject();
        for(Object object0: cameraEffectArguments0.keySet()) {
            String s = (String)object0;
            Object object1 = cameraEffectArguments0.get(s);
            if(object1 != null) {
                Class class0 = object1.getClass();
                Setter cameraEffectJSONUtility$Setter0 = (Setter)CameraEffectJSONUtility.SETTERS.get(class0);
                if(cameraEffectJSONUtility$Setter0 == null) {
                    throw new IllegalArgumentException("Unsupported type: " + object1.getClass());
                }
                cameraEffectJSONUtility$Setter0.setOnJSON(jSONObject0, s, object1);
            }
        }
        return jSONObject0;
    }
}

