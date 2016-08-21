package eg.edu.alexu.csd.oop.db;

import java.util.LinkedList;

public class Parser {

	private LinkedList<String> formula = new LinkedList<String>();
	private String createDatabase = "CREATE DATABASE ([^]]+)";
	private String createTable = "CREATE\\s*TABLE ([^]]+)\\((([^]]+)(VARCHAR|INT)\\s*,?\\s*)*\\)\\s*";
	private String deleteTable = "DELETE FROM ([^]]+)";
	private String deleteTable2 = "DELETE \\* FROM ([^]]+)";
	private String deleteTable3 = "DELETE FROM ([^]]+) WHERE ([^]]+)\\s*=\\s*([^]]+)\\s*";
	private String dropDatabase = "DROP DATABASE ([^]]+)";
	private String dropTable = "DROP TABLE \\w+\\s*";
	private String insert = "INSERT INTO ([^]]+)\\s*VALUES\\s*\\((\\s*\'?([^]]+)\\s*\'?\\s*,?\\s*)*\\)?";
	private String insert2 = "INSERT INTO ([^]]+)\\s*\\((([^]]+)\\s*,?\\s*)*\\)\\s*VALUES\\s*\\((\\s*([^]]+)\\s*,?\\s*)*\\)?";
	private String selcetAll = "SELECT \\* FROM ([^]]+)";
	private String selcetCol = "SELECT ([^]]+) FROM ([^]]+)";
	private String update = "UPDATE ([^]]+) SET (\\w+\\s*=\\s*([^]]+),?)*\\s*WHERE\\s*\\w+\\s*=\\s*([^]]+)";
	private String where = "SELECT ([^]]+) FROM ([^]]+) WHERE ([^]]+) (>|<|=) ([^]]+)\\s*";
	private String update2 = "UPDATE ([^]]+) SET\\s*(\\s*([^]]+)\\s*=\\s*\'?\\s*([^]]+)+\\s*\'?\\s*,?\\s?)*\\s*";

	boolean check(String input) {

		while (input.contains("  ")) {
			input = input.replace("  ", " ");
		}

		input = input.toUpperCase();
		formula.add(createDatabase);
		formula.add(createTable);
		formula.add(deleteTable);
		formula.add(deleteTable2);
		formula.add(deleteTable3);
		formula.add(dropDatabase);
		formula.add(dropTable);
		formula.add(insert);
		formula.add(insert2);
		formula.add(selcetAll);
		formula.add(selcetCol);
		formula.add(update);
		formula.add(where);
		formula.add(update2);

		for (int i = 0; i < formula.size(); i++) {

			if (input.matches(formula.get(i))) {
				return true;
			}
		}
		return false;
	}

}