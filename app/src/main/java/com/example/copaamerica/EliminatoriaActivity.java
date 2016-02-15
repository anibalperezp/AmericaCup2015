package com.example.copaamerica;

import java.util.LinkedList;
import java.util.Locale;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import com.example.copaamerica.R;

public class EliminatoriaActivity extends FragmentActivity {

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	private Intent inten;
	protected void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eliminatoria_main);
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		inten=new Intent(this, MainActivity.class);
	}

	public void onBackPressed() 
	{
		inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(new Intent(inten));	
		this.finish();
		LinkedList<DTOElim> listDTO=Controller.getInstancia().getListDTOElim(getApplicationContext());
		LinkedList<DTO> list=Controller.getInstancia().getListDTO(getApplicationContext());
		listDTO.clear();
		list.clear();
		return;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		public Fragment getItem(int position) {
			Fragment fragment = null;
			if(position==0){
					fragment =new FragmentoElim1();
				}else
					if(position==1){
						fragment =new FragmentElim13();
					}else
						if(position==2){
							fragment =new FragmentoElim2();
						}else
							if(position==3){
								fragment =new FragmentElim22();
							}else
								if(position==4){
									fragment =new FragmentoElim3();
								}
			return fragment;  
		}


		public int getCount() {
			// Show 5 total pages.
			return 5;
		}


		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.elimcuart).toUpperCase(l);
			case 1:
				return getString(R.string.elimsemi).toUpperCase(l);
			case 2:
				return getString(R.string.elimsemi).toUpperCase(l);
			case 3:
				return getString(R.string.elim).toUpperCase(l);
			case 4:
				return getString(R.string.elim).toUpperCase(l);
			}
			return null;
		}
	}

	public static class FragmentoElim1 extends Fragment {

		final String[] grupoa =new String[]{"CHI","MEX","ECU","BOL","ARG","URU","PAR","JAM","BRA","COL","PER","VEN"};
		public EditText goct1,goct2,goct3,goct4,goct5,goct6,goct7,goct8;
		public Button boct1,boct2,boct3,boct4,boct5,boct6,boct7,boct8;
		public RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8;
		public Button btnsalvar,btneditar;
		public FragmentoElim1() {}
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.elim_fragment1,	container, false);
			btnsalvar=(Button)rootView.findViewById(R.id.buttong9);
			btneditar=(Button)rootView.findViewById(R.id.buttone9);
			//RadioButtons del primer octavo de final
			rb1=(RadioButton)rootView.findViewById(R.id.radioButtonoct1);
			rb2=(RadioButton)rootView.findViewById(R.id.radioButtonoct2);
			rb3=(RadioButton)rootView.findViewById(R.id.radioButtonoct3);
			rb4=(RadioButton)rootView.findViewById(R.id.radioButtonoct4);
			rb5=(RadioButton)rootView.findViewById(R.id.radioButtonoct5);
			rb6=(RadioButton)rootView.findViewById(R.id.radioButtonoct6);
			rb7=(RadioButton)rootView.findViewById(R.id.radioButtonoct7);
			rb8=(RadioButton)rootView.findViewById(R.id.radioButtonoct8);

			//Editores del primer octavo de final
			goct1=(EditText)rootView.findViewById(R.id.editTextoct1);
			goct2=(EditText)rootView.findViewById(R.id.editTextoct2);
			goct3=(EditText)rootView.findViewById(R.id.editTextoct3);
			goct4=(EditText)rootView.findViewById(R.id.editTextoct4);
			goct5=(EditText)rootView.findViewById(R.id.editTextoct5);
			goct6=(EditText)rootView.findViewById(R.id.editTextoct6);
			goct7=(EditText)rootView.findViewById(R.id.editTextoct7);
			goct8=(EditText)rootView.findViewById(R.id.editTextoct8);

			//Banderas del primer octavo de final       (Buttons)
			boct1=(Button)rootView.findViewById(R.id.buttonoct1);
			boct2=(Button)rootView.findViewById(R.id.buttonoct2);
			boct3=(Button)rootView.findViewById(R.id.buttonoct3);
			boct4=(Button)rootView.findViewById(R.id.buttonoct4);
			boct5=(Button)rootView.findViewById(R.id.buttonoct5);
			boct6=(Button)rootView.findViewById(R.id.buttonoct6);
			boct7=(Button)rootView.findViewById(R.id.buttonoct8);
			boct8=(Button)rootView.findViewById(R.id.buttonoct7);

			//Combobox del primer octavo de final
			final Spinner cmbOpciones1 = (Spinner)rootView.findViewById(R.id.spinneroct1);
			final Spinner cmbOpciones2 = (Spinner)rootView.findViewById(R.id.spinneroct2);
			final Spinner cmbOpciones3 = (Spinner)rootView.findViewById(R.id.spinneroct3);
			final Spinner cmbOpciones4 = (Spinner)rootView.findViewById(R.id.spinneroct4);
			final Spinner cmbOpciones5 = (Spinner)rootView.findViewById(R.id.spinneroct5);
			final Spinner cmbOpciones6 = (Spinner)rootView.findViewById(R.id.spinneroct6);
			final Spinner cmbOpciones7 = (Spinner)rootView.findViewById(R.id.spinneroct7);
			final Spinner cmbOpciones8 = (Spinner)rootView.findViewById(R.id.spinneroct8);

			//Inicializando componenetes
			goct1.setEnabled(true); goct2.setEnabled(true); goct3.setEnabled(true); goct4.setEnabled(true);  
			goct5.setEnabled(true); goct6.setEnabled(true); goct7.setEnabled(true); goct8.setEnabled(true);

			//Listas adaptadoras para los comboboxes
			ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			ArrayAdapter<String> adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			ArrayAdapter<String> adaptador5 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			ArrayAdapter<String> adaptador6 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			ArrayAdapter<String> adaptador7 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			ArrayAdapter<String> adaptador8 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);

			adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cmbOpciones1.setAdapter(adaptador1);
			adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cmbOpciones2.setAdapter(adaptador2);
			adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cmbOpciones3.setAdapter(adaptador3);
			adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cmbOpciones4.setAdapter(adaptador4);
			adaptador5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cmbOpciones5.setAdapter(adaptador5);
			adaptador6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cmbOpciones6.setAdapter(adaptador6);
			adaptador7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cmbOpciones7.setAdapter(adaptador7);
			adaptador8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cmbOpciones8.setAdapter(adaptador8);
			//---------------------------------------------------------------------------------------->

			cmbOpciones1.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					String bandera=(String)cmbOpciones1.getSelectedItem();
					if(bandera.equals("CHI"))
					{
						boct1.setBackgroundResource(R.drawable.chile);
					}else
						if(bandera.equals("MEX"))
						{
							boct1.setBackgroundResource(R.drawable.mexico);
						}else
							if(bandera.equals("ECU"))
							{
								boct1.setBackgroundResource(R.drawable.ecuador);
							}else
								if(bandera.equals("BOL"))
								{
									boct1.setBackgroundResource(R.drawable.bolivia);
								}else
									if(bandera.equals("ARG"))
									{
										boct1.setBackgroundResource(R.drawable.argentina);
									}else
										if(bandera.equals("URU"))
										{
											boct1.setBackgroundResource(R.drawable.uruguay);
										}else
											if(bandera.equals("PAR"))
											{
												boct1.setBackgroundResource(R.drawable.paraguay);
											}else
												if(bandera.equals("JAM"))
												{
													boct1.setBackgroundResource(R.drawable.jamaica);
												}else
													if(bandera.equals("BRA"))
													{
														boct1.setBackgroundResource(R.drawable.brasil);
													}else
														if(bandera.equals("COL"))
														{
															boct1.setBackgroundResource(R.drawable.colombia);
														}else
															if(bandera.equals("PER"))
															{
																boct1.setBackgroundResource(R.drawable.peru);
															}else
																if(bandera.equals("VEN"))
																{
																	boct1.setBackgroundResource(R.drawable.venezuela);
																}
				}

				public void onNothingSelected(AdapterView<?> arg0) {
				}
			});

			cmbOpciones2.setOnItemSelectedListener(new OnItemSelectedListener() {


				public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					String bandera=(String)cmbOpciones2.getSelectedItem();
					if(bandera.equals("CHI"))
					{
						boct2.setBackgroundResource(R.drawable.chile);
					}else
						if(bandera.equals("MEX"))
						{
							boct2.setBackgroundResource(R.drawable.mexico);
						}else
							if(bandera.equals("ECU"))
							{
								boct2.setBackgroundResource(R.drawable.ecuador);
							}else
								if(bandera.equals("BOL"))
								{
									boct2.setBackgroundResource(R.drawable.bolivia);
								}else
									if(bandera.equals("ARG"))
									{
										boct2.setBackgroundResource(R.drawable.argentina);
									}else
										if(bandera.equals("URU"))
										{
											boct2.setBackgroundResource(R.drawable.uruguay);
										}else
											if(bandera.equals("PAR"))
											{
												boct2.setBackgroundResource(R.drawable.paraguay);
											}else
												if(bandera.equals("JAM"))
												{
													boct2.setBackgroundResource(R.drawable.jamaica);
												}else
													if(bandera.equals("BRA"))
													{
														boct2.setBackgroundResource(R.drawable.brasil);
													}else
														if(bandera.equals("COL"))
														{
															boct2.setBackgroundResource(R.drawable.colombia);
														}else
															if(bandera.equals("PER"))
															{
																boct2.setBackgroundResource(R.drawable.peru);
															}else
																if(bandera.equals("VEN"))
																{
																	boct2.setBackgroundResource(R.drawable.venezuela);
																}
				}


				public void onNothingSelected(AdapterView<?> arg0) {
				}
			});

			cmbOpciones3.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					String bandera=(String)cmbOpciones3.getSelectedItem();
					if(bandera.equals("CHI"))
					{
						boct3.setBackgroundResource(R.drawable.chile);
					}else
						if(bandera.equals("MEX"))
						{
							boct3.setBackgroundResource(R.drawable.mexico);
						}else
							if(bandera.equals("ECU"))
							{
								boct3.setBackgroundResource(R.drawable.ecuador);
							}else
								if(bandera.equals("BOL"))
								{
									boct3.setBackgroundResource(R.drawable.bolivia);
								}else
									if(bandera.equals("ARG"))
									{
										boct3.setBackgroundResource(R.drawable.argentina);
									}else
										if(bandera.equals("URU"))
										{
											boct3.setBackgroundResource(R.drawable.uruguay);
										}else
											if(bandera.equals("PAR"))
											{
												boct3.setBackgroundResource(R.drawable.paraguay);
											}else
												if(bandera.equals("JAM"))
												{
													boct3.setBackgroundResource(R.drawable.jamaica);
												}else
													if(bandera.equals("BRA"))
													{
														boct3.setBackgroundResource(R.drawable.brasil);
													}else
														if(bandera.equals("COL"))
														{
															boct3.setBackgroundResource(R.drawable.colombia);
														}else
															if(bandera.equals("PER"))
															{
																boct3.setBackgroundResource(R.drawable.peru);
															}else
																if(bandera.equals("VEN"))
																{
																	boct3.setBackgroundResource(R.drawable.venezuela);
																}
				}


				public void onNothingSelected(AdapterView<?> arg0) {
				}
			});


			cmbOpciones4.setOnItemSelectedListener(new OnItemSelectedListener() {


				public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					String bandera=(String)cmbOpciones4.getSelectedItem();
					if(bandera.equals("CHI"))
					{
						boct4.setBackgroundResource(R.drawable.chile);
					}else
						if(bandera.equals("MEX"))
						{
							boct4.setBackgroundResource(R.drawable.mexico);
						}else
							if(bandera.equals("ECU"))
							{
								boct4.setBackgroundResource(R.drawable.ecuador);
							}else
								if(bandera.equals("BOL"))
								{
									boct4.setBackgroundResource(R.drawable.bolivia);
								}else
									if(bandera.equals("ARG"))
									{
										boct4.setBackgroundResource(R.drawable.argentina);
									}else
										if(bandera.equals("URU"))
										{
											boct4.setBackgroundResource(R.drawable.uruguay);
										}else
											if(bandera.equals("PAR"))
											{
												boct4.setBackgroundResource(R.drawable.paraguay);
											}else
												if(bandera.equals("JAM"))
												{
													boct4.setBackgroundResource(R.drawable.jamaica);
												}else
													if(bandera.equals("BRA"))
													{
														boct4.setBackgroundResource(R.drawable.brasil);
													}else
														if(bandera.equals("COL"))
														{
															boct4.setBackgroundResource(R.drawable.colombia);
														}else
															if(bandera.equals("PER"))
															{
																boct4.setBackgroundResource(R.drawable.peru);
															}else
																if(bandera.equals("VEN"))
																{
																	boct4.setBackgroundResource(R.drawable.venezuela);
																}
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				}
			});


			cmbOpciones5.setOnItemSelectedListener(new OnItemSelectedListener() {


				public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					String bandera=(String)cmbOpciones5.getSelectedItem();
					if(bandera.equals("CHI"))
					{
						boct5.setBackgroundResource(R.drawable.chile);
					}else
						if(bandera.equals("MEX"))
						{
							boct5.setBackgroundResource(R.drawable.mexico);
						}else
							if(bandera.equals("ECU"))
							{
								boct5.setBackgroundResource(R.drawable.ecuador);
							}else
								if(bandera.equals("BOL"))
								{
									boct5.setBackgroundResource(R.drawable.bolivia);
								}else
									if(bandera.equals("ARG"))
									{
										boct5.setBackgroundResource(R.drawable.argentina);
									}else
										if(bandera.equals("URU"))
										{
											boct5.setBackgroundResource(R.drawable.uruguay);
										}else
											if(bandera.equals("PAR"))
											{
												boct5.setBackgroundResource(R.drawable.paraguay);
											}else
												if(bandera.equals("JAM"))
												{
													boct5.setBackgroundResource(R.drawable.jamaica);
												}else
													if(bandera.equals("BRA"))
													{
														boct5.setBackgroundResource(R.drawable.brasil);
													}else
														if(bandera.equals("COL"))
														{
															boct5.setBackgroundResource(R.drawable.colombia);
														}else
															if(bandera.equals("PER"))
															{
																boct5.setBackgroundResource(R.drawable.peru);
															}else
																if(bandera.equals("VEN"))
																{
																	boct5.setBackgroundResource(R.drawable.venezuela);
																}
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				}
			});

			cmbOpciones6.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					String bandera=(String)cmbOpciones6.getSelectedItem();
					if(bandera.equals("CHI"))
					{
						boct6.setBackgroundResource(R.drawable.chile);
					}else
						if(bandera.equals("MEX"))
						{
							boct6.setBackgroundResource(R.drawable.mexico);
						}else
							if(bandera.equals("ECU"))
							{
								boct6.setBackgroundResource(R.drawable.ecuador);
							}else
								if(bandera.equals("BOL"))
								{
									boct6.setBackgroundResource(R.drawable.bolivia);
								}else
									if(bandera.equals("ARG"))
									{
										boct6.setBackgroundResource(R.drawable.argentina);
									}else
										if(bandera.equals("URU"))
										{
											boct6.setBackgroundResource(R.drawable.uruguay);
										}else
											if(bandera.equals("PAR"))
											{
												boct6.setBackgroundResource(R.drawable.paraguay);
											}else
												if(bandera.equals("JAM"))
												{
													boct6.setBackgroundResource(R.drawable.jamaica);
												}else
													if(bandera.equals("BRA"))
													{
														boct6.setBackgroundResource(R.drawable.brasil);
													}else
														if(bandera.equals("COL"))
														{
															boct6.setBackgroundResource(R.drawable.colombia);
														}else
															if(bandera.equals("PER"))
															{
																boct6.setBackgroundResource(R.drawable.peru);
															}else
																if(bandera.equals("VEN"))
																{
																	boct6.setBackgroundResource(R.drawable.venezuela);
																}
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				}
			});

			cmbOpciones7.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					String bandera=(String)cmbOpciones7.getSelectedItem();
					if(bandera.equals("CHI"))
					{
						boct8.setBackgroundResource(R.drawable.chile);
					}else
						if(bandera.equals("MEX"))
						{
							boct8.setBackgroundResource(R.drawable.mexico);
						}else
							if(bandera.equals("ECU"))
							{
								boct8.setBackgroundResource(R.drawable.ecuador);
							}else
								if(bandera.equals("BOL"))
								{
									boct8.setBackgroundResource(R.drawable.bolivia);
								}else
									if(bandera.equals("ARG"))
									{
										boct8.setBackgroundResource(R.drawable.argentina);
									}else
										if(bandera.equals("URU"))
										{
											boct8.setBackgroundResource(R.drawable.uruguay);
										}else
											if(bandera.equals("PAR"))
											{
												boct8.setBackgroundResource(R.drawable.paraguay);
											}else
												if(bandera.equals("JAM"))
												{
													boct8.setBackgroundResource(R.drawable.jamaica);
												}else
													if(bandera.equals("BRA"))
													{
														boct8.setBackgroundResource(R.drawable.brasil);
													}else
														if(bandera.equals("COL"))
														{
															boct8.setBackgroundResource(R.drawable.colombia);
														}else
															if(bandera.equals("PER"))
															{
																boct8.setBackgroundResource(R.drawable.peru);
															}else
																if(bandera.equals("VEN"))
																{
																	boct8.setBackgroundResource(R.drawable.venezuela);
																}
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				}
			});

			cmbOpciones8.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					String bandera=(String)cmbOpciones8.getSelectedItem();
					if(bandera.equals("CHI"))
					{
						boct7.setBackgroundResource(R.drawable.chile);
					}else
						if(bandera.equals("MEX"))
						{
							boct7.setBackgroundResource(R.drawable.mexico);
						}else
							if(bandera.equals("ECU"))
							{
								boct7.setBackgroundResource(R.drawable.ecuador);
							}else
								if(bandera.equals("BOL"))
								{
									boct7.setBackgroundResource(R.drawable.bolivia);
								}else
									if(bandera.equals("ARG"))
									{
										boct7.setBackgroundResource(R.drawable.argentina);
									}else
										if(bandera.equals("URU"))
										{
											boct7.setBackgroundResource(R.drawable.uruguay);
										}else
											if(bandera.equals("PAR"))
											{
												boct7.setBackgroundResource(R.drawable.paraguay);
											}else
												if(bandera.equals("JAM"))
												{
													boct7.setBackgroundResource(R.drawable.jamaica);
												}else
													if(bandera.equals("BRA"))
													{
														boct7.setBackgroundResource(R.drawable.brasil);
													}else
														if(bandera.equals("COL"))
														{
															boct7.setBackgroundResource(R.drawable.colombia);
														}else
															if(bandera.equals("PER"))
															{
																boct7.setBackgroundResource(R.drawable.peru);
															}else
																if(bandera.equals("VEN"))
																{
																	boct7.setBackgroundResource(R.drawable.venezuela);
																}
				}
				public void onNothingSelected(AdapterView<?> arg0) {

				}
			});
			//---------------------------------------------------------				


			//*********************************************************
			//Cargando en la interfaz los componentes.
			//*********************************************************

			LinkedList<DTOElim> list=Controller.getInstancia().getListDTOElim(rootView.getContext());
			if(list.size()!=0)
			{
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i).getPartido().equals("cuag1"))
					{
						DTOElim dt=list.get(i);
						goct1.setText(String.valueOf(dt.getGoles1()));
						goct1.setEnabled(false);
						goct2.setText(String.valueOf(dt.getGoles2()));
						goct2.setEnabled(false);
						cmbOpciones1.setEnabled(false);
						cmbOpciones2.setEnabled(false);
						rb1.setEnabled(false);
						rb2.setEnabled(false);
						if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
						{
							rb1.setChecked(true);
							rb2.setChecked(false);
						}else
							if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
							{
								rb2.setChecked(true);
								rb1.setChecked(false);
							}
						String bandera1=dt.getPais1();
						String bandera2=dt.getPais2();
						final String a1[] =new String[]{bandera1};
						final String a2[] =new String[]{bandera2};
						adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
						adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						cmbOpciones1.setAdapter(adaptador1);
						if(bandera1.equals("CHI"))
						{
							boct1.setBackgroundResource(R.drawable.chile);
						}else
							if(bandera1.equals("MEX"))
							{
								boct1.setBackgroundResource(R.drawable.mexico);
							}else
								if(bandera1.equals("ECU"))
								{
									boct1.setBackgroundResource(R.drawable.ecuador);
								}else
									if(bandera1.equals("BOL"))
									{
										boct1.setBackgroundResource(R.drawable.bolivia);
									}else
										if(bandera1.equals("ARG"))
										{
											boct1.setBackgroundResource(R.drawable.argentina);
										}else
											if(bandera1.equals("URU"))
											{
												boct1.setBackgroundResource(R.drawable.uruguay);
											}else
												if(bandera1.equals("PAR"))
												{
													boct1.setBackgroundResource(R.drawable.paraguay);
												}else
													if(bandera1.equals("JAM"))
													{
														boct1.setBackgroundResource(R.drawable.jamaica);
													}else
														if(bandera1.equals("BRA"))
														{
															boct1.setBackgroundResource(R.drawable.brasil);
														}else
															if(bandera1.equals("COL"))
															{
																boct1.setBackgroundResource(R.drawable.colombia);
															}else
																if(bandera1.equals("PER"))
																{
																	boct1.setBackgroundResource(R.drawable.peru);
																}else
																	if(bandera1.equals("VEN"))
																	{
																		boct1.setBackgroundResource(R.drawable.venezuela);
																	}

						adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
						adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						cmbOpciones2.setAdapter(adaptador2);
						if(bandera2.equals("CHI"))
						{
							boct2.setBackgroundResource(R.drawable.chile);
						}else
							if(bandera2.equals("MEX"))
							{
								boct2.setBackgroundResource(R.drawable.mexico);
							}else
								if(bandera2.equals("ECU"))
								{
									boct2.setBackgroundResource(R.drawable.ecuador);
								}else
									if(bandera2.equals("BOL"))
									{
										boct2.setBackgroundResource(R.drawable.bolivia);
									}else
										if(bandera2.equals("ARG"))
										{
											boct2.setBackgroundResource(R.drawable.argentina);
										}else
											if(bandera2.equals("URU"))
											{
												boct2.setBackgroundResource(R.drawable.uruguay);
											}else
												if(bandera2.equals("PAR"))
												{
													boct2.setBackgroundResource(R.drawable.paraguay);
												}else
													if(bandera2.equals("JAM"))
													{
														boct2.setBackgroundResource(R.drawable.jamaica);
													}else
														if(bandera2.equals("BRA"))
														{
															boct2.setBackgroundResource(R.drawable.brasil);
														}else
															if(bandera2.equals("COL"))
															{
																boct2.setBackgroundResource(R.drawable.colombia);
															}else
																if(bandera2.equals("PER"))
																{
																	boct2.setBackgroundResource(R.drawable.peru);
																}else
																	if(bandera2.equals("VEN"))
																	{
																		boct2.setBackgroundResource(R.drawable.venezuela);
																	}
					}
					else
						if(list.get(i).getPartido().equals("cuag2"))
						{
							DTOElim dt=list.get(i);
							goct3.setText(String.valueOf(dt.getGoles1()));
							goct3.setEnabled(false);
							goct4.setText(String.valueOf(dt.getGoles2()));
							goct4.setEnabled(false);
							cmbOpciones3.setEnabled(false);
							cmbOpciones4.setEnabled(false);
							rb3.setEnabled(false);
							rb4.setEnabled(false);
							if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
							{
								rb3.setChecked(true);
								rb4.setChecked(false);
							}else
								if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
								{
									rb4.setChecked(true);
									rb3.setChecked(false);
								}
							String bandera1=dt.getPais1();
							String bandera2=dt.getPais2();
							final String a1[] =new String[]{bandera1};
							final String a2[] =new String[]{bandera2};
							adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
							adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones3.setAdapter(adaptador3);
							if(bandera1.equals("CHI"))
							{
								boct3.setBackgroundResource(R.drawable.chile);
							}else
								if(bandera1.equals("MEX"))
								{
									boct3.setBackgroundResource(R.drawable.mexico);
								}else
									if(bandera1.equals("ECU"))
									{
										boct3.setBackgroundResource(R.drawable.ecuador);
									}else
										if(bandera1.equals("BOL"))
										{
											boct3.setBackgroundResource(R.drawable.bolivia);
										}else
											if(bandera1.equals("ARG"))
											{
												boct3.setBackgroundResource(R.drawable.argentina);
											}else
												if(bandera1.equals("URU"))
												{
													boct3.setBackgroundResource(R.drawable.uruguay);
												}else
													if(bandera1.equals("PAR"))
													{
														boct3.setBackgroundResource(R.drawable.paraguay);
													}else
														if(bandera1.equals("JAM"))
														{
															boct3.setBackgroundResource(R.drawable.jamaica);
														}else
															if(bandera1.equals("BRA"))
															{
																boct3.setBackgroundResource(R.drawable.brasil);
															}else
																if(bandera1.equals("COL"))
																{
																	boct3.setBackgroundResource(R.drawable.colombia);
																}else
																	if(bandera1.equals("PER"))
																	{
																		boct3.setBackgroundResource(R.drawable.peru);
																	}else
																		if(bandera1.equals("VEN"))
																		{
																			boct3.setBackgroundResource(R.drawable.venezuela);
																		}
							adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
							adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones4.setAdapter(adaptador4);
							if(bandera2.equals("CHI"))
							{
								boct4.setBackgroundResource(R.drawable.chile);
							}else
								if(bandera2.equals("MEX"))
								{
									boct4.setBackgroundResource(R.drawable.mexico);
								}else
									if(bandera2.equals("ECU"))
									{
										boct4.setBackgroundResource(R.drawable.ecuador);
									}else
										if(bandera2.equals("BOL"))
										{
											boct4.setBackgroundResource(R.drawable.bolivia);
										}else
											if(bandera2.equals("ARG"))
											{
												boct4.setBackgroundResource(R.drawable.argentina);
											}else
												if(bandera2.equals("URU"))
												{
													boct4.setBackgroundResource(R.drawable.uruguay);
												}else
													if(bandera2.equals("PAR"))
													{
														boct4.setBackgroundResource(R.drawable.paraguay);
													}else
														if(bandera2.equals("JAM"))
														{
															boct4.setBackgroundResource(R.drawable.jamaica);
														}else
															if(bandera2.equals("BRA"))
															{
																boct4.setBackgroundResource(R.drawable.brasil);
															}else
																if(bandera2.equals("COL"))
																{
																	boct4.setBackgroundResource(R.drawable.colombia);
																}else
																	if(bandera2.equals("PER"))
																	{
																		boct4.setBackgroundResource(R.drawable.peru);
																	}else
																		if(bandera2.equals("VEN"))
																		{
																			boct4.setBackgroundResource(R.drawable.venezuela);
																		}
						}else
							if(list.get(i).getPartido().equals("cuag3"))
							{
								DTOElim dt=list.get(i);
								goct5.setText(String.valueOf(dt.getGoles1()));
								goct5.setEnabled(false);
								goct6.setText(String.valueOf(dt.getGoles2()));
								goct6.setEnabled(false);
								cmbOpciones5.setEnabled(false);
								cmbOpciones6.setEnabled(false);
								rb5.setEnabled(false);
								rb6.setEnabled(false);
								if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
								{
									rb5.setChecked(true);
									rb6.setChecked(false);
								}else
									if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
									{
										rb6.setChecked(true);
										rb5.setChecked(false);
									}
								String bandera1=dt.getPais1();
								String bandera2=dt.getPais2();
								final String a1[] =new String[]{bandera1};
								final String a2[] =new String[]{bandera2};
								adaptador5 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
								adaptador5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
								cmbOpciones5.setAdapter(adaptador5);
								if(bandera1.equals("CHI"))
								{
									boct5.setBackgroundResource(R.drawable.chile);
								}else
									if(bandera1.equals("MEX"))
									{
										boct5.setBackgroundResource(R.drawable.mexico);
									}else
										if(bandera1.equals("ECU"))
										{
											boct5.setBackgroundResource(R.drawable.ecuador);
										}else
											if(bandera1.equals("BOL"))
											{
												boct5.setBackgroundResource(R.drawable.bolivia);
											}else
												if(bandera1.equals("ARG"))
												{
													boct5.setBackgroundResource(R.drawable.argentina);
												}else
													if(bandera1.equals("URU"))
													{
														boct5.setBackgroundResource(R.drawable.uruguay);
													}else
														if(bandera1.equals("PAR"))
														{
															boct5.setBackgroundResource(R.drawable.paraguay);
														}else
															if(bandera1.equals("JAM"))
															{
																boct5.setBackgroundResource(R.drawable.jamaica);
															}else
																if(bandera1.equals("BRA"))
																{
																	boct5.setBackgroundResource(R.drawable.brasil);
																}else
																	if(bandera1.equals("COL"))
																	{
																		boct5.setBackgroundResource(R.drawable.colombia);
																	}else
																		if(bandera1.equals("PER"))
																		{
																			boct5.setBackgroundResource(R.drawable.peru);
																		}else
																			if(bandera1.equals("VEN"))
																			{
																				boct5.setBackgroundResource(R.drawable.venezuela);
																			}
								adaptador6 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
								adaptador6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
								cmbOpciones6.setAdapter(adaptador6);
								if(bandera2.equals("CHI"))
								{
									boct6.setBackgroundResource(R.drawable.chile);
								}else
									if(bandera2.equals("MEX"))
									{
										boct6.setBackgroundResource(R.drawable.mexico);
									}else
										if(bandera2.equals("ECU"))
										{
											boct6.setBackgroundResource(R.drawable.ecuador);
										}else
											if(bandera2.equals("BOL"))
											{
												boct6.setBackgroundResource(R.drawable.bolivia);
											}else
												if(bandera2.equals("ARG"))
												{
													boct6.setBackgroundResource(R.drawable.argentina);
												}else
													if(bandera2.equals("URU"))
													{
														boct6.setBackgroundResource(R.drawable.uruguay);
													}else
														if(bandera2.equals("PAR"))
														{
															boct6.setBackgroundResource(R.drawable.paraguay);
														}else
															if(bandera2.equals("JAM"))
															{
																boct6.setBackgroundResource(R.drawable.jamaica);
															}else
																if(bandera2.equals("BRA"))
																{
																	boct6.setBackgroundResource(R.drawable.brasil);
																}else
																	if(bandera2.equals("COL"))
																	{
																		boct6.setBackgroundResource(R.drawable.colombia);
																	}else
																		if(bandera2.equals("PER"))
																		{
																			boct6.setBackgroundResource(R.drawable.peru);
																		}else
																			if(bandera2.equals("VEN"))
																			{
																				boct6.setBackgroundResource(R.drawable.venezuela);
																			}

							}else
								if(list.get(i).getPartido().equals("cuag4"))
								{
									DTOElim dt=list.get(i);
									goct7.setText(String.valueOf(dt.getGoles1()));
									goct7.setEnabled(false);
									goct8.setText(String.valueOf(dt.getGoles2()));
									goct8.setEnabled(false);
									cmbOpciones7.setEnabled(false);
									cmbOpciones8.setEnabled(false);
									rb7.setEnabled(false);
									rb8.setEnabled(false);
									if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
									{
										rb7.setChecked(true);
										rb8.setChecked(false);
									}else
										if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
										{
											rb8.setChecked(true);
											rb7.setChecked(false);
										}
									String bandera1=dt.getPais1();
									String bandera2=dt.getPais2();
									final String a1[] =new String[]{bandera1};
									final String a2[] =new String[]{bandera2};
									adaptador7 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
									adaptador7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones7.setAdapter(adaptador7);
									if(bandera1.equals("CHI"))
									{
										boct8.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera1.equals("MEX"))
										{
											boct8.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera1.equals("ECU"))
											{
												boct8.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera1.equals("BOL"))
												{
													boct8.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera1.equals("ARG"))
													{
														boct8.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera1.equals("URU"))
														{
															boct8.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera1.equals("PAR"))
															{
																boct8.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera1.equals("JAM"))
																{
																	boct8.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera1.equals("BRA"))
																	{
																		boct8.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera1.equals("COL"))
																		{
																			boct8.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera1.equals("PER"))
																			{
																				boct8.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera1.equals("VEN"))
																				{
																					boct8.setBackgroundResource(R.drawable.venezuela);
																				}
									adaptador8 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
									adaptador8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones8.setAdapter(adaptador8);

									if(bandera2.equals("CHI"))
									{
										boct7.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera2.equals("MEX"))
										{
											boct7.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera2.equals("ECU"))
											{
												boct7.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera2.equals("BOL"))
												{
													boct7.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera2.equals("ARG"))
													{
														boct7.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera2.equals("URU"))
														{
															boct7.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera2.equals("PAR"))
															{
																boct7.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera2.equals("JAM"))
																{
																	boct7.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera2.equals("BRA"))
																	{
																		boct7.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera2.equals("COL"))
																		{
																			boct7.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera2.equals("PER"))
																			{
																				boct7.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera2.equals("VEN"))
																				{
																					boct7.setBackgroundResource(R.drawable.venezuela);
																				}
								}
				}
			}

			//*********************************************************
			//Seleccion de radiobuttons		
			//*********************************************************

			rb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb2.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb2.setChecked(true);
						}
				}
			});

			rb2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb1.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb1.setChecked(true);
						}
				}
			});

			rb3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb4.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb4.setChecked(true);
						}
				}
			});

			rb4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb3.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb3.setChecked(true);
						}
				}
			});

			rb5.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb6.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb6.setChecked(true);
						}
				}
			});

			rb6.setOnCheckedChangeListener(new OnCheckedChangeListener() {


				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb5.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb5.setChecked(true);
						}
				}
			});

			rb7.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb8.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb8.setChecked(true);
						}
				}
			});

			rb8.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb7.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb7.setChecked(true);
						}
				}
			});

			//*********************************************************
			//Seleccion de radiobuttons		
			//*********************************************************
			
			btnsalvar.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					final LinkedList<DTOElim> listDTO=Controller.getInstancia().getListDTOElim(rootView.getContext());
					if(goct1.length()!=0 && goct2.length()!=0)
					{
						DTOElim dt=new DTOElim();
						dt.setPartido("cuag1");
						String bandera1=(String)cmbOpciones1.getSelectedItem();
						String bandera2=(String)cmbOpciones2.getSelectedItem();
						dt.setPais1(bandera1);
						dt.setPais2(bandera2);
						dt.setAceptado("true");
						int g1=Integer.parseInt(goct1.getEditableText().toString());
						int g2=Integer.parseInt(goct2.getEditableText().toString());
						dt.setGoles1(g1);
						dt.setGoles2(g2);
						if(g1>g2)
						{
							rb1.setChecked(true);
							rb2.setChecked(false);
							dt.setEmpatev1(1);
							dt.setEmpatev2(0);
						}else
							if(g2>g1)
							{
								rb2.setChecked(true);
								rb1.setChecked(false);
								dt.setEmpatev1(0);
								dt.setEmpatev2(1);
							}else
								if(g2==g1)
								{
									if(rb1.isChecked()==true)
									{
										dt.setEmpatev1(1);
										dt.setEmpatev2(0);
									}else
										if(rb2.isChecked()==true)
										{
											dt.setEmpatev2(1);
											dt.setEmpatev1(0);
										}
								}
						listDTO.add(dt);
					}
						if(goct3.length()!=0 && goct4.length()!=0)
						{
							DTOElim dt=new DTOElim();
							dt.setPartido("cuag2");
							String bandera1=(String)cmbOpciones3.getSelectedItem();
							String bandera2=(String)cmbOpciones4.getSelectedItem();
							dt.setPais1(bandera1);
							dt.setPais2(bandera2);
							dt.setAceptado("true");
							int g1=Integer.parseInt(goct3.getEditableText().toString());
							int g2=Integer.parseInt(goct4.getEditableText().toString());
							dt.setGoles1(g1);
							dt.setGoles2(g2);
							if(g1>g2)
							{
								rb3.setChecked(true);
								rb4.setChecked(false);
								dt.setEmpatev1(1);
								dt.setEmpatev2(0);
							}else
								if(g2>g1)
								{
									rb4.setChecked(true);
									rb3.setChecked(false);
									dt.setEmpatev1(0);
									dt.setEmpatev2(1);
								}else
									if(g2==g1)
									{
										if(rb3.isChecked()==true)
										{
											dt.setEmpatev1(1);
											dt.setEmpatev2(0);
										}else
											if(rb4.isChecked()==true)
											{
												dt.setEmpatev2(1);
												dt.setEmpatev1(0);
											}
									}
							listDTO.add(dt);
						}
						if(goct5.length()!=0 && goct6.length()!=0)
						{
							DTOElim dt=new DTOElim();
							dt.setPartido("cuag3");
							String bandera1=(String)cmbOpciones5.getSelectedItem();
							String bandera2=(String)cmbOpciones6.getSelectedItem();
							dt.setPais1(bandera1);
							dt.setPais2(bandera2);
							dt.setAceptado("true");
							int g1=Integer.parseInt(goct5.getEditableText().toString());
							int g2=Integer.parseInt(goct6.getEditableText().toString());
							dt.setGoles1(g1);
							dt.setGoles2(g2);
							if(g1>g2)
							{
								rb5.setChecked(true);
								rb6.setChecked(false);
								dt.setEmpatev1(1);
								dt.setEmpatev2(0);
							}else
								if(g2>g1)
								{
									rb6.setChecked(true);
									rb5.setChecked(false);
									dt.setEmpatev1(0);
									dt.setEmpatev2(1);
								}else
									if(g2==g1)
									{
										if(rb5.isChecked()==true)
										{
											dt.setEmpatev1(1);
											dt.setEmpatev2(0);
										}else
											if(rb6.isChecked()==true)
											{
												dt.setEmpatev2(1);
												dt.setEmpatev1(0);
											}
									}
							listDTO.add(dt);
						}
						if(goct7.length()!=0 && goct8.length()!=0)
						{
							DTOElim dt=new DTOElim();
							dt.setPartido("cuag4");
							String bandera1=(String)cmbOpciones7.getSelectedItem();
							String bandera2=(String)cmbOpciones8.getSelectedItem();
							dt.setPais1(bandera1);
							dt.setPais2(bandera2);
							dt.setAceptado("true");
							int g1=Integer.parseInt(goct7.getEditableText().toString());
							int g2=Integer.parseInt(goct8.getEditableText().toString());
							dt.setGoles1(g1);
							dt.setGoles2(g2);
							if(g1>g2)
							{
								rb7.setChecked(true);
								rb8.setChecked(false);
								dt.setEmpatev1(1);
								dt.setEmpatev2(0);
							}else
								if(g2>g1)
								{
									rb8.setChecked(true);
									rb7.setChecked(false);
									dt.setEmpatev1(0);
									dt.setEmpatev2(1);
								}else
									if(g2==g1)
									{
										if(rb7.isChecked()==true)
										{
											dt.setEmpatev1(1);
											dt.setEmpatev2(0);
										}else
											if(rb8.isChecked()==true)
											{
												dt.setEmpatev2(1);
												dt.setEmpatev1(0);
											}
									}
							listDTO.add(dt);
						}
					if(listDTO.size()!=0)
					{
						for(int i=0;i<listDTO.size();i++)
						{
							if(listDTO.get(i).getPartido().equals("cuag1"))
							{
								DTOElim dt=listDTO.get(i);
								Controller.getInstancia().insertElimD(rootView.getContext(),dt.getPartido(),dt.getPais1(),dt.getPais2() , dt.getAceptado() , dt.getGoles1(), dt.getGoles2(),dt.getEmpatev1(),dt.getEmpatev2());
								goct1.setEnabled(false);
								goct2.setEnabled(false);
								cmbOpciones1.setEnabled(false);
								cmbOpciones2.setEnabled(false);
								rb1.setEnabled(false);
								rb2.setEnabled(false);

							}else
								if(listDTO.get(i).getPartido().equals("cuag2") )
								{
									DTOElim dt=listDTO.get(i);
									Controller.getInstancia().insertElimD(rootView.getContext(),dt.getPartido(),dt.getPais1(),dt.getPais2() , dt.getAceptado() , dt.getGoles1(), dt.getGoles2(),dt.getEmpatev1(),dt.getEmpatev2());
									goct3.setEnabled(false);
									goct4.setEnabled(false);
									rb3.setEnabled(false);
									rb4.setEnabled(false);
									cmbOpciones3.setEnabled(false);
									cmbOpciones4.setEnabled(false);
								}else
									if(listDTO.get(i).getPartido().equals("cuag3"))
									{
										DTOElim dt=listDTO.get(i);
										Controller.getInstancia().insertElimD(rootView.getContext(),dt.getPartido(),dt.getPais1(),dt.getPais2() , dt.getAceptado() , dt.getGoles1(), dt.getGoles2(),dt.getEmpatev1(),dt.getEmpatev2());
										goct5.setEnabled(false);
										goct6.setEnabled(false);
										cmbOpciones5.setEnabled(false);
										cmbOpciones6.setEnabled(false);
										rb5.setEnabled(false);
										rb6.setEnabled(false);

									}else
										if(listDTO.get(i).getPartido().equals("cuag4") )
										{
											DTOElim dt=listDTO.get(i);
											Controller.getInstancia().insertElimD(rootView.getContext(),dt.getPartido(),dt.getPais1(),dt.getPais2() , dt.getAceptado() , dt.getGoles1(), dt.getGoles2(),dt.getEmpatev1(),dt.getEmpatev2());
											goct7.setEnabled(false);
											goct8.setEnabled(false);
											rb7.setEnabled(false);
											rb8.setEnabled(false);
											cmbOpciones7.setEnabled(false);
											cmbOpciones8.setEnabled(false);
										}
						}
					}
				}
			});
			final ArrayAdapter<String> adaptador1c = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			final ArrayAdapter<String> adaptador2c = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			final ArrayAdapter<String> adaptador3c = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			final ArrayAdapter<String> adaptador4c = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			final ArrayAdapter<String> adaptador5c = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			final ArrayAdapter<String> adaptador6c = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			final ArrayAdapter<String> adaptador7c = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			final ArrayAdapter<String> adaptador8c = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
			btneditar.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					new AlertDialog.Builder(arg0.getContext()).setTitle("Confirme si desea limpiar los datos de la pantalla de los Cuartos de Final")
					.setPositiveButton("Si",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int whichButton) {
							adaptador1c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones1.setAdapter(adaptador1c);
							adaptador2c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones2.setAdapter(adaptador2c);
							adaptador3c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones3.setAdapter(adaptador3c);
							adaptador4c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones4.setAdapter(adaptador4c);
							adaptador5c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones5.setAdapter(adaptador5c);
							adaptador6c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones6.setAdapter(adaptador6c);
							adaptador7c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones7.setAdapter(adaptador7c);
							adaptador8c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones8.setAdapter(adaptador8c);
							goct1.getText().clear();goct4.getText().clear();
							goct2.getText().clear();goct3.getText().clear();
							goct1.setEnabled(true);goct4.setEnabled(true);
							goct2.setEnabled(true);goct3.setEnabled(true);
							goct5.getText().clear();goct7.getText().clear();
							goct6.getText().clear();goct8.getText().clear();
							goct5.setEnabled(true);goct7.setEnabled(true);
							goct6.setEnabled(true);goct8.setEnabled(true);
							cmbOpciones1.setEnabled(true);
							cmbOpciones2.setEnabled(true);
							cmbOpciones3.setEnabled(true);
							cmbOpciones4.setEnabled(true);
							cmbOpciones5.setEnabled(true);
							cmbOpciones6.setEnabled(true);
							cmbOpciones7.setEnabled(true);
							cmbOpciones8.setEnabled(true);
							rb1.setEnabled(true);rb3.setEnabled(true);
							rb2.setEnabled(true);rb4.setEnabled(true);
							rb1.setChecked(false);rb3.setChecked(false);
							rb2.setChecked(false);rb4.setChecked(false);
							rb5.setEnabled(true);rb7.setEnabled(true);
							rb6.setEnabled(true);rb8.setEnabled(true);
							rb5.setChecked(false);rb7.setChecked(false);
							rb6.setChecked(false);rb8.setChecked(false);
							try 
							{
								LinkedList<DTOElim> lista=Controller.getInstancia().getListDTOElim(rootView.getContext());
								if(!lista.isEmpty())
								{	
									Controller.getInstancia().DeleteElimAllD(rootView.getContext());
								}
								Controller.getInstancia().getListDTOElim(rootView.getContext()).clear();
							} catch (Exception e1) {
								// TODO: handle exception
							}
							Controller.getInstancia().getListDTO(rootView.getContext()).clear();
						}
					}).setNegativeButton("No", null).show();
				}
			});
			
			rootView.setOnKeyListener(new OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {
						Intent myIntent =new Intent(v.getContext(), MainActivity.class);
						startActivityForResult(myIntent, 0);
						LinkedList<DTOElim> listDTO=Controller.getInstancia().getListDTOElim(rootView.getContext());
						LinkedList<DTO> list=Controller.getInstancia().getListDTO(rootView.getContext());
						listDTO.clear();
						list.clear();
						return true;
					}
					return false;
				}
			});
			//*********************************************************

			return rootView;
		}
	}

	public static class FragmentElim13 extends Fragment {

		public FragmentElim13() {}
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.elim_fragment13,container, false);
			rootView.setOnKeyListener(new OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {
						Intent myIntent =new Intent(v.getContext(), MainActivity.class);
						startActivityForResult(myIntent, 0);
						return true; // consume event, hence do nothing on camera button
					}
					return false;
				}
			});
			//*********************************************************

			return rootView;

		}
	}
	
	public static class FragmentoElim2 extends Fragment {

		public String[] grupoa =new String[]{""};
		public String[] grupob =new String[]{""};
		public String[] grupoc =new String[]{""};
		public String[] grupod =new String[]{""};

		public EditText goct1,goct2,goct3,goct4;
		public Button boct1,boct2,boct3,boct4;
		public RadioButton rb1,rb2,rb3,rb4;
		public Button btnsalvar,btneditar;
		public ArrayAdapter<String> adaptador1,adaptador2,adaptador3,adaptador4;

		public FragmentoElim2() {}
		
		public LinkedList<String> plays()
		{
			LinkedList<String> l=new LinkedList<String>();
			LinkedList<DTOElim> list=Controller.getInstancia().getListDTOElim(this.getActivity().getApplicationContext());
			if(list.size()!=0)
			{
				for (int i = 0; i < list.size(); i++) {
					l.add(list.get(i).getPartido());
				}
			}
			return l;
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
		{
			final View rootView = inflater.inflate(R.layout.elim_fragment2,container, false);
			btnsalvar=(Button)rootView.findViewById(R.id.buttong12);
			btneditar=(Button)rootView.findViewById(R.id.buttone12);

			//RadioButtons de cuartos de final
			rb1=(RadioButton)rootView.findViewById(R.id.radioButtoncua1);
			rb2=(RadioButton)rootView.findViewById(R.id.radioButtoncua2);
			rb3=(RadioButton)rootView.findViewById(R.id.radioButtoncua3);
			rb4=(RadioButton)rootView.findViewById(R.id.radioButtoncua4);

			//Editores de cuartos de final
			goct1=(EditText)rootView.findViewById(R.id.editTextcua1);
			goct2=(EditText)rootView.findViewById(R.id.editTextcua2);
			goct3=(EditText)rootView.findViewById(R.id.editTextcua3);
			goct4=(EditText)rootView.findViewById(R.id.editTextcua4);

			//Banderas de cuartos de final       (Buttons)
			boct1=(Button)rootView.findViewById(R.id.buttoncua1);
			boct2=(Button)rootView.findViewById(R.id.buttoncua2);
			boct3=(Button)rootView.findViewById(R.id.buttoncua3);
			boct4=(Button)rootView.findViewById(R.id.buttoncua4);

			final Spinner cmbOpciones1 = (Spinner)rootView.findViewById(R.id.spinnercua1);
			final Spinner cmbOpciones2 = (Spinner)rootView.findViewById(R.id.spinnercua2);
			final Spinner cmbOpciones3 = (Spinner)rootView.findViewById(R.id.spinnercua3);
			final Spinner cmbOpciones4 = (Spinner)rootView.findViewById(R.id.spinnercua4);

			
			//Llenando comboboxes con partidos de los octavos
			LinkedList<DTOElim> list=Controller.getInstancia().getListDTOElim(rootView.getContext());
			LinkedList<String> l=plays();
			if(list.size()!=0)
			{
				for(int i=0;i<list.size();i++)
				{
					if(l.contains("semig1")==false)
					{
						if(list.get(i).getPartido().equals("cuag1"))
						{
							DTOElim dt=list.get(i);
							if(dt!=null)
							{
								
								if(dt.getEmpatev1()>dt.getEmpatev2())
								{
									String bandera1=dt.getPais1();
									final String a1[] =new String[]{bandera1};
									adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
									adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones1.setAdapter(adaptador1);
									if(bandera1.equals("CHI"))
									{
										boct1.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera1.equals("MEX"))
										{
											boct1.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera1.equals("ECU"))
											{
												boct1.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera1.equals("BOL"))
												{
													boct1.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera1.equals("ARG"))
													{
														boct1.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera1.equals("URU"))
														{
															boct1.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera1.equals("PAR"))
															{
																boct1.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera1.equals("JAM"))
																{
																	boct1.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera1.equals("BRA"))
																	{
																		boct1.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera1.equals("COL"))
																		{
																			boct1.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera1.equals("PER"))
																			{
																				boct1.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera1.equals("VEN"))
																				{
																					boct1.setBackgroundResource(R.drawable.venezuela);
																				}

								}else
									if(dt.getEmpatev1()<dt.getEmpatev2())
									{
										String bandera1="";
										bandera1=dt.getPais2();
										final String a1[] =new String[]{bandera1};
										adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
										adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones1.setAdapter(adaptador1);
										if(bandera1.equals("CHI"))
										{
											boct1.setBackgroundResource(R.drawable.chile);
										}else
											if(bandera1.equals("MEX"))
											{
												boct1.setBackgroundResource(R.drawable.mexico);
											}else
												if(bandera1.equals("ECU"))
												{
													boct1.setBackgroundResource(R.drawable.ecuador);
												}else
													if(bandera1.equals("BOL"))
													{
														boct1.setBackgroundResource(R.drawable.bolivia);
													}else
														if(bandera1.equals("ARG"))
														{
															boct1.setBackgroundResource(R.drawable.argentina);
														}else
															if(bandera1.equals("URU"))
															{
																boct1.setBackgroundResource(R.drawable.uruguay);
															}else
																if(bandera1.equals("PAR"))
																{
																	boct1.setBackgroundResource(R.drawable.paraguay);
																}else
																	if(bandera1.equals("JAM"))
																	{
																		boct1.setBackgroundResource(R.drawable.jamaica);
																	}else
																		if(bandera1.equals("BRA"))
																		{
																			boct1.setBackgroundResource(R.drawable.brasil);
																		}else
																			if(bandera1.equals("COL"))
																			{
																				boct1.setBackgroundResource(R.drawable.colombia);
																			}else
																				if(bandera1.equals("PER"))
																				{
																					boct1.setBackgroundResource(R.drawable.peru);
																				}else
																					if(bandera1.equals("VEN"))
																					{
																						boct1.setBackgroundResource(R.drawable.venezuela);
																					}								}

							}else
							{
								grupoa =new String[]{""};
								adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
								adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
								cmbOpciones1.setAdapter(adaptador1);
							}
						}else
							if(list.get(i).getPartido().equals("cuag2"))
							{
								DTOElim dt=list.get(i);
								if(dt!=null)
								{
									
									if(dt.getEmpatev1()>dt.getEmpatev2())
									{
										String bandera1="";
										bandera1=dt.getPais1();
										final String a1[] =new String[]{bandera1};
										adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
										adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones2.setAdapter(adaptador2);
										if(bandera1.equals("CHI"))
										{
											boct2.setBackgroundResource(R.drawable.chile);
										}else
											if(bandera1.equals("MEX"))
											{
												boct2.setBackgroundResource(R.drawable.mexico);
											}else
												if(bandera1.equals("ECU"))
												{
													boct2.setBackgroundResource(R.drawable.ecuador);
												}else
													if(bandera1.equals("BOL"))
													{
														boct2.setBackgroundResource(R.drawable.bolivia);
													}else
														if(bandera1.equals("ARG"))
														{
															boct2.setBackgroundResource(R.drawable.argentina);
														}else
															if(bandera1.equals("URU"))
															{
																boct2.setBackgroundResource(R.drawable.uruguay);
															}else
																if(bandera1.equals("PAR"))
																{
																	boct2.setBackgroundResource(R.drawable.paraguay);
																}else
																	if(bandera1.equals("JAM"))
																	{
																		boct2.setBackgroundResource(R.drawable.jamaica);
																	}else
																		if(bandera1.equals("BRA"))
																		{
																			boct2.setBackgroundResource(R.drawable.brasil);
																		}else
																			if(bandera1.equals("COL"))
																			{
																				boct2.setBackgroundResource(R.drawable.colombia);
																			}else
																				if(bandera1.equals("PER"))
																				{
																					boct2.setBackgroundResource(R.drawable.peru);
																				}else
																					if(bandera1.equals("VEN"))
																					{
																						boct2.setBackgroundResource(R.drawable.venezuela);
																					}
									}else
										if(dt.getEmpatev1()<dt.getEmpatev2())
										{
											String bandera1="";
											bandera1=dt.getPais2();
											final String a1[] =new String[]{bandera1};
											adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
											adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
											cmbOpciones2.setAdapter(adaptador2);
											if(bandera1.equals("CHI"))
											{
												boct2.setBackgroundResource(R.drawable.chile);
											}else
												if(bandera1.equals("MEX"))
												{
													boct2.setBackgroundResource(R.drawable.mexico);
												}else
													if(bandera1.equals("ECU"))
													{
														boct2.setBackgroundResource(R.drawable.ecuador);
													}else
														if(bandera1.equals("BOL"))
														{
															boct2.setBackgroundResource(R.drawable.bolivia);
														}else
															if(bandera1.equals("ARG"))
															{
																boct2.setBackgroundResource(R.drawable.argentina);
															}else
																if(bandera1.equals("URU"))
																{
																	boct2.setBackgroundResource(R.drawable.uruguay);
																}else
																	if(bandera1.equals("PAR"))
																	{
																		boct2.setBackgroundResource(R.drawable.paraguay);
																	}else
																		if(bandera1.equals("JAM"))
																		{
																			boct2.setBackgroundResource(R.drawable.jamaica);
																		}else
																			if(bandera1.equals("BRA"))
																			{
																				boct2.setBackgroundResource(R.drawable.brasil);
																			}else
																				if(bandera1.equals("COL"))
																				{
																					boct2.setBackgroundResource(R.drawable.colombia);
																				}else
																					if(bandera1.equals("PER"))
																					{
																						boct2.setBackgroundResource(R.drawable.peru);
																					}else
																						if(bandera1.equals("VEN"))
																						{
																							boct2.setBackgroundResource(R.drawable.venezuela);
																						}
										}
								}else
								{
									grupob =new String[]{""};
									adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupob);
									adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones2.setAdapter(adaptador2);
								}
							}else
								if(list.get(i).getPartido().equals("cuag3") && list.get(i).getAceptado().equals("true"))
								{
									DTOElim dt=list.get(i);
									if(dt!=null)
									{
										
										if(dt.getEmpatev1()>dt.getEmpatev2())
										{
											String bandera1="";
											bandera1=dt.getPais1();
											final String a1[] =new String[]{bandera1};
											adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
											adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
											cmbOpciones3.setAdapter(adaptador3);
											if(bandera1.equals("CHI"))
											{
												boct3.setBackgroundResource(R.drawable.chile);
											}else
												if(bandera1.equals("MEX"))
												{
													boct3.setBackgroundResource(R.drawable.mexico);
												}else
													if(bandera1.equals("ECU"))
													{
														boct3.setBackgroundResource(R.drawable.ecuador);
													}else
														if(bandera1.equals("BOL"))
														{
															boct3.setBackgroundResource(R.drawable.bolivia);
														}else
															if(bandera1.equals("ARG"))
															{
																boct3.setBackgroundResource(R.drawable.argentina);
															}else
																if(bandera1.equals("URU"))
																{
																	boct3.setBackgroundResource(R.drawable.uruguay);
																}else
																	if(bandera1.equals("PAR"))
																	{
																		boct3.setBackgroundResource(R.drawable.paraguay);
																	}else
																		if(bandera1.equals("JAM"))
																		{
																			boct3.setBackgroundResource(R.drawable.jamaica);
																		}else
																			if(bandera1.equals("BRA"))
																			{
																				boct3.setBackgroundResource(R.drawable.brasil);
																			}else
																				if(bandera1.equals("COL"))
																				{
																					boct3.setBackgroundResource(R.drawable.colombia);
																				}else
																					if(bandera1.equals("PER"))
																					{
																						boct3.setBackgroundResource(R.drawable.peru);
																					}else
																						if(bandera1.equals("VEN"))
																						{
																							boct3.setBackgroundResource(R.drawable.venezuela);
																						}
										}else
											if(dt.getEmpatev1()<dt.getEmpatev2())
											{
												String bandera1="";
												bandera1=dt.getPais2();
												final String a1[] =new String[]{bandera1};
												adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
												adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												cmbOpciones3.setAdapter(adaptador3);
												if(bandera1.equals("CHI"))
												{
													boct3.setBackgroundResource(R.drawable.chile);
												}else
													if(bandera1.equals("MEX"))
													{
														boct3.setBackgroundResource(R.drawable.mexico);
													}else
														if(bandera1.equals("ECU"))
														{
															boct3.setBackgroundResource(R.drawable.ecuador);
														}else
															if(bandera1.equals("BOL"))
															{
																boct3.setBackgroundResource(R.drawable.bolivia);
															}else
																if(bandera1.equals("ARG"))
																{
																	boct3.setBackgroundResource(R.drawable.argentina);
																}else
																	if(bandera1.equals("URU"))
																	{
																		boct3.setBackgroundResource(R.drawable.uruguay);
																	}else
																		if(bandera1.equals("PAR"))
																		{
																			boct3.setBackgroundResource(R.drawable.paraguay);
																		}else
																			if(bandera1.equals("JAM"))
																			{
																				boct3.setBackgroundResource(R.drawable.jamaica);
																			}else
																				if(bandera1.equals("BRA"))
																				{
																					boct3.setBackgroundResource(R.drawable.brasil);
																				}else
																					if(bandera1.equals("COL"))
																					{
																						boct3.setBackgroundResource(R.drawable.colombia);
																					}else
																						if(bandera1.equals("PER"))
																						{
																							boct3.setBackgroundResource(R.drawable.peru);
																						}else
																							if(bandera1.equals("VEN"))
																							{
																								boct3.setBackgroundResource(R.drawable.venezuela);
																							}


											}
									}else
									{
										grupoc =new String[]{""};
										adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoc);
										adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones3.setAdapter(adaptador3);
									}
								}else
									if(list.get(i).getPartido().equals("cuag4") && list.get(i).getAceptado().equals("true"))
									{
										DTOElim dt=list.get(i);
										if(dt!=null)
										{
											String bandera1="";
											if(dt.getEmpatev1()>dt.getEmpatev2())
											{
												bandera1=dt.getPais1();
												final String a1[] =new String[]{bandera1};
												adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
												adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												cmbOpciones4.setAdapter(adaptador4);
												if(bandera1.equals("CHI"))
												{
													boct4.setBackgroundResource(R.drawable.chile);
												}else
													if(bandera1.equals("MEX"))
													{
														boct4.setBackgroundResource(R.drawable.mexico);
													}else
														if(bandera1.equals("ECU"))
														{
															boct4.setBackgroundResource(R.drawable.ecuador);
														}else
															if(bandera1.equals("BOL"))
															{
																boct4.setBackgroundResource(R.drawable.bolivia);
															}else
																if(bandera1.equals("ARG"))
																{
																	boct4.setBackgroundResource(R.drawable.argentina);
																}else
																	if(bandera1.equals("URU"))
																	{
																		boct4.setBackgroundResource(R.drawable.uruguay);
																	}else
																		if(bandera1.equals("PAR"))
																		{
																			boct4.setBackgroundResource(R.drawable.paraguay);
																		}else
																			if(bandera1.equals("JAM"))
																			{
																				boct4.setBackgroundResource(R.drawable.jamaica);
																			}else
																				if(bandera1.equals("BRA"))
																				{
																					boct4.setBackgroundResource(R.drawable.brasil);
																				}else
																					if(bandera1.equals("COL"))
																					{
																						boct4.setBackgroundResource(R.drawable.colombia);
																					}else
																						if(bandera1.equals("PER"))
																						{
																							boct4.setBackgroundResource(R.drawable.peru);
																						}else
																							if(bandera1.equals("VEN"))
																							{
																								boct4.setBackgroundResource(R.drawable.venezuela);
																							}
											}else
												if(dt.getEmpatev1()<dt.getEmpatev2())
												{
													bandera1=dt.getPais2();
													final String a1[] =new String[]{bandera1};
													adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
													adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
													cmbOpciones4.setAdapter(adaptador4);
													if(bandera1.equals("CHI"))
													{
														boct4.setBackgroundResource(R.drawable.chile);
													}else
														if(bandera1.equals("MEX"))
														{
															boct4.setBackgroundResource(R.drawable.mexico);
														}else
															if(bandera1.equals("ECU"))
															{
																boct4.setBackgroundResource(R.drawable.ecuador);
															}else
																if(bandera1.equals("BOL"))
																{
																	boct4.setBackgroundResource(R.drawable.bolivia);
																}else
																	if(bandera1.equals("ARG"))
																	{
																		boct4.setBackgroundResource(R.drawable.argentina);
																	}else
																		if(bandera1.equals("URU"))
																		{
																			boct4.setBackgroundResource(R.drawable.uruguay);
																		}else
																			if(bandera1.equals("PAR"))
																			{
																				boct4.setBackgroundResource(R.drawable.paraguay);
																			}else
																				if(bandera1.equals("JAM"))
																				{
																					boct4.setBackgroundResource(R.drawable.jamaica);
																				}else
																					if(bandera1.equals("BRA"))
																					{
																						boct4.setBackgroundResource(R.drawable.brasil);
																					}else
																						if(bandera1.equals("COL"))
																						{
																							boct4.setBackgroundResource(R.drawable.colombia);
																						}else
																							if(bandera1.equals("PER"))
																							{
																								boct4.setBackgroundResource(R.drawable.peru);
																							}else
																								if(bandera1.equals("VEN"))
																								{
																									boct4.setBackgroundResource(R.drawable.venezuela);
																								}
												}
										}else
										{
											grupod =new String[]{""};
											adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupod);
											adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
											cmbOpciones4.setAdapter(adaptador4);
										}
									}
					}
					if(l.contains("semig1")==true)
					{
						if(list.get(i).getPartido().equals("semig1"))
						{
							DTOElim dt=list.get(i);
							if(dt!=null)
							{
								if(dt.getEmpatev1()>dt.getEmpatev2())
								{
									goct1.setText(String.valueOf(dt.getGoles1()));
									goct1.setEnabled(false);
									goct2.setText(String.valueOf(dt.getGoles2()));
									goct2.setEnabled(false);
									cmbOpciones1.setEnabled(false);
									cmbOpciones2.setEnabled(false);
									rb1.setEnabled(false);
									rb2.setEnabled(false);
									if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
									{
										rb1.setChecked(true);
										rb2.setChecked(false);
									}else
										if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
										{
											rb2.setChecked(true);
											rb1.setChecked(false);
										}
									String bandera1=dt.getPais1();
									String bandera2=dt.getPais2();
									String a1[] =new String[]{bandera1};
									String a2[] =new String[]{bandera2};
									
									adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
									adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones1.setAdapter(adaptador1);
									if(bandera1.equals("CHI"))
									{
										boct1.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera1.equals("MEX"))
										{
											boct1.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera1.equals("ECU"))
											{
												boct1.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera1.equals("BOL"))
												{
													boct1.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera1.equals("ARG"))
													{
														boct1.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera1.equals("URU"))
														{
															boct1.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera1.equals("PAR"))
															{
																boct1.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera1.equals("JAM"))
																{
																	boct1.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera1.equals("BRA"))
																	{
																		boct1.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera1.equals("COL"))
																		{
																			boct1.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera1.equals("PER"))
																			{
																				boct1.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera1.equals("VEN"))
																				{
																					boct1.setBackgroundResource(R.drawable.venezuela);
																				}
									
									adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
									adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones2.setAdapter(adaptador2);
									if(bandera2.equals("CHI"))
									{
										boct2.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera2.equals("MEX"))
										{
											boct2.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera2.equals("ECU"))
											{
												boct2.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera2.equals("BOL"))
												{
													boct2.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera2.equals("ARG"))
													{
														boct2.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera2.equals("URU"))
														{
															boct2.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera2.equals("PAR"))
															{
																boct2.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera2.equals("JAM"))
																{
																	boct2.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera2.equals("BRA"))
																	{
																		boct2.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera2.equals("COL"))
																		{
																			boct2.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera2.equals("PER"))
																			{
																				boct2.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera2.equals("VEN"))
																				{
																					boct2.setBackgroundResource(R.drawable.venezuela);
																				}

								}else
									if(dt.getEmpatev1()<dt.getEmpatev2())
									{
										goct1.setText(String.valueOf(dt.getGoles1()));
										goct1.setEnabled(false);
										goct2.setText(String.valueOf(dt.getGoles2()));
										goct2.setEnabled(false);
										cmbOpciones1.setEnabled(false);
										cmbOpciones2.setEnabled(false);
										rb1.setEnabled(false);
										rb2.setEnabled(false);
										if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
										{
											rb1.setChecked(true);
											rb2.setChecked(false);
										}else
											if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
											{
												rb2.setChecked(true);
												rb1.setChecked(false);
											}
										String bandera1=dt.getPais1();
										String bandera2=dt.getPais2();
										String a1[] =new String[]{bandera1};
										String a2[] =new String[]{bandera2};
										
										adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
										adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones1.setAdapter(adaptador1);
										if(bandera1.equals("CHI"))
										{
											boct1.setBackgroundResource(R.drawable.chile);
										}else
											if(bandera1.equals("MEX"))
											{
												boct1.setBackgroundResource(R.drawable.mexico);
											}else
												if(bandera1.equals("ECU"))
												{
													boct1.setBackgroundResource(R.drawable.ecuador);
												}else
													if(bandera1.equals("BOL"))
													{
														boct1.setBackgroundResource(R.drawable.bolivia);
													}else
														if(bandera1.equals("ARG"))
														{
															boct1.setBackgroundResource(R.drawable.argentina);
														}else
															if(bandera1.equals("URU"))
															{
																boct1.setBackgroundResource(R.drawable.uruguay);
															}else
																if(bandera1.equals("PAR"))
																{
																	boct1.setBackgroundResource(R.drawable.paraguay);
																}else
																	if(bandera1.equals("JAM"))
																	{
																		boct1.setBackgroundResource(R.drawable.jamaica);
																	}else
																		if(bandera1.equals("BRA"))
																		{
																			boct1.setBackgroundResource(R.drawable.brasil);
																		}else
																			if(bandera1.equals("COL"))
																			{
																				boct1.setBackgroundResource(R.drawable.colombia);
																			}else
																				if(bandera1.equals("PER"))
																				{
																					boct1.setBackgroundResource(R.drawable.peru);
																				}else
																					if(bandera1.equals("VEN"))
																					{
																						boct1.setBackgroundResource(R.drawable.venezuela);
																					}


										
										
										adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
										adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones2.setAdapter(adaptador2);
										if(bandera2.equals("CHI"))
										{
											boct2.setBackgroundResource(R.drawable.chile);
										}else
											if(bandera2.equals("MEX"))
											{
												boct2.setBackgroundResource(R.drawable.mexico);
											}else
												if(bandera2.equals("ECU"))
												{
													boct2.setBackgroundResource(R.drawable.ecuador);
												}else
													if(bandera2.equals("BOL"))
													{
														boct2.setBackgroundResource(R.drawable.bolivia);
													}else
														if(bandera2.equals("ARG"))
														{
															boct2.setBackgroundResource(R.drawable.argentina);
														}else
															if(bandera2.equals("URU"))
															{
																boct2.setBackgroundResource(R.drawable.uruguay);
															}else
																if(bandera2.equals("PAR"))
																{
																	boct2.setBackgroundResource(R.drawable.paraguay);
																}else
																	if(bandera2.equals("JAM"))
																	{
																		boct2.setBackgroundResource(R.drawable.jamaica);
																	}else
																		if(bandera2.equals("BRA"))
																		{
																			boct2.setBackgroundResource(R.drawable.brasil);
																		}else
																			if(bandera2.equals("COL"))
																			{
																				boct2.setBackgroundResource(R.drawable.colombia);
																			}else
																				if(bandera2.equals("PER"))
																				{
																					boct2.setBackgroundResource(R.drawable.peru);
																				}else
																					if(bandera2.equals("VEN"))
																					{
																						boct2.setBackgroundResource(R.drawable.venezuela);
																					}
									}

							}else
								{
									grupoa =new String[]{""};
									adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
									adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones2.setAdapter(adaptador1);
		
									grupob =new String[]{""};
									adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupob);
									adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones1.setAdapter(adaptador2);
								}
						}else
							if(list.get(i).getPartido().equals("semig2"))
							{
								DTOElim dt=list.get(i);
								if(dt!=null)
								{
									if(dt.getEmpatev1()>dt.getEmpatev2())
									{
										goct3.setText(String.valueOf(dt.getGoles1()));
										goct3.setEnabled(false);
										goct4.setText(String.valueOf(dt.getGoles2()));
										goct4.setEnabled(false);
										cmbOpciones3.setEnabled(false);
										cmbOpciones4.setEnabled(false);
										rb3.setEnabled(false);
										rb4.setEnabled(false);
										if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
										{
											rb3.setChecked(true);
											rb4.setChecked(false);
										}else
											if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
											{
												rb4.setChecked(true);
												rb3.setChecked(false);
											}
										String bandera1=dt.getPais1();
										String bandera2=dt.getPais2();
										
										String a1[] =new String[]{bandera1};
										String a2[] =new String[]{bandera2};
										adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
										adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones4.setAdapter(adaptador4);
										if(bandera2.equals("CHI"))
										{
											boct4.setBackgroundResource(R.drawable.chile);
										}else
											if(bandera2.equals("MEX"))
											{
												boct4.setBackgroundResource(R.drawable.mexico);
											}else
												if(bandera2.equals("ECU"))
												{
													boct4.setBackgroundResource(R.drawable.ecuador);
												}else
													if(bandera2.equals("BOL"))
													{
														boct4.setBackgroundResource(R.drawable.bolivia);
													}else
														if(bandera2.equals("ARG"))
														{
															boct4.setBackgroundResource(R.drawable.argentina);
														}else
															if(bandera2.equals("URU"))
															{
																boct4.setBackgroundResource(R.drawable.uruguay);
															}else
																if(bandera2.equals("PAR"))
																{
																	boct4.setBackgroundResource(R.drawable.paraguay);
																}else
																	if(bandera2.equals("JAM"))
																	{
																		boct4.setBackgroundResource(R.drawable.jamaica);
																	}else
																		if(bandera2.equals("BRA"))
																		{
																			boct4.setBackgroundResource(R.drawable.brasil);
																		}else
																			if(bandera2.equals("COL"))
																			{
																				boct4.setBackgroundResource(R.drawable.colombia);
																			}else
																				if(bandera2.equals("PER"))
																				{
																					boct4.setBackgroundResource(R.drawable.peru);
																				}else
																					if(bandera2.equals("VEN"))
																					{
																						boct4.setBackgroundResource(R.drawable.venezuela);
																					}
										
										adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
										adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones3.setAdapter(adaptador3);
										if(bandera1.equals("CHI"))
										{
											boct3.setBackgroundResource(R.drawable.chile);
										}else
											if(bandera1.equals("MEX"))
											{
												boct3.setBackgroundResource(R.drawable.mexico);
											}else
												if(bandera1.equals("ECU"))
												{
													boct3.setBackgroundResource(R.drawable.ecuador);
												}else
													if(bandera1.equals("BOL"))
													{
														boct3.setBackgroundResource(R.drawable.bolivia);
													}else
														if(bandera1.equals("ARG"))
														{
															boct3.setBackgroundResource(R.drawable.argentina);
														}else
															if(bandera1.equals("URU"))
															{
																boct3.setBackgroundResource(R.drawable.uruguay);
															}else
																if(bandera1.equals("PAR"))
																{
																	boct3.setBackgroundResource(R.drawable.paraguay);
																}else
																	if(bandera1.equals("JAM"))
																	{
																		boct3.setBackgroundResource(R.drawable.jamaica);
																	}else
																		if(bandera1.equals("BRA"))
																		{
																			boct3.setBackgroundResource(R.drawable.brasil);
																		}else
																			if(bandera1.equals("COL"))
																			{
																				boct3.setBackgroundResource(R.drawable.colombia);
																			}else
																				if(bandera1.equals("PER"))
																				{
																					boct3.setBackgroundResource(R.drawable.peru);
																				}else
																					if(bandera1.equals("VEN"))
																					{
																						boct3.setBackgroundResource(R.drawable.venezuela);
																					}
									}else
										if(dt.getEmpatev1()<dt.getEmpatev2())
										{
											goct3.setText(String.valueOf(dt.getGoles1()));
											goct3.setEnabled(false);
											goct4.setText(String.valueOf(dt.getGoles2()));
											goct4.setEnabled(false);
											cmbOpciones3.setEnabled(false);
											cmbOpciones4.setEnabled(false);
											rb3.setEnabled(false);
											rb4.setEnabled(false);
											if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
											{
												rb3.setChecked(true);
												rb4.setChecked(false);
											}else
												if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
												{
													rb4.setChecked(true);
													rb3.setChecked(false);
												}
											String bandera1=dt.getPais1();
											String bandera2=dt.getPais2();
											String a1[] =new String[]{bandera1};
											String a2[] =new String[]{bandera2};
											adaptador4= new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
											adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
											cmbOpciones4.setAdapter(adaptador4);
											if(bandera2.equals("CHI"))
											{
												boct4.setBackgroundResource(R.drawable.chile);
											}else
												if(bandera2.equals("MEX"))
												{
													boct4.setBackgroundResource(R.drawable.mexico);
												}else
													if(bandera2.equals("ECU"))
													{
														boct4.setBackgroundResource(R.drawable.ecuador);
													}else
														if(bandera2.equals("BOL"))
														{
															boct4.setBackgroundResource(R.drawable.bolivia);
														}else
															if(bandera2.equals("ARG"))
															{
																boct4.setBackgroundResource(R.drawable.argentina);
															}else
																if(bandera2.equals("URU"))
																{
																	boct4.setBackgroundResource(R.drawable.uruguay);
																}else
																	if(bandera2.equals("PAR"))
																	{
																		boct4.setBackgroundResource(R.drawable.paraguay);
																	}else
																		if(bandera2.equals("JAM"))
																		{
																			boct4.setBackgroundResource(R.drawable.jamaica);
																		}else
																			if(bandera2.equals("BRA"))
																			{
																				boct4.setBackgroundResource(R.drawable.brasil);
																			}else
																				if(bandera2.equals("COL"))
																				{
																					boct4.setBackgroundResource(R.drawable.colombia);
																				}else
																					if(bandera2.equals("PER"))
																					{
																						boct4.setBackgroundResource(R.drawable.peru);
																					}else
																						if(bandera2.equals("VEN"))
																						{
																							boct4.setBackgroundResource(R.drawable.venezuela);
																						}
											
											
											adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
											adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
											cmbOpciones3.setAdapter(adaptador3);
											if(bandera1.equals("CHI"))
											{
												boct3.setBackgroundResource(R.drawable.chile);
											}else
												if(bandera1.equals("MEX"))
												{
													boct3.setBackgroundResource(R.drawable.mexico);
												}else
													if(bandera1.equals("ECU"))
													{
														boct3.setBackgroundResource(R.drawable.ecuador);
													}else
														if(bandera1.equals("BOL"))
														{
															boct3.setBackgroundResource(R.drawable.bolivia);
														}else
															if(bandera1.equals("ARG"))
															{
																boct3.setBackgroundResource(R.drawable.argentina);
															}else
																if(bandera1.equals("URU"))
																{
																	boct3.setBackgroundResource(R.drawable.uruguay);
																}else
																	if(bandera1.equals("PAR"))
																	{
																		boct3.setBackgroundResource(R.drawable.paraguay);
																	}else
																		if(bandera1.equals("JAM"))
																		{
																			boct3.setBackgroundResource(R.drawable.jamaica);
																		}else
																			if(bandera1.equals("BRA"))
																			{
																				boct3.setBackgroundResource(R.drawable.brasil);
																			}else
																				if(bandera1.equals("COL"))
																				{
																					boct3.setBackgroundResource(R.drawable.colombia);
																				}else
																					if(bandera1.equals("PER"))
																					{
																						boct3.setBackgroundResource(R.drawable.peru);
																					}else
																						if(bandera1.equals("VEN"))
																						{
																							boct3.setBackgroundResource(R.drawable.venezuela);
																						}
										}
								}else
								{
									grupoc =new String[]{""};
									adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoc);
									adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones4.setAdapter(adaptador3);

									grupod =new String[]{""};
									adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupod);
									adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones3.setAdapter(adaptador4);
								}
							}
					}
				}
			}
			else
				if(list.size()==0)
				{
					grupoa =new String[]{""};
					grupob =new String[]{""};
					grupoc =new String[]{""};
					grupod =new String[]{""};

					adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupob);
					adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
					adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupod);
					adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoc);
				}
			
			
					

			//*********************************************************
			//Seleccion de radiobuttons		
			//*********************************************************

			rb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb2.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb2.setChecked(true);
						}
				}
			});

			rb2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb1.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb1.setChecked(true);
						}
				}
			});

			rb3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb4.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb4.setChecked(true);
						}
				}
			});

			rb4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb3.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb3.setChecked(true);
						}
				}
			});



			//*********************************************************			
			//Seleccion de checkbox para enviar sms.
			//*********************************************************
			
			btnsalvar.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					final LinkedList<DTOElim> listDTO=Controller.getInstancia().getListDTOElim(rootView.getContext());
					if(goct1.length()!=0 && goct2.length()!=0)
					{
						DTOElim dt=new DTOElim();
						dt.setPartido("semig1");
						String bandera1=(String)cmbOpciones1.getSelectedItem();
						String bandera2=(String)cmbOpciones2.getSelectedItem();
						dt.setPais1(bandera1);
						dt.setPais2(bandera2);
						dt.setAceptado("true");
						int g1=Integer.parseInt(goct1.getEditableText().toString());
						int g2=Integer.parseInt(goct2.getEditableText().toString());
						dt.setGoles1(g1);
						dt.setGoles2(g2);
						if(g1>g2)
						{
							rb1.setChecked(true);
							rb2.setChecked(false);
							dt.setEmpatev1(1);
							dt.setEmpatev2(0);
						}else
							if(g2>g1)
							{
								rb2.setChecked(true);
								rb1.setChecked(false);
								dt.setEmpatev1(0);
								dt.setEmpatev2(1);
							}else
								if(g2==g1)
								{
									if(rb1.isChecked()==true)
									{
										dt.setEmpatev1(1);
										dt.setEmpatev2(0);
									}else
										if(rb2.isChecked()==true)
										{
											dt.setEmpatev2(1);
											dt.setEmpatev1(0);
										}
								}
						listDTO.add(dt);
					}
						if(goct3.length()!=0 && goct4.length()!=0 && goct3.isEnabled()!=false && goct4.isEnabled()!=false )
						{
							DTOElim dt=new DTOElim();
							dt.setPartido("semig2");
							String bandera1=(String)cmbOpciones3.getSelectedItem();
							String bandera2=(String)cmbOpciones4.getSelectedItem();
							dt.setPais1(bandera1);
							dt.setPais2(bandera2);
							dt.setAceptado("true");
							int g1=Integer.parseInt(goct3.getEditableText().toString());
							int g2=Integer.parseInt(goct4.getEditableText().toString());
							dt.setGoles1(g1);
							dt.setGoles2(g2);
							if(g1>g2)
							{
								rb3.setChecked(true);
								rb4.setChecked(false);
								dt.setEmpatev1(1);
								dt.setEmpatev2(0);
							}else
								if(g2>g1)
								{
									rb4.setChecked(true);
									rb3.setChecked(false);
									dt.setEmpatev1(0);
									dt.setEmpatev2(1);
								}else
									if(g2==g1)
									{
										if(rb3.isChecked()==true)
										{
											dt.setEmpatev1(1);
											dt.setEmpatev2(0);
										}else
											if(rb4.isChecked()==true)
											{
												dt.setEmpatev2(1);
												dt.setEmpatev1(0);
											}
									}
							listDTO.add(dt);
						}

					if(listDTO.size()!=0)
					{
						for(int i=0;i<listDTO.size();i++)
						{
							if(listDTO.get(i).getPartido().equals("semig1"))
							{
								DTOElim dt=listDTO.get(i);
								Controller.getInstancia().insertElimD(rootView.getContext(),dt.getPartido(),dt.getPais1(),dt.getPais2() , dt.getAceptado() , dt.getGoles1(), dt.getGoles2(),dt.getEmpatev1(),dt.getEmpatev2());
								goct1.setEnabled(false);
								goct2.setEnabled(false);
								cmbOpciones1.setEnabled(false);
								cmbOpciones2.setEnabled(false);
								rb1.setEnabled(false);
								rb2.setEnabled(false);
							}else
								if(listDTO.get(i).getPartido().equals("semig2") )
								{
									DTOElim dt=listDTO.get(i);
									Controller.getInstancia().insertElimD(rootView.getContext(),dt.getPartido(),dt.getPais1(),dt.getPais2() , dt.getAceptado() , dt.getGoles1(), dt.getGoles2(),dt.getEmpatev1(),dt.getEmpatev2());
									goct3.setEnabled(false);
									goct4.setEnabled(false);
									cmbOpciones3.setEnabled(false);
									cmbOpciones4.setEnabled(false);
									rb3.setEnabled(false);
									rb4.setEnabled(false);
								}
						}
					}
				}
			});

			btneditar.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					new AlertDialog.Builder(arg0.getContext()).setTitle("Confirme si desea editar los resultados de la Semifinal")
					.setPositiveButton("Si",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int whichButton) {
							goct1.setEnabled(true);goct4.setEnabled(true);
							goct2.setEnabled(true);goct3.setEnabled(true);
							rb1.setEnabled(true);rb3.setEnabled(true);
							rb2.setEnabled(true);rb4.setEnabled(true);
							try 
							{
								LinkedList<DTOElim> lista=Controller.getInstancia().getListDTOElim(rootView.getContext());
								if(!lista.isEmpty())
								{	
									for (int i = 0; i < lista.size(); i++) 
									{
										if(lista.get(i).getPartido().equalsIgnoreCase("semig1"))
										{
											Controller.getInstancia().EditlimD(rootView.getContext(),lista.get(i).getPartido(),lista.get(i).getGoles1(),lista.get(i).getGoles2());
											goct1.setEnabled(true);
											goct2.setEnabled(true);
											rb1.setEnabled(true);
											rb2.setEnabled(true);
										}else
											if(lista.get(i).getPartido().equalsIgnoreCase("semig2"))
											{
												Controller.getInstancia().EditlimD(rootView.getContext(),lista.get(i).getPartido(),lista.get(i).getGoles1(),lista.get(i).getGoles2());
												goct3.setEnabled(true);
												goct4.setEnabled(true);
												rb3.setEnabled(true);
												rb4.setEnabled(true);
											}else
												if(lista.get(i).getPartido().equalsIgnoreCase("finalg1"))
												{
													Controller.getInstancia().DeleteElimD(rootView.getContext(),lista.get(i).getPartido());
												}else
													if(lista.get(i).getPartido().equalsIgnoreCase("finalg2"))
													{
														Controller.getInstancia().DeleteElimD(rootView.getContext(),lista.get(i).getPartido());
													}
									}
								}
								Controller.getInstancia().getListDTOElim(rootView.getContext()).clear();
							} catch (Exception e1) {
								// TODO: handle exception
							}
							Controller.getInstancia().getListDTO(rootView.getContext()).clear();
						}
					}).setNegativeButton("No", null).show();
				}
			});


			rootView.setOnKeyListener(new OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {
						Intent myIntent =new Intent(v.getContext(), MainActivity.class);
						startActivityForResult(myIntent, 0);
						LinkedList<DTOElim> listDTO=Controller.getInstancia().getListDTOElim(rootView.getContext());
						Controller.getInstancia().getListDTO(rootView.getContext());
						listDTO.clear();
						return true; // consume event, hence do nothing on camera button
					}
					return false;
				}
			});
			//*********************************************************
			return rootView;
		}
	}

	
	public static class FragmentElim22 extends Fragment {

		public FragmentElim22() {}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.elim_fragment22,
					container, false);

			rootView.setOnKeyListener(new OnKeyListener() {

				public boolean onKey(View v, int keyCode, KeyEvent event) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {
						Intent myIntent =new Intent(v.getContext(), MainActivity.class);
						startActivityForResult(myIntent, 0);
						LinkedList<DTOElim> listDTO=Controller.getInstancia().getListDTOElim(rootView.getContext());
						LinkedList<DTO> list=Controller.getInstancia().getListDTO(rootView.getContext());
						listDTO.clear();
						list.clear();
						return true; // consume event, hence do nothing on camera button
					}
					return false;
				}
			});
			//*********************************************************

			return rootView;

		}
	}

	public static class FragmentoElim3 extends Fragment {

		public String[] grupoa =new String[]{""};
		public String[] grupob =new String[]{""};
		public String[] grupoc =new String[]{""};
		public String[] grupod =new String[]{""};

		public EditText goct1,goct2,goct3,goct4;
		public Button boct1,boct2,boct3,boct4;
		public RadioButton rb1,rb2,rb3,rb4;
		public Button btnsalvar,btneditar;
		public ArrayAdapter<String> adaptador1,adaptador2,adaptador3,adaptador4;

		public FragmentoElim3() {}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.elim_fragment3,
					container, false);

			btnsalvar=(Button)rootView.findViewById(R.id.buttong13);
			btneditar=(Button)rootView.findViewById(R.id.buttone13);

			//RadioButtons de cuartos de final
			rb1=(RadioButton)rootView.findViewById(R.id.radioButtonsemi1);
			rb2=(RadioButton)rootView.findViewById(R.id.radioButtonsemi2);
			rb3=(RadioButton)rootView.findViewById(R.id.radioButtonsemi3);
			rb4=(RadioButton)rootView.findViewById(R.id.radioButtonsemi4);

			//Editores de cuartos de final
			goct1=(EditText)rootView.findViewById(R.id.editTextsemi1);
			goct2=(EditText)rootView.findViewById(R.id.editTextsemi2);
			goct3=(EditText)rootView.findViewById(R.id.editTextsemi3);
			goct4=(EditText)rootView.findViewById(R.id.editTextsemi4);

			//Banderas de cuartos de final       (Buttons)
			boct1=(Button)rootView.findViewById(R.id.buttonsemi1);
			boct2=(Button)rootView.findViewById(R.id.buttonsemi2);
			boct3=(Button)rootView.findViewById(R.id.buttonsemi3);
			boct4=(Button)rootView.findViewById(R.id.buttonsemi4);

			final Spinner cmbOpciones1 = (Spinner)rootView.findViewById(R.id.spinnersemi1);
			final Spinner cmbOpciones2 = (Spinner)rootView.findViewById(R.id.spinnersemi2);
			final Spinner cmbOpciones3 = (Spinner)rootView.findViewById(R.id.spinnersemi3);
			final Spinner cmbOpciones4 = (Spinner)rootView.findViewById(R.id.spinnersemi4);
			//Llenando comboboxes con partidos de los octavos
			LinkedList<DTOElim> list=Controller.getInstancia().getListDTOElim(rootView.getContext());
			if(list.size()!=0)
			{
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i).getPartido().equals("semig1"))
					{
						DTOElim dt=list.get(i);
						if(dt!=null)
						{
							if(dt.getEmpatev1()>dt.getEmpatev2())
							{
								String bandera1=dt.getPais1();
								String bandera2=dt.getPais2();
								final String a1[] =new String[]{bandera1};
								final String a2[] =new String[]{bandera2};
								
								adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
								adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
								cmbOpciones3.setAdapter(adaptador1);
								if(bandera1.equals("CHI"))
								{
									boct3.setBackgroundResource(R.drawable.chile);
								}else
									if(bandera1.equals("MEX"))
									{
										boct3.setBackgroundResource(R.drawable.mexico);
									}else
										if(bandera1.equals("ECU"))
										{
											boct3.setBackgroundResource(R.drawable.ecuador);
										}else
											if(bandera1.equals("BOL"))
											{
												boct3.setBackgroundResource(R.drawable.bolivia);
											}else
												if(bandera1.equals("ARG"))
												{
													boct3.setBackgroundResource(R.drawable.argentina);
												}else
													if(bandera1.equals("URU"))
													{
														boct3.setBackgroundResource(R.drawable.uruguay);
													}else
														if(bandera1.equals("PAR"))
														{
															boct3.setBackgroundResource(R.drawable.paraguay);
														}else
															if(bandera1.equals("JAM"))
															{
																boct3.setBackgroundResource(R.drawable.jamaica);
															}else
																if(bandera1.equals("BRA"))
																{
																	boct3.setBackgroundResource(R.drawable.brasil);
																}else
																	if(bandera1.equals("COL"))
																	{
																		boct3.setBackgroundResource(R.drawable.colombia);
																	}else
																		if(bandera1.equals("PER"))
																		{
																			boct3.setBackgroundResource(R.drawable.peru);
																		}else
																			if(bandera1.equals("VEN"))
																			{
																				boct3.setBackgroundResource(R.drawable.venezuela);
																			}
								
								adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
								adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
								cmbOpciones1.setAdapter(adaptador2);
								if(bandera2.equals("CHI"))
								{
									boct1.setBackgroundResource(R.drawable.chile);
								}else
									if(bandera2.equals("MEX"))
									{
										boct1.setBackgroundResource(R.drawable.mexico);
									}else
										if(bandera2.equals("ECU"))
										{
											boct1.setBackgroundResource(R.drawable.ecuador);
										}else
											if(bandera2.equals("BOL"))
											{
												boct1.setBackgroundResource(R.drawable.bolivia);
											}else
												if(bandera2.equals("ARG"))
												{
													boct1.setBackgroundResource(R.drawable.argentina);
												}else
													if(bandera2.equals("URU"))
													{
														boct1.setBackgroundResource(R.drawable.uruguay);
													}else
														if(bandera2.equals("PAR"))
														{
															boct1.setBackgroundResource(R.drawable.paraguay);
														}else
															if(bandera2.equals("JAM"))
															{
																boct1.setBackgroundResource(R.drawable.jamaica);
															}else
																if(bandera2.equals("BRA"))
																{
																	boct1.setBackgroundResource(R.drawable.brasil);
																}else
																	if(bandera2.equals("COL"))
																	{
																		boct1.setBackgroundResource(R.drawable.colombia);
																	}else
																		if(bandera2.equals("PER"))
																		{
																			boct1.setBackgroundResource(R.drawable.peru);
																		}else
																			if(bandera2.equals("VEN"))
																			{
																				boct1.setBackgroundResource(R.drawable.venezuela);
																			}
							}else
								if(dt.getEmpatev1()<dt.getEmpatev2())
								{
									String bandera1=dt.getPais2();
									String bandera2=dt.getPais1();
									final String a1[] =new String[]{bandera1};
									adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
									adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones3.setAdapter(adaptador1);
									if(bandera1.equals("CHI"))
									{
										boct3.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera1.equals("MEX"))
										{
											boct3.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera1.equals("ECU"))
											{
												boct3.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera1.equals("BOL"))
												{
													boct3.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera1.equals("ARG"))
													{
														boct3.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera1.equals("URU"))
														{
															boct3.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera1.equals("PAR"))
															{
																boct3.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera1.equals("JAM"))
																{
																	boct3.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera1.equals("BRA"))
																	{
																		boct3.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera1.equals("COL"))
																		{
																			boct3.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera1.equals("PER"))
																			{
																				boct3.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera1.equals("VEN"))
																				{
																					boct3.setBackgroundResource(R.drawable.venezuela);
																				}


									
									final String a2[] =new String[]{bandera2};
									adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
									adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones1.setAdapter(adaptador2);
									if(bandera2.equals("CHI"))
									{
										boct1.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera2.equals("MEX"))
										{
											boct1.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera2.equals("ECU"))
											{
												boct1.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera2.equals("BOL"))
												{
													boct1.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera2.equals("ARG"))
													{
														boct1.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera2.equals("URU"))
														{
															boct1.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera2.equals("PAR"))
															{
																boct1.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera2.equals("JAM"))
																{
																	boct1.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera2.equals("BRA"))
																	{
																		boct1.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera2.equals("COL"))
																		{
																			boct1.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera2.equals("PER"))
																			{
																				boct1.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera2.equals("VEN"))
																				{
																					boct1.setBackgroundResource(R.drawable.venezuela);
																				}
								}

						}else
						{
							grupoa =new String[]{""};
							adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
							adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones3.setAdapter(adaptador1);

							grupob =new String[]{""};
							adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupob);
							adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							cmbOpciones1.setAdapter(adaptador2);
						}
					}else
						if(list.get(i).getPartido().equals("semig2"))
						{
							DTOElim dt=list.get(i);
							if(dt!=null)
							{
								if(dt.getEmpatev1()>dt.getEmpatev2())
								{
									String bandera1=dt.getPais1();
									String bandera2=dt.getPais2();
									final String a1[] =new String[]{bandera1};
									adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
									adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones4.setAdapter(adaptador3);
									if(bandera1.equals("CHI"))
									{
										boct4.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera1.equals("MEX"))
										{
											boct4.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera1.equals("ECU"))
											{
												boct4.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera1.equals("BOL"))
												{
													boct4.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera1.equals("ARG"))
													{
														boct4.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera1.equals("URU"))
														{
															boct4.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera1.equals("PAR"))
															{
																boct4.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera1.equals("JAM"))
																{
																	boct4.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera1.equals("BRA"))
																	{
																		boct4.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera1.equals("COL"))
																		{
																			boct4.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera1.equals("PER"))
																			{
																				boct4.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera1.equals("VEN"))
																				{
																					boct4.setBackgroundResource(R.drawable.venezuela);
																				}
									
									final String a2[] =new String[]{bandera2};
									adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
									adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									cmbOpciones2.setAdapter(adaptador4);
									if(bandera2.equals("CHI"))
									{
										boct2.setBackgroundResource(R.drawable.chile);
									}else
										if(bandera2.equals("MEX"))
										{
											boct2.setBackgroundResource(R.drawable.mexico);
										}else
											if(bandera2.equals("ECU"))
											{
												boct2.setBackgroundResource(R.drawable.ecuador);
											}else
												if(bandera2.equals("BOL"))
												{
													boct2.setBackgroundResource(R.drawable.bolivia);
												}else
													if(bandera2.equals("ARG"))
													{
														boct2.setBackgroundResource(R.drawable.argentina);
													}else
														if(bandera2.equals("URU"))
														{
															boct2.setBackgroundResource(R.drawable.uruguay);
														}else
															if(bandera2.equals("PAR"))
															{
																boct2.setBackgroundResource(R.drawable.paraguay);
															}else
																if(bandera2.equals("JAM"))
																{
																	boct2.setBackgroundResource(R.drawable.jamaica);
																}else
																	if(bandera2.equals("BRA"))
																	{
																		boct2.setBackgroundResource(R.drawable.brasil);
																	}else
																		if(bandera2.equals("COL"))
																		{
																			boct2.setBackgroundResource(R.drawable.colombia);
																		}else
																			if(bandera2.equals("PER"))
																			{
																				boct2.setBackgroundResource(R.drawable.peru);
																			}else
																				if(bandera2.equals("VEN"))
																				{
																					boct2.setBackgroundResource(R.drawable.venezuela);
																				}
								}else
									if(dt.getEmpatev1()<dt.getEmpatev2())
									{
										String bandera1=dt.getPais2();
										String bandera2=dt.getPais1();
										final String a2[] =new String[]{bandera2};
										final String a1[] =new String[]{bandera1};
										adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a1);
										adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones4.setAdapter(adaptador3);
										if(bandera1.equals("CHI"))
										{
											boct4.setBackgroundResource(R.drawable.chile);
										}else
											if(bandera1.equals("MEX"))
											{
												boct4.setBackgroundResource(R.drawable.mexico);
											}else
												if(bandera1.equals("ECU"))
												{
													boct4.setBackgroundResource(R.drawable.ecuador);
												}else
													if(bandera1.equals("BOL"))
													{
														boct4.setBackgroundResource(R.drawable.bolivia);
													}else
														if(bandera1.equals("ARG"))
														{
															boct4.setBackgroundResource(R.drawable.argentina);
														}else
															if(bandera1.equals("URU"))
															{
																boct4.setBackgroundResource(R.drawable.uruguay);
															}else
																if(bandera1.equals("PAR"))
																{
																	boct4.setBackgroundResource(R.drawable.paraguay);
																}else
																	if(bandera1.equals("JAM"))
																	{
																		boct4.setBackgroundResource(R.drawable.jamaica);
																	}else
																		if(bandera1.equals("BRA"))
																		{
																			boct4.setBackgroundResource(R.drawable.brasil);
																		}else
																			if(bandera1.equals("COL"))
																			{
																				boct4.setBackgroundResource(R.drawable.colombia);
																			}else
																				if(bandera1.equals("PER"))
																				{
																					boct4.setBackgroundResource(R.drawable.peru);
																				}else
																					if(bandera1.equals("VEN"))
																					{
																						boct4.setBackgroundResource(R.drawable.venezuela);
																					}
										
										adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, a2);
										adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
										cmbOpciones2.setAdapter(adaptador4);
										if(bandera2.equals("CHI"))
										{
											boct2.setBackgroundResource(R.drawable.chile);
										}else
											if(bandera2.equals("MEX"))
											{
												boct2.setBackgroundResource(R.drawable.mexico);
											}else
												if(bandera2.equals("ECU"))
												{
													boct2.setBackgroundResource(R.drawable.ecuador);
												}else
													if(bandera2.equals("BOL"))
													{
														boct2.setBackgroundResource(R.drawable.bolivia);
													}else
														if(bandera2.equals("ARG"))
														{
															boct2.setBackgroundResource(R.drawable.argentina);
														}else
															if(bandera2.equals("URU"))
															{
																boct2.setBackgroundResource(R.drawable.uruguay);
															}else
																if(bandera2.equals("PAR"))
																{
																	boct2.setBackgroundResource(R.drawable.paraguay);
																}else
																	if(bandera2.equals("JAM"))
																	{
																		boct2.setBackgroundResource(R.drawable.jamaica);
																	}else
																		if(bandera2.equals("BRA"))
																		{
																			boct2.setBackgroundResource(R.drawable.brasil);
																		}else
																			if(bandera2.equals("COL"))
																			{
																				boct2.setBackgroundResource(R.drawable.colombia);
																			}else
																				if(bandera2.equals("PER"))
																				{
																					boct2.setBackgroundResource(R.drawable.peru);
																				}else
																					if(bandera2.equals("VEN"))
																					{
																						boct2.setBackgroundResource(R.drawable.venezuela);
																					}
									}
							}else
							{
								grupoc =new String[]{""};
								adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoc);
								adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
								cmbOpciones4.setAdapter(adaptador3);

								grupod =new String[]{""};
								adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupod);
								adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
								cmbOpciones2.setAdapter(adaptador4);
							}
						}
				}
			}else
				if(list.size()==0)
				{
					grupoa =new String[]{""};
					grupob =new String[]{""};
					grupoc =new String[]{""};
					grupod =new String[]{""};

					adaptador1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupob);
					adaptador2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoa);
					adaptador3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupod);
					adaptador4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, grupoc);
				}

			//*******************************************************************

			LinkedList<DTOElim> listcua=Controller.getInstancia().getListDTOElim(rootView.getContext());
			if(listcua.size()!=0)
			{
				for(int i=0;i<listcua.size();i++)
				{
					if(listcua.get(i).getPartido().equals("finalg1"))
					{
						DTOElim dt=listcua.get(i);
						goct1.setText(String.valueOf(dt.getGoles1()));
						goct1.setEnabled(false);
						goct2.setText(String.valueOf(dt.getGoles2()));
						goct2.setEnabled(false);
						cmbOpciones1.setEnabled(false);
						cmbOpciones2.setEnabled(false);
						rb1.setEnabled(false);
						rb2.setEnabled(false);
						if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
						{
							rb1.setChecked(true);
							rb2.setChecked(false);
						}else
							if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
							{
								rb2.setChecked(true);
								rb1.setChecked(false);
							}
						String bandera1=dt.getPais1();
						String bandera2=dt.getPais2();
						if(bandera1.equals("CHI"))
						{
							boct1.setBackgroundResource(R.drawable.chile);
						}else
							if(bandera1.equals("MEX"))
							{
								boct1.setBackgroundResource(R.drawable.mexico);
							}else
								if(bandera1.equals("ECU"))
								{
									boct1.setBackgroundResource(R.drawable.ecuador);
								}else
									if(bandera1.equals("BOL"))
									{
										boct1.setBackgroundResource(R.drawable.bolivia);
									}else
										if(bandera1.equals("ARG"))
										{
											boct1.setBackgroundResource(R.drawable.argentina);
										}else
											if(bandera1.equals("URU"))
											{
												boct1.setBackgroundResource(R.drawable.uruguay);
											}else
												if(bandera1.equals("PAR"))
												{
													boct1.setBackgroundResource(R.drawable.paraguay);
												}else
													if(bandera1.equals("JAM"))
													{
														boct1.setBackgroundResource(R.drawable.jamaica);
													}else
														if(bandera1.equals("BRA"))
														{
															boct1.setBackgroundResource(R.drawable.brasil);
														}else
															if(bandera1.equals("COL"))
															{
																boct1.setBackgroundResource(R.drawable.colombia);
															}else
																if(bandera1.equals("PER"))
																{
																	boct1.setBackgroundResource(R.drawable.peru);
																}else
																	if(bandera1.equals("VEN"))
																	{
																		boct1.setBackgroundResource(R.drawable.venezuela);
																	}



						if(bandera2.equals("CHI"))
						{
							boct2.setBackgroundResource(R.drawable.chile);
						}else
							if(bandera2.equals("MEX"))
							{
								boct2.setBackgroundResource(R.drawable.mexico);
							}else
								if(bandera2.equals("ECU"))
								{
									boct2.setBackgroundResource(R.drawable.ecuador);
								}else
									if(bandera2.equals("BOL"))
									{
										boct2.setBackgroundResource(R.drawable.bolivia);
									}else
										if(bandera2.equals("ARG"))
										{
											boct2.setBackgroundResource(R.drawable.argentina);
										}else
											if(bandera2.equals("URU"))
											{
												boct2.setBackgroundResource(R.drawable.uruguay);
											}else
												if(bandera2.equals("PAR"))
												{
													boct2.setBackgroundResource(R.drawable.paraguay);
												}else
													if(bandera2.equals("JAM"))
													{
														boct2.setBackgroundResource(R.drawable.jamaica);
													}else
														if(bandera2.equals("BRA"))
														{
															boct2.setBackgroundResource(R.drawable.brasil);
														}else
															if(bandera2.equals("COL"))
															{
																boct2.setBackgroundResource(R.drawable.colombia);
															}else
																if(bandera2.equals("PER"))
																{
																	boct2.setBackgroundResource(R.drawable.peru);
																}else
																	if(bandera2.equals("VEN"))
																	{
																		boct2.setBackgroundResource(R.drawable.venezuela);
																	}


					}
					else
						if(listcua.get(i).getPartido().equals("finalg2"))
						{
							DTOElim dt=listcua.get(i);
							goct3.setText(String.valueOf(dt.getGoles1()));
							goct3.setEnabled(false);
							goct4.setText(String.valueOf(dt.getGoles2()));
							goct4.setEnabled(false);
							cmbOpciones3.setEnabled(false);
							cmbOpciones4.setEnabled(false);
							rb3.setEnabled(false);
							rb4.setEnabled(false);
							if(dt.getEmpatev1()==1 && dt.getEmpatev2()==0)
							{
								rb3.setChecked(true);
								rb4.setChecked(false);
							}else
								if(dt.getEmpatev2()==1 && dt.getEmpatev1()==0)
								{
									rb4.setChecked(true);
									rb3.setChecked(false);
								}
							String bandera1=dt.getPais1();
							String bandera2=dt.getPais2();
							if(bandera1.equals("CHI"))
							{
								boct3.setBackgroundResource(R.drawable.chile);
							}else
								if(bandera1.equals("MEX"))
								{
									boct3.setBackgroundResource(R.drawable.mexico);
								}else
									if(bandera1.equals("ECU"))
									{
										boct3.setBackgroundResource(R.drawable.ecuador);
									}else
										if(bandera1.equals("BOL"))
										{
											boct3.setBackgroundResource(R.drawable.bolivia);
										}else
											if(bandera1.equals("ARG"))
											{
												boct3.setBackgroundResource(R.drawable.argentina);
											}else
												if(bandera1.equals("URU"))
												{
													boct3.setBackgroundResource(R.drawable.uruguay);
												}else
													if(bandera1.equals("PAR"))
													{
														boct3.setBackgroundResource(R.drawable.paraguay);
													}else
														if(bandera1.equals("JAM"))
														{
															boct3.setBackgroundResource(R.drawable.jamaica);
														}else
															if(bandera1.equals("BRA"))
															{
																boct3.setBackgroundResource(R.drawable.brasil);
															}else
																if(bandera1.equals("COL"))
																{
																	boct3.setBackgroundResource(R.drawable.colombia);
																}else
																	if(bandera1.equals("PER"))
																	{
																		boct3.setBackgroundResource(R.drawable.peru);
																	}else
																		if(bandera1.equals("VEN"))
																		{
																			boct3.setBackgroundResource(R.drawable.venezuela);
																		}



							if(bandera2.equals("CHI"))
							{
								boct4.setBackgroundResource(R.drawable.chile);
							}else
								if(bandera2.equals("MEX"))
								{
									boct4.setBackgroundResource(R.drawable.mexico);
								}else
									if(bandera2.equals("ECU"))
									{
										boct4.setBackgroundResource(R.drawable.ecuador);
									}else
										if(bandera2.equals("BOL"))
										{
											boct4.setBackgroundResource(R.drawable.bolivia);
										}else
											if(bandera2.equals("ARG"))
											{
												boct4.setBackgroundResource(R.drawable.argentina);
											}else
												if(bandera2.equals("URU"))
												{
													boct4.setBackgroundResource(R.drawable.uruguay);
												}else
													if(bandera2.equals("PAR"))
													{
														boct4.setBackgroundResource(R.drawable.paraguay);
													}else
														if(bandera2.equals("JAM"))
														{
															boct4.setBackgroundResource(R.drawable.jamaica);
														}else
															if(bandera2.equals("BRA"))
															{
																boct4.setBackgroundResource(R.drawable.brasil);
															}else
																if(bandera2.equals("COL"))
																{
																	boct4.setBackgroundResource(R.drawable.colombia);
																}else
																	if(bandera2.equals("PER"))
																	{
																		boct4.setBackgroundResource(R.drawable.peru);
																	}else
																		if(bandera2.equals("VEN"))
																		{
																			boct4.setBackgroundResource(R.drawable.venezuela);
																		}


						}
				}
			}
			if(listcua.size()==0)
			{

			}

			//*********************************************************
			//Seleccion de radiobuttons		
			//*********************************************************

			rb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb2.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb2.setChecked(true);
						}
				}
			});

			rb2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb1.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb1.setChecked(true);
						}
				}
			});

			rb3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb4.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb4.setChecked(true);
						}
				}
			});

			rb4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked==true)
					{
						rb3.setChecked(false);
					}else
						if(isChecked==false)
						{
							rb3.setChecked(true);
						}
				}
			});



			//*********************************************************			
			//Seleccion de checkbox para enviar sms.
			//*********************************************************
			
			btnsalvar.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					final LinkedList<DTOElim> listDTO=Controller.getInstancia().getListDTOElim(rootView.getContext());
					if(goct1.length()!=0 && goct2.length()!=0 && goct1.isEnabled()!=false && goct2.isEnabled()!=false )
					{
						DTOElim dt=new DTOElim();
						dt.setPartido("finalg1");
						String bandera1=(String)cmbOpciones1.getSelectedItem();
						String bandera2=(String)cmbOpciones2.getSelectedItem();
						dt.setPais1(bandera1);
						dt.setPais2(bandera2);
						dt.setAceptado("true");
						int g1=Integer.parseInt(goct1.getEditableText().toString());
						int g2=Integer.parseInt(goct2.getEditableText().toString());
						dt.setGoles1(g1);
						dt.setGoles2(g2);
						if(g1>g2)
						{
							rb1.setChecked(true);
							rb2.setChecked(false);
							dt.setEmpatev1(1);
							dt.setEmpatev2(0);
						}else
							if(g2>g1)
							{
								rb2.setChecked(true);
								rb1.setChecked(false);
								dt.setEmpatev1(0);
								dt.setEmpatev2(1);
							}else
								if(g2==g1)
								{
									if(rb1.isChecked()==true)
									{
										dt.setEmpatev1(1);
										dt.setEmpatev2(0);
									}else
										if(rb2.isChecked()==true)
										{
											dt.setEmpatev2(1);
											dt.setEmpatev1(0);
										}
								}
						listDTO.add(dt);
					}
						if(goct3.length()!=0 && goct4.length()!=0 && goct3.isEnabled()!=false && goct4.isEnabled()!=false )
						{

							DTOElim dt=new DTOElim();
							dt.setPartido("finalg2");
							String bandera1=(String)cmbOpciones3.getSelectedItem();
							String bandera2=(String)cmbOpciones4.getSelectedItem();
							dt.setPais1(bandera1);
							dt.setPais2(bandera2);
							dt.setAceptado("true");
							int g1=Integer.parseInt(goct3.getEditableText().toString());
							int g2=Integer.parseInt(goct4.getEditableText().toString());
							dt.setGoles1(g1);
							dt.setGoles2(g2);
							if(g1>g2)
							{
								rb3.setChecked(true);
								rb4.setChecked(false);
								dt.setEmpatev1(1);
								dt.setEmpatev2(0);
							}else
								if(g2>g1)
								{
									rb4.setChecked(true);
									rb3.setChecked(false);
									dt.setEmpatev1(0);
									dt.setEmpatev2(1);
								}else
									if(g2==g1)
									{
										if(rb3.isChecked()==true)
										{
											dt.setEmpatev1(1);
											dt.setEmpatev2(0);
										}else
											if(rb4.isChecked()==true)
											{
												dt.setEmpatev2(1);
												dt.setEmpatev1(0);
											}
									}
							listDTO.add(dt);
						}

					if(listDTO.size()!=0)
					{
						for(int i=0;i<listDTO.size();i++)
						{
							if(listDTO.get(i).getPartido().equals("finalg1"))
							{
								DTOElim dt=listDTO.get(i);
								Controller.getInstancia().insertElimD(rootView.getContext(),dt.getPartido(),dt.getPais1(),dt.getPais2() , dt.getAceptado() , dt.getGoles1(), dt.getGoles2(),dt.getEmpatev1(),dt.getEmpatev2());
								goct1.setEnabled(false);
								goct2.setEnabled(false);
								cmbOpciones1.setEnabled(false);
								cmbOpciones2.setEnabled(false);
								rb1.setEnabled(false);
								rb2.setEnabled(false);
							}else
								if(listDTO.get(i).getPartido().equals("finalg2") )
								{
									DTOElim dt=listDTO.get(i);
									Controller.getInstancia().insertElimD(rootView.getContext(),dt.getPartido(),dt.getPais1(),dt.getPais2() , dt.getAceptado() , dt.getGoles1(), dt.getGoles2(),dt.getEmpatev1(),dt.getEmpatev2());
									goct3.setEnabled(false);
									goct4.setEnabled(false);
									cmbOpciones3.setEnabled(false);
									cmbOpciones4.setEnabled(false);
									rb3.setEnabled(false);
									rb4.setEnabled(false);
								}
						}
					}
				}
			});

			btneditar.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					new AlertDialog.Builder(arg0.getContext()).setTitle("Confirme si desea editar los resultados de la Final")
					.setPositiveButton("Si",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int whichButton) {
							goct1.setEnabled(true);goct4.setEnabled(true);
							goct2.setEnabled(true);goct3.setEnabled(true);
							rb1.setEnabled(true);rb3.setEnabled(true);
							rb2.setEnabled(true);rb4.setEnabled(true);
							try 
							{
								LinkedList<DTOElim> lista=Controller.getInstancia().getListDTOElim(rootView.getContext());
								if(!lista.isEmpty())
								{	
									for (int i = 0; i < lista.size(); i++) 
									{
										if(lista.get(i).getPartido().equalsIgnoreCase("finalg1"))
										{
											Controller.getInstancia().EditlimD(rootView.getContext(),lista.get(i).getPartido(),lista.get(i).getGoles1(),lista.get(i).getGoles2());
											goct1.setEnabled(true);
											goct2.setEnabled(true);
											rb1.setEnabled(true);
											rb2.setEnabled(true);
										}else
											if(lista.get(i).getPartido().equalsIgnoreCase("finalg2"))
											{
												Controller.getInstancia().EditlimD(rootView.getContext(),lista.get(i).getPartido(),lista.get(i).getGoles1(),lista.get(i).getGoles2());
												goct3.setEnabled(true);
												goct4.setEnabled(true);
												rb3.setEnabled(true);
												rb4.setEnabled(true);
											}
									}
								}
								Controller.getInstancia().getListDTOElim(rootView.getContext()).clear();
							} catch (Exception e1) {
								// TODO: handle exception
							}
							Controller.getInstancia().getListDTO(rootView.getContext()).clear();
						}
					}).setNegativeButton("No", null).show();
				}
			});


			rootView.setOnKeyListener(new OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					if (keyCode == KeyEvent.KEYCODE_BACK) {
						Intent myIntent =new Intent(v.getContext(), MainActivity.class);
						startActivityForResult(myIntent, 0);
						LinkedList<DTOElim> listDTO=Controller.getInstancia().getListDTOElim(rootView.getContext());
						Controller.getInstancia().getListDTO(rootView.getContext());
						listDTO.clear();
						return true; // consume event, hence do nothing on camera button
					}
					return false;
				}
			});
			//*********************************************************


			return rootView;
		}
	}
}
