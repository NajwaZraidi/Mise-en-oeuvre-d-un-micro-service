package ma.enset.entities;

import ma.enset.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = CompteBanque.class,name="p1")
public interface CompteProjection {
    public String getId();
    public TypeCompte getTypeCompte();
}
