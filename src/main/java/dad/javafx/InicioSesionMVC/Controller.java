package dad.javafx.InicioSesionMVC;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class Controller {

	private Model model = new Model();
	private View view = new View();

	public Controller() {

		model.usuarioProperty().bindBidirectional(view.getUsuarioText().textProperty());
		model.contraseñaProperty().bindBidirectional(view.getContraseñaPass().textProperty());

		view.getAccederButton().setOnAction(e -> onAccederAction(e));
		view.getCancelarButton().setOnAction(e1 -> onCancelarAction(e1));

	}

	private void onCancelarAction(ActionEvent e) {
		Platform.exit();
	}

	private void onAccederAction(ActionEvent e) {

		String usuario = model.getUsuario();
		String contraseña = model.getContraseña();
		boolean correcto = false;

		String md5 = DigestUtils.md5Hex(contraseña).toUpperCase();
		String linea = "";
		String[] lineaArray;

		FileInputStream file;
		InputStreamReader input;
		BufferedReader reader;
		
		
		
			

		try {
			file = new FileInputStream("users.csv");
			input = new InputStreamReader(file,StandardCharsets.UTF_8);
			reader = new BufferedReader(input); 
			

			
			
			while ((linea = reader.readLine()) != null) {
				lineaArray = linea.split(",");
				if (lineaArray[0].equals(usuario) && lineaArray[1].equals(md5)) {
					correcto = true;
					dentro(usuario);
				}
			}

			if (!correcto) {
				fuera(usuario);
			}

			file.close();
			reader.close();

		} catch (IOException e1) {
			System.out.println("Ocurrió un fallo al abrir users.csv");
		}

	}

	private void fuera(String usuario) {
		Alert paFuera = new Alert(AlertType.ERROR);
		paFuera.setTitle("Inicio sesión MVC");
		paFuera.setHeaderText("Acceso denegado");
		paFuera.setContentText("El usuario o la contraseña estan incorrectas");

		paFuera.showAndWait();
	
		
		Button chao = new Button("Salir");
		chao.setOnAction(e -> onCancelarAction(e));

	}

	private void dentro(String usuario) {
		Alert paDentro = new Alert(AlertType.INFORMATION);
		paDentro.setTitle("Inicio sesión MVC");
		paDentro.setHeaderText("Acceso permitido");
		paDentro.setContentText("Todo correcto");

		paDentro.showAndWait();
		
		Button chao = new Button("Salir");
		chao.setOnAction(e -> onCancelarAction(e));

	}

	public View getRoot() {
		return view;

	}

}
