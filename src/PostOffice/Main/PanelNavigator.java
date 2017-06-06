package PostOffice.Main;

import java.util.HashMap;

import PostOffice.Forms.PostOfficePanel;

public class PanelNavigator {

	private HashMap<String, PostOfficePanel> frames;

	public PanelNavigator() {
		frames = new HashMap<String, PostOfficePanel>();
	}

	public void addFrame(PostOfficePanel frame) {
		frames.put(frame.getName(), frame);
	}

	private PostOfficePanel findFrame(String name) throws Exception {
		PostOfficePanel frame = frames.get(name);

		if (frame == null) {
			throw new Exception("Frame '" + name + "' not found");
		}

		return frame;
	}

	public void navigateTo(String from, String to, Object initArgs, Object resetArgs) throws Exception {
		navigateTo(findFrame(from), findFrame(to), initArgs, resetArgs);
	}

	public void navigateTo(PostOfficePanel from, PostOfficePanel to, Object initArgs, Object resetArgs) {

		System.out.println("navigate from='" + from.getName() + "' to='" + to.getName() + "'");

		from.reset(resetArgs);
		from.setVisible(false);

		to.init(initArgs);
		to.setVisible(true);
	}

}
