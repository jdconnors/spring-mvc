package com.example.testsuite;

import com.example.services.CustomerServiceJpaDaoImplTest;
import com.example.services.ProductServiceJpaDaoImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by jconnors on 6/13/16.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProductServiceJpaDaoImplTest.class,
        CustomerServiceJpaDaoImplTest.class
})
public class ServicesTestSuite {
}
