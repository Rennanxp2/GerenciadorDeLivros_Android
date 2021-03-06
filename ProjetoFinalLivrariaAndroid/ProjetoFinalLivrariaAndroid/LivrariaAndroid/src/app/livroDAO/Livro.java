package app.livroDAO;

public class Livro {

	private int id;
	private String titulo;
	private String subTitulo;
	private String autor;
	private String isbn;
	private String editora;
	private String edicao;
	private String ano;
	private String paginas;
	private String categoria;

	public Livro() {

	}

	public Livro(int id, String titulo, String subTitulo, String autor, String isbn, String editora, String edicao,
			String ano, String paginas, String categoria) {

		this.id = id;
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.autor = autor;
		this.isbn = isbn;
		this.editora = editora;
		this.edicao = edicao;
		this.ano = ano;
		this.paginas = paginas;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return titulo + "\n" + autor + "\n" + categoria;
	}
}
