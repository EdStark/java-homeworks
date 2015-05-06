package ch4;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static java.lang.System.exit;
import java.util.ArrayList;

/*
Test FactorialTestNSG
**********************************
Step 1: Provide 2 integer lists of same length - one for the arguments and one for the expected results
Expected: The two lists should have same length. Quit, if lengths are different

Step 2: Check if the argument list has non-negative integers
Expected: Arguments should be non-negative integers. Quit, if negative integer is provided

Step 3: Add one argument to the argument list and recalculate factorial and add to expected
Expected: The new recalculated value should be added to expected

Step 4: Add one more argument and check that it's a non-negative
Expected: Assertion should PASS

Step 5:  Recalculate factorial and add to expected list
Expected: The new recalculated value should be added to expected

Step 6: Loop through all elements of the argument list and assert expected vs actual
Expected: All assertions should PASS
*/



public class FactorialTestNGTest {

    int[] a = {5, 6, 7, 8};     //Factorial numbers. Modify these values to check different test results
    long[] b = {120, 720, 5040, 40320}; //Expected results. Modify these values to check different test results

    FactorialTestNG factorial = new FactorialTestNG();
    //We use ArrayList
    ArrayList<Integer> argument_list = new ArrayList<>();
    ArrayList<Long> expected_results = new ArrayList<>();

    @BeforeClass
    public void beforeClass() {
        //Loop through array a and add all values to our argument_list
        for(int i=0; i < a.length; i++){
            argument_list.add(i, a[i]);
            assertTrue(argument_list.size()!=0); // Verify size is not 0
        }

        //Loop through array b and add all values to our expected_results
        for(int j=0; j < b.length; j++){
            expected_results.add(j, b[j]);
            assertFalse(expected_results.size()==0);   //Verify size is not 0
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        /*Quit if parameter has a negative integer*/
        for(int i=0; i< argument_list.size();i++){
            if(argument_list.get(i) < 0){
                System.out.println("Parameter array contains a negative value. Please correct this and try again!");
                exit(-1);
            }
        }

        /*Quit if the 2 arrays have different lengths*/
        if(expected_results.size() != argument_list.size()){
            System.out.println("Cannot continue... Parameter and results arrays have different lengths! Please correct this and try again!");
            exit(-1);
        }
    }

    @Test
    public void TestAssertions() throws Exception {
        int new_element = 15;  //Create new argument of 15
        argument_list.add(new_element);  //Add new argument to the list
        expected_results.add(factorial.CalculateFactorial(new_element)); //Calculate  and add to expected

        new_element += 1;  //New argument is now 16
        argument_list.add(new_element); //Add it to the list

        assertTrue(new_element > 15); //ASSERT that it incremented and added the number correctly
        expected_results.add(factorial.CalculateFactorial(new_element)); // Calculate and add to expected

        // Loop through elements.
        for (int i = 0; i < argument_list.size(); i++) {
            int value = argument_list.get(i);
            long expected = expected_results.get(i);
            System.out.println("Factorial for element " + value + " is " + expected);
            assertEquals(expected, factorial.CalculateFactorial(value), "Factorial is not correct");
        }

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }
}