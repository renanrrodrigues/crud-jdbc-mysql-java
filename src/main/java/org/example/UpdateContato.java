package org.example;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;


public class UpdateContato {
    public static void main(String[] args) {

            ContatoDAO dao = new ContatoDAO(); // instanciando o DAO para salvar os dados no banco

            Contato contato = new Contato(); // instanciando o contato para salvar no banco

            contato.setId(46); // id do contato que será atualizado
            contato.setNome("Renan"); // setando o nome do contato
            contato.setIdade(33); // setando a idade do contato

            dao.update(contato); // atualizando o contato no banco

    }
}
