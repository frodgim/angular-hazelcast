package entities;


import javax.persistence.*;
import java.util.UUID;

/**
 * This is a base class for all entities. It provides an equals and hashcode that will always work correctly in all
 * circumstances. This avoids frequent errors related to the implementation of those same methods.
 *
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    /*
    *
    *   This method is mean for testing purposes only (create mock data), as we should not set Ids manually,
    *   Hibernate will do it automatically
    *
    **/
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
  
}

