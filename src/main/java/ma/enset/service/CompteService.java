package ma.enset.service;

import ma.enset.dto.CompteBanqueReponseDTO;
import ma.enset.dto.CompteBanqueRequestDTO;

public interface CompteService {
        public CompteBanqueReponseDTO addCompte(CompteBanqueRequestDTO compteBanqueDTO);
}
