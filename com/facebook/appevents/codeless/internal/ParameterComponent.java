package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\bR\u0011\u0010\u0010\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ParameterComponent;", "", "component", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "name", "", "getName", "()Ljava/lang/String;", "path", "", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "getPath", "()Ljava/util/List;", "pathType", "getPathType", "value", "getValue", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ParameterComponent {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ParameterComponent$Companion;", "", "()V", "PARAMETER_NAME_KEY", "", "PARAMETER_PATH_KEY", "PARAMETER_VALUE_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PARAMETER_NAME_KEY = "name";
    @NotNull
    private static final String PARAMETER_PATH_KEY = "path";
    @NotNull
    private static final String PARAMETER_VALUE_KEY = "value";
    @NotNull
    private final String name;
    @NotNull
    private final List path;
    @NotNull
    private final String pathType;
    @NotNull
    private final String value;

    static {
        ParameterComponent.Companion = new Companion(null);
    }

    public ParameterComponent(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "component");
        super();
        String s = jSONObject0.getString("name");
        q.f(s, "component.getString(PARAMETER_NAME_KEY)");
        this.name = s;
        String s1 = jSONObject0.optString("value");
        q.f(s1, "component.optString(PARAMETER_VALUE_KEY)");
        this.value = s1;
        String s2 = jSONObject0.optString("path_type", "absolute");
        q.f(s2, "component.optString(Cons…tants.PATH_TYPE_ABSOLUTE)");
        this.pathType = s2;
        ArrayList arrayList0 = new ArrayList();
        JSONArray jSONArray0 = jSONObject0.optJSONArray("path");
        if(jSONArray0 != null) {
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v1);
                q.f(jSONObject1, "jsonPathArray.getJSONObject(i)");
                arrayList0.add(new PathComponent(jSONObject1));
            }
        }
        this.path = arrayList0;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List getPath() {
        return this.path;
    }

    @NotNull
    public final String getPathType() {
        return this.pathType;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}

