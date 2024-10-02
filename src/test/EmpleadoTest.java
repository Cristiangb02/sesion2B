package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {
	
	private TipoEmpleado tipoE;
	private int ventasMes;
	private float horasExtra;
	private Empleado empleado = new Empleado();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBrutaVendedorMasDe1500() {
		this.tipoE=TipoEmpleado.Vendedor;
		this.ventasMes=1600;
		this.horasExtra=2;
		float expected = 2260;
		float actual = empleado.calculoNominaBruta(tipoE, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVendedorMenosDe1500() {
		tipoE=TipoEmpleado.Vendedor;
		ventasMes=1400;
		horasExtra=2;
		float expected = 2160;
		float actual = empleado.calculoNominaBruta(tipoE, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVendedorMenosDe1000() {
	    this.tipoE = TipoEmpleado.Vendedor;
	    this.ventasMes = 800; // Menos de 1000
	    this.horasExtra = 2;
	    float expected = 2000 + 0 + (2 * 30); // 2000 + 0 + 60
	    float actual = empleado.calculoNominaBruta(tipoE, ventasMes, horasExtra);
	    assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaEncargadoMasDe1500() {
		tipoE=TipoEmpleado.Encargado;
		ventasMes=1600;
		horasExtra=2;
		float expected = 2760;
		float actual = empleado.calculoNominaBruta(tipoE, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaEncargadoMenosDe1500() {
		tipoE=TipoEmpleado.Encargado;
		ventasMes=1400;
		horasExtra=2;
		float expected = 2660;
		float actual = empleado.calculoNominaBruta(tipoE, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaEncargadoMenosDe1000() {
	    this.tipoE = TipoEmpleado.Encargado;
	    this.ventasMes = 800; 
	    this.horasExtra = 2;
	    float expected = 2560; 
	    float actual = empleado.calculoNominaBruta(tipoE, ventasMes, horasExtra);
	    assertEquals(expected, actual);
	}
	
	
	//Para el cálculo de la nómina neta
	
	@Test
	public void testCalculoNominaNetaMasDe2500() {
	    float nominaBruta = 2600; 
	    float expected = 2132;
	    float actual = empleado.calculoNominaNeta(nominaBruta);
	    assertEquals(expected, actual, 0.01); 
	}

	@Test
	public void testCalculoNominaNetaEntre2100Y2500() {
	    float nominaBruta = 2300; 
	    float expected = 1955;
	    float actual = empleado.calculoNominaNeta(nominaBruta);
	    assertEquals(expected, actual, 0.01); 
	}

	@Test
	public void testCalculoNominaNetaMenosDe2100() {
	    float nominaBruta = 2000;
	    float expected = 2000;
	    float actual = empleado.calculoNominaNeta(nominaBruta);
	    assertEquals(expected, actual, 0.01);
	}
	
	void testCalculoNominaNeta() {
		fail("Not yet implemented");
	}

}