package app.Activities.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import app.catalogolivros.R;

public class Equipe extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.equipe);
	}
	
	public void fechar(View botao) {
		finish();
	}
}
