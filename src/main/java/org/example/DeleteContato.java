package org.example;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class DeleteContato {
    public static void main(String[] args) {

            ContatoDAO dao = new ContatoDAO();

            Contato contato = new Contato();

            contato.setId(67);

            dao.delete(contato);
    }
}
