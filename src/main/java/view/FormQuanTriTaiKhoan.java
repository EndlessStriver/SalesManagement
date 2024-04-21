package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MouseControllerFormQuanTri;
import util.ConnectServer;
import model.Quyen;
import model.TaiKhoan;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class FormQuanTriTaiKhoan extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField textFieldTenTaiKhoan;
	private JTable tableTaiKhoan;
	private JPasswordField passwordField;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;
	private JComboBox<Quyen> comboBoxQuyenHan;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	public FormQuanTriTaiKhoan() throws RemoteException {
		mouseControllerFormQuanTri = new MouseControllerFormQuanTri(this);
		setSize(1120, 680);
		setLayout(null);

		JLabel lblQuanLyNhn = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblQuanLyNhn.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblQuanLyNhn.setBounds(431, 11, 313, 55);
		add(lblQuanLyNhn);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 63, 313, 606);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên tài khoản");
		lblNewLabel.setBounds(13, 87, 94, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		textFieldTenTaiKhoan = new JTextField();
		textFieldTenTaiKhoan.setEditable(false);
		textFieldTenTaiKhoan.setBounds(117, 87, 186, 29);
		panel.add(textFieldTenTaiKhoan);
		textFieldTenTaiKhoan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textFieldTenTaiKhoan.setColumns(10);

		JLabel lblHoVaTn = new JLabel("Mật khẩu");
		lblHoVaTn.setBounds(13, 127, 94, 29);
		panel.add(lblHoVaTn);
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblEmail = new JLabel("Quyền hạn");
		lblEmail.setBounds(13, 163, 94, 29);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblGiiTinh = new JLabel("Trạng Thái");
		lblGiiTinh.setBounds(13, 199, 94, 29);
		panel.add(lblGiiTinh);
		lblGiiTinh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JRadioButton rdbtnKichHoat = new JRadioButton("Kích hoạt");
		rdbtnKichHoat.setBackground(new Color(255, 255, 255));
		rdbtnKichHoat.setBounds(117, 203, 109, 23);
		panel.add(rdbtnKichHoat);
		rdbtnKichHoat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JRadioButton rdbtnTat = new JRadioButton("Tắt");
		rdbtnTat.setBackground(new Color(255, 255, 255));
		rdbtnTat.setBounds(117, 239, 109, 23);
		panel.add(rdbtnTat);
		rdbtnTat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		ButtonGroup buttonGroupStatus = new ButtonGroup();
		buttonGroupStatus.add(rdbtnKichHoat);
		buttonGroupStatus.add(rdbtnTat);

		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblChcNng.setBounds(10, 497, 94, 29);
		panel.add(lblChcNng);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 537, 293, 39);
		panel.add(panel_3);

		JRadioButton rdbtnCapNhat = new JRadioButton("Cập nhật");
		panel_3.add(rdbtnCapNhat);
		rdbtnCapNhat.setBackground(new Color(255, 255, 255));
		rdbtnCapNhat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JRadioButton rdbtnXoa = new JRadioButton("Xóa");
		panel_3.add(rdbtnXoa);
		rdbtnXoa.setBackground(new Color(255, 255, 255));
		rdbtnXoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		ButtonGroup buttonGroupFunction = new ButtonGroup();
		buttonGroupFunction.add(rdbtnXoa);
		buttonGroupFunction.add(rdbtnCapNhat);

		JLabel lblThngTinTai = new JLabel("Thông Tin Tài Khoản");
		lblThngTinTai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinTai.setBounds(57, 25, 201, 30);
		panel.add(lblThngTinTai);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		passwordField.setEditable(false);
		passwordField.setBounds(117, 127, 186, 29);
		panel.add(passwordField);

		comboBoxQuyenHan = new JComboBox();
		comboBoxQuyenHan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		comboBoxQuyenHan.setBounds(117, 167, 186, 29);
		panel.add(comboBoxQuyenHan);

		JButton btnXacNhn = new JButton("Xác nhận");
		btnXacNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXacNhn.setBounds(117, 269, 100, 29);
		panel.add(btnXacNhn);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(333, 63, 775, 606);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDanhSachNhn = new JLabel("Danh sách tài khoản");
		lblDanhSachNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachNhn.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachNhn);

		tableTaiKhoan = new JTable();
		tableTaiKhoan.setRowHeight(25);
		tableTaiKhoan.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tableTaiKhoan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tableTaiKhoan.setForeground(new Color(0, 0, 0));
		tableTaiKhoan.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Tên tài khoản", "Mật khẩu", "Quyền hạn", "Trạng thái" }));

		ListSelectionModel selectionModel = tableTaiKhoan.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableTaiKhoan.getSelectedRow();
					String tenTaiKhoan = String.valueOf(tableTaiKhoan.getValueAt(selectedRow, 0));
					String matKhau = String.valueOf(tableTaiKhoan.getValueAt(selectedRow, 1));
					String quyenHan = String.valueOf(tableTaiKhoan.getValueAt(selectedRow, 2));
					String trangThai = String.valueOf(tableTaiKhoan.getValueAt(selectedRow, 3));

					textFieldTenTaiKhoan.setText(tenTaiKhoan);
					passwordField.setText(matKhau);
					comboBoxQuyenHan.setSelectedItem(quyenHan);
					if (trangThai.equals("Kích hoạt")) {
						rdbtnKichHoat.setSelected(true);
					} else {
						rdbtnTat.setSelected(true);
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tableTaiKhoan);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiem.setBounds(676, 6, 89, 23);
		btnTimKiem.addMouseListener(mouseControllerFormQuanTri);
		panel_2.add(btnTimKiem);
		layDanhSachQuyenHan();
		layDanhSachTaiKhoan();
	}

	private void layDanhSachQuyenHan() throws RemoteException {
		List<Quyen> danhSachQuyenHan = ConnectServer.quyenInf.layDanhSachQuyen();

		for (Quyen quyen : danhSachQuyenHan) {
			comboBoxQuyenHan.addItem(quyen);
		}
	}

	private void layDanhSachTaiKhoan() throws RemoteException {
		List<TaiKhoan> danhSachTaiKhoan = ConnectServer.taiKhoanInf.layDanhSachTaiKhoan();

		for (TaiKhoan taiKhoan : danhSachTaiKhoan) {
			DefaultTableModel model = (DefaultTableModel) tableTaiKhoan.getModel();
			model.addRow(new Object[] { taiKhoan.getTenTaiKhoan(), taiKhoan.getMatKhau(),
					taiKhoan.getQuyen().getTenQuyen(), taiKhoan.isTrangThai() ? "Kích hoạt" : "Tắt" });
		}

	}

}
