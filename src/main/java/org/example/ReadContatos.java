package org.example;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class ReadContatos {
    public static void main(String[] args) {

        ContatoDAO dao = new ContatoDAO();

        Contato contato = new Contato();

        for (Contato c: dao.getContatos()) {
            System.out.println("Nome: " + c.getNome()+"\nIdade: "+c.getIdade()+"\n");
        }
    }
}
