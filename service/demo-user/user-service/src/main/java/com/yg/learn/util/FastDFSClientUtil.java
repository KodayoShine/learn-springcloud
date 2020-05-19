package com.yg.learn.util;

import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FastDFSClientUtil {

    private static Logger logger = LoggerFactory.getLogger(FastDFSClientUtil.class);
    private static final String CONFIG_FILENAME = "fdfs_client.conf";

    // 加载文件
    static {

        try {
            ClientGlobal.init(CONFIG_FILENAME);
            logger.info("初始化 Fastdfs Client 配置信息：{}", ClientGlobal.configInfo());

        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
    }

    /**
     * 上传文件
     * @param fileContent
     * @param extName
     * @return
     * @throws Exception
     */
    public String[] uploadFile(byte[] fileContent, String extName) {

        try {
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            return storageClient.upload_file(fileContent, extName, null);

        } catch (Exception e) {
            logger.error(e.toString(), e);
            return null;
        }

    }

    /**
     * 下载文件
     * @param groupName
     * @param fileId
     * @return
     */
    public byte[] downloadFile(String groupName, String fileId) {
        try {
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            byte[] fileByte = storageClient.download_file(groupName, fileId);
            return fileByte;
        } catch (Exception e) {
            logger.error(e.toString(), e);
            return null;
        }
    }


    /**
     * 删除文件
     * @param groupName
     * @param remoteFilename
     * @return
     */
    public int deleteFile(String groupName, String remoteFilename) {

        try {
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            int i = storageClient.delete_file(groupName, remoteFilename);
            logger.info("delete file successfully!!!" + i);
            return 1;
        } catch (Exception e) {
            logger.error(e.toString(), e);
            return 0;
        }

    }

}