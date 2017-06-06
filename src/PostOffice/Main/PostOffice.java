package PostOffice.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import PostOffice.Forms.Home;
import PostOffice.Forms.Login;
import PostOffice.Forms.PostExpress;
import PostOffice.Forms.PostOfficePanel;

import java.awt.CardLayout;
import java.awt.Dimension;

public class PostOffice {

	private JFrame frame;
	private PanelNavigator navigator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostOffice window = new PostOffice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PostOffice() {

		navigator = new PanelNavigator();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		//frame.setPreferredSize(new Dimension(400, 600));

		Login login = new Login(navigator);
		Home home = new Home(navigator);
		PostExpress postExpress = new PostExpress(navigator);

		addFrame(login);
		addFrame(home);
		addFrame(postExpress);
	}

	private void addFrame(PostOfficePanel panel) {
		frame.getContentPane().add(panel);
		navigator.addFrame(panel);
	}

}
