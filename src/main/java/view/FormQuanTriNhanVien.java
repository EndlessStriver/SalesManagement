package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MouseControllerFormQuanTri;
import model.NhanVien;
import model.Quyen;
import util.ConnectServer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormQuanTriNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tableNhanVien;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;
	private ConnectServer connectServer;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public FormQuanTriNhanVien(MouseControllerFormQuanTri mouseControllerFormQuanTri1, ConnectServer connectServer1) throws RemoteException {
		connectServer = connectServer1;
		mouseControllerFormQuanTri = mouseControllerFormQuanTri1;
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

		textField = new JTextField();
		textField.setBounds(117, 81, 186, 29);
		panel.add(textField);
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);

		JLabel lblHoVaTn = new JLabel("Họ và tên");
		lblHoVaTn.setBounds(13, 121, 94, 29);
		panel.add(lblHoVaTn);
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		textField_1 = new JTextField();
		textField_1.setBounds(117, 121, 186, 29);
		panel.add(textField_1);
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);

		JLabel lblSinThoai = new JLabel("Số điện thoại");
		lblSinThoai.setBounds(13, 161, 94, 29);
		panel.add(lblSinThoai);
		lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		textField_2 = new JTextField();
		textField_2.setBounds(117, 161, 186, 29);
		panel.add(textField_2);
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(117, 201, 186, 29);
		panel.add(textField_3);
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_3.setColumns(10);

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

		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(new Color(255, 255, 255));
		rdbtnNam.setBounds(117, 281, 109, 23);
		panel.add(rdbtnNam);
		rdbtnNam.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(new Color(255, 255, 255));
		rdbtnNu.setBounds(117, 317, 109, 23);
		panel.add(rdbtnNu);
		rdbtnNu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		ButtonGroup btnGroupSex = new ButtonGroup();
		btnGroupSex.add(rdbtnNam);
		btnGroupSex.add(rdbtnNu);

		textField_4 = new JTextField();
		textField_4.setBounds(117, 237, 186, 29);
		panel.add(textField_4);
		textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_4.setColumns(10);

		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblChcNng.setBounds(10, 497, 94, 29);
		panel.add(lblChcNng);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 537, 293, 39);
		panel.add(panel_3);

		JRadioButton rdbtnThem = new JRadioButton("Thêm");
		panel_3.add(rdbtnThem);
		rdbtnThem.setBackground(new Color(255, 255, 255));
		rdbtnThem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

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
		buttonGroupFunction.add(rdbtnThem);

		JButton btnXacNhn = new JButton("Xác nhận");
		btnXacNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXacNhn.setBounds(117, 347, 100, 29);
		panel.add(btnXacNhn);

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
		tableNhanVien.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		tableNhanVien.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		tableNhanVien.setForeground(new Color(0, 0, 0));
		tableNhanVien.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã nhân viên", "Họ và tên",
				"Số điện thoại", "Email", "Địa chỉ", "Giới tính" }));
		JScrollPane scrollPane = new JScrollPane(tableNhanVien);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiem.setBounds(676, 6, 89, 23);
		btnTimKiem.addMouseListener(mouseControllerFormQuanTri);
		panel_2.add(btnTimKiem);
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
