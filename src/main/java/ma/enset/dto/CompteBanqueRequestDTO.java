package ma.enset.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.enums.TypeCompte;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompteBanqueRequestDTO {

    private  Double balence;
    private String current;
    private TypeCompte typeCompte;
}
