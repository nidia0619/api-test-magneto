package com.mercadolibre.test.magneto.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadolibre.test.magneto.daos.AdnDAO;
import com.mercadolibre.test.magneto.dto.RequestDTO;
import com.mercadolibre.test.magneto.dto.ResponseDTO;
import com.mercadolibre.test.magneto.settings.ConstantsDescription;
import com.mercadolibre.test.magneto.utils.ProcessChain;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Component
@Slf4j
public class ControllerBusiness {

    @Autowired
    private AdnDAO adnDAO;

    @Autowired
    private ConstantsDescription constantsDescription;

    /**
     * Metodo que detectar si un humano es mutante enviando la secuencia de ADN
     * mediante un HTTP POST
     *
     * @param req - Contiene un array de Strings con el ADN
     * @return En caso de verificar un mutante, debería devolver un HTTP 200-OK,
     * en caso contrario un 403-Forbidden
     */
    public ResponseEntity<?> mutant(RequestDTO req) {
        log.info("Start...");
        log.info("Request: " + req);
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        try {
            if (ProcessChain.validate(req.getDna(), constantsDescription.getDnaLetters(), constantsDescription.getDnaSize())) {
                boolean isMutan = ProcessChain.isMutant(ProcessChain.convertArray(req.getDna()));
                adnDAO.insert(Arrays.toString(req.getDna()), isMutan);
                if (isMutan) {
                    httpStatus = HttpStatus.OK;
                } else {
                    log.info(constantsDescription.getNotMutant());
                }
            } else {
                log.info(constantsDescription.getValidate());
            }
        } catch (Exception e) {
            log.error(constantsDescription.getErrorExceptionService() + " - " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        log.info("End...");
        return new ResponseEntity(httpStatus);
    }

    /**
     * Mertodo que consulta las estadísticas de las verificaciones de ADN
     *
     * @return ResponseDTO - Json con la estadística
     */
    public ResponseEntity<ResponseDTO> stats() {
        log.info("Start...");
        HttpStatus httpStatus = HttpStatus.OK;
        ResponseDTO resp = null;
        try {
            resp = new ResponseDTO();
            resp.setStats(adnDAO.get());
        } catch (Exception e) {
            log.error(constantsDescription.getErrorExceptionService() + " - " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        log.info("Response: " + resp);
        log.info("End...");
        return new ResponseEntity(resp, httpStatus);
    }

}
