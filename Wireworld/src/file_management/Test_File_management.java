package file_management;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import circuit_element.Circuit_Element;
import table.Table;

class Test_File_management {
	File_management fm = new File_management();
	
	@Test
	void save_and_loading_01_test() throws Exception{
		Circuit_Element[][] ce1 = new Circuit_Element[20][20];
		Circuit_Element[][] ce2 = new Circuit_Element[20][20];
		for(int sor = 0; sor <20;sor++) {
			for(int oszlop = 0; oszlop< 20; oszlop++) {
				ce1[sor][oszlop] = new Circuit_Element(Circuit_Element.Condition.Connector);
			}
		}
		Table t = new Table(ce1);
		fm.saving("test.txt", t);
		ce2 = fm.loading("test.txt");
		for(int sor = 0; sor< 20; sor++) {
			for(int oszlop = 0; oszlop <20;oszlop++) {
				assertEquals(ce1[sor][oszlop].getCondition(),ce2[sor][oszlop].getCondition());
			}
		}
	}
}
