package com.iloen.melon.fragments.mymusic;

import com.iloen.melon.net.v5x.response.CastMemberDetailRes.RESPONSE.PROGRAM;
import com.iloen.melon.net.v5x.response.ProgramBase.Cast;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \b2\u00020\u0001:\u0004\b\t\n\u000BB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/DataWrapper;", "", "viewType", "", "<init>", "(I)V", "getViewType", "()I", "Companion", "ProgramTitle", "CastItem", "Program", "Lcom/iloen/melon/fragments/mymusic/DataWrapper$CastItem;", "Lcom/iloen/melon/fragments/mymusic/DataWrapper$Program;", "Lcom/iloen/melon/fragments/mymusic/DataWrapper$ProgramTitle;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class DataWrapper {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/DataWrapper$CastItem;", "Lcom/iloen/melon/fragments/mymusic/DataWrapper;", "cast", "Lcom/iloen/melon/net/v5x/response/ProgramBase$Cast;", "<init>", "(Lcom/iloen/melon/net/v5x/response/ProgramBase$Cast;)V", "getCast", "()Lcom/iloen/melon/net/v5x/response/ProgramBase$Cast;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class CastItem extends DataWrapper {
        public static final int $stable = 8;
        @NotNull
        private final Cast cast;

        public CastItem(@NotNull Cast programBase$Cast0) {
            q.g(programBase$Cast0, "cast");
            super(1, null);
            this.cast = programBase$Cast0;
        }

        @NotNull
        public final Cast component1() {
            return this.cast;
        }

        @NotNull
        public final CastItem copy(@NotNull Cast programBase$Cast0) {
            q.g(programBase$Cast0, "cast");
            return new CastItem(programBase$Cast0);
        }

        public static CastItem copy$default(CastItem dataWrapper$CastItem0, Cast programBase$Cast0, int v, Object object0) {
            if((v & 1) != 0) {
                programBase$Cast0 = dataWrapper$CastItem0.cast;
            }
            return dataWrapper$CastItem0.copy(programBase$Cast0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof CastItem ? q.b(this.cast, ((CastItem)object0).cast) : false;
        }

        @NotNull
        public final Cast getCast() {
            return this.cast;
        }

        @Override
        public int hashCode() {
            return this.cast.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "CastItem(cast=" + this.cast + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/DataWrapper$Companion;", "", "<init>", "()V", "VIEW_TYPE_PROGRAM_TITLE", "", "VIEW_TYPE_CAST_ITEM", "VIEW_TYPE_PROGRAM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/DataWrapper$Program;", "Lcom/iloen/melon/fragments/mymusic/DataWrapper;", "program", "Lcom/iloen/melon/net/v5x/response/CastMemberDetailRes$RESPONSE$PROGRAM;", "<init>", "(Lcom/iloen/melon/net/v5x/response/CastMemberDetailRes$RESPONSE$PROGRAM;)V", "getProgram", "()Lcom/iloen/melon/net/v5x/response/CastMemberDetailRes$RESPONSE$PROGRAM;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Program extends DataWrapper {
        public static final int $stable = 8;
        @NotNull
        private final PROGRAM program;

        public Program(@NotNull PROGRAM castMemberDetailRes$RESPONSE$PROGRAM0) {
            q.g(castMemberDetailRes$RESPONSE$PROGRAM0, "program");
            super(2, null);
            this.program = castMemberDetailRes$RESPONSE$PROGRAM0;
        }

        @NotNull
        public final PROGRAM component1() {
            return this.program;
        }

        @NotNull
        public final Program copy(@NotNull PROGRAM castMemberDetailRes$RESPONSE$PROGRAM0) {
            q.g(castMemberDetailRes$RESPONSE$PROGRAM0, "program");
            return new Program(castMemberDetailRes$RESPONSE$PROGRAM0);
        }

        public static Program copy$default(Program dataWrapper$Program0, PROGRAM castMemberDetailRes$RESPONSE$PROGRAM0, int v, Object object0) {
            if((v & 1) != 0) {
                castMemberDetailRes$RESPONSE$PROGRAM0 = dataWrapper$Program0.program;
            }
            return dataWrapper$Program0.copy(castMemberDetailRes$RESPONSE$PROGRAM0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Program ? q.b(this.program, ((Program)object0).program) : false;
        }

        @NotNull
        public final PROGRAM getProgram() {
            return this.program;
        }

        @Override
        public int hashCode() {
            return this.program.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Program(program=" + this.program + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/DataWrapper$ProgramTitle;", "Lcom/iloen/melon/fragments/mymusic/DataWrapper;", "title", "", "<init>", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ProgramTitle extends DataWrapper {
        public static final int $stable;
        @NotNull
        private final String title;

        public ProgramTitle(@NotNull String s) {
            q.g(s, "title");
            super(0, null);
            this.title = s;
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final ProgramTitle copy(@NotNull String s) {
            q.g(s, "title");
            return new ProgramTitle(s);
        }

        public static ProgramTitle copy$default(ProgramTitle dataWrapper$ProgramTitle0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = dataWrapper$ProgramTitle0.title;
            }
            return dataWrapper$ProgramTitle0.copy(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ProgramTitle ? q.b(this.title, ((ProgramTitle)object0).title) : false;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override
        public int hashCode() {
            return this.title.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "ProgramTitle(title=" + this.title + ")";
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int VIEW_TYPE_CAST_ITEM = 1;
    public static final int VIEW_TYPE_PROGRAM = 2;
    public static final int VIEW_TYPE_PROGRAM_TITLE;
    private final int viewType;

    static {
        DataWrapper.Companion = new Companion(null);
    }

    private DataWrapper(int v) {
        this.viewType = v;
    }

    public DataWrapper(int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v);
    }

    public final int getViewType() {
        return this.viewType;
    }
}

