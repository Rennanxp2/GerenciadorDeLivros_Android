package app.Activities.Administracao;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import app.Activities.catalogo.UpdateDelete;
import app.Activities.catalogo.UpdateDeleteCampos;
import app.Activities.login.Principal;
import app.BdsSqliteHelper.BDSQLiteHelper;
import app.LivroAdapter.LivroAdapter;
import app.catalogolivros.R;
import app.livroDAO.Livro;
	
public class Administrador extends Activity {
		
	private BDSQLiteHelper bd;
	ArrayList<Livro> listaLivros;
	SearchView srcLivros;
	ListView lvLivros;
	ArrayAdapter<Livro> adapter;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.administrador);

		bd = new BDSQLiteHelper(this);

		srcLivros = (SearchView) findViewById(R.id.srcLivros);
		lvLivros = (ListView) findViewById(R.id.lvLivros);
		
		listaLivros = bd.getAllLivros();
		adapter = new ArrayAdapter<Livro>(this, android.R.layout.simple_list_item_1, listaLivros);
		lvLivros.setAdapter(adapter);

		lvLivros.setOnItemLongClickListener(new OnItemLongClickListener() {

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        	
			Intent intent = new Intent(Administrador.this, UpdateDeleteCampos.class);
			intent.putExtra("ID", listaLivros.get(i).getId());
			startActivity(intent);

            return true;
        }
    });
        

		
		srcLivros.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String text) {
				return false;
			}

			@Override
			public boolean onQueryTextChange(String text) {

				adapter.getFilter().filter(text);

				
				return false;
			
			
				}
			});
		}
		
    public void botao (View botao){
    	Intent it = new Intent(this, Cadastro.class);
    	startActivity(it);
    	
    }
    
    public void home (View botao){
    	Intent it = new Intent(this, Principal.class);
    	startActivity(it);
    }
    
}
