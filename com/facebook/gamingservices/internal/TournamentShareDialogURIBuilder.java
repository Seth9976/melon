package com.facebook.gamingservices.internal;

import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.gamingservices.TournamentConfig;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0004H\u0000¢\u0006\u0002\b\u000FJ%\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0004H\u0000¢\u0006\u0002\b\u0012J%\u0010\u0013\u001A\u00020\u00142\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0004H\u0000¢\u0006\u0002\b\u0015J%\u0010\u0016\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0004H\u0000¢\u0006\u0002\b\u0017R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/gamingservices/internal/TournamentShareDialogURIBuilder;", "", "()V", "authority", "", "me", "scheme", "tournament", "bundleForCreating", "Landroid/os/Bundle;", "config", "Lcom/facebook/gamingservices/TournamentConfig;", "score", "", "appID", "bundleForCreating$facebook_gamingservices_release", "bundleForUpdating", "tournamentID", "bundleForUpdating$facebook_gamingservices_release", "uriForCreating", "Landroid/net/Uri;", "uriForCreating$facebook_gamingservices_release", "uriForUpdating", "uriForUpdating$facebook_gamingservices_release", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TournamentShareDialogURIBuilder {
    @NotNull
    public static final TournamentShareDialogURIBuilder INSTANCE = null;
    @NotNull
    public static final String authority = "fb.gg";
    @NotNull
    public static final String me = "me";
    @NotNull
    public static final String scheme = "https";
    @NotNull
    public static final String tournament = "instant_tournament";

    static {
        TournamentShareDialogURIBuilder.INSTANCE = new TournamentShareDialogURIBuilder();
    }

    @NotNull
    public final Bundle bundleForCreating$facebook_gamingservices_release(@NotNull TournamentConfig tournamentConfig0, @NotNull Number number0, @NotNull String s) {
        q.g(tournamentConfig0, "config");
        q.g(number0, "score");
        q.g(s, "appID");
        Bundle bundle0 = new Bundle();
        bundle0.putString("deeplink", "INSTANT_TOURNAMENT");
        bundle0.putString("app_id", s);
        bundle0.putString("score", number0.toString());
        TournamentSortOrder tournamentSortOrder0 = tournamentConfig0.getSortOrder();
        if(tournamentSortOrder0 != null) {
            bundle0.putString("sort_order", tournamentSortOrder0.toString());
        }
        TournamentScoreType tournamentScoreType0 = tournamentConfig0.getScoreType();
        if(tournamentScoreType0 != null) {
            bundle0.putString("score_format", tournamentScoreType0.toString());
        }
        String s1 = tournamentConfig0.getTitle();
        if(s1 != null) {
            bundle0.putString("tournament_title", s1.toString());
        }
        String s2 = tournamentConfig0.getPayload();
        if(s2 != null) {
            bundle0.putString("tournament_payload", s2.toString());
        }
        Instant instant0 = tournamentConfig0.getEndTime();
        if(instant0 != null) {
            bundle0.putString("end_time", String.valueOf(((int)instant0.getEpochSecond())));
        }
        return bundle0;
    }

    @NotNull
    public final Bundle bundleForUpdating$facebook_gamingservices_release(@NotNull String s, @NotNull Number number0, @NotNull String s1) {
        q.g(s, "tournamentID");
        q.g(number0, "score");
        q.g(s1, "appID");
        Bundle bundle0 = new Bundle();
        bundle0.putString("deeplink", "INSTANT_TOURNAMENT");
        bundle0.putString("app_id", s1);
        bundle0.putString("score", number0.toString());
        bundle0.putString("tournament_id", s);
        return bundle0;
    }

    @NotNull
    public final Uri uriForCreating$facebook_gamingservices_release(@NotNull TournamentConfig tournamentConfig0, @NotNull Number number0, @NotNull String s) {
        q.g(tournamentConfig0, "config");
        q.g(number0, "score");
        q.g(s, "appID");
        Uri.Builder uri$Builder0 = new Uri.Builder().scheme("https").authority("fb.gg").appendPath("me").appendPath("instant_tournament").appendPath(s).appendQueryParameter("score", number0.toString());
        Instant instant0 = tournamentConfig0.getEndTime();
        if(instant0 != null) {
            uri$Builder0.appendQueryParameter("end_time", instant0.toString());
        }
        TournamentSortOrder tournamentSortOrder0 = tournamentConfig0.getSortOrder();
        if(tournamentSortOrder0 != null) {
            uri$Builder0.appendQueryParameter("sort_order", tournamentSortOrder0.toString());
        }
        TournamentScoreType tournamentScoreType0 = tournamentConfig0.getScoreType();
        if(tournamentScoreType0 != null) {
            uri$Builder0.appendQueryParameter("score_format", tournamentScoreType0.toString());
        }
        String s1 = tournamentConfig0.getTitle();
        if(s1 != null) {
            uri$Builder0.appendQueryParameter("tournament_title", s1);
        }
        String s2 = tournamentConfig0.getPayload();
        if(s2 != null) {
            uri$Builder0.appendQueryParameter("tournament_payload", s2);
        }
        Uri uri0 = uri$Builder0.build();
        q.f(uri0, "builder.build()");
        return uri0;
    }

    @NotNull
    public final Uri uriForUpdating$facebook_gamingservices_release(@NotNull String s, @NotNull Number number0, @NotNull String s1) {
        q.g(s, "tournamentID");
        q.g(number0, "score");
        q.g(s1, "appID");
        Uri uri0 = new Uri.Builder().scheme("https").authority("fb.gg").appendPath("me").appendPath("instant_tournament").appendPath(s1).appendQueryParameter("tournament_id", s).appendQueryParameter("score", number0.toString()).build();
        q.f(uri0, "Builder()\n        .schem…tring())\n        .build()");
        return uri0;
    }
}

