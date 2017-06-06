package PostOffice.Forms;

import javax.swing.JPanel;

import PostOffice.Main.PanelNavigator;

public abstract class PostOfficePanel extends JPanel implements Initializable {

	private static final long serialVersionUID = 1L;

	protected String name;
	private PanelNavigator navigator;

	public PostOfficePanel(String name, PanelNavigator navigator) {
		this.name = name;
		this.navigator = navigator;
	}

	public String getName() {
		return name;
	}
}
