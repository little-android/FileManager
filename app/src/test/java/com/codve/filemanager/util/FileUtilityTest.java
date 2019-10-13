package com.codve.filemanager.util;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FileUtilityTest {

    private FileUtil mFileUtil;

    @Rule
    public ExpectedException mException = ExpectedException.none();

    @Rule
    public TemporaryFolder mFolder = new TemporaryFolder();

    @Before
    public void setUp() {
        mFileUtil = new FileUtil();
    }

    @Test
    public void getFileInfoTest() throws IOException {
        File file = mFolder.newFile("exam.txt");
        String filename = file.getName();
        String filepath = file.getParent();
        String fileType = "txt";
        long updateTime = file.lastModified();
        FileItem item = mFileUtil.getFileInfo(file);

        assertEquals(filename, item.getFilename());
        assertEquals(filepath, item.getFilepath());
        assertEquals(fileType, item.getFileType());
        assertEquals(updateTime, item.getUpdateTime());
    }

    @Test
    public void whenGetFileInfoThenException() throws FileNotFoundException {
        mException.expect(FileNotFoundException.class);

        File file = new File("exam.txt");
        mFileUtil.getFileInfo(file);
    }

    @Test
    public void listTest() throws IOException {
        File file1 = mFolder.newFile("file1.txt");
        File file2 = mFolder.newFile("file2.txt");
        File folder = mFolder.newFolder("folder");

        List<FileItem> items = new ArrayList<>();
        mFileUtil.list(mFolder.getRoot(), items, false);
        assertEquals(3, items.size());
    }

    @Test
    public void listRecursiveTest() throws IOException {
        File file1 = mFolder.newFile("file1.txt");
        File folder1 = mFolder.newFolder("folder1");
        File file2 = new File(folder1, "file2.txt");

        FileOutputStream outputStream = new FileOutputStream(file2);

        String content = "hello, world!";

        outputStream.write(content.getBytes(StandardCharsets.UTF_8));

        List<FileItem> items = new ArrayList<>();
        mFileUtil.list(mFolder.getRoot(), items, true);
        assertEquals(2, items.size());
    }

    @Test
    public void whenListFile() throws IOException {
        File file = mFolder.newFile();
        List<FileItem> items = new ArrayList<>();
        mFileUtil.list(file, items, true);
        assertEquals(0, items.size());

    }

}