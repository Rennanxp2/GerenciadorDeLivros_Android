package app.Activities.Administracao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import app.Activities.catalogo.UpdateDelete;
import app.Activities.catalogo.UpdateDeleteCampos;
import app.Activities.login.Principal;
import app.BdsSqliteHelper.BDSQLiteHelper;
import app.catalogolivros.R;
import app.livroDAO.Livro;

public class Cadastro extends Activity {
	
	private BDSQLiteHelper bd;
	Button cadastrar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);
		
		bd = new BDSQLiteHelper(this);
		
		final EditText titulo    = (EditText) findViewById(R.id.edtTitulo);
		final EditText subtitulo = (EditText) findViewById(R.id.edtSubtitulo);
		final EditText autor	   = (EditText) findViewById(R.id.edtAutor);
		final EditText isbn	   = (EditText) findViewById(R.id.edtIsbn);
		final EditText editora   = (EditText) findViewById(R.id.edtEditora);
		final EditText edicao	   = (EditText) findViewById(R.id.edtEdicao);
		final EditText ano	   = (EditText) findViewById(R.id.edtAno);
		final EditText paginas   = (EditText) findViewById(R.id.edtPaginas);
		final Spinner  categoria = (Spinner) findViewById(R.id.edtCategoria);
		Button cadastrar = (Button)   findViewById(R.id.btnCadastrar);
		
		cadastrar.setOnClickListener(new View.OnClickListener() {
			

	public void onClick (View view) {
		Livro livro = new Livro();
		
		livro.setTitulo	  				 (titulo.getText().toString());
		livro.setSubTitulo				 (subtitulo.getText().toString());
		livro.setAutor	  				 (autor.getText().toString());
		livro.setIsbn					 (isbn.getText().toString());
		livro.setEditora				 (editora.getText().toString());
		livro.setEdicao					 (edicao.getText().toString());
		livro.setAno					 (ano.getText().toString());
		livro.setPaginas 				 (paginas.getText().toString());
		livro.setCategoria				 (categoria.getSelectedItem().toString());
		
		bd.addLivro(livro);
		bd.close();
		
		Toast.makeText(getBaseContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
	
		titulo.setText("");
		subtitulo.setText("");
		autor.setText("");
		isbn.setText("");
		editora.setText("");
		edicao.setText("");
		ano.setText("");
		paginas.setText("");
		
		Intent intent = new Intent(Cadastro.this, Administrador.class);
		startActivity(intent);
	}
	
		});
	}
    public void Voltar (View botao){
    	this.finish();
    }
}
