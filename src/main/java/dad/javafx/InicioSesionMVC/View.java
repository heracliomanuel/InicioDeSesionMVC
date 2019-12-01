package dad.javafx.InicioSesionMVC;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox {

		private Label usuarioLabel,contraseñaLabel;
		private TextField usuarioText;
		private PasswordField contraseñaPass;
		private Button accederButton,cancelarButton;
		
		
		public View() {
			super();
			
			usuarioLabel = new Label("Usuario: ");
			contraseñaLabel = new Label("Contraseña: ");
			
			usuarioText = new TextField();
			usuarioText.setPromptText("Introduce un Usuario");
			usuarioText.setMaxWidth(Double.MAX_VALUE);
			
			contraseñaLabel.setMaxWidth(Double.MAX_VALUE);

			contraseñaPass = new PasswordField();
			contraseñaPass.setPromptText("Contraseña");
			
			accederButton = new Button("Acceder");
			accederButton.setDefaultButton(true);
			accederButton.setMaxWidth(Double.MAX_VALUE);
			
			cancelarButton = new Button("Cancelar");
			cancelarButton.setMaxWidth(Double.MAX_VALUE);
			//cancelarButton.setDefaultButton(true);
			
			HBox hboxUsu = new HBox(usuarioLabel,usuarioText);
			hboxUsu.setAlignment(Pos.BASELINE_LEFT);
			
			HBox hboxContra = new HBox(contraseñaLabel,contraseñaPass);
			hboxContra.setAlignment(Pos.BASELINE_LEFT);

			
			HBox hboxButton = new HBox(accederButton,cancelarButton);
			hboxButton.setAlignment(Pos.BASELINE_CENTER);

			
			this.setSpacing(5);
			this.setAlignment(Pos.CENTER);
			this.getChildren().addAll(hboxUsu,hboxContra,hboxButton);
			
		}


		public TextField getUsuarioText() {
			return usuarioText;
		}


		public PasswordField getContraseñaPass() {
			return contraseñaPass;
		}


		public Button getAccederButton() {
			return accederButton;
		}


		public Button getCancelarButton() {
			return cancelarButton;
		}


		
		
}
