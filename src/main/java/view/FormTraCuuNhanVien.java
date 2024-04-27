package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private JTextField textFieldMaNhanVien;
	private JTextField textFieldHoVaTen;
	private JTextField textFieldSoDienThoai;
	private JTable tableNhanVien;
	public JButton btnTimKiemNhanVien;
	private MouseControllerFormTraCuuThongTin controllerFormTraCuuThongTin;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	public FormTraCuuNhanVien() throws RemoteException {
		controllerFormTraCuuThongTin = new MouseControllerFormTraCuuThongTin(this);
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

		textFieldMaNhanVien = new JTextField();
		textFieldMaNhanVien.setEditable(false);
		textFieldMaNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textFieldMaNhanVien.setColumns(10);
		textFieldMaNhanVien.setBounds(114, 85, 186, 29);
		panel.add(textFieldMaNhanVien);

		JLabel lblHoVaTn = new JLabel("Họ và tên");
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblHoVaTn.setBounds(10, 125, 94, 29);
		panel.add(lblHoVaTn);

		textFieldHoVaTen = new JTextField();
		textFieldHoVaTen.setEditable(false);
		textFieldHoVaTen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textFieldHoVaTen.setColumns(10);
		textFieldHoVaTen.setBounds(114, 125, 186, 29);
		panel.add(textFieldHoVaTen);

		JLabel lblSinThoai = new JLabel("Số điện thoại");
		lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblSinThoai.setBounds(10, 165, 94, 29);
		panel.add(lblSinThoai);

		textFieldSoDienThoai = new JTextField();
		textFieldSoDienThoai.setEditable(false);
		textFieldSoDienThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		textFieldSoDienThoai.setColumns(10);
		textFieldSoDienThoai.setBounds(114, 165, 186, 29);
		panel.add(textFieldSoDienThoai);

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

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã nhân viên", "Họ và tên", "Số điện thoại", "Giới tính" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Tất cả các ô không thể chỉnh sửa
				return false;
			}
		};

		tableNhanVien = new JTable(model);
		tableNhanVien.setRowHeight(25);
		tableNhanVien.setForeground(new Color(0, 0, 0));

		ListSelectionModel selectionModel = tableNhanVien.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableNhanVien.getSelectedRow();

					if (selectedRow >= 0) {

						String maNhanVien = String.valueOf(tableNhanVien.getValueAt(selectedRow, 0));
						String hoVaTen = String.valueOf(tableNhanVien.getValueAt(selectedRow, 1));
						String soDienThoai = String.valueOf(tableNhanVien.getValueAt(selectedRow, 2));
						String gioiTinh = String.valueOf(tableNhanVien.getValueAt(selectedRow, 3));

						textFieldMaNhanVien.setText(maNhanVien);
						textFieldHoVaTen.setText(hoVaTen);
						textFieldSoDienThoai.setText(soDienThoai);
						rdbtnNam.setSelected(gioiTinh.equals("Nam"));
						rdbtnNu.setSelected(gioiTinh.equals("Nữ"));
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(tableNhanVien);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);

		btnTimKiemNhanVien = new JButton("Tìm kiếm");
		btnTimKiemNhanVien.addMouseListener(controllerFormTraCuuThongTin);
		btnTimKiemNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiemNhanVien.setBounds(676, 6, 89, 23);
		panel_2.add(btnTimKiemNhanVien);

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
					nhanVien.isGioiTinh() ? "Nam" : "Nữ" });
		}
	}

	public void hienThiDanhSachTimKiemNhanVien(List<NhanVien> danhSachNhanVien) {
		for (NhanVien nhanVien : danhSachNhanVien) {
			DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
			model.setRowCount(0);
			model.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getTenNhanVien(), nhanVien.getSoDienThoai(),
					nhanVien.isGioiTinh() ? "Nam" : "Nữ" });
		}

	}
}
