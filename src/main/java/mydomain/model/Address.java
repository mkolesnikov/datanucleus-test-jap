package mydomain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Address extends BaseEntity<Long> {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  private Person person;
}
