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
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MouseControllerFormTraCuuThongTin;

import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormTraCuuSanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTable table;
	private MouseControllerFormTraCuuThongTin mouseControllerFormTraCuuThongTin;
	public JButton btnTimKiemSanPham;

	/**
	 * Create the panel.
	 */
	public FormTraCuuSanPham(MouseControllerFormTraCuuThongTin mouseControllerFormTraCuuThongTin) {
		this.mouseControllerFormTraCuuThongTin = mouseControllerFormTraCuuThongTin;
		setSize(1120, 680);
		setLayout(null);
		
		JLabel lblTraCuSn = new JLabel("TRA CỨU SẢN PHẨM");
		lblTraCuSn.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblTraCuSn.setBounds(412, 11, 313, 55);
		add(lblTraCuSn);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 63, 313, 606);
		add(panel);
		
		JLabel lblMaSanPhm = new JLabel("Mã sản phẩm");
		lblMaSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaSanPhm.setBounds(10, 198, 94, 29);
		panel.add(lblMaSanPhm);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(114, 198, 186, 29);
		panel.add(textField);
		
		JLabel lblTnSanPhm = new JLabel("Tên sản phẩm");
		lblTnSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblTnSanPhm.setBounds(10, 238, 94, 29);
		panel.add(lblTnSanPhm);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(114, 238, 186, 29);
		panel.add(textField_1);
		
		JLabel lblLoaiSanPhm = new JLabel("Loại sản phẩm");
		lblLoaiSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblLoaiSanPhm.setBounds(10, 278, 94, 29);
		panel.add(lblLoaiSanPhm);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(114, 318, 186, 29);
		panel.add(textField_3);
		
		JLabel lblGiaSanPhm = new JLabel("Giá sản phẩm");
		lblGiaSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblGiaSanPhm.setBounds(10, 318, 94, 29);
		panel.add(lblGiaSanPhm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(114, 11, 186, 176);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 186, 176);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblAnhaiDin = new JLabel("Ảnh đại diện");
		lblAnhaiDin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAnhaiDin.setBounds(10, 158, 94, 29);
		panel.add(lblAnhaiDin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		comboBox.setBounds(114, 278, 186, 29);
		panel.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(335, 63, 775, 606);
		add(panel_2);
		
		JLabel lblDanhSachSan = new JLabel("Danh sách sản phẩm");
		lblDanhSachSan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachSan.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachSan);
		
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
				"Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Giá sản phẩm", "Ảnh đại diện"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);
		
		btnTimKiemSanPham = new JButton("Tìm kiếm");
		btnTimKiemSanPham.addMouseListener(mouseControllerFormTraCuuThongTin);
		btnTimKiemSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiemSanPham.setBounds(676, 6, 89, 23);
		panel_2.add(btnTimKiemSanPham);
		
	}
}
