package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\b\u0010\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\t\u0010\bJ\u000F\u0010\n\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\n\u0010\bJ\u000F\u0010\u000B\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u000B\u0010\bJ\u000F\u0010\f\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\f\u0010\bJ\u0015\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\r\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0011\u00A2\u0006\u0004\b\u000F\u0010\u0012J\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0014J\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0016J\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0018J\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u001AJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u001CJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u001EJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\u000F\u0010 J\u0017\u0010\"\u001A\u00020\u00062\u0006\u0010!\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\"\u0010\u0012R\u0014\u0010\u0003\u001A\u00020\u00028\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010#R*\u0010$\u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u001F8\u0006@DX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b$\u0010%\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010 \u00A8\u0006)"}, d2 = {"Lkotlinx/serialization/json/internal/Composer;", "", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "writer", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;)V", "Lie/H;", "indent", "()V", "unIndent", "nextItem", "nextItemIfNotFirst", "space", "", "v", "print", "(C)V", "", "(Ljava/lang/String;)V", "", "(F)V", "", "(D)V", "", "(B)V", "", "(S)V", "", "(I)V", "", "(J)V", "", "(Z)V", "value", "printQuoted", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "writingFirst", "Z", "getWritingFirst", "()Z", "setWritingFirst", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public class Composer {
    @NotNull
    public final InternalJsonWriter writer;
    private boolean writingFirst;

    public Composer(@NotNull InternalJsonWriter internalJsonWriter0) {
        q.g(internalJsonWriter0, "writer");
        super();
        this.writer = internalJsonWriter0;
        this.writingFirst = true;
    }

    public final boolean getWritingFirst() {
        return this.writingFirst;
    }

    public void indent() {
        this.writingFirst = true;
    }

    public void nextItem() {
        this.writingFirst = false;
    }

    public void nextItemIfNotFirst() {
        this.writingFirst = false;
    }

    public void print(byte b) {
        this.writer.writeLong(((long)b));
    }

    public final void print(char c) {
        this.writer.writeChar(c);
    }

    public void print(double f) {
        this.writer.write(String.valueOf(f));
    }

    public void print(float f) {
        this.writer.write(String.valueOf(f));
    }

    public void print(int v) {
        this.writer.writeLong(((long)v));
    }

    public void print(long v) {
        this.writer.writeLong(v);
    }

    public final void print(@NotNull String s) {
        q.g(s, "v");
        this.writer.write(s);
    }

    public void print(short v) {
        this.writer.writeLong(((long)v));
    }

    public void print(boolean z) {
        this.writer.write(String.valueOf(z));
    }

    public void printQuoted(@NotNull String s) {
        q.g(s, "value");
        this.writer.writeQuoted(s);
    }

    public final void setWritingFirst(boolean z) {
        this.writingFirst = z;
    }

    public void space() {
    }

    public void unIndent() {
    }
}

