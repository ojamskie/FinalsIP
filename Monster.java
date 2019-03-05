import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;

public class Monster{
	
	public int xPos = 150;
	public int yPos = 300;
	public int hp = 10;
	public int width;
	public int height;

	public BufferedImage image;
	public URL resource = getClass().getResource("slime/idle0.png");

	public Monster(){
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public Monster(int xPass, int yPass){
		xPos = xPass;
		yPos = yPass;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
	}

	public Rectangle monsterCollision(){
		return(new Rectangle(xPos, yPos, width, height));
	}

}