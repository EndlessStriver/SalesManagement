package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
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
import model.NhanVien;
import util.ConnectServer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormQuanTriNhanVien extends JPanel{

	private static final long serialVersionUID = 1L;
	public JTextField textFieldMaNhanVien;
	public JTextField textFieldHoVaTen;
	public JTextField textFieldSoDienThoai;
	public JTextField textFieldEmail;
	public JTextField textFieldDiaChi;
	private JTable tableNhanVien;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;
	public JButton btnChucNang;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
	public JRadioButton rdbtnThem;
	public JRadioButton rdbtnCapNhat;
	public JRadioButton rdbtnXoa;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	public FormQuanTriNhanVien() throws RemoteException {
		mouseControllerFormQuanTri = new MouseControllerFormQuanTri(this);
		setSize(1120, 680);
		setLayout(null);

		JLabel lblQuanLyNhn = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQuanLyNhn.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblQuanLyNhn.setBounds(431, 11, 313, 55);
		add(lblQuanLyNhn);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 63, 313, 606);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setBounds(13, 81, 94, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		textFieldMaNhanVien = new JTextField();
		textFieldMaNhanVien.setEnabled(false);
		textFieldMaNhanVien.setEditable(false);
		textFieldMaNhanVien.setBounds(117, 81, 186, 29);
		panel.add(textFieldMaNhanVien);
		textFieldMaNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldMaNhanVien.setColumns(10);

		JLabel lblHoVaTn = new JLabel("Họ và tên");
		lblHoVaTn.setBounds(13, 121, 94, 29);
		panel.add(lblHoVaTn);
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		textFieldHoVaTen = new JTextField();
		textFieldHoVaTen.setBounds(117, 121, 186, 29);
		panel.add(textFieldHoVaTen);
		textFieldHoVaTen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldHoVaTen.setColumns(10);

		JLabel lblSinThoai = new JLabel("Số điện thoại");
		lblSinThoai.setBounds(13, 161, 94, 29);
		panel.add(lblSinThoai);
		lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		textFieldSoDienThoai = new JTextField();
		textFieldSoDienThoai.setBounds(117, 161, 186, 29);
		panel.add(textFieldSoDienThoai);
		textFieldSoDienThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldSoDienThoai.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(117, 201, 186, 29);
		panel.add(textFieldEmail);
		textFieldEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldEmail.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(13, 201, 94, 29);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lbliaChi = new JLabel("Địa chỉ");
		lbliaChi.setBounds(13, 237, 94, 29);
		panel.add(lbliaChi);
		lbliaChi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblGiiTinh = new JLabel("Giới tính");
		lblGiiTinh.setBounds(13, 277, 94, 29);
		panel.add(lblGiiTinh);
		lblGiiTinh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setSelected(true);
		rdbtnNam.setBackground(new Color(255, 255, 255));
		rdbtnNam.setBounds(117, 281, 109, 23);
		panel.add(rdbtnNam);
		rdbtnNam.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(new Color(255, 255, 255));
		rdbtnNu.setBounds(117, 317, 109, 23);
		panel.add(rdbtnNu);
		rdbtnNu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		ButtonGroup btnGroupSex = new ButtonGroup();
		btnGroupSex.add(rdbtnNam);
		btnGroupSex.add(rdbtnNu);

		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setBounds(117, 237, 186, 29);
		panel.add(textFieldDiaChi);
		textFieldDiaChi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldDiaChi.setColumns(10);

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
				
				textFieldMaNhanVien.setText("");
				textFieldHoVaTen.setText("");
				textFieldSoDienThoai.setText("");
				textFieldEmail.setText("");
				textFieldDiaChi.setText("");
				btnChucNang.setText("Thêm");
				btnChucNang.setEnabled(true);
				
				textFieldMaNhanVien.enable();
				textFieldHoVaTen.enable();
				textFieldSoDienThoai.enable();
				textFieldEmail.enable();
				textFieldDiaChi.enable();
				
			}
		});

		rdbtnCapNhat = new JRadioButton("Cập nhật");
		panel_3.add(rdbtnCapNhat);
		rdbtnCapNhat.setBackground(new Color(255, 255, 255));
		rdbtnCapNhat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		rdbtnCapNhat.addItemListener(e -> {
			if (rdbtnCapNhat.isSelected()) {
				
				btnChucNang.setText("Cập nhật");
				textFieldMaNhanVien.enable();
				textFieldHoVaTen.enable();
				textFieldSoDienThoai.enable();
				textFieldEmail.enable();
				textFieldDiaChi.enable();
				btnChucNang.setEnabled(true);
			}
		});

		rdbtnXoa = new JRadioButton("Xóa");
		panel_3.add(rdbtnXoa);
		rdbtnXoa.setBackground(new Color(255, 255, 255));
		rdbtnXoa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		rdbtnXoa.addItemListener(e -> {
			if (rdbtnXoa.isSelected()) {
				
				textFieldMaNhanVien.setText("");
				textFieldHoVaTen.setText("");
				textFieldSoDienThoai.setText("");
				textFieldEmail.setText("");
				textFieldDiaChi.setText("");
				
				btnChucNang.setText("Xóa");
				btnChucNang.setEnabled(true);
				
				textFieldMaNhanVien.disable();
				textFieldHoVaTen.disable();
				textFieldSoDienThoai.disable();
				textFieldEmail.disable();
				textFieldDiaChi.disable();
				
			}
		});

		ButtonGroup buttonGroupFunction = new ButtonGroup();
		buttonGroupFunction.add(rdbtnXoa);
		buttonGroupFunction.add(rdbtnCapNhat);
		buttonGroupFunction.add(rdbtnThem);

		btnChucNang = new JButton("................................");
		btnChucNang.setEnabled(false);
		btnChucNang.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnChucNang.setBounds(13, 355, 290, 39);
		panel.add(btnChucNang);
		btnChucNang.addMouseListener(mouseControllerFormQuanTri);

		JLabel lblThngTinNhn = new JLabel("Thông Tin Nhân Viên");
		lblThngTinNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinNhn.setBounds(56, 29, 201, 30);
		panel.add(lblThngTinNhn);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(333, 63, 775, 606);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblDanhSachNhn = new JLabel("Danh sách nhân viên");
		lblDanhSachNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachNhn.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachNhn);

		tableNhanVien = new JTable();
		tableNhanVien.setRowHeight(25);
		tableNhanVien.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tableNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tableNhanVien.setForeground(new Color(0, 0, 0));
		tableNhanVien.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã nhân viên", "Họ và tên",
				"Số điện thoại", "Email", "Địa chỉ", "Giới tính" }));

		ListSelectionModel selectionModel = tableNhanVien.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableNhanVien.getSelectedRow();
					
					if(selectedRow != -1) {
						
						String maNhanVien = String.valueOf(tableNhanVien.getValueAt(selectedRow, 0));
						String hoVaTen = String.valueOf(tableNhanVien.getValueAt(selectedRow, 1));
						String soDienThoai = String.valueOf(tableNhanVien.getValueAt(selectedRow, 2));
						String email = String.valueOf(tableNhanVien.getValueAt(selectedRow, 3));
						String diaChi = String.valueOf(tableNhanVien.getValueAt(selectedRow, 4));
						String gioiTinh = String.valueOf(tableNhanVien.getValueAt(selectedRow, 5));
						
						textFieldMaNhanVien.setText(maNhanVien);
						textFieldHoVaTen.setText(hoVaTen);
						textFieldSoDienThoai.setText(soDienThoai);
						textFieldEmail.setText(email);
						textFieldDiaChi.setText(diaChi);
						rdbtnNam.setSelected(gioiTinh.equals("Nam"));
						rdbtnNu.setSelected(gioiTinh.equals("Nữ"));
						
					}
					
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tableNhanVien);
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
					layDanhSachNhanVien();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLamMoi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoi.setBounds(577, 6, 89, 23);
		panel_2.add(btnLamMoi);
		layDanhSachNhanVien();
	}

	public void layDanhSachNhanVien() throws RemoteException {

		List<NhanVien> danhSachNhanVien = ConnectServer.nhanVienInf.layDanhSachNhanVien();
		
		DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
		model.setRowCount(0);
		
		for (NhanVien nhanVien : danhSachNhanVien) {
			model.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getTenNhanVien(), nhanVien.getSoDienThoai(),
					nhanVien.getGmail(), nhanVien.getDiaChi(), nhanVien.isGioiTinh() ? "Nam" : "Nữ" });
		}

	}

	public void hienThiDanhSachTimKiemNhanVien(List<NhanVien> danhSachNhanVien) {
		DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
		model.setRowCount(0);
		for (NhanVien nhanVien : danhSachNhanVien) {
			model.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getTenNhanVien(), nhanVien.getSoDienThoai(),
					nhanVien.getGmail(), nhanVien.getDiaChi(), nhanVien.isGioiTinh() ? "Nam" : "Nữ" });
		}
		
	}
	
	public void lamMoiForm() {
		textFieldMaNhanVien.setText("");
		textFieldHoVaTen.setText("");
		textFieldSoDienThoai.setText("");
		textFieldEmail.setText("");
		textFieldDiaChi.setText("");
		rdbtnNam.setSelected(true);
	}
}
