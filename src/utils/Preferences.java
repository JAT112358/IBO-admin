package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * @author Jordan Aranda Tejada
 */
public class Preferences implements Serializable 
{
	private static final long	serialVersionUID	= - 1140374742103678200L;
	
	private static Preferences	preferences;
	private String				lookAndFeelClass;

	private Preferences(final String lookAndFeelClass) {
		this.lookAndFeelClass = lookAndFeelClass;
	}

	private void update() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("config.pref"));
			oos.writeObject(preferences);
			oos.close();
		} catch (final IOException e) {
			e.printStackTrace();
			preferences = new Preferences(UIManager.getSystemLookAndFeelClassName());
		}
	}

	private static void init() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("config.pref"));
			preferences = (Preferences) ois.readObject();
			ois.close();
		} catch (Exception e) {
			if ( ! (e instanceof FileNotFoundException)) {
				e.printStackTrace();
			}
			preferences = new Preferences(UIManager.getSystemLookAndFeelClassName());
			preferences.update();
		}
	}

	public static String getLookAndFeel() {
		if (preferences == null) {
			init();
		}
		return preferences.lookAndFeelClass;
	}

	public static void setLookAndFeelClass(final String lf) {
		if (preferences == null) {
			init();
		}
		if (isLFAvailable(lf)) {
			preferences.lookAndFeelClass = lf;
		}
		preferences.update();
	}

	private static boolean isLFAvailable(final String lf) {
		final LookAndFeelInfo lfs[] = UIManager.getInstalledLookAndFeels();
		for (final LookAndFeelInfo lf2: lfs) {
			if (lf2.getClassName().equals(lf)) {
				return true;
			}
		}
		return false;
	}
}