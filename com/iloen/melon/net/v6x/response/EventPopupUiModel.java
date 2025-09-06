package com.iloen.melon.net.v6x.response;

import A7.d;
import U4.x;
import ba.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\u0006\u0010\u000B\u001A\u00020\u0002\u00A2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u0010\u0010\u0011\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u000FJ\u0016\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u000FJ\u0010\u0010\u0015\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u000FJ\u0010\u0010\u0016\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u000FJ\u0010\u0010\u0017\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u000FJf\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001A\u0010\u000FJ\u0010\u0010\u001C\u001A\u00020\u001BH\u00D6\u0001\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001A\u0010!\u001A\u00020 2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u00D6\u0003\u00A2\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010#\u001A\u0004\b$\u0010\u000FR\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010#\u001A\u0004\b%\u0010\u000FR\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010#\u001A\u0004\b&\u0010\u000FR\u001D\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010\'\u001A\u0004\b(\u0010\u0013R\u0017\u0010\b\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\b\u0010#\u001A\u0004\b)\u0010\u000FR\u0017\u0010\t\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\t\u0010#\u001A\u0004\b*\u0010\u000FR\u0017\u0010\n\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\n\u0010#\u001A\u0004\b+\u0010\u000FR\u0017\u0010\u000B\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010#\u001A\u0004\b,\u0010\u000F\u00A8\u0006-"}, d2 = {"Lcom/iloen/melon/net/v6x/response/EventPopupUiModel;", "Lba/s;", "", "eventId", "title", "description", "", "preCautions", "period", "winnerAnnouncementDate", "eligibleParticipants", "prizes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/util/List;", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/net/v6x/response/EventPopupUiModel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEventId", "getTitle", "getDescription", "Ljava/util/List;", "getPreCautions", "getPeriod", "getWinnerAnnouncementDate", "getEligibleParticipants", "getPrizes", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EventPopupUiModel implements s {
    public static final int $stable = 8;
    @NotNull
    private final String description;
    @NotNull
    private final String eligibleParticipants;
    @NotNull
    private final String eventId;
    @NotNull
    private final String period;
    @NotNull
    private final List preCautions;
    @NotNull
    private final String prizes;
    @NotNull
    private final String title;
    @NotNull
    private final String winnerAnnouncementDate;

    public EventPopupUiModel(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull List list0, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6) {
        q.g(s, "eventId");
        q.g(s1, "title");
        q.g(s2, "description");
        q.g(list0, "preCautions");
        q.g(s3, "period");
        q.g(s4, "winnerAnnouncementDate");
        q.g(s5, "eligibleParticipants");
        q.g(s6, "prizes");
        super();
        this.eventId = s;
        this.title = s1;
        this.description = s2;
        this.preCautions = list0;
        this.period = s3;
        this.winnerAnnouncementDate = s4;
        this.eligibleParticipants = s5;
        this.prizes = s6;
    }

    @NotNull
    public final String component1() {
        return this.eventId;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final List component4() {
        return this.preCautions;
    }

    @NotNull
    public final String component5() {
        return this.period;
    }

    @NotNull
    public final String component6() {
        return this.winnerAnnouncementDate;
    }

    @NotNull
    public final String component7() {
        return this.eligibleParticipants;
    }

    @NotNull
    public final String component8() {
        return this.prizes;
    }

    @NotNull
    public final EventPopupUiModel copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull List list0, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6) {
        q.g(s, "eventId");
        q.g(s1, "title");
        q.g(s2, "description");
        q.g(list0, "preCautions");
        q.g(s3, "period");
        q.g(s4, "winnerAnnouncementDate");
        q.g(s5, "eligibleParticipants");
        q.g(s6, "prizes");
        return new EventPopupUiModel(s, s1, s2, list0, s3, s4, s5, s6);
    }

    public static EventPopupUiModel copy$default(EventPopupUiModel eventPopupUiModel0, String s, String s1, String s2, List list0, String s3, String s4, String s5, String s6, int v, Object object0) {
        if((v & 1) != 0) {
            s = eventPopupUiModel0.eventId;
        }
        if((v & 2) != 0) {
            s1 = eventPopupUiModel0.title;
        }
        if((v & 4) != 0) {
            s2 = eventPopupUiModel0.description;
        }
        if((v & 8) != 0) {
            list0 = eventPopupUiModel0.preCautions;
        }
        if((v & 16) != 0) {
            s3 = eventPopupUiModel0.period;
        }
        if((v & 0x20) != 0) {
            s4 = eventPopupUiModel0.winnerAnnouncementDate;
        }
        if((v & 0x40) != 0) {
            s5 = eventPopupUiModel0.eligibleParticipants;
        }
        if((v & 0x80) != 0) {
            s6 = eventPopupUiModel0.prizes;
        }
        return eventPopupUiModel0.copy(s, s1, s2, list0, s3, s4, s5, s6);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof EventPopupUiModel)) {
            return false;
        }
        if(!q.b(this.eventId, ((EventPopupUiModel)object0).eventId)) {
            return false;
        }
        if(!q.b(this.title, ((EventPopupUiModel)object0).title)) {
            return false;
        }
        if(!q.b(this.description, ((EventPopupUiModel)object0).description)) {
            return false;
        }
        if(!q.b(this.preCautions, ((EventPopupUiModel)object0).preCautions)) {
            return false;
        }
        if(!q.b(this.period, ((EventPopupUiModel)object0).period)) {
            return false;
        }
        if(!q.b(this.winnerAnnouncementDate, ((EventPopupUiModel)object0).winnerAnnouncementDate)) {
            return false;
        }
        return q.b(this.eligibleParticipants, ((EventPopupUiModel)object0).eligibleParticipants) ? q.b(this.prizes, ((EventPopupUiModel)object0).prizes) : false;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getEligibleParticipants() {
        return this.eligibleParticipants;
    }

    @NotNull
    public final String getEventId() {
        return this.eventId;
    }

    @NotNull
    public final String getPeriod() {
        return this.period;
    }

    @NotNull
    public final List getPreCautions() {
        return this.preCautions;
    }

    @NotNull
    public final String getPrizes() {
        return this.prizes;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getWinnerAnnouncementDate() {
        return this.winnerAnnouncementDate;
    }

    @Override
    public int hashCode() {
        return this.prizes.hashCode() + x.b(x.b(x.b(d.d(x.b(x.b(this.eventId.hashCode() * 0x1F, 0x1F, this.title), 0x1F, this.description), 0x1F, this.preCautions), 0x1F, this.period), 0x1F, this.winnerAnnouncementDate), 0x1F, this.eligibleParticipants);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("EventPopupUiModel(eventId=", this.eventId, ", title=", this.title, ", description=");
        stringBuilder0.append(this.description);
        stringBuilder0.append(", preCautions=");
        stringBuilder0.append(this.preCautions);
        stringBuilder0.append(", period=");
        d.u(stringBuilder0, this.period, ", winnerAnnouncementDate=", this.winnerAnnouncementDate, ", eligibleParticipants=");
        return d.n(stringBuilder0, this.eligibleParticipants, ", prizes=", this.prizes, ")");
    }
}

