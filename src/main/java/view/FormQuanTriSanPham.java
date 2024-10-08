package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import item.FormLoaiSanPham;
import model.LoaiSanPham;
import model.SanPham;
import util.ConnectServer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormQuanTriSanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField txtMaSP;
	public JTextField txtTenSP;
	public JTextField txtGiaSP;
	private JTable tableSanPham;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;
	public JComboBox<LoaiSanPham> comboBoxLoaiSanPham;
	public JButton btnChucNang;
	public JRadioButton rdbtnXoa;
	public JRadioButton rdbtnCapNhat;
	public JRadioButton rdbtnThem;
	public ButtonGroup buttonGroupFunction;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	public FormQuanTriSanPham() throws RemoteException {
		mouseControllerFormQuanTri = new MouseControllerFormQuanTri(this);
		setSize(1120, 680);
		setLayout(null);

		JLabel lblQuanLySP = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblQuanLySP.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblQuanLySP.setBounds(431, 11, 313, 55);
		add(lblQuanLySP);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 63, 313, 606);
		add(panel);
		panel.setLayout(null);

		JLabel lblMaSP = new JLabel("Mã Sản Phẩm");
		lblMaSP.setBounds(13, 91, 94, 29);
		panel.add(lblMaSP);
		lblMaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		txtMaSP = new JTextField();
		txtMaSP.setEnabled(false);
		txtMaSP.setBounds(117, 91, 186, 29);
		panel.add(txtMaSP);
		txtMaSP.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		txtMaSP.setColumns(10);

		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setBounds(13, 131, 94, 29);
		panel.add(lblTenSP);
		lblTenSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		txtTenSP = new JTextField();
		txtTenSP.setEditable(false);
		txtTenSP.setBounds(117, 131, 186, 29);
		panel.add(txtTenSP);
		txtTenSP.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		txtTenSP.setColumns(10);

		JLabel lblGiaSP = new JLabel("Giá Sản Phẩm");
		lblGiaSP.setBounds(13, 171, 94, 29);
		panel.add(lblGiaSP);
		lblGiaSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		txtGiaSP = new JTextField();
		txtGiaSP.setEditable(false);
		txtGiaSP.setBounds(117, 171, 186, 29);
		panel.add(txtGiaSP);
		txtGiaSP.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		txtGiaSP.setColumns(10);

		JLabel lblLoaiSP = new JLabel("Loại Sản Phẩm");
		lblLoaiSP.setBounds(13, 211, 94, 29);
		panel.add(lblLoaiSP);
		lblLoaiSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblChcNng.setBounds(10, 497, 94, 29);
		panel.add(lblChcNng);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 537, 293, 39);
		panel.add(panel_3);

		rdbtnThem = new JRadioButton("Thêm");
		panel_3.add(rdbtnThem);
		rdbtnThem.setBackground(new Color(255, 255, 255));
		rdbtnThem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		rdbtnThem.addItemListener(e -> {

			if (rdbtnThem.isSelected()) {

				btnChucNang.setText("Thêm");
				btnChucNang.setEnabled(true);

				txtMaSP.setEditable(true);
				txtTenSP.setEditable(true);
				txtGiaSP.setEditable(true);
				comboBoxLoaiSanPham.setEnabled(true);

			}

		});

		rdbtnCapNhat = new JRadioButton("Cập nhật");
		panel_3.add(rdbtnCapNhat);
		rdbtnCapNhat.setBackground(new Color(255, 255, 255));
		rdbtnCapNhat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		rdbtnCapNhat.addItemListener(e -> {

			if (rdbtnCapNhat.isSelected()) {
				btnChucNang.setText("Cập Nhật");
				btnChucNang.setEnabled(true);

				txtMaSP.setEditable(true);
				txtTenSP.setEditable(true);
				txtGiaSP.setEditable(true);
				comboBoxLoaiSanPham.setEnabled(true);
			}

		});

		rdbtnXoa = new JRadioButton("Xóa");
		panel_3.add(rdbtnXoa);
		rdbtnXoa.setBackground(new Color(255, 255, 255));
		rdbtnXoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		rdbtnXoa.addItemListener(e -> {

			if (rdbtnXoa.isSelected()) {
				btnChucNang.setText("Xóa");
				btnChucNang.setEnabled(true);

				txtMaSP.setEditable(false);
				txtTenSP.setEditable(false);
				txtGiaSP.setEditable(false);
				comboBoxLoaiSanPham.setEnabled(false);
			}

		});

		buttonGroupFunction = new ButtonGroup();
		buttonGroupFunction.add(rdbtnXoa);
		buttonGroupFunction.add(rdbtnCapNhat);
		buttonGroupFunction.add(rdbtnThem);

		JLabel lblThngTinSn = new JLabel("Thông Tin Sản Phẩm");
		lblThngTinSn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinSn.setBounds(59, 43, 201, 30);
		panel.add(lblThngTinSn);

		comboBoxLoaiSanPham = new JComboBox();
		comboBoxLoaiSanPham.setEnabled(false);
		comboBoxLoaiSanPham.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		comboBoxLoaiSanPham.setBounds(117, 211, 186, 29);
		panel.add(comboBoxLoaiSanPham);

		btnChucNang = new JButton("................................");
		btnChucNang.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnChucNang.setEnabled(false);
		btnChucNang.setBounds(13, 285, 290, 39);
		panel.add(btnChucNang);

		JButton btnLamMoiForm = new JButton("Làm Mới");
		btnLamMoiForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoiForm();
			}
		});
		btnLamMoiForm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoiForm.setBounds(214, 251, 89, 23);
		panel.add(btnLamMoiForm);

		JButton btnLoaiSanPham = new JButton("Loại sản phẩm");
		btnLoaiSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FormLoaiSanPham formLoaiSanPham = new FormLoaiSanPham();
					formLoaiSanPham.setVisible(true);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnLoaiSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLoaiSanPham.setBounds(165, 11, 138, 29);
		panel.add(btnLoaiSanPham);

		btnChucNang.addMouseListener(mouseControllerFormQuanTri);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(333, 63, 775, 606);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDanhSachSP = new JLabel("Danh sách sản phẩm");
		lblDanhSachSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachSP.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachSP);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Giá", "Loại" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Tất cả các ô không thể chỉnh sửa
				return false;
			}
		};

		tableSanPham = new JTable(model);
		tableSanPham.setRowHeight(25);
		tableSanPham.setForeground(new Color(0, 0, 0));

		ListSelectionModel selectionModel = tableSanPham.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {

					int selectedRow = tableSanPham.getSelectedRow();
					if (selectedRow != -1) {
						String maSanPham = String.valueOf(tableSanPham.getValueAt(selectedRow, 0));
						String tenSanPham = String.valueOf(tableSanPham.getValueAt(selectedRow, 1));
						String giaSanPham = String.valueOf(tableSanPham.getValueAt(selectedRow, 2));
						LoaiSanPham loaiSanPham = (LoaiSanPham) tableSanPham.getValueAt(selectedRow, 3);

						txtMaSP.setText(maSanPham);
						txtTenSP.setText(tenSanPham);
						txtGiaSP.setText(giaSanPham);
						comboBoxLoaiSanPham.setSelectedItem(loaiSanPham);
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tableSanPham);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiem.setBounds(676, 6, 89, 23);
		btnTimKiem.addMouseListener(mouseControllerFormQuanTri);
		panel_2.add(btnTimKiem);

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					layDanhSachSanPham();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLamMoi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoi.setBounds(577, 6, 89, 23);
		panel_2.add(btnLamMoi);
		layDanhSachSanPham();
		layDanhSachLoaiSanPham();
	}

	public void layDanhSachSanPham() throws RemoteException {
		DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
		List<SanPham> listSanPham = ConnectServer.sanPhamInf.layDanhSachSanPham();

		model.setRowCount(0);

		for (SanPham sanPham : listSanPham) {
			model.addRow(new Object[] { sanPham.getIdSanPham(), sanPham.getTenSanPham(),
					dinhDangTienTe(sanPham.getGiaSanPham()), sanPham.getLoaiSanPham() });
		}
	}

	public void layDanhSachLoaiSanPham() throws RemoteException {
		List<LoaiSanPham> loaiSanPhams = ConnectServer.loaiSanPhamInf.layDanhSachLoaiSanPham();
		for (LoaiSanPham loaiSanPham : loaiSanPhams) {
			comboBoxLoaiSanPham.addItem(loaiSanPham);
		}
	}

	public void hienThiThongTinTimKiemSanPham(List<SanPham> dsSanPham) throws RemoteException {
		DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
		model.setRowCount(0);
		for (SanPham sanPham : dsSanPham) {
			model.addRow(new Object[] { sanPham.getIdSanPham(), sanPham.getTenSanPham(),
					dinhDangTienTe(sanPham.getGiaSanPham()), sanPham.getLoaiSanPham() });
		}
	}

	// làm mới form
	public void lamMoiForm() {
		txtMaSP.setText("");
		txtTenSP.setText("");
		txtGiaSP.setText("");
		comboBoxLoaiSanPham.setSelectedIndex(0);

		txtMaSP.setEditable(false);
		txtTenSP.setEditable(false);
		txtGiaSP.setEditable(false);
		comboBoxLoaiSanPham.setEnabled(false);
		btnChucNang.setEnabled(false);
		btnChucNang.setText("................................");
		buttonGroupFunction.clearSelection();
	}

	// kiểm tra ràng buộc nhập liệu
	public List<String> rangBuocFormNhapLieu() {

		String tenSanPham = txtTenSP.getText();
		String giaSanPham = txtGiaSP.getText();

		List<String> thongBaoLoi = new ArrayList<String>();

		if (tenSanPham.equals("") || giaSanPham.equals("")) {
			thongBaoLoi.add("Vui lòng nhập đầy đủ thông tin");
			return thongBaoLoi;
		}

		if (!giaSanPham.matches("[0-9]+")) {
			thongBaoLoi.add("Giá sản phẩm phải là số");
			return thongBaoLoi;
		}

		if (Float.parseFloat(giaSanPham) < 1000) {
			thongBaoLoi.add("Giá sản phẩm >= 1000");
		}

		return thongBaoLoi;
	}

	// hiển thị thông báo lỗi nhập liệu
	public void thongBaoLoiNhapLieu(List<String> thongBao) {
		String thongBaoLoi = thongBao.get(0);
		JOptionPane.showMessageDialog(null, thongBaoLoi, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}

	// Định dạng tiền tệ
	public String dinhDangTienTe(float money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String strCurrencyVN = currencyVN.format(money);
		return strCurrencyVN;
	}
}
