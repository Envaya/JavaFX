package ch.fhnw.oop2.module09.nationalratswahlen;

import javafx.collections.ObservableList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.fhnw.oop2.module09.nationalratswahlen.presentationmodels.Resultat;
import ch.fhnw.oop2.module09.nationalratswahlen.presentationmodels.WahlPM;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Dieter Holz
 */
class WahlPMTest {
	private WahlPM sut;

	@BeforeEach
	void setUp() {
		sut = new WahlPM();
	}

	@Test
	void testGetResulate() {
		//given
		ObservableList<Resultat> resulate = sut.getResultate();

		//then
		assertTrue(resulate.size() > 1);
		assertEquals("Aeugst am Albis"    , resulate.get(0).getGemeindeNamen());
		assertEquals("GE-CH de l'étranger", resulate.get(resulate.size() - 1).getGemeindeNamen());
	}

	@Test
	void testSave() {
		//when
		sut.getResultate().get(0).setGemeindeNamen("NNN");
		sut.save();

		WahlPM secondPM = new WahlPM();

		//then
		assertEquals(sut.getResultate().size(), secondPM.getResultate().size());
		assertEquals("NNN", secondPM.getResultate().get(0).getGemeindeNamen());

		for (int i = 0; i < sut.getResultate().size(); i++) {
			assertEquals(sut.getResultate().get(i).getGemeindeNamen(),
                         secondPM.getResultate().get(i).getGemeindeNamen());
		}

		//after
		sut.getResultate().get(0).setGemeindeNamen("Aeugst am Albis");
		sut.save();
	}

}