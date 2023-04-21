package org.example;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;
import net.datafaker.Faker;

public class InsertContatos {
    public static void main(String[] args) {

        Faker faker = new Faker(); // instanciando o faker para gerar dados aleatórios

        ContatoDAO dao = new ContatoDAO(); // instanciando o DAO para salvar os dados no banco

        Contato contato = new Contato(); // instanciando o contato para salvar no banco

        contato.setNome(faker.name().firstName()); // setando o nome do contato
        contato.setIdade(faker.number().numberBetween(1, 75)); // setando a idade do contato
        contato.setDataCadastro(faker.date().birthday()); // setando a data de cadastro do contato


        dao.save(contato); // salvando o contato no banco

        for (int i = 0; i < 50; i++) { // loop para salvar 100 contatos no banco
            contato = new Contato();    // instanciando o contato para salvar no banco

            contato.setNome(faker.name().firstName());
            contato.setIdade(faker.number().numberBetween(1, 75));
            contato.setDataCadastro(faker.date().birthday());

            dao.save(contato); // salvando o contato no banco

            if (i % 10 == 0) { // printando a cada 10 contatos salvos
                System.out.println("Salvando contato " + i);
            }
        }


    }
}