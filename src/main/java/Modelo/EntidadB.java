package Modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity 
@Table (name = "Tabla_del_B")
public class EntidadB {
	
	
	  @ManyToOne
	    @JoinColumn(name = "A_ID", referencedColumnName = "ID")
	    private EntidadA a;
	    @Id
	    @Column(nullable = false)
	    private Long id;
	    public EntidadB() {
	    	
	    }
	    public EntidadB(Long id) {
	    	this.id=id;
	    }
	     
	    public void setA(EntidadA a) {
	        setA(a, true);
	    }
	     
	    void setA(EntidadA a, boolean add) {
	        this.a = a;
	        if (a != null && add) {
	            a.addB(this, false);
	        }
	    }
	 
	    public EntidadA getA() {
	        return a;
	    }
	 
	    public void setId(Long id) {
	        this.id = id;
	    }
	 
	    public Long getId() {
	        return id;
	    }
	     
	    public boolean equals(Object object) {
	        if (object == this)
	            return true;
	        if ((object == null) || !(object instanceof EntidadB))
	            return false;
	 
	        final EntidadB b = (EntidadB)object;
	 
	        if (id != null && b.getId() != null) {
	            return id.equals(b.getId());
	        }
	        return false;
	    }

	

}