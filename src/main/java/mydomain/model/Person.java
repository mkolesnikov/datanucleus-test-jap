package mydomain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person extends BaseEntity<Long>
{
    private static final long serialVersionUID = 1L;

    private String name;
    
    @OneToMany(mappedBy = "person")
    @JoinColumn(name = "person_id")
    private List<Address> address;

    public Person(long id, String name)
    {
        super(id);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

}
