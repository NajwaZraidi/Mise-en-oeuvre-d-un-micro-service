package ma.enset.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import ma.enset.dto.CompteBanqueReponseDTO;
import ma.enset.entities.CompteBanque;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteBanqueReponseDTO fromCompteBanque(CompteBanque compteBanque){
        CompteBanqueReponseDTO compteBanqueReponseDTO=new CompteBanqueReponseDTO();
        BeanUtils.copyProperties(compteBanque,compteBanqueReponseDTO);
        return compteBanqueReponseDTO;
    }
}
