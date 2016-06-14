package com.example.testsuite;

import com.example.controllers.CustomerControllerTest;
import com.example.controllers.IndexControllerTest;
import com.example.controllers.ProductControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by jconnors on 6/13/16.
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
        IndexControllerTest.class,
        ProductControllerTest.class,
        CustomerControllerTest.class
})
public class ControllersTestSuite {
}
