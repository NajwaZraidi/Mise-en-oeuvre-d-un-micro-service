package ma.enset;

import ma.enset.entities.CompteBanque;
import ma.enset.enums.TypeCompte;
import ma.enset.repositories.CompteBanqueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MiseEnOeuvreUnMicroServiceApplicationBanque {

    public static void main(String[] args) {
        SpringApplication.run(MiseEnOeuvreUnMicroServiceApplicationBanque.class, args);
    }
    @Bean
    CommandLineRunner start(CompteBanqueRepository compteBanqueRepository){
        return args -> {
            for(int i=0;i<10;i++){
                CompteBanque compteBanque=CompteBanque.builder()
                        .id(UUID.randomUUID().toString())//intialisation des attributs
                        .typeCompte(Math.random()>0.5? TypeCompte.COMPTE_CURRENT:TypeCompte.COMPTE_EPARGNE)
                        .dateCreation(new Date())
                        .balence(10000+Math.random()*90000)
                        .current("MAD")
                        .build();
                compteBanqueRepository.save(compteBanque);
            }
        };
    }

}
