package item;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ChiTietHoaDon;
import model.HoaDon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormThongTinHoaDon extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableChiTietHoaDon;
	private HoaDon hoaDon;
	private JLabel lblMaHoaDon;
	private JLabel lblNgayLap;
	private JLabel lblTenNhanVien;
	private JLabel lblThanhTien;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FormThongTinHoaDon dialog = new FormThongTinHoaDon();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public FormThongTinHoaDon(HoaDon hoaDon1) {
		hoaDon = hoaDon1;
		setModal(true);
		setBounds(100, 100, 679, 813);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("THÔNG TIN HÓA ĐƠN");
			lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
			lblNewLabel.setBounds(158, 26, 358, 37);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn:");
			lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(20, 92, 122, 22);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Ngày lập:");
			lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(331, 92, 107, 22);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblMaHoaDon = new JLabel("HD001");
			lblMaHoaDon.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
			lblMaHoaDon.setBounds(152, 92, 169, 22);
			contentPanel.add(lblMaHoaDon);
		}
		{
			lblNgayLap = new JLabel("22/1/2024");
			lblNgayLap.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
			lblNgayLap.setBounds(448, 92, 169, 22);
			contentPanel.add(lblNgayLap);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Tên nhân viên:");
			lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(20, 125, 122, 22);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblTenNhanVien = new JLabel("Ngô Thiên Phú");
			lblTenNhanVien.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
			lblTenNhanVien.setBounds(152, 125, 169, 22);
			contentPanel.add(lblTenNhanVien);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Chi tiết hóa đơn:");
			lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(20, 158, 144, 22);
			contentPanel.add(lblNewLabel_1);
		}
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// chỉ có thể sủa cột số lượng
				return false;
			}
		};
		tableChiTietHoaDon = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(tableChiTietHoaDon);
		scrollPane.setBounds(20, 191, 622, 494);
		contentPanel.add(scrollPane);
		{
			JLabel lblThnhTin = new JLabel("THÀNH TIỀN:");
			lblThnhTin.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
			lblThnhTin.setBounds(20, 696, 217, 37);
			contentPanel.add(lblThnhTin);
		}
		{
			lblThanhTien = new JLabel("0000000000 đ");
			lblThanhTien.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
			lblThanhTien.setBounds(247, 696, 395, 37);
			contentPanel.add(lblThanhTien);
		}
		{
			JButton btnNewButton = new JButton("In hóa đơn");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					ReportViewer.showReport(hoaDon);
				}
			});
			btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			btnNewButton.setBounds(463, 142, 179, 38);
			contentPanel.add(btnNewButton);
		}

		capNhatThongTin();
	}
	
	// Cập nhật thông tin hóa đơn
	public void capNhatThongTin() {

		DefaultTableModel model = (DefaultTableModel) tableChiTietHoaDon.getModel();
		model.setRowCount(0);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String maHD = hoaDon.getMaHoaDon() + "";
		String ngayLap = sdf.format(hoaDon.getNgayLap());
		String tenNV = hoaDon.getNhanVien().getTenNhanVien();
		Set<ChiTietHoaDon> dsChiTiet = hoaDon.getDanhSachChiTietHoaDon();
		float thanhTien = hoaDon.getTongTien();;

		lblMaHoaDon.setText(maHD);
		lblNgayLap.setText(ngayLap);
		lblTenNhanVien.setText(tenNV);
		lblThanhTien.setText(dinhDangTienTe(thanhTien));

		for (ChiTietHoaDon ct : dsChiTiet) {
			model.addRow(new Object[] { ct.getSanPham(), ct.getSanPham().getTenSanPham(),
					ct.getSanPham().getLoaiSanPham().getTenLoai(), ct.getSoLuong(), dinhDangTienTe(ct.getSanPham().getGiaSanPham()),
					dinhDangTienTe(ct.getSoLuong() * ct.getSanPham().getGiaSanPham()) });
		}

	}
	
	// Định dạng tiền tệ
	public String dinhDangTienTe(float money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String strCurrencyVN = currencyVN.format(money);
		return strCurrencyVN;
	}
}
