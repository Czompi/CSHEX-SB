package hu.czsoft.cshex_sb.controllers;

import hu.czsoft.cshex_sb.NetHandler;
import hu.czsoft.cshex_sb.models.ConverterData;
import hu.czsoft.cshex_sb.services.PdfService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "/convert")
public class SiteConverterController {
    @Autowired
    private PdfService pdfService;
    @PostMapping()
    public void post(@RequestBody ConverterData post, HttpServletResponse response) throws IOException, RuntimeException {
        String html;
        try {
            html = NetHandler.getString(post.url);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream byteArrayInputStream = pdfService.convertHtmlToPdf(html);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=file.pdf");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
