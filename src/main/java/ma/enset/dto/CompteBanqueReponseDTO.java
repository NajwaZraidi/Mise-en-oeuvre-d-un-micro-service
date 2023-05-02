package ma.enset.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.enums.TypeCompte;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompteBanqueReponseDTO {
    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private  Double balence;
    private String current;
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;
}
