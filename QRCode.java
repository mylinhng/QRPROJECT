/*
 * Quick response code generator and reader
 * 
 * @author IC
 * @version 1.0.0
 */

package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JTextField;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {
	
	String qrCodeData = null;
	String filePath = null;
	String charset = "UTF-8"; // or "ISO-8859-1"
	
	public QRCode(String data, String filename) {
		this.setQrCodeData(data);
		this.setFilePath(filename);
	}

	public String getQrCodeData() {
		return qrCodeData;
	}

	public void setQrCodeData(String qrCodeData) {
		this.qrCodeData = qrCodeData;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void createQRCode(String qrCodeData, String filePath, Map hintMap, int qrCodeheight,
			int qrCodewidth) throws WriterException, IOException {

		Path p1 = Paths.get(filePath);
		// encode the data to the hashmap.
		BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), this.charset),
				BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
		// write out QR code to file image
		MatrixToImageWriter.writeToPath(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), p1);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String readQRCode(String filePath, Map hintMap)
			throws FileNotFoundException, IOException, NotFoundException {
		BinaryBitmap binaryBitmap = new BinaryBitmap(
				new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));
		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
		return qrCodeResult.getText();
	}

}
