package dad.javafx.calculadora.fxml;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CalculadoraModel {
	
	StringProperty pantalla = new SimpleStringProperty();

	public final StringProperty pantallaProperty() {
		return this.pantalla;
	}
	

	public final String getPantalla() {
		return this.pantallaProperty().get();
	}
	

	public final void setPantalla(final String pantalla) {
		this.pantallaProperty().set(pantalla);
	}
	
	
	

}
