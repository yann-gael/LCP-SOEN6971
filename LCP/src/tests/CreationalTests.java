package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import factory.Factory;
import view.IDisplayable;

class CreationalTests {

	@Test
	void BuilderTest() {
		IDisplayable building = Factory.getInstance().getBuilding(1);
		assertEquals("Building", building.getDisplay());
	}

}
