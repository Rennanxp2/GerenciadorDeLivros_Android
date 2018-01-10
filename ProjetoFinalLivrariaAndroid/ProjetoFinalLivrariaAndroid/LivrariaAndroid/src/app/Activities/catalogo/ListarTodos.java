package app.Activities.catalogo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import app.BdsSqliteHelper.BDSQLiteHelper;
import app.LivroAdapter.LivroAdapter;
import app.catalogolivros.R;
import app.livroDAO.Livro;

public class ListarTodos extends Activity {

	private BDSQLiteHelper bd;
	ArrayList<Livro> listaLivros;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_todos);

		bd = new BDSQLiteHelper(this);

	}

	@Override
	protected void onStart() {

		super.onStart();
		ListView lista = (ListView) findViewById(R.id.lvLivros);
		listaLivros = bd.getAllLivros();
		LivroAdapter adapter = new LivroAdapter(this, listaLivros);
		lista.setAdapter(adapter);

		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				Intent intent = new Intent(ListarTodos.this, InformacaoLivro.class);

				intent.putExtra("titulo", listaLivros.get(i).getTitulo());
				intent.putExtra("subtitulo", listaLivros.get(i).getSubTitulo());
				intent.putExtra("autor", listaLivros.get(i).getAutor());
				intent.putExtra("isbn", listaLivros.get(i).getIsbn());
				intent.putExtra("editora", listaLivros.get(i).getEditora());
				intent.putExtra("edicao", listaLivros.get(i).getEdicao());
				intent.putExtra("ano", listaLivros.get(i).getAno());
				intent.putExtra("paginas", listaLivros.get(i).getPaginas());
				intent.putExtra("categoria", listaLivros.get(i).getCategoria());

				startActivity(intent);

			}
		});
	}
	public void Voltar (View botao) {
		finish();
	}

}
