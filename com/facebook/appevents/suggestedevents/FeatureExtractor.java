package com.facebook.appevents.suggestedevents;

import Tf.a;
import Tf.o;
import android.util.Patterns;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import ie.m;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.regex.Pattern;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\b\u00C1\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u0010\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u001E\u0010\u001FJ/\u0010$\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\f2\u0006\u0010!\u001A\u00020\f2\u0006\u0010\"\u001A\u00020\f2\u0006\u0010#\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b$\u0010%J\u001F\u0010$\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\f2\u0006\u0010#\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b$\u0010\'J+\u0010+\u001A\u00020\u00042\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\f0(2\f\u0010*\u001A\b\u0012\u0004\u0012\u00020\f0(H\u0002\u00A2\u0006\u0004\b+\u0010,J\u001F\u0010-\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b-\u0010.J\u001F\u00101\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00142\u0006\u00100\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\b1\u00102J\u0017\u00103\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b3\u00104J/\u0010:\u001A\u00020\t2\u0006\u00105\u001A\u00020\u00122\n\u00108\u001A\u000606j\u0002`72\n\u00109\u001A\u000606j\u0002`7H\u0002\u00A2\u0006\u0004\b:\u0010;J\u0019\u0010<\u001A\u0004\u0018\u00010\u00122\u0006\u00105\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b<\u0010=R\u0014\u0010?\u001A\u00020>8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bC\u0010BR\u0014\u0010D\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bD\u0010BR\u0014\u0010E\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bE\u0010BR\u0014\u0010F\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bF\u0010BR\u0014\u0010G\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bG\u0010BR\"\u0010I\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bI\u0010JR\"\u0010K\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bK\u0010JR\"\u0010L\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010M\u001A\u00020\u00128\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010P\u00A8\u0006Q"}, d2 = {"Lcom/facebook/appevents/suggestedevents/FeatureExtractor;", "", "<init>", "()V", "", "isInitialized", "()Z", "Ljava/io/File;", "file", "Lie/H;", "initialize", "(Ljava/io/File;)V", "", "buttonText", "activityName", "appName", "getTextFeature", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lorg/json/JSONObject;", "viewHierarchy", "", "getDenseFeatures", "(Lorg/json/JSONObject;Ljava/lang/String;)[F", "node", "parseFeatures", "(Lorg/json/JSONObject;)[F", "Lorg/json/JSONArray;", "siblings", "screenName", "formFieldsJSON", "nonparseFeatures", "(Lorg/json/JSONObject;Lorg/json/JSONArray;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[F", "language", "event", "textType", "matchText", "regexMatched", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "pattern", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "indicators", "values", "matchIndicators", "([Ljava/lang/String;[Ljava/lang/String;)Z", "pruneTree", "(Lorg/json/JSONObject;Lorg/json/JSONArray;)Z", "a", "b", "sum", "([F[F)V", "isButton", "(Lorg/json/JSONObject;)Z", "view", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "textSB", "hintSB", "updateHintAndTextRecursively", "(Lorg/json/JSONObject;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)V", "getInteractedNode", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "", "NUM_OF_FEATURES", "I", "REGEX_CR_PASSWORD_FIELD", "Ljava/lang/String;", "REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD", "REGEX_CR_HAS_LOG_IN_KEYWORDS", "REGEX_CR_HAS_SIGN_ON_KEYWORDS", "REGEX_ADD_TO_CART_BUTTON_TEXT", "REGEX_ADD_TO_CART_PAGE_TITLE", "", "languageInfo", "Ljava/util/Map;", "eventInfo", "textTypeInfo", "rules", "Lorg/json/JSONObject;", "initialized", "Z", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FeatureExtractor {
    @NotNull
    public static final FeatureExtractor INSTANCE = null;
    private static final int NUM_OF_FEATURES = 30;
    @NotNull
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    @NotNull
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    @NotNull
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    @NotNull
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    @NotNull
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    @NotNull
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map eventInfo;
    private static boolean initialized;
    private static Map languageInfo;
    private static JSONObject rules;
    private static Map textTypeInfo;

    static {
        FeatureExtractor.INSTANCE = new FeatureExtractor();
    }

    @Nullable
    public static final float[] getDenseFeatures(@NotNull JSONObject jSONObject0, @NotNull String s) {
        Class class0 = FeatureExtractor.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(jSONObject0, "viewHierarchy");
            q.g(s, "appName");
            if(!FeatureExtractor.initialized) {
                return null;
            }
            float[] arr_f = new float[30];
            for(int v = 0; v < 30; ++v) {
                arr_f[v] = 0.0f;
            }
            try {
                String s1 = s.toLowerCase();
                q.f(s1, "this as java.lang.String).toLowerCase()");
                JSONObject jSONObject1 = new JSONObject(jSONObject0.optJSONObject("view").toString());
                String s2 = jSONObject0.optString("screenname");
                JSONArray jSONArray0 = new JSONArray();
                FeatureExtractor featureExtractor0 = FeatureExtractor.INSTANCE;
                featureExtractor0.pruneTree(jSONObject1, jSONArray0);
                featureExtractor0.sum(arr_f, featureExtractor0.parseFeatures(jSONObject1));
                JSONObject jSONObject2 = featureExtractor0.getInteractedNode(jSONObject1);
                if(jSONObject2 == null) {
                    return null;
                }
                q.f(s2, "screenName");
                String s3 = jSONObject1.toString();
                q.f(s3, "viewTree.toString()");
                featureExtractor0.sum(arr_f, featureExtractor0.nonparseFeatures(jSONObject2, jSONArray0, s2, s3, s1));
            }
            catch(JSONException unused_ex) {
            }
            return arr_f;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final JSONObject getInteractedNode(JSONObject jSONObject0) {
        JSONObject jSONObject2;
        int v1;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if(jSONObject0.optBoolean("is_interacted")) {
                return jSONObject0;
            }
            JSONArray jSONArray0 = jSONObject0.optJSONArray("childviews");
            if(jSONArray0 == null) {
                return null;
            }
            int v = jSONArray0.length();
            v1 = 0;
        label_9:
            while(v1 < v) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v1);
                q.f(jSONObject1, "children.getJSONObject(i)");
                jSONObject2 = this.getInteractedNode(jSONObject1);
                goto label_17;
            }
        }
        catch(JSONException throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        label_17:
            if(jSONObject2 != null) {
                return jSONObject2;
            }
            ++v1;
            goto label_9;
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    @NotNull
    public static final String getTextFeature(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        Class class0 = FeatureExtractor.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "buttonText");
            q.g(s1, "activityName");
            q.g(s2, "appName");
            String s3 = (s2 + " | " + s1 + ", " + s).toLowerCase();
            q.f(s3, "this as java.lang.String).toLowerCase()");
            return s3;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void initialize(@Nullable File file0) {
        Class class0 = FeatureExtractor.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                try {
                    FeatureExtractor.rules = new JSONObject();
                    FileInputStream fileInputStream0 = new FileInputStream(file0);
                    byte[] arr_b = new byte[fileInputStream0.available()];
                    fileInputStream0.read(arr_b);
                    fileInputStream0.close();
                    FeatureExtractor.rules = new JSONObject(new String(arr_b, a.a));
                }
                catch(Exception unused_ex) {
                    return;
                }
                FeatureExtractor.languageInfo = C.S(new m[]{new m("ENGLISH", "1"), new m("GERMAN", "2"), new m("SPANISH", "3"), new m("JAPANESE", "4")});
                FeatureExtractor.eventInfo = C.S(new m[]{new m("VIEW_CONTENT", "0"), new m("SEARCH", "1"), new m("ADD_TO_CART", "2"), new m("ADD_TO_WISHLIST", "3"), new m("INITIATE_CHECKOUT", "4"), new m("ADD_PAYMENT_INFO", "5"), new m("PURCHASE", "6"), new m("LEAD", "7"), new m("COMPLETE_REGISTRATION", "8")});
                FeatureExtractor.textTypeInfo = C.S(new m[]{new m("BUTTON_TEXT", "1"), new m("PAGE_TITLE", "2"), new m("RESOLVED_DOCUMENT_LINK", "3"), new m("BUTTON_ID", "4")});
                FeatureExtractor.initialized = true;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    private final boolean isButton(JSONObject jSONObject0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if((jSONObject0.optInt("classtypebitmask") & 1) << 5 > 0) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return false;
    }

    // 去混淆评级： 低(20)
    public static final boolean isInitialized() {
        return CrashShieldHandler.isObjectCrashing(FeatureExtractor.class) ? false : FeatureExtractor.initialized;
    }

    private final boolean matchIndicators(String[] arr_s, String[] arr_s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        else {
            try {
                int v = 0;
                while(v < arr_s.length) {
                    String s = arr_s[v];
                    int v1 = 0;
                label_5:
                    if(v1 >= arr_s1.length) {
                        ++v;
                        continue;
                    }
                    if(!o.v0(arr_s1[v1], s, false)) {
                        ++v1;
                        goto label_5;
                    }
                    return true;
                }
                return false;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    private final float[] nonparseFeatures(JSONObject jSONObject0, JSONArray jSONArray0, String s, String s1, String s2) {
        float[] arr_f2;
        int v3;
        float[] arr_f1;
        float[] arr_f = null;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            arr_f1 = new float[30];
            for(int v = 0; v < 30; ++v) {
                arr_f1[v] = 0.0f;
            }
            int v1 = jSONArray0.length();
            arr_f1[3] = v1 <= 1 ? 0.0f : ((float)v1) - 1.0f;
            try {
                int v2 = jSONArray0.length();
                v3 = 0;
            }
            catch(JSONException unused_ex) {
                arr_f2 = arr_f;
                break;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
        while(true) {
            if(v3 >= v2) {
                arr_f2 = arr_f;
                break;
            }
            try {
                arr_f2 = arr_f;
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v3);
                q.f(jSONObject1, "siblings.getJSONObject(i)");
                if(this.isButton(jSONObject1)) {
                    ++arr_f1[9];
                }
                ++v3;
                arr_f = arr_f2;
                continue;
            }
            catch(JSONException unused_ex) {
                break;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return arr_f2;
            }
        }
        try {
            arr_f1[13] = -1.0f;
            arr_f1[14] = -1.0f;
            String s3 = s + '|' + s2;
            StringBuilder stringBuilder0 = new StringBuilder();
            StringBuilder stringBuilder1 = new StringBuilder();
            this.updateHintAndTextRecursively(jSONObject0, stringBuilder1, stringBuilder0);
            String s4 = stringBuilder0.toString();
            q.f(s4, "hintSB.toString()");
            String s5 = stringBuilder1.toString();
            q.f(s5, "textSB.toString()");
            arr_f1[15] = this.regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_TEXT", s5) ? 1.0f : 0.0f;
            arr_f1[16] = this.regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "PAGE_TITLE", s3) ? 1.0f : 0.0f;
            arr_f1[17] = this.regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_ID", s4) ? 1.0f : 0.0f;
            arr_f1[18] = o.v0(s1, "password", false) ? 1.0f : 0.0f;
            arr_f1[19] = this.regexMatched("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", s1) ? 1.0f : 0.0f;
            arr_f1[20] = this.regexMatched("(?i)(sign in)|login|signIn", s1) ? 1.0f : 0.0f;
            arr_f1[21] = this.regexMatched("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", s1) ? 1.0f : 0.0f;
            arr_f1[22] = this.regexMatched("ENGLISH", "PURCHASE", "BUTTON_TEXT", s5) ? 1.0f : 0.0f;
            arr_f1[24] = this.regexMatched("ENGLISH", "PURCHASE", "PAGE_TITLE", s3) ? 1.0f : 0.0f;
            arr_f1[25] = this.regexMatched("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", s5) ? 1.0f : 0.0f;
            arr_f1[27] = this.regexMatched("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", s3) ? 1.0f : 0.0f;
            arr_f1[28] = this.regexMatched("ENGLISH", "LEAD", "BUTTON_TEXT", s5) ? 1.0f : 0.0f;
            arr_f1[29] = this.regexMatched("ENGLISH", "LEAD", "PAGE_TITLE", s3) ? 1.0f : 0.0f;
            return arr_f1;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return arr_f2;
    }

    private final float[] parseFeatures(JSONObject jSONObject0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] arr_f = new float[30];
            for(int v1 = 0; v1 < 30; ++v1) {
                arr_f[v1] = 0.0f;
            }
            String s = jSONObject0.optString("text");
            q.f(s, "node.optString(TEXT_KEY)");
            String s1 = s.toLowerCase();
            q.f(s1, "this as java.lang.String).toLowerCase()");
            String s2 = jSONObject0.optString("hint");
            q.f(s2, "node.optString(HINT_KEY)");
            String s3 = s2.toLowerCase();
            q.f(s3, "this as java.lang.String).toLowerCase()");
            String s4 = jSONObject0.optString("classname");
            q.f(s4, "node.optString(CLASS_NAME_KEY)");
            String s5 = s4.toLowerCase();
            q.f(s5, "this as java.lang.String).toLowerCase()");
            int v2 = jSONObject0.optInt("inputtype", -1);
            String[] arr_s = {s1, s3};
            if(this.matchIndicators(new String[]{"$", "amount", "price", "total"}, arr_s)) {
                ++arr_f[0];
            }
            if(this.matchIndicators(new String[]{"password", "pwd"}, arr_s)) {
                ++arr_f[1];
            }
            if(this.matchIndicators(new String[]{"tel", "phone"}, arr_s)) {
                ++arr_f[2];
            }
            if(this.matchIndicators(new String[]{"search"}, arr_s)) {
                ++arr_f[4];
            }
            if(v2 >= 0) {
                ++arr_f[5];
            }
            if(v2 == 2 || v2 == 3) {
                ++arr_f[6];
            }
            if(v2 == 0x20 || Patterns.EMAIL_ADDRESS.matcher(s1).matches()) {
                ++arr_f[7];
            }
            if(o.v0(s5, "checkbox", false)) {
                ++arr_f[8];
            }
            if(this.matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{s1})) {
                ++arr_f[10];
            }
            if(o.v0(s5, "radio", false) && o.v0(s5, "button", false)) {
                ++arr_f[12];
            }
            try {
                JSONArray jSONArray0 = jSONObject0.optJSONArray("childviews");
                int v3 = jSONArray0.length();
                for(int v = 0; v < v3; ++v) {
                    JSONObject jSONObject1 = jSONArray0.getJSONObject(v);
                    q.f(jSONObject1, "childViews.getJSONObject(i)");
                    this.sum(arr_f, this.parseFeatures(jSONObject1));
                }
            }
            catch(JSONException unused_ex) {
            }
            return arr_f;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final boolean pruneTree(JSONObject jSONObject0, JSONArray jSONArray0) {
        boolean z;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if(jSONObject0.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray jSONArray1 = jSONObject0.optJSONArray("childviews");
            int v = jSONArray1.length();
            for(int v1 = 0; true; ++v1) {
                z = false;
                if(v1 >= v) {
                    break;
                }
                if(jSONArray1.getJSONObject(v1).optBoolean("is_interacted")) {
                    z = true;
                    break;
                }
            }
            boolean z1 = z;
            JSONArray jSONArray2 = new JSONArray();
            if(z) {
                int v2 = jSONArray1.length();
                for(int v3 = 0; v3 < v2; ++v3) {
                    jSONArray0.put(jSONArray1.getJSONObject(v3));
                }
                return z1;
            }
            int v4 = jSONArray1.length();
            for(int v5 = 0; v5 < v4; ++v5) {
                JSONObject jSONObject1 = jSONArray1.getJSONObject(v5);
                q.f(jSONObject1, "child");
                if(this.pruneTree(jSONObject1, jSONArray0)) {
                    jSONArray2.put(jSONObject1);
                    z1 = true;
                }
            }
            jSONObject0.put("childviews", jSONArray2);
            return z1;
        }
        catch(JSONException unused_ex) {
            return false;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    private final boolean regexMatched(String s, String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Pattern.compile(s).matcher(s1).find();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    private final boolean regexMatched(String s, String s1, String s2, String s3) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            JSONObject jSONObject0 = FeatureExtractor.rules;
            String s4 = null;
            if(jSONObject0 != null) {
                JSONObject jSONObject1 = jSONObject0.optJSONObject("rulesForLanguage");
                if(jSONObject1 != null) {
                    Map map0 = FeatureExtractor.languageInfo;
                    if(map0 == null) {
                        q.m("languageInfo");
                        throw null;
                    }
                    JSONObject jSONObject2 = jSONObject1.optJSONObject(((String)map0.get(s)));
                    if(jSONObject2 != null) {
                        JSONObject jSONObject3 = jSONObject2.optJSONObject("rulesForEvent");
                        if(jSONObject3 != null) {
                            Map map1 = FeatureExtractor.eventInfo;
                            if(map1 == null) {
                                q.m("eventInfo");
                                throw null;
                            }
                            JSONObject jSONObject4 = jSONObject3.optJSONObject(((String)map1.get(s1)));
                            if(jSONObject4 != null) {
                                JSONObject jSONObject5 = jSONObject4.optJSONObject("positiveRules");
                                if(jSONObject5 != null) {
                                    Map map2 = FeatureExtractor.textTypeInfo;
                                    if(map2 != null) {
                                        s4 = jSONObject5.optString(((String)map2.get(s2)));
                                        return s4 == null ? false : this.regexMatched(s4, s3);
                                    }
                                    q.m("textTypeInfo");
                                    throw null;
                                }
                            }
                        }
                    }
                }
                return s4 == null ? false : this.regexMatched(s4, s3);
            }
            q.m("rules");
            throw null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    private final void sum(float[] arr_f, float[] arr_f1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                for(int v = 0; v < arr_f.length; ++v) {
                    arr_f[v] += arr_f1[v];
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void updateHintAndTextRecursively(JSONObject jSONObject0, StringBuilder stringBuilder0, StringBuilder stringBuilder1) {
        int v1;
        JSONArray jSONArray0;
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                String s = jSONObject0.optString("text", "");
                q.f(s, "view.optString(TEXT_KEY, \"\")");
                String s1 = s.toLowerCase();
                q.f(s1, "this as java.lang.String).toLowerCase()");
                String s2 = jSONObject0.optString("hint", "");
                q.f(s2, "view.optString(HINT_KEY, \"\")");
                String s3 = s2.toLowerCase();
                q.f(s3, "this as java.lang.String).toLowerCase()");
                if(s1.length() > 0) {
                    stringBuilder0.append(s1);
                    stringBuilder0.append(" ");
                }
                if(s3.length() > 0) {
                    stringBuilder1.append(s3);
                    stringBuilder1.append(" ");
                }
                jSONArray0 = jSONObject0.optJSONArray("childviews");
                if(jSONArray0 != null) {
                    int v = jSONArray0.length();
                    v1 = 0;
                    goto label_19;
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
            return;
        label_19:
            while(v1 < v) {
                try {
                    JSONObject jSONObject1 = jSONArray0.getJSONObject(v1);
                    q.f(jSONObject1, "currentChildView");
                    this.updateHintAndTextRecursively(jSONObject1, stringBuilder0, stringBuilder1);
                }
                catch(JSONException unused_ex) {
                }
                catch(Throwable throwable0) {
                    CrashShieldHandler.handleThrowable(throwable0, this);
                    return;
                }
                ++v1;
            }
        }
        try {
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }
}

