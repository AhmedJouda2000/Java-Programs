package Answer3;

/**
 * @author ahmed
 * 
 * This is the D+ Answer
 *
 */

public class CheckedUser implements User {
	private int age;
	private String name, email;
	
	
	//part B - constructors -- I set the instance variables within the "check" functions
	
		//constructor that takes 3 variables, name, age & email
		public CheckedUser(String name, int age, String email) {
			checkName(name);
	        checkAge(age);
	        checkEmail(email, name);
	    }
		
		//overloaded constructor that takes 2 variables name & age
		public CheckedUser(String name, int age) {
			checkName(name);
	        checkAge(age);
	    }
		
		//overloaded constructor that takes 1 variable, name.
		public CheckedUser(String name) {
			checkName(name);
	    }
		
		//Part C - getters/setters/validations
				
		//getters
		
		/**
		 *Accessor method for name, returns the name of the user
		 *
		 *@return name    the name in the object is returned
		 *@throws NullPointerException   if the name is not initialized an exception is thrown
		 */
		@Override
		public String getName() throws NullPointerException{
			if(name == null) {
				throw new NullPointerException("No name");
			}
			else return name;
		}
		
		
		/**
		 *Accessor method for age, returns the age of the user
		 *
		 *@return age    the age in the object is returned
		 *@throws NullPointerException    if the age is not initialized an exception is thrown
		 */
		@Override
		public int getAge() throws NullPointerException{
			if(age == 0) {
				throw new NullPointerException("No age");
			}
			else return age;
		}
		
		
		/**
		 *Accessor method for email, returns the email of the user
		 *
		 *@return email    the email in the object is returned
		 *@throws NullPointerException    if the email is not initialized an exception is thrown
		 */
		@Override
		public String getEmail() throws NullPointerException{
			if(email == null) {
				throw new NullPointerException("No email");
			}
			else return email;
		}

		
		//setters
		
		/**
		 *Mutator method for name, sets the name of the user
		 *
		 *@param name    the name we want to set the instance variable to
		 */
		@Override
		public void setName(String name) {
			checkName(name);
		}
		
		/**
		 *Mutator method for email, sets the email of the user to the parameter
		 *
		 *@param email    the name we want to set the instance variable to
		 */
		@Override
		public void setEmail(String email) {
			checkEmail(email, name);		
		}
		
		/**
		 *Mutator method for age, sets the age of the user to the parameter
		 *
		 *@param age    the age we want to set the instance variable to
		 */
		@Override
		public void setAge(int age) {
			checkAge(age);
		}
	
	
	//validation functions
		
	/**
	 *Check if name passed is valid, if it is assign it to the instance variable
	 *
	 *@param name    the name that will be validated and/or assigned
	 *@throws IllegalArgumentException   if the name is not valid an exception is thrown
	 */
	private void checkName(String name) throws IllegalArgumentException {
		//check if the name has a prefix
		if(checkNamePrefix(name) == 1) {
			throw new IllegalArgumentException("Wrong Format - has a prefix");
		}
		
		//check if the length of the name is valid
		if(checkNameLength(name) == 1) {
			throw new IllegalArgumentException("Wrong Format - wrong name length");
		}
		else this.name = name.trim();
	}
	
	/**
	 *Check if name passed is has a prefix, if it does return 1 else return 0 
	 *
	 *@param name    the name that will be validated
	 */
	private int checkNamePrefix(String name) {
		//if the name starts with the following it has a prefix
		if(name.contains("Mr") || name.startsWith("Ms") || name.startsWith("Prof")){
			return 1;
		}
		else return 0;
		
	}

	
	/**
	 *Check if name passed is of valid length, if it is return 0 else return 1 
	 *
	 *@param name    the name that will be validated
	 */
	private int checkNameLength(String name) {

		//split the string into words at whitespace and place in an array
			String[] words = name.split("\\s+");
			if(words.length == 1 || words.length == 2 ) {
				return 0;
			}
			else return 1;
		  }

	
	/**
	 *Check if age passed is valid, if it is assign it to the instance variable
	 *
	 *@param age    the age that will be validated and/or assigned
	 *@throws IllegalArgumentException   if the age is not valid an exception is thrown
	 */
	private void checkAge(int age) throws IllegalArgumentException {
		//check if age is between but not including 18 and 30, if it isn't throw exception
		if(age<=18 || age>=30) {
			throw new IllegalArgumentException("Outside Range");	
			}
		//if it is in the right range assign it to the instance variable
		else this.age = age;
	}
	
	
	/**
	 *Check if email passed is valid, if it is assign it to the instance variable
	 *
	 *@param email    the email that will be validated and/or assigned
	 *@param name     the name that will be used to validate email
	 *@throws IllegalArgumentException   if the email is not valid an exception is thrown
	 */
	private void checkEmail(String email, String name) throws IllegalArgumentException {
		
		//split the string into words at whitespace and place in an array
		String[] words = name.split("\\s+");
		
		//if name has 1 word check the format as follows
		if(words.length == 1) {
			if(email.startsWith(name + "@") && email.endsWith(".ie")) {
				this.email = email;		//if it follows the format assign it to the instance variable
			}
			else throw new IllegalArgumentException("Wrong Format");		//if it doesn't follow the specified format throw an exception
		}
		//if name has 2 words check the format as follows
		else if(words.length == 2) {
			if(email.startsWith(words[0] + "." + words[1] + "@") && email.endsWith(".ie")) {
				this.email = email;		//if it follows the format assign it to the instance variable
			}
			else throw new IllegalArgumentException("Wrong Format");	//if it doesn't follow the specified format throw an exception
		}
		else throw new IllegalArgumentException("Wrong Format");	//else throw an exception
		
	}

	

	
	//part D - toString
	
	/**
	 *Print out the requested summary message of the object
	 *
	 *@return message     the summary message requested is returned
	 */
	public String toString() {
			
		String message = "CheckedUser:" + " " + name + " (" + age + "), " + email;
		
		return message;
	}

}
