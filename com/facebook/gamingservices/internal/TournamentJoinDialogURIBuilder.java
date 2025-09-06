package com.facebook.gamingservices.internal;

import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0002J-\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\u000BJ%\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\u000E¨\u0006\u000F"}, d2 = {"Lcom/facebook/gamingservices/internal/TournamentJoinDialogURIBuilder;", "", "()V", "baseUriBuilder", "Landroid/net/Uri$Builder;", "bundle", "Landroid/os/Bundle;", "appID", "", "tournamentID", "payload", "bundle$facebook_gamingservices_release", "uri", "Landroid/net/Uri;", "uri$facebook_gamingservices_release", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TournamentJoinDialogURIBuilder {
    @NotNull
    public static final TournamentJoinDialogURIBuilder INSTANCE;

    static {
        TournamentJoinDialogURIBuilder.INSTANCE = new TournamentJoinDialogURIBuilder();
    }

    private final Uri.Builder baseUriBuilder() {
        Uri.Builder uri$Builder0 = new Uri.Builder().scheme("https").authority("fb.gg").appendPath("dialog").appendPath("join_tournament");
        q.f(uri$Builder0, "Builder()\n              …ndPath(\"join_tournament\")");
        return uri$Builder0;
    }

    @NotNull
    public final Bundle bundle$facebook_gamingservices_release(@NotNull String s, @Nullable String s1, @Nullable String s2) {
        q.g(s, "appID");
        Bundle bundle0 = new Bundle();
        bundle0.putString("deeplink", "INSTANT_TOURNAMENT");
        bundle0.putString("app_id", s);
        if(s1 != null) {
            bundle0.putString("tournament_id", s1);
        }
        if(s2 != null) {
            bundle0.putString("payload", s2);
        }
        return bundle0;
    }

    public static Bundle bundle$facebook_gamingservices_release$default(TournamentJoinDialogURIBuilder tournamentJoinDialogURIBuilder0, String s, String s1, String s2, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            s2 = null;
        }
        return tournamentJoinDialogURIBuilder0.bundle$facebook_gamingservices_release(s, s1, s2);
    }

    @NotNull
    public final Uri uri$facebook_gamingservices_release(@Nullable String s, @Nullable String s1) {
        Uri.Builder uri$Builder0 = this.baseUriBuilder();
        if(s != null) {
            uri$Builder0.appendQueryParameter("tournament_id", s);
        }
        if(s1 != null) {
            uri$Builder0.appendQueryParameter("payload", s1);
        }
        Uri uri0 = uri$Builder0.build();
        q.f(uri0, "builder.build()");
        return uri0;
    }

    public static Uri uri$facebook_gamingservices_release$default(TournamentJoinDialogURIBuilder tournamentJoinDialogURIBuilder0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        return tournamentJoinDialogURIBuilder0.uri$facebook_gamingservices_release(s, s1);
    }
}

