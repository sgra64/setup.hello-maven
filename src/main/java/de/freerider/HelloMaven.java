package de.freerider;


/**
 * Main class.
 * 
 * The class implements the singleton pattern with lazy instance creation, see
 * https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples
 * 
 */
public class HelloMaven {

	/*
	 * Private singleton instance with lazy instance creation (only when needed).
	 */
	private static HelloMaven singletonInstance = null;


	/**
	 * Private constructor for prevent external instance creation.
	 */
	private HelloMaven() { }


	/**
	 * Public instance getter method.
	 * 
	 * @return reference to singleton instance
	 */
	public static HelloMaven getInstance() {
		if(singletonInstance == null) {
			singletonInstance = new HelloMaven();
		}
		return singletonInstance;
	}


	/**
	 * Main function.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		var inst = HelloMaven.getInstance();
		var withQuotes = false;
		//
		for(String arg: args) {
			var spl = arg.split("=");
			if(spl.length > 1 && spl[0].trim().equals("--withQuotes")) {
				withQuotes = spl[1].toLowerCase().trim().equals("true");
			}
		}
		var msg = inst.getHelloMessage(withQuotes);
		System.out.println(msg);
	}


	/**
	 * Return "Hello Maven!" message quoted or unquoted.
	 * 
	 * @param withQuotes return quoted message if set to true
	 * @return message quoted or unquoted
	 */
	public String getHelloMessage(boolean withQuotes) {
		String msg = "Hello Maven!";
		return withQuotes? "\"" + msg + "\"" : msg;
	}
}