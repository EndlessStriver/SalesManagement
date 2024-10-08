package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
import item.FormQuyenHan;
import util.ConnectServer;
import model.Quyen;
import model.TaiKhoan;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormQuanTriTaiKhoan extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final String RANG_BUOC_MAT_KHAU = "[a-zA-Z0-9]{8,}$";

	public JTextField textFieldTenTaiKhoan;
	private JTable tableTaiKhoan;
	public JPasswordField passwordField;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;
	public JComboBox<Quyen> comboBoxQuyenHan;
	public JButton btnChucNang;
	public JRadioButton rdbtnCapNhat;
	public JTextField textFieldMaTaiKhoan;
	public JRadioButton rdbtnKichHoat;
	public JRadioButton rdbtnTat;

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
		lblNewLabel.setBounds(13, 143, 94, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		textFieldTenTaiKhoan = new JTextField();
		textFieldTenTaiKhoan.setEditable(false);
		textFieldTenTaiKhoan.setBounds(117, 143, 186, 29);
		panel.add(textFieldTenTaiKhoan);
		textFieldTenTaiKhoan.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		textFieldTenTaiKhoan.setColumns(10);

		JLabel lblHoVaTn = new JLabel("Mật khẩu");
		lblHoVaTn.setBounds(13, 183, 94, 29);
		panel.add(lblHoVaTn);
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblEmail = new JLabel("Quyền hạn");
		lblEmail.setBounds(13, 219, 94, 29);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblGiiTinh = new JLabel("Trạng Thái");
		lblGiiTinh.setBounds(13, 255, 94, 29);
		panel.add(lblGiiTinh);
		lblGiiTinh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		rdbtnKichHoat = new JRadioButton("Kích hoạt");
		rdbtnKichHoat.setSelected(true);
		rdbtnKichHoat.setEnabled(false);
		rdbtnKichHoat.setBackground(new Color(255, 255, 255));
		rdbtnKichHoat.setBounds(117, 259, 109, 23);
		panel.add(rdbtnKichHoat);
		rdbtnKichHoat.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));

		rdbtnTat = new JRadioButton("Tắt");
		rdbtnTat.setEnabled(false);
		rdbtnTat.setBackground(new Color(255, 255, 255));
		rdbtnTat.setBounds(117, 295, 109, 23);
		panel.add(rdbtnTat);
		rdbtnTat.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));

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

		rdbtnCapNhat = new JRadioButton("Cập nhật");
		panel_3.add(rdbtnCapNhat);
		rdbtnCapNhat.setBackground(new Color(255, 255, 255));
		rdbtnCapNhat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		rdbtnCapNhat.addItemListener(e -> {

			if (rdbtnCapNhat.isSelected()) {

				btnChucNang.setText("Cập nhật");
				btnChucNang.setEnabled(true);
				passwordField.setEditable(true);
				comboBoxQuyenHan.setEnabled(true);
				rdbtnKichHoat.setEnabled(true);
				rdbtnTat.setEnabled(true);

			}

		});

		JLabel lblThngTinTai = new JLabel("Thông Tin Tài Khoản");
		lblThngTinTai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinTai.setBounds(57, 41, 201, 30);
		panel.add(lblThngTinTai);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		passwordField.setEditable(false);
		passwordField.setBounds(117, 183, 186, 29);
		panel.add(passwordField);

		comboBoxQuyenHan = new JComboBox();
		comboBoxQuyenHan.setEnabled(false);
		comboBoxQuyenHan.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		comboBoxQuyenHan.setBounds(117, 223, 186, 29);
		panel.add(comboBoxQuyenHan);

		btnChucNang = new JButton("................................");
		btnChucNang.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnChucNang.setEnabled(false);
		btnChucNang.setBounds(13, 355, 290, 39);
		panel.add(btnChucNang);

		JLabel lblMTiKhon = new JLabel("Mã tài khoản");
		lblMTiKhon.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMTiKhon.setBounds(13, 103, 94, 29);
		panel.add(lblMTiKhon);

		textFieldMaTaiKhoan = new JTextField();
		textFieldMaTaiKhoan.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		textFieldMaTaiKhoan.setEditable(false);
		textFieldMaTaiKhoan.setColumns(10);
		textFieldMaTaiKhoan.setBounds(117, 103, 186, 29);
		panel.add(textFieldMaTaiKhoan);

		JButton btnLamMoiForm = new JButton("Làm mới");
		btnLamMoiForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoiForm();
			}
		});
		btnLamMoiForm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoiForm.setBounds(214, 321, 89, 23);
		panel.add(btnLamMoiForm);
		
		JButton btnQuynHn = new JButton("Quyền hạn");
		btnQuynHn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormQuyenHan formQuyenHan;
				try {
					formQuyenHan = new FormQuyenHan();
					formQuyenHan.setVisible(true);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnQuynHn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnQuynHn.setBounds(182, 11, 121, 29);
		panel.add(btnQuynHn);

		btnChucNang.addMouseListener(mouseControllerFormQuanTri);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(333, 63, 775, 606);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDanhSachNhn = new JLabel("Danh sách tài khoản");
		lblDanhSachNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachNhn.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachNhn);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã tài khoản", "Tên tài khoản", "Mật khẩu", "Quyền hạn", "Trạng thái" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// All cells are not editable
				return false;
			}
		};

		tableTaiKhoan = new JTable(model);
		tableTaiKhoan.setRowHeight(25);
		tableTaiKhoan.setForeground(new Color(0, 0, 0));

		ListSelectionModel selectionModel = tableTaiKhoan.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableTaiKhoan.getSelectedRow();

					if (selectedRow >= 0) {
						String maTaiKhoan = String.valueOf(tableTaiKhoan.getValueAt(selectedRow, 0));
						String tenTaiKhoan = String.valueOf(tableTaiKhoan.getValueAt(selectedRow, 1));
						String matKhau = String.valueOf(tableTaiKhoan.getValueAt(selectedRow, 2));
						Quyen quyenHan = (Quyen) tableTaiKhoan.getValueAt(selectedRow, 3);
						String trangThai = String.valueOf(tableTaiKhoan.getValueAt(selectedRow, 4));

						textFieldMaTaiKhoan.setText(maTaiKhoan);
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

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					layDanhSachTaiKhoan();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLamMoi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoi.setBounds(577, 6, 89, 23);
		panel_2.add(btnLamMoi);
		layDanhSachQuyenHan();
		layDanhSachTaiKhoan();
	}

	// lấy danh sách quyền hạn
	public void layDanhSachQuyenHan() throws RemoteException {
		List<Quyen> danhSachQuyenHan = ConnectServer.quyenInf.layDanhSachQuyen();

		for (Quyen quyen : danhSachQuyenHan) {
			comboBoxQuyenHan.addItem(quyen);
		}
	}

	// lấy danh sách tài khoản
	public void layDanhSachTaiKhoan() throws RemoteException {
		List<TaiKhoan> danhSachTaiKhoan = ConnectServer.taiKhoanInf.layDanhSachTaiKhoan();
		DefaultTableModel model = (DefaultTableModel) tableTaiKhoan.getModel();
		model.setRowCount(0);
		for (TaiKhoan taiKhoan : danhSachTaiKhoan) {
			model.addRow(new Object[] { taiKhoan.getIdTaiKhoan(), taiKhoan.getTenTaiKhoan(), taiKhoan.getMatKhau(),
					taiKhoan.getQuyen(), taiKhoan.isTrangThai() ? "Kích hoạt" : "Tắt" });
		}

	}

	// hiển thị thông báo
	public void lamMoiForm() {
		textFieldMaTaiKhoan.setText("");
		textFieldTenTaiKhoan.setText("");
		passwordField.setText("");
		comboBoxQuyenHan.setSelectedIndex(0);
		rdbtnKichHoat.setSelected(true);

		btnChucNang.setEnabled(false);
		btnChucNang.setText("................................");

		passwordField.setEditable(false);
		comboBoxQuyenHan.setEnabled(false);
		rdbtnKichHoat.setEnabled(false);
		rdbtnTat.setEnabled(false);
		rdbtnCapNhat.setSelected(false);
	}

	// kiểm tra ràng buộc nhập liệu
	public List<String> kiemTraRangBuocFormNhapLieu() {

		List<String> thongBaoLoi = new ArrayList<String>();

		if (textFieldMaTaiKhoan.getText().isEmpty()) {
			thongBaoLoi.add("Vui lòng chọn tài khoản cần cập nhật");
		}

		if (passwordField.getText().isEmpty()) {
			thongBaoLoi.add("Vui lòng nhập đầy đủ thông tin");
		}

		if (!passwordField.getText().matches(RANG_BUOC_MAT_KHAU)) {
			thongBaoLoi.add("Mật khẩu phải có ít nhất 8 ký tự");
		}

		return thongBaoLoi;
	}

	// hiển thị thông báo lỗi nhập liệu
	public void thongBaoLoiNhapLieu(List<String> thongBao) {
		String thongBaoLoi = thongBao.get(0);
		JOptionPane.showMessageDialog(null, thongBaoLoi, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}
	
	// hien thi danh sach tai khoan tim kiem
	public void hienThiDanhSachTaiKhoanTimKiem(List<TaiKhoan> dsTaiKhoan) {
		DefaultTableModel model = (DefaultTableModel) tableTaiKhoan.getModel();
        model.setRowCount(0);
        for (TaiKhoan taiKhoan : dsTaiKhoan) {
            model.addRow(new Object[] { taiKhoan.getIdTaiKhoan(), taiKhoan.getTenTaiKhoan(), taiKhoan.getMatKhau(),
                    taiKhoan.getQuyen(), taiKhoan.isTrangThai() ? "Kích hoạt" : "Tắt" });
        }
    }
}
