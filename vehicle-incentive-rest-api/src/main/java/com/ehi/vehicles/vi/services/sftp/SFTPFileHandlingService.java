package com.ehi.vehicles.vi.services.sftp;

import java.io.IOException;

/**
 * SFTP File Handling Service
 * Push Files to GM FTP folder
 * Pull Files from GM FTP
 */
public interface SFTPFileHandlingService {
    /**
     * Connect to SFTP
     */
    void connectToSFTPServer() throws IOException;

    /**
     * disConnect from SFTP
     */
    void disconnectFromSFTPServer() throws IOException;


    /**
     * push files to SFTP
     *
     * @param localFilePath
     * @return
     * @throws IOException
     */
    boolean pushFileToSFTPServer(String localFilePath) throws IOException;

    /**
     * pull files from GM
     * @param localFilePath
     * @return
     * @throws IOException
     */
    boolean pullFilesFromSFTPServer(String localFilePath) throws IOException;

}
