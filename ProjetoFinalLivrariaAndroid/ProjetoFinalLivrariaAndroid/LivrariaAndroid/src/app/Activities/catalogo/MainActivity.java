package app.Activities.catalogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import app.Activities.login.Principal;
import app.catalogolivros.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void AddLivro(View botao) {
		Intent intent = new Intent(this, AddLivroActivity.class);
		startActivity(intent);
	}

	public void Todos(View botao) {
		Intent intent = new Intent(this, ListarTodos.class);
		startActivity(intent);
	}

	public void Categoria(View botao) {
		Intent intent = new Intent(this, ListarCategoria.class);
		startActivity(intent);
	}

	public void Titulo(View botao) {
		Intent intent = new Intent(this, PesquisaLivro.class);
		startActivity(intent);
	}

	public void Update(View botao) {
		Intent intent = new Intent(this, UpdateDelete.class);
		startActivity(intent);
	}
	public void voltar(View botao) {
		Intent intent = new Intent(this, Principal.class);
		startActivity(intent);
	}
}
