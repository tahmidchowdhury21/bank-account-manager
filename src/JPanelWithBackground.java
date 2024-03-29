import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * Adding helper support class to extend the normal JPanel functionally with background image
 * 
 */
class JPanelWithBackground extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image img;

	public JPanelWithBackground(String img) {
		this(new ImageIcon(img).getImage().getScaledInstance(500, 500,Image.SCALE_FAST));
	}

	public JPanelWithBackground(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

}