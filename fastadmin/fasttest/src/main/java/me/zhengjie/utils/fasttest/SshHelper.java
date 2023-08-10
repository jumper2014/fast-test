package me.zhengjie.utils.fasttest;

import com.jcraft.jsch.*;

import java.io.IOException;
import java.io.InputStream;

public class SshHelper {

    public static String run(String command, boolean withCert) {
        String host = "192.168.0.1";
        String privateKeyPath = "";
        int port = 22;
        String username = "user";
        String password = "pass";
        if (withCert) {
            privateKeyPath = "path_to_private_key_file";
        }

        StringBuilder output = new StringBuilder();
        try {
            JSch jsch = new JSch();
            if(withCert) {
                jsch.addIdentity(privateKeyPath);
            }
            Session session = jsch.getSession(username, host, port);
            if(!withCert) {
                session.setPassword(password);
            }
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream inputStream = channel.getInputStream();
            channel.connect();

            // 读取命令输出
            byte[] buffer = new byte[1024];

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                output.append(new String(buffer, 0, bytesRead));
            }

            // 打印命令输出
            System.out.println(output.toString());

            channel.disconnect();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}
