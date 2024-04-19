package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MouseControllerFormTraCuuThongTin;
import item.FormTimKiemNhanVien;
import model.NhanVien;
import util.ConnectServer;

import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormTraCuuNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable tableNhanVien;
	public JButton btnTimKiemNhanVien;
	private MouseControllerFormTraCuuThongTin controllerFormTraCuuThongTin;
	private ConnectServer connectServer;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public FormTraCuuNhanVien(MouseControllerFormTraCuuThongTin controllerFormTraCuuThongTin1,
			ConnectServer connectServer1) throws RemoteException {
		connectServer = connectServer1;
		controllerFormTraCuuThongTin = controllerFormTraCuuThongTin1;
		setSize(1120, 680);
		setLayout(null);

		JLabel lblTraCuSn = new JLabel("TRA CỨU NHÂN VIÊN");
		lblTraCuSn.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblTraCuSn.setBounds(412, 11, 313, 55);
		add(lblTraCuSn);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 63, 313, 606);
		add(panel);

		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 85, 94, 29);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(114, 85, 186, 29);
		panel.add(textField);

		JLabel lblHoVaTn = new JLabel("Họ và tên");
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblHoVaTn.setBounds(10, 125, 94, 29);
		panel.add(lblHoVaTn);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(114, 125, 186, 29);
		panel.add(textField_1);

		JLabel lblSinThoai = new JLabel("Số điện thoại");
		lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblSinThoai.setBounds(10, 165, 94, 29);
		panel.add(lblSinThoai);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(114, 165, 186, 29);
		panel.add(textField_2);

		JLabel lblGiiTinh = new JLabel("Giới tính");
		lblGiiTinh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblGiiTinh.setBounds(10, 201, 94, 29);
		panel.add(lblGiiTinh);

		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setBounds(114, 205, 109, 23);
		panel.add(rdbtnNam);

		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setBounds(114, 241, 109, 23);
		panel.add(rdbtnNu);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNam);
		buttonGroup.add(rdbtnNu);

		JLabel lblThngTinNhn = new JLabel("Thông Tin Nhân Viên");
		lblThngTinNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinNhn.setBounds(58, 44, 201, 30);
		panel.add(lblThngTinNhn);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(333, 63, 775, 606);
		add(panel_2);

		JLabel lblDanhSachNhn = new JLabel("Danh sách nhân viên");
		lblDanhSachNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachNhn.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachNhn);

		tableNhanVien = new JTable();
		tableNhanVien.setRowHeight(25);
		tableNhanVien.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		tableNhanVien.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		tableNhanVien.setForeground(new Color(0, 0, 0));
		tableNhanVien.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã nhân viên", "Họ và tên", "Số điện thoại", "Giới tính" }));

		JScrollPane scrollPane = new JScrollPane(tableNhanVien);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);

		btnTimKiemNhanVien = new JButton("Tìm kiếm");
		btnTimKiemNhanVien.addMouseListener(controllerFormTraCuuThongTin);
		btnTimKiemNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiemNhanVien.setBounds(676, 6, 89, 23);
		panel_2.add(btnTimKiemNhanVien);
		layDanhSachNhanVien();
	}

	public void layDanhSachNhanVien() throws RemoteException {
		List<NhanVien> danhSachNhanVien = connectServer.getNhanVienInf().layDanhSachNhanVien();

		for (NhanVien nhanVien : danhSachNhanVien) {
			DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
			model.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getTenNhanVien(), nhanVien.getSoDienThoai(),
					nhanVien.getGmail(), nhanVien.getDiaChi(), nhanVien.isGioiTinh() ? "Nam" : "Nữ" });
		}
	}
}
