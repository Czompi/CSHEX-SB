package hu.czsoft.cshex_sb.services;

import java.io.ByteArrayInputStream;

public interface PdfService {
    ByteArrayInputStream convertHtmlToPdf(String htmlContent);
}
