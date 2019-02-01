package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table (name = "Tabla_del_A")
public class EntidadA {
	
	 @OneToMany(cascade={CascadeType.ALL}, mappedBy="a")
	    private List<EntidadB> bList =new ArrayList<EntidadB>();
	    @Id
	    @Column(nullable = false)
	    private Long id;
	    public EntidadA() {
	    }
	    public EntidadA(Long id) {
	    	this.id=id;
	    }
	    public void addB(EntidadB b) {
	        addB(b, true);
	    }
	 
	    void addB(EntidadB b, boolean set) {
	        if (b != null) {
	            if(getBList().contains(b)) {
	                getBList().set(getBList().indexOf(b), b);
	            }
	            else {
	                getBList().add(b);
	            }
	            if (set) {
	                b.setA(this, false);
	            }
	        }
	    }
	     
	    public void removeB(EntidadB b) {
	        getBList().remove(b);
	        b.setA(null);
	    }    
	 
	    public void setBList(List<EntidadB> bList) {
	        this.bList = bList;
	    }
	 
	    public List<EntidadB> getBList() {
	        return bList;
	    }
	     
	 
	    public void setId(Long id) {
	        this.id = id;
	    }
	 
	    public Long getId() {
	        return id;
	    }
	}
    

