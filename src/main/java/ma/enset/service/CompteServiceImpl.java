package ma.enset.service;


import ma.enset.dto.CompteBanqueReponseDTO;
import ma.enset.dto.CompteBanqueRequestDTO;
import ma.enset.entities.CompteBanque;
import ma.enset.enums.TypeCompte;
import ma.enset.mappers.CompteMapper;
import ma.enset.repositories.CompteBanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service @Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteBanqueRepository compteBanqueRepository;
    @Autowired
    private CompteMapper compteMapper;
    @Override
    public CompteBanqueReponseDTO addCompte(CompteBanqueRequestDTO compteBanqueDTO) {
        CompteBanque compteBanque=CompteBanque.builder()
                .id(UUID.randomUUID().toString())//intialisation des attributs
                .typeCompte(Math.random()>0.5? TypeCompte.COMPTE_CURRENT:TypeCompte.COMPTE_EPARGNE)
                .dateCreation(new Date())
                .balence(10000+Math.random()*90000)
                .current("MAD")
                .build();
         CompteBanque saveCompte=compteBanqueRepository.save(compteBanque);
         CompteBanqueReponseDTO banqueReponseDTO=compteMapper.fromCompteBanque(saveCompte);
        return banqueReponseDTO;
    }
}
