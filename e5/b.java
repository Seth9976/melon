package E5;

import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.io.File;
import java.io.FilenameFilter;

public final class b implements FilenameFilter {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override
    public final boolean accept(File file0, String s) {
        switch(this.a) {
            case 0: {
                return InstrumentUtility.b(file0, s);
            }
            case 1: {
                return InstrumentUtility.c(file0, s);
            }
            case 2: {
                return InstrumentUtility.a(file0, s);
            }
            case 3: {
                return ErrorReportHandler.b(file0, s);
            }
            case 4: {
                return s.startsWith("aqs.");
            }
            case 5: {
                return s.startsWith(".ae");
            }
            case 6: {
                return s.startsWith("event");
            }
            default: {
                return s.startsWith("event") && !s.endsWith("_");
            }
        }
    }
}

