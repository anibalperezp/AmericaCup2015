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

public class GrupoBActivity extends Activity{
	public Button btnsalvar,btneditar;
	public EditText gat1,gat2,gat3,gat4,gat5,gat6,gat7,gat8,gat9,gat10,gat11,gat12;
	public TextView ptos1,ptos2,ptos3,ptos4,gfa1,gfa2,gfa3,gfa4,gca1,gca2,gca3,gca4;
	public int arg,uru,par,jam; 
	public int gfarg,gfuru,gfpar,gfjam;
	public int gcarg,gcuru,gcpar,gcjam;
	private Intent inten;
    
	protected void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clasif_fragment3);
		inten=new Intent(this, MainActivity.class);
		
		//Campos de la Tabla
		ptos1=(TextView)findViewById(R.id.textViewptsb1);
		ptos2=(TextView)findViewById(R.id.textViewptsb2);
		ptos3=(TextView)findViewById(R.id.textViewptsb3);
		ptos4=(TextView)findViewById(R.id.textViewptsb4);
		gfa1=(TextView)findViewById(R.id.textViewgfb1);
		gfa2=(TextView)findViewById(R.id.textViewgfb2);
		gfa3=(TextView)findViewById(R.id.textViewgfb3);
		gfa4=(TextView)findViewById(R.id.textViewgfb4);
		gca1=(TextView)findViewById(R.id.textViewgcb1);
		gca2=(TextView)findViewById(R.id.textViewgcb2);
		gca3=(TextView)findViewById(R.id.textViewgcb3);
		gca4=(TextView)findViewById(R.id.textViewgcb4);
		btnsalvar=(Button)findViewById(R.id.buttong2);
		btneditar=(Button)findViewById(R.id.buttone2);
		
		//Campos de cada partido
		gat1=(EditText)findViewById(R.id.editTextgb1);
		gat2=(EditText)findViewById(R.id.editTextgb2);
		gat3=(EditText)findViewById(R.id.editTextgb3);
		gat4=(EditText)findViewById(R.id.editTextgb4);
		gat5=(EditText)findViewById(R.id.editTextgb5);
		gat6=(EditText)findViewById(R.id.editTextgb6);
		gat7=(EditText)findViewById(R.id.editTextgb7);
		gat8=(EditText)findViewById(R.id.editTextgb8);
		gat9=(EditText)findViewById(R.id.editTextgb9);
		gat10=(EditText)findViewById(R.id.editTextgb10);
		gat11=(EditText)findViewById(R.id.editTextgb11);
		gat12=(EditText)findViewById(R.id.editTextgb12);
		
		
		arg=0;uru=0;par=0;jam=0;
		gfarg=0;gfuru=0;gfpar=0;gfjam=0;
		gcarg=0;gcuru=0;gcpar=0;gcjam=0;
//*********************************************************
		//Cargando en la interfaz los componentes.
//*********************************************************
		LinkedList<DTO> list=Controller.getInstancia().getListDTO(getApplicationContext());
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).getPartido().equals("gb1"))
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
						arg+=0;uru+=3;par+=0;jam+=0;
						gfarg+=0;gfuru+=g1;gfpar+=0;gfjam+=g2;
						gcarg-=0;gcuru-=g2;gcpar-=0;gcjam-=g1;
					}else
						if(g1<g2)
						{
							arg+=0;uru+=0;par+=0;jam+=3;
							gfarg+=0;gfuru+=g1;gfpar+=0;gfjam+=g2;
							gcarg-=0;gcuru-=g2;gcpar-=0;gcjam-=g1;
						}else
							if(g1==g2)
							{
								arg+=0;uru+=1;par+=0;jam+=1;
								gfarg+=0;gfuru+=g1;gfpar+=0;gfjam+=g2;
								gcarg-=0;gcuru-=g2;gcpar-=0;gcjam-=g1;
							}
				}
				else
				if(list.get(i).getPartido().equals("gb2"))
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
						arg+=3;uru+=0;par+=0;jam+=0;
						gfarg+=g1;gfuru+=0;gfpar+=g2;gfjam+=0;
						gcarg-=g2;gcuru-=0;gcpar-=g1;gcjam-=0;
					}else
						if(g1<g2)
						{
							arg+=0;uru+=0;par+=3;jam+=0;
							gfarg+=g1;gfuru+=0;gfpar+=g2;gfjam+=0;
							gcarg-=g2;gcuru-=0;gcpar-=g1;gcjam-=0;
						}else
							if(g1==g2)
							{
								arg+=1;uru+=0;par+=1;jam+=0;
								gfarg+=g1;gfuru+=0;gfpar+=g2;gfjam+=0;
								gcarg-=g2;gcuru-=0;gcpar-=g1;gcjam-=0;
							}
				}else
					if(list.get(i).getPartido().equals("gb3"))
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
							arg+=0;uru+=0;par+=3;jam+=0;
							gfarg+=0;gfuru+=0;gfpar+=g1;gfjam+=g2;
							gcarg-=0;gcuru-=0;gcpar-=g2;gcjam-=g1;
						}else
							if(g1<g2)
							{
								arg+=0;uru+=0;par+=0;jam+=3;
								gfarg+=0;gfuru+=0;gfpar+=g1;gfjam+=g2;
								gcarg-=0;gcuru-=0;gcpar-=g2;gcjam-=g1;
							}else
								if(g1==g2)
								{
									arg+=0;uru+=0;par+=1;jam+=1;
									gfarg+=0;gfuru+=0;gfpar+=g1;gfjam+=g2;
									gcarg-=0;gcuru-=0;gcpar-=g2;gcjam-=g1;
								}
					}else
						if(list.get(i).getPartido().equals("gb4"))
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
								arg+=3;uru+=0;par+=0;jam+=0;
								gfarg+=g1;gfuru+=g2;gfpar+=0;gfjam+=0;
								gcarg-=g2;gcuru-=g1;gcpar-=0;gcjam-=0;
							}else
								if(g1<g2)
								{
									arg+=0;uru+=3;par+=0;jam+=0;
									gfarg+=g1;gfuru+=g2;gfpar+=0;gfjam+=0;
									gcarg-=g2;gcuru-=g1;gcpar-=0;gcjam-=0;
								}else
									if(g1==g2)
									{
										arg+=1;uru+=1;par+=0;jam+=0;
										gfarg+=g1;gfuru+=g2;gfpar+=0;gfjam+=0;
										gcarg-=g2;gcuru-=g1;gcpar-=0;gcjam-=0;
									}
						}else
							if(list.get(i).getPartido().equals("gb5"))
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
									arg+=0;uru+=3;par+=0;jam+=0;
									gfarg+=0;gfuru+=g1;gfpar+=g2;gfjam+=0;
									gcarg-=0;gcuru-=g2;gcpar-=g1;gcjam-=0;
								}else
									if(g1<g2)
									{
										arg+=0;uru+=0;par+=3;jam+=0;
										gfarg+=0;gfuru+=g1;gfpar+=g2;gfjam+=0;
										gcarg-=0;gcuru-=g2;gcpar-=g1;gcjam-=0;
									}else
										if(g1==g2)
										{
											arg+=0;uru+=1;par+=1;jam+=0;
											gfarg+=0;gfuru+=g1;gfpar+=g2;gfjam+=0;
											gcarg-=0;gcuru-=g2;gcpar-=g1;gcjam-=0;
										}
							}else
								if(list.get(i).getPartido().equals("gb6"))
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
										arg+=3;uru+=0;par+=0;jam+=0;
										gfarg+=g1;gfuru+=0;gfpar+=0;gfjam+=g2;
										gcarg-=g2;gcuru-=0;gcpar-=0;gcjam-=g1;
									}else
										if(g1<g2)
										{
											arg+=0;uru+=0;par+=0;jam+=3;
											gfarg+=g1;gfuru+=0;gfpar+=0;gfjam+=g2;
											gcarg-=g2;gcuru-=0;gcpar-=0;gcjam-=g1;
										}else
											if(g1==g2)
											{
												arg+=1;uru+=0;par+=0;jam+=1;
												gfarg+=g1;gfuru+=0;gfpar+=0;gfjam+=g2;
												gcarg-=g2;gcuru-=0;gcpar-=0;gcjam-=g1;
											}
								}						
					}
			ptos1.setText(String.valueOf(arg));gfa1.setText(String.valueOf(gfarg));gca1.setText(String.valueOf(gcarg));
			ptos2.setText(String.valueOf(uru));gfa2.setText(String.valueOf(gfuru));gca2.setText(String.valueOf(gcuru));
			ptos3.setText(String.valueOf(par));gfa3.setText(String.valueOf(gfpar));gca3.setText(String.valueOf(gcpar));
			ptos4.setText(String.valueOf(jam));gfa4.setText(String.valueOf(gfjam));gca4.setText(String.valueOf(gcjam));
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
					dt.setPartido("gb1");
					int g1=Integer.parseInt(gat1.getEditableText().toString());
					int g2=Integer.parseInt(gat2.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						arg+=0;uru+=3;par+=0;jam+=0;
						gfarg+=0;gfuru+=g1;gfpar+=0;gfjam+=g2;
						gcarg-=0;gcuru-=g2;gcpar-=0;gcjam-=g1;
					}else
						if(g1<g2)
						{
							arg+=0;uru+=0;par+=0;jam+=3;
							gfarg+=0;gfuru+=g1;gfpar+=0;gfjam+=g2;
							gcarg-=0;gcuru-=g2;gcpar-=0;gcjam-=g1;
						}else
							if(g1==g2)
							{
								arg+=0;uru+=1;par+=0;jam+=1;
								gfarg+=0;gfuru+=g1;gfpar+=0;gfjam+=g2;
								gcarg-=0;gcuru-=g2;gcpar-=0;gcjam-=g1;
							}
					gat1.setEnabled(false);
					gat2.setEnabled(false);
					listDTO.add(dt);
				}
				
				if(gat3.length()!=0 && gat4.length()!=0  && gat3.isEnabled()!=false && gat4.isEnabled()!=false)
				{
					
					DTO dt=new DTO();
					dt.setPartido("gb2");
					int g1=Integer.parseInt(gat3.getEditableText().toString());
					int g2=Integer.parseInt(gat4.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						arg+=3;uru+=0;par+=0;jam+=0;
						gfarg+=g1;gfuru+=0;gfpar+=g2;gfjam+=0;
						gcarg-=g2;gcuru-=0;gcpar-=g1;gcjam-=0;
					}else
						if(g1<g2)
						{
							arg+=0;uru+=0;par+=3;jam+=0;
							gfarg+=g1;gfuru+=0;gfpar+=g2;gfjam+=0;
							gcarg-=g2;gcuru-=0;gcpar-=g1;gcjam-=0;
						}else
							if(g1==g2)
							{
								arg+=1;uru+=0;par+=1;jam+=0;
								gfarg+=g1;gfuru+=0;gfpar+=g2;gfjam+=0;
								gcarg-=g2;gcuru-=0;gcpar-=g1;gcjam-=0;
							}
					gat3.setEnabled(false);
					gat4.setEnabled(false);
					listDTO.add(dt);
				}
				
				if((gat5.length()!=0 && gat6.length()!=0)  && (gat5.isEnabled()!=false && gat6.isEnabled()!=false))
				{
					
					DTO dt=new DTO();
					dt.setPartido("gb3");
					int g1=Integer.parseInt(gat5.getEditableText().toString());
					int g2=Integer.parseInt(gat6.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						arg+=0;uru+=0;par+=3;jam+=0;
						gfarg+=0;gfuru+=0;gfpar+=g1;gfjam+=g2;
						gcarg-=0;gcuru-=0;gcpar-=g2;gcjam-=g1;
					}else
						if(g1<g2)
						{
							arg+=0;uru+=0;par+=0;jam+=3;
							gfarg+=0;gfuru+=0;gfpar+=g1;gfjam+=g2;
							gcarg-=0;gcuru-=0;gcpar-=g2;gcjam-=g1;
						}else
							if(g1==g2)
							{
								arg+=0;uru+=0;par+=1;jam+=1;
								gfarg+=0;gfuru+=0;gfpar+=g1;gfjam+=g2;
								gcarg-=0;gcuru-=0;gcpar-=g2;gcjam-=g1;
							}
					gat5.setEnabled(false);
					gat6.setEnabled(false);
					listDTO.add(dt);
				}
				
				if(gat7.length()!=0 && gat8.length()!=0 && gat7.isEnabled()!=false && gat8.isEnabled()!=false)
				{
					
					DTO dt=new DTO();
					dt.setPartido("gb4");
					int g1=Integer.parseInt(gat7.getEditableText().toString());
					int g2=Integer.parseInt(gat8.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						arg+=3;uru+=0;par+=0;jam+=0;
						gfarg+=g1;gfuru+=g2;gfpar+=0;gfjam+=0;
						gcarg-=g2;gcuru-=g1;gcpar-=0;gcjam-=0;
					}else
						if(g1<g2)
						{
							arg+=0;uru+=3;par+=0;jam+=0;
							gfarg+=g1;gfuru+=g2;gfpar+=0;gfjam+=0;
							gcarg-=g2;gcuru-=g1;gcpar-=0;gcjam-=0;
						}else
							if(g1==g2)
							{
								arg+=1;uru+=1;par+=0;jam+=0;
								gfarg+=g1;gfuru+=g2;gfpar+=0;gfjam+=0;
								gcarg-=g2;gcuru-=g1;gcpar-=0;gcjam-=0;
							}
					gat7.setEnabled(false);
					gat8.setEnabled(false);
					listDTO.add(dt);
				}
				
				if((gat9.length()!=0 && gat10.length()!=0) && (gat9.isEnabled()!=false && gat10.isEnabled()!=false))			{
					
					DTO dt=new DTO();
					dt.setPartido("gb5");
					int g1=Integer.parseInt(gat9.getEditableText().toString());
					int g2=Integer.parseInt(gat10.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						arg+=0;uru+=3;par+=0;jam+=0;
						gfarg+=0;gfuru+=g1;gfpar+=g2;gfjam+=0;
						gcarg-=0;gcuru-=g2;gcpar-=g1;gcjam-=0;
					}else
						if(g1<g2)
						{
							arg+=0;uru+=0;par+=3;jam+=0;
							gfarg+=0;gfuru+=g1;gfpar+=g2;gfjam+=0;
							gcarg-=0;gcuru-=g2;gcpar-=g1;gcjam-=0;
						}else
							if(g1==g2)
							{
								arg+=0;uru+=1;par+=1;jam+=0;
								gfarg+=0;gfuru+=g1;gfpar+=g2;gfjam+=0;
								gcarg-=0;gcuru-=g2;gcpar-=g1;gcjam-=0;
							}
					gat9.setEnabled(false);
					gat10.setEnabled(false);
					listDTO.add(dt);
				}
				
				if((gat11.length()!=0 && gat12.length()!=0) && (gat11.isEnabled()!=false && gat12.isEnabled()!=false))
				{
					
					DTO dt=new DTO();
					dt.setPartido("gb6");
					int g1=Integer.parseInt(gat11.getEditableText().toString());
					int g2=Integer.parseInt(gat12.getEditableText().toString());
					dt.setInsertado(true);
					dt.setGoles1(g1);
					dt.setGoles2(g2);
					if(g1>g2)
					{
						arg+=3;uru+=0;par+=0;jam+=0;
						gfarg+=g1;gfuru+=0;gfpar+=0;gfjam+=g2;
						gcarg-=g2;gcuru-=0;gcpar-=0;gcjam-=g1;
					}else
						if(g1<g2)
						{
							arg+=0;uru+=0;par+=0;jam+=3;
							gfarg+=g1;gfuru+=0;gfpar+=0;gfjam+=g2;
							gcarg-=g2;gcuru-=0;gcpar-=0;gcjam-=g1;
						}else
							if(g1==g2)
							{
								arg+=1;uru+=0;par+=0;jam+=1;
								gfarg+=g1;gfuru+=0;gfpar+=0;gfjam+=g2;
								gcarg-=g2;gcuru-=0;gcpar-=0;gcjam-=g1;
							}
					gat11.setEnabled(false);
					gat12.setEnabled(false);
					listDTO.add(dt);
				}
				
				ptos1.setText(String.valueOf(arg));gfa1.setText(String.valueOf(gfarg));gca1.setText(String.valueOf(gcarg));
				ptos2.setText(String.valueOf(uru));gfa2.setText(String.valueOf(gfuru));gca2.setText(String.valueOf(gcuru));
				ptos3.setText(String.valueOf(par));gfa3.setText(String.valueOf(gfpar));gca3.setText(String.valueOf(gcpar));
				ptos4.setText(String.valueOf(jam));gfa4.setText(String.valueOf(gfjam));gca4.setText(String.valueOf(gcjam));
				
				if(listDTO.size()!=0)
				{
					for(int i=0;i<listDTO.size();i++)
					{
						if(listDTO.get(i).getPartido().equals("gb1"))
						{
							DTO dt=listDTO.get(i);
							Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
							gat1.setEnabled(false);
							gat2.setEnabled(false);
						}else
							if(listDTO.get(i).getPartido().equals("gb2"))
							{
								DTO dt=listDTO.get(i);
								Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
								gat3.setEnabled(false);
								gat4.setEnabled(false);
							}else
								if(listDTO.get(i).getPartido().equals("gb3"))
								{
									DTO dt=listDTO.get(i);
									Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
									gat5.setEnabled(false);
									gat6.setEnabled(false);
								}else
									if(listDTO.get(i).getPartido().equals("gb4"))
									{
										DTO dt=listDTO.get(i);
										Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
										gat7.setEnabled(false);
										gat8.setEnabled(false);
									}else
										if(listDTO.get(i).getPartido().equals("gb5"))
										{
											DTO dt=listDTO.get(i);
											Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
											gat9.setEnabled(false);
											gat10.setEnabled(false);
										}else
											if(listDTO.get(i).getPartido().equals("gb6"))
											{
												DTO dt=listDTO.get(i);
												Controller.getInstancia().insertDTO(getApplicationContext(),dt.getPartido(), dt.getGoles1(), dt.getGoles2());
												gat11.setEnabled(false);
												gat12.setEnabled(false);
											}
					}
					ptos1.setText(String.valueOf(arg));gfa1.setText(String.valueOf(gfarg));gca1.setText(String.valueOf(gcarg));
					ptos2.setText(String.valueOf(uru));gfa2.setText(String.valueOf(gfuru));gca2.setText(String.valueOf(gcuru));
					ptos3.setText(String.valueOf(par));gfa3.setText(String.valueOf(gfpar));gca3.setText(String.valueOf(gcpar));
					ptos4.setText(String.valueOf(jam));gfa4.setText(String.valueOf(gfjam));gca4.setText(String.valueOf(gcjam));
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
						new AlertDialog.Builder(arg0.getContext()).setTitle("Confirme si desea limpiar los datos del grupo B")
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
						arg=0;uru=0;par=0;jam=0;
						gfarg=0;gfuru=0;gfpar=0;gfjam=0;
						gcarg=0;gcuru=0;gcpar=0;gcjam=0;
						try 
						{
							LinkedList<DTO> lista=Controller.getInstancia().getListDTO(getApplicationContext());
							if(!lista.isEmpty())
							{	
								for (int i = 0; i < lista.size(); i++) 
								{
									if(lista.get(i).getPartido().equalsIgnoreCase("gb1"))
									{
										Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
									}else
										if(lista.get(i).getPartido().equalsIgnoreCase("gb2"))
										{
											Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
										}else
											if(lista.get(i).getPartido().equalsIgnoreCase("gb3"))
											{
												Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
											}else
												if(lista.get(i).getPartido().equalsIgnoreCase("gb4"))
												{
													Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
												}else
													if(lista.get(i).getPartido().equalsIgnoreCase("gb5"))
													{
														Controller.getInstancia().DeleteD(getApplicationContext(),lista.get(i).getPartido());
													}else
														if(lista.get(i).getPartido().equalsIgnoreCase("gb6"))
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
