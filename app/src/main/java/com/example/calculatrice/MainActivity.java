package com.example.calculatrice;

import com.example.calculatrice.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import parseur_expression_mathematique.exception.ParsingException;
import parseur_expression_mathematique.metier.ParseurMath;


public class MainActivity extends Activity {


	private String a;
	private TextView afficheur;
	private boolean affAEffacer;

	/**
	 * Met en place les écouteurs
	 */
	public void initConnection() {

		Button button = null;

		button = (Button) this.findViewById(R.id.bt_un);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_plus);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_deux);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_egale);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_backspace);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_ac);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_point);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_neuf);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_trois);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_cinq);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_div);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_fois);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_moins);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_quatre);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_huit);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_six);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_sept);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_zero);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		button = (Button) this.findViewById(R.id.bt_backspace);
		button.setTag(button.getText().toString());
		button.setOnClickListener(new EcouteurBouton());
		if(this.getScreenOrientation()==Configuration.ORIENTATION_LANDSCAPE) {
			button = (Button) this.findViewById(R.id.bt_parentOuv);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_log);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_parentFerm);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_abs);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_acos);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_asin);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_atan);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_cos);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_sin);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_tan);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());

			button = (Button) this.findViewById(R.id.bt_ln);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_norm);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_rac);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
			button = (Button) this.findViewById(R.id.bt_puiss);
			button.setTag(button.getText().toString());
			button.setOnClickListener(new EcouteurBouton());
		}

	}


	/**
	 * Permet de détécter l'orientation de l'écran du terminal
	 *
	 * @return (int) : Configuration.ORIENTATION_PORTRAIT si position portrait
	 * Configuration.ORIENTATION_LANDSCAPE si payasage
	 */
	public int getScreenOrientation() {
		Display getOrient = getWindowManager().getDefaultDisplay();
		int orientation = Configuration.ORIENTATION_UNDEFINED;
		if (getOrient.getWidth() == getOrient.getHeight()) {
			orientation = Configuration.ORIENTATION_SQUARE;
		} else {
			if (getOrient.getWidth() < getOrient.getHeight()) {
				orientation = Configuration.ORIENTATION_PORTRAIT;
			} else {
				orientation = Configuration.ORIENTATION_LANDSCAPE;
			}
		}
		return orientation;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		this.afficheur = (TextView) findViewById(R.id.textView1);
		initConnection();


		if(savedInstanceState!=null){
			String c = savedInstanceState.getString("calcul","toto");
			Toast.makeText(this,"sauvegarde"+c,Toast.LENGTH_SHORT).show();

			this.afficheur.setText(c);
		}else
			this.afficheur.setText("pas de restauration");

		/**
		/**
		 * Exemple d'utilisation du parseur
		 */


	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}




	@Override
	protected void onSaveInstanceState(Bundle outState) {

		this.afficheur = (TextView) findViewById(R.id.textView1);
		outState.putString("calcul", (String) this.afficheur.getText().toString());
		super.onSaveInstanceState(outState);
		Toast.makeText(this,"sauvegarde",Toast.LENGTH_SHORT).show();

	}

	class EcouteurBouton implements View.OnClickListener {
		private ParseurMath p = ParseurMath.getInstance();
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			String saisie = v.getTag().toString();
			TextView t = (TextView) findViewById(R.id.textView1);
			if(v.getId()==R.id.bt_egale) {

				try {

					t.setText(t.getText()+"="+p.parseDouble(t.getText().toString()));
				} catch (ParsingException e) {
					e.printStackTrace();
				}
			}else if(v.getId()==R.id.bt_backspace&&t.getText().length()!=0){
				t.setText(t.getText().toString().substring(0, t.getText().toString().length() - 1));
			}else if(v.getId()==R.id.bt_ac){
				t.setText("");
			}else if(v.getId()!=R.id.bt_backspace)

				t.setText(t.getText() + saisie);

		}
	}

}
