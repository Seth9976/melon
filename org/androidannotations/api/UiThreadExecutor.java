package org.androidannotations.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

public final class UiThreadExecutor {
    static final class Token {
        final String id;
        int runnablesCount;

        private Token(String s) {
            this.runnablesCount = 0;
            this.id = s;
        }

        public Token(String s, org.androidannotations.api.UiThreadExecutor.1 uiThreadExecutor$10) {
            this(s);
        }
    }

    private static final Handler HANDLER;
    private static final Map TOKENS;

    static {
        UiThreadExecutor.HANDLER = new Handler(Looper.getMainLooper()) {
            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                Runnable runnable0 = message0.getCallback();
                if(runnable0 != null) {
                    runnable0.run();
                    UiThreadExecutor.decrementToken(((Token)message0.obj));
                    return;
                }
                super.handleMessage(message0);
            }
        };
        UiThreadExecutor.TOKENS = new HashMap();
    }

    public static void cancelAll(String s) {
        Token uiThreadExecutor$Token0;
        synchronized(UiThreadExecutor.TOKENS) {
            uiThreadExecutor$Token0 = (Token)UiThreadExecutor.TOKENS.remove(s);
        }
        if(uiThreadExecutor$Token0 == null) {
            return;
        }
        UiThreadExecutor.HANDLER.removeCallbacksAndMessages(uiThreadExecutor$Token0);
    }

    private static void decrementToken(Token uiThreadExecutor$Token0) {
        Map map0 = UiThreadExecutor.TOKENS;
        synchronized(map0) {
            int v1 = uiThreadExecutor$Token0.runnablesCount - 1;
            uiThreadExecutor$Token0.runnablesCount = v1;
            if(v1 == 0) {
                String s = uiThreadExecutor$Token0.id;
                Token uiThreadExecutor$Token1 = (Token)map0.remove(s);
                if(uiThreadExecutor$Token1 != uiThreadExecutor$Token0) {
                    map0.put(s, uiThreadExecutor$Token1);
                }
            }
        }
    }

    private static Token nextToken(String s) {
        Map map0 = UiThreadExecutor.TOKENS;
        synchronized(map0) {
            Token uiThreadExecutor$Token0 = (Token)map0.get(s);
            if(uiThreadExecutor$Token0 == null) {
                uiThreadExecutor$Token0 = new Token(s, null);
                map0.put(s, uiThreadExecutor$Token0);
            }
            ++uiThreadExecutor$Token0.runnablesCount;
            return uiThreadExecutor$Token0;
        }
    }

    public static void runTask(String s, Runnable runnable0, long v) {
        if("".equals(s)) {
            UiThreadExecutor.HANDLER.postDelayed(runnable0, v);
            return;
        }
        long v1 = SystemClock.uptimeMillis();
        Token uiThreadExecutor$Token0 = UiThreadExecutor.nextToken(s);
        UiThreadExecutor.HANDLER.postAtTime(runnable0, uiThreadExecutor$Token0, v1 + v);
    }
}

