package app.Activities.login;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import app.BdsSqliteHelper.DBCreator;
import app.catalogolivros.R;

public class Login extends Activity {
	
	private EditText txtLogin;
	private EditText txtSenha;
	
	
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		txtLogin = (EditText) findViewById(R.id.txtLogin);
		txtSenha = (EditText) findViewById(R.id.txtSenha);
		
		db = new DBCreator(this, "dbLogin",2).getWritableDatabase();
		
		
	}
	
	public void login(View botao) {
		
		String login = txtLogin.getText().toString();
		String senha = txtSenha.getText().toString();
		
		Cursor rs = db.rawQuery("SELECT * FROM login WHERE login = ? AND senha = ?", new String [] {login,senha});
		
		if(rs.moveToNext()) {
			startActivity(new Intent(this, Principal.class));
			Toast.makeText(this, "Bem Vindo " + login + "!", Toast.LENGTH_LONG).show();
			finish();
		}else {
			Toast.makeText(this, "Senha ou login incorretos", Toast.LENGTH_LONG).show();
		}
		
	}
	
	public void sair (View botao) {
	
		System.exit(0);
		
	}
	
}
