package modelIMPL;


import java.awt.Color;

import model.IDisplayContent;

public class DisplayContent implements IDisplayContent {
	private String display;
	private Color backgroundColor;
	
	@Override
	public String getDisplay() {
		return display;
	}
	
	@Override
	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public void setBackground(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public Color getBackground() {
		return this.backgroundColor;
	}
}
