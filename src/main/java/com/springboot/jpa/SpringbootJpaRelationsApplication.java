package com.springboot.jpa;

import com.springboot.jpa.entities.Address;
import com.springboot.jpa.entities.Client;
import com.springboot.jpa.entities.Facture;
import com.springboot.jpa.repositories.IClientRepository;
import com.springboot.jpa.repositories.IFactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootApplication
public class SpringbootJpaRelationsApplication implements CommandLineRunner {

	@Autowired
	private IClientRepository clientRepository;

	@Autowired
	private IFactureRepository factureRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		OneToMAny();
	}

	@Transactional
	public void OneToMAny(){
		Client client = new Client("Rafa", "Rodriguez");

		Address address1 = new Address("Vicente alexandre", 47);
		Address address2 = new Address("Antequera", 4);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);
		System.out.println(client);
	}

	@Transactional
	public void manyToOne(){
		Client client = new Client("Jose",  "Doe");
		clientRepository.save(client);

		Facture facture = new Facture("compras de oficina", 1322L);
		facture.setClient(client);

		Facture factureDb = factureRepository.save(facture);
		System.out.println(factureDb);
	}

	@Transactional
	public void manyToOnFindByIdClient(){
		Optional<Client> optionalClient = clientRepository.findById(1L);
		if (optionalClient.isPresent()){
			Client client = optionalClient.orElseThrow();

			Facture facture = new Facture("compras de oficina", 1322L);
			facture.setClient(client);

			Facture factureDb = factureRepository.save(facture);
			System.out.println(factureDb);
		}

	}
}
