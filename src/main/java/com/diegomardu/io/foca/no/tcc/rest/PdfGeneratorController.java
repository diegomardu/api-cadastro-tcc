package com.diegomardu.io.foca.no.tcc.rest;

import com.diegomardu.io.foca.no.tcc.Conteudo;
import com.diegomardu.io.foca.no.tcc.model.entity.ConteudoAta;
import com.diegomardu.io.foca.no.tcc.service.PdfGeneratorService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/pdf/generate")
public class PdfGeneratorController {

    private final PdfGeneratorService pdfGeneratorService;

    public PdfGeneratorController(PdfGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @PostMapping
    public void generatePDF(HttpServletResponse httpServletResponse, @RequestBody Conteudo conteudo) throws IOException {
        httpServletResponse.setContentType("application/pdf");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = df.format(new Date());

        conteudo.setData(currentDateTime);

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ata_reuniao_" + currentDateTime + ".pdf";
        httpServletResponse.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.export(httpServletResponse, conteudo);
    }
}
