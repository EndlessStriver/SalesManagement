package view;

import java.awt.Color;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.MouseControllerFormIndex;
import controller.MouseControllerFormTraCuuThongTin;
import model.NhanVien;
import util.ConnectServer;

public class FormTraCuuThongTin extends JPanel {

	private static final long serialVersionUID = 1L;
	public FormTraCuuNhanVien formTraCuuNhanVien;
	public FormTraCuuSanPham formTraCuuSanPham;
	public FormTraCuuHoaDon formTraCuuHoaDon;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public FormTraCuuThongTin() throws RemoteException {
		formTraCuuNhanVien = new FormTraCuuNhanVien();
		formTraCuuSanPham = new FormTraCuuSanPham();
		formTraCuuHoaDon = new FormTraCuuHoaDon();
		setSize(1133, 753);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(123, 104, 238));
		panel.setBounds(0, 0, 1133, 753);
		add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		tabbedPane.setBounds(0, 0, 1133, 753);
		tabbedPane.addTab("Tra Cứu Nhân Viên", formTraCuuNhanVien);
		tabbedPane.addTab("Tra Cứu Sản Phẩm", formTraCuuSanPham);
		tabbedPane.addTab("Tra Cứu Hóa Đơn", formTraCuuHoaDon);
		panel.add(tabbedPane);
		
	}
}
