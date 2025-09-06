package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class g {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public g(String s, String s1, String s2, String s3, String s4, String s5, String s6) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(s), "ApplicationId must be set.");
        this.b = s;
        this.a = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
    }

    public static g a(Context context0) {
        StringResourceValueReader stringResourceValueReader0 = new StringResourceValueReader(context0);
        String s = stringResourceValueReader0.getString("google_app_id");
        return TextUtils.isEmpty(s) ? null : new g(s, stringResourceValueReader0.getString("google_api_key"), stringResourceValueReader0.getString("firebase_database_url"), stringResourceValueReader0.getString("ga_trackingId"), stringResourceValueReader0.getString("gcm_defaultSenderId"), stringResourceValueReader0.getString("google_storage_bucket"), stringResourceValueReader0.getString("project_id"));
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof g ? Objects.equal(this.b, ((g)object0).b) && Objects.equal(this.a, ((g)object0).a) && Objects.equal(this.c, ((g)object0).c) && Objects.equal(this.d, ((g)object0).d) && Objects.equal(this.e, ((g)object0).e) && Objects.equal(this.f, ((g)object0).f) && Objects.equal(this.g, ((g)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.b, this.a, this.c, this.d, this.e, this.f, this.g});
    }

    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.b).add("apiKey", this.a).add("databaseUrl", this.c).add("gcmSenderId", this.e).add("storageBucket", this.f).add("projectId", this.g).toString();
    }
}

