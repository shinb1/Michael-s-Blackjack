import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Display {

	private String name;
	private Image image;

	public Display(String name) {
		this.name = name;
		this.image = Display.loadImage(name);
	}

	public void draw(Graphics g, Rectangle r) {
		g.drawImage(image, r.x, r.y, r.width, r.height, null);
	}

	private static Image loadImage(String name) {
		String path = null;
		Image image = null;

		try {
			path = "images" + File.separator + name + ".png";
			image = ImageIO.read(new File(path));
		} catch(IOException e) {
			System.out.println("Could not load image at path" + path);
			System.exit(1);
		}

		return image;
	}

	
}