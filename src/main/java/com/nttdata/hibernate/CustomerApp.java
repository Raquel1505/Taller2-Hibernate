package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.nttdata.persistence.Contracts;
import com.nttdata.persistence.Customer;
import com.nttdata.services.ContractsServiceI;
import com.nttdata.services.ContractsServiceImpl;
import com.nttdata.services.CustomerServiceI;
import com.nttdata.services.CustomerServiceImpl;

/**
 * NTT DATA - CUSTOMER/CONTRACTS
 * 
 * @author dhraq
 *
 */
public class CustomerApp 
{
    public static void main( String[] args ){
    	
    	//Apertura de sesión
    	final Session session = CustomerSessionUtil.getSessionFactory().openSession();
    	
    	//Inicialización de servicios
    	final CustomerServiceI customerService = new CustomerServiceImpl(session);
    	final ContractsServiceI contractsService = new ContractsServiceImpl(session);

    	//Lógica de negocio
    	
    	final Customer raul = new Customer();
    	raul.setName("Raul");
    	raul.setSurname("Sánchez");
    	raul.setSecondSurname("Cuadrado");
    	raul.setDni("62736245-L");
    	raul.setUpdateDate(new Date());
    	raul.setUpdateUser("rdh@nttdata.com");
    	
    	final Customer maria = new Customer();
    	maria.setName("María");
    	maria.setSurname("Fernández");
    	maria.setSecondSurname("Saez");
    	maria.setDni("29472847-D");
    	maria.setUpdateDate(new Date());
    	maria.setUpdateUser("tsa@nttdata.com");
    	
    	final Customer alberto = new Customer();
    	alberto.setName("Alberto");
    	alberto.setSurname("Roma");
    	alberto.setSecondSurname("Bueno");
    	alberto.setDni("75938563-Ñ");
    	alberto.setUpdateDate(new Date());
    	alberto.setUpdateUser("rdh@nttdata.com");
    	
    	final Customer sara = new Customer();
    	sara.setName("Sara");
    	sara.setSurname("Merino");
    	sara.setSecondSurname("Benítez");
    	sara.setDni("753287438-L");
    	sara.setUpdateDate(new Date());
    	sara.setUpdateUser("tsa@nttdata.com");
    	
    	customerService.insertNewCustomer(sara);
    	customerService.insertNewCustomer(maria);
    	customerService.insertNewCustomer(alberto);
    	customerService.insertNewCustomer(raul);
    	
    	
    	
    	final Contracts contract1 = new Contracts();
    	contract1.setEffectiveDate(new Date());
    	contract1.setExpirationDate(new Date(20-04-2024));
    	contract1.setPrice("42.30");
    	contract1.setUpdateDate(new Date());
    	contract1.setUpdateUser("tsa@nttdata.com");
    	contract1.setCustomer(sara);
    	
    	final Contracts contract2 = new Contracts();
    	contract2.setEffectiveDate(new Date());
    	contract2.setExpirationDate(new Date(15-06-2024));
    	contract2.setPrice("30.27");
    	contract2.setUpdateDate(new Date());
    	contract2.setUpdateUser("rdh@nttdata.com");
    	contract2.setCustomer(maria);
    	
    	final Contracts contract3 = new Contracts();
    	contract3.setEffectiveDate(new Date());
    	contract3.setExpirationDate(new Date(12-07-2024));
    	contract3.setPrice("51.98");
    	contract3.setUpdateDate(new Date());
    	contract3.setUpdateUser("rrhh@nttdata.com");
    	contract3.setCustomer(raul);
    	
    	final Contracts contract4 = new Contracts();
    	contract4.setEffectiveDate(new Date());
    	contract4.setExpirationDate(new Date(12-02-2024));
    	contract4.setPrice("43.21");
    	contract4.setUpdateDate(new Date());
    	contract4.setUpdateUser("rrhh@nttdata.com");
    	contract4.setCustomer(alberto);
    	
    	contractsService.insertNewContracts(contract4);
    	contractsService.insertNewContracts(contract1);
    	contractsService.insertNewContracts(contract2);
    	contractsService.insertNewContracts(contract3);
    	
    	
//    	List<Customer> customers = customerService.searchByName("Alberto" , "Roma" , "Bueno");
//    	for(final Customer customer : customers) {
//    		System.out.println(customer.getName() + " | " + customer.getSurname() + " | " + customer.getSecondSurname() + " | " + customer.getContractsList());
//    		
//    	}
//    	
//    	List<Contracts> contracts = contractsService.findeAllContractsFromSystem();
//    	for(final Contracts contract : contracts) {
//    		System.out.println(contract.getContractsId()  + " | " + contract.getCustomer() + " | " + contract.getEffectiveDate() + " | " + contract.getExpirationDate());
//    		
//    	}
//    	
    	//final Contracts cc = (Contracts) session.getCriteriaBuilder();
    	final CriteriaBuilder cb = session.getCriteriaBuilder();
    	final CriteriaQuery<Contracts> cquery = cb.createQuery(Contracts.class);
    	
    	  	
    	//Cierre de sesión
    	session.close();

    }
}
