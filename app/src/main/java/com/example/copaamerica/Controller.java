package com.example.copaamerica;
import java.util.LinkedList;
import android.content.Context;

public class Controller {
	
	private static Equipo eq;
	
	private static Controller instancia=new Controller();

	private Controller()
	{
	}

	public static Controller getInstancia()
	{
		return instancia;
	}
	
    public LinkedList<NotInt> getListDTONotInt(Context c)
   	{
       	eq=new Equipo(c);
       	LinkedList<NotInt> listDTO=new LinkedList<NotInt>();
       	eq.open();
   		listDTO=eq.obtenerNotInt();
   		eq.close();
   		return listDTO;
   	}
    
    public LinkedList<DTO> getListDTO(Context c)
   	{
       	eq=new Equipo(c);
       	LinkedList<DTO> listDTO=new LinkedList<DTO>();
       	eq.open();
   		listDTO=eq.obtener();
   		eq.close();
   		return listDTO;
   	}
    
    public LinkedList<DTOElim> getListDTOElim(Context c)
   	{
       	eq=new Equipo(c);
       	LinkedList<DTOElim> listDTO=new LinkedList<DTOElim>();
       	eq.open();
   		listDTO=eq.obtenerElim();
   		eq.close();
   		return listDTO;
   	}
    
    public void insertElimD(Context c,String idpartido,String pais1,String pais2,String elegido,int equipo1,int equipo2,int equipog1,int equipog2)
	{
    	eq=new Equipo(c);
       	eq.open();
   		eq.insertElim(idpartido, pais1, pais2, elegido, equipo1, equipo2, equipog1, equipog2);
   		eq.close();
	}
    
    public void insertDTO(Context c,String idpartido,int equipo1,int equipo2)
	{
    	eq=new Equipo(c);
       	eq.open();
   		eq.insert(idpartido,equipo1, equipo2);
   		eq.close();
	}
    
    public void DeleteElimD(Context c,String idpartido)
   	{
       	eq=new Equipo(c);
          	eq.open();
      		eq.EliminarDTOElim(idpartido);
      		eq.close();
   	}
    
    public DTOE getPartidos(Context c)
    {
    	DTOE v=new DTOE();
    	eq=new Equipo(c);
    	eq.open();
  		v=eq.obtenerGoles();
  		eq.close();
    	return v;
    }
    
    public void DeleteElimAllD(Context c)
   	{
       	eq=new Equipo(c);
          	eq.open();
      		eq.EliminarTodoDTOElim();
      		eq.close();
   	}
    
    public void EditGPartidos(Context c,String goles)
   	{
       	eq=new Equipo(c);
          	eq.open();
      		eq.editarGoles(goles);
      		eq.close();
   	}
    
    public void EditlimD(Context c,String idpartido,int goles1,int goles2)
   	{
       	eq=new Equipo(c);
          	eq.open();
      		eq.editarDTO(idpartido, goles1, goles2);
      		eq.close();
   	}
    
    public void DeleteD(Context c,String idpartido)
   	{
       	eq=new Equipo(c);
          	eq.open();
      		eq.EliminarDTO(idpartido);
      		eq.close();
   	}
}
