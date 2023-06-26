package plataforma;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmpresaTransporte {
    private ArrayList<Omnibus> omnibus = new ArrayList<Omnibus>();
    //private RegistroCompras reservas;
    private String nombre;

    public EmpresaTransporte(String nombre) {
        this.nombre = nombre; 
        //this.reservas = new RegistroCompras();
    }
    
    public boolean equals(Object o)
    {
    	EmpresaTransporte otraEmpresa = (EmpresaTransporte) o;
    	return this.getNombre().equals(otraEmpresa.getNombre());
    }
    
    

    public void addNewOmnibus(int codOmnibus)
    {
    	Omnibus nuevoOmnibus = new Omnibus(this, codOmnibus);
    	omnibus.add(nuevoOmnibus);
    }
    
    
    public ArrayList<Viaje> obtenerViajes(String origen, String destino, LocalDate fecha) {
        ArrayList<Viaje> viajesDisponibles = new ArrayList<Viaje>();
        for (Omnibus bus : omnibus) {
        	//System.out.println(bus);
            for (Viaje viaje : bus.getViajes(origen, destino, fecha)) {
                viajesDisponibles.add(viaje);
                }
            }
        return viajesDisponibles;
    }

    // Getters and setters
    public Omnibus buscarOmnibus(int numOmnibus) {
    	for (Omnibus o : this.omnibus)
    		if (o.getNum() == numOmnibus)
    			return o;
    	
    	return null;
    }
    
    
    public ArrayList<Omnibus> getOmnibus() {
    	ArrayList<Omnibus> copia = new ArrayList<Omnibus>();
    	copia.addAll(this.omnibus);
        return copia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}