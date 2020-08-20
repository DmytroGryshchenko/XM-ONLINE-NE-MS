package com.icthh.xm.tmf.ms.communication.service;

import com.icthh.xm.tmf.ms.communication.domain.Client;
import com.icthh.xm.tmf.ms.communication.domain.VodData;

public interface VideoOnDemandService {

    VodData read(Client client);
}
