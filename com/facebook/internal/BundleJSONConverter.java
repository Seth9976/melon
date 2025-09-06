package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0007J\u0010\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\bH\u0007R\u001E\u0010\u0003\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter;", "", "()V", "SETTERS", "", "Ljava/lang/Class;", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "convertToBundle", "Landroid/os/Bundle;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "bundle", "Setter", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BundleJSONConverter {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\'\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0001H&¢\u0006\u0004\b\b\u0010\tJ\'\u0010\f\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0001H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter$Setter;", "", "Landroid/os/Bundle;", "bundle", "", "key", "value", "Lie/H;", "setOnBundle", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "Lorg/json/JSONObject;", "json", "setOnJSON", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Setter {
        void setOnBundle(@NotNull Bundle arg1, @NotNull String arg2, @NotNull Object arg3);

        void setOnJSON(@NotNull JSONObject arg1, @NotNull String arg2, @NotNull Object arg3);
    }

    @NotNull
    public static final BundleJSONConverter INSTANCE;
    @NotNull
    private static final Map SETTERS;

    static {
        BundleJSONConverter.INSTANCE = new BundleJSONConverter();
        HashMap hashMap0 = new HashMap();
        BundleJSONConverter.SETTERS = hashMap0;
        com.facebook.internal.BundleJSONConverter.1 bundleJSONConverter$10 = new Setter() {
            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnBundle(@NotNull Bundle bundle0, @NotNull String s, @NotNull Object object0) {
                q.g(bundle0, "bundle");
                q.g(s, "key");
                q.g(object0, "value");
                bundle0.putBoolean(s, ((Boolean)object0).booleanValue());
            }

            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnJSON(@NotNull JSONObject jSONObject0, @NotNull String s, @NotNull Object object0) {
                q.g(jSONObject0, "json");
                q.g(s, "key");
                q.g(object0, "value");
                jSONObject0.put(s, object0);
            }
        };
        hashMap0.put(Boolean.class, bundleJSONConverter$10);
        com.facebook.internal.BundleJSONConverter.2 bundleJSONConverter$20 = new Setter() {
            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnBundle(@NotNull Bundle bundle0, @NotNull String s, @NotNull Object object0) {
                q.g(bundle0, "bundle");
                q.g(s, "key");
                q.g(object0, "value");
                bundle0.putInt(s, ((int)(((Integer)object0))));
            }

            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnJSON(@NotNull JSONObject jSONObject0, @NotNull String s, @NotNull Object object0) {
                q.g(jSONObject0, "json");
                q.g(s, "key");
                q.g(object0, "value");
                jSONObject0.put(s, object0);
            }
        };
        hashMap0.put(Integer.class, bundleJSONConverter$20);
        com.facebook.internal.BundleJSONConverter.3 bundleJSONConverter$30 = new Setter() {
            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnBundle(@NotNull Bundle bundle0, @NotNull String s, @NotNull Object object0) {
                q.g(bundle0, "bundle");
                q.g(s, "key");
                q.g(object0, "value");
                bundle0.putLong(s, ((long)(((Long)object0))));
            }

            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnJSON(@NotNull JSONObject jSONObject0, @NotNull String s, @NotNull Object object0) {
                q.g(jSONObject0, "json");
                q.g(s, "key");
                q.g(object0, "value");
                jSONObject0.put(s, object0);
            }
        };
        hashMap0.put(Long.class, bundleJSONConverter$30);
        com.facebook.internal.BundleJSONConverter.4 bundleJSONConverter$40 = new Setter() {
            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnBundle(@NotNull Bundle bundle0, @NotNull String s, @NotNull Object object0) {
                q.g(bundle0, "bundle");
                q.g(s, "key");
                q.g(object0, "value");
                bundle0.putDouble(s, ((double)(((Double)object0))));
            }

            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnJSON(@NotNull JSONObject jSONObject0, @NotNull String s, @NotNull Object object0) {
                q.g(jSONObject0, "json");
                q.g(s, "key");
                q.g(object0, "value");
                jSONObject0.put(s, object0);
            }
        };
        hashMap0.put(Double.class, bundleJSONConverter$40);
        com.facebook.internal.BundleJSONConverter.5 bundleJSONConverter$50 = new Setter() {
            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnBundle(@NotNull Bundle bundle0, @NotNull String s, @NotNull Object object0) {
                q.g(bundle0, "bundle");
                q.g(s, "key");
                q.g(object0, "value");
                bundle0.putString(s, ((String)object0));
            }

            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnJSON(@NotNull JSONObject jSONObject0, @NotNull String s, @NotNull Object object0) {
                q.g(jSONObject0, "json");
                q.g(s, "key");
                q.g(object0, "value");
                jSONObject0.put(s, object0);
            }
        };
        hashMap0.put(String.class, bundleJSONConverter$50);
        com.facebook.internal.BundleJSONConverter.6 bundleJSONConverter$60 = new Setter() {
            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnBundle(@NotNull Bundle bundle0, @NotNull String s, @NotNull Object object0) {
                q.g(bundle0, "bundle");
                q.g(s, "key");
                q.g(object0, "value");
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnJSON(@NotNull JSONObject jSONObject0, @NotNull String s, @NotNull Object object0) {
                q.g(jSONObject0, "json");
                q.g(s, "key");
                q.g(object0, "value");
                JSONArray jSONArray0 = new JSONArray();
                for(int v = 0; v < ((String[])object0).length; ++v) {
                    jSONArray0.put(((String[])object0)[v]);
                }
                jSONObject0.put(s, jSONArray0);
            }
        };
        hashMap0.put(String[].class, bundleJSONConverter$60);
        com.facebook.internal.BundleJSONConverter.7 bundleJSONConverter$70 = new Setter() {
            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnBundle(@NotNull Bundle bundle0, @NotNull String s, @NotNull Object object0) {
                q.g(bundle0, "bundle");
                q.g(s, "key");
                q.g(object0, "value");
                ArrayList arrayList0 = new ArrayList();
                if(((JSONArray)object0).length() == 0) {
                    bundle0.putStringArrayList(s, arrayList0);
                    return;
                }
                int v = ((JSONArray)object0).length();
                for(int v1 = 0; v1 < v; ++v1) {
                    Object object1 = ((JSONArray)object0).get(v1);
                    if(!(object1 instanceof String)) {
                        throw new IllegalArgumentException("Unexpected type in an array: " + object1.getClass());
                    }
                    arrayList0.add(object1);
                }
                bundle0.putStringArrayList(s, arrayList0);
            }

            @Override  // com.facebook.internal.BundleJSONConverter$Setter
            public void setOnJSON(@NotNull JSONObject jSONObject0, @NotNull String s, @NotNull Object object0) {
                q.g(jSONObject0, "json");
                q.g(s, "key");
                q.g(object0, "value");
                throw new IllegalArgumentException("JSONArray\'s are not supported in bundles.");
            }
        };
        hashMap0.put(JSONArray.class, bundleJSONConverter$70);
    }

    @NotNull
    public static final Bundle convertToBundle(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "jsonObject");
        Bundle bundle0 = new Bundle();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s = (String)object0;
            Object object1 = jSONObject0.get(s);
            if(object1 == JSONObject.NULL) {
            }
            else if(object1 instanceof JSONObject) {
                bundle0.putBundle(s, BundleJSONConverter.convertToBundle(((JSONObject)object1)));
            }
            else {
                Class class0 = object1.getClass();
                Setter bundleJSONConverter$Setter0 = (Setter)BundleJSONConverter.SETTERS.get(class0);
                if(bundleJSONConverter$Setter0 == null) {
                    throw new IllegalArgumentException("Unsupported type: " + object1.getClass());
                }
                q.f(s, "key");
                bundleJSONConverter$Setter0.setOnBundle(bundle0, s, object1);
            }
        }
        return bundle0;
    }

    @NotNull
    public static final JSONObject convertToJSON(@NotNull Bundle bundle0) {
        q.g(bundle0, "bundle");
        JSONObject jSONObject0 = new JSONObject();
        for(Object object0: bundle0.keySet()) {
            String s = (String)object0;
            Object object1 = bundle0.get(s);
            if(object1 != null) {
                if(!(object1 instanceof List)) {
                    if(object1 instanceof Bundle) {
                        jSONObject0.put(s, BundleJSONConverter.convertToJSON(((Bundle)object1)));
                    }
                    else {
                        Class class0 = object1.getClass();
                        Setter bundleJSONConverter$Setter0 = (Setter)BundleJSONConverter.SETTERS.get(class0);
                        if(bundleJSONConverter$Setter0 == null) {
                            throw new IllegalArgumentException("Unsupported type: " + object1.getClass());
                        }
                        q.f(s, "key");
                        bundleJSONConverter$Setter0.setOnJSON(jSONObject0, s, object1);
                    }
                    continue;
                }
                JSONArray jSONArray0 = new JSONArray();
                for(Object object2: ((List)object1)) {
                    jSONArray0.put(((String)object2));
                }
                jSONObject0.put(s, jSONArray0);
            }
        }
        return jSONObject0;
    }
}

