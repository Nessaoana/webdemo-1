package webdemo.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Produto {

		private int id;
		private String nome;
		private float preco;
		
		
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public float getPreco() {
			return preco;
		}
		public void setPreco(float preco) {
			this.preco = preco;
		}
		
		public Produto(String nome, float preco) {
			super();
			this.nome = nome;
			this.preco = preco;
		}
		
		
		public void salvar() {
			if(this.id == 0) {
				_produtoSeq++;
				this.setId(_produtoSeq);
				_ProdutoDict.put(_produtoSeq, this);
			}else {
				_ProdutoDict.replace(this.getId(), this);
			}
		}
		
		public void remover() {
			_ProdutoDict.remove(this.id);
		}
		
		public static List<Produto> Todos(){
			return new ArrayList<Produto>(_ProdutoDict.values());
		}
		
		public static Produto GetById(int id) {
			return _ProdutoDict.get(id);
		}
		
		
		private static HashMap<Integer, Produto> _ProdutoDict = new HashMap<>();
		private static int _produtoSeq = 0;
		
		
		
}
