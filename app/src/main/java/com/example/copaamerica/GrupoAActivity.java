package com.example.copaamerica;

import java.util.LinkedList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GrupoAActivity extends Activity{
	public Button btnsalvar,btneditar;
	public EditText gat1,gat2,gat3,gat4,gat5,gat6,gat7,gat8,gat9,gat10,gat11,gat12;
	public TextView ptos1,ptos2,ptos3,ptos4,gfa1,gfa2,gfa3,gfa4,gca1,gca2,gca3,gca4;
	public int chile,mex,ecu,bol; 
	public int gfchi,gfmex,gfecu,gfbol;
	public int gcchi,gcmex,gcecu,gcbol;
	private Intent inten;
    
	protected void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clasif_fragment2);
		inten=new Intent(this, MainActivity.class);
		
		//Campos de la Tabla
		ptos1=(TextView)findViewById(R.id.textViewptsa1);
		ptos2=(TextView)findViewById(R.id.textViewptsa2);
		ptos3=(TextView)findViewById(R.id.textViewptsa3);
		ptos4=(TextView)findViewById(R.id.textViewptsa4);
		gfa1=(TextView)findViewById(R.id.textViewgfa1);
		gfa2=(TextView)findViewById(R.id.textViewgfa2);
		gfa3=(TextView)findViewById(R.id.textViewgfa3);
		gfa4=(TextView)findViewById(R.id.textViewgfa4);
		gca1=(TextView)findViewById(R.id.textViewgca1);
		gca2=(TextView)findViewById(R.id.textViewgca2);
		gca3=(TextView)findViewById(R.id.textViewgca3);
		gca4=(TextView)findViewById(R.id.textViewgca4);
		btnsalvar=(Button)findViewById(R.id.buttong1);
		btneditar=(Button)findViewById(R.id.buttone1);
		
		//Campos de cada partido
		gat1=(EditText)findViewById(R.id.editTextga1);
		gat2=(EditText)findViewById(R.id.editTextga2);
		gat3=(EditText)findViewById(R.id.editTextga3);
		gat4=(EditText)findViewById(R.id.editTextga4);
		gat5=(EditText)findViewById(R.id.editTextga5);
		gat6=(EditText)findViewById(R.id.editTextga6);
		gat7=(EditText)findViewById(R.id.editTextga7);
		gat8=(EditText)findViewById(R.id.editTextga8);
		gat9=(EditText)findViewById(R.id.editTextga9);
		gat10=(EditText)findViewById(R.id.editTextga10);
		gat11=(EditText)findViewById(R.id.editTextga11);
		gat12=(EditText)findViewById(R.id.editTextga12);
		
		
		chile=0;mex=0;ecu=0;bol=0;
		gfchi=0;gfmex=0;gfecu=0;gfbol=0;
		gcchi=0;gcmex=0;gcecu=0;gcbol=0;
//*********************************************************
		//Cargando en la interfaz los componentes.
//*********************************************************
		LinkedList<DTO> list=Controller.getInstancia().getListDTO(getApplicationContext());
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).getPartido().equals("ga1"))
				{
					DTO dt=list.get(i);
					gat1.setText(String.valueOf(dt.getGoles1()));
					gat1.setEnabled(false);
					gat2.setText(String.valueOf(dt.getGoles2()));
					gat2.setEnabled(false);
					int g1=dt.getGoles1();
					int g2=dt.getGoles2();
					if(g1>g2)
					{
						chile+=3;mex+=0;ecu+=0;bol+=0;
						gfchi+=g1;gfmex+=0;gfecu+=g2;gfbol+=0;
						gcchi-=g2;gcmex-=0;gcecu-=g1;gcbol-=0;
					}else
						if(g1<g2)
						{
							chile+=0;mex+=0;ecu+=3;bol+=0;
							gfchi+=g1;gfmex+=0;gfecu+=g2;gfbol+=0;
							gcchi-=g2;gcmex-=0;gcecu-=g1;gcbol-=0;
						}else
							if(g1==g2)
							{
								chile+=1;mex+=0;ecu+=1;bol+=0;
								gfchi+=g1;gfmex+=0;gfecu+=g2;gfbol+=0;
								gcchi-=g2;gcmex-=0;gcecu-=g1;gcbol-=0;
							}
				}
				else
				if(list.get(i).getPartido().equals("ga2"))
				{
					DTO dt=list.get(i);
					gat3.setText(String.valueOf(dt.getGoles1()));
					gat3.setEnabled(false);
					gat4.setText(String.valueOf(dt.getGoles2()));
					gat4.setEnabled(false);
					int g1=dt.getGoles1();
					int g2=dt.getGoles2();
					if(g1>g2)
					{
						chile+=0;mex+=3;ecu+=0;bol+=0;
						gfchi+=0;gfmex+=g1;gfecu+=0;gfbol+=g2;
						gcchi-=0;gcmex-=g2;gcecu-=0;gcbol-=g1;
					}else
						if(g1<g2)
						{
							chile+=0;mex+=0;ecu+=0;bol+=3;
							gfchi+=0;gfmex+=g1;gfecu+=0;gfbol+=g2;
							gcchi-=0;gcmex-=g2;gcecu-=0;gcbol-=g1;
						}else
							if(g1==g2)
							{
								chile+=0;mex+=1;ecu+=0;bol+=1;
								gfchi+=0;gfmex+=g1;gfecu+=0;gfbol+=g2;
								gcchi-=0;gcmex-=g2;gcecu-=0;gcbol-=g1;
							}
				}else
					if(list.get(i).getPartido().equals("ga3"))
					{
						DTO dt=list.get(i);
						gat5.setText(String.valueOf(dt.getGoles1()));
						gat5.setEnabled(false);
						gat6.setText(String.valueOf(dt.getGoles2()));
						gat6.setEnabled(false);
						int g1=dt.getGoles1();
						int g2=dt.getGoles2();
						if(g1>g2)
						{
							chile+=0;mex+=0;ecu+=3;bol+=0;
							gfchi+=0;gfmex+=0;gfecu+=g1;gfbol+=g2;
							gcchi-=0;gcmex-=0;gcecu-=g2;gcbol-=g1;
						}else
							if(g1<g2)
							{
								chile+=0;mex+=0;ecu+=0;bol+=3;
								gfchi+=0;gfmex+=0;gfecu+=g1;gfbol+=g2;
								gcchi-=0;gcmex-=0;gcecu-=g2;gcbol-=g1;
							}else
								if(g1==g2)
								{
									chile+=0;mex+=1;ecu+=0;bol+=1;
									gfchi+=0;gfmex+=g1;gfecu+=0;gfbol+=g2;
									gcchi-=0;gcmex-=g2;gcecu-=0;gcbol-=g1;
								}
					}else
						if(list.get(i).getPartido().equals("ga4"))
						{
							DTO dt=list.get(i);
							gat7.setText(String.valueOf(dt.getGoles1()));
							gat7.setEnabled(false);
							gat8.setText(String.valueOf(dt.getGoles2()));
							gat8.setEnabled(false);
							int g1=dt.getGoles1();
							int g2=dt.getGoles2();
							if(g1>g2)
							{
								chile+=3;mex+=0;ecu+=0;bol+=0;
								gfchi+=g1;gfmex+=g2;gfecu+=0;gfbol+=0;
								gcchi-=g2;gcmex-=g1;gcecu-=0;gcbol-=0;
							}else
								if(g1<g2)
								{
									chile+=0;mex+=3;ecu+=0;bol+=0;
									gfchi+=g1;gfmex+=g2;gfecu+=0;gfbol+=0;
									gcchi-=g2;gcmex-=g1;gcecu-=0;gcbol-=0;
								}else
									if(g1==g2)
									{
										chile+=1;mex+=1;ecu+=0;bol+=0;
										gfchi+=g1;gfmex+=g2;gfecu+=0;gfbol+=0;
										gcchi-=g2;gcmex-=g1;gcecu-=0;gcbol-=0;
									}
						}else
							if(list.get(i).getPartido().equals("ga5"))
							{
								DTO dt=list.get(i);
								gat9.setText(String.valueOf(dt.getGoles1()));
								gat9.setEnabled(false);
								gat10.setText(String.valueOf(dt.getGoles2()));
								gat10.setEnabled(false);
								int g1=dt.getGoles1();
								int g2=dt.getGoles2();
								if(g1>g2)
								{
									chile+=0;mex+=3;ecu+=0;bol+=0;
									gfchi+=0;gfmex+=g1;gfecu+=g2;gfbol+=0;
									gcchi-=0;gcmex-=g2;gcecu-=g1;gcbol-=0;
								}else
									if(g1<g2)
									{
										chile+=0;mex+=0;ecu+=3;bol+=0;
										gfchi+=0;gfmex+=g1;gfecu+=g2;gfbol+=0;
										gcchi-=0;gcmex-=g2;gcecu-=g1;gcbol-=0;
									}else
										if(g1==g2)
										{
											chile+=0;mex+=1;ecu+=1;bol+=0;
											gfchi+=0;gfmex+=g1;gfecu+=g2;gfbol+=0;
											gcchi-=0;gcmex-=g2;gcecu-=g1;gcbol-=0;
										}
							}else
								if(list.get(i).getPartido().equals("ga6"))
								{
									DTO dt=list.get(i);
									gat11.setText(String.valueOf(dt.getGoles1()));
									gat11.setEnabled(false);
									gat12.setText(String.valueOf(dt.getGoles2()));
									gat12.setEnabled(false);
									int g1=dt.getGoles1();
									int g2=dt.getGoles2();
									if(g1>g2)
									{
										chile+=3;mex+=0;ecu+=0;bol+=0;
										gfchi+=g1;gfmex+=0;gfecu+=0;gfbol+=g2;
										gcchi-=g2;gcmex-=0;gcecu-=0;gcbol-=g1;
									}else
										if(g1<g2)
										{
											chile+=0;mex+=0;ecu+=0;bol+=3;
											gfchi+=g1;gfmex+=0;gfecu+=g1;gfbol+=g2;
											gcchi-=g2;gcmex-=0;gcecu-=g2;gcbol-=g1;
										}else
											if(g1==g2)
											{
												chile+=1;mex+=0;ecu+=0;bol+=1;
												gfchi+=g1;gfmex+=0;gfecu+=0;gfbol+=g2;
												gcchi-=g2;gcmex-=0;gcecu-=0;gcbol-=g1;
											}
								}						
					}
			ptos1.setText(String.valueOf(chile));gfa1.setText(String.valueOf(gfchi));gca1.setText(String.valueOf(gcchi));
			ptos2.setText(String.valueOf(mex));gfa2.setText(String.valueOf(gfmex));gca2.setText(String.valueOf(gcmex));
			ptos3.setText(String.valueOf(ecu));gfa3.setText(String.valueOf(gfecu));gca3.setText(String.valueOf(gcecu));
			ptos4.setText(String.valueOf(bol));gfa4.setText(String.valueOf(gfbol));gca4.setText(String.valueOf(gcbol));
			}else
				if(list.size()==0)
				{}
			
//*********************************************************			
		//Salvando elementos mediante el boton "Salvar".
//*********************************************************
		btnsalvar.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final LinkedList<DTO> listDTO=Controller.getInstancia().getListDTO(getApplicationContext());
				
				if(gat1.length()!=0 && gat2.length()!=0 && gat1.isEnabled()!=false && gat2.isEnabled()!=false)
				{
					DTO dt=new DTO();
					dt.setPartido("ga1");
					int g1=Integer.parseInt(gat1.getEditableText().toString());
					int g2=Integer.parseInt(gat2.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						chile+=3;mex+=0;ecu+=0;bol+=0;
						gfchi+=g1;gfmex+=0;gfecu+=g2;gfbol+=0;
						gcchi-=g2;gcmex-=0;gcecu-=g1;gcbol-=0;
					}else
						if(g1<g2)
						{
							chile+=0;mex+=0;ecu+=3;bol+=0;
							gfchi+=g1;gfmex+=0;gfecu+=g2;gfbol+=0;
							gcchi-=g2;gcmex-=0;gcecu-=g1;gcbol-=0;
						}else
							if(g1==g2)
							{
								chile+=1;mex+=0;ecu+=1;bol+=0;
								gfchi+=g1;gfmex+=0;gfecu+=g2;gfbol+=0;
								gcchi-=g2;gcmex-=0;gcecu-=g1;gcbol-=0;
							}
					gat1.setEnabled(false);
					gat2.setEnabled(false);
					listDTO.add(dt);
				}
				
				if(gat3.length()!=0 && gat4.length()!=0  && gat3.isEnabled()!=false && gat4.isEnabled()!=false)
				{
					
					DTO dt=new DTO();
					dt.setPartido("ga2");
					int g1=Integer.parseInt(gat3.getEditableText().toString());
					int g2=Integer.parseInt(gat4.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						chile+=0;mex+=3;ecu+=0;bol+=0;
						gfchi+=0;gfmex+=g1;gfecu+=0;gfbol+=g2;
						gcchi-=0;gcmex-=g2;gcecu-=0;gcbol-=g1;
					}else
						if(g1<g2)
						{
							chile+=0;mex+=0;ecu+=0;bol+=3;
							gfchi+=0;gfmex+=g1;gfecu+=0;gfbol+=g2;
							gcchi-=0;gcmex-=g2;gcecu-=0;gcbol-=g1;
						}else
							if(g1==g2)
							{
								chile+=0;mex+=1;ecu+=0;bol+=1;
								gfchi+=0;gfmex+=g1;gfecu+=0;gfbol+=g2;
								gcchi-=0;gcmex-=g2;gcecu-=0;gcbol-=g1;
							}
					gat3.setEnabled(false);
					gat4.setEnabled(false);
					listDTO.add(dt);
				}
				
				if((gat5.length()!=0 && gat6.length()!=0)  && (gat5.isEnabled()!=false && gat6.isEnabled()!=false))
				{
					
					DTO dt=new DTO();
					dt.setPartido("ga3");
					int g1=Integer.parseInt(gat5.getEditableText().toString());
					int g2=Integer.parseInt(gat6.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						chile+=0;mex+=0;ecu+=3;bol+=0;
						gfchi+=0;gfmex+=0;gfecu+=g1;gfbol+=g2;
						gcchi-=0;gcmex-=0;gcecu-=g2;gcbol-=g1;
					}else
						if(g1<g2)
						{
							chile+=0;mex+=0;ecu+=0;bol+=3;
							gfchi+=0;gfmex+=0;gfecu+=g1;gfbol+=g2;
							gcchi-=0;gcmex-=0;gcecu-=g2;gcbol-=g1;
						}else
							if(g1==g2)
							{
								chile+=0;mex+=1;ecu+=0;bol+=1;
								gfchi+=0;gfmex+=g1;gfecu+=0;gfbol+=g2;
								gcchi-=0;gcmex-=g2;gcecu-=0;gcbol-=g1;
							}
					gat5.setEnabled(false);
					gat6.setEnabled(false);
					listDTO.add(dt);
				}
				
				if(gat7.length()!=0 && gat8.length()!=0 && gat7.isEnabled()!=false && gat8.isEnabled()!=false)
				{
					
					DTO dt=new DTO();
					dt.setPartido("ga4");
					int g1=Integer.parseInt(gat7.getEditableText().toString());
					int g2=Integer.parseInt(gat8.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						chile+=3;mex+=0;ecu+=0;bol+=0;
						gfchi+=g1;gfmex+=g2;gfecu+=0;gfbol+=0;
						gcchi-=g2;gcmex-=g1;gcecu-=0;gcbol-=0;
					}else
						if(g1<g2)
						{
							chile+=0;mex+=3;ecu+=0;bol+=0;
							gfchi+=g1;gfmex+=g2;gfecu+=0;gfbol+=0;
							gcchi-=g2;gcmex-=g1;gcecu-=0;gcbol-=0;
						}else
							if(g1==g2)
							{
								chile+=1;mex+=1;ecu+=0;bol+=0;
								gfchi+=g1;gfmex+=g2;gfecu+=0;gfbol+=0;
								gcchi-=g2;gcmex-=g1;gcecu-=0;gcbol-=0;
							}
					gat7.setEnabled(false);
					gat8.setEnabled(false);
					listDTO.add(dt);
				}
				
				if((gat9.length()!=0 && gat10.length()!=0) && (gat9.isEnabled()!=false && gat10.isEnabled()!=false))			{
					
					DTO dt=new DTO();
					dt.setPartido("ga5");
					int g1=Integer.parseInt(gat9.getEditableText().toString());
					int g2=Integer.parseInt(gat10.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						chile+=0;mex+=3;ecu+=0;bol+=0;
						gfchi+=0;gfmex+=g1;gfecu+=g2;gfbol+=0;
						gcchi-=0;gcmex-=g2;gcecu-=g1;gcbol-=0;
					}else
						if(g1<g2)
						{
							chile+=0;mex+=0;ecu+=3;bol+=0;
							gfchi+=0;gfmex+=g1;gfecu+=g2;gfbol+=0;
							gcchi-=0;gcmex-=g2;gcecu-=g1;gcbol-=0;
						}else
							if(g1==g2)
							{
								chile+=0;mex+=1;ecu+=1;bol+=0;
								gfchi+=0;gfmex+=g1;gfecu+=g2;gfbol+=0;
								gcchi-=0;gcmex-=g2;gcecu-=g1;gcbol-=0;
							}
					gat9.setEnabled(false);
					gat10.setEnabled(false);
					listDTO.add(dt);
				}
				
				if((gat11.length()!=0 && gat12.length()!=0) && (gat11.isEnabled()!=false && gat12.isEnabled()!=false))
				{
					
					DTO dt=new DTO();
					dt.setPartido("ga6");
					int g1=Integer.parseInt(gat11.getEditableText().toString());
					int g2=Integer.parseInt(gat12.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						chile+=3;mex+=0;ecu+=0;bol+=0;
						gfchi+=g1;gfmex+=0;gfecu+=0;gfbol+=g2;
						gcchi-=g2;gcmex-=0;gcecu-=0;gcbol-=g1;
					}else
						if(g1<g2)
						{
							chile+=0;mex+=0;ecu+=0;bol+=3;
							gfchi+=g1;gfmex+=0;gfecu+=g1;gfbol+=g2;
							gcchi-=g2;gcmex-=0;gcecu-=g2;gcbol-=g1;
						}else
							if(g1==g2)
							{
								chile+=1;mex+=0;ecu+=0;bol+=1;
								gfchi+=g1;gfmex+=0;gfecu+=0;gfbol+=g2;
								gcchi-=g2;gcmex-=0;gcecu-=0;gcbol-=g1;
							}
					gat11.setEnabled(false);
					gat12.setEnabled(false);
					listDTO.add(dt);
				}
				
				ptos1.setText(String.valueOf(chile));gfa1.setText(String.valueOf(gfchi));gca1.setText(String.valueOf(gcchi));
				ptos2.setText(String.valueOf(mex));gfa2.setText(String.valueOf(gfmex));gca2.setText(String.valueOf(gcmex));
				ptos3.setText(String.valueOf(ecu));gfa3.setText(String.valueOf(gfecu));gca3.setText(String.valueOf(gcecu));
				ptos4.setText(String.valueOf(bol));gfa4.setText(String.valueOf(gfbol));gca4.setText(String.valueOf(gcbol));
				
				if(listDTO.size()!=0)
				{
					for(int i=0;i<listDTO.size();i++)
					{
						if(listDTO.get(i).getPartido().equals("ga1"))
						{
							DTO dt=listDTO.get(i);
							Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
							gat1.setEnabled(false);
							gat2.setEnabled(false);
						}else
							if(listDTO.get(i).getPartido().equals("ga2"))
							{
								DTO dt=listDTO.get(i);
								Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
								gat3.setEnabled(false);
								gat4.setEnabled(false);
							}else
								if(listDTO.get(i).getPartido().equals("ga3"))
								{
									DTO dt=listDTO.get(i);
									Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
									gat5.setEnabled(false);
									gat6.setEnabled(false);
								}else
									if(listDTO.get(i).getPartido().equals("ga4"))
									{
										DTO dt=listDTO.get(i);
										Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
										gat7.setEnabled(false);
										gat8.setEnabled(false);
									}else
										if(listDTO.get(i).getPartido().equals("ga5"))
										{
											DTO dt=listDTO.get(i);
											Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
											gat9.setEnabled(false);
											gat10.setEnabled(false);
										}else
											if(listDTO.get(i).getPartido().equals("ga6"))
											{
												DTO dt=listDTO.get(i);
												Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
												gat11.setEnabled(false);
												gat12.setEnabled(false);
											}
					}
					ptos1.setText(String.valueOf(chile));gfa1.setText(String.valueOf(gfchi));gca1.setText(String.valueOf(gcchi));
					ptos2.setText(String.valueOf(mex));gfa2.setText(String.valueOf(gfmex));gca2.setText(String.valueOf(gcmex));
					ptos3.setText(String.valueOf(ecu));gfa3.setText(String.valueOf(gfecu));gca3.setText(String.valueOf(gcecu));
					ptos4.setText(String.valueOf(bol));gfa4.setText(String.valueOf(gfbol));gca4.setText(String.valueOf(gcbol));
					listDTO.clear();
				}
			}
		});
		//*********************************************************			
		//Inicializando con el boton "Enviar".
	//*********************************************************			
				
				btneditar.setOnClickListener(new OnClickListener() {
					
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						new AlertDialog.Builder(arg0.getContext()).setTitle("Confirme si desea limpiar los datos del grupo A")
						.setPositiveButton("Si",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int whichButton) {
						
						ptos1.setText(String.valueOf(0));gfa1.setText(String.valueOf(0));gca1.setText(String.valueOf(0));
						ptos2.setText(String.valueOf(0));gfa2.setText(String.valueOf(0));gca2.setText(String.valueOf(0));
						ptos3.setText(String.valueOf(0));gfa3.setText(String.valueOf(0));gca3.setText(String.valueOf(0));
						ptos4.setText(String.valueOf(0));gfa4.setText(String.valueOf(0));gca4.setText(String.valueOf(0));
						gat1.getText().clear();gat4.getText().clear();gat7.getText().clear();gat10.getText().clear();
						gat2.getText().clear();gat5.getText().clear();gat8.getText().clear();gat11.getText().clear();
						gat3.getText().clear();gat6.getText().clear();gat9.getText().clear();gat12.getText().clear();
						gat1.setEnabled(true);
						gat2.setEnabled(true);
						gat3.setEnabled(true);
						gat4.setEnabled(true);
						gat5.setEnabled(true);
						gat6.setEnabled(true);
						gat7.setEnabled(true);
						gat8.setEnabled(true);
						gat9.setEnabled(true);
						gat10.setEnabled(true);
						gat11.setEnabled(true);
						gat12.setEnabled(true);
						chile=0;mex=0;ecu=0;bol=0;
						gfchi=0;gfmex=0;gfecu=0;gfbol=0;
						gcchi=0;gcmex=0;gcecu=0;gcbol=0;
						try 
						{
							LinkedList<DTO> lista=Controller.getInstancia().getListDTO(getApplicationContext());
							if(!lista.isEmpty())
							{	
								for (int i = 0; i < lista.size(); i++) 
								{
									if(lista.get(i).getPartido().equalsIgnoreCase("ga1"))
									{
										Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
									}else
										if(lista.get(i).getPartido().equalsIgnoreCase("ga2"))
										{
											Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
										}else
											if(lista.get(i).getPartido().equalsIgnoreCase("ga3"))
											{
												Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
											}else
												if(lista.get(i).getPartido().equalsIgnoreCase("ga4"))
												{
													Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
												}else
													if(lista.get(i).getPartido().equalsIgnoreCase("ga5"))
													{
														Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
													}else
														if(lista.get(i).getPartido().equalsIgnoreCase("ga6"))
														{
															Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
														}
									}
								}
						} catch (Exception e1) {
							// TODO: handle exception
						}
						Controller.getInstancia().getListDTO(getApplicationContext()).clear();
						}
						}).setNegativeButton("No", null).show();
					}
				});			

				
		//*********************************************************
		}
	public void onBackPressed() 
	{
	   inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	   startActivity(new Intent(inten));	
	   this.finish();
	   return;
	}
}
