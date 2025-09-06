package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class GameFeaturesLibrary {
    public static void canCreateShortcut(Context context0, JSONObject jSONObject0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, jSONObject0, daemonRequest$Callback0, SDKMessageEnum.CAN_CREATE_SHORTCUT);
    }

    public static void createShortcut(Context context0, JSONObject jSONObject0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, jSONObject0, daemonRequest$Callback0, SDKMessageEnum.CREATE_SHORTCUT);
    }

    public static void createTournamentAsync(Context context0, int v, String s, String s1, String s2, String s3, Integer integer0, JSONObject jSONObject0, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("initialScore", v).put("title", s).put("image", s1).put("sortOrder", s2).put("scoreFormat", s3).put("endTime", integer0).put("data", jSONObject0), daemonRequest$Callback0, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC, jSONException0);
        }
    }

    public static void getPayload(Context context0, JSONObject jSONObject0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, jSONObject0, daemonRequest$Callback0, SDKMessageEnum.GET_PAYLOAD);
    }

    public static void getTournamentAsync(Context context0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, null, daemonRequest$Callback0, SDKMessageEnum.GET_TOURNAMENT_ASYNC);
    }

    public static void getTournamentsAsync(Context context0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, null, daemonRequest$Callback0, SDKMessageEnum.TOURNAMENT_GET_TOURNAMENTS_ASYNC);
    }

    public static void joinTournamentAsync(Context context0, String s, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, new JSONObject().put("tournamentId", s), daemonRequest$Callback0, SDKMessageEnum.TOURNAMENT_JOIN_ASYNC);
    }

    public static void performHapticFeedback(Context context0) {
        DaemonRequest.executeAsync(context0, null, new Callback() {
            @Override  // com.facebook.gamingservices.cloudgaming.DaemonRequest$Callback
            public void onCompleted(GraphResponse graphResponse0) {
            }
        }, SDKMessageEnum.PERFORM_HAPTIC_FEEDBACK_ASYNC);
    }

    public static void postSessionScore(Context context0, int v, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("score", v), daemonRequest$Callback0, SDKMessageEnum.POST_SESSION_SCORE);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.POST_SESSION_SCORE, jSONException0);
        }
    }

    public static void postSessionScoreAsync(Context context0, int v, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("score", v), daemonRequest$Callback0, SDKMessageEnum.POST_SESSION_SCORE_ASYNC);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.POST_SESSION_SCORE_ASYNC, jSONException0);
        }
    }

    public static void postTournamentScoreAsync(Context context0, int v, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, new JSONObject().put("score", v), daemonRequest$Callback0, SDKMessageEnum.TOURNAMENT_POST_SCORE_ASYNC);
    }

    public static void shareTournamentAsync(Context context0, Integer integer0, JSONObject jSONObject0, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("score", integer0).put("data", jSONObject0), daemonRequest$Callback0, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC, jSONException0);
        }
    }
}

