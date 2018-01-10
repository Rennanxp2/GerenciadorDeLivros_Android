package app.Activities.catalogo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import app.BdsSqliteHelper.BDSQLiteHelper;
import app.LivroAdapter.LivroAdapter;
import app.catalogolivros.R;
import app.livroDAO.Livro;

public class ListarCategoria extends Activity {

	private BDSQLiteHelper bd;
	private ArrayList<Livro> listaLivros;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_categoria);

		bd = new BDSQLiteHelper(this);

		final ListView lista = (ListView) findViewById(R.id.lvCategoria);
		final Spinner categoria = (Spinner) findViewById(R.id.spinnerCategoria);
		
		
		categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selected = parent.getItemAtPosition(position).toString();
				ListView lista = (ListView) findViewById(R.id.lvCategoria);
				listaLivros = bd.getAllCategoria(selected);
				LivroAdapter adapter = new LivroAdapter(parent.getContext(), listaLivros);
				lista.setAdapter(adapter);
				
			}
		});
		
		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				Intent intent = new Intent(ListarCategoria.this, InformacaoLivro.class);

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