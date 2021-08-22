import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDownloadDocx {

    static final String PATH_DOWNLOADS = "testDownloads";

    @AfterAll
    static void clearDownloads() throws IOException {
        FileUtils.cleanDirectory(new File(PATH_DOWNLOADS));
    }

    @Test
    void fileDownload() throws IOException {
        Configuration.downloadsFolder = PATH_DOWNLOADS;

        open("https://github.com/IvanBo3/07.working_with_files/blob/master/src/test/resources/Geology_report.docx");
        File downloadedFile = $("#raw-url").download();

        FileInputStream fis = new FileInputStream(downloadedFile);
        XWPFDocument document = new XWPFDocument(fis);
        XWPFWordExtractor extract = new XWPFWordExtractor(document);
        String fileContent = extract.getText();
        Assertions.assertTrue(fileContent.contains("Отчет по геологии 101"));
    }

}
