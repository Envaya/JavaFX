package ch.fhnw.oop2.module08.multilanguage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Dieter Holz
 */
class LanguageSwitcherPMTest {

	@Test

	void testInitialization() {
		//when
		LanguageSwitcherPM switcher = new LanguageSwitcherPM();

		//then
		Assertions.assertEquals(LanguageSwitcherPM.MultiLanguageText.WINDOW_TITLE.getGermanLabel(), switcher.getApplicationTitle());
		Assertions.assertEquals(LanguageSwitcherPM.MultiLanguageText.LABEL_TEXT.getGermanLabel(), switcher.getText());
	}

	void testSetLanguage() {
		//given
		LanguageSwitcherPM switcher = new LanguageSwitcherPM();

		//when
		switcher.setLanguage(LanguageSwitcherPM.Lang.DE);

		//then
		Assertions.assertEquals(LanguageSwitcherPM.MultiLanguageText.WINDOW_TITLE.getGermanLabel(), switcher.getApplicationTitle());

		//when
		switcher.setLanguage(LanguageSwitcherPM.Lang.EN);

		//then
		Assertions.assertEquals(LanguageSwitcherPM.MultiLanguageText.WINDOW_TITLE.getEnglishLabel(), switcher.getApplicationTitle());
	}

}