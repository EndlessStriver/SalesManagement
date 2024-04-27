package item;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ChiTietHoaDon;
import model.LoaiSanPham;
import model.NhanVien;
import model.SanPham;
import view.FormThanhToan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTimNhanVienHoaDon extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private List<NhanVien> dsNhanVien;
	private JDialog myView;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FormThemSanPham dialog = new FormThemSanPham();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FormTimNhanVienHoaDon(JDialog myView1, List<NhanVien> dsNhanVien1) {
		myView = myView1;
		dsNhanVien = dsNhanVien1;
		setBounds(100, 100, 651, 435);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDanhSchSn = new JLabel("Danh sách sản phẩm:");
			lblDanhSchSn.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
			lblDanhSchSn.setBounds(10, 11, 154, 27);
			contentPanel.add(lblDanhSchSn);
		}
		{
			DefaultTableModel model = new DefaultTableModel(new Object[][] {},
					new String[] { "Mã nhân viên", "Họ và tên", "Số điện thoại", "Giới tính" }) {
				@Override
				public boolean isCellEditable(int row, int column) {
					// Tất cả các ô không thể chỉnh sửa
					return false;
				}
			};

			table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 36, 615, 313);
			contentPanel.add(scrollPane);
		}

		{
			JButton btnXacNhan = new JButton("Xác nhận");
			btnXacNhan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();

					int selectedRow = table.getSelectedRow();
					
					if (selectedRow == -1) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						return;
					}

					long idNhanVien = (long) table.getValueAt(selectedRow, 0);

					// Set mã nhân viên vào form tương ứng
					if (myView instanceof FormTimKiemHoaDon) {
						
						FormTimKiemHoaDon formTimKiemHoaDon = (FormTimKiemHoaDon) myView;
						formTimKiemHoaDon.textFieldMaNhanVien.setText(String.valueOf(idNhanVien));
						formTimKiemHoaDon.setVisible(true);
					}
				}
			});
			btnXacNhan.setBounds(320, 360, 156, 25);
			contentPanel.add(btnXacNhan);
		}
		{
			JButton btnHyB = new JButton("Hủy bỏ");
			btnHyB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnHyB.setBounds(486, 360, 139, 25);
			contentPanel.add(btnHyB);
		}
		{
			loadTable();
		}
	}

	private void loadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (NhanVien nv : dsNhanVien) {
			model.addRow(new Object[] { nv.getIdNhanVien(), nv.getTenNhanVien(), nv.getSoDienThoai(),
					nv.isGioiTinh() ? "Nam" : "Nữ" });
		}
	}

}
