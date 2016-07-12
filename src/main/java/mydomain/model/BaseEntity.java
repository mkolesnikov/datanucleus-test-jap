package mydomain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity<K extends Serializable> implements Serializable 
{

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private K id;
  
  @Version
  private Timestamp version;

  public BaseEntity() {}

  public BaseEntity(K id) {
    this.id = id;
  }

  public K getId() {
    return id;
  }

  public void setId(K id) {
    this.id = id;
  }

  public Timestamp getVersion() {
    return version;
  }

  public void setVersion(Timestamp version) {
    this.version = version;
  }
}
