package PostOffice.Forms;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipalLookupService;

import javax.swing.JButton;

import PostOffice.Entity.User;
import PostOffice.Main.PanelNavigator;
import PostOffice.Service.AuthenticationService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends PostOfficePanel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "Login";
	private JTextField usernameInput;
	private JPasswordField passwordInput;

	private AuthenticationService authenticationService = null;

	/**
	 * Create the panel.
	 */
	public Login(PanelNavigator navigator) {
		super(NAME, navigator);
			
		
		authenticationService = new AuthenticationService();

		setToolTipText("Login");

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(105, 56, 57, 14);
		add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(105, 93, 57, 14);
		add(lblPassword);

		usernameInput = new JTextField();
		usernameInput.setBounds(188, 53, 86, 20);
		add(usernameInput);
		usernameInput.setColumns(10);

		passwordInput = new JPasswordField();
		passwordInput.setBounds(188, 93, 86, 20);
		add(passwordInput);

		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(217, 155, 57, 23);
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					System.out.println("username=" + getUsername() + "; password=" + getPassword());
					
					User user = authenticationService.authenticate(getUsername(), getPassword());

					System.out.println("Wellcome " + user.getUsername());
					
					navigator.navigateTo(getName(), Home.NAME, user, null);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(1);
				}

			}
		});
		setLayout(null);
		add(loginBtn);

	}

	private String getUsername() {
		return usernameInput.getText();
	}

	private String getPassword() {
		return passwordInput.getText();
	}

	@Override
	public void init(Object arg) {
		System.out.println("Login.init");

	}

	@Override
	public void reset(Object arg) {
		System.out.println("Login.reset");

	}
}
