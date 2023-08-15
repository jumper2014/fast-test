package com.example.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FileExtractor {

    private static final Logger logger = LoggerFactory.getLogger(FileExtractor.class);
    private static final String OS_NAME_PROPERTY = "os.name";
    private static final String WINDOWS_PLATFORM = "win";
    private static final String EXE_FILE = ".exe";

    private FileExtractor(){
        logger.info("Private constructor of FileExtractor");
    }

    /**
     * Extract file from jar file
     *
     * @param srcURL source URL
     * @param dst    destination file name
     */
    public static void extractFile(URL srcURL, String dst) {
        String osName = System.getProperty(OS_NAME_PROPERTY).toLowerCase();

        if (osName.contains(WINDOWS_PLATFORM)) {
            File file = new File(dst);
            if (srcURL.toString().contains(EXE_FILE) && !file.setExecutable(true)) {
                logger.error("Fail to set file attribute to executable");
            }
        } else {
            Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString("rwxr--r--");
            FileAttribute<?> permission = PosixFilePermissions.asFileAttribute(ownerWritable);
            try {
                Files.createFile(Paths.get(dst), permission);
            } catch (IOException ie) {
                logger.error("Fail to create file " + dst, ie);
            }
        }

        try (InputStream inputStream = srcURL.openStream();
             FileOutputStream outputStream = new FileOutputStream(dst)
        ) {
            byte[] buffer = new byte[4096];
            int bytesRead = inputStream.read(buffer);
            while (bytesRead != -1) {
                outputStream.write(buffer, 0, bytesRead);
                bytesRead = inputStream.read(buffer);
            }
        } catch (Exception e) {
            logger.error("Fail to extract file", e);
        }
    }

    /**
     * Delete runtime file with given name
     *
     * @param fileName file name
     */
    public static void deleteFile(String fileName) {
        if (null != fileName) {
            try{
                Files.delete(Paths.get(fileName));
            }catch (IOException ioe){
                logger.error("Fail to delete file {}", fileName);
            }
        }
    }

    /**
     * Delete file or directory
     *
     * @param file file object
     */
    public static void deteteFile(File file) {

        if (file.isFile()) {
            try{
                Files.delete(file.toPath());
                logger.info("Deleted file {}", file.getPath());
            }catch (IOException ie){
                logger.error("Fail to delete {}", file.getName());
            }
            return;
        }

        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            deteteFile(f);
        }
    }

    /**
     * Copy TestNG files from jar file to current directory with new TestNG file names
     *
     */
    public static void extractTestNGFiles(String[] args) {
        if (null != args) {
            URL testNGFileName;

            deleteTestNGFiles();
            for (int i = 0; i < args.length; i++) {
                testNGFileName = Thread.currentThread().getContextClassLoader().getResource(args[i]);
                if (null != testNGFileName) {
                    args[i] = "TestNG_" + i + ".xml";
                    FileExtractor.extractFile(testNGFileName, args[i]);
                }
            }
        }
    }

    /**
     * Delete all TestNG files in current directory, names like TestNG_?.xml
     */
    public static void deleteTestNGFiles() {
        File currentDir = new File(System.getProperty("user.dir"));
        File[] files = currentDir.listFiles();

        assert files != null;
        for(File file : files){
            if (file.isFile()
                    && file.getName().contains("TestNG_")
                    && file.getName().contains(".xml")) {
                deteteFile(file);
            }
        }
    }
}
