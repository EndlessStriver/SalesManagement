package main;

import javax.swing.JOptionPane;
import util.ConnectServer;
import view.FormLogin;

public class RunProject {
	public static void main(String[] args) {
		try {
			ConnectServer connectServer = new ConnectServer();
			FormLogin formLogin = new FormLogin();
			formLogin.setVisible(true);
			System.out.println("Kết nối thành công !");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể kết nối tới máy chủ !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
}
