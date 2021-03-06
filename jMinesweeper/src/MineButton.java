import java.awt.Color;
import java.awt.Graphics;

public class MineButton extends JButton {
	boolean isClicked;
	boolean holdsMine;
	int x;
	int y;
	
	int minesInVicinity;
		
	public boolean holdsMine() {
		return holdsMine;
	}
	public void setHoldsMine(boolean hm) {
		holdsMine = hm;
	}
	public MineButton() {
		super();
		minesInVicinity = 0;
		setLabel("");
		setBackground(Color.GRAY);
		unclick();
	}
	
	public MineButton(int x, int y) {
		this();
		this.x = x;
		this.y = y;
	}
	
	public void setMinesInVicinity(int mines) {
		minesInVicinity = mines;
	}
	public int getMinesInVicinity() {
		return minesInVicinity;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	public void click() {
		isClicked = true;
		if(holdsMine) {
			System.out.println("You died");
			setBackground(Color.RED);
			setLabel("X");
			minesInVicinity = 9;
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		if(minesInVicinity != 0 && !holdsMine) setLabel(Integer.toString(minesInVicinity));
	}
	public void unclick() {
		isClicked = false;
		setLabel("");
	}
}
