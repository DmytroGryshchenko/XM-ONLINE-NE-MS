package com.icthh.xm.tmf.ms.communication.service;

import com.icthh.xm.tmf.ms.communication.domain.Client;
import com.icthh.xm.tmf.ms.communication.domain.VodData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class VideoOnDemandServiceImpl implements VideoOnDemandService {

    private TcpClient tcpClient;

    @Override
    public VodData read(Client client) {
        VodData vodData;
        tcpClient = new TcpClient();
        System.out.println("Connect to tcp network emulator");
        String statusConnect = tcpClient.connect(client.getLogin(), client.getPassword());
        System.out.println("Status Connection: "+ statusConnect);
        if(statusConnect.equals("connected()")){
            vodData = tcpClient.read(client.getUid());
            System.out.println("read data response: "+ vodData);
        } else {
            vodData = new VodData("OFF","OFF");
            System.out.println("didn't pass connect operation for uid "+ client.getLogin() +", VodData set to default params");
        }

        String statusDisconnect = tcpClient.disconnect();
        System.out.println("Status Connection: "+ statusDisconnect);
        return vodData;

    }

}
