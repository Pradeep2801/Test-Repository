package com.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrganisationIdUpdater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("provide your object :");
		String str = sc.nextLine();
		System.out.println();
		String str1 = """
						_org := root.organisation.add(Organisation, id := '200', name := 'Org A')_org1 := _org.add(Organisation, id := '101', name := 'Org B')_org1.add(Organisation, id := 'RTS_Organisation_106', name := 'OrgnB1')_org1.add(Organisation, id := 'RTS_Organisation_107', name := 'Org B2')_org4 := _org.add(Organisation, id := '111', name := 'Org C')
						_sco := _org4.add(Scorecard, id := 'RTS_Scorecard_152', name := 'Scorecard 1')
				        _sco.add(RiskChart, id := 'RTS_RiskChart_153', name := 'Risk chart 1')
				        _sco.add(BarChart, id := 'RTS_BarChart_154', name := 'Bar chart 1')
				_per := _sco.add(Perspective, id := '167')
				_str := _per.add(StrategicObjective, id := '168')
				        _str.add(Kpi, id := '169')
				        _sco.add(StandardTable, id := '171')
				        _sco.add(FilterTable, id := '172')
				        _sco.add(DescriptionView, id := '173')
				        _sco.add(LocalComments, id := '174')
				        _sco.add(ActionButton, id := '175')
				        _sco.add(RiskList, id := '176')""";

		String renamedObj = renameId(str);
		System.out.println("renamed of your object :");

		System.out.println(renamedObj);
	}

	public static String renameId(String object) {
		Pattern pattern = Pattern.compile("add\\((\\S+), id := '(\\S+)'");

		Matcher matcher = pattern.matcher(object);

		String result = matcher.replaceAll((matchResult) -> {
			String type = matchResult.group(1);
			String id = matchResult.group(2);
			if (!id.startsWith("RTS_")) {
				id = "RTS_" + type + "_" + id;
			}
			return "add(" + type + ", id := '" + id + "'";
		});

		return result;

	}
}
