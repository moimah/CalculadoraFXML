package dad.javafx.calculadora.fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class CalculadoraController implements Initializable {
	
	private Calculadora calculadora = new Calculadora();
	
	private CalculadoraModel model = new CalculadoraModel();
	
	private int estadoSumar = 0; 
	private int estadoRestar = 0; 
	private int estadoMultiplicar = 0; 
	private int estadoDividir = 0; 
		
	@FXML
	private GridPane root;
	@FXML
	private TextField txtOps;
	@FXML
	private Button btn7;
	@FXML
	private Button btn4;
	@FXML
	private Button btn1;
	@FXML
	private Button btn0;
	@FXML
	private Button btn8;
	@FXML
	private Button btn6;	
	@FXML
	private Button btn5;
	@FXML
	private Button btn2;
	@FXML
	private Button btn9;
	@FXML
	private Button clickBtn6;
	@FXML
	private Button btn3;
	@FXML
	private Button btnComa;
	@FXML
	private Button btnCE;
	@FXML
	private Button btnMultiply;
	@FXML
	private Button btnSubstract;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnC;
	@FXML
	private Button btnDivide;
	@FXML
	private Button btnResult;
	
	public CalculadoraController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//Bindings		
		model.pantalla.bindBidirectional(txtOps.textProperty());
		
		//Listeners propios
		
		btn0.setOnAction(e->onClickButtonAction('0'));
		btn1.setOnAction(e->onClickButtonAction('1'));
		btn2.setOnAction(e->onClickButtonAction('2'));
		btn3.setOnAction(e->onClickButtonAction('3'));
		btn4.setOnAction(e->onClickButtonAction('4'));
		btn5.setOnAction(e->onClickButtonAction('5'));
		btn6.setOnAction(e->onClickButtonAction('6'));
		btn7.setOnAction(e->onClickButtonAction('7'));
		btn8.setOnAction(e->onClickButtonAction('8'));
		btn9.setOnAction(e->onClickButtonAction('9'));
		
		btnComa.setOnAction(e->onClickButtonAction(','));
		
		btnAdd.setOnAction(e->onClickButtonAction('+'));
		btnSubstract.setOnAction(e->onClickButtonAction('-'));
		btnMultiply.setOnAction(e->onClickButtonAction('*'));
		btnDivide.setOnAction(e->onClickButtonAction('/'));
		btnResult.setOnAction(e->onClickButtonAction('='));
		
		btnC.setOnAction(e->onClickButtonAction('c'));
		btnCE.setOnAction(e->onClickButtonAction('e'));
		
		
		
		
	}

	
	private void onClickButtonAction(char c) {
		
		if(Character.isDigit(c)) {
			calculadora.insertar(c);
		}else {
			switch (c) {
			case ',':
				calculadora.insertarComa();
				break;
			case '+':
				calculadora.operar(Calculadora.SUMAR);
				break;
				
			case '-':
				calculadora.operar(Calculadora.RESTAR);
				break;
			case '*':
				calculadora.operar(Calculadora.MULTIPLICAR);
				break;
			case '/':
				calculadora.operar(Calculadora.DIVIDIR);
				break;
			case '=':
				calculadora.operar(Calculadora.IGUAL);
				break;
			case 'c':
				calculadora.borrar(); //Se invierten los metodos de borrado
				break;
			case 'e':
				calculadora.borrarTodo();//Se invierten los metodos de borrado
				break;
						
			}
		}
		
		model.setPantalla(calculadora.getPantalla());
	}

	public GridPane getView() {
		
		return root;
		
	}
	
}
