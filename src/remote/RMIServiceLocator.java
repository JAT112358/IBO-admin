package remote;

import interfaces.IServerAdministrator;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 * @author Jordan Aranda Tejada
 */
public class RMIServiceLocator {

	private IServerAdministrator	iboService;

	public RMIServiceLocator() {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
	}

	public void setService(String[] args) {
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		try {
			iboService = (IServerAdministrator) java.rmi.Naming.lookup(name);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public IServerAdministrator getService() {
		return iboService;
	}
}