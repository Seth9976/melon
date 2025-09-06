package com.facebook.appevents.cloudbridge;

import Tf.v;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import e.k;
import e2.a;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0004@ABCB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0001H\u0001\u00A2\u0006\u0004\b\u0007\u0010\bJC\u0010\u0010\u001A.\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u000Bj\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u0001`\r2\u0006\u0010\n\u001A\u00020\u0004H\u0001\u00A2\u0006\u0004\b\u000E\u0010\u000FJ3\u0010\u0015\u001A\u00020\u00142\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0005\u001A\u00020\u00132\u0006\u0010\u0006\u001A\u00020\u0001H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0018\u001A\u00020\u00142\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0005\u001A\u00020\u00132\u0006\u0010\u0006\u001A\u00020\u0001H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJA\u0010\u001F\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u001E2\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0002\u00A2\u0006\u0004\b\u001F\u0010 JQ\u0010\"\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u001E2\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0018\u0010!\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f0\u001EH\u0002\u00A2\u0006\u0004\b\"\u0010#J\u008F\u0001\u0010\'\u001A\u00020&2\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112.\u0010!\u001A*\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f0\u000Bj\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f`\r2\u0012\u0010%\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011H\u0002\u00A2\u0006\u0004\b\'\u0010(JG\u0010+\u001A\u00020\u00142\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0005\u001A\u00020\u00132\u0006\u0010\u0006\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b)\u0010*JW\u0010.\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010%\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\fH\u0000\u00A2\u0006\u0004\b,\u0010-J\u008B\u0001\u00102\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u001E2\u0006\u0010/\u001A\u00020&2\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010%\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00112\u0018\u0010!\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f0\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0000\u00A2\u0006\u0004\b0\u00101J7\u00105\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\f\u0018\u00010\u001E2\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\fH\u0000\u00A2\u0006\u0004\b3\u00104R\u0014\u00106\u001A\u00020\u00048\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b6\u00107R \u00109\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u0002080\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u0010:R \u0010=\u001A\u000E\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0\f8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010:R \u0010?\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020>0\f8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b?\u0010:\u00A8\u0006D"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer;", "", "<init>", "()V", "", "field", "value", "transformValue$facebook_core_release", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "transformValue", "appEvents", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "transformEvents$facebook_core_release", "(Ljava/lang/String;)Ljava/util/ArrayList;", "transformEvents", "", "appData", "Lcom/facebook/appevents/cloudbridge/AppEventUserAndAppDataField;", "Lie/H;", "transformAndUpdateAppData", "(Ljava/util/Map;Lcom/facebook/appevents/cloudbridge/AppEventUserAndAppDataField;Ljava/lang/Object;)V", "userData", "transformAndUpdateUserData", "input", "transformEventName", "(Ljava/lang/String;)Ljava/lang/String;", "commonFields", "eventTime", "", "combineAllTransformedDataForMobileAppInstall", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/List;", "customEvents", "combineAllTransformedDataForCustom", "(Ljava/util/Map;Ljava/util/List;)Ljava/util/List;", "parameters", "restOfData", "Lcom/facebook/appevents/cloudbridge/AppEventType;", "splitAppEventParameters", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/ArrayList;Ljava/util/Map;)Lcom/facebook/appevents/cloudbridge/AppEventType;", "transformAndUpdateAppAndUserData$facebook_core_release", "(Ljava/util/Map;Ljava/util/Map;Lcom/facebook/appevents/cloudbridge/AppEventUserAndAppDataField;Ljava/lang/Object;)V", "transformAndUpdateAppAndUserData", "combineCommonFields$facebook_core_release", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "combineCommonFields", "eventType", "combineAllTransformedData$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventType;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "combineAllTransformedData", "conversionsAPICompatibleEvent$facebook_core_release", "(Ljava/util/Map;)Ljava/util/List;", "conversionsAPICompatibleEvent", "TAG", "Ljava/lang/String;", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionFieldMapping;", "topLevelTransformations", "Ljava/util/Map;", "Lcom/facebook/appevents/cloudbridge/CustomEventField;", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionCustomEventFieldMapping;", "customEventTransformations", "Lcom/facebook/appevents/cloudbridge/ConversionsAPIEventName;", "standardEventTransformations", "DataProcessingParameterName", "SectionCustomEventFieldMapping", "SectionFieldMapping", "ValueTransformationType", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventsConversionsAPITransformer {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000B"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "OPTIONS", "COUNTRY", "STATE", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum DataProcessingParameterName {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0086\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName$Companion;", "", "()V", "invoke", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$DataProcessingParameterName;", "rawValue", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @Nullable
            public final DataProcessingParameterName invoke(@NotNull String s) {
                q.g(s, "rawValue");
                DataProcessingParameterName[] arr_appEventsConversionsAPITransformer$DataProcessingParameterName = DataProcessingParameterName.values();
                for(int v = 0; v < arr_appEventsConversionsAPITransformer$DataProcessingParameterName.length; ++v) {
                    DataProcessingParameterName appEventsConversionsAPITransformer$DataProcessingParameterName0 = arr_appEventsConversionsAPITransformer$DataProcessingParameterName[v];
                    if(q.b(appEventsConversionsAPITransformer$DataProcessingParameterName0.getRawValue(), s)) {
                        return appEventsConversionsAPITransformer$DataProcessingParameterName0;
                    }
                }
                return null;
            }
        }

        OPTIONS("data_processing_options"),
        COUNTRY("data_processing_options_country"),
        STATE("data_processing_options_state");

        @NotNull
        public static final Companion Companion;
        @NotNull
        private final String rawValue;

        private static final DataProcessingParameterName[] $values() [...] // Inlined contents

        static {
            DataProcessingParameterName.Companion = new Companion(null);
        }

        private DataProcessingParameterName(String s1) {
            this.rawValue = s1;
        }

        @NotNull
        public final String getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000B\u0010\u000F\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\u001F\u0010\u0011\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionCustomEventFieldMapping;", "", "section", "Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "field", "Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;)V", "getField", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;", "setField", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPICustomEventField;)V", "getSection", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "setSection", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class SectionCustomEventFieldMapping {
        @NotNull
        private ConversionsAPICustomEventField field;
        @Nullable
        private ConversionsAPISection section;

        public SectionCustomEventFieldMapping(@Nullable ConversionsAPISection conversionsAPISection0, @NotNull ConversionsAPICustomEventField conversionsAPICustomEventField0) {
            q.g(conversionsAPICustomEventField0, "field");
            super();
            this.section = conversionsAPISection0;
            this.field = conversionsAPICustomEventField0;
        }

        @Nullable
        public final ConversionsAPISection component1() {
            return this.section;
        }

        @NotNull
        public final ConversionsAPICustomEventField component2() {
            return this.field;
        }

        @NotNull
        public final SectionCustomEventFieldMapping copy(@Nullable ConversionsAPISection conversionsAPISection0, @NotNull ConversionsAPICustomEventField conversionsAPICustomEventField0) {
            q.g(conversionsAPICustomEventField0, "field");
            return new SectionCustomEventFieldMapping(conversionsAPISection0, conversionsAPICustomEventField0);
        }

        public static SectionCustomEventFieldMapping copy$default(SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0, ConversionsAPISection conversionsAPISection0, ConversionsAPICustomEventField conversionsAPICustomEventField0, int v, Object object0) {
            if((v & 1) != 0) {
                conversionsAPISection0 = appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0.section;
            }
            if((v & 2) != 0) {
                conversionsAPICustomEventField0 = appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0.field;
            }
            return appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0.copy(conversionsAPISection0, conversionsAPICustomEventField0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SectionCustomEventFieldMapping)) {
                return false;
            }
            return this.section == ((SectionCustomEventFieldMapping)object0).section ? this.field == ((SectionCustomEventFieldMapping)object0).field : false;
        }

        @NotNull
        public final ConversionsAPICustomEventField getField() {
            return this.field;
        }

        @Nullable
        public final ConversionsAPISection getSection() {
            return this.section;
        }

        @Override
        public int hashCode() {
            return this.section == null ? this.field.hashCode() : this.field.hashCode() + this.section.hashCode() * 0x1F;
        }

        public final void setField(@NotNull ConversionsAPICustomEventField conversionsAPICustomEventField0) {
            q.g(conversionsAPICustomEventField0, "<set-?>");
            this.field = conversionsAPICustomEventField0;
        }

        public final void setSection(@Nullable ConversionsAPISection conversionsAPISection0) {
            this.section = conversionsAPISection0;
        }

        @Override
        @NotNull
        public String toString() {
            return "SectionCustomEventFieldMapping(section=" + this.section + ", field=" + this.field + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0010\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$SectionFieldMapping;", "", "section", "Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "field", "Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;)V", "getField", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;", "setField", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPIUserAndAppDataField;)V", "getSection", "()Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;", "setSection", "(Lcom/facebook/appevents/cloudbridge/ConversionsAPISection;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class SectionFieldMapping {
        @Nullable
        private ConversionsAPIUserAndAppDataField field;
        @NotNull
        private ConversionsAPISection section;

        public SectionFieldMapping(@NotNull ConversionsAPISection conversionsAPISection0, @Nullable ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField0) {
            q.g(conversionsAPISection0, "section");
            super();
            this.section = conversionsAPISection0;
            this.field = conversionsAPIUserAndAppDataField0;
        }

        @NotNull
        public final ConversionsAPISection component1() {
            return this.section;
        }

        @Nullable
        public final ConversionsAPIUserAndAppDataField component2() {
            return this.field;
        }

        @NotNull
        public final SectionFieldMapping copy(@NotNull ConversionsAPISection conversionsAPISection0, @Nullable ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField0) {
            q.g(conversionsAPISection0, "section");
            return new SectionFieldMapping(conversionsAPISection0, conversionsAPIUserAndAppDataField0);
        }

        public static SectionFieldMapping copy$default(SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping0, ConversionsAPISection conversionsAPISection0, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField0, int v, Object object0) {
            if((v & 1) != 0) {
                conversionsAPISection0 = appEventsConversionsAPITransformer$SectionFieldMapping0.section;
            }
            if((v & 2) != 0) {
                conversionsAPIUserAndAppDataField0 = appEventsConversionsAPITransformer$SectionFieldMapping0.field;
            }
            return appEventsConversionsAPITransformer$SectionFieldMapping0.copy(conversionsAPISection0, conversionsAPIUserAndAppDataField0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SectionFieldMapping)) {
                return false;
            }
            return this.section == ((SectionFieldMapping)object0).section ? this.field == ((SectionFieldMapping)object0).field : false;
        }

        @Nullable
        public final ConversionsAPIUserAndAppDataField getField() {
            return this.field;
        }

        @NotNull
        public final ConversionsAPISection getSection() {
            return this.section;
        }

        @Override
        public int hashCode() {
            int v = this.section.hashCode();
            return this.field == null ? v * 0x1F : v * 0x1F + this.field.hashCode();
        }

        public final void setField(@Nullable ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField0) {
            this.field = conversionsAPIUserAndAppDataField0;
        }

        public final void setSection(@NotNull ConversionsAPISection conversionsAPISection0) {
            q.g(conversionsAPISection0, "<set-?>");
            this.section = conversionsAPISection0;
        }

        @Override
        @NotNull
        public String toString() {
            return "SectionFieldMapping(section=" + this.section + ", field=" + this.field + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType;", "", "(Ljava/lang/String;I)V", "ARRAY", "BOOL", "INT", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum ValueTransformationType {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0086\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType$Companion;", "", "()V", "invoke", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformer$ValueTransformationType;", "rawValue", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.ValueTransformationType.Companion {
            private com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.ValueTransformationType.Companion() {
            }

            public com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.ValueTransformationType.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @Nullable
            public final ValueTransformationType invoke(@NotNull String s) {
                q.g(s, "rawValue");
                if(s.equals("extInfo")) {
                    return ValueTransformationType.ARRAY;
                }
                if(s.equals("url_schemes")) {
                    return ValueTransformationType.ARRAY;
                }
                if(s.equals("fb_content_id")) {
                    return ValueTransformationType.ARRAY;
                }
                if(s.equals("fb_content")) {
                    return ValueTransformationType.ARRAY;
                }
                if(s.equals("data_processing_options")) {
                    return ValueTransformationType.ARRAY;
                }
                if(s.equals("advertiser_tracking_enabled")) {
                    return ValueTransformationType.BOOL;
                }
                if(s.equals("application_tracking_enabled")) {
                    return ValueTransformationType.BOOL;
                }
                return s.equals("_logTime") ? ValueTransformationType.INT : null;
            }
        }

        ARRAY,
        BOOL,
        INT;

        @NotNull
        public static final com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.ValueTransformationType.Companion Companion;

        private static final ValueTransformationType[] $values() [...] // Inlined contents

        static {
            ValueTransformationType.Companion = new com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformer.ValueTransformationType.Companion(null);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        public static final int[] $EnumSwitchMapping$2;

        static {
            int[] arr_v = new int[ValueTransformationType.values().length];
            try {
                arr_v[ValueTransformationType.ARRAY.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ValueTransformationType.BOOL.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ValueTransformationType.INT.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[ConversionsAPISection.values().length];
            try {
                arr_v1[ConversionsAPISection.APP_DATA.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[ConversionsAPISection.USER_DATA.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
            int[] arr_v2 = new int[AppEventType.values().length];
            try {
                arr_v2[AppEventType.MOBILE_APP_INSTALL.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v2[AppEventType.CUSTOM.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$2 = arr_v2;
        }
    }

    @NotNull
    public static final AppEventsConversionsAPITransformer INSTANCE = null;
    @NotNull
    public static final String TAG = "AppEventsConversionsAPITransformer";
    @NotNull
    public static final Map customEventTransformations;
    @NotNull
    public static final Map standardEventTransformations;
    @NotNull
    private static final Map topLevelTransformations;

    static {
        AppEventsConversionsAPITransformer.INSTANCE = new AppEventsConversionsAPITransformer();
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping0 = new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.ANON_ID);
        m m0 = new m(AppEventUserAndAppDataField.ANON_ID, appEventsConversionsAPITransformer$SectionFieldMapping0);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping1 = new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.FB_LOGIN_ID);
        m m1 = new m(AppEventUserAndAppDataField.APP_USER_ID, appEventsConversionsAPITransformer$SectionFieldMapping1);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping2 = new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.MAD_ID);
        m m2 = new m(AppEventUserAndAppDataField.ADVERTISER_ID, appEventsConversionsAPITransformer$SectionFieldMapping2);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping3 = new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.PAGE_ID);
        m m3 = new m(AppEventUserAndAppDataField.PAGE_ID, appEventsConversionsAPITransformer$SectionFieldMapping3);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping4 = new SectionFieldMapping(ConversionsAPISection.USER_DATA, ConversionsAPIUserAndAppDataField.PAGE_SCOPED_USER_ID);
        m m4 = new m(AppEventUserAndAppDataField.PAGE_SCOPED_USER_ID, appEventsConversionsAPITransformer$SectionFieldMapping4);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping5 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.ADV_TE);
        m m5 = new m(AppEventUserAndAppDataField.ADV_TE, appEventsConversionsAPITransformer$SectionFieldMapping5);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping6 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.APP_TE);
        m m6 = new m(AppEventUserAndAppDataField.APP_TE, appEventsConversionsAPITransformer$SectionFieldMapping6);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping7 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.CONSIDER_VIEWS);
        m m7 = new m(AppEventUserAndAppDataField.CONSIDER_VIEWS, appEventsConversionsAPITransformer$SectionFieldMapping7);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping8 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.DEVICE_TOKEN);
        m m8 = new m(AppEventUserAndAppDataField.DEVICE_TOKEN, appEventsConversionsAPITransformer$SectionFieldMapping8);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping9 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.EXT_INFO);
        m m9 = new m(AppEventUserAndAppDataField.EXT_INFO, appEventsConversionsAPITransformer$SectionFieldMapping9);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping10 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INCLUDE_DWELL_DATA);
        m m10 = new m(AppEventUserAndAppDataField.INCLUDE_DWELL_DATA, appEventsConversionsAPITransformer$SectionFieldMapping10);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping11 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INCLUDE_VIDEO_DATA);
        m m11 = new m(AppEventUserAndAppDataField.INCLUDE_VIDEO_DATA, appEventsConversionsAPITransformer$SectionFieldMapping11);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping12 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INSTALL_REFERRER);
        m m12 = new m(AppEventUserAndAppDataField.INSTALL_REFERRER, appEventsConversionsAPITransformer$SectionFieldMapping12);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping13 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.INSTALLER_PACKAGE);
        m m13 = new m(AppEventUserAndAppDataField.INSTALLER_PACKAGE, appEventsConversionsAPITransformer$SectionFieldMapping13);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping14 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.RECEIPT_DATA);
        m m14 = new m(AppEventUserAndAppDataField.RECEIPT_DATA, appEventsConversionsAPITransformer$SectionFieldMapping14);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping15 = new SectionFieldMapping(ConversionsAPISection.APP_DATA, ConversionsAPIUserAndAppDataField.URL_SCHEMES);
        m m15 = new m(AppEventUserAndAppDataField.URL_SCHEMES, appEventsConversionsAPITransformer$SectionFieldMapping15);
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping16 = new SectionFieldMapping(ConversionsAPISection.USER_DATA, null);
        AppEventsConversionsAPITransformer.topLevelTransformations = C.S(new m[]{m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, new m(AppEventUserAndAppDataField.USER_DATA, appEventsConversionsAPITransformer$SectionFieldMapping16)});
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0 = new SectionCustomEventFieldMapping(null, ConversionsAPICustomEventField.EVENT_TIME);
        m m16 = new m(CustomEventField.EVENT_TIME, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping1 = new SectionCustomEventFieldMapping(null, ConversionsAPICustomEventField.EVENT_NAME);
        m m17 = new m(CustomEventField.EVENT_NAME, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping1);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping2 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.VALUE_TO_SUM);
        m m18 = new m(CustomEventField.VALUE_TO_SUM, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping2);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping3 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENT_IDS);
        m m19 = new m(CustomEventField.CONTENT_IDS, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping3);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping4 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENTS);
        m m20 = new m(CustomEventField.CONTENTS, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping4);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping5 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CONTENT_TYPE);
        m m21 = new m(CustomEventField.CONTENT_TYPE, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping5);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping6 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.CURRENCY);
        m m22 = new m(CustomEventField.CURRENCY, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping6);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping7 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.DESCRIPTION);
        m m23 = new m(CustomEventField.DESCRIPTION, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping7);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping8 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.LEVEL);
        m m24 = new m(CustomEventField.LEVEL, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping8);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping9 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.MAX_RATING_VALUE);
        m m25 = new m(CustomEventField.MAX_RATING_VALUE, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping9);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping10 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.NUM_ITEMS);
        m m26 = new m(CustomEventField.NUM_ITEMS, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping10);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping11 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.PAYMENT_INFO_AVAILABLE);
        m m27 = new m(CustomEventField.PAYMENT_INFO_AVAILABLE, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping11);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping12 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.REGISTRATION_METHOD);
        m m28 = new m(CustomEventField.REGISTRATION_METHOD, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping12);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping13 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.SEARCH_STRING);
        m m29 = new m(CustomEventField.SEARCH_STRING, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping13);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping14 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.SUCCESS);
        m m30 = new m(CustomEventField.SUCCESS, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping14);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping15 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.ORDER_ID);
        m m31 = new m(CustomEventField.ORDER_ID, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping15);
        SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping16 = new SectionCustomEventFieldMapping(ConversionsAPISection.CUSTOM_DATA, ConversionsAPICustomEventField.AD_TYPE);
        AppEventsConversionsAPITransformer.customEventTransformations = C.S(new m[]{m16, m17, m18, m19, m20, m21, m22, m23, m24, m25, m26, m27, m28, m29, m30, m31, new m(CustomEventField.AD_TYPE, appEventsConversionsAPITransformer$SectionCustomEventFieldMapping16)});
        AppEventsConversionsAPITransformer.standardEventTransformations = C.S(new m[]{new m("fb_mobile_achievement_unlocked", ConversionsAPIEventName.UNLOCKED_ACHIEVEMENT), new m("fb_mobile_activate_app", ConversionsAPIEventName.ACTIVATED_APP), new m("fb_mobile_add_payment_info", ConversionsAPIEventName.ADDED_PAYMENT_INFO), new m("fb_mobile_add_to_cart", ConversionsAPIEventName.ADDED_TO_CART), new m("fb_mobile_add_to_wishlist", ConversionsAPIEventName.ADDED_TO_WISHLIST), new m("fb_mobile_complete_registration", ConversionsAPIEventName.COMPLETED_REGISTRATION), new m("fb_mobile_content_view", ConversionsAPIEventName.VIEWED_CONTENT), new m("fb_mobile_initiated_checkout", ConversionsAPIEventName.INITIATED_CHECKOUT), new m("fb_mobile_level_achieved", ConversionsAPIEventName.ACHIEVED_LEVEL), new m("fb_mobile_purchase", ConversionsAPIEventName.PURCHASED), new m("fb_mobile_rate", ConversionsAPIEventName.RATED), new m("fb_mobile_search", ConversionsAPIEventName.SEARCHED), new m("fb_mobile_spent_credits", ConversionsAPIEventName.SPENT_CREDITS), new m("fb_mobile_tutorial_completion", ConversionsAPIEventName.COMPLETED_TUTORIAL)});
    }

    @Nullable
    public final List combineAllTransformedData$facebook_core_release(@NotNull AppEventType appEventType0, @NotNull Map map0, @NotNull Map map1, @NotNull Map map2, @NotNull List list0, @Nullable Object object0) {
        q.g(appEventType0, "eventType");
        q.g(map0, "userData");
        q.g(map1, "appData");
        q.g(map2, "restOfData");
        q.g(list0, "customEvents");
        Map map3 = this.combineCommonFields$facebook_core_release(map0, map1, map2);
        switch(WhenMappings.$EnumSwitchMapping$2[appEventType0.ordinal()]) {
            case 1: {
                return this.combineAllTransformedDataForMobileAppInstall(map3, object0);
            }
            case 2: {
                return this.combineAllTransformedDataForCustom(map3, list0);
            }
            default: {
                return null;
            }
        }
    }

    private final List combineAllTransformedDataForCustom(Map map0, List list0) {
        if(list0.isEmpty()) {
            return null;
        }
        List list1 = new ArrayList();
        for(Object object0: list0) {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            linkedHashMap0.putAll(map0);
            linkedHashMap0.putAll(((Map)object0));
            ((ArrayList)list1).add(linkedHashMap0);
        }
        return list1;
    }

    private final List combineAllTransformedDataForMobileAppInstall(Map map0, Object object0) {
        if(object0 == null) {
            return null;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        linkedHashMap0.putAll(map0);
        linkedHashMap0.put("event_name", "MobileAppInstall");
        linkedHashMap0.put("event_time", object0);
        return k.z(linkedHashMap0);
    }

    @NotNull
    public final Map combineCommonFields$facebook_core_release(@NotNull Map map0, @NotNull Map map1, @NotNull Map map2) {
        q.g(map0, "userData");
        q.g(map1, "appData");
        q.g(map2, "restOfData");
        Map map3 = new LinkedHashMap();
        map3.put("action_source", "app");
        map3.put("user_data", map0);
        map3.put("app_data", map1);
        map3.putAll(map2);
        return map3;
    }

    @Nullable
    public final List conversionsAPICompatibleEvent$facebook_core_release(@NotNull Map map0) {
        q.g(map0, "parameters");
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        LinkedHashMap linkedHashMap1 = new LinkedHashMap();
        ArrayList arrayList0 = new ArrayList();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        AppEventType appEventType0 = this.splitAppEventParameters(map0, linkedHashMap0, linkedHashMap1, arrayList0, linkedHashMap2);
        return appEventType0 == AppEventType.OTHER ? null : this.combineAllTransformedData$facebook_core_release(appEventType0, linkedHashMap0, linkedHashMap1, linkedHashMap2, arrayList0, map0.get("install_timestamp"));
    }

    private final AppEventType splitAppEventParameters(Map map0, Map map1, Map map2, ArrayList arrayList0, Map map3) {
        Object object0 = map0.get("event");
        q.e(object0, "null cannot be cast to non-null type kotlin.String");
        AppEventType appEventType0 = AppEventType.Companion.invoke(((String)object0));
        if(appEventType0 != AppEventType.OTHER) {
            for(Object object1: map0.entrySet()) {
                String s = (String)((Map.Entry)object1).getKey();
                Object object2 = ((Map.Entry)object1).getValue();
                AppEventUserAndAppDataField appEventUserAndAppDataField0 = AppEventUserAndAppDataField.Companion.invoke(s);
                if(appEventUserAndAppDataField0 == null) {
                    boolean z = q.b(s, "custom_events");
                    if(appEventType0 == AppEventType.CUSTOM && z && object2 instanceof String) {
                        q.e(object2, "null cannot be cast to non-null type kotlin.String");
                        ArrayList arrayList1 = AppEventsConversionsAPITransformer.transformEvents$facebook_core_release(((String)object2));
                        if(arrayList1 == null) {
                            continue;
                        }
                        arrayList0.addAll(arrayList1);
                    }
                    else if(DataProcessingParameterName.Companion.invoke(s) != null) {
                        map3.put(s, object2);
                    }
                }
                else {
                    AppEventsConversionsAPITransformer.INSTANCE.transformAndUpdateAppAndUserData$facebook_core_release(map1, map2, appEventUserAndAppDataField0, object2);
                }
            }
        }
        return appEventType0;
    }

    public final void transformAndUpdateAppAndUserData$facebook_core_release(@NotNull Map map0, @NotNull Map map1, @NotNull AppEventUserAndAppDataField appEventUserAndAppDataField0, @NotNull Object object0) {
        q.g(map0, "userData");
        q.g(map1, "appData");
        q.g(appEventUserAndAppDataField0, "field");
        q.g(object0, "value");
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping0 = (SectionFieldMapping)AppEventsConversionsAPITransformer.topLevelTransformations.get(appEventUserAndAppDataField0);
        if(appEventsConversionsAPITransformer$SectionFieldMapping0 != null) {
            ConversionsAPISection conversionsAPISection0 = appEventsConversionsAPITransformer$SectionFieldMapping0.getSection();
            if(conversionsAPISection0 != null) {
                switch(WhenMappings.$EnumSwitchMapping$1[conversionsAPISection0.ordinal()]) {
                    case 1: {
                        this.transformAndUpdateAppData(map1, appEventUserAndAppDataField0, object0);
                        break;
                    }
                    case 2: {
                        this.transformAndUpdateUserData(map0, appEventUserAndAppDataField0, object0);
                    }
                }
            }
        }
    }

    private final void transformAndUpdateAppData(Map map0, AppEventUserAndAppDataField appEventUserAndAppDataField0, Object object0) {
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping0 = (SectionFieldMapping)AppEventsConversionsAPITransformer.topLevelTransformations.get(appEventUserAndAppDataField0);
        if(appEventsConversionsAPITransformer$SectionFieldMapping0 != null) {
            ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField0 = appEventsConversionsAPITransformer$SectionFieldMapping0.getField();
            if(conversionsAPIUserAndAppDataField0 != null) {
                String s = conversionsAPIUserAndAppDataField0.getRawValue();
                if(s != null) {
                    map0.put(s, object0);
                }
            }
        }
    }

    private final void transformAndUpdateUserData(Map map0, AppEventUserAndAppDataField appEventUserAndAppDataField0, Object object0) {
        if(appEventUserAndAppDataField0 == AppEventUserAndAppDataField.USER_DATA) {
            try {
                q.e(object0, "null cannot be cast to non-null type kotlin.String");
                map0.putAll(Utility.convertJSONObjectToHashMap(new JSONObject(((String)object0))));
            }
            catch(JSONException jSONException0) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", new Object[]{object0, jSONException0});
            }
            return;
        }
        SectionFieldMapping appEventsConversionsAPITransformer$SectionFieldMapping0 = (SectionFieldMapping)AppEventsConversionsAPITransformer.topLevelTransformations.get(appEventUserAndAppDataField0);
        if(appEventsConversionsAPITransformer$SectionFieldMapping0 != null) {
            ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField0 = appEventsConversionsAPITransformer$SectionFieldMapping0.getField();
            if(conversionsAPIUserAndAppDataField0 != null) {
                String s = conversionsAPIUserAndAppDataField0.getRawValue();
                if(s != null) {
                    map0.put(s, object0);
                }
            }
        }
    }

    private final String transformEventName(String s) {
        Map map0 = AppEventsConversionsAPITransformer.standardEventTransformations;
        if(map0.containsKey(s)) {
            ConversionsAPIEventName conversionsAPIEventName0 = (ConversionsAPIEventName)map0.get(s);
            if(conversionsAPIEventName0 != null) {
                String s1 = conversionsAPIEventName0.getRawValue();
                return s1 == null ? "" : s1;
            }
            return "";
        }
        return s;
    }

    @Nullable
    public static final ArrayList transformEvents$facebook_core_release(@NotNull String s) {
        q.g(s, "appEvents");
        ArrayList arrayList0 = new ArrayList();
        try {
            for(Object object0: Utility.convertJSONArrayToList(new JSONArray(s))) {
                arrayList0.add(Utility.convertJSONObjectToHashMap(new JSONObject(((String)object0))));
            }
        }
        catch(JSONException jSONException0) {
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", new Object[]{s, jSONException0});
            return null;
        }
        if(arrayList0.isEmpty()) {
            return null;
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            Map map0 = (Map)object1;
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            LinkedHashMap linkedHashMap1 = new LinkedHashMap();
            for(Object object2: map0.keySet()) {
                String s1 = (String)object2;
                CustomEventField customEventField0 = CustomEventField.Companion.invoke(s1);
                SectionCustomEventFieldMapping appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0 = (SectionCustomEventFieldMapping)AppEventsConversionsAPITransformer.customEventTransformations.get(customEventField0);
                if(customEventField0 != null && appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0 != null) {
                    ConversionsAPISection conversionsAPISection0 = appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0.getSection();
                    if(conversionsAPISection0 == null) {
                        try {
                            String s2 = appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0.getField().getRawValue();
                            if(customEventField0 == CustomEventField.EVENT_NAME && ((String)map0.get(s1)) != null) {
                                Object object5 = map0.get(s1);
                                q.e(object5, "null cannot be cast to non-null type kotlin.String");
                                linkedHashMap1.put(s2, AppEventsConversionsAPITransformer.INSTANCE.transformEventName(((String)object5)));
                                continue;
                            }
                            if(customEventField0 != CustomEventField.EVENT_TIME || ((Integer)map0.get(s1)) == null) {
                                continue;
                            }
                            Object object6 = map0.get(s1);
                            q.e(object6, "null cannot be cast to non-null type kotlin.Any");
                            Object object7 = AppEventsConversionsAPITransformer.transformValue$facebook_core_release(s1, object6);
                            q.e(object7, "null cannot be cast to non-null type kotlin.Any");
                            linkedHashMap1.put(s2, object7);
                            continue;
                        }
                        catch(ClassCastException classCastException0) {
                        }
                        Object[] arr_object = {a.T(classCastException0)};
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents ClassCastException: \n %s ", arr_object);
                    }
                    else {
                        if(conversionsAPISection0 != ConversionsAPISection.CUSTOM_DATA) {
                            continue;
                        }
                        Object object3 = map0.get(s1);
                        q.e(object3, "null cannot be cast to non-null type kotlin.Any");
                        Object object4 = AppEventsConversionsAPITransformer.transformValue$facebook_core_release(s1, object3);
                        q.e(object4, "null cannot be cast to non-null type kotlin.Any");
                        linkedHashMap0.put(appEventsConversionsAPITransformer$SectionCustomEventFieldMapping0.getField().getRawValue(), object4);
                    }
                }
            }
            if(!linkedHashMap0.isEmpty()) {
                linkedHashMap1.put("custom_data", linkedHashMap0);
            }
            arrayList1.add(linkedHashMap1);
        }
        return arrayList1;
    }

    @Nullable
    public static final Object transformValue$facebook_core_release(@NotNull String s, @NotNull Object object0) {
        q.g(s, "field");
        q.g(object0, "value");
        ValueTransformationType appEventsConversionsAPITransformer$ValueTransformationType0 = ValueTransformationType.Companion.invoke(s);
        String s1 = object0 instanceof String ? ((String)object0) : null;
        if(appEventsConversionsAPITransformer$ValueTransformationType0 != null && s1 != null) {
            boolean z = true;
            switch(WhenMappings.$EnumSwitchMapping$0[appEventsConversionsAPITransformer$ValueTransformationType0.ordinal()]) {
                case 1: {
                    try {
                        List list0 = Utility.convertJSONArrayToList(new JSONArray(s1));
                        ArrayList arrayList0 = new ArrayList();
                        Iterator iterator0 = list0.iterator();
                        while(true) {
                            if(!iterator0.hasNext()) {
                                return arrayList0;
                            }
                            Object object1 = iterator0.next();
                            String s2 = (String)object1;
                            try {
                                s2 = Utility.convertJSONObjectToHashMap(new JSONObject(s2));
                            }
                            catch(JSONException unused_ex) {
                                try {
                                    s2 = Utility.convertJSONArrayToList(new JSONArray(s2));
                                }
                                catch(JSONException unused_ex) {
                                }
                            }
                            arrayList0.add(s2);
                        }
                    }
                    catch(JSONException jSONException0) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", new Object[]{object0, jSONException0});
                        return H.a;
                    }
                }
                case 2: {
                    Integer integer0 = v.t0(s1.toString());
                    if(integer0 != null) {
                        if(((int)integer0) == 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                    return null;
                }
                case 3: {
                    return v.t0(object0.toString());
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        return object0;
    }
}

