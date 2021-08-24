import org.apache.hc.core5.util.Asserts;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ReadPdfFile {

    @Test
    void readPdf() throws IOException {

        File file = new File("./src/test/resources/Modern_architecture.pdf");
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String documentText = pdfStripper.getText(document);

        Assertions.assertTrue(documentText.contains("Современная архитектура"));

        document.close();



    }
}
