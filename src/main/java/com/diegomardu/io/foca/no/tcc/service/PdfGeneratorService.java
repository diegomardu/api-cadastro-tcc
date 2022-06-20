package com.diegomardu.io.foca.no.tcc.service;

import com.diegomardu.io.foca.no.tcc.Conteudo;
import com.diegomardu.io.foca.no.tcc.model.entity.ConteudoAta;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PdfGeneratorService {

        public void export(HttpServletResponse httpServletResponse, Conteudo conteudo) throws IOException {
                Document document = new Document(PageSize.A4);
                PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

                document.open();
                Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitle.setSize(18);

                Paragraph title = new Paragraph(conteudo.getTitulo(), fontTitle);
                title.setAlignment(Paragraph.ALIGN_CENTER);

                Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
                fontTitle.setSize(12);

                Paragraph paragraph = new Paragraph(conteudo.getTitulo(), fontParagraph);
                paragraph.setAlignment(Paragraph.ALIGN_CENTER);

                Paragraph paragraphData = new Paragraph("Campina Grande " + conteudo.getData(),fontParagraph);
                paragraphData.setAlignment(Paragraph.ALIGN_CENTER);

                document.add(title);
                document.add(paragraph);
                document.add(paragraphData);

                document.close();
        }
}
