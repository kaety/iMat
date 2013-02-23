package grp30;

public class ButtonPressed {
	private String ButtonId;
	
	public ButtonPressed(String id){
		setButtonId(id);
	}

	public String getButtonId() {
		return ButtonId;
	}

	private void setButtonId(String buttonId) {
		ButtonId = buttonId;
	}
}
