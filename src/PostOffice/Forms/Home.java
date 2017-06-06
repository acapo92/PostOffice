package PostOffice.Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import PostOffice.Entity.User;
import PostOffice.Main.PanelNavigator;

public class Home extends PostOfficePanel {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "Home";
	JButton btn = null;

	/**
	 * Create the panel.
	 */
	public Home(PanelNavigator navigator) {
		super(NAME, navigator);
		setToolTipText("Login");
		btn = new JButton("Dugme2");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					navigator.navigateTo(getName(), Login.NAME, null, null);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(1);
				}

			}
		});

		add(btn);

		JButton btnPostEpress = new JButton("PostExpress");
		btnPostEpress.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					navigator.navigateTo(getName(), PostExpress.NAME, null, null);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(1);
				}

			}
		});

		add(btnPostEpress);

	}

	@Override
	public void init(Object arg) {
		if (arg != null) {
			User user = (User) arg;
			System.out.println("Home.init");
		}

	}

	@Override
	public void reset(Object arg) {
		System.out.println("Home.reset");

	}

}
