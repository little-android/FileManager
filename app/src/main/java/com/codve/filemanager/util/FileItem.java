package com.codve.filemanager.util;

public class FileItem {

    private String filename;
    private String filepath;
    private String fileType;
    private long updateTime;

    public FileItem() {
    }

    public FileItem(String filename, String filepath, String fileType, long updateTime) {
        this.filename = filename;
        this.filepath = filepath;
        this.fileType = fileType;
        this.updateTime = updateTime;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
