package astraeus_v1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class createAccountGUI{
	GridPane root = new GridPane();
	static boolean selected;
	static int i=0;
	public createAccountGUI() {
		root.setMinSize(300, 300);
		root.setVgap(5);
		root.setHgap(5);

		Text username = new Text("Username:");
		root.add(username, 1, 2);
		TextField usernameCreate = new TextField();
		usernameCreate.setPrefColumnCount(10);
		root.add(usernameCreate, 2, 2);

		Text password = new Text("Password:");
		root.add(password, 1, 5);
		final TextField passwordCreate = new TextField();
		passwordCreate.setPrefColumnCount(10);

		Text verifyPassword = new Text("Verify Password:");
		root.add(verifyPassword, 1, 8);
		final TextField vpassword = new TextField();
		vpassword.setPrefColumnCount(10);
		
		
		final PasswordField passwords = new PasswordField();
		final PasswordField passwordsV = new PasswordField();
		passwordCreate.setManaged(false);
		passwordCreate.setVisible(false);
		vpassword.setManaged(false);
		vpassword.setVisible(false);
		
		CheckBox showPass = new CheckBox("Show/Hide password");
		passwordCreate.managedProperty().bind(showPass.selectedProperty());
		passwordCreate.visibleProperty().bind(showPass.selectedProperty());
		vpassword.managedProperty().bind(showPass.selectedProperty());
		vpassword.visibleProperty().bind(showPass.selectedProperty());
		
		passwords.managedProperty().bind(showPass.selectedProperty().not());
		passwords.visibleProperty().bind(showPass.selectedProperty().not());
		passwordsV.managedProperty().bind(showPass.selectedProperty().not());
		passwordsV.visibleProperty().bind(showPass.selectedProperty().not());
		passwordCreate.textProperty().bindBidirectional(passwords.textProperty());
		vpassword.textProperty().bindBidirectional(passwordsV.textProperty());
		vpassword.setPrefColumnCount(17);
		root.add(showPass, 2, 10);
		root.add(vpassword, 2, 8);
		root.add(passwordCreate, 2, 5);
		root.add(passwords, 2, 5);
		root.add(passwordsV, 2, 8);

		CheckBox adminBox = new CheckBox("Admin Account");
		root.add(adminBox, 2, 11);

		Button create = new Button();
		create.setMaxWidth(500);
		root.add(create, 2, 13);
		create.setText("Create Account");

		Button back = new Button();
		back.setMaxWidth(500);
		root.add(back, 3, 13);
		back.setText("Go Back");


		create.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				selected = adminBox.isSelected();
				if(usernameCreate.getText().isEmpty() | passwordCreate.getText().isEmpty()) {
					Text nothingL = new Text("Please fill out all fields");
					if(i==0) {
					root.add(nothingL, 2, 16);
					}
					i++;
				}
				if(!passwordCreate.getText().isEmpty() && !vpassword.getText().isEmpty()) {
					String pass = passwordCreate.getText();
					String passV = vpassword.getText();
					if(!pass.equals(passV)) {
						Text nothingP = new Text("The passwords entered don't match");
						root.add(nothingP, 2, 16);
					}

					else {
							UserAccount.username = usernameCreate.getText();
							UserAccount.password = passwordCreate.getText();
							UserAccount.createNewAccount();
							if(UserAccount.created==true) {
								Text created = new Text("Account Created");
								root.add(created, 2, 16);
							}
					}
				}
			}
		});

		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				loginGUI GUI = new loginGUI();
				GUI.start(loginGUI.loginstage);
			}
		});	
	}

	public GridPane getGridPane() {
		return root;
	}
}
