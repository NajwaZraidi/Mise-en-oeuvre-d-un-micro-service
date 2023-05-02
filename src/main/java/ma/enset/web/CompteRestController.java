package ma.enset.web;

import ma.enset.dto.CompteBanqueReponseDTO;
import ma.enset.dto.CompteBanqueRequestDTO;
import ma.enset.entities.CompteBanque;
import ma.enset.mappers.CompteMapper;
import ma.enset.repositories.CompteBanqueRepository;
import ma.enset.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    private CompteBanqueRepository compteBanqueRepository;
    private CompteService compteService;
    private CompteMapper compteMapper;
    public CompteRestController(CompteBanqueRepository compteBanqueRepository, CompteService compteService, CompteMapper compteMapper) {
        this.compteBanqueRepository = compteBanqueRepository;
        this.compteService = compteService;
        this.compteMapper = compteMapper;
    }

    //Rest API
    @GetMapping("/compteBanques")
   public List<CompteBanque> compteBanques(){
       return  compteBanqueRepository.findAll();
   }
   @GetMapping("/compteBanques/{id}")
    public CompteBanque compteBanque(@PathVariable String id){
        return  compteBanqueRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s n'existe pas",id)));
   }
    @PostMapping("/compteBanques")
   public CompteBanqueReponseDTO save(@RequestBody CompteBanqueRequestDTO requestDTO){
         return  compteService.addCompte(requestDTO);
   }

   @PutMapping("/compteBanques/{id}")
    public CompteBanque update(@PathVariable String id,@RequestBody CompteBanque compteBanque){
        CompteBanque compteBanque1=compteBanqueRepository.findById(id).orElseThrow();
        if(compteBanque.getBalence()!=null) compteBanque1.setBalence(compteBanque.getBalence());
       if(compteBanque.getDateCreation()!=null)  compteBanque1.setDateCreation(new Date());
       if(compteBanque.getTypeCompte()!=null)  compteBanque1.setTypeCompte(compteBanque.getTypeCompte());
       if(compteBanque.getCurrent()!=null) compteBanque1.setCurrent(compteBanque.getCurrent());
        return compteBanqueRepository.save(compteBanque1);
    }
    @DeleteMapping("/compteBanques/{id}")
    public void deleteCompte(@PathVariable String id){
        compteBanqueRepository.deleteById(id);
    }
}
