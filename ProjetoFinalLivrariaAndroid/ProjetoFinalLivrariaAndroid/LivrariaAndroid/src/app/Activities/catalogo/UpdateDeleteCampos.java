package app.Activities.catalogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import app.Activities.Administracao.Administrador;
import app.Activities.login.Principal;
import app.BdsSqliteHelper.BDSQLiteHelper;
import app.catalogolivros.R;
import app.livroDAO.Livro;

public class UpdateDeleteCampos extends Activity {

	private BDSQLiteHelper bd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_delete_campos);

		Intent intent = getIntent();
		final int id = intent.getIntExtra("ID", 0);
		bd = new BDSQLiteHelper(this);
		Livro livro = bd.getLivro(id);

		final EditText titulo = (EditText) findViewById(R.id.edTitulo);
		final EditText subtitulo = (EditText) findViewById(R.id.edSubtitulo);
		final EditText autor = (EditText) findViewById(R.id.edAutor);
		final EditText isbn = (EditText) findViewById(R.id.edIsbn);
		final EditText editora = (EditText) findViewById(R.id.edEditora);
		final EditText edicao = (EditText) findViewById(R.id.edEdicao);
		final EditText ano = (EditText) findViewById(R.id.edAno);
		final EditText paginas = (EditText) findViewById(R.id.edPaginas);
		final Spinner categoria = (Spinner) findViewById(R.id.edCategoria);

		titulo.setText(livro.getTitulo());
		subtitulo.setText(livro.getSubTitulo());
		autor.setText(livro.getAutor());
		isbn.setText(livro.getIsbn());
		editora.setText(livro.getEditora());
		edicao.setText(livro.getEdicao());
		ano.setText(livro.getAno());
		paginas.setText(livro.getPaginas());

		Button atualizar = (Button) findViewById(R.id.btnAtualizar);
		atualizar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Livro livro = new Livro();
				livro.setId(id);

				livro.setTitulo(titulo.getText().toString());
				livro.setSubTitulo(subtitulo.getText().toString());
				livro.setAutor(autor.getText().toString());
				livro.setIsbn(isbn.getText().toString());
				livro.setEditora(editora.getText().toString());
				livro.setEdicao(edicao.getText().toString());
				livro.setAno(ano.getText().toString());
				livro.setPaginas(paginas.getText().toString());
				livro.setCategoria(categoria.getSelectedItem().toString());

				bd.updateLivro(livro);

				Toast.makeText(getBaseContext(), "Livro alterado com sucesso.", Toast.LENGTH_SHORT).show();

				Intent intent = new Intent(UpdateDeleteCampos.this, Administrador.class);
				startActivity(intent);
				
				titulo.setText("");
				subtitulo.setText("");
				autor.setText("");
				isbn.setText("");
				editora.setText("");
				edicao.setText("");
				ano.setText("");
				paginas.setText("");
			}
		});
		final Button deletar = (Button) findViewById(R.id.btnDeletar);
		deletar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Livro livro = new Livro();
				livro.setId(id);
				bd.deleteLivro(livro);

				titulo.setText("");
				subtitulo.setText("");
				autor.setText("");
				isbn.setText("");
				editora.setText("");
				edicao.setText("");
				ano.setText("");
				paginas.setText("");

				Intent intent = new Intent(UpdateDeleteCampos.this, Administrador.class);
				startActivity(intent);
				
				deletar.setEnabled(false);
				Toast.makeText(getBaseContext(), "Livro excluido com sucesso.", Toast.LENGTH_SHORT).show();
			}
		});
	}
}