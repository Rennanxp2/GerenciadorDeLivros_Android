package app.Activities.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import app.Activities.Administracao.Administrador;
import app.Activities.catalogo.MainActivity;
import app.catalogolivros.R;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
	}
	
	public void editar(View botao) {
		startActivity(new Intent(this, AltSenha.class));
	}
	
	public void equipe(View botao) {
		startActivity(new Intent(this,Equipe.class));
	}
	public void catalogo(View botao) {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
	public void administracao(View botao) {
		startActivity(new Intent(this, Administrador.class));
		finish();
	}
	
	public void sair(View botao) {
		startActivity(new Intent(this, Login.class));
		finish();
	}
}
