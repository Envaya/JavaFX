package ch.fhnw.oop2.module08.multilanguage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Dieter Holz
 */
public class LanguageSwitcherPM {

	enum Lang {DE, EN}

	enum MultiLanguageText {
		WINDOW_TITLE(       "App in English", "App auf Deutsch"),
		LABEL_TEXT(         "some Label"    , "eine Beschriftung"),
		GERMAN_BUTTON_TEXT( "German"        , "Deutsch"),
		ENGLISH_BUTTON_TEXT("English"       , "Englisch");

		private final String englishLabel;
		private final String germanLabel;

		MultiLanguageText(String englishLabel, String germanLabel) {
			this.englishLabel = englishLabel;
			this.germanLabel  = germanLabel;
		}

		public String getEnglishLabel() {
			return englishLabel;
		}

		public String getGermanLabel() {
			return germanLabel;
		}

		public String getText(Lang lang) {
			switch (lang) {
				case DE:
					return getGermanLabel();
				case EN:
					return getEnglishLabel();
				default:
					return getEnglishLabel();
			}
		}
	}

	private final StringProperty applicationTitle = new SimpleStringProperty();
	private final StringProperty text = new SimpleStringProperty();
	private final StringProperty germanButtonText = new SimpleStringProperty();
	private final StringProperty englishButtonText = new SimpleStringProperty();

	public void setLanguage(Lang lang){
		setApplicationTitle(MultiLanguageText.WINDOW_TITLE.getText(lang));
		setText(MultiLanguageText.LABEL_TEXT.getText(lang));
		setEnglishButtonText(MultiLanguageText.ENGLISH_BUTTON_TEXT.getText(lang));
		setGermanButtonText(MultiLanguageText.GERMAN_BUTTON_TEXT.getText(lang));
	}

	public String getText() {
		return text.get();
	}

	public StringProperty textProperty() {
		return text;
	}

	public void setText(String text) {
		this.text.set(text);
	}

	public String getGermanButtonText() {
		return germanButtonText.get();
	}

	public StringProperty germanButtonTextProperty() {
		return germanButtonText;
	}

	public void setGermanButtonText(String germanButtonText) {
		this.germanButtonText.set(germanButtonText);
	}

	public String getEnglishButtonText() {
		return englishButtonText.get();
	}

	public StringProperty englishButtonTextProperty() {
		return englishButtonText;
	}

	public void setEnglishButtonText(String englishButtonText) {
		this.englishButtonText.set(englishButtonText);
	}

	public LanguageSwitcherPM() {
		setLanguage(Lang.DE);

	}


	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	private void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

}
