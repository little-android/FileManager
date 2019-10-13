package com.codve.filemanager.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class FileUtil {

    public FileItem getFileInfo(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        String filename = file.getName();
        String filepath = file.getParent();
        long updateTime = file.lastModified();
        int index = filename.lastIndexOf('.');
        String fileType = "";
        if (file.isDirectory()) {
            fileType = "dir";
        } else if (index > 0) {
            fileType = filename.substring(index + 1);
        }
        return new FileItem(filename, filepath, fileType, updateTime);
    }

    public void list(File dir, List<FileItem> items, boolean recursive)
            throws FileNotFoundException {
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        String[] filenames = dir.list();
        for (String filename : filenames) {
            String filepath = dir.getAbsolutePath() + File.separator + filename;
            File tmpFile = new File(filepath);
            if (tmpFile.isDirectory() && recursive) {
                list(tmpFile, items, true);
            } else {
                items.add(getFileInfo(tmpFile));
            }
        }
    }
}
