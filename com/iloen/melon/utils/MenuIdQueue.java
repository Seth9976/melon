package com.iloen.melon.utils;

import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MenuIdQueue {
    static final class MenuIdQueueHolder {
        public static final MenuIdQueue a;

        static {
            MenuIdQueue menuIdQueue0 = new MenuIdQueue();  // 初始化器: Ljava/lang/Object;-><init>()V
            menuIdQueue0.a = new ConcurrentLinkedQueue();
            MenuIdQueueHolder.a = menuIdQueue0;
        }
    }

    public ConcurrentLinkedQueue a;
    public volatile boolean b;

    public static MenuIdQueue getInstance() {
        return MenuIdQueueHolder.a;
    }

    public boolean isSkipAction() {
        return this.b;
    }

    public void offer(String s) {
        ConcurrentLinkedQueue concurrentLinkedQueue0 = this.a;
        if(1 <= concurrentLinkedQueue0.size()) {
            this.peek();
        }
        try {
            if(TextUtils.isEmpty(s)) {
                s = "";
            }
            concurrentLinkedQueue0.offer(s);
            return;
        }
        catch(Exception exception0) {
        }
        LogU.w("MenuIdQueue", "offer() " + exception0);
    }

    public String peek() {
        String s = (String)this.a.poll();
        return s == null ? "" : s;
    }

    public void setSkipAction(boolean z) {
        this.b = z;
    }
}

