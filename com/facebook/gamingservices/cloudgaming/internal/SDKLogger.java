package com.facebook.gamingservices.cloudgaming.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.appevents.InternalAppEventsLogger;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class SDKLogger {
    private String appID;
    private static SDKLogger instance;
    private final InternalAppEventsLogger logger;
    private ConcurrentHashMap requestIDToFunctionTypeMap;
    private String sessionID;
    private String userID;

    private SDKLogger(Context context0) {
        this.appID = null;
        this.userID = null;
        this.sessionID = null;
        this.logger = new InternalAppEventsLogger(context0);
        this.requestIDToFunctionTypeMap = new ConcurrentHashMap();
    }

    private Bundle getInitParameters() {
        Bundle bundle0 = new Bundle();
        String s = this.appID;
        if(s != null) {
            bundle0.putString("app_id", s);
        }
        String s1 = this.sessionID;
        if(s1 != null) {
            bundle0.putString("session_id", s1);
        }
        return bundle0;
    }

    public static SDKLogger getInstance(Context context0) {
        synchronized(SDKLogger.class) {
            if(SDKLogger.instance == null) {
                SDKLogger.instance = new SDKLogger(context0);
            }
            return SDKLogger.instance;
        }
    }

    private Bundle getParametersWithRequestIDAndFunctionType(String s) {
        Bundle bundle0 = this.getInitParameters();
        if(s != null) {
            String s1 = (String)this.requestIDToFunctionTypeMap.getOrDefault(s, null);
            bundle0.putString("request_id", s);
            if(s1 != null) {
                bundle0.putString("function_type", s1);
                this.requestIDToFunctionTypeMap.remove(s);
            }
        }
        return bundle0;
    }

    private Bundle getParametersWithRequestIDAndFunctionType(String s, String s1) {
        Bundle bundle0 = this.getInitParameters();
        bundle0.putString("request_id", s);
        bundle0.putString("function_type", s1);
        return bundle0;
    }

    public void logGameLoadComplete() {
        Bundle bundle0 = this.getInitParameters();
        this.logger.logEventImplicitly("cloud_games_load_complete", bundle0);
    }

    public static void logInternalError(Context context0, SDKMessageEnum sDKMessageEnum0, Exception exception0) {
        SDKLogger.getInstance(context0).logInternalError(sDKMessageEnum0, exception0);
    }

    public void logInternalError(SDKMessageEnum sDKMessageEnum0, Exception exception0) {
        Bundle bundle0 = this.getInitParameters();
        bundle0.putString("function_type", sDKMessageEnum0.toString());
        bundle0.putString("error_type", exception0.getClass().getName());
        bundle0.putString("error_message", exception0.getMessage());
        this.logger.logEventImplicitly("cloud_games_internal_error", bundle0);
    }

    public void logLoginSuccess() {
        Bundle bundle0 = this.getInitParameters();
        this.logger.logEventImplicitly("cloud_games_login_success", bundle0);
    }

    public void logPreparingRequest(String s, String s1, JSONObject jSONObject0) {
        Bundle bundle0 = this.getParametersWithRequestIDAndFunctionType(s1, s);
        bundle0.putString("payload", jSONObject0.toString());
        this.logger.logEventImplicitly("cloud_games_preparing_request", bundle0);
    }

    public void logSendingErrorResponse(FacebookRequestError facebookRequestError0, String s) {
        Bundle bundle0 = this.getParametersWithRequestIDAndFunctionType(s);
        bundle0.putString("error_code", Integer.toString(facebookRequestError0.getErrorCode()));
        bundle0.putString("error_type", facebookRequestError0.getErrorType());
        bundle0.putString("error_message", facebookRequestError0.getErrorMessage());
        this.logger.logEventImplicitly("cloud_games_sending_error_response", bundle0);
    }

    public void logSendingSuccessResponse(String s) {
        Bundle bundle0 = this.getParametersWithRequestIDAndFunctionType(s);
        this.logger.logEventImplicitly("cloud_games_sending_success_response", bundle0);
    }

    public void logSentRequest(String s, String s1, JSONObject jSONObject0) {
        Bundle bundle0 = this.getParametersWithRequestIDAndFunctionType(s1, s);
        this.requestIDToFunctionTypeMap.put(s1, s);
        bundle0.putString("payload", jSONObject0.toString());
        this.logger.logEventImplicitly("cloud_games_sent_request", bundle0);
    }

    public void setAppID(String s) {
        this.appID = s;
    }

    public void setSessionID(String s) {
        this.sessionID = s;
    }

    public void setUserID(String s) {
        this.userID = s;
    }
}

