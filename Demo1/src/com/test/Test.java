package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {   
//		String obj = "_org := root.organisation.add(Organisation, id := '101', name := 'Pradeep organization', description := 'Description') _org.add(Scorecard, id := '102', name := 'Scorecard_pradeep')";
//		String obj = "_org := root.organisation.add(Organisation, id := '102', name := 'Org A')_org1 := _org.add(Organisation, id := '103', name := 'Org B')_org1.add(Organisation, id := '106', name := 'OrgnB1')_org1.add(Organisation, id := '107', name := 'Org B2') _org.add(Organisation, id := '104', name := 'Org C')";
		String obj = "_sco := o.EXE.add(Scorecard, id := '464', name := 'Individual Awards', description := '      Internal', showTitleBar := false, showToolMenu := false, showTabs := false)"
				+ "_sco.add(InputView, id := '465', name := 'Add medal', inputSet := t.10494, headerColor := t.21981, fontColor := t.white, container := t.22814)"
				+ "_sco.add(InputView, id := '466', name := 'Add Criteria and Sub Criteria', inputSet := t.22780, headerColor := t.21981, fontColor := t.white, container := t.22814)"
				+ "_sco.add(ExtendedTable, id := '467', name := 'Framework', expression := 'vList := select ListPropertySetItem from t.10367\\nmyTable:= createTable(\\\"Name\\\",\\\"Object Type\\\")\\nvList.sort().forEach(vthislist:\\nA := select ceservice from root.ceservice where exe_award = vthislist and exe_obj_type.id = \'li_criteria\' and exe_nominee = \'Framework\' and exe_main_awards.id = \'exe_internal_ind\'\\nmyTable.addRow(vthislist,name,exe_obj_type).style(bold).indent(0)\\nA.forEach(vthisA:\\nB := select cetask from root.cetask where exe_award = vthislist and exe_obj_type.id = \'li_sub_criteria\' and exe_nominee = \'Framework\' and exe_parent = vthisA and exe_main_awards.id = \'exe_internal_ind\'\\nmyTable.addRow(vthisA,name,exe_obj_type).indent(1).collapse()\\nB.forEach(vthisB:\\nmyTable.addRow(vthisB,name,exe_obj_type).indent(2)\\n)\\n)\\n)\\nmyTable', showToolMenu := false, headerColor := t.21981, fontColor := t.white, rowPerPage := 6, container := t.10578, inlineReadOnly := false)"
				+ "_sco.add(ExtendedTable, id := '468', name := 'PM Medal for Specialized Jobs', expression := 'A := select ceservice from root.ceservice where exe_award.id =\'Ind_spl\' and exe_obj_type.id = \'criteria\' and exe_nominee = \'Framework\'\\nmyTable:= createTable(\\\"Name\\\",\\\"Weightage\\\")\\nA.forEach(vthisA:\\nB := select cetask from root.cetask where exe_award.id =\'Ind_spl\' and exe_obj_type.id = \'sub_criteria\' and exe_nominee = \'Framework\' and exe_parent = vthisA\\nmyTable.addRow(vthisA,name,exe_weight).indent(0)\\nB.forEach(vthisB:\\nmyTable.addRow(vthisB,name,exe_weight).indent(1)\\n)\\n)\\nmyTable.sort(name)', showToolMenu := false, height := 200, headerColor := t.21981, fontColor := t.white, rowPerPage := 6, visibility := 'NOVISIBLE', container := t.22816)"
				+ "_sco.add(ExtendedTable, id := '469', name := 'PM Medal for Government Communications', expression := 'A := select ceservice from root.ceservice where exe_award.id =\'Ind_govn\' and exe_obj_type.id = \'criteria\' and exe_nominee = \'Framework\'\\nmyTable:= createTable(\\\"Name\\\",\\\"Weightage\\\")\\nA.forEach(vthisA:\\nB := select cetask from root.cetask where exe_award.id =\'Ind_govn\' and exe_obj_type.id = \'sub_criteria\' and exe_nominee = \'Framework\' and exe_parent = vthisA\\nmyTable.addRow(vthisA,name,exe_weight).indent(0)\\nB.forEach(vthisB:\\nmyTable.addRow(vthisB,name,exe_weight).indent(1)\\n)\\n)\\nmyTable.sort(name)', showToolMenu := false, height := 200, headerColor := t.21981, fontColor := t.white, rowPerPage := 6, visibility := 'NOVISIBLE', container := t.22815)"
				+ "_sco.add(ExtendedTable, id := '470', name := 'PM Medal for Youth', expression := 'A := select ceservice from root.ceservice where exe_award.id =\'Ind_youth\' and exe_obj_type.id = \'criteria\' and exe_nominee = \'Framework\'\\nmyTable:= createTable(\\\"Name\\\",\\\"Weightage\\\")\\nA.forEach(vthisA:\\nB := select cetask from root.cetask where exe_award.id =\'Ind_youth\' and exe_obj_type.id = \'sub_criteria\' and exe_nominee = \'Framework\' and exe_parent = vthisA\\nmyTable.addRow(vthisA,name,exe_weight).indent(0)\\nB.forEach(vthisB:\\nmyTable.addRow(vthisB,name,exe_weight).indent(1)\\n)\\n)\\nmyTable.sort(name)', showToolMenu := false, height := 200, headerColor := t.21981, fontColor := t.white, rowPerPage := 6, visibility := 'NOVISIBLE', container := t.22816)"
				+ "_sco.add(InputView, id := '471', name := 'Share your interest', inputSet := t.22836, headerColor := t.21981, fontColor := t.white, container := t.22857)"
				+ "_sco.add(ExtendedTable, id := '472', name := 'Enrolled Nominees', expression := 'A := select ceregulation from root.ceregulation where description = \'Nominee\'\\nA.sort(exe_HR_veri).table(name, exe_award, exe_nominee_job, exe_nominee_phone, ref_dept, exe_nominee_manager)', headerColor := t.21981, fontColor := t.white, container := t.22858)"
				+ "_sco.add(ExtendedTable, id := '473', name := 'Selected Nominees', expression := 'A := select ceregulation from root.ceregulation where description = \'Nominee\' and exe_nominee_status != \'Eliminated\' and exe_current_stage = \\\"Selected for Approvals\\\"\\nA.sort(exe_HR_veri).table(name, exe_award, exe_nominee_job, exe_nominee_phone, ref_dept, exe_nominee_manager,exe_HR_veri)', headerColor := t.21981, fontColor := t.white, container := t.10044)"
				+ "_sco.add(ExtendedTable, id := '474', name := 'Eliminated Nominees', expression := 'A := select ceregulation from root.ceregulation where description = \'Nominee\' and exe_nominee_status = \'Eliminated\'\\nA.sort(exe_HR_veri).table(name, exe_award, exe_nominee_job, exe_nominee_phone, ref_dept, exe_nominee_manager,exe_HR_veri)', headerColor := t.21981, fontColor := t.white, container := t.10044)"
				+ "_but := _sco.add(ButtonContainer, id := '475', container := t.10044)"
				+ "_but.add(ActionButton, id := '476', name := 'Begin Approvals', buttonText := 'Begin Approvals', actionObject := t.10165, headerStyle := 'NONE', borderStyle := 'NONE', refreshWhenClicked := true)"
				+ "_sco.add(FilterTable, id := '477', name := 'Begin Approval Process', conditionGroupList := filter(CeRegulation, *everywhere, name = Approval Object - Internal Individual Awards; 378180299454181617 = exe_Ind), headerColor := t.21981, fontColor := t.white, container := t.10045)"
				+ "_sco.add(ExtendedTable, id := '478', name := 'Update deadlines', expression := 'A:= t.22689\\ncreatetable(\\\"Name\\\", \\\"Date\\\")\\n     .addRow(A,\\\"Framework Setup\\\", exe_frame_date)\\n     .addRow(A,\\\"Nominee Registration\\\", exe_shareinterest_date)\\n     .addRow(A,\\\"HR Verification\\\", exe_HR_date)\\n     .addRow(A,\\\"Nomination Form Submission\\\", exe_nomination_date)\\n     .addRow(A,\\\"Head of Department Review\\\", exe_hodreview_date)\\n     .addRow(A,\\\"Assistant Governor Review\\\", exe_agreview_date)\\n     .addRow(A,\\\"Excellence & Evaluation Team Review\\\", exe_teamreview_date)\\n     .addRow(A,\\\"Phase 1 Evaluation\\\", exe_eval1_date)\\n     .addRow(A,\\\"Phase 2 Evaluation\\\", exe_eval2_date)\\n     .addRow(A,\\\"Jury Members Approval\\\", exe_jury_date)\\n     .addRow(A,\\\"Excellence Director Approval\\\", exe_director_date)\\n     .addRow(A,\\\"Cheif of Strategy Approval\\\", exe_cheif_date)\\n     .addRow(A,\\\"Governer Approval\\\", exe_governer_date)', headerColor := t.21981, fontColor := t.white, container := t.10680, inlineReadOnly := false)"
				+ "_sco.add(ExtendedTable, id := '479', name := 'Update Escalation Deadlines', expression := 'A := t.22689\\ncreatetable(\\\"Name\\\", \\\"Date\\\")\\n  .addRow(A,\\\"Head of Department Review Escalation\\\", exe_eschod_date)\\n  .addRow(A,\\\"Assistant Governer Review Escalation \\\", exe_escasg_date)\\n  .addRow(A,\\\"Excellence & Evaluation Team Review Escalation \\\", exe_escexcellence_date)\\n', headerColor := t.21981, fontColor := t.white, container := t.10680, inlineReadOnly := false)"
				+ "_lin := _sco.add(LinkMap, id := '480', name := 'Banner', imageFile := r.180, scaleToFit := true, headerStyle := 'NONE', borderStyle := 'NONE', container := t.22823)"
				+ "_lin.add(LinkEntry, mapEntry, reference := t.22779, showName := true, overrideName := 'Framework ', x := 1018.0, y := 2.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin.add(LinkEntry, mapEntry, reference := t.10042, showName := true, overrideName := 'Approvals', x := 1461.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin.add(LinkEntry, mapEntry, reference := t.1425, showName := true, overrideName := 'Reports', x := 1609.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin.add(LinkEntry, mapEntry, reference := t.22829, showName := true, overrideName := 'Registration', x := 1315.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin.add(LinkEntry, mapEntry, reference := t.10619, showName := true, overrideName := 'Deadlines', x := 1167.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin1 := _sco.add(LinkMap, id := '481', name := 'Banner', imageFile := r.180, scaleToFit := true, headerStyle := 'NONE', borderStyle := 'NONE', container := t.10678)"
				+ "_lin1.add(LinkEntry, mapEntry, reference := t.22779, showName := true, overrideName := 'Framework ', x := 1018.0, y := 2.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin1.add(LinkEntry, mapEntry, reference := t.10042, showName := true, overrideName := 'Approvals', x := 1461.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin1.add(LinkEntry, mapEntry, reference := t.1425, showName := true, overrideName := 'Reports', x := 1609.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin1.add(LinkEntry, mapEntry, reference := t.22829, showName := true, overrideName := 'Registration', x := 1315.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin1.add(LinkEntry, mapEntry, reference := t.10619, showName := true, overrideName := 'Deadlines', x := 1167.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin2 := _sco.add(LinkMap, id := '482', name := 'Banner', imageFile := r.180, scaleToFit := true, headerStyle := 'NONE', borderStyle := 'NONE', container := t.22832)"
				+ "_lin2.add(LinkEntry, mapEntry, reference := t.22779, showName := true, overrideName := 'Framework ', x := 1018.0, y := 2.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin2.add(LinkEntry, mapEntry, reference := t.10042, showName := true, overrideName := 'Approvals', x := 1461.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin2.add(LinkEntry, mapEntry, reference := t.1428, showName := true, overrideName := 'Reports', x := 1609.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin2.add(LinkEntry, mapEntry, reference := t.22829, showName := true, overrideName := 'Registration', x := 1315.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin2.add(LinkEntry, mapEntry, reference := t.10619, showName := true, overrideName := 'Deadlines', x := 1167.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin3 := _sco.add(LinkMap, id := '483', name := 'Banner', imageFile := r.180, scaleToFit := true, headerStyle := 'NONE', borderStyle := 'NONE', container := t.10046)"
				+ "_lin3.add(LinkEntry, mapEntry, reference := t.22779, showName := true, overrideName := 'Framework ', x := 1018.0, y := 2.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin3.add(LinkEntry, mapEntry, reference := t.10042, showName := true, overrideName := 'Approvals', x := 1461.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin3.add(LinkEntry, mapEntry, reference := t.1430, showName := true, overrideName := 'Reports', x := 1609.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin3.add(LinkEntry, mapEntry, reference := t.22829, showName := true, overrideName := 'Registration', x := 1315.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_lin3.add(LinkEntry, mapEntry, reference := t.10619, showName := true, overrideName := 'Deadlines', x := 1167.0, y := 1.0, width := 142.0, height := 41.0, font := 'Dialog-plain-16', textColor := t.white)"
				+ "_sco.add(TextElement, id := '484', name := 'Total Awards', text := '      ', showToolMenu := false, headerColor := t.21981, fontColor := t.white, container := t.1418)"
				+ "_sco.add(TextElement, id := '485', name := 'Total Enrolled', showToolMenu := false, headerColor := t.21981, fontColor := t.white, container := t.1419)"
				+ "_sco.add(TextElement, id := '486', name := 'Total Selected', showToolMenu := false, headerColor := t.21981, fontColor := t.white, container := t.1420)"
				+ "_sco.add(TextElement, id := '487', name := 'Total Eliminated', showToolMenu := false, headerColor := t.21981, fontColor := t.white, container := t.1421)"
				+ "_sco.add(ExtendedTable, id := '488', expression := 'A := select ceregulation from root.ceregulation where description = \'Nominee\' and exe_nominee_status != \'Eliminated\'\\nA.table(name)', enableTableMode := false, enableTreeGraphMode := true, enableCardGridMode := true, defaultDisplayMode := 'TREE_GRAPH', headerStyle := 'NONE', borderStyle := 'NONE', transparency := 100, container := t.1438)"
				+ "_sco.add(InputView, id := '489', name := 'Add Maturity Level', inputSet := t.10383, headerColor := t.21981, fontColor := t.white, container := t.10381)"
				+ "_sco.add(ExtendedTable, id := '490', name := 'Maturity Levels', expression := 'A := select ListPropertySetItem from t.10373\\nA.sort().table(name,value)', headerColor := t.21981, fontColor := t.white, container := t.10381, inlineReadOnly := false)"
				+ "_but1 := _sco.add(ButtonContainer, id := '491', container := t.18259)"
				+ "_but1.add(ActionButton, id := '492', name := 'Notify', buttonText := 'Notify Employees', headerColor := t.21981, fontColor := t.white, refreshWhenClicked := true, displayOnActionMenu := true, container := t.10381)";
		System.out.print(obj);

		Pattern pattern = Pattern.compile("add\\((\\S+), id := '(\\S+)'");

		Matcher matcher = pattern.matcher(obj);

		String result = matcher.replaceAll("add($1, id := 'RTS_$1_$2'");

		System.out.println(result);
	}
}
