package table;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import circuit_element.Circuit_Element;

public class Test_Table {
	//1 konstruktor paraméterrel + 1 getPlayfield + 1 getPanel + 2 ujkor + 1 setTableElement + 1 setTable
	Table t01;
	Circuit_Element[][] test_input;
	Table t02;
	
	public Test_Table() {
		t01 = new Table();
		test_input = new Circuit_Element[20][20];
		t02 = new Table(test_input);
		for(int sor = 20; sor< 20; sor++) {
		for(int oszlop = 20; oszlop< 20; oszlop++) {
			test_input[sor][oszlop] = new Circuit_Element();	
			}
		}
	}
	
	@Before
	public void before() {
		for(int sor = 20; sor< 20; sor++) {
			for(int oszlop = 20; oszlop< 20; oszlop++) {
				t01.playfield[sor][oszlop].setCondition(Circuit_Element.Condition.Empty);
			}
		}
	}
	
	@Test
	public void kon_01_test() {
		assertSame(t02.playfield,test_input); 
	}
	
	@Test
	public void get_playf_01_test() {
		assertSame(t01.playfield,t01.getPlayfield());
	}
	
	@Test
	public void get_panel_01_test() {
		assertSame(t01.panel,t01.getPanel());
	}
	
	@Test
	public void void_ujkor_01_test() {
		for(int sor = 0; sor< 20; sor++) {
			for(int oszlop = 0; oszlop< 20; oszlop++) {
				assertEquals(t01.playfield[sor][oszlop].getCondition(),Circuit_Element.Condition.Empty);
			}
		}
		
		t01.playfield[0][0].setCondition(Circuit_Element.Condition.Electron_head);
		
		assertEquals(t01.playfield[0][0].getCondition(),Circuit_Element.Condition.Electron_head);
		
		t01.ujkor();

		assertEquals(t01.playfield[0][0].getCondition(),Circuit_Element.Condition.Electron_tail);
		
		t01.ujkor();

		assertEquals(t01.playfield[0][0].getCondition(),Circuit_Element.Condition.Connector);
		for(int sor = 1; sor< 20; sor++) {
			for(int oszlop = 1; oszlop< 20; oszlop++) {
				assertEquals(t01.playfield[sor][oszlop].getCondition(),Circuit_Element.Condition.Empty);
			}
		}
	}
	
	@Test
	public void void_ujkor_02_test() {
		
		for(int sor = 0; sor <3; sor++){
			for(int oszlop = 0; oszlop < 3; oszlop++) {	
				t01.playfield[sor][oszlop].setCondition(Circuit_Element.Condition.Connector); 
			}
		}
		t01.playfield[1][1].setCondition(Circuit_Element.Condition.Electron_head); 
		
		assertEquals(t01.playfield[0][0].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[0][1].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[0][2].getCondition(),Circuit_Element.Condition.Connector);
		
		assertEquals(t01.playfield[1][0].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[1][2].getCondition(),Circuit_Element.Condition.Connector);
		
		assertEquals(t01.playfield[2][0].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[2][1].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[2][2].getCondition(),Circuit_Element.Condition.Connector);
		
		t01.ujkor();
		
		assertEquals(t01.playfield[0][0].getCondition(),Circuit_Element.Condition.Electron_head);
		assertEquals(t01.playfield[0][1].getCondition(),Circuit_Element.Condition.Electron_head);
		assertEquals(t01.playfield[0][2].getCondition(),Circuit_Element.Condition.Electron_head);
		
		assertEquals(t01.playfield[1][0].getCondition(),Circuit_Element.Condition.Electron_head);
		assertEquals(t01.playfield[1][2].getCondition(),Circuit_Element.Condition.Electron_head);
		
		assertEquals(t01.playfield[2][0].getCondition(),Circuit_Element.Condition.Electron_head);
		assertEquals(t01.playfield[2][1].getCondition(),Circuit_Element.Condition.Electron_head);
		assertEquals(t01.playfield[2][2].getCondition(),Circuit_Element.Condition.Electron_head);

		assertEquals(t01.playfield[1][1].getCondition(),Circuit_Element.Condition.Electron_tail);
		
		t01.ujkor();
		
		assertEquals(t01.playfield[0][0].getCondition(),Circuit_Element.Condition.Electron_tail);
		assertEquals(t01.playfield[0][1].getCondition(),Circuit_Element.Condition.Electron_tail);
		assertEquals(t01.playfield[0][2].getCondition(),Circuit_Element.Condition.Electron_tail);
		
		assertEquals(t01.playfield[1][0].getCondition(),Circuit_Element.Condition.Electron_tail);
		assertEquals(t01.playfield[1][2].getCondition(),Circuit_Element.Condition.Electron_tail);
		
		assertEquals(t01.playfield[2][0].getCondition(),Circuit_Element.Condition.Electron_tail);
		assertEquals(t01.playfield[2][1].getCondition(),Circuit_Element.Condition.Electron_tail);
		assertEquals(t01.playfield[2][2].getCondition(),Circuit_Element.Condition.Electron_tail);

		assertEquals(t01.playfield[1][1].getCondition(),Circuit_Element.Condition.Connector);
		
		t01.ujkor();
		
		assertEquals(t01.playfield[0][0].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[0][1].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[0][2].getCondition(),Circuit_Element.Condition.Connector);
		
		assertEquals(t01.playfield[1][0].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[1][2].getCondition(),Circuit_Element.Condition.Connector);
		
		assertEquals(t01.playfield[2][0].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[2][1].getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(t01.playfield[2][2].getCondition(),Circuit_Element.Condition.Connector);

		assertEquals(t01.playfield[1][1].getCondition(),Circuit_Element.Condition.Connector);
	}
	
	@Test
	public void set_telement_01_test() {
		t01.setTableElement(Circuit_Element.Condition.Connector,5,5);
		assertSame(t01.playfield[5][5].getCondition(),Circuit_Element.Condition.Connector);
	}
	
	@Test
	public void set_Table_01_test() {
		assertNotSame(t01.playfield,test_input);
		t01.setTable(test_input);
		assertSame(t01.playfield,test_input);
	}	
}
