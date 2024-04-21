package view;

import java.awt.Color;
import java.awt.Font;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.MouseControllerFormQuanTri;
import util.ConnectServer;

public class FormQuanTri extends JPanel {

	private static final long serialVersionUID = 1L;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public FormQuanTriNhanVien formQuanTriNhanVien;
	public FormQuanTriTaiKhoan formQuanTriTaiKhoan;
	public FormQuanTriHoaDon formQuanTriHoaDon;
	public FormQuanTriSanPham formQuanTriSanPham;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public FormQuanTri() throws RemoteException {
		mouseControllerFormQuanTri = new MouseControllerFormQuanTri(this);
		formQuanTriNhanVien = new FormQuanTriNhanVien(mouseControllerFormQuanTri);
		formQuanTriTaiKhoan = new FormQuanTriTaiKhoan(mouseControllerFormQuanTri);
		formQuanTriHoaDon = new FormQuanTriHoaDon(mouseControllerFormQuanTri);
		formQuanTriSanPham = new FormQuanTriSanPham(mouseControllerFormQuanTri);
		setSize(1131, 753);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(123, 104, 238));
		panel.setBounds(0, 0, 1131, 753);
		add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tabbedPane.setBounds(0, 0, 1134, 753);
		panel.add(tabbedPane);
		
		tabbedPane.addTab("Quản lý nhân viên", null, formQuanTriNhanVien, null);
		tabbedPane.addTab("Quản lý tài khoản", null, formQuanTriTaiKhoan, null);
		tabbedPane.addTab("Quản lý hóa đơn", null, formQuanTriHoaDon, null);
		tabbedPane.addTab("Quản lý sản phẩm", null, formQuanTriSanPham, null);
	}
}
