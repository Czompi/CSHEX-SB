package hu.czsoft.cshex_sb.services;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.layout.font.FontProvider;
import hu.czsoft.cshex_sb.workers.CustomTagWorkerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    @Override
    public ByteArrayInputStream convertHtmlToPdf(String htmlContent) {
        ConverterProperties properties = new ConverterProperties();
        FontProvider fontProvider = new DefaultFontProvider(true, true, true);
        fontProvider.addFont("cascadia-code.ttf");
        properties.setFontProvider(fontProvider);
        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
        properties.setTagWorkerFactory(new CustomTagWorkerFactory());
        HtmlConverter.convertToPdf(htmlContent, pdfStream, properties);
        return new ByteArrayInputStream(pdfStream.toByteArray());
    }
}


