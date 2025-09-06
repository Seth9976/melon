package com.iloen.melon.eventbus;

import com.iloen.melon.constants.CType;

public class EventPremiumDownload {
    public static class EventPremiumDownloadItem extends EventPremiumDownload {
        public String cId;
        public CType cType;
        public Exception exception;

        public EventPremiumDownloadItem(EventType eventPremiumDownload$EventType0, String s, CType cType0, Exception exception0) {
            super(eventPremiumDownload$EventType0, 0);
            this.cId = s;
            this.cType = cType0;
            this.exception = exception0;
        }
    }

    public static enum EventType {
        START,
        ERROR,
        FINISH,
        UPDATE_UI;

        private static EventType[] $values() [...] // Inlined contents
    }

    public static EventPremiumDownload Finish;
    public static EventPremiumDownload Start;
    public static EventPremiumDownload UpdateButtonUI;
    public EventType eventType;

    static {
        EventPremiumDownload.Start = new EventPremiumDownload(EventType.START);
        EventPremiumDownload.Finish = new EventPremiumDownload(EventType.FINISH);
        EventPremiumDownload.UpdateButtonUI = new EventPremiumDownload(EventType.UPDATE_UI);
    }

    private EventPremiumDownload(EventType eventPremiumDownload$EventType0) {
        this.eventType = eventPremiumDownload$EventType0;
    }

    public EventPremiumDownload(EventType eventPremiumDownload$EventType0, int v) {
        this(eventPremiumDownload$EventType0);
    }
}

