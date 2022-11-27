package circuit_element;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import org.junit.jupiter.api.Test;

class Test_Circuit_element {
	//2 kosntruktor + 1 setCondition + 1 setChange = 4 method
	//Minden teszthez külön Circuit_ELement-t hoztam létre, hogy átláthatóbb legyen.
	
	Circuit_Element c1 = new Circuit_Element();
	Circuit_Element c2 = new Circuit_Element(Circuit_Element.Condition.Connector);	
	Circuit_Element c3 = new Circuit_Element();
	Circuit_Element c4 = new Circuit_Element();
	Circuit_Element c5 = new Circuit_Element();
	Circuit_Element c6 = new Circuit_Element(Circuit_Element.Condition.Connector);
	Circuit_Element c7 = new Circuit_Element(Circuit_Element.Condition.Connector);
	Circuit_Element c8 = new Circuit_Element(Circuit_Element.Condition.Electron_tail);
	Circuit_Element c9 = new Circuit_Element(Circuit_Element.Condition.Electron_head);

	@Test
	void kon_01_test() {
		assertEquals(c1.getCondition(),Circuit_Element.Condition.Empty);
		assertEquals(c1.getBackground(),Color.GRAY);
	}
	@Test
	void kon_02_test() {
		assertEquals(c2.getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(c2.getBackground(),Color.YELLOW);
	}
	//set condition
	@Test
	void set_con_01_test() {
		c3.setCondition(Circuit_Element.Condition.Connector);
		
		assertEquals(c3.getCondition(),Circuit_Element.Condition.Connector);
		assertEquals(c3.getBackground(),Color.YELLOW);
	}
	//set direction
	//Empty + Right
	@Test
	void set_dir_01_test() {
		assertEquals(c4.getCondition(),Circuit_Element.Condition.Empty);
		
		assertNotEquals(c4.getCondition(),Circuit_Element.Condition.Connector);
		assertNotEquals(c4.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c4.getCondition(),Circuit_Element.Condition.Electron_head);
		
		c4.setChange(Circuit_Element.Direction.Right);
		
		assertEquals(c4.getCondition(),Circuit_Element.Condition.Electron_head);
		
		assertNotEquals(c4.getCondition(),Circuit_Element.Condition.Connector);
		assertNotEquals(c4.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c4.getCondition(),Circuit_Element.Condition.Empty);
	}
	//Empty + Left click
	@Test
	void set_dir_02_test() {
		assertEquals(c5.getCondition(),Circuit_Element.Condition.Empty);
		
		assertNotEquals(c5.getCondition(),Circuit_Element.Condition.Connector);
		assertNotEquals(c5.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c5.getCondition(),Circuit_Element.Condition.Electron_head);
		
		c5.setChange(Circuit_Element.Direction.Left);
		
		assertEquals(c5.getCondition(),Circuit_Element.Condition.Connector);
		
		assertNotEquals(c5.getCondition(),Circuit_Element.Condition.Electron_head);
		assertNotEquals(c5.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c5.getCondition(),Circuit_Element.Condition.Empty);
	}
	//Connector + Left click
	@Test
	void set_dir_03_test() {
		assertEquals(c6.getCondition(),Circuit_Element.Condition.Connector);
		
		assertNotEquals(c6.getCondition(),Circuit_Element.Condition.Electron_head);
		assertNotEquals(c6.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c6.getCondition(),Circuit_Element.Condition.Empty);
		
		c6.setChange(Circuit_Element.Direction.Left);
		
		assertEquals(c6.getCondition(),Circuit_Element.Condition.Electron_head);
		
		assertNotEquals(c6.getCondition(),Circuit_Element.Condition.Connector);
		assertNotEquals(c6.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c6.getCondition(),Circuit_Element.Condition.Empty);
	}
	//Electron_head + Right click
	@Test
	void set_dir_04_test() {
		assertEquals(c7.getCondition(),Circuit_Element.Condition.Connector);
		
		assertNotEquals(c7.getCondition(),Circuit_Element.Condition.Electron_head);
		assertNotEquals(c7.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c7.getCondition(),Circuit_Element.Condition.Empty);
		
		c7.setChange(Circuit_Element.Direction.Right);
		
		assertEquals(c7.getCondition(),Circuit_Element.Condition.Empty);
		
		assertNotEquals(c7.getCondition(),Circuit_Element.Condition.Connector);
		assertNotEquals(c7.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c7.getCondition(),Circuit_Element.Condition.Electron_head);
	}
	//Electron_tail + Right
	@Test
	void set_dir_05_test() {
		assertEquals(c8.getCondition(),Circuit_Element.Condition.Electron_tail);
		
		assertNotEquals(c8.getCondition(),Circuit_Element.Condition.Electron_head);
		assertNotEquals(c8.getCondition(),Circuit_Element.Condition.Connector);
		assertNotEquals(c8.getCondition(),Circuit_Element.Condition.Empty);
		
		c8.setChange(Circuit_Element.Direction.Right);
		
		assertEquals(c8.getCondition(),Circuit_Element.Condition.Connector);
		
		assertNotEquals(c8.getCondition(),Circuit_Element.Condition.Empty);
		assertNotEquals(c8.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c8.getCondition(),Circuit_Element.Condition.Electron_head);
	}
	//Electron_head + Right
	@Test
	void set_dir_06_test() {
		assertEquals(c9.getCondition(),Circuit_Element.Condition.Electron_head);
		
		assertNotEquals(c9.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c9.getCondition(),Circuit_Element.Condition.Connector);
		assertNotEquals(c9.getCondition(),Circuit_Element.Condition.Empty);
		
		c9.setChange(Circuit_Element.Direction.Right);
		
		assertEquals(c9.getCondition(),Circuit_Element.Condition.Connector);
		
		assertNotEquals(c9.getCondition(),Circuit_Element.Condition.Empty);
		assertNotEquals(c9.getCondition(),Circuit_Element.Condition.Electron_tail);
		assertNotEquals(c9.getCondition(),Circuit_Element.Condition.Electron_head);
	}
}