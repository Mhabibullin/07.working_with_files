import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.apache.commons.io.FileUtils.cleanDirectory;

public class ReadUnzipFile {

    @AfterAll
    static void clearUnzipDir() throws IOException {
        cleanDirectory(new File("./src/test/resources/unzip"));
    }

    @Test
    void readUnzipFile() throws IOException {
        String zipFilePath = "./src/test/resources/cv.zip";
        String unzipFolder = "./src/test/resources/unzip";
        String zipPassword = "1234";
        String unzipFileTxtPath = "./src/test/resources/unzip/cv.txt";
        String expectedData = "Менеджер проекта";

        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(zipPassword.toCharArray());
        }
        zipFile.extractAll(unzipFolder);

        FileInputStream fis = new FileInputStream(unzipFileTxtPath);
        String document = IOUtils.toString(fis, StandardCharsets.UTF_8);
        Assertions.assertTrue(document.contains(expectedData));
        fis.close();
    }
}
