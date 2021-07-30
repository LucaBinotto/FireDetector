package it.epicode.be;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.epicode.be.factory.CentroDiControlloFactory;
import it.epicode.be.model.CentroDiControllo;
import it.epicode.be.model.CentroDiControlloHttp;
import it.epicode.be.model.CentroDiControlloSMS;
import it.epicode.be.model.InvalidResponseTypeException;
import it.epicode.be.model.Sonda;
@TestMethodOrder(OrderAnnotation.class)
class CentroDiControlloTest {
	private static CentroDiControllo sms;
	private static CentroDiControllo http; 
	private static Sonda s1;
	private static Sonda s2;
	private static Sonda s3;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	@Test
	void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
	    System.out.println("Hello Baeldung Readers!!");
	        
	    assertEquals("Hello Baeldung Readers!!", outputStreamCaptor.toString()
	      .trim());
	}
	
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
	void testSmokeLevelMoreThanAlarmLevelSMS() {
		s1.setSmokeLevel(6);
		assertTrue(sms.getSmokeLevel()> 5);
		assertEquals("#INVIOSMS#\n"
				+ "ALLARME SCATTATO dalla sonda 1\n"
				+ "LATITUDINE 41.902782\n"
				+ "LONGITUDINE 12.597846\n"
				+ "LIVELLO DI FUMO 6", outputStreamCaptor.toString()
			      .trim());
	}
	
	@Test
	void testSmokeLevelMoreThanAlarmLevelHttp() {
		s2.setSmokeLevel(8);
		assertTrue(http.getSmokeLevel()> 5);
		assertEquals("Chiamata rest a http://host/alarm?=idsonda=2&lat=88.696969&lon=12.496366&smokelevel=8", outputStreamCaptor.toString()
			      .trim());
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

	@Test
	@Order(1)
	void testAddCentroControllo(){
		s3 = new Sonda("32424242424234", "312412415153");
		s3.register(http);
		assertTrue(s3.getObservers().contains(http));
	}
	
	@Test
	@Order(2)
	void testRemoveCentroControllo(){
		s3.unregister(http);
		assertTrue(!s3.getObservers().contains(http));
	}
}
