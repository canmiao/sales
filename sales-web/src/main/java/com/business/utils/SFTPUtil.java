package com.business.utils;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @Author: taoye
 * @Description: SFTPUtil
 * @Date: 13:44 2018/8/8
 */
public class SFTPUtil {
    private final Logger logger = LoggerFactory.getLogger(SFTPUtil.class);

    ChannelSftp sftp = null;

    private String host = "";

    private int port = 0;

    private String username = "";

    private String password = "";

    public SFTPUtil(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }


    public ChannelSftp connect() throws Exception {
        JSch jsch = new JSch();
        Session sshSession = jsch.getSession(this.username, this.host,
                this.port);
        logger.debug(SFTPUtil.class + "Session created.");

        sshSession.setPassword(password);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        sshSession.connect(20000);
        logger.debug(SFTPUtil.class + " Session connected.");

        logger.debug(SFTPUtil.class + " Opening Channel.");
        Channel channel = sshSession.openChannel("sftp");
        channel.connect();
        this.sftp = (ChannelSftp) channel;
        logger.debug(SFTPUtil.class + " Connected to " + this.host + ".");
        return sftp;
    }


    public void disconnect() throws Exception {
        if (this.sftp != null) {
            if (this.sftp.isConnected()) {
                this.sftp.disconnect();
            } else if (this.sftp.isClosed()) {
                logger.debug(SFTPUtil.class + " sftp is closed already");
            }
        }
    }


    public void upload(String directory, String uploadFile) throws Exception {
        this.sftp.cd(directory);
        File file = new File(uploadFile);
        this.sftp.put(new FileInputStream(file), file.getName());
    }


    public void uploadByDirectory(String directory) throws Exception {

        String uploadFile = "";
        List<String> uploadFileList = this.listFiles(directory);
        Iterator<String> it = uploadFileList.iterator();

        while (it.hasNext()) {
            uploadFile = it.next().toString();
            this.upload(directory, uploadFile);
        }
    }


    public void download(String directory, String downloadFile,
                         String saveDirectory) throws Exception {
        String saveFile = saveDirectory + "//" + downloadFile;
        this.sftp.cd(directory);
        File file = new File(saveFile);
        this.sftp.get(downloadFile, new FileOutputStream(file));
    }


    public void downloadByDirectory(String directory, String saveDirectory)
            throws Exception {
        String downloadFile = "";
        List<String> downloadFileList = this.listFiles(directory);
        Iterator<String> it = downloadFileList.iterator();
        while (it.hasNext()) {
            downloadFile = it.next().toString();
            if (downloadFile.toString().indexOf(".") < 0) {
                continue;
            }
            this.download(directory, downloadFile, saveDirectory);
        }
    }


    public void delete(String directory, String deleteFile) throws Exception {
        this.sftp.cd(directory);
        this.sftp.rm(deleteFile);
    }


    @SuppressWarnings("unchecked")
    public List<String> listFiles(String directory) throws Exception {
        Vector fileList;
        List<String> fileNameList = new ArrayList<String>();
        fileList = this.sftp.ls(directory);
        Iterator it = fileList.iterator();
        while (it.hasNext()) {
            String fileName = ((ChannelSftp.LsEntry) it.next()).getFilename();
            if (".".equals(fileName) || "..".equals(fileName)) {
                continue;
            }
            fileNameList.add(fileName);
        }
        return fileNameList;
    }


    public void rename(String directory, String oldFileNm, String newFileNm)
            throws Exception {
        this.sftp.cd(directory);
        this.sftp.rename(oldFileNm, newFileNm);
    }

    public void cd(String directory) throws Exception {
        this.sftp.cd(directory);
    }

    public InputStream get(String directory) throws Exception {
        InputStream streatm = this.sftp.get(directory);
        return streatm;
    }

    /**
     * @param directory
     * @param inputStream
     * @throws Exception
     */
    public void upload(String directory, InputStream inputStream,String fileName) throws Exception {
        // TODO Auto-generated method stub
        this.sftp.cd(directory);
        this.sftp.put(inputStream, fileName);
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		SFTPUtil sftpUtils = new SFTPUtil("192.168.252.129",22,"uftp","uftp");
		try {
			sftpUtils.connect();
			String directory = "/home/uftp/";
			String uploadFile = "D:/test.txt";
			sftpUtils.upload(directory, uploadFile);
            sftpUtils.download("/home/uftp","test.txt","D:/taoye");
			sftpUtils.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sftpUtils.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
//        System.out.println(MD5.getMD5("000000".getBytes()));

    }
}
