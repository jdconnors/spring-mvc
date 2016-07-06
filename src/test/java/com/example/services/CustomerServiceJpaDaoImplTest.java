package com.example.services;

import com.example.config.JpaIntegrationConfig;
import com.example.domain.Customer;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by jconnors on 6/13/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class CustomerServiceJpaDaoImplTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /* This test was provided by the instructor in the tutorial, but it is not
    a good test assumption.  Tests are not necessarily run in order.
    If one of the other tests runs first and changes the number of records
    then this test will fail - because it is assuming that SpringJPABootstrap.loadCustomers() has
    just run and nothing else.
     */
    @Test
    public void testListMethod() throws Exception {

        List<Customer> customers = (List<Customer>) customerService.listAll();

        System.out.println("customers.size() = " + customers.size());
        assert customers.size() == 5;
    }

    @Test
    public void testGetByIdMethod() throws Exception {

        Customer customer = customerService.getById(2);

        assert customer.getId() == 2;
        assert 0 == customer.getFirstName().compareTo("FName2");
        assert 0 == customer.getLastName().compareTo("LName2");
        assert 0 == customer.getEmail().compareTo("fnamelname2");
        assert 0 == customer.getPhoneNumber().compareTo("2065551002");
        assert 0 == customer.getAddress1().compareTo("address1-2");
        assert 0 == customer.getAddress2().compareTo("address2-2");
        assert 0 == customer.getCity().compareTo("Seattle");
        assert 0 == customer.getState().compareTo("WA");
        assert 0 == customer.getZipCode().compareTo("98121");
    }

    @Test
    public void testSaveOrUpdateMethodForSave() throws Exception {

        List<Customer> customersBefore = (List<Customer>) customerService.listAll();

        String firstName = "fnametest";
        String lastName = "lnametest";
        String email = "emailtest";
        String phonenumber = "2061234567";
        String address1 = "address test 1";
        String address2 = "address test 2";
        String city = "Anytown";
        String state = "Anystate";
        String zipCode = "01234";

        Customer customerNew = new Customer();
        customerNew.setFirstName(firstName);
        customerNew.setLastName(lastName);
        customerNew.setEmail(email);
        customerNew.setPhoneNumber(phonenumber);
        customerNew.setAddress1(address1);
        customerNew.setAddress2(address2);
        customerNew.setCity(city);
        customerNew.setState(state);
        customerNew.setZipCode(zipCode);
        Customer savedCustomer = customerService.saveOrUpdate(customerNew);

        List<Customer> customersAfter = (List<Customer>) customerService.listAll();
        assert customersAfter.size() == customersBefore.size() + 1;

        Optional optionalCustomer = customersBefore
                .stream()
                .collect(Collectors.maxBy(new Comparator<Customer>() {
                    @Override
                    public int compare(Customer o1, Customer o2) {
                        return o1.getId() - o2.getId();
                    }
                }));
        Integer resultInteger = optionalCustomer.isPresent() ? ((Customer) optionalCustomer.get()).getId() : 0;
        assert savedCustomer.getId() > resultInteger;

        Customer retrievedCustomer = customerService.getById(savedCustomer.getId());
        assert 0 == retrievedCustomer.getFirstName().compareTo(firstName);
        assert 0 == retrievedCustomer.getLastName().compareTo(lastName);
        assert 0 == retrievedCustomer.getEmail().compareTo(email);
        assert 0 == retrievedCustomer.getPhoneNumber().compareTo(phonenumber);
        assert 0 == retrievedCustomer.getAddress1().compareTo(address1);
        assert 0 == retrievedCustomer.getAddress2().compareTo(address2);
        assert 0 == retrievedCustomer.getCity().compareTo(city);
        assert 0 == retrievedCustomer.getState().compareTo(state);
        assert 0 == retrievedCustomer.getZipCode().compareTo(zipCode);
    }

    @Test
    public void testSaveOrUpdateMethodForUpdate() throws Exception {
        //$TODO
    }

    public void testDeleteMethod() throws Exception {
        //$TODO
    }

    /*
    The testSaveWithUser() test was added by the instructor in the
    'One to One Entity Relationships - Unidirectional' lesson, but
    does not work after the refactoring he did in the 'One to One
    Entity Relationships - Bidirectional' lesson.  When he changed...
        @OneToOne(cascade = {CascadeType.ALL})
    ...to...
        @OneToOne
    ...it breaks this test.  He confirmed that his new test in
    UserServiceJpaDaoImplTest.jave worked fine but he did not go back
    and see that this test no longer works.  In his source at the end
    of the module he did not show this test being removed.  But I have
    removed it because it is no longer valid.
     */
    /*
    @Test
    public void testSaveWithUser() {
        Customer customer = new Customer();
        User user = new User();
        user.setUsername("This is my user name");
        user.setPassword("MyAwesomePassword");
        customer.setUser(user);

        Customer savedCustomer = customerService.saveOrUpdate(customer);

        assert savedCustomer.getUser().getId() != null;
    }
    */
}
