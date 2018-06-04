package viewIMPL;

import view.IDisplayContent;

public class DisplayContent implements IDisplayContent {
	String display;
	
	@Override
	public String getDisplay() {
		return display;
	}
	
	@Override
	public void setDisplay(String display) {
		this.display = display;
	}
}
