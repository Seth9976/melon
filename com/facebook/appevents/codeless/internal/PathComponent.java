package com.facebook.appevents.codeless.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001AB\u000F\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\bR\u0011\u0010\u000B\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\bR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\b¨\u0006\u001B"}, d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent;", "", "component", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "className", "", "getClassName", "()Ljava/lang/String;", "description", "getDescription", "hint", "getHint", "id", "", "getId", "()I", "index", "getIndex", "matchBitmask", "getMatchBitmask", "tag", "getTag", "text", "getText", "Companion", "MatchBitmaskType", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PathComponent {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent$Companion;", "", "()V", "PATH_CLASS_NAME_KEY", "", "PATH_DESCRIPTION_KEY", "PATH_HINT_KEY", "PATH_ID_KEY", "PATH_INDEX_KEY", "PATH_MATCH_BITMASK_KEY", "PATH_TAG_KEY", "PATH_TEXT_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent$MatchBitmaskType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ID", "TEXT", "TAG", "DESCRIPTION", "HINT", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);

        private final int value;

        private static final MatchBitmaskType[] $values() [...] // Inlined contents

        private MatchBitmaskType(int v1) {
            this.value = v1;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PATH_CLASS_NAME_KEY = "class_name";
    @NotNull
    private static final String PATH_DESCRIPTION_KEY = "description";
    @NotNull
    private static final String PATH_HINT_KEY = "hint";
    @NotNull
    private static final String PATH_ID_KEY = "id";
    @NotNull
    private static final String PATH_INDEX_KEY = "index";
    @NotNull
    private static final String PATH_MATCH_BITMASK_KEY = "match_bitmask";
    @NotNull
    private static final String PATH_TAG_KEY = "tag";
    @NotNull
    private static final String PATH_TEXT_KEY = "text";
    @NotNull
    private final String className;
    @NotNull
    private final String description;
    @NotNull
    private final String hint;
    private final int id;
    private final int index;
    private final int matchBitmask;
    @NotNull
    private final String tag;
    @NotNull
    private final String text;

    static {
        PathComponent.Companion = new Companion(null);
    }

    public PathComponent(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "component");
        super();
        String s = jSONObject0.getString("class_name");
        q.f(s, "component.getString(PATH_CLASS_NAME_KEY)");
        this.className = s;
        this.index = jSONObject0.optInt("index", -1);
        this.id = jSONObject0.optInt("id");
        String s1 = jSONObject0.optString("text");
        q.f(s1, "component.optString(PATH_TEXT_KEY)");
        this.text = s1;
        String s2 = jSONObject0.optString("tag");
        q.f(s2, "component.optString(PATH_TAG_KEY)");
        this.tag = s2;
        String s3 = jSONObject0.optString("description");
        q.f(s3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.description = s3;
        String s4 = jSONObject0.optString("hint");
        q.f(s4, "component.optString(PATH_HINT_KEY)");
        this.hint = s4;
        this.matchBitmask = jSONObject0.optInt("match_bitmask");
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getHint() {
        return this.hint;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getMatchBitmask() {
        return this.matchBitmask;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}

