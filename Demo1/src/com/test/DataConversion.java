package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//

//public class DataConversion {
//	public static void main(String[] args) {
//		String str = "_org := root.organisation.add(Organisation, id := 'P_001', name := 'Pradeep organization', description := 'Description') _org.add(Scorecard, id := 'S_01', name := 'Scorecard_pradeep')";
//		doConvert(str);
//		System.out.println(str);
//
//	}
//
//	public static String doConvert(String str) {
//
//		return str;
//
//	}
//}

//package com.test;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class DataConversion {
//	public static void main(String[] args) {
//		String str = "_org := root.organisation.add(Organisation, id := '101', name := 'Pradeep organization', description := 'Description') _org.add(Scorecard, id := '102', name := 'Scorecard_pradeep')";
//
//		String result = doConvert(str);
//		System.out.println(result);
//	}
//
//	public static String doConvert(String str) {
//		// Define a pattern to match id := '<id_value>'
//		Pattern pattern = Pattern.compile("id := '([^']+)'");
//		Matcher matcher = pattern.matcher(str);
//
//		StringBuilder modifiedStr = new StringBuilder(str);
//System.out.println("---"+ modifiedStr );
//		// Loop through all found id occurrences
//		while (matcher.find()) {
//			System.out.println(".."+ matcher.find() );
//
//			// For each id found, prepend 'RTS_' to the original id value
//			String oldId = matcher.group(1);
//			String newId = "RTS_" + oldId;
//
//			// Replace the old id with the new id
//			modifiedStr.replace(matcher.start(1), matcher.end(1), newId);
//		}
//
//		return modifiedStr.toString();
//	}
//}

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class DataConversion {
//	public static void main(String[] args) {
//		String obj = "_org := root.organisation.add(Organisation, id := '101', name := 'Pradeep organization', description := 'Description') _org.add(Scorecard, id := '102', name := 'Scorecard_pradeep')";
//
//		String suffix = "_updated";
//
//		Pattern pattern = Pattern.compile("id := '(\\S+)'");
//
//		Matcher matcher = pattern.matcher(obj);
//
//		String result = matcher.replaceAll("id := '$1" + suffix + "'");
//
//		System.out.println(result);
//	}
//}
////
//
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class DataConversion {
//	public static void main(String[] args) {
//		// Input string
//		String obj = "_org := root.organisation.add(Organisation, id := '101', name := 'Pradeep organization', description := 'Description') _org.add(Scorecard, id := '102', name := 'Scorecard_pradeep')";
//
//		// Pattern to capture the type (Organisation, Scorecard, etc.) and id
//		Pattern pattern = Pattern.compile("add\\((\\S+), id := '(\\S+)'");
//
//		Matcher matcher = pattern.matcher(obj);
//
//		// Replace with the type and id updated as type_OLDID
//		String result = matcher.replaceAll("add($1, id := '$2_$1'");
//
//		// Output the modified string
//		System.out.println(result);
//	}
//}
////

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class DataConversion {
//	public static void main(String[] args) {
//		// Input string
//		String obj = "_org := root.organisation.add(Organisation, id := '101', name := 'Pradeep organization', description := 'Description') _org.add(Scorecard, id := '102', name := 'Scorecard_pradeep')";
//
//		// Pattern to capture the type (Organisation, Scorecard, etc.) and id
//		Pattern pattern = Pattern.compile("add\\((\\S+), id := '(\\S+)'");
//
//		Matcher matcher = pattern.matcher(obj);
//
//		// Replace with the type before the id, forming type_id format
//		String result = matcher.replaceAll("add($1, id := '$1_$2'");
//
//		// Output the modified string
//		System.out.println(result);
//	}
//}
//
//
////

public class DataConversion {
	public static void main(String[] args) {
//		String obj = "_org := root.organisation.add(Organisation, id := '101', name := 'Pradeep organization', description := 'Description') _org.add(Scorecard, id := '102', name := 'Scorecard_pradeep')";
//		String obj = "_org := root.organisation.add(Organisation, id := '102', name := 'Org A')_org1 := _org.add(Organisation, id := '103', name := 'Org B')_org1.add(Organisation, id := '106', name := 'OrgnB1')_org1.add(Organisation, id := '107', name := 'Org B2') _org.add(Organisation, id := '104', name := 'Org C')";
		String obj = "_org := root.organisation.add(Organisation, id := '102', name := 'Org A')_org1 := _org.add(Organisation, id := '103', name := 'Org B') _org1.add(Organisation, id := '106', name := 'OrgnB1')_org1.add(Organisation, id := '107', name := 'Org B2')_org4 := _org.add(Organisation, id := '104', name := 'Org C')_sco := _org4.add(Scorecard, id := '152', name := 'Scorecard 1')_sco.add(RiskChart, id := '153', name := 'Risk chart 1')_sco.add(BarChart, id := '154', name := 'Bar chart 1')";

		Pattern pattern = Pattern.compile("add\\((\\S+), id := '(\\S+)'");

		Matcher matcher = pattern.matcher(obj);

		String result = matcher.replaceAll("add($1, id := 'RTS_$1_$2'");

		System.out.println(result);
	}
}
