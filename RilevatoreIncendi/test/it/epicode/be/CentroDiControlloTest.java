package it.epicode.be;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.epicode.be.factory.CentroDiControlloFactory;
import it.epicode.be.model.CentroDiControllo;
import it.epicode.be.model.CentroDiControlloHttp;
import it.epicode.be.model.CentroDiControlloSMS;
import it.epicode.be.model.InvalidResponseTypeException;
import it.epicode.be.model.Sonda;

class CentroDiControlloTest {
	private static CentroDiControllo sms;
	private static CentroDiControllo http; 
	private static Sonda s1;
	private static Sonda s2;
	@BeforeAll
	static void setUpBeforeClass() throws InvalidResponseTypeException {
		CentroDiControlloFactory fact = new CentroDiControlloFactory();
		sms = fact.creaCC("sms");
		s1 = new Sonda("41.902782", "12.597846");
		s2 = new Sonda("88.696969", "12.496366");
		
		s1.register(sms);
	
		http = fact.creaCC("http");

		s2.register(http);
	}


	@Test
	void testSmokeLevelLessThanAlarmLevel() {
		s1.setSmokeLevel(0);
		assertTrue(sms.getSmokeLevel()<= 5);
		s2.setSmokeLevel(1);
		assertTrue(http.getSmokeLevel()<= 5);
	}
	@Test
	void testSmokeLevelMoreThanAlarmLevel() {
		s1.setSmokeLevel(6);
		assertTrue(sms.getSmokeLevel()> 5);
		System.out.println();
		s2.setSmokeLevel(8);
		assertTrue(http.getSmokeLevel()> 5);
	}
	@Test
	void testCreateSmsControl() throws InvalidResponseTypeException {
		CentroDiControlloFactory fact = new CentroDiControlloFactory();
		CentroDiControllo x = fact.creaCC("sms");
		assertEquals(CentroDiControlloSMS.class,x.getClass());
	}
	@Test
	void testCreateHttpControl() throws InvalidResponseTypeException {
		CentroDiControlloFactory fact = new CentroDiControlloFactory();
		CentroDiControllo x = fact.creaCC("httP");
		assertEquals(CentroDiControlloHttp.class,x.getClass());
	}
	@Test
	void testFailCreateControl() {
		CentroDiControlloFactory fact = new CentroDiControlloFactory();
		
		assertThrows(InvalidResponseTypeException.class,() -> fact.creaCC("dasd"));
	}

}
