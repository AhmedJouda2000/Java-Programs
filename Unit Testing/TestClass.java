package Answer3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ahmed
 *
 */
class TestClass {
	
	CheckedUser obj;
	CheckedUser obj2;
	CheckedUser obj3;
	CheckedUser obj4;

	@BeforeEach
	void setUp() throws Exception {
		obj = new CheckedUser("ahmed jouda", 19, "ahmed.jouda@ucd.ie");
		obj2 = new CheckedUser("Maddy", 22, "Maddy@ucd.ie");
		obj4 = new CheckedUser("Simon");
	}
	
	
	
	/**
	 * Constructor tests - part B of question - 3 marks
	 */
	private CheckedUser c;
    
	//constructing CheckedUser with just name
    @Test
    public void constructorFirstTest(){
    	c = new CheckedUser("Sanjay");
        assertEquals("Sanjay", (c.getName()));
    	c = new CheckedUser("Allan");
        assertEquals("Allan", (c.getName()));
    }
    
    //constructing CheckedUser with name and age
    @Test
    public void constructorSecondTest(){
    	c = new CheckedUser("Sanjay", 27);
        assertEquals(27, (c.getAge()));
    	c = new CheckedUser("Allan", 28);
        assertEquals(28, (c.getAge()));
    }
    
    //constructing CheckedUser with name, age and email
    @Test
    public void constructorThirdTest(){
        try {
        c = new CheckedUser("sanjay", 28, "sanjay@ucd.ie");
        assertEquals("sanjay@ucd.ie", (c.getEmail()));
        c = new CheckedUser("allan", 28, "allan@ucd.ie");
        assertEquals("allan@ucd.ie", (c.getEmail()));
        }catch(IllegalArgumentException ex) {fail("email format");}
    }

	
	/**
	 * Validation tests start - part c of the question - 12 marks
	 * age tests
	 */
	
	@Test
	void ageUnder18Test() {
		//validate that ages below 17 aren't accepted
		try {
		obj.setAge(17);
		fail("Age outside range");
		}
		catch(IllegalArgumentException ex) {}
	}
	
	
	@Test
	void ageOver30Test() {
		//validate that ages over 30 aren't accepted
		try {
		obj.setAge(60);
		fail("Age outside range");
		}
		catch(IllegalArgumentException ex) {}
	}
	
	
	@Test
	void ageNegativeTest() {
		//validate that a negative age shouldn't be accepted
		try {
		obj.setAge(-12);
		fail("Age shouldn't be negative");
		}
		catch(IllegalArgumentException ex) {}
	}
	
	
	@Test
	void ageValidTest() {
		try {
		//should pass as we are setting it to a valid age
		obj.setAge(22);
		}
		catch(IllegalArgumentException ex) {fail("Age outside range");}
	}
	
	
	
	/**
	 * name tests
	 */	
	@Test
	void nameBasicPrefixTests() {
		//prefix without "." must be validated
		try {
		obj.setName("Mr Ahmed Jouda");
		fail("Name in wrong format - has a prefix");
		}
		catch(IllegalArgumentException ex) {}
		
		try {
			obj2.setName("Ms Maddy");
			fail("Name in wrong format - has a prefix");
			}
			catch(IllegalArgumentException ex) {}
		
		try {
			obj4.setName("Prof Simon");
			fail("Name in wrong format - has a prefix");
			}
			catch(IllegalArgumentException ex) {}
	}
	
	@Test
	void nameBasicLengthTest() {
		//make sure the name only has 1 or 2 words
			try {
				obj.setName("Ahmed Mohd Jouda");
				fail("Name in wrong format - max 2 words");
				}
			catch(IllegalArgumentException ex) {}
	}
	
	
	@Test
	void nameIntermediatePrefixTests() {
		//All prefixes must be validated
		try {
		obj.setName("Mr. Ahmed Jouda");
		fail("Name in wrong format - has a prefix");
		}
		catch(IllegalArgumentException ex) {}
		
		try {
			obj2.setName("Mrs. Maddy");
			fail("Name in wrong format - has a prefix");
			}
			catch(IllegalArgumentException ex) {}
		
		try {
			obj4.setName("Dr. Simon");
			fail("Name in wrong format - has a prefix");
			}
			catch(IllegalArgumentException ex) {}
				
	}
	
	@Test
	void nameIntermediateNullTest() {
		//setting an empty name should be validated
			try {
				obj.setName("");
				fail("Name can't be empty");
				}
				catch(IllegalArgumentException ex) {}
	}
		
	
	
	@Test
	void nameAdvancedPrefixTests() {
		//If start of a name is a prefix it should pass
		try {
		obj.setName("Mravi Jouda");
		}
		catch(IllegalArgumentException ex) {fail("Name in wrong format - has a prefix");}
		
		try {
			obj2.setName("Missy");
			}
			catch(IllegalArgumentException ex) {fail("Name in wrong format - has a prefix");}

	}
	
	@Test
	void nameAdvancedLengthTests() {
		//make sure the name only has 1 or 2 words
			try {
				//this should pass because its 2 words regardless of the space
				obj.setName(" Ahmed Jouda");
				}
				catch(IllegalArgumentException ex) {fail("Name in wrong format - max 2 words");}
				
			try {
				//this should pass because its 2 words regardless of the space
				obj4.setName(" Simon Caton ");
				}
				catch(IllegalArgumentException ex) {fail("Name in wrong format - max 2 words");}
	}
	
	
	
	/**
	 * email tests
	 */
	@Test
	void emailBasicNameCheckTest() {
		//validate that the name in the email must match the instance variable name
				try {
					obj.setEmail("sean.jouda@ucd.ie");
					fail("Wrong name - must be same as name as instance variable");
					}
					catch(IllegalArgumentException ex) {}
				
	}
	
	
	@Test
	void emailBasicSpaceCheckTest() {
			//validate that spaces aren't allowed in email
			try {
				obj.setEmail("ahmed.jouda @ucd.ie");
				fail("Wrong format - emails can't contain a space");
				}
				catch(IllegalArgumentException ex) {}
	}
	
	
	@Test
	void emailBasicTwoNameTest() {
		//validate that if a 2nd name is entered it must be in the email
		try {
			obj.setEmail("ahmed@ucd.ie");
			fail("Wrong format - second name given but not in email");
			}
			catch(IllegalArgumentException ex) {}
	}
	
	@Test
	void emailIntermediateFormatTest() {
		//validate that after '@' a company/domain name is needed
				try {
					obj2.setEmail("Maddy@.ie");
					fail("Wrong format - missing part after \"@\" ");
					}
			catch(IllegalArgumentException ex) {}
				
	}
		
	
	@Test
	void emailAdvancedFormatTest() {
		//allows "." char in the string after "@" hence allowing .co.uk
		try {
		obj.setEmail("ahmed.jouda@acer.co.uk");
		}
		catch(IllegalArgumentException ex) {fail("Wrong format - missing part after \"@\" ");}
		
		
	}
	
	
	@Test
	void emailAdvancedCaseTests() {
		//allows name in email in upper/lower case
			try {
				obj2.setEmail("maddy@ucd.ie");
				}
			catch(IllegalArgumentException ex) {fail("Doesn't allow capitals in name");}
				
		//allows name in email in upper/lower case
			try {
				obj.setEmail("AhMed.JoUdA@ucd.ie");
				}
			catch(IllegalArgumentException ex) {fail("Doesn't allow capitals in name");}
	}
	
		
	
	
	
	/**
	 * toString tests - part d of the question - 2 marks
	 */
	
	//tests constructor with 3 variables
	@Test
	void toStringFirstTest() {
		try {
			assertEquals("CheckedUser: ahmed jouda (19), ahmed.jouda@ucd.ie", obj.toString());
			assertEquals("CheckedUser: Maddy (22), maddy@ucd.ie", obj2.toString());
		}
			catch(IllegalArgumentException ex) {}
	}
	
	//tests constructor with 2 variables
	@Test
	void toStringSecondTest() {
		try {
			CheckedUser cu = new CheckedUser("Jack Seliman", 25);
			assertEquals("CheckedUser: Jack Seliman (25)", cu.toString());
		}
			catch(IllegalArgumentException ex) {}
	}
	
	//tests constructor with 1 variable
	@Test
	void toStringThirdTest() {
		try {
			assertEquals("CheckedUser: Simon", obj4.toString());
		}
			catch(IllegalArgumentException ex) {}
	}
	
	
	
	/**
	 * getters tests
	 */
	
	//validation and null pointer error handling
	//none of the getters should work with obj3 as it isn't constructed
	@Test
	void gettersNullTest() {
		try {
			
			obj3.getName();
			fail("name not available");
		}
			catch(NullPointerException e) {}
		
		try {	
			
			obj3.getAge();
			fail("Age not available");
			}
			catch(NullPointerException e) {}

		try {	
			
			obj3.getEmail();
			fail("Email not available");
			}
			catch(NullPointerException e) {}
		
	}
	
	
	//testing getters with a constructed object to show they return the correct value
	@Test
	void gettersTest() {
		
			assertEquals("ahmed jouda", obj.getName());
			assertEquals(19, obj.getAge());
			assertEquals("ahmed.jouda@ucd.ie", obj.getEmail());    //we see email is returned in lowercase
		
	}
	
	
	//testing getters with an object that doesn't have an age and an email
	//email and age should throw null pointer exceptions while the name should be returned.
	@Test
	void gettersHalfNullTest() {
		
			assertEquals("Simon", obj4.getName());
			
			try {	
				
				obj4.getAge();
				fail("Age not available");
				}
				catch(NullPointerException e) {}
			
			try {	
				
				obj4.getEmail();
				fail("Email not available");
				}
				catch(NullPointerException e) {}
		
	}
	
	//shows the usage of name.trim() to make sure that any extra spaces entered are deleted
	@Test
	void gettersNameSpacesTest() {
			
			try {
				CheckedUser cu = new CheckedUser("  Sam Maher");
				assertEquals("Sam Maher", cu.getName());
			}
			catch(IllegalArgumentException ex) {fail("Failed");}
			
			try {
			CheckedUser cu1 = new CheckedUser("  Sam Maher    ");
			assertEquals("Sam Maher", cu1.getName());
			}
			catch(IllegalArgumentException ex) {fail("Failed");}
	}
	
	
	
}
