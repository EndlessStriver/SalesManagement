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
import model.SanPham;
import view.FormThanhToan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormThemSanPham extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private List<SanPham> dsSanPham;
	private JPanel myView;

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
	public FormThemSanPham(JPanel myView1, List<SanPham> dsSanPham1) {
		myView = myView1;
		dsSanPham = dsSanPham1;
		setBounds(100, 100, 651, 435);
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
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã sản phẩm", "Tên sản phẩm", "Giá", "Loại"
				}
			));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 36, 615, 313);
			contentPanel.add(scrollPane);
		}

		{
			JButton btnNewButton = new JButton("Thêm sản phẩm");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					// hiển thị form nhập số lượng sản phẩm
					String soSanPham = JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm:", "Số lượng:", JOptionPane.QUESTION_MESSAGE);
					
					// kiểm tra dữ liệu nhập vào
					if (soSanPham == null) {
						setVisible(true);
						return;
					}
					
					
					// kiểm tra dữ liệu nhập vào
					if (soSanPham.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng sản phẩm!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						return;
					}
					
					// kiểm tra dữ liệu nhập vào
					if (!soSanPham.matches("[0-9]+")) {
						JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không hợp lệ!", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						return;
					}
					
					// chuyển dữ liệu nhập vào thành kiểu số nguyên
					int soLuong = Integer.parseInt(soSanPham);
					
					int selectedRow = table.getSelectedRow();
					
					long idSanPham = (long) table.getValueAt(selectedRow, 0);
					String tenSanPham = (String) table.getValueAt(selectedRow, 1);
					float giaSanPham = (float) table.getValueAt(selectedRow, 2);
					LoaiSanPham loaiSanPham = (LoaiSanPham) table.getValueAt(selectedRow, 3);
					
					SanPham sanPham = new SanPham(idSanPham, tenSanPham, giaSanPham);
					sanPham.setLoaiSanPham(loaiSanPham);
					
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(soLuong, sanPham);
					
					// thêm chi tiết hóa đơn vào table thanh toán
					if (myView instanceof FormThanhToan) {
						FormThanhToan formThanhToan = (FormThanhToan) myView;
						formThanhToan.themChiTietHoaDon(chiTietHoaDon);
						formThanhToan.capNhatThanhTien();
					}
				}
			});
			btnNewButton.setBounds(320, 360, 156, 25);
			contentPanel.add(btnNewButton);
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
		
		for (SanPham sp : dsSanPham) {
			model.addRow(new Object[] { sp.getIdSanPham(), sp.getTenSanPham(), sp.getGiaSanPham(), sp.getLoaiSanPham() });
		}
	}

}
