package item;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhanVienInf;
import dao.implement.NhanVienImp;
import model.NhanVien;
import util.ConnectServer;
import view.FormQuanTriNhanVien;
import view.FormTraCuuNhanVien;
import view.FormTraCuuThongTin;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormTimKiemNhanVien extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaNhanVien;
	private JTextField textFieldHoVaTen;
	private JTextField textFieldSoDienThoai;
	private JPanel viewShow;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FormTimKiemNhanVien dialog = new FormTimKiemNhanVien();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FormTimKiemNhanVien(JPanel viewShow1) {
		viewShow = viewShow1;
		setModal(true);
		setBounds(100, 100, 329, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Mã nhân viên");
			lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblNewLabel.setBounds(10, 11, 94, 29);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldMaNhanVien = new JTextField();
			textFieldMaNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textFieldMaNhanVien.setColumns(10);
			textFieldMaNhanVien.setBounds(114, 11, 186, 29);
			contentPanel.add(textFieldMaNhanVien);
		}
		{
			textFieldHoVaTen = new JTextField();
			textFieldHoVaTen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textFieldHoVaTen.setColumns(10);
			textFieldHoVaTen.setBounds(114, 51, 186, 29);
			contentPanel.add(textFieldHoVaTen);
		}
		{
			JLabel lblHoVaTn = new JLabel("Họ và tên");
			lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblHoVaTn.setBounds(10, 51, 94, 29);
			contentPanel.add(lblHoVaTn);
		}
		{
			JLabel lblSinThoai = new JLabel("Số điện thoại");
			lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblSinThoai.setBounds(10, 91, 94, 29);
			contentPanel.add(lblSinThoai);
		}
		{
			textFieldSoDienThoai = new JTextField();
			textFieldSoDienThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textFieldSoDienThoai.setColumns(10);
			textFieldSoDienThoai.setBounds(114, 91, 186, 29);
			contentPanel.add(textFieldSoDienThoai);
		}
		{
			JLabel lblGiiTinh = new JLabel("Giới tính");
			lblGiiTinh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblGiiTinh.setBounds(10, 127, 94, 29);
			contentPanel.add(lblGiiTinh);
		}
		{
			rdbtnNam = new JRadioButton("Nam");
			rdbtnNam.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			rdbtnNam.setBackground(Color.WHITE);
			rdbtnNam.setBounds(114, 131, 109, 23);
			contentPanel.add(rdbtnNam);
		}
		{
			rdbtnNu = new JRadioButton("Nữ");
			rdbtnNu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			rdbtnNu.setBackground(Color.WHITE);
			rdbtnNu.setBounds(114, 167, 109, 23);
			contentPanel.add(rdbtnNu);
		}
		{
			JButton btnTimKiem = new JButton("Tìm kiếm");
			btnTimKiem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NhanVienInf nhanVienInf = ConnectServer.nhanVienInf;
					try {
						List<NhanVien> danhSachNhanVien = nhanVienInf.timKiemNhanVien(textFieldMaNhanVien.getText(),
								textFieldHoVaTen.getText(), textFieldSoDienThoai.getText(),
								rdbtnNam.isSelected() ? "Nam" : rdbtnNu.isSelected() ? "Nữ" : "");
						
						if(viewShow instanceof FormTraCuuNhanVien) {
							((FormTraCuuNhanVien) viewShow).hienThiDanhSachNhanVien(danhSachNhanVien);
							dispose();
						}
						
						if(viewShow instanceof FormQuanTriNhanVien) {
							((FormQuanTriNhanVien) viewShow).hienThiDanhSachNhanVien(danhSachNhanVien);
                            dispose();
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			btnTimKiem.setBounds(114, 211, 186, 38);
			contentPanel.add(btnTimKiem);
		}
	}

}
