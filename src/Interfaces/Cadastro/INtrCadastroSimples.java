package Interfaces.Cadastro;

public interface INtrCadastroSimples {
	
	//Coleta os dados e salva criando uma instancia no banco de dados
	 abstract boolean salvar();
	 //quando vamos alterar inserirmos um objeto já cadastrado nas lacunas
	 abstract boolean inserirObjetoExterno();
	 
	 //para resgatar um objeto que foi criado ou alterado
	 abstract Object getObjeto();

}
