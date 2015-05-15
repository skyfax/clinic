package server.services;

import server.mappers.ConsultationMapper;

/**
 * Created by Paul on 09/05/2015.
 */
public class ConsultationService {
    ConsultationMapper cM;

    public ConsultationService(ConsultationMapper cM) {
        this.cM = cM;
    }
}
