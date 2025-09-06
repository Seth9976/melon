package com.facebook.appevents.aam;

import Tf.o;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00058F¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\u000E"}, d2 = {"Lcom/facebook/appevents/aam/MetadataRule;", "", "name", "", "keyRules", "", "valRule", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getKeyRules", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getValRule", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MetadataRule {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\rH\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\r0\tH\u0007¢\u0006\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001A\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\n0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/aam/MetadataRule$Companion;", "", "<init>", "()V", "Lorg/json/JSONObject;", "jsonObject", "Lie/H;", "constructRules", "(Lorg/json/JSONObject;)V", "", "Lcom/facebook/appevents/aam/MetadataRule;", "getRules", "()Ljava/util/Set;", "", "rulesFromServer", "updateRules", "(Ljava/lang/String;)V", "getEnabledRuleNames", "FIELD_K", "Ljava/lang/String;", "FIELD_K_DELIMITER", "FIELD_V", "", "rules", "Ljava/util/Set;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final void constructRules(JSONObject jSONObject0) {
            Iterator iterator0 = jSONObject0.keys();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                String s = (String)object0;
                JSONObject jSONObject1 = jSONObject0.optJSONObject(s);
                if(jSONObject1 != null) {
                    String s1 = jSONObject1.optString("k");
                    String s2 = jSONObject1.optString("v");
                    q.f(s1, "k");
                    if(s1.length() != 0) {
                        Set set0 = MetadataRule.access$getRules$cp();
                        q.f(s, "key");
                        List list0 = o.R0(s1, new String[]{","}, 0, 6);
                        q.f(s2, "v");
                        set0.add(new MetadataRule(s, list0, s2, null));
                    }
                }
            }
        }

        @NotNull
        public final Set getEnabledRuleNames() {
            Set set0 = new HashSet();
            for(Object object0: MetadataRule.access$getRules$cp()) {
                set0.add(((MetadataRule)object0).getName());
            }
            return set0;
        }

        @NotNull
        public final Set getRules() {
            return new HashSet(MetadataRule.access$getRules$cp());
        }

        public final void updateRules(@NotNull String s) {
            q.g(s, "rulesFromServer");
            try {
                MetadataRule.access$getRules$cp().clear();
                this.constructRules(new JSONObject(s));
            }
            catch(JSONException unused_ex) {
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String FIELD_K = "k";
    @NotNull
    private static final String FIELD_K_DELIMITER = ",";
    @NotNull
    private static final String FIELD_V = "v";
    @NotNull
    private final List keyRules;
    @NotNull
    private final String name;
    @NotNull
    private static final Set rules;
    @NotNull
    private final String valRule;

    static {
        MetadataRule.Companion = new Companion(null);
        MetadataRule.rules = new CopyOnWriteArraySet();
    }

    private MetadataRule(String s, List list0, String s1) {
        this.name = s;
        this.valRule = s1;
        this.keyRules = list0;
    }

    public MetadataRule(String s, List list0, String s1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, list0, s1);
    }

    // 去混淆评级： 低(20)
    public static final Set access$getRules$cp() {
        return CrashShieldHandler.isObjectCrashing(MetadataRule.class) ? null : MetadataRule.rules;
    }

    @NotNull
    public static final Set getEnabledRuleNames() {
        Class class0 = MetadataRule.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return MetadataRule.Companion.getEnabledRuleNames();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public final List getKeyRules() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new ArrayList(this.keyRules);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final String getName() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.name;
    }

    @NotNull
    public static final Set getRules() {
        Class class0 = MetadataRule.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return MetadataRule.Companion.getRules();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final String getValRule() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.valRule;
    }

    public static final void updateRules(@NotNull String s) {
        Class class0 = MetadataRule.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            MetadataRule.Companion.updateRules(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

