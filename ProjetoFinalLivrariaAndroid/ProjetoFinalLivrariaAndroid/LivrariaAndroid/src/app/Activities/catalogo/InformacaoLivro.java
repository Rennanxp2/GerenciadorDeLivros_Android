package app.Activities.catalogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import app.catalogolivros.R;

public class InformacaoLivro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_informacao_livro);

		final Button voltar = (Button) findViewById(R.id.btnVoltar);
		
		Intent intent = getIntent();

		String Titulo = (String) intent.getSerializableExtra("titulo");
		TextView titulo = (TextView) findViewById(R.id.txtTitulo);

		String Subtitulo = (String) intent.getSerializableExtra("subtitulo");
		TextView subtitulo = (TextView) findViewById(R.id.txtSubtitulo);

		String Autor = (String) intent.getSerializableExtra("autor");
		TextView autor = (TextView) findViewById(R.id.txtAutor);

		String Isbn = intent.getSerializableExtra("isbn").toString();
		TextView isbn = (TextView) findViewById(R.id.txtIsbn);

		String Editora = (String) intent.getSerializableExtra("editora");
		TextView editora = (TextView) findViewById(R.id.txtEditora);

		String Edicao = (String) intent.getSerializableExtra("edicao");
		TextView edicao = (TextView) findViewById(R.id.txtEdicao);

		String Ano = intent.getSerializableExtra("ano").toString();
		TextView ano = (TextView) findViewById(R.id.txtAno);

		String Paginas = intent.getSerializableExtra("paginas").toString();
		TextView paginas = (TextView) findViewById(R.id.txtPaginas);

		String Categoria = (String) intent.getSerializableExtra("categoria");
		TextView categoria = (TextView) findViewById(R.id.txtCategoria);

		titulo.setText(Titulo);
		subtitulo.setText(Subtitulo);
		autor.setText(Autor);
		isbn.setText(Isbn);
		editora.setText(Editora);
		edicao.setText(Edicao);
		ano.setText(Ano);
		paginas.setText(Paginas);
		categoria.setText(Categoria);
		
		  voltar.setOnClickListener(new OnClickListener(){
			  
				@Override
				public void onClick(View v) {
					 
					finish();
					
				}

		  });
	}
}