package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void noMoviesTest() {

        Customer testCustomer = new Customer("Sam");
        System.out.println(Customer.statement(testCustomer));
        String expected = "Rental Record for Sam\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        Assert.assertEquals(expected, Customer.statement(testCustomer));
    }
    @Test
    public void oneMovieTest() {
        Movie testMovie = new Movie("Avatar", 1);
        Rental testRental = new Rental(testMovie,2);
        Customer testCustomer = new Customer("Sam");
        testCustomer.addRental(testRental);
        System.out.println(Customer.statement(testCustomer));
        String expected = "Rental Record for Sam\n" +
                "\tAvatar\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";


        Assert.assertEquals(expected, Customer.statement(testCustomer));
    }

    @Test
    public void shouldGenerateStatementForCustomer() {
        Customer customer = new Customer("Bruce Wayne");
        customer.addRental(new Rental(new Movie("Spider-man: No way home", Movie.NEW_RELEASE), 4));
        customer.addRental(new Rental(new Movie("Spider-man: Homecoming", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Spider-man: Animated", Movie.CHILDRENS), 4));

        String statement = Customer.statement(customer);

        Assert.assertEquals("Rental Record for Bruce Wayne\n" +
                "\tSpider-man: No way home\t12.0\n" +
                "\tSpider-man: Homecoming\t5.0\n" +
                "\tSpider-man: Animated\t3.0\n" +
                "Amount owed is 20.0\n" +
                "You earned 4 frequent renter points", statement);
    }
}