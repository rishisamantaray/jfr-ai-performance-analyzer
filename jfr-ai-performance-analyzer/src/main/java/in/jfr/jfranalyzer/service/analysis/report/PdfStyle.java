package in.jfr.jfranalyzer.service.analysis.report;

import org.openpdf.text.Font;
import org.openpdf.text.FontFactory;

public final class PdfStyle {

    private PdfStyle() {
    }

    public static final Font TITLE =
            FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD,
                    24);

    public static final Font SECTION =
            FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD,
                    16);

    public static final Font HEADER =
            FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD,
                    12);

    public static final Font NORMAL =
            FontFactory.getFont(
                    FontFactory.HELVETICA,
                    11);

}