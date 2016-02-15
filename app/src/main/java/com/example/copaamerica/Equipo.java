package com.example.copaamerica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class Equipo extends SQLiteOpenHelper{

	private final static String ID_Fila="idequipo";
	private final static String ID_EQUIPO1="equipo1";
	private final static String ID_EQUIPO2="equipo2";
	private static String DB_PATH = "/data/data/com.example.copaamerica/databases/";
	private final static String ID_Fila2="idequipo";
	private final static String ID_ELEGIDO2="elegido";
	private final static String ID_PAIS1="pais1";
	private final static String ID_PAIS2="pais2";
	private final static String ID_EQUIPO11="equipo1";
	private final static String ID_EQUIPO21="equipo2";
	private final static String ID_EQUIPOG1="equipog1";
	public final static String ID_NOTICINT="idint";
	public final static String ID_MENENG="mensaje";
	public final static String ID_FECHA="fecha";
	private final static String ID_EQUIPOG2="equipog2";
	public final static String ID_EQUIPOG3="val";
	private final static String ID_EQUIPOG4="cor";

	private final static String DB_NAME = "america.db";
	private final static String N_TABLA = "equipo";
	private final static String N_TABLA2 = "equipoelim";
	public final static String N_TABLAINT="notint";
	public final static String N_TABLA3="invrey";

	private SQLiteDatabase myDataBase; 
	private final Context myContext;
	DatabaseHelper dbHelper;


	public Equipo(Context context) {
		//el uno corresponde a la version de la base de datos; 
		// En mi caso es la primera versión 
		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}

	/**
	 * Comprueba si la base de datos existe para evitar copiar 
	 * siempre el fichero cada vez que se abra la aplicación.
	 */
	private boolean checkDataBase(){
		SQLiteDatabase checkDB = null;
		try{ 
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

		}catch(SQLiteException e){ 
			//si llegamos aqui es porque la base de datos no existe todavía. 
		}
		if(checkDB != null){
			checkDB.close();
		}
		return checkDB != null ? true : false;
	}

	/**
	 * Copia nuestra base de datos desde la carpeta assets a la recién creada
	 * base de datos en la carpeta de sistema, desde dónde podremos acceder a ella.
	 * */
	private void copyDataBase() throws IOException{
		//Abrimos el fichero de base de datos como entrada
		//A través del contexto accedemos a la carpeta assets
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		//Ruta a la base de datos vacía recién creada
		String outFileName = DB_PATH + DB_NAME;

		//Abrimos la base de datos vacía como salida
		OutputStream myOutput = new FileOutputStream(outFileName);

		//Transferimos los bytes desde el fichero de entrada al de salida
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer))>0)
		{
			myOutput.write(buffer, 0, length);
		}

		//Liberamos los streams
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	/**
	 * Crea una base de datos vacía en el sistema y la reescribe con nuestro fichero 
	 * de base de datos.
	 * */
	public void createDataBase() throws IOException{ 
		boolean dbExist = checkDataBase();

		if(dbExist){
			//la base de datos existe y no hacemos nada.
		}else{
			//Llamando a este método se crea la base de datos vacía en la ruta por defecto 
			//del sistema
			//de nuestra aplicación por lo que podremos sobreescribirla con nuestra base de datos.
			this.getReadableDatabase();

			try { 
				copyDataBase(); 
			}catch (IOException e) {
				throw new Error("Error copiando Base de Datos");
			}
		} 
	}

	/**
	 * Abre la base de datos
	 */
	public void open() throws SQLException{ 
		if(myDataBase==null || (!(myDataBase.isOpen())) ){ 
			try {
				createDataBase(); //Si no existe crea la base de datos, si existe no hace nada 
			} catch (IOException e) {
				throw new Error("Ha sido imposible crear la Base de Datos");
			}
			String myPath = DB_PATH + DB_NAME;
			myDataBase = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READWRITE);
		}
	}
	
	public void close(){
		myDataBase.close(); 
	}

	//***********************************************************************************
	
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		public DatabaseHelper(Context context) {
			super(context, DB_NAME, null, 1);
		}	

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + N_TABLA + " ( " + ID_Fila + " TEXT NOT NULL, " +
					ID_EQUIPO1 + " INTEGER NOT NULL, " +
					ID_EQUIPO2 + " INTEGER NOT NULL); ");
					
			db.execSQL("CREATE TABLE " + N_TABLA2 + " ( " + ID_Fila2 + " TEXT NOT NULL, " +
					ID_PAIS1 + " TEXT NOT NULL, " +
					ID_PAIS2 + " TEXT NOT NULL, " +
					ID_ELEGIDO2 + " TEXT NOT NULL, " +
					ID_EQUIPO11 + " INTEGER NOT NULL, " +
					ID_EQUIPO21 + " INTEGER NOT NULL, " +
					ID_EQUIPOG1	+ " INTEGER NOT NULL, " +
					ID_EQUIPOG2	+ " INTEGER NOT NULL); ");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + N_TABLA);
			db.execSQL("DROP TABLE IF EXISTS " + N_TABLA2);
			onCreate(db);
		}
	}

	public void insert(String idpartido,int equipo1,int equipo2)
	{
		ContentValues cv = new ContentValues();
		cv.put(ID_Fila, idpartido);
		cv.put(ID_EQUIPO1,equipo1);
		cv.put(ID_EQUIPO2,equipo2);
		//Insertamos el registro en la base de datos
		myDataBase.insert(N_TABLA, null, cv);
	}
	
	public void insertElim(String idpartido,String pais1,String pais2,String elegido,int equipo1,int equipo2,int equipog1,int equipog2)
	{
		ContentValues cv = new ContentValues();
		cv.put(ID_Fila2, idpartido);
		cv.put(ID_PAIS1, pais1);
		cv.put(ID_PAIS2, pais2);
		cv.put(ID_ELEGIDO2, elegido);
		cv.put(ID_EQUIPO11,equipo1);
		cv.put(ID_EQUIPO21,equipo2);
		cv.put(ID_EQUIPOG1,equipog1);
		cv.put(ID_EQUIPOG2,equipog2);
		//Insertamos el registro en la base de datos
		myDataBase.insert(N_TABLA2, null, cv);
	}

	public void insertNotInt(String mensaje,String fecha)
	{
		LinkedList<NotInt> l=obtenerNotInt();
		ContentValues cv = new ContentValues();
		cv.put(ID_NOTICINT,l.size()+1);
		cv.put(ID_MENENG,mensaje);
		cv.put(ID_FECHA, fecha);
		//Insertamos el registro en la base de datos
		myDataBase.insert(N_TABLAINT, null, cv);
	}
	
	public LinkedList<DTO> obtener()
	{
		LinkedList<DTO> list=new LinkedList<DTO>();
		String[] columnas=new String[]{ID_Fila,ID_EQUIPO1,ID_EQUIPO2};
		Cursor c=myDataBase.query(N_TABLA, columnas, null,null, null, null, null);
		int idequipo=c.getColumnIndex(ID_Fila);
		int equipo1=c.getColumnIndex(ID_EQUIPO1);
		int equipo2=c.getColumnIndex(ID_EQUIPO2);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			DTO dt=new DTO();
			String id=c.getString(idequipo); 
			int eq1=c.getInt(equipo1);
			int eq2=c.getInt(equipo2);
			dt.setPartido(id);
			dt.setGoles1(eq1);
			dt.setGoles2(eq2);
			list.add(dt);
		}
		return list;
	}
	
	public LinkedList<NotInt> obtenerNotInt() throws SQLException
	{
		LinkedList<NotInt> list=new LinkedList<NotInt>();
		String[] columnas=new String[]{ID_NOTICINT,ID_MENENG,ID_FECHA};
		Cursor c=myDataBase.query(N_TABLAINT, columnas, null,null, null, null, ID_NOTICINT + " DESC ");
		int id=c.getColumnIndex("idint");
		int mensaje=c.getColumnIndex("mensaje");
		int fecha=c.getColumnIndex("fecha");
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			NotInt dt=new NotInt();
			int idr=c.getInt(id); 
			String mensajer=c.getString(mensaje);
			String fechar=c.getString(fecha);
			dt.setLig(idr);
			dt.setMgs(mensajer);
			dt.setFecha(fechar);
			list.add(dt);
		}
		return list;
	}

	public void editarDTO(String partido, int goles1, int goles2) throws SQLException
	{
		ContentValues cvEditar=new ContentValues();
		cvEditar.put(ID_EQUIPO1, goles1);
		cvEditar.put(ID_EQUIPO2, goles2);
		//nBD.update(N_TABLA, cvEditar, ID_Fila + "=" + partido, null);
		myDataBase.update(N_TABLA2, cvEditar,"idequipo=?", new String[] { partido});
	}
	
	public void editarGoles(String gol) throws SQLException
	{
		try {
			ContentValues cvEditar=new ContentValues();
			cvEditar.put(ID_EQUIPOG4, gol);
			myDataBase.update(N_TABLA3, cvEditar,"val=?", new String[] { "108870427"});
		} catch (Exception e) {
			String sms=e.getMessage();
		}
		
	}
	
	public DTOE obtenerGoles()
	{
		DTOE list=new DTOE();
		String[] columnas=new String[]{ID_EQUIPOG3,ID_EQUIPOG4};
		Cursor c=myDataBase.query(N_TABLA3, columnas, null,null, null, null, null);
		int equipog1=c.getColumnIndex(ID_EQUIPOG3);
		int equipog2=c.getColumnIndex(ID_EQUIPOG4);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String el=c.getString(equipog2);
			String eqg2=c.getString(equipog1);
			int va=Integer.parseInt(eqg2);
			list.setGoles1(va);
			list.setGoles2(el);
		}
		return list;
	}
	
	public LinkedList<DTOElim> obtenerElim()
	{
		LinkedList<DTOElim> list=new LinkedList<DTOElim>();
		String[] columnas=new String[]{ID_Fila2,ID_PAIS1,ID_PAIS2,ID_ELEGIDO2,ID_EQUIPO1,ID_EQUIPO2,ID_EQUIPOG1,ID_EQUIPOG2};
		Cursor c=myDataBase.query(N_TABLA2, columnas, null,null, null, null, null);
		int idequipo=c.getColumnIndex(ID_Fila2);
		int pais1=c.getColumnIndex(ID_PAIS1);
		int pais2=c.getColumnIndex(ID_PAIS2);
		int elegido=c.getColumnIndex(ID_ELEGIDO2);
		int equipo1=c.getColumnIndex(ID_EQUIPO1);
		int equipo2=c.getColumnIndex(ID_EQUIPO2);
		int equipog1=c.getColumnIndex(ID_EQUIPOG1);
		int equipog2=c.getColumnIndex(ID_EQUIPOG2);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			DTOElim dt=new DTOElim();
			String id=c.getString(idequipo); 
			String pa1=c.getString(pais1);
			String pa2=c.getString(pais2);
			String el=c.getString(elegido);
			int eq1=c.getInt(equipo1);
			int eq2=c.getInt(equipo2);
			int eqg1=c.getInt(equipog1);
			int eqg2=c.getInt(equipog2);
			dt.setPartido(id);
			dt.setPais1(pa1);
			dt.setPais2(pa2);
			dt.setAceptado(el);
			dt.setGoles1(eq1);
			dt.setGoles2(eq2);
			dt.setEmpatev1(eqg1);
			dt.setEmpatev2(eqg2);
			list.add(dt);
		}
		return list;
	}

	public void EliminarDTO(String idpartido) throws SQLException
	{
		//nBD.delete(N_TABLA, ID_Fila + "=" + idpartido, null);
		String[] args = new String[]{idpartido};
		myDataBase.execSQL("DELETE FROM equipo WHERE idequipo=?", args);
	}
	
	public void EliminarDTOElim(String idpartido) throws SQLException
	{
		//nBD.delete(N_TABLA, ID_Fila + "=" + idpartido, null);
		String[] args = new String[]{idpartido};
		myDataBase.execSQL("DELETE FROM equipoelim WHERE idequipo=?", args);
	}
	
	public void EliminarTodoDTOElim() throws SQLException
	{
		myDataBase.execSQL("DELETE FROM equipoelim");
	}
	
	public void cerrar()
	{
		dbHelper.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	
}




