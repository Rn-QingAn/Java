package renwenxiang.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	public static Image getImage(String path) {
		BufferedImage img=null;
		URL url=GameUtil.class.getClassLoader().getResource(path);
		try {
			img=ImageIO.read(url);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return img;
	}
}
