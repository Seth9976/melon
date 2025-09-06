package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \"2\u00020\u0001:\u0003!\"#BY\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0003\u0012\u0006\u0010\u0010\u001A\u00020\u0003¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0010\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000E\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000F\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0017\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\r0\n8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0017\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8F¢\u0006\u0006\u001A\u0004\b \u0010\u001E¨\u0006$"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding;", "", "eventName", "", "method", "Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "type", "Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "appVersion", "path", "", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "parameters", "Lcom/facebook/appevents/codeless/internal/ParameterComponent;", "componentId", "pathType", "activityName", "(Ljava/lang/String;Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "getAppVersion", "getComponentId", "getEventName", "getMethod", "()Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "getPathType", "getType", "()Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "viewParameters", "getViewParameters", "()Ljava/util/List;", "viewPath", "getViewPath", "ActionType", "Companion", "MappingMethod", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class EventBinding {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "", "(Ljava/lang/String;I)V", "CLICK", "SELECTED", "TEXT_CHANGED", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED;

        private static final ActionType[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\u0018\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00040\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0007¨\u0006\u000B"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$Companion;", "", "()V", "getInstanceFromJson", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "Lorg/json/JSONObject;", "parseArray", "", "array", "Lorg/json/JSONArray;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final EventBinding getInstanceFromJson(@NotNull JSONObject jSONObject0) {
            q.g(jSONObject0, "mapping");
            String s = jSONObject0.getString("event_name");
            String s1 = jSONObject0.getString("method");
            q.f(s1, "mapping.getString(\"method\")");
            Locale locale0 = Locale.ENGLISH;
            q.f(locale0, "ENGLISH");
            String s2 = s1.toUpperCase(locale0);
            q.f(s2, "this as java.lang.String).toUpperCase(locale)");
            MappingMethod eventBinding$MappingMethod0 = MappingMethod.valueOf(s2);
            String s3 = jSONObject0.getString("event_type");
            q.f(s3, "mapping.getString(\"event_type\")");
            String s4 = s3.toUpperCase(locale0);
            q.f(s4, "this as java.lang.String).toUpperCase(locale)");
            ActionType eventBinding$ActionType0 = ActionType.valueOf(s4);
            String s5 = jSONObject0.getString("app_version");
            JSONArray jSONArray0 = jSONObject0.getJSONArray("path");
            ArrayList arrayList0 = new ArrayList();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v1);
                q.f(jSONObject1, "jsonPath");
                arrayList0.add(new PathComponent(jSONObject1));
            }
            String s6 = jSONObject0.optString("path_type", "absolute");
            JSONArray jSONArray1 = jSONObject0.optJSONArray("parameters");
            ArrayList arrayList1 = new ArrayList();
            if(jSONArray1 != null) {
                int v3 = jSONArray1.length();
                for(int v2 = 0; v2 < v3; ++v2) {
                    JSONObject jSONObject2 = jSONArray1.getJSONObject(v2);
                    q.f(jSONObject2, "jsonParameter");
                    arrayList1.add(new ParameterComponent(jSONObject2));
                }
            }
            String s7 = jSONObject0.optString("component_id");
            String s8 = jSONObject0.optString("activity_name");
            q.f(s, "eventName");
            q.f(s5, "appVersion");
            q.f(s7, "componentId");
            q.f(s6, "pathType");
            q.f(s8, "activityName");
            return new EventBinding(s, eventBinding$MappingMethod0, eventBinding$ActionType0, s5, arrayList0, arrayList1, s7, s6, s8);
        }

        @NotNull
        public final List parseArray(@Nullable JSONArray jSONArray0) {
            List list0 = new ArrayList();
            if(jSONArray0 != null) {
                try {
                    int v = jSONArray0.length();
                    for(int v1 = 0; v1 < v; ++v1) {
                        JSONObject jSONObject0 = jSONArray0.getJSONObject(v1);
                        q.f(jSONObject0, "array.getJSONObject(i)");
                        ((ArrayList)list0).add(this.getInstanceFromJson(jSONObject0));
                    }
                    return list0;
                }
                catch(JSONException | IllegalArgumentException unused_ex) {
                }
            }
            return list0;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "", "(Ljava/lang/String;I)V", "MANUAL", "INFERENCE", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum MappingMethod {
        MANUAL,
        INFERENCE;

        private static final MappingMethod[] $values() [...] // Inlined contents
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String activityName;
    @NotNull
    private final String appVersion;
    @NotNull
    private final String componentId;
    @NotNull
    private final String eventName;
    @NotNull
    private final MappingMethod method;
    @NotNull
    private final List parameters;
    @NotNull
    private final List path;
    @NotNull
    private final String pathType;
    @NotNull
    private final ActionType type;

    static {
        EventBinding.Companion = new Companion(null);
    }

    public EventBinding(@NotNull String s, @NotNull MappingMethod eventBinding$MappingMethod0, @NotNull ActionType eventBinding$ActionType0, @NotNull String s1, @NotNull List list0, @NotNull List list1, @NotNull String s2, @NotNull String s3, @NotNull String s4) {
        q.g(s, "eventName");
        q.g(eventBinding$MappingMethod0, "method");
        q.g(eventBinding$ActionType0, "type");
        q.g(s1, "appVersion");
        q.g(list0, "path");
        q.g(list1, "parameters");
        q.g(s2, "componentId");
        q.g(s3, "pathType");
        q.g(s4, "activityName");
        super();
        this.eventName = s;
        this.method = eventBinding$MappingMethod0;
        this.type = eventBinding$ActionType0;
        this.appVersion = s1;
        this.path = list0;
        this.parameters = list1;
        this.componentId = s2;
        this.pathType = s3;
        this.activityName = s4;
    }

    @NotNull
    public final String getActivityName() {
        return this.activityName;
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getComponentId() {
        return this.componentId;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @NotNull
    public static final EventBinding getInstanceFromJson(@NotNull JSONObject jSONObject0) {
        return EventBinding.Companion.getInstanceFromJson(jSONObject0);
    }

    @NotNull
    public final MappingMethod getMethod() {
        return this.method;
    }

    @NotNull
    public final String getPathType() {
        return this.pathType;
    }

    @NotNull
    public final ActionType getType() {
        return this.type;
    }

    @NotNull
    public final List getViewParameters() {
        List list0 = Collections.unmodifiableList(this.parameters);
        q.f(list0, "unmodifiableList(parameters)");
        return list0;
    }

    @NotNull
    public final List getViewPath() {
        List list0 = Collections.unmodifiableList(this.path);
        q.f(list0, "unmodifiableList(path)");
        return list0;
    }

    @NotNull
    public static final List parseArray(@Nullable JSONArray jSONArray0) {
        return EventBinding.Companion.parseArray(jSONArray0);
    }
}

