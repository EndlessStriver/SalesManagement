package util;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dao.NhanVienInf;
import dao.QuyenInf;
import dao.TaiKhoanInf;

public class ConnectServer {
	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 1234;
	
	private NhanVienInf nhanVienInf;
	private QuyenInf quyenInf;
	private TaiKhoanInf taiKhoanInf;
	
	public NhanVienInf getNhanVienInf() {
		return nhanVienInf;
	}

	public QuyenInf getQuyenInf() {
		return quyenInf;
	}

	public TaiKhoanInf getTaiKhoanInf() {
		return taiKhoanInf;
	}


	public ConnectServer() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(SERVER_IP, SERVER_PORT);
		
		nhanVienInf = (NhanVienInf) registry.lookup("nhanVienInf");
		quyenInf = (QuyenInf) registry.lookup("quyenInf");
		taiKhoanInf = (TaiKhoanInf) registry.lookup("taiKhoanInf");
	}
	
}
