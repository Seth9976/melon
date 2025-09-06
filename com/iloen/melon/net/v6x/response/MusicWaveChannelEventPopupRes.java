package com.iloen.melon.net.v6x.response;

import S7.b;
import ba.s;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import je.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveChannelEventPopupRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000FB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\t\u001A\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "", "<init>", "()V", "Lcom/iloen/melon/net/v6x/response/EventPopupUiModel;", "toUiModel", "()Lcom/iloen/melon/net/v6x/response/EventPopupUiModel;", "Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO;", "eventPopupInfo", "Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO;", "getEventPopupInfo", "()Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO;", "setEventPopupInfo", "(Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO;)V", "EVENTPOPUPINFO", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR&\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR \u0010\u001C\u001A\u0004\u0018\u00010\u001D8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO;", "", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "description", "getDescription", "setDescription", "precautions", "", "getPrecautions", "()Ljava/util/List;", "setPrecautions", "(Ljava/util/List;)V", "dispStartDate", "getDispStartDate", "setDispStartDate", "dispEndDate", "getDispEndDate", "setDispEndDate", "participationInfo", "Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO;", "getParticipationInfo", "()Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO;", "setParticipationInfo", "(Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO;)V", "PARTICIPATIONINFO", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class EVENTPOPUPINFO {
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO;", "", "<init>", "()V", "period", "", "getPeriod", "()Ljava/lang/String;", "setPeriod", "(Ljava/lang/String;)V", "winnerAnnouncementDate", "getWinnerAnnouncementDate", "setWinnerAnnouncementDate", "eligibleParticipants", "getEligibleParticipants", "setEligibleParticipants", "prizes", "getPrizes", "setPrizes", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class PARTICIPATIONINFO {
                public static final int $stable = 8;
                @b("ELIGIBLEPARTICIPANTS")
                @Nullable
                private String eligibleParticipants;
                @b("PERIOD")
                @Nullable
                private String period;
                @b("PRIZES")
                @Nullable
                private String prizes;
                @b("WINNERANNOUNCEMENTDATE")
                @Nullable
                private String winnerAnnouncementDate;

                @Nullable
                public final String getEligibleParticipants() {
                    return this.eligibleParticipants;
                }

                @Nullable
                public final String getPeriod() {
                    return this.period;
                }

                @Nullable
                public final String getPrizes() {
                    return this.prizes;
                }

                @Nullable
                public final String getWinnerAnnouncementDate() {
                    return this.winnerAnnouncementDate;
                }

                public final void setEligibleParticipants(@Nullable String s) {
                    this.eligibleParticipants = s;
                }

                public final void setPeriod(@Nullable String s) {
                    this.period = s;
                }

                public final void setPrizes(@Nullable String s) {
                    this.prizes = s;
                }

                public final void setWinnerAnnouncementDate(@Nullable String s) {
                    this.winnerAnnouncementDate = s;
                }
            }

            public static final int $stable = 8;
            @b("DESCRIPTION")
            @Nullable
            private String description;
            @b("DISPENDDATE")
            @Nullable
            private String dispEndDate;
            @b("DISPSTARTDATE")
            @Nullable
            private String dispStartDate;
            @b("EVENTID")
            @Nullable
            private String eventId;
            @b("PARTICIPATIONINFO")
            @Nullable
            private PARTICIPATIONINFO participationInfo;
            @b("PRECAUTIONS")
            @Nullable
            private List precautions;
            @b("TITLE")
            @Nullable
            private String title;

            @Nullable
            public final String getDescription() {
                return this.description;
            }

            @Nullable
            public final String getDispEndDate() {
                return this.dispEndDate;
            }

            @Nullable
            public final String getDispStartDate() {
                return this.dispStartDate;
            }

            @Nullable
            public final String getEventId() {
                return this.eventId;
            }

            @Nullable
            public final PARTICIPATIONINFO getParticipationInfo() {
                return this.participationInfo;
            }

            @Nullable
            public final List getPrecautions() {
                return this.precautions;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            public final void setDescription(@Nullable String s) {
                this.description = s;
            }

            public final void setDispEndDate(@Nullable String s) {
                this.dispEndDate = s;
            }

            public final void setDispStartDate(@Nullable String s) {
                this.dispStartDate = s;
            }

            public final void setEventId(@Nullable String s) {
                this.eventId = s;
            }

            public final void setParticipationInfo(@Nullable PARTICIPATIONINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO0) {
                this.participationInfo = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO0;
            }

            public final void setPrecautions(@Nullable List list0) {
                this.precautions = list0;
            }

            public final void setTitle(@Nullable String s) {
                this.title = s;
            }
        }

        public static final int $stable = 8;
        @b("EVENTPOPUPINFO")
        @Nullable
        private EVENTPOPUPINFO eventPopupInfo;

        @Nullable
        public final EVENTPOPUPINFO getEventPopupInfo() {
            return this.eventPopupInfo;
        }

        public final void setEventPopupInfo(@Nullable EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO0) {
            this.eventPopupInfo = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO0;
        }

        public s toUiModel() {
            return this.toUiModel();
        }

        @NotNull
        public EventPopupUiModel toUiModel() {
            String s5;
            String s4;
            String s3;
            List list0;
            String s2;
            String s1;
            String s;
            EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO0 = this.eventPopupInfo;
            if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO0 == null) {
                s = "";
            }
            else {
                s = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO0.getEventId();
                if(s == null) {
                    s = "";
                }
            }
            EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO1 = this.eventPopupInfo;
            if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO1 == null) {
                s1 = "";
            }
            else {
                s1 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO1.getTitle();
                if(s1 == null) {
                    s1 = "";
                }
            }
            EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO2 = this.eventPopupInfo;
            if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO2 == null) {
                s2 = "";
            }
            else {
                s2 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO2.getDescription();
                if(s2 == null) {
                    s2 = "";
                }
            }
            EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO3 = this.eventPopupInfo;
            if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO3 == null) {
                list0 = w.a;
            }
            else {
                list0 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO3.getPrecautions();
                if(list0 == null) {
                    list0 = w.a;
                }
            }
            EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO4 = this.eventPopupInfo;
            if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO4 == null) {
                s3 = "";
            }
            else {
                PARTICIPATIONINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO0 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO4.getParticipationInfo();
                if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO0 == null) {
                    s3 = "";
                }
                else {
                    s3 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO0.getPeriod();
                    if(s3 == null) {
                        s3 = "";
                    }
                }
            }
            EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO5 = this.eventPopupInfo;
            if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO5 == null) {
                s4 = "";
            }
            else {
                PARTICIPATIONINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO1 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO5.getParticipationInfo();
                if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO1 == null) {
                    s4 = "";
                }
                else {
                    s4 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO1.getWinnerAnnouncementDate();
                    if(s4 == null) {
                        s4 = "";
                    }
                }
            }
            EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO6 = this.eventPopupInfo;
            if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO6 == null) {
                s5 = "";
            }
            else {
                PARTICIPATIONINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO2 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO6.getParticipationInfo();
                if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO2 == null) {
                    s5 = "";
                }
                else {
                    s5 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO2.getEligibleParticipants();
                    if(s5 == null) {
                        s5 = "";
                    }
                }
            }
            EVENTPOPUPINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO7 = this.eventPopupInfo;
            if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO7 != null) {
                PARTICIPATIONINFO musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO3 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO7.getParticipationInfo();
                if(musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO3 != null) {
                    String s6 = musicWaveChannelEventPopupRes$RESPONSE$EVENTPOPUPINFO$PARTICIPATIONINFO3.getPrizes();
                    return s6 == null ? new EventPopupUiModel(s, s1, s2, list0, s3, s4, s5, "") : new EventPopupUiModel(s, s1, s2, list0, s3, s4, s5, s6);
                }
            }
            return new EventPopupUiModel(s, s1, s2, list0, s3, s4, s5, "");
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private RESPONSE response;

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE musicWaveChannelEventPopupRes$RESPONSE0) {
        this.response = musicWaveChannelEventPopupRes$RESPONSE0;
    }
}

