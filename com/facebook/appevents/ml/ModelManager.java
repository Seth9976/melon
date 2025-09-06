package com.facebook.appevents.ml;

import B9.g;
import C5.a;
import Ce.f;
import Tf.o;
import Tf.v;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask.Callback;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.k;
import i.n.i.b.a.s.e.M3;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\b\u00C7\u0002\u0018\u00002\u00020\u0001:\u0002BCB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001A\u0004\u0018\u00010\u000BH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0003J\u001B\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001B\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001EJ;\u0010#\u001A\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001F2\u0006\u0010\u001B\u001A\u00020\u001A2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00170\u001F2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020!0\u001FH\u0007\u00A2\u0006\u0004\b#\u0010$J\'\u0010(\u001A\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001F2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b(\u0010)J\'\u0010*\u001A\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001F2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b*\u0010)R\"\u0010-\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00103\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b3\u00100R\u0014\u00104\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b4\u00100R\u0014\u00105\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b5\u00100R\u0014\u00106\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b6\u00100R\u0014\u00107\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b7\u00100R\u0014\u00108\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b8\u00100R\u0014\u0010:\u001A\u0002098\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u001A\u0010=\u001A\b\u0012\u0004\u0012\u00020!0<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u001A\u0010?\u001A\b\u0012\u0004\u0012\u00020!0<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b?\u0010>R\u0014\u0010@\u001A\u00020\b8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b@\u0010A\u00A8\u0006D"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager;", "", "<init>", "()V", "Lie/H;", "enable", "", "timestamp", "", "isValidTimestamp", "(J)Z", "Lorg/json/JSONObject;", "models", "addModels", "(Lorg/json/JSONObject;)V", "jsonObject", "parseRawJsonObject", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "fetchModels", "()Lorg/json/JSONObject;", "enableMTML", "Lorg/json/JSONArray;", "jsonArray", "", "parseJsonArray", "(Lorg/json/JSONArray;)[F", "Lcom/facebook/appevents/ml/ModelManager$Task;", "task", "Ljava/io/File;", "getRuleFile", "(Lcom/facebook/appevents/ml/ModelManager$Task;)Ljava/io/File;", "", "denses", "", "texts", "predict", "(Lcom/facebook/appevents/ml/ModelManager$Task;[[F[Ljava/lang/String;)[Ljava/lang/String;", "Lcom/facebook/appevents/ml/MTensor;", "res", "thresholds", "processSuggestedEventResult", "(Lcom/facebook/appevents/ml/MTensor;[F)[Ljava/lang/String;", "processIntegrityDetectionResult", "", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "taskHandlers", "Ljava/util/Map;", "MODEL_ASSERT_STORE", "Ljava/lang/String;", "CACHE_KEY_MODELS", "MTML_USE_CASE", "USE_CASE_KEY", "VERSION_ID_KEY", "ASSET_URI_KEY", "RULES_URI_KEY", "THRESHOLD_KEY", "CACHE_KEY_REQUEST_TIMESTAMP", "", "MODEL_REQUEST_INTERVAL_MILLISECONDS", "I", "", "MTML_SUGGESTED_EVENTS_PREDICTION", "Ljava/util/List;", "MTML_INTEGRITY_DETECT_PREDICTION", "isLocaleEnglish", "()Z", "Task", "TaskHandler", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ModelManager {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004J\u0006\u0010\u0005\u001A\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$Task;", "", "(Ljava/lang/String;I)V", "toKey", "", "toUseCase", "MTML_INTEGRITY_DETECT", "MTML_APP_EVENT_PREDICTION", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Task {
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[Task.values().length];
                try {
                    arr_v[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        private static final Task[] $values() [...] // Inlined contents

        @NotNull
        public final String toKey() {
            switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                case 1: {
                    return "integrity_detect";
                }
                case 2: {
                    return "app_event_pred";
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }

        @NotNull
        public final String toUseCase() {
            switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                case 1: {
                    return "MTML_INTEGRITY_DETECT";
                }
                case 2: {
                    return "MTML_APP_EVENT_PRED";
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u00020\u0001:\u0001*B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001A\u00020\u00002\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016R\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\f\"\u0004\b\u001E\u0010\u000ER\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\f\"\u0004\b$\u0010\u000ER\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(¨\u0006+"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "", "useCase", "", "assetUri", "ruleUri", "versionId", "", "thresholds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[F)V", "getAssetUri", "()Ljava/lang/String;", "setAssetUri", "(Ljava/lang/String;)V", "model", "Lcom/facebook/appevents/ml/Model;", "getModel", "()Lcom/facebook/appevents/ml/Model;", "setModel", "(Lcom/facebook/appevents/ml/Model;)V", "onPostExecute", "Ljava/lang/Runnable;", "ruleFile", "Ljava/io/File;", "getRuleFile", "()Ljava/io/File;", "setRuleFile", "(Ljava/io/File;)V", "getRuleUri", "setRuleUri", "getThresholds", "()[F", "setThresholds", "([F)V", "getUseCase", "setUseCase", "getVersionId", "()I", "setVersionId", "(I)V", "setOnPostExecute", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class TaskHandler {
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000F\u001A\u00020\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\f\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\u00132\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00130\u001A¢\u0006\u0004\b\u0017\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler$Companion;", "", "<init>", "()V", "", "useCase", "", "versionId", "Lie/H;", "deleteOldFiles", "(Ljava/lang/String;I)V", "uri", "name", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "onComplete", "download", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/appevents/internal/FileDownloadTask$Callback;)V", "Lorg/json/JSONObject;", "json", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "build", "(Lorg/json/JSONObject;)Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "handler", "execute", "(Lcom/facebook/appevents/ml/ModelManager$TaskHandler;)V", "master", "", "slaves", "(Lcom/facebook/appevents/ml/ModelManager$TaskHandler;Ljava/util/List;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @Nullable
            public final TaskHandler build(@Nullable JSONObject jSONObject0) {
                if(jSONObject0 == null) {
                    return null;
                }
                try {
                    String s = jSONObject0.getString("use_case");
                    String s1 = jSONObject0.getString("asset_uri");
                    String s2 = jSONObject0.optString("rules_uri", null);
                    int v = jSONObject0.getInt("version_id");
                    JSONArray jSONArray0 = jSONObject0.getJSONArray("thresholds");
                    float[] arr_f = ModelManager.access$parseJsonArray(ModelManager.INSTANCE, jSONArray0);
                    q.f(s, "useCase");
                    q.f(s1, "assetUri");
                    return new TaskHandler(s, s1, s2, v, arr_f);
                }
                catch(Exception unused_ex) {
                    return null;
                }
            }

            private final void deleteOldFiles(String s, int v) {
                File file0 = Utils.getMlDir();
                if(file0 != null) {
                    File[] arr_file = file0.listFiles();
                    if(arr_file != null && arr_file.length != 0) {
                        for(int v1 = 0; v1 < arr_file.length; ++v1) {
                            File file1 = arr_file[v1];
                            String s1 = file1.getName();
                            q.f(s1, "name");
                            if(v.r0(s1, s, false) && !v.r0(s1, s + '_' + v, false)) {
                                file1.delete();
                            }
                        }
                    }
                }
            }

            private final void download(String s, String s1, Callback fileDownloadTask$Callback0) {
                File file0 = new File(Utils.getMlDir(), s1);
                if(s != null && !file0.exists()) {
                    new FileDownloadTask(s, file0, fileDownloadTask$Callback0).execute(new String[0]);
                    return;
                }
                fileDownloadTask$Callback0.onComplete(file0);
            }

            public final void execute(@NotNull TaskHandler modelManager$TaskHandler0) {
                q.g(modelManager$TaskHandler0, "handler");
                this.execute(modelManager$TaskHandler0, k.z(modelManager$TaskHandler0));
            }

            public final void execute(@NotNull TaskHandler modelManager$TaskHandler0, @NotNull List list0) {
                q.g(modelManager$TaskHandler0, "master");
                q.g(list0, "slaves");
                this.deleteOldFiles(modelManager$TaskHandler0.getUseCase(), modelManager$TaskHandler0.getVersionId());
                this.download(modelManager$TaskHandler0.getAssetUri(), modelManager$TaskHandler0.getUseCase() + '_' + modelManager$TaskHandler0.getVersionId(), new a(list0, 0));
            }

            private static final void execute$lambda$1(List list0, File file0) {
                q.g(list0, "$slaves");
                q.g(file0, "file");
                Model model0 = Model.Companion.build(file0);
                if(model0 != null) {
                    for(Object object0: list0) {
                        String s = ((TaskHandler)object0).getRuleUri();
                        g g0 = new g(3, ((TaskHandler)object0), model0);
                        TaskHandler.Companion.download(s, ((TaskHandler)object0).getUseCase() + '_' + ((TaskHandler)object0).getVersionId() + "_rule", g0);
                    }
                }
            }

            private static final void execute$lambda$1$lambda$0(TaskHandler modelManager$TaskHandler0, Model model0, File file0) {
                q.g(modelManager$TaskHandler0, "$slave");
                q.g(file0, "file");
                modelManager$TaskHandler0.setModel(model0);
                modelManager$TaskHandler0.setRuleFile(file0);
                Runnable runnable0 = modelManager$TaskHandler0.onPostExecute;
                if(runnable0 != null) {
                    runnable0.run();
                }
            }
        }

        @NotNull
        public static final Companion Companion;
        @NotNull
        private String assetUri;
        @Nullable
        private Model model;
        @Nullable
        private Runnable onPostExecute;
        @Nullable
        private File ruleFile;
        @Nullable
        private String ruleUri;
        @Nullable
        private float[] thresholds;
        @NotNull
        private String useCase;
        private int versionId;

        static {
            TaskHandler.Companion = new Companion(null);
        }

        public TaskHandler(@NotNull String s, @NotNull String s1, @Nullable String s2, int v, @Nullable float[] arr_f) {
            q.g(s, "useCase");
            q.g(s1, "assetUri");
            super();
            this.useCase = s;
            this.assetUri = s1;
            this.ruleUri = s2;
            this.versionId = v;
            this.thresholds = arr_f;
        }

        @NotNull
        public final String getAssetUri() {
            return this.assetUri;
        }

        @Nullable
        public final Model getModel() {
            return this.model;
        }

        @Nullable
        public final File getRuleFile() {
            return this.ruleFile;
        }

        @Nullable
        public final String getRuleUri() {
            return this.ruleUri;
        }

        @Nullable
        public final float[] getThresholds() {
            return this.thresholds;
        }

        @NotNull
        public final String getUseCase() {
            return this.useCase;
        }

        public final int getVersionId() {
            return this.versionId;
        }

        public final void setAssetUri(@NotNull String s) {
            q.g(s, "<set-?>");
            this.assetUri = s;
        }

        public final void setModel(@Nullable Model model0) {
            this.model = model0;
        }

        @NotNull
        public final TaskHandler setOnPostExecute(@Nullable Runnable runnable0) {
            this.onPostExecute = runnable0;
            return this;
        }

        public final void setRuleFile(@Nullable File file0) {
            this.ruleFile = file0;
        }

        public final void setRuleUri(@Nullable String s) {
            this.ruleUri = s;
        }

        public final void setThresholds(@Nullable float[] arr_f) {
            this.thresholds = arr_f;
        }

        public final void setUseCase(@NotNull String s) {
            q.g(s, "<set-?>");
            this.useCase = s;
        }

        public final void setVersionId(int v) {
            this.versionId = v;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class com.facebook.appevents.ml.ModelManager.WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Task.values().length];
            try {
                arr_v[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Task.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            com.facebook.appevents.ml.ModelManager.WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    private static final String ASSET_URI_KEY = "asset_uri";
    @NotNull
    private static final String CACHE_KEY_MODELS = "models";
    @NotNull
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    @NotNull
    public static final ModelManager INSTANCE = null;
    @NotNull
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    public static final int MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;
    @NotNull
    private static final List MTML_INTEGRITY_DETECT_PREDICTION = null;
    @NotNull
    private static final List MTML_SUGGESTED_EVENTS_PREDICTION = null;
    @NotNull
    private static final String MTML_USE_CASE = "MTML";
    @NotNull
    private static final String RULES_URI_KEY = "rules_uri";
    @NotNull
    private static final String THRESHOLD_KEY = "thresholds";
    @NotNull
    private static final String USE_CASE_KEY = "use_case";
    @NotNull
    private static final String VERSION_ID_KEY = "version_id";
    @NotNull
    private static final Map taskHandlers;

    static {
        ModelManager.INSTANCE = new ModelManager();
        ModelManager.taskHandlers = new ConcurrentHashMap();
        ModelManager.MTML_SUGGESTED_EVENTS_PREDICTION = k.A(new String[]{"other", "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout"});
        ModelManager.MTML_INTEGRITY_DETECT_PREDICTION = k.A(new String[]{"none", "address", "health"});
    }

    public static final float[] access$parseJsonArray(ModelManager modelManager0, JSONArray jSONArray0) {
        Class class0 = ModelManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return modelManager0.parseJsonArray(jSONArray0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final void addModels(JSONObject jSONObject0) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Iterator iterator0 = jSONObject0.keys();
                try {
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        JSONObject jSONObject1 = jSONObject0.getJSONObject(((String)object0));
                        TaskHandler modelManager$TaskHandler0 = TaskHandler.Companion.build(jSONObject1);
                        if(modelManager$TaskHandler0 != null) {
                            ModelManager.taskHandlers.put(modelManager$TaskHandler0.getUseCase(), modelManager$TaskHandler0);
                        }
                    }
                }
                catch(JSONException unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public static final void enable() {
        Class class0 = ModelManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            Utility.runOnNonUiThread(new A5.a(3));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void enable$lambda$0() {
        Class class0 = ModelManager.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.MODEL_STORE", 0);
                String s = sharedPreferences0.getString("models", null);
                JSONObject jSONObject0 = s == null || s.length() == 0 ? new JSONObject() : new JSONObject(s);
                long v = sharedPreferences0.getLong("model_request_timestamp", 0L);
                if(FeatureManager.isEnabled(Feature.ModelRequest) && jSONObject0.length() != 0 && ModelManager.INSTANCE.isValidTimestamp(v)) {
                    ModelManager.INSTANCE.addModels(jSONObject0);
                    ModelManager.INSTANCE.enableMTML();
                    return;
                }
                jSONObject0 = ModelManager.INSTANCE.fetchModels();
                if(jSONObject0 != null) {
                    sharedPreferences0.edit().putString("models", jSONObject0.toString()).putLong("model_request_timestamp", System.currentTimeMillis()).apply();
                    ModelManager.INSTANCE.addModels(jSONObject0);
                    ModelManager.INSTANCE.enableMTML();
                    return;
                }
                return;
            }
            catch(Exception unused_ex) {
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final void enableMTML() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                ArrayList arrayList0 = new ArrayList();
                String s = null;
                int v = 0;
                for(Object object0: ModelManager.taskHandlers.entrySet()) {
                    String s1 = (String)((Map.Entry)object0).getKey();
                    TaskHandler modelManager$TaskHandler0 = (TaskHandler)((Map.Entry)object0).getValue();
                    if(q.b(s1, "MTML_APP_EVENT_PRED")) {
                        String s2 = modelManager$TaskHandler0.getAssetUri();
                        int v1 = Math.max(v, modelManager$TaskHandler0.getVersionId());
                        if(FeatureManager.isEnabled(Feature.SuggestedEvents) && this.isLocaleEnglish()) {
                            arrayList0.add(modelManager$TaskHandler0.setOnPostExecute(new A5.a(1)));
                        }
                        s = s2;
                        v = v1;
                    }
                    if(q.b(s1, "MTML_INTEGRITY_DETECT")) {
                        s = modelManager$TaskHandler0.getAssetUri();
                        v = Math.max(v, modelManager$TaskHandler0.getVersionId());
                        if(FeatureManager.isEnabled(Feature.IntelligentIntegrity)) {
                            arrayList0.add(modelManager$TaskHandler0.setOnPostExecute(new A5.a(2)));
                        }
                    }
                }
                if(s != null && v > 0 && !arrayList0.isEmpty()) {
                    TaskHandler modelManager$TaskHandler1 = new TaskHandler("MTML", s, null, v, null);
                    TaskHandler.Companion.execute(modelManager$TaskHandler1, arrayList0);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void enableMTML$lambda$1() {
        Class class0 = ModelManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            SuggestedEventsManager.enable();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void enableMTML$lambda$2() {
        Class class0 = ModelManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            IntegrityManager.enable();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final JSONObject fetchModels() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Bundle bundle0 = new Bundle();
            bundle0.putString("fields", TextUtils.join(",", new String[]{"use_case", "version_id", "asset_uri", "rules_uri", "thresholds"}));
            GraphRequest graphRequest0 = GraphRequest.Companion.newGraphPathRequest(null, "app/model_asset", null);
            graphRequest0.setParameters(bundle0);
            JSONObject jSONObject0 = graphRequest0.executeAndWait().getJSONObject();
            return jSONObject0 == null ? null : this.parseRawJsonObject(jSONObject0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Nullable
    public static final File getRuleFile(@NotNull Task modelManager$Task0) {
        Class class0 = ModelManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(modelManager$Task0, "task");
            String s = modelManager$Task0.toUseCase();
            TaskHandler modelManager$TaskHandler0 = (TaskHandler)ModelManager.taskHandlers.get(s);
            return modelManager$TaskHandler0 == null ? null : modelManager$TaskHandler0.getRuleFile();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final boolean isLocaleEnglish() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Locale locale0 = Utility.getResourceLocale();
                if(locale0 == null) {
                    return true;
                }
                String s = locale0.getLanguage();
                q.f(s, "locale.language");
                if(o.v0(s, "en", false)) {
                    return true;
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return false;
            }
        }
        return false;
    }

    private final boolean isValidTimestamp(long v) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        return v == 0L ? false : System.currentTimeMillis() - v < 259200000L;
    }

    private final float[] parseJsonArray(JSONArray jSONArray0) {
        float[] arr_f;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        if(jSONArray0 == null) {
            return null;
        }
        try {
            arr_f = new float[jSONArray0.length()];
            int v = jSONArray0.length();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
        for(int v1 = 0; v1 < v; ++v1) {
            try {
                String s = jSONArray0.getString(v1);
                q.f(s, "jsonArray.getString(i)");
                arr_f[v1] = Float.parseFloat(s);
                continue;
            }
            catch(JSONException unused_ex) {
                continue;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
        return arr_f;
    }

    private final JSONObject parseRawJsonObject(JSONObject jSONObject0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject1 = new JSONObject();
            try {
                JSONArray jSONArray0 = jSONObject0.getJSONArray("data");
                int v = jSONArray0.length();
                for(int v1 = 0; v1 < v; ++v1) {
                    JSONObject jSONObject2 = jSONArray0.getJSONObject(v1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version_id", jSONObject2.getString("version_id"));
                    jSONObject3.put("use_case", jSONObject2.getString("use_case"));
                    jSONObject3.put("thresholds", jSONObject2.getJSONArray("thresholds"));
                    jSONObject3.put("asset_uri", jSONObject2.getString("asset_uri"));
                    if(jSONObject2.has("rules_uri")) {
                        jSONObject3.put("rules_uri", jSONObject2.getString("rules_uri"));
                    }
                    jSONObject1.put(jSONObject2.getString("use_case"), jSONObject3);
                }
                return jSONObject1;
            }
            catch(JSONException unused_ex) {
                return new JSONObject();
            }
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    @Nullable
    public static final String[] predict(@NotNull Task modelManager$Task0, @NotNull float[][] arr2_f, @NotNull String[] arr_s) {
        Class class0 = ModelManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(modelManager$Task0, "task");
            q.g(arr2_f, "denses");
            q.g(arr_s, "texts");
            String s = modelManager$Task0.toUseCase();
            TaskHandler modelManager$TaskHandler0 = (TaskHandler)ModelManager.taskHandlers.get(s);
            if(modelManager$TaskHandler0 != null) {
                Model model0 = modelManager$TaskHandler0.getModel();
                if(model0 != null) {
                    float[] arr_f = modelManager$TaskHandler0.getThresholds();
                    int v = arr2_f[0].length;
                    MTensor mTensor0 = new MTensor(new int[]{arr_s.length, v});
                    for(int v1 = 0; v1 < arr_s.length; ++v1) {
                        System.arraycopy(arr2_f[v1], 0, mTensor0.getData(), v1 * v, v);
                    }
                    MTensor mTensor1 = model0.predictOnMTML(mTensor0, arr_s, modelManager$Task0.toKey());
                    if(mTensor1 != null && arr_f != null && mTensor1.getData().length != 0 && arr_f.length != 0) {
                        switch(com.facebook.appevents.ml.ModelManager.WhenMappings.$EnumSwitchMapping$0[modelManager$Task0.ordinal()]) {
                            case 1: {
                                return ModelManager.INSTANCE.processSuggestedEventResult(mTensor1, arr_f);
                            }
                            case 2: {
                                return ModelManager.INSTANCE.processIntegrityDetectionResult(mTensor1, arr_f);
                            }
                            default: {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        }
                    }
                }
            }
            return null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final String[] processIntegrityDetectionResult(MTensor mTensor0, float[] arr_f) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int v = mTensor0.getShape(0);
            int v1 = mTensor0.getShape(1);
            float[] arr_f1 = mTensor0.getData();
            if(v1 != arr_f.length) {
                return null;
            }
            Ce.g g0 = P4.a.K(0, v);
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, g0));
            Iterator iterator0 = g0.iterator();
            while(iterator0.hasNext()) {
                int v2 = ((f)iterator0).nextInt();
                String s = "none";
                int v3 = 0;
                for(int v4 = 0; v3 < arr_f.length; ++v4) {
                    if(arr_f1[v2 * v1 + v4] >= arr_f[v3]) {
                        s = ModelManager.MTML_INTEGRITY_DETECT_PREDICTION.get(v4);
                    }
                    ++v3;
                }
                arrayList0.add(s);
            }
            return (String[])arrayList0.toArray(new String[0]);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final String[] processSuggestedEventResult(MTensor mTensor0, float[] arr_f) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int v = mTensor0.getShape(0);
            int v1 = mTensor0.getShape(1);
            float[] arr_f1 = mTensor0.getData();
            if(v1 != arr_f.length) {
                return null;
            }
            Ce.g g0 = P4.a.K(0, v);
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, g0));
            Iterator iterator0 = g0.iterator();
            while(iterator0.hasNext()) {
                int v2 = ((f)iterator0).nextInt();
                String s = "other";
                int v3 = 0;
                for(int v4 = 0; v3 < arr_f.length; ++v4) {
                    if(arr_f1[v2 * v1 + v4] >= arr_f[v3]) {
                        s = ModelManager.MTML_SUGGESTED_EVENTS_PREDICTION.get(v4);
                    }
                    ++v3;
                }
                arrayList0.add(s);
            }
            return (String[])arrayList0.toArray(new String[0]);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }
}

