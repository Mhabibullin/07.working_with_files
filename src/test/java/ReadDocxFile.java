import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

public class ReadDocxFile {
        @Test
        void readDocx() {
            try {
            File fileToBeRead = new File("./src/test/resources/Geology_report.docx");
            FileInputStream fileInputStream = new FileInputStream(fileToBeRead);
            XWPFDocument document = new XWPFDocument(fileInputStream);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            String fileContent = extractor.getText();
                Assertions.assertTrue(fileContent.contains("101"));
                document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}