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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormQuanTriNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private MouseControllerFormQuanTri mouseControllerFormQuanTri;
	public JButton btnTimKiem;

	/**
	 * Create the panel.
	 */
	public FormQuanTriNhanVien(MouseControllerFormQuanTri mouseControllerFormQuanTri) {
		this.mouseControllerFormQuanTri = mouseControllerFormQuanTri;
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
		lblNewLabel.setBounds(10, 198, 94, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setBounds(114, 198, 186, 29);
		panel.add(textField);
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);
		
		JLabel lblHoVaTn = new JLabel("Họ và tên");
		lblHoVaTn.setBounds(10, 238, 94, 29);
		panel.add(lblHoVaTn);
		lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 238, 186, 29);
		panel.add(textField_1);
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		
		JLabel lblSinThoai = new JLabel("Số điện thoại");
		lblSinThoai.setBounds(10, 278, 94, 29);
		panel.add(lblSinThoai);
		lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 278, 186, 29);
		panel.add(textField_2);
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 318, 186, 29);
		panel.add(textField_3);
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 318, 94, 29);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JLabel lbliaChi = new JLabel("Địa chỉ");
		lbliaChi.setBounds(10, 354, 94, 29);
		panel.add(lbliaChi);
		lbliaChi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JLabel lblGiiTinh = new JLabel("Giới tính");
		lblGiiTinh.setBounds(10, 394, 94, 29);
		panel.add(lblGiiTinh);
		lblGiiTinh.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(114, 398, 109, 23);
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setBackground(new Color(255, 255, 255));
		rdbtnN.setBounds(114, 434, 109, 23);
		panel.add(rdbtnN);
		rdbtnN.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		textField_4 = new JTextField();
		textField_4.setBounds(114, 354, 186, 29);
		panel.add(textField_4);
		textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_4.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(114, 11, 186, 176);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 186, 176);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblAnhaiDin = new JLabel("Ảnh đại diện");
		lblAnhaiDin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAnhaiDin.setBounds(10, 158, 94, 29);
		panel.add(lblAnhaiDin);
		
		JLabel lblChcNng = new JLabel("Chức năng");
		lblChcNng.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblChcNng.setBounds(10, 497, 94, 29);
		panel.add(lblChcNng);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 537, 293, 39);
		panel.add(panel_3);
		
		JRadioButton rdbtnThm = new JRadioButton("Thêm");
		panel_3.add(rdbtnThm);
		rdbtnThm.setBackground(new Color(255, 255, 255));
		rdbtnThm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Cập nhật");
		panel_3.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Xóa");
		panel_3.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JButton btnXacNhn = new JButton("Xác nhận");
		btnXacNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnXacNhn.setBounds(114, 464, 100, 29);
		panel.add(btnXacNhn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(333, 63, 775, 606);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDanhSachNhn = new JLabel("Danh sách nhân viên");
		lblDanhSachNhn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachNhn.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachNhn);
		
		table = new JTable();
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		table.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Mã nhân viên", "Họ và tên", "Số điện thoại", "Email", "Địa chỉ", "Giới tính", "Ảnh đại diện"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiem.setBounds(676, 6, 89, 23);
		btnTimKiem.addMouseListener(mouseControllerFormQuanTri);
		panel_2.add(btnTimKiem);
		
	}
}
